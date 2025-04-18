package consorsbank.model;

import io.fair_acc.dataset.spi.financial.api.attrs.AttributeModel;
import io.fair_acc.dataset.spi.financial.api.ohlcv.IOhlcvItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Stock implements IOhlcvItem {

    private final AttributeModel addon = new SimpleAttributeModel();


    private final Wkn wkn;
    private final String stockExchange;

    private double lastPrice;
    private double highPrice;
    private double lowPrice;
    private double openPrice;
    private double askPrice;
    private double bidPrice;
    private int todayNumTrades;
    private double todayVolume;
    private double relativeDifference;
    private double absoluteDifference;

    private double weekHighPrice;
    private double weekLowPrice;
    private LocalDate dateWeekHigh;
    private LocalDate dateWeekLow;

    private double monthHighPrice;
    private double monthLowPrice;
    private LocalDate dateMonthHigh;
    private LocalDate dateMonthLow;

    private double yearHighPrice;
    private double yearLowPrice;
    private LocalDate dateYearHigh;
    private LocalDate dateYearLow;

    private LocalDate previousDate;
    private LocalDateTime lastDateTime;
    private LocalDateTime askTime;
    private LocalDateTime bidTime;

    private String addendum;
    private String tradingPhase;

    public Stock(Wkn wkn, String stockExchange) {
        this.wkn = wkn;
        this.stockExchange = stockExchange;
    }

    public Stock(Date timestamp, double open, double high, double low, double close, double volume) {
        this.wkn = new Wkn("DUMMY"); // oder null, wenn du keine brauchst
        this.stockExchange = "OTC";
        this.lastDateTime = timestamp.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        this.openPrice = open;
        this.highPrice = high;
        this.lowPrice = low;
        this.lastPrice = close;
        this.todayVolume = volume;
    }


    // Getter und Setter

    public Wkn getWkn() {
        return wkn;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getTodayNumTrades() {
        return todayNumTrades;
    }

    public void setTodayNumTrades(int todayNumTrades) {
        this.todayNumTrades = todayNumTrades;
    }

    public double getTodayVolume() {
        return todayVolume;
    }

    public void setTodayVolume(double todayVolume) {
        this.todayVolume = todayVolume;
    }

    public double getRelativeDifference() {
        return relativeDifference;
    }

    public void setRelativeDifference(double relativeDifference) {
        this.relativeDifference = relativeDifference;
    }

    public double getAbsoluteDifference() {
        return absoluteDifference;
    }

    public void setAbsoluteDifference(double absoluteDifference) {
        this.absoluteDifference = absoluteDifference;
    }

    public double getWeekHighPrice() {
        return weekHighPrice;
    }

    public void setWeekHighPrice(double weekHighPrice) {
        this.weekHighPrice = weekHighPrice;
    }

    public double getWeekLowPrice() {
        return weekLowPrice;
    }

    public void setWeekLowPrice(double weekLowPrice) {
        this.weekLowPrice = weekLowPrice;
    }

    public LocalDate getDateWeekHigh() {
        return dateWeekHigh;
    }

    public void setDateWeekHigh(LocalDate dateWeekHigh) {
        this.dateWeekHigh = dateWeekHigh;
    }

    public LocalDate getDateWeekLow() {
        return dateWeekLow;
    }

    public void setDateWeekLow(LocalDate dateWeekLow) {
        this.dateWeekLow = dateWeekLow;
    }

    public double getMonthHighPrice() {
        return monthHighPrice;
    }

    public void setMonthHighPrice(double monthHighPrice) {
        this.monthHighPrice = monthHighPrice;
    }

    public double getMonthLowPrice() {
        return monthLowPrice;
    }

    public void setMonthLowPrice(double monthLowPrice) {
        this.monthLowPrice = monthLowPrice;
    }

    public LocalDate getDateMonthHigh() {
        return dateMonthHigh;
    }

    public void setDateMonthHigh(LocalDate dateMonthHigh) {
        this.dateMonthHigh = dateMonthHigh;
    }

    public LocalDate getDateMonthLow() {
        return dateMonthLow;
    }

    public void setDateMonthLow(LocalDate dateMonthLow) {
        this.dateMonthLow = dateMonthLow;
    }

    public double getYearHighPrice() {
        return yearHighPrice;
    }

    public void setYearHighPrice(double yearHighPrice) {
        this.yearHighPrice = yearHighPrice;
    }

    public double getYearLowPrice() {
        return yearLowPrice;
    }

    public void setYearLowPrice(double yearLowPrice) {
        this.yearLowPrice = yearLowPrice;
    }

    public LocalDate getDateYearHigh() {
        return dateYearHigh;
    }

    public void setDateYearHigh(LocalDate dateYearHigh) {
        this.dateYearHigh = dateYearHigh;
    }

    public LocalDate getDateYearLow() {
        return dateYearLow;
    }

    public void setDateYearLow(LocalDate dateYearLow) {
        this.dateYearLow = dateYearLow;
    }

    public LocalDate getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(LocalDate previousDate) {
        this.previousDate = previousDate;
    }

    public LocalDateTime getLastDateTime() {
        return lastDateTime;
    }

    public void setLastDateTime(LocalDateTime lastDateTime) {
        this.lastDateTime = lastDateTime;
    }

    public LocalDateTime getAskTime() {
        return askTime;
    }

    public void setAskTime(LocalDateTime askTime) {
        this.askTime = askTime;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public String getAddendum() {
        return addendum;
    }

    public void setAddendum(String addendum) {
        this.addendum = addendum;
    }

    public String getTradingPhase() {
        return tradingPhase;
    }

    public void setTradingPhase(String tradingPhase) {
        this.tradingPhase = tradingPhase;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Stock{" +
                "WKN='" + wkn.getValue() + '\'' +
                ", Stock Exchange='" + stockExchange + '\'' +
                ", Last Price=" + lastPrice +
                ", High Price=" + highPrice +
                ", Low Price=" + lowPrice +
                ", Open Price=" + openPrice +
                ", Ask Price=" + askPrice +
                ", Bid Price=" + bidPrice +
                ", Today Num Trades=" + todayNumTrades +
                ", Previous Date=" + (previousDate != null ? previousDate.toString() : "N/A") +
                '}';
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Date getTimeStamp() {
        return Date.from(lastDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public double getOpen() {
        return openPrice;
    }

    @Override
    public double getHigh() {
        return highPrice;
    }

    @Override
    public double getLow() {
        return lowPrice;
    }

    @Override
    public double getClose() {
        return lastPrice; // "lastPrice" als Schlusskurs interpretieren
    }

    @Override
    public double getVolume() {
        return todayVolume;
    }

    @Override
    public double getOpenInterest() {
        return 0.0; // optional nicht verwendet
    }


    @Override
    public AttributeModel getAddon() {
        return addon;
    }

    @Override
    public AttributeModel getAddonOrCreate() {
        return addon;
    }

}
