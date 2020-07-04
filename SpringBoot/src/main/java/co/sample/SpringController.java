package co.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringController extends SpringBootServletInitializer {

	@Autowired
	ExpenseRepository expenseRepository;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringController.class);
	}

	@GetMapping(value = "")
	public String get() {
		return "Api is working fine..!";
	}

	@PostMapping(value = "/addExpenses")
	public String addExpenses(Expense expense) {
		expenseRepository.save(expense);
		return "Data Saved";
	}

}
