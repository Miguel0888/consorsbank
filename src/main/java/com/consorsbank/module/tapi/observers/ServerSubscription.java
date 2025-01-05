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

import java.io.Closeable;

// tag::ServerSubscription[]
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;

public abstract class ServerSubscription<R, T> implements ClientResponseObserver<R, T>, Closeable {
  private ClientCallStreamObserver<R> observer;
  
  // end::ServerSubscription[]
  
  @Override
  public final void onError(Throwable e) {
    if (e instanceof StatusRuntimeException) {
      StatusRuntimeException statusRuntimeException = (StatusRuntimeException)e;
      Status status = statusRuntimeException.getStatus();
      if (status.getCode()==Status.Code.CANCELLED) {
        // Nothing to show
        return;
      }
    }
  }

  // tag::ServerSubscription[]
  /**
   * This function is called during subscription initialization.
   * observer will created by GRPC engine and can be used for
   * data flow control.
   */
  @Override
  public void beforeStart(ClientCallStreamObserver<R> observer) {
    this.observer = observer; // <1>
  }
  
  /**
   * Call this function to unsubscribe from server
   */
  @Override
  public void close() {
    observer.cancel("Fin", null); // <2>
  }
  // end::ServerSubscription[]
  protected void processError(Throwable e) {
    e.printStackTrace();
  }
  
  // tag::ServerSubscription[]
  // ...
}
// end::ServerSubscription[]