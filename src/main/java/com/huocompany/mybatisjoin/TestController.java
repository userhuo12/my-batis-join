package com.huocompany.mybatisjoin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huocompany.mybatisjoin.dao.IDao;
import com.huocompany.mybatisjoin.dto.BoardDto;

@Controller
public class TestController {
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping(value = "/jointest")
	public String jointest(Model model) {
		IDao dao = sqlsession.getMapper(IDao.class);
		BoardDto boardDto =dao.listDao("tiger");
//		System.out.println(boardDto.getMemberDto().getName());
		model.addAttribute("boardInfo", boardDto);
		
		return "jointest";
	}
}
