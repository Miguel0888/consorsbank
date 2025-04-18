package consorsbank.model.markeddata;

import org.ta4j.core.Bar;
import org.ta4j.core.BaseBar;

import java.time.LocalDateTime;
import java.util.List;

import java.time.Duration;
import java.util.stream.Collectors;

class MarketTick {
    LocalDateTime timestamp;
    double price;
    double bid;
    double ask;
    double volume;

    /**
     * Convert Data to fixed intervals for TA4J Chart Analysis
     * @param ticks
     * @param interval
     * @return
     */
    public List<Bar> aggregateToBaseBars(List<MarketTick> ticks, Duration interval) {
        long intervalMillis = interval.toMillis();

        return ticks.stream()
                .collect(Collectors.groupingBy(tick -> {
                    long timestampMillis = tick.timestamp.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
                    long bucket = timestampMillis / intervalMillis;
                    return bucket;
                }))
                .entrySet().stream()
                .map(entry -> {
                    List<MarketTick> group = entry.getValue();

                    double open = group.get(0).price;
                    double close = group.get(group.size() - 1).price;
                    double high = group.stream().mapToDouble(tick -> tick.price).max().orElse(0);
                    double low = group.stream().mapToDouble(tick -> tick.price).min().orElse(0);
                    double volume = group.stream().mapToDouble(tick -> tick.volume).sum();

                    long bucketStartMillis = entry.getKey() * intervalMillis;
                    LocalDateTime bucketStart = LocalDateTime.ofInstant(
                            java.time.Instant.ofEpochMilli(bucketStartMillis),
                            java.time.ZoneId.systemDefault()
                    );

                    return new BaseBar(
                            interval,
                            bucketStart.atZone(java.time.ZoneId.systemDefault()),
                            open, high, low, close, volume
                    );
                })
                .sorted((a, b) -> a.getEndTime().compareTo(b.getEndTime()))
                .collect(Collectors.toList());

    }

}

