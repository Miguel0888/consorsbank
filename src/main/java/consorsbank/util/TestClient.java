/*
 * Copyright 2018 - 2020, Trading-API, Consorsbank.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package consorsbank.util;

import java.io.Closeable;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import com.consorsbank.module.tapi.grpc.AccessServiceGrpc;
import com.consorsbank.module.tapi.grpc.AccountServiceGrpc;
import com.consorsbank.module.tapi.grpc.DepotServiceGrpc;
import com.consorsbank.module.tapi.grpc.OrderServiceGrpc;
import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc;
import com.consorsbank.module.tapi.grpc.StockExchangeServiceGrpc;
import com.consorsbank.module.tapi.grpc.access.LoginReply;
import com.consorsbank.module.tapi.grpc.access.LoginRequest;
import com.consorsbank.module.tapi.grpc.access.LogoutRequest;
import com.consorsbank.module.tapi.grpc.account.TradingAccount;
import com.consorsbank.module.tapi.grpc.account.TradingAccountRequest;
import com.consorsbank.module.tapi.grpc.account.TradingAccounts;
import com.consorsbank.module.tapi.grpc.common.AccessTokenRequest;
import com.consorsbank.module.tapi.grpc.common.Empty;
import com.consorsbank.module.tapi.grpc.common.Error;
import com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest;
import com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest;
import com.consorsbank.module.tapi.grpc.order.AddOrderRequest;
import com.consorsbank.module.tapi.grpc.order.AddOrderRequest.Builder;
import com.consorsbank.module.tapi.grpc.order.CancelOrderRequest;
import com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest;
import com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest;
import com.consorsbank.module.tapi.grpc.order.Order;
import com.consorsbank.module.tapi.grpc.order.OrderCosts;
import com.consorsbank.module.tapi.grpc.order.OrderCosts.CategoryCost;
import com.consorsbank.module.tapi.grpc.order.OrderReply;
import com.consorsbank.module.tapi.grpc.order.QuoteEntry;
import com.consorsbank.module.tapi.grpc.order.QuoteReply;
import com.consorsbank.module.tapi.grpc.order.QuoteRequest;
import com.consorsbank.module.tapi.grpc.order.Validation;
import com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityInfoReply;
import com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply;
import com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.security.TimeResolution;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription;
import com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions;
import com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest;
import com.consorsbank.module.tapi.grpc.trading.CashQuotation;
import com.consorsbank.module.tapi.grpc.trading.OrderModel;
import com.consorsbank.module.tapi.grpc.trading.OrderType;
import consorsbank.observers.CurrencyRateDataObserver;
import consorsbank.observers.DepotObserver;
import consorsbank.observers.MarketDataDataObserver;
import consorsbank.observers.OrderBookDataObserver;
import consorsbank.observers.OrdersObserver;
import consorsbank.observers.TradingAccountInformationObserver;
import consorsbank.observers.TradingAccountTransactionsObserver;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

public class TestClient implements Closeable {
  // tag::EMPTY[]
  private static final Empty EMPTY = Empty.getDefaultInstance();
  // end::EMPTY[]
  // tag::Stubs[]
  private final ManagedChannel channel;
  // tag::AccessServiceStub[]
  private final AccessServiceGrpc.AccessServiceBlockingStub accessServiceBlockingStub;
  // end::AccessServiceStub[]
  // tag::SecurityServiceBlockingStub[]
  private final SecurityServiceGrpc.SecurityServiceBlockingStub securityServiceBlockingStub;
  // end::SecurityServiceBlockingStub[]
  // tag::SecurityServiceStub[]
  private final SecurityServiceGrpc.SecurityServiceStub securityServiceStub;
  // end::SecurityServiceStub[]
  // tag::StockExchangeServiceBlockingStub[]
  private final StockExchangeServiceGrpc.StockExchangeServiceBlockingStub stockExchangeServiceBlockingStub;
  // end::StockExchangeServiceBlockingStub[]
  // tag::AccountServiceBlockingStub[]
  private final AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;
  // end::AccountServiceBlockingStub[]
  private final AccountServiceGrpc.AccountServiceStub accountServiceStub;
  // tag::OrderServiceStub[]
  private final OrderServiceGrpc.OrderServiceStub orderServiceStub;
  // end::OrderServiceStub[]
  // tag::OrderServiceBlockingStub[]
  private final OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;
  // end::OrderServiceBlockingStub[]
  // tag::DepotServiceStub[]
  private final DepotServiceGrpc.DepotServiceStub depotServiceStub;
  // end::DepotServiceStub[]
  // end::Stubs[]

  private final HashMap<TradingAccount,TradingAccountInformationObserver> accountObservers = new HashMap<>();
  private final HashMap<TradingAccount,TradingAccountTransactionsObserver> accountTransactionsObservers = new HashMap<>();
  private final HashMap<TradingAccount,DepotObserver> depotObservers = new HashMap<>();
  private final HashMap<TradingAccount,OrdersObserver> ordersObservers = new HashMap<>();
  private final HashMap<String, CurrencyRateDataObserver> currencyObservers = new HashMap<>();
  private final HashMap<String, MarketDataDataObserver> marketDataObservers = new HashMap<>();
  private final HashMap<String, OrderBookDataObserver> orderBookObservers = new HashMap<>();

  // tag::initClass[]
  private String accessToken = "";

  // end::initClass[]
  // tag::TestClient[]
  public TestClient(String host, int port, File caFile, String secret) throws SSLException {
    this(NettyChannelBuilder.forAddress(host, port)
        .negotiationType(NegotiationType.TLS)
        .sslContext(GrpcSslContexts.forClient().trustManager(caFile).build())
        .build());
    accessToken = login(secret);
    if (accessToken.isEmpty()) {
      // Error
    }
  }
  // end::TestClient[]

  // Without TLS, Example only
  private TestClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // For the example disable TLS to avoid needing certificates.
        .usePlaintext()
        .build());
  }

  // tag::Stubs[]
  /**
   * Construct client for accessing ActiveTrader using the existing channel.
   */
  TestClient(ManagedChannel channel) { // <1>
    this.channel = channel;
    securityServiceBlockingStub = SecurityServiceGrpc.newBlockingStub(channel); // <2>
    securityServiceStub = SecurityServiceGrpc.newStub(channel); // <3>
    stockExchangeServiceBlockingStub = StockExchangeServiceGrpc.newBlockingStub(channel);
    accountServiceBlockingStub = AccountServiceGrpc.newBlockingStub(channel);
    accountServiceStub = AccountServiceGrpc.newStub(channel);
    orderServiceStub = OrderServiceGrpc.newStub(channel);
    orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(channel);
    depotServiceStub = DepotServiceGrpc.newStub(channel);
    accessServiceBlockingStub = AccessServiceGrpc.newBlockingStub(channel);
  }
  // end::Stubs[]

  /**
   * Shutdowns communication channel
   * @throws InterruptedException
   */
  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }


  // tag::login[]
  private String login(String secret) {
    LoginRequest loginRequest = LoginRequest.newBuilder()
        .setSecret(secret)
        .build();
    LoginReply loginReply = accessServiceBlockingStub.login(loginRequest);
    if (loginReply.getError()!=Error.getDefaultInstance()) {
      System.err.println(loginReply.getError());
      return "";
    } else {
      return loginReply.getAccessToken();
    }
  }
  // end::login[]


  // tag::logout[]
  private void logout() {
    if (accessToken!=null && !accessToken.isEmpty()) {
      LogoutRequest request = LogoutRequest.newBuilder()
          .setAccessToken(accessToken)
          .build();
      accessServiceBlockingStub.logout(request);
    }
  }
  // end::logout[]

  // tag::requestSecurityInfo[]
  private SecurityInfoReply requestSecurityInfo(String code, SecurityCodeType securityCodeType) {
    SecurityCode securityCode = TestUtils.getSecurityCode(code, securityCodeType); // <1>
    SecurityInfoRequest request = SecurityInfoRequest.newBuilder() // <2>
        .setAccessToken(accessToken)
        .setSecurityCode(securityCode) // <3>
        .build(); // <4>
    SecurityInfoReply response = securityServiceBlockingStub.getSecurityInfo(request); // <5>
    return response;
  }
  // end::requestSecurityInfo[]

  // tag::getStockExchanges[]
  private StockExchangeDescriptions getStockExchanges() {
    AccessTokenRequest request = AccessTokenRequest.newBuilder()
        .setAccessToken(accessToken)
        .build();
    return stockExchangeServiceBlockingStub.getStockExchanges(request);
  }
  // end::getStockExchanges[]

  // tag::getBaadaStockExchangeInformation[]
  private StockExchangeDescription getBaadaStockExchangeInformation() {
    StockExchange stockExchange = StockExchange.newBuilder()
        .setId("OTC")
        .setIssuer("BAAD")
        .build(); // <1>

    StockExchangeRequest request = StockExchangeRequest.newBuilder()
        .setAccessToken(accessToken)
        .setStockExchange(stockExchange)
        .build(); // <2>
    return stockExchangeServiceBlockingStub.getStockExchange(request); // <3>
  }
  // end::getBaadaStockExchangeInformation[]

  // tag::streamMarketData[]
  private MarketDataDataObserver streamMarketData(String code,
      SecurityCodeType securityCodeType, String stockExchangeId, String currency) {

    SecurityWithStockExchange securityWithStockExchange = // <1>
        TestUtils.getSecurityWithStockExchange(code, securityCodeType, stockExchangeId, null);

    SecurityMarketDataRequest request =  SecurityMarketDataRequest.newBuilder()
        .setAccessToken(accessToken)
        .setSecurityWithStockexchange(securityWithStockExchange) // <2>
        .setCurrency(currency!=null ? currency : "")
        .build();

    MarketDataDataObserver marketDataDataObserver = // <3>
        new MarketDataDataObserver(request, securityServiceStub);

    String key = code+"|"+securityCodeType+"|"+stockExchangeId+"|"+currency;
    marketDataObservers.put(key, marketDataDataObserver);
    return marketDataDataObserver;
  }
  // end::streamMarketData[]

  // tag::streamOrderBook[]
  private OrderBookDataObserver streamOrderBook(String code,
      SecurityCodeType securityCodeType, String stockExchangeId, String currency) {

    SecurityWithStockExchange securityWithStockExchange =  // <1>
        TestUtils.getSecurityWithStockExchange(code, securityCodeType, stockExchangeId, null);

    SecurityOrderBookRequest request = SecurityOrderBookRequest.newBuilder()
        .setAccessToken(accessToken)
        .setSecurityWithStockexchange(securityWithStockExchange)
        .setCurrency(currency==null ? "" : currency)
        .build(); // <2>

    OrderBookDataObserver orderBookDataObserver =  // <3>
        new OrderBookDataObserver(request, securityServiceStub);

    String key = code+"|"+securityCodeType+"|"+stockExchangeId+"|"+currency;
    orderBookObservers.put(key, orderBookDataObserver);
    return orderBookDataObserver;
  }
  // end::streamOrderBook[]

  // tag::streamCurrencyRate[]
  private CurrencyRateDataObserver streamCurrencyRate(String currencyFrom, String currencyTo) {
    CurrencyRateRequest request = CurrencyRateRequest.newBuilder()
        .setAccessToken(accessToken)
        .setCurrencyFrom(currencyFrom)
        .setCurrencyTo(currencyTo)
        .build(); // <1>

    CurrencyRateDataObserver currencyRateDataObserver = // <2>
        new CurrencyRateDataObserver(request, securityServiceStub);

    String key = currencyFrom+"|"+currencyTo;
    currencyObservers.put(key, currencyRateDataObserver);
    return currencyRateDataObserver;
  }
  // end::streamCurrencyRate[]

  // tag::getSecurityPriceHistory[]
  private SecurityPriceHistoryReply getSecurityPriceHistory(
      String code, SecurityCodeType securityCodeType, String stockExchangeId,
      int days, TimeResolution resolution) {

    SecurityWithStockExchange securityWithStockExchange =  // <1>
        TestUtils.getSecurityWithStockExchange(code, securityCodeType, stockExchangeId, null);
    SecurityPriceHistoryRequest request = SecurityPriceHistoryRequest.newBuilder() // <2>
        .setAccessToken(accessToken)
        .setSecurityWithStockexchange(securityWithStockExchange) // <3>
        .setDays(days) // <4>
        .setTimeResolution(resolution) // <5>
        .build(); // <6>
    SecurityPriceHistoryReply response =
        securityServiceBlockingStub.getSecurityPriceHistory(request); // <7>
    return response;
  }
  // end::getSecurityPriceHistory[]

  // tag::streamOrders[]
  private void streamOrders() {
    TradingAccounts tradingAccounts = getTradingAccounts(); // <1>
    for (int accountIndex = 0; accountIndex<tradingAccounts.getAccountsCount(); accountIndex++) {
      TradingAccount account = tradingAccounts.getAccounts(accountIndex); // <2>
      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(account)
          .build();
      OrdersObserver ordersObserver = new OrdersObserver(request, orderServiceStub); // <3>
      ordersObservers.put(account, ordersObserver);
    }
  }
  // end::streamOrders[]

  // tag::streamDepotData[]
  private void streamDepotData() {
    TradingAccounts tradingAccounts = getTradingAccounts(); // <1>
    for (int accountIndex = 0; accountIndex<tradingAccounts.getAccountsCount(); accountIndex++) {
      TradingAccount account = tradingAccounts.getAccounts(accountIndex);

      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(account)
          .build();

      DepotObserver depotObserver = new DepotObserver(request, depotServiceStub); // <2>
      depotObservers.put(account, depotObserver);
    }
  }
  // end::streamDepotData[]

  // tag::updateDepot[]
  private void updateDepot() {
    TradingAccounts tradingAccounts = getTradingAccounts();
    if (tradingAccounts.getAccountsCount()>0) {
      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(tradingAccounts.getAccounts(0))
          .build();

      depotServiceStub.updateDepot(
          request, new StreamObserver<Empty>() {

            @Override
            public void onCompleted() {
              // Updated
            }

            @Override
            public void onError(Throwable arg0) {
              // Check error
            }

            @Override
            public void onNext(Empty arg0) {
              // Processed
            }
          });
    }
  }
  // end::updateDepot[]


  // tag::streamTradingAccountInformation[]
  private void streamTradingAccountInformation() {
    TradingAccounts tradingAccounts = getTradingAccounts(); // <1>
    for (int accountIndex = 0; accountIndex<tradingAccounts.getAccountsCount(); accountIndex++) {
      TradingAccount account = tradingAccounts.getAccounts(accountIndex); // <2>
      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(account)
          .build();

      TradingAccountInformationObserver observer = // <3>
          new TradingAccountInformationObserver(request, accountServiceStub);
      accountObservers.put(account, observer);
    }
  }
  // end::streamTradingAccountInformation[]


  // tag::streamTradingAccountTransactions[]
  private void streamTradingAccountTransactions() {
    TradingAccounts tradingAccounts = getTradingAccounts(); // <1>
    for (int accountIndex = 0; accountIndex<tradingAccounts.getAccountsCount(); accountIndex++) {
      TradingAccount account = tradingAccounts.getAccounts(accountIndex); // <2>
      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(account)
          .build();
      TradingAccountTransactionsObserver observer = // <3>
          new TradingAccountTransactionsObserver(request, accountServiceStub);
      accountTransactionsObservers.put(account, observer);
    }
  }
  // end::streamTradingAccountTransactions[]


  // tag::addOrder[]
  private OrderReply addOrder() {
    SecurityCode securityCode = TestUtils.getSecurityCode("710000", SecurityCodeType.WKN); // <1>
    StockExchange stockExchange = TestUtils.getStockExchange("OTC", null); // <2>
    SecurityWithStockExchange securityWithStockExchange =
        TestUtils.getSecurityWithStockExchange(securityCode, stockExchange); // <3>
    AddOrderRequest request = AddOrderRequest.newBuilder() //<4>
        .setAccessToken(accessToken)
        .setAccountNumber("123456789") // <5>
        .setSecurityWithStockexchange(securityWithStockExchange)
        .setValidation(Validation.VALIDATE_ONLY) // <6>
        .setAmount(1)
        .setOrderModel(OrderModel.LIMIT) // <7>
        .setLimit(1)
        .setOrderType(OrderType.BUY) // <8>
        .setCashQuotation(CashQuotation.KASSA)
        .setValidityDate(TestUtils.getDate(GregorianCalendar.getInstance()))
        .build();
    OrderReply addOrderReply = orderServiceBlockingStub.addOrder(request); // <9>
    System.err.println(addOrderReply);
    return addOrderReply;
  }
  // end::addOrder[]


  // tag::addOrderWithCostsRequest[]
  private OrderReply addOrderWithCostsRequest() {
    SecurityCode securityCode = TestUtils.getSecurityCode("710000", SecurityCodeType.WKN); // <1>
    StockExchange stockExchange = TestUtils.getStockExchange("OTC", null); // <2>
    SecurityWithStockExchange securityWithStockExchange =
        TestUtils.getSecurityWithStockExchange(securityCode, stockExchange); // <3>
    Builder requestBuilder = AddOrderRequest.newBuilder() //<4>
        .setAccessToken(accessToken)
        .setAccountNumber("123456789") // <5>
        .setSecurityWithStockexchange(securityWithStockExchange)
        .setAmount(1)
        .setOrderModel(OrderModel.LIMIT)
        .setLimit(1)
        .setOrderType(OrderType.BUY)
        .setCashQuotation(CashQuotation.KASSA)
        .setValidityDate(TestUtils.getDate(GregorianCalendar.getInstance()));
    AddOrderRequest costsRequest = requestBuilder
        .setValidation(Validation.TOTAL_COSTS_ONLY) // <6>
        .build();
    OrderReply costsReply = orderServiceBlockingStub.addOrder(costsRequest); // <7>

    if (costsReply.getError()!=Error.getDefaultInstance()) {
      System.err.print("Error: "+costsReply.getError());
      return costsReply;
    }

    // Can be later
    AddOrderRequest executionRequest = requestBuilder
        .setValidation(Validation.WITHOUT_VALIDATION) // <8>
        .build();

    OrderReply executionReply = orderServiceBlockingStub.addOrder(executionRequest); // <9>
    System.err.println(executionReply);
    return executionReply;
  }
  // end::addOrderWithCostsRequest[]

  // tag::getOrderCosts[]
  private OrderReply getOrderCosts() {
    SecurityCode securityCode = TestUtils.getSecurityCode("710000", SecurityCodeType.WKN); // <1>
    StockExchange stockExchange = TestUtils.getStockExchange("OTC", null); // <2>
    SecurityWithStockExchange securityWithStockExchange =
        TestUtils.getSecurityWithStockExchange(securityCode, stockExchange); // <3>
    AddOrderRequest request = AddOrderRequest.newBuilder() //<4>
        .setAccessToken(accessToken)
        .setAccountNumber("123456789") // <5>
        .setSecurityWithStockexchange(securityWithStockExchange)
        .setValidation(Validation.VALIDATE_WITH_TOTAL_COSTS) // <6>
        // .setValidation(Validation.VALIDATE_WITH_DETAIL_COSTS) // <7>
        .setAmount(1)
        .setOrderModel(OrderModel.LIMIT)
        .setLimit(1)
        .setOrderType(OrderType.BUY)
        .setCashQuotation(CashQuotation.KASSA)
        .setValidityDate(TestUtils.getDate(GregorianCalendar.getInstance()))
        .build();
    OrderReply addOrderReply = orderServiceBlockingStub.addOrder(request); // <8>

    OrderCosts orderCosts = addOrderReply.getOrderCosts(); // <9>
    double estimatedTotalCosts = orderCosts.getEstimatedTotalCosts();
    for (CategoryCost categoryCost : orderCosts.getCategorieCostsList()) {
      double totalSumAbsolute = categoryCost.getTotalSumAbsolute();
      //
    }
    System.err.println(addOrderReply);
    return addOrderReply;
  }
  // end::getOrderCosts[]


  // tag::cancelOrder[]
  private void cancelOrder(Order order, TradingAccount account) {
    if (order!=null) {
      String orderNumber = order.getOrderNumber();
      if (orderNumber!=null && !orderNumber.isEmpty()) {
        CancelOrderRequest cancelOrderRequest = CancelOrderRequest.newBuilder()
            .setAccessToken(accessToken)
            .setAccountNumber(account.getAccountNumber()) // <1>
            .setOrderNumber(order.getOrderNumber()) // <2>
            .setValidation(Validation.VALIDATE_ONLY) // <3>
            .build();

        OrderReply cancelOrderReply = // <4>
            orderServiceBlockingStub.cancelOrder(cancelOrderRequest);
        System.out.println(cancelOrderReply);
      }
    }
  }
  // end::cancelOrder[]

  // tag::changeOrder[]
  private void changeOrder(Order order, TradingAccount account) {
    if (order!=null) {
      String orderNumber = order.getOrderNumber();
      if (orderNumber!=null && !orderNumber.isEmpty()) {
        ChangeOrderRequest changeOrderRequest = ChangeOrderRequest.newBuilder()
            .setAccessToken(accessToken)
            .setAccountNumber(account.getAccountNumber()) // <1>
            .setOrderNumber(order.getOrderNumber()) // <2>
            .setValidation(Validation.VALIDATE_ONLY) // <3>
            .setOrderModel(OrderModel.LIMIT) // <4>
            .setLimit(2)
            .build();

        OrderReply changeOrderReply = // <5>
            orderServiceBlockingStub.changeOrder(changeOrderRequest);
        System.out.println(changeOrderReply);
      }
    }
  }
  // end::changeOrder[]

  // tag::activateOrder[]
  private void activateOrder(Order order, TradingAccount account) {
    if (order!=null) {
      String orderNumber = order.getOrderNumber();
      if (orderNumber!=null && !orderNumber.isEmpty()) {
        ActivateOrderRequest activateOrderRequest = ActivateOrderRequest.newBuilder()
            .setAccessToken(accessToken)
            .setAccountNumber(account.getAccountNumber()) // <1>
            .setOrderNumber(order.getOrderNumber()) // <2>
            .setValidation(Validation.VALIDATE_ONLY) // <3>
            .build();

        OrderReply changeOrderReply =  // <4>
            orderServiceBlockingStub.activateOrder(activateOrderRequest);
        System.out.println(changeOrderReply);
      }
    }
  }
  // end::activateOrder[]

  // tag::deactivateOrder[]
  private void deactivateOrder(Order order, TradingAccount account) {
    if (order!=null) {
      String orderNumber = order.getOrderNumber();
      if (orderNumber!=null && !orderNumber.isEmpty()) {
        DeactivateOrderRequest deactivateOrderRequest = DeactivateOrderRequest.newBuilder()
            .setAccessToken(accessToken)
            .setAccountNumber(account.getAccountNumber()) // <1>
            .setOrderNumber(order.getOrderNumber()) // <2>
            .setValidation(Validation.VALIDATE_ONLY) // <3>
            .build();

        OrderReply changeOrderReply = // <4>
            orderServiceBlockingStub.deactivateOrder(deactivateOrderRequest);
        System.out.println(changeOrderReply);
      }
    }
  }
  // end::deactivateOrder[]

  // tag::processAddCancelOrder[]
  private void processAddCancelOrder() {
    OrderReply addOrderReply = addOrder();
    if (addOrderReply.getError()!=Error.getDefaultInstance()) {
      Order order = addOrderReply.getOrder();
      TradingAccount account = addOrderReply.getAccount();
      cancelOrder(order, account);
    }
  }
  // end::processAddCancelOrder[]

  // tag::acceptQuote[]
  private void acceptQuote() {
    QuoteRequest quoteRequest = QuoteRequest.newBuilder() // <1>
        .setAccessToken(accessToken)
        .setOrderType(OrderType.BUY)
        .setSecurityCode(TestUtils.getSecurityCode("710000", SecurityCodeType.WKN))
        .setAmount(10)
        .addStockExchanges(TestUtils.getStockExchange("OTC", null))
        .build();

    PerformanceCounter pcGetQuote = new PerformanceCounter("GetQuote");
    QuoteReply quoteReply = orderServiceBlockingStub.getQuote(quoteRequest); // <2>
    pcGetQuote.print();

    if (quoteReply.getError()==Error.getDefaultInstance()) {
      QuoteEntry quoteEntry = quoteReply.getPriceEntries(0); // <3>
      if (quoteEntry.getError()==Error.getDefaultInstance() &&
          !quoteEntry.getQuoteReference().isEmpty()) { // <4>
        SecurityWithStockExchange securityWithStockExchange = // <5>
            TestUtils.getSecurityWithStockExchange(
                quoteReply.getSecurityCode(), quoteEntry.getStockExchange());

        AcceptQuoteRequest acceptQuoteRequest = AcceptQuoteRequest.newBuilder() // <6>
            .setAccessToken(accessToken)
            .setOrderType(OrderType.BUY)
            // .setAccountNumber(accountNumber)
            .setSecurityWithStockexchange(securityWithStockExchange)
            .setAmount(10)
            .setValidation(Validation.VALIDATE_ONLY) // <7>
            .setLimit(quoteEntry.getBuyPrice())
            .setQuoteReference(quoteEntry.getQuoteReference()) // <8>
            .build();
        OrderReply acceptQuote = orderServiceBlockingStub.acceptQuote(acceptQuoteRequest); // <9>
        System.err.println(acceptQuote);
      }
    }
  }
  //end::acceptQuote[]

  //tag::acceptQuoteWithCostsRequest[]
  private void acceptQuoteWithCostsRequest() {
    SecurityCode securityCode = TestUtils.getSecurityCode("710000", SecurityCodeType.WKN);
    StockExchange stockExchange = TestUtils.getStockExchange("OTC", null);
    SecurityWithStockExchange securityWithStockExchange = TestUtils.getSecurityWithStockExchange(securityCode, stockExchange);

    AcceptQuoteRequest costsRequest = AcceptQuoteRequest.newBuilder() // <1>
        .setAccessToken(accessToken)
        .setOrderType(OrderType.BUY)
        .setSecurityWithStockexchange(securityWithStockExchange)
        .setAmount(10)
        .setValidation(Validation.TOTAL_COSTS_ONLY) // <2>
        //.setLimit(10) // <3>
        //.setQuoteReference() // <4>
        .build();
    OrderReply costsReply = orderServiceBlockingStub.acceptQuote(costsRequest); // <5>

    if (costsReply.getError()!=Error.getDefaultInstance()) {
      System.err.print("Error: "+costsReply.getError());
      return;
    }

    // Later
    QuoteRequest quoteRequest = QuoteRequest.newBuilder() // <6>
        .setAccessToken(accessToken)
        .setOrderType(OrderType.BUY)
        .setSecurityCode(securityCode)
        .setAmount(10)
        .addStockExchanges(stockExchange)
        .build();

    PerformanceCounter pcGetQuote = new PerformanceCounter("GetQuote");
    QuoteReply quoteReply = orderServiceBlockingStub.getQuote(quoteRequest); // <7>
    pcGetQuote.print();

    if (quoteReply.getError()==Error.getDefaultInstance()) {
      QuoteEntry quoteEntry = quoteReply.getPriceEntries(0); // <8>
      if (quoteEntry.getError()==Error.getDefaultInstance() &&
          !quoteEntry.getQuoteReference().isEmpty()) { // <9>

        AcceptQuoteRequest acceptQuoteRequest = AcceptQuoteRequest.newBuilder() // <10>
            .setAccessToken(accessToken)
            .setOrderType(OrderType.BUY)
            .setSecurityWithStockexchange(securityWithStockExchange)
            .setAmount(10)
            .setValidation(Validation.WITHOUT_VALIDATION) // <11>
            .setLimit(quoteEntry.getBuyPrice())
            .setQuoteReference(quoteEntry.getQuoteReference()) // <12>
            .build();
        OrderReply acceptQuote = orderServiceBlockingStub.acceptQuote(acceptQuoteRequest); // <13>
        System.err.println(acceptQuote);
      }
    }
  }
  //end::acceptQuoteWithCostsRequest[]

  // tag::requestQuotesDirect[]
  private void requestQuotesDirect(String code, SecurityCodeType securityCodeType) {
    QuoteRequest quoteRequest = QuoteRequest.newBuilder()
        .setAccessToken(accessToken)
        .setOrderType(OrderType.BUY) // <1>
        .setSecurityCode(TestUtils.getSecurityCode(code, securityCodeType)) // <2>
        .setAmount(10) // <3>
        .addStockExchanges(TestUtils.getStockExchange("BAA", null)) // <4>
        .addStockExchanges(TestUtils.getStockExchange("OTC", null))
        .addStockExchanges(TestUtils.getStockExchange("TRG", null))
        .build();
    QuoteReply quoteReply = orderServiceBlockingStub.getQuote(quoteRequest); // <5>
    if (quoteReply.getError()!=Error.getDefaultInstance()) {
      List<QuoteEntry> priceEntriesList = quoteReply.getPriceEntriesList(); // <6>
      for (QuoteEntry quoteEntry : priceEntriesList) {
        if (quoteEntry.getError()!=Error.getDefaultInstance()) {
          // ...
        }
      }
    }
  }
  // end::requestQuotesDirect[]

  // tag::requestQuotesAsynchronically[]
  private void requestQuotesAsynchronically(String code, SecurityCodeType securityCodeType) {
    final StreamObserver<QuoteReply> quotesObserver = new StreamObserver<QuoteReply>() { // <1>
      @Override
      public void onNext(QuoteReply quoteReply) {
        System.err.println(quoteReply); // <2>
        if (quoteReply.getError()!=Error.getDefaultInstance()) {
          List<QuoteEntry> priceEntriesList = quoteReply.getPriceEntriesList();
          // priceEntriesList will contain only one entry
          for (QuoteEntry quoteEntry : priceEntriesList) {
            StockExchange stockExchange = quoteEntry.getStockExchange();
            if (quoteEntry.getError()!=Error.getDefaultInstance()) {
              // ...
            }
          }
        }
      }
      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }
      @Override
      public void onCompleted() {}
    };
    final SecurityCode securityCode = TestUtils.getSecurityCode(code, securityCodeType); // <3>
    final StockExchange[] stockexchanges = { // <4>
        TestUtils.getStockExchange("BAA", null),
        TestUtils.getStockExchange("OTC", null),
        TestUtils.getStockExchange("TRG", null),
    };

    // Request data
    for (StockExchange stockExchange : stockexchanges) {
      QuoteRequest quoteRequest = QuoteRequest.newBuilder() // <5>
          .setAccessToken(accessToken)
          .setOrderType(OrderType.BUY)
          .setSecurityCode(securityCode)
          .setAmount(10)
          .addStockExchanges(stockExchange)
          .build();
      orderServiceStub.getQuote(quoteRequest, quotesObserver);
    }

    // ...
  }
  // end::requestQuotesAsynchronically[]

  private void getQuotes(String code, SecurityCodeType securityCodeType,
      String stockExchangeId, String issuer) {

    QuoteRequest quoteRequest = QuoteRequest.newBuilder()
        .setAccessToken(accessToken)
        .setSecurityCode(TestUtils.getSecurityCode(code, securityCodeType))
        .setAmount(10)
        .setOrderType(OrderType.BUY)
        .addStockExchanges(TestUtils.getStockExchange(stockExchangeId, issuer))
        .build();

    orderServiceStub.getQuote(quoteRequest, new StreamObserver<QuoteReply>() {

      @Override
      public void onNext(QuoteReply reply) {
        System.err.println(reply);
      }

      @Override
      public void onError(Throwable t) {
        System.err.println("Err: "+t);
      }

      @Override
      public void onCompleted() {
        System.err.println("Fin");
      }
    });
  }


  private void updateOrders() {
    TradingAccounts tradingAccounts = getTradingAccounts();
    if (tradingAccounts.getAccountsCount()>0) {
      TradingAccountRequest request = TradingAccountRequest.newBuilder()
          .setAccessToken(accessToken)
          .setTradingAccount(tradingAccounts.getAccounts(0))
          .build();
      orderServiceStub.updateOrders(request, null);
    }
  }

  // tag::getTradingAccounts[]
  private TradingAccounts getTradingAccounts() {
    AccessTokenRequest request = AccessTokenRequest.newBuilder()
        .setAccessToken(accessToken)
        .build();
    return accountServiceBlockingStub.getTradingAccounts(request);
  }
  // end::getTradingAccounts[]

  // tag::getTradingAccountsAsync[]
  private void getTradingAccountsAsync() {
    AccessTokenRequest request = AccessTokenRequest.newBuilder()
        .setAccessToken(accessToken)
        .build();
    accountServiceStub.getTradingAccounts(request, new StreamObserver<TradingAccounts>() { // <1>
      @Override
      public void onNext(TradingAccounts tradingAccounts) {
        System.out.println(tradingAccounts); // <2>
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace(); // <3>
      }

      @Override
      public void onCompleted() {
        System.out.println("No results anymore"); // <4>
      }
    });
  }
  // end::getTradingAccountsAsync[]


  @Override
  public void close() {
    try {
      logout();
      shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // tag::initClass[]
  /**
   * Test client.
   */
  public static void main(String[] args) throws Exception {
    if (args.length<2) {
      System.err.println("Please generate key in AT and "
          + "put location of the trust certificate and secret as arguments");
      System.exit(-1);
    }
    File caFile = new File(args[0]); // <1>

    if (!caFile.isFile()) { // <2>
      System.err.println("File: "+caFile+" does not exist");
      System.exit(-1);
    }

    String server = "localhost"; // <3>
    int port = 40443;

    System.err.println("Connecting... "+server+":"+port);
    try (TestClient client = new TestClient(server, port, caFile, args[1])) { // <4>
      // end::initClass[]

      // Get trading accounts
      System.err.println(client.getTradingAccounts());

      // Get stock exchanges
      System.err.println(client.getStockExchanges());

      // Get security info
      System.err.println(client.requestSecurityInfo("710000", SecurityCodeType.WKN));

      // Stream orders
      client.streamOrders();


      // Stream depots
      client.streamDepotData();

      // Stream firstLevel
      MarketDataDataObserver streamMarketDataDefault =
          client.streamMarketData("710000", SecurityCodeType.WKN, "OTC", null);
      MarketDataDataObserver streamMarketDataUSD =
          client.streamMarketData("710000", SecurityCodeType.WKN, "OTC", "USD");

      // Wait 10 sec.
      Thread.sleep(10000);
      // Close first market stream
      streamMarketDataDefault.close();

      // Wait 60 sec.
      Thread.sleep(60000);

      // Close second market stream
      streamMarketDataUSD.close();
      // tag::initClass[]

      // ...

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  // end::initClass[]


}
