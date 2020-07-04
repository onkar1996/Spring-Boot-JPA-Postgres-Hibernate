package co.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.demo.springboot.model.Employee;
import co.demo.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return empRepo.findById(id).orElse(new Employee());
	}

	@PostMapping("/employees")
	public Employee createEmployees(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployees(@PathVariable("id") Long id, @RequestBody Employee emp) {
		Employee employee = empRepo.findById(id).orElse(new Employee());
		employee.setName(emp.getName());
		employee.setPosition(emp.getPosition());
		return empRepo.save(employee);
	}

	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployees(@PathVariable("id") Long id) {
		Employee employee = empRepo.findById(id).orElse(new Employee());
		empRepo.delete(employee);
		return employee;
	}

}
