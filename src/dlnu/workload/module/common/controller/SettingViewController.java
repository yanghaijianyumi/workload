package dlnu.workload.module.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingViewController {

	@RequestMapping(value = "/account/setting")
	public String setting() {

		return "setting/setting";
	}

	@RequestMapping(value = "/account/setting/password")
	public String updatePassword() {

		return "setting/password";
	}

}
