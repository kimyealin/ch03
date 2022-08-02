package yeling.spring.service;

import java.util.List;

import yeling.spring.domain.BoardVO;

public interface BoardService {
	String hello(String name);
	BoardVO getBoard();
	List<BoardVO> getBoardList();
}
