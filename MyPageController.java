package jp.co.internous.team2402.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2402.model.domain.MstUser;
import jp.co.internous.team2402.model.mapper.MstUserMapper;
import jp.co.internous.team2402.model.session.LoginSession;

/**
 * マイページに関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2402/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * マイページ画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return マイページ画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user",user);
		
		return "my_page";
	}
}
