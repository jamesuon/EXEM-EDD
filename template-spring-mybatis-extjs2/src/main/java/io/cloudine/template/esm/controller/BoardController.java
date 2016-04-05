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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Board>> getBoard() {
        //http://localhost:8080/example/board
        System.out.println("boardList controller");
        return ResponseEntity.ok(boardService.getBoardList());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Board> insertBoard(@RequestBody Board board) {
        //http://localhost:8080/example/board

        System.out.printf("insert Controller");

        return ResponseEntity.ok(boardService.insert(board));
    }

    @RequestMapping(value="/{b_id}", method=RequestMethod.GET)
    public ResponseEntity<Board> getBoard(@PathVariable Integer b_id) {
        //http://localhost:8080/example/board/1

        System.out.printf("getBoard Controller");

        return ResponseEntity.ok(boardService.get(b_id));
    }

    @RequestMapping(value="/{b_id}", method=RequestMethod.DELETE)
    public ResponseEntity<ArrayList<Board>> deleteBoard(@PathVariable Integer b_id) {
        //http://localhost:8080/example/board/1

        System.out.printf("deleteBoard Controller");
        //List를 return
        return ResponseEntity.ok(boardService.delete(b_id));
    }

    @RequestMapping(value="/{b_id}", method=RequestMethod.PUT)
    public ResponseEntity<Board> updateBoard(@PathVariable int b_id, @RequestBody Board board) {
        //http://localhost:8080/example/board/update/1

        System.out.printf("board controller update board");

        //Board를 return
        return ResponseEntity.ok(boardService.updateBoard(b_id, board));
    }

}