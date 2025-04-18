package consorsbank.api.consorsbank.mapper;

import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import consorsbank.model.Stock;
import consorsbank.model.Wkn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.consorsbank.module.tapi.grpc.common.Date;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    /**
     * Maps a `SecurityMarketDataReply` from the gRPC API to a domain `Stock` object.
     *
     * @param reply The gRPC API reply containing market data.
     * @return A domain `Stock` object populated with the mapped data.
     */
    public Stock mapToDomain(SecurityMarketDataReply reply) {
        // WKN and stock exchange
        Wkn wkn = new Wkn(reply.getSecurityWithStockexchange().getSecurityCode().getCode());
        String stockExchange = reply.getSecurityWithStockexchange().getStockExchange().getId();

        // Initialize domain model
        Stock stock = new Stock(wkn, stockExchange);

        // Map numeric fields
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

        // Map timestamp fields to LocalDateTime
        if (reply.hasLastDateTime()) {
            stock.setLastDateTime(toLocalDateTime(reply.getLastDateTime().getSeconds()));
        }
        if (reply.hasAskTime()) {
            stock.setAskTime(toLocalDateTime(reply.getAskTime().getSeconds()));
        }
        if (reply.hasBidTime()) {
            stock.setBidTime(toLocalDateTime(reply.getBidTime().getSeconds()));
        }

        // Map date fields to LocalDate
        if (reply.hasPreviousDate()) {
            stock.setPreviousDate(toLocalDate(reply.getPreviousDate()));
        }
        if (reply.hasDateWeekHigh()) {
            stock.setDateWeekHigh(toLocalDate(reply.getDateWeekHigh()));
        }
        if (reply.hasDateWeekLow()) {
            stock.setDateWeekLow(toLocalDate(reply.getDateWeekLow()));
        }
        if (reply.hasDateMonthHigh()) {
            stock.setDateMonthHigh(toLocalDate(reply.getDateMonthHigh()));
        }
        if (reply.hasDateMonthLow()) {
            stock.setDateMonthLow(toLocalDate(reply.getDateMonthLow()));
        }
        if (reply.hasDateYearHigh()) {
            stock.setDateYearHigh(toLocalDate(reply.getDateYearHigh()));
        }
        if (reply.hasDateYearLow()) {
            stock.setDateYearLow(toLocalDate(reply.getDateYearLow()));
        }

        // Optional additional fields
        stock.setAddendum(reply.getLastAddendum());
        stock.setTradingPhase(reply.getTradingPhase().name());

        return stock;
    }

    /**
     * Converts a Protobuf Timestamp (seconds since epoch) to LocalDateTime.
     *
     * @param seconds The seconds since the epoch (from Protobuf Timestamp).
     * @return A LocalDateTime object.
     */
    private LocalDateTime toLocalDateTime(long seconds) {
        return LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.UTC);
    }

    /**
     * Converts a Protobuf Date to LocalDate.
     *
     * @param date The Protobuf Date object.
     * @return A LocalDate object.
     */
    private LocalDate toLocalDate(Date date) {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
    }
}
