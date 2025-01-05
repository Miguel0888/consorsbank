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
package com.consorsbank.module.tapi;

public class PerformanceCounter {
  private double start;
  private double end;
  private long runs;
  private long total;
  private boolean isCumulative;
  private String name = null;
  
  public long getRuns() {
    return runs;
  }
  
  public PerformanceCounter() {
    startMeasure();
  }
  
  public PerformanceCounter(boolean isCumulative) {
    this.isCumulative = isCumulative;
    startMeasure();
  }
  
  public PerformanceCounter(String name) {
    this.name = name;
    startMeasure();
  }
  
  public PerformanceCounter(String name, boolean isCumulative) {
    this.isCumulative = isCumulative;
    this.name = name;
    startMeasure();
  }
  
  public void startMeasure() {
    start = getCurrentTime();
    end = Long.MIN_VALUE;
  }
  
  public void endMeasure() {
    end = getCurrentTime();
    total += getDelta();
    runs++;
  }
  
  private double getCurrentTime() {
    return System.nanoTime()*.000001D;
  }
  
  public double getDelta() {
    check();
    return Math.round((end-start)*1000D)*.001D;
  }
  
  public double getIterationTime(long iteration) {
    return getDelta()/iteration;
  }
  
  private void check() {
    if (end==Long.MIN_VALUE) {
      endMeasure();
    }
  }
  public double getAverage() {
    return (((double)total)/runs);
  }
  
  public String toString(String text) {
    if (isCumulative) {
      String result = (name==null ? "" : name) + text + ": ";
      result += String.valueOf(getDelta()) + " msec.";
      result += ", runs: " + runs
          + ", total: "+total+" msec. "
          + ", average: "+getAverage()+" msec.";
      return result;
    } else {
      String result =  (name==null ? "" : name) + text + ": ";
      long delta = (long)getDelta();
      long msec = delta%1000;
      delta /= 1000;
      long sec = delta%60;
      delta /= 60;
      long min = delta%60;
      delta /= 60;
      long hours = delta%24;
      delta /= 24;
      if (delta>0) {
        result += String.valueOf(delta) + " d. ";
      }
      if (delta>0 || hours>0) {
        result += String.valueOf(hours) + " h. ";
      }
      if (delta>0 || hours>0 || min>0) {
        result += String.valueOf(min) + " min. ";
      }
      if (delta>0 || hours>0 || min>0 || sec>0) {
        result += String.valueOf(sec) + " sec. ";
      }
      result += String.valueOf(msec) + " msec.";
      return result;
    }
  }
  
  @Override
  public String toString() {
    return toString("");
  }
  
  public void print() {
    System.out.println(this);
  }
}
