/*
 * Copyright 2018, Trading-API, Consorsbank.
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
package com.consorsbank.module.tapi.observers;

import java.util.List;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc.SecurityServiceStub;
import com.consorsbank.module.tapi.grpc.common.Error;
import com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply;
import com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply.OrderBookEntry;
import com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest;

// tag::OrderBookDataObserver[]
public class OrderBookDataObserver extends ServerSubscription<SecurityOrderBookRequest, SecurityOrderBookReply> {
  private final SecurityServiceStub securityServiceStub;

  public OrderBookDataObserver(SecurityOrderBookRequest request,
      SecurityServiceStub securityServiceStub) {
    this.securityServiceStub = securityServiceStub;
    
    securityServiceStub.streamOrderBook(request, this); // <1>
  }
  
  @Override
  public void onCompleted() {
    System.out.println("Call completed!"); // <2>
  }
  
  @Override
  public void onNext(SecurityOrderBookReply response) {
    Error error = response.getError();
    if (error==Error.getDefaultInstance()) {
      System.out.printf("Async client onNext: %s%n", response); // <3>
      List<OrderBookEntry> orderBookEntriesList = response.getOrderBookEntriesList();
      for (OrderBookEntry orderBookEntry : orderBookEntriesList) {
        double askPrice = orderBookEntry.getAskPrice();
        double askVolume = orderBookEntry.getAskVolume();
      }
      // ...
      
    } else {
      System.out.printf("Error: %s%n", error);
    }
  }
}
// end::OrderBookDataObserver[]
