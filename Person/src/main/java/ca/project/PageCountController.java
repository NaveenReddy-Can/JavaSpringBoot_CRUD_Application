package ca.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
public class PageCountController {
	
	@Autowired
	private PageCounter pageCounter;
	// url mapping 
	@GetMapping("/currentcount")
	public Integer currentCount() {
		return pageCounter.getPageCount();
	}
}
