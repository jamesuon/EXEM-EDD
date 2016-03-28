/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cloudine.template.esm.controller;

import io.cloudine.template.esm.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
@RequestMapping("/async/callable")
public class AsyncController {

    private final Queue<DeferredResult<String>> responseBodyQueue = new ConcurrentLinkedQueue<DeferredResult<String>>();

    private final Queue<DeferredResult<ModelAndView>> mavQueue = new ConcurrentLinkedQueue<DeferredResult<ModelAndView>>();

    private final Queue<DeferredResult<String>> exceptionQueue = new ConcurrentLinkedQueue<DeferredResult<String>>();

    @RequestMapping("/deferred-result/response-body")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        DeferredResult<String> result = new DeferredResult<String>();
        this.responseBodyQueue.add(result);
        return result;
    }

    @RequestMapping("/deferred-result/model-and-view")
    @ResponseBody
    public DeferredResult<ModelAndView> deferredResultWithView() {
        DeferredResult<ModelAndView> result = new DeferredResult<ModelAndView>();
        this.mavQueue.add(result);
        return result;
    }

    @RequestMapping("/deferred-result/exception")
    @ResponseBody
    public DeferredResult<String> deferredResultWithException() {
        DeferredResult<String> result = new DeferredResult<String>();
        this.exceptionQueue.add(result);
        return result;
    }

    @RequestMapping("/deferred-result/timeout-value")
    @ResponseBody
    public DeferredResult<String> deferredResultWithTimeoutValue() {
        return new DeferredResult<String>(1000L, "Deferred result after timeout");
    }

    @Scheduled(fixedRate = 2000)
    public void processQueues() {
        for (DeferredResult<String> result : this.responseBodyQueue) {
            result.setResult("Deferred result :: " + System.currentTimeMillis());
            this.responseBodyQueue.remove(result);
        }
        for (DeferredResult<String> result : this.exceptionQueue) {
            result.setErrorResult(new IllegalStateException("DeferredResult error"));
            this.exceptionQueue.remove(result);
        }
        for (DeferredResult<ModelAndView> result : this.mavQueue) {
            result.setResult(new ModelAndView("index", "user", new User()));
            this.mavQueue.remove(result);
        }
    }

    @ExceptionHandler
    @ResponseBody
    public String handleException(IllegalStateException ex) {
        return "Handled exception: " + ex.getMessage();
    }
}