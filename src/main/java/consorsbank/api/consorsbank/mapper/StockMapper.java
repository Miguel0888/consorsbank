package consorsbank.api.consorsbank.mapper;

import com.consorsbank.module.tapi.grpc.common.Date;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.model.Stock;
import consorsbank.model.Wkn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class StockMapper {

    /**
     * Map a `SecurityMarketDataReply` from the gRPC API to a domain `Stock` object.
     *
     * @param reply gRPC API reply containing market data
     * @return mapped domain `Stock`
     */
    public Stock mapToDomain(SecurityMarketDataReply reply) {
        Wkn wkn = new Wkn(reply.getSecurityWithStockexchange().getSecurityCode().getCode());
        String stockExchange = reply.getSecurityWithStockexchange().getStockExchange().getId();

        Stock stock = new Stock(wkn, stockExchange);

        // Numeric fields
        stock.setLastPrice(reply.getLastPrice());
        stock.setHighPrice(reply.getHighPrice());
        stock.setLowPrice(reply.getLowPrice());
        stock.setOpenPrice(reply.getOpenPrice());
        stock.setAskPrice(reply.getAskPrice());
        stock.setBidPrice(reply.getBidPrice());
        stock.setTodayNumTrades(reply.getTodayNumTrades());
        stock.setTodayVolume(reply.getTodayVolume());
        stock.setRelativeDifference(reply.getRelativeDiff());
        stock.setAbsoluteDifference(reply.getAbsDiff());

        stock.setWeekHighPrice(reply.getWeekHighPrice());
        stock.setWeekLowPrice(reply.getWeekLowPrice());
        stock.setMonthHighPrice(reply.getMonthHighPrice());
        stock.setMonthLowPrice(reply.getMonthLowPrice());
        stock.setYearHighPrice(reply.getYearHighPrice());
        stock.setYearLowPrice(reply.getYearLowPrice());

        // Timestamp fields (seconds since epoch)
        if (reply.hasLastDateTime()) {
            stock.setLastDateTime(toLocalDateTime(reply.getLastDateTime().getSeconds()));
        }
        if (reply.hasAskTime()) {
            stock.setAskTime(toLocalDateTime(reply.getAskTime().getSeconds()));
        }
        if (reply.hasBidTime()) {
            stock.setBidTime(toLocalDateTime(reply.getBidTime().getSeconds()));
        }

        // Date fields (guard against invalid default values like month==0)
        if (reply.hasPreviousDate()) {
            LocalDate value = toLocalDateOrNull(reply.getPreviousDate());
            if (value != null) {
                stock.setPreviousDate(value);
            }
        }
        if (reply.hasDateWeekHigh()) {
            LocalDate value = toLocalDateOrNull(reply.getDateWeekHigh());
            if (value != null) {
                stock.setDateWeekHigh(value);
            }
        }
        if (reply.hasDateWeekLow()) {
            LocalDate value = toLocalDateOrNull(reply.getDateWeekLow());
            if (value != null) {
                stock.setDateWeekLow(value);
            }
        }
        if (reply.hasDateMonthHigh()) {
            LocalDate value = toLocalDateOrNull(reply.getDateMonthHigh());
            if (value != null) {
                stock.setDateMonthHigh(value);
            }
        }
        if (reply.hasDateMonthLow()) {
            LocalDate value = toLocalDateOrNull(reply.getDateMonthLow());
            if (value != null) {
                stock.setDateMonthLow(value);
            }
        }
        if (reply.hasDateYearHigh()) {
            LocalDate value = toLocalDateOrNull(reply.getDateYearHigh());
            if (value != null) {
                stock.setDateYearHigh(value);
            }
        }
        if (reply.hasDateYearLow()) {
            LocalDate value = toLocalDateOrNull(reply.getDateYearLow());
            if (value != null) {
                stock.setDateYearLow(value);
            }
        }

        stock.setAddendum(reply.getLastAddendum());
        stock.setTradingPhase(reply.getTradingPhase().name());

        return stock;
    }

    /**
     * Convert protobuf Timestamp seconds since epoch to LocalDateTime.
     *
     * @param seconds seconds since epoch
     * @return local date time
     */
    private LocalDateTime toLocalDateTime(long seconds) {
        return LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.UTC);
    }

    /**
     * Convert protobuf Date to LocalDate.
     * Return null if the date is not fully initialized (e.g. month==0).
     *
     * @param date protobuf date
     * @return local date or null
     */
    private LocalDate toLocalDateOrNull(Date date) {
        if (date == null) {
            return null;
        }

        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();

        if (year <= 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return null;
        }

        try {
            return LocalDate.of(year, month, day);
        } catch (RuntimeException ignored) {
            return null;
        }
    }
}
