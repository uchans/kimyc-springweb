package org.kyc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {

	static final Logger logger = LogManager.getLogger();

	@GetMapping("/**")
	public void mapDefault() {
		logger.debug("Map default.");
	}
}