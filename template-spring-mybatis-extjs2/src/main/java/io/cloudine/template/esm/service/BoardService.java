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
package io.cloudine.template.esm.service;

import io.cloudine.template.esm.domain.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author Edward KIM
 * @since 0.2
 */
public interface BoardService {

    Board get(int id);

    ArrayList<Board> getBoardList();

    boolean refresh(Board board);

    void updateBoard(Board board);

    void insert(Board board);

    void delete(int id);
}

