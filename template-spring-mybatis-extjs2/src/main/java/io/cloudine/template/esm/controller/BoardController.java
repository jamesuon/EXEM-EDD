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

import io.cloudine.template.esm.domain.Board;
import io.cloudine.template.esm.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board")
    public String getBoard(Model model) {
        //http://localhost:8080/example/board

        ArrayList<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        System.out.printf("boardListController");
        return "boardList"; // 이동할 URL  --> boardList.jsp
    }

    @RequestMapping("/board/{b_id}")
    public String getBoard(@PathVariable Integer b_id, Model model) {

        //http://localhost:8080/example/board/1


        System.out.printf("getBoard Controller");

        Board board = boardService.get(b_id);
        model.addAttribute("board", board);
        return "board"; // 이동할 URL  --> board.jsp
    }

    @RequestMapping(value = "/delete/{b_id}", method=RequestMethod.DELETE)
    public String deleteBoard(@PathVariable Integer b_id) {

        //http://localhost:8080/example/board/1


        System.out.printf("deleteBoard Controller");

        boardService.delete(b_id);

        return "redirect:/example/board"; // 이동할 URL  --> board.jsp
    }


    @RequestMapping(value="/board/update/{b_id}", method=RequestMethod.GET)
    public String updateBoardForm(@PathVariable Integer b_id, Model model) {

        //http://localhost:8080/example/board/1/uform


        System.out.printf("updateform Controller");

        Board board = boardService.get(b_id);

        model.addAttribute("board", board);
        return "updateBoard"; // 이동할 URL  --> updateBoard.jsp
    }


    @RequestMapping(value="/board/update/edit/{b_id}", method=RequestMethod.PUT)
    //public String updateBoard(@RequestParam("b_id") int b_id, @RequestParam("b_name") String b_name, @RequestParam("c_date") Date c_date, @RequestParam("u_date") Date u_date, @RequestParam("member_id") String member_id) {
    //public String updateBoard(@ModelAttribute Board board) {
    public String updateBoard(@PathVariable int b_id, @ModelAttribute Board board) {
        //http://localhost:8080/example/board

        System.out.println(board.getB_id()+"," + board.getB_name());

        System.out.printf("board controller update board");

        //Board board = boardService.get(1);

        System.out.printf("check`````````````````3");
        //model.addAttribute("board", board);

        boardService.updateBoard(board);

        System.out.printf("check`````````````````4");

        return "redirect:/example/board"; // 이동할 URL  --> boardList.jsp
    }

    @RequestMapping(value="/board/insert", method=RequestMethod.GET)
    public String insertBoardForm() {

        //http://localhost:8080/example/board/1/uform


        System.out.printf("insertform Controller");

        return "insertBoard"; // 이동할 URL  --> updateBoard.jsp
    }

    @RequestMapping(value="/board/insert", method=RequestMethod.POST)
    public String insertBoard(@ModelAttribute("board") Board board) {
    //public String insertBoard(@RequestParam("b_name") String b_name, @RequestParam("c_date") Date c_date, @RequestParam("member_id") int member_id) {
        //http://localhost:8080/example/board/1/uform

        System.out.printf("insertform Controller");

        boardService.insert(board);

        return "redirect:/example/board"; // 이동할 URL  --> updateBoard.jsp
    }

}