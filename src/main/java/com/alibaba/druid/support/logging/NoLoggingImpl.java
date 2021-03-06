/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.support.logging;

public class NoLoggingImpl implements Log {

    private int infoCount;
    private int errorCount;
    private int warnCount;
    private Class<?> clazz;

    public NoLoggingImpl(Class<?> clazz){
        this.clazz = clazz;
    }

    public boolean isDebugEnabled() {
        return false;
    }

    public void error(String s, Throwable e) {
        error(s);
        
        if (e != null) {
            e.printStackTrace();
        }
    }

    public void error(String s) {
        errorCount++;
        if (s != null) {
            System.err.println(clazz.getClass().getName() + " : " + s);
        }
    }

    public void debug(String s) {
    }

    public void debug(String s, Throwable e) {
    }

    public void warn(String s) {
        warnCount++;
    }

    @Override
    public void warn(String s, Throwable e) {
        warnCount++;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public int getWarnCount() {
        return warnCount;
    }

    @Override
    public void resetStat() {
        errorCount = 0;
        warnCount = 0;
        infoCount = 0;
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String s) {
        infoCount++;
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    public int getInfoCount() {
        return infoCount;
    }
}
