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

import com.consorsbank.module.tapi.grpc.DepotServiceGrpc.DepotServiceStub;
import com.consorsbank.module.tapi.grpc.account.TradingAccount;
import com.consorsbank.module.tapi.grpc.account.TradingAccountRequest;
import com.consorsbank.module.tapi.grpc.common.Error;
import com.consorsbank.module.tapi.grpc.depot.DepotEntries;
import com.consorsbank.module.tapi.grpc.depot.DepotEntry;

//tag::DepotObserver[]
public class DepotObserver extends ServerSubscription<TradingAccountRequest, DepotEntries>{
  private final DepotServiceStub serviceStub;
  
  public DepotObserver(TradingAccountRequest request, DepotServiceStub depotServiceStub) {
    this.serviceStub = depotServiceStub;
    this.serviceStub.streamDepot(request, this); // <1>
  }
  

  @Override
  public void onCompleted() { // <2>
    System.out.println("Call completed!");
  }

  @Override
  public void onNext(DepotEntries depotEntries) { // <3>
    Error error = depotEntries.getError(); // <4>
    if (error==Error.getDefaultInstance()) {
      System.out.printf("Async depot: %s%n", depotEntries);
      TradingAccount account = depotEntries.getAccount();
      List<DepotEntry> entriesList = depotEntries.getEntriesList();
      // ...
      
    } else {
      System.out.printf("Error: %s%n", error);
    }
  }
}
// end::DepotObserver[]