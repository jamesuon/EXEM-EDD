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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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


        System.out.printf("check`````````````````2");

        //Board board = boardService.get(1);

        System.out.printf("check`````````````````3");
        //model.addAttribute("board", board);

        ArrayList<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        System.out.printf("check`````````````````4");
        return "boardList"; // 이동할 URL  --> boardList.jsp
    }

    @RequestMapping("/board/{b_id}")
    public String getBoard(@PathVariable Integer b_id, Model model) {

        //http://localhost:8080/example/board/1


        System.out.printf("check`````````````````2");

        Board board = boardService.get(b_id);

        System.out.printf("check`````````````````3");
        model.addAttribute("board", board);

        System.out.printf("check`````````````````4");
        return "board"; // 이동할 URL  --> board.jsp
    }


    @RequestMapping("/board/{b_id}/uform")
    public String updateBoardForm(@PathVariable Integer b_id, Model model) {

        //http://localhost:8080/example/board/1


        System.out.printf("check`````````````````2");

        Board board = boardService.get(b_id);

        System.out.printf("check`````````````````3");
        model.addAttribute("board", board);

        System.out.printf("check`````````````````4");
        return "updateBoard"; // 이동할 URL  --> updateBoard.jsp
    }


    @RequestMapping("/board/{b_id}/update")
    //public String updateBoard(@RequestParam("b_id") int b_id, @RequestParam("b_name") String b_name, @RequestParam("c_date") String c_date, @RequestParam("u_date") String u_date, @RequestParam("member_id") int member_id, Model model) {
    public String updateBoard(@ModelAttribute Board board) {


        //http://localhost:8080/example/board
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");

//        Board board = boardService.get(b_id);
//        System.out.println("111111111");
//        board.setB_name(b_name);
//        System.out.println("22222222222"+c_date);
//        board.setC_date(new Date());
//        System.out.println("3333333333333333");
//        board.setU_date(new Date());
//        System.out.println("444444444444444");
//        board.setMember_id(member_id);
//        System.out.println("5555555555555555");

        System.out.println(board.getB_id()+"," + board.getB_name());


        System.out.printf("board controller update board");

        //Board board = boardService.get(1);

        System.out.printf("check`````````````````3");
        //model.addAttribute("board", board);

        boardService.updateBoard(board);

        System.out.printf("check`````````````````4");

//        ArrayList<Board> boardList = boardService.getBoardList();
//        model.addAttribute("boardList", boardList);
        return "redirect:/example/board"; // 이동할 URL  --> boardList.jsp
    }

}