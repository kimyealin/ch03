package yeling.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import yeling.spring.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	public BoardServiceImpl() {
		System.out.println("---> BoardServiceImpl 객체 생성");
	}
	
	@Override
	public String hello(String name) {
		return "Hello : " + name;
	}

	@Override
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트");
		board.setWriter("손오공");
		board.setContent("글쓰기 테스트");
		board.setRegDate(new Date());
		board.setCnt(0);
		return board;
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i=1; i<=10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(1);
			board.setTitle("제목 : " + i);
			board.setWriter("손오공");
			board.setContent(i + "번 글의 내용입니다.");
			board.setRegDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}

}
