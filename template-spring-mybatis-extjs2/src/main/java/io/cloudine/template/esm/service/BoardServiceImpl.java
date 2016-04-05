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

        return boardRepository.selectById(id);

    }

    @Override
    public ArrayList<Board> getBoardList() {

        return boardRepository.selectList();

    }

    @Override
    public boolean refresh(Board board) {
        return false;
    }

    @Override
    public Board updateBoard(int id, Board board) {

        int result = boardRepository.update(board);

        return boardRepository.selectById(id);

    }

    @Override
    public Board insert(Board board) {
        int result = boardRepository.insert(board);
        return boardRepository.selectById(result);
    }

    @Override
    public ArrayList<Board> delete(int id) {
        int result = boardRepository.delete(id);
        return boardRepository.selectList();
    }
}
