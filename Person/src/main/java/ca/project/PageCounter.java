package ca.project;

import javax.validation.constraints.Min;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PageCounter {
	//value to store the count value
	@Min(0)
	private Integer pageCounter = 0;
	// Incrementing method
    public void Increment() {
    	pageCounter++;
    }
	// Page counting method
	public Integer getPageCount() {
		Increment();
		return pageCounter;
	}
}
