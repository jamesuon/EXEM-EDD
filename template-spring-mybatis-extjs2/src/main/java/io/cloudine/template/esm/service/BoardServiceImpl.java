package io.cloudine.template.esm.service;

import io.cloudine.template.esm.domain.Board;
import io.cloudine.template.esm.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Choi on 2016-03-24.
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board get(int id) {

        System.out.printf("cccccc 1 = " + id);
        Board b=boardRepository.selectById(id);
        System.out.println(b.getB_name());
        return b;


    }

    @Override
    public ArrayList<Board> getBoardList() {

        System.out.println("Service : getBoardList : before");
        ArrayList<Board> boardList = boardRepository.selectList();
        System.out.println("Service : getBoardList : after");
        return boardList;

    }

    @Override
    public boolean refresh(Board board) {
        return false;
    }

    @Override
    public void updateBoard(Board board) {

        int result = boardRepository.update(board);

    }
}
