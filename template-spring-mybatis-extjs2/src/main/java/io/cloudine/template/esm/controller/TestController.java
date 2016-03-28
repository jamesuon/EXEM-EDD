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
import io.cloudine.template.esm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {


        //http://localhost:8080/example/helloWorld





        System.out.println("helloWorld...................1");

        User user = userService.get(1);

        System.out.println("helloWorld...................2");
        System.out.println(user);
//        user.setName("Dooli");
//
//        System.out.println("helloWorld...................3");
//        userService.refresh(user);

        System.out.println("helloWorld...................4");

        model.addAttribute("user", user);
        System.out.println("helloWorld...................5");
        return "index"; // 이동할 URL  --> /WEB-INF/jsp/index.jsp
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@RequestBody String body) {
        return body;
    }

    @RequestMapping(value = "/sayUser", method = RequestMethod.GET)
    @ResponseBody
    public User sayUser() {
        return userService.get(1);
    }
}