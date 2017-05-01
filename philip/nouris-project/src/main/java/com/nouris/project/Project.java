package com.nouris.project;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nouris.project.api.domain.Day;
import com.nouris.project.api.domain.Period;
import com.nouris.project.api.domain.Shift;
import com.nouris.project.api.domain.ShiftRepository;
import com.nouris.project.api.domain.Worker;
import com.nouris.project.api.domain.WorkerRepository;

@SpringBootApplication
public class Project {
	
	@Autowired 
	private ShiftRepository shiftRepository;
	@Autowired 
	private WorkerRepository workerRepository;
 
	public static void main(String[] args) {
		SpringApplication.run(Project.class, args);
	}
	
	public @PostConstruct void init() {							//PostContrust when app runs then run the init code

		Worker one = new Worker("Bilbo", "Baggins");
		Worker two = new Worker("Frodo", "Baggins");
		Worker three = new Worker("Gandalf", "the Wizard");
		workerRepository.save(Arrays.asList(one, two, three));

		/**
		 * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
		 * with an authentication token containing the necessary privileges.
		 */
		Shift first = new Shift(Day.Monday, Period.Day);
		first.setWorkers(Arrays.asList(one, two));
		Shift second = new Shift(Day.Tuesday, Period.Evening);
		second.setWorkers(Arrays.asList(three));
		
		shiftRepository.save(Arrays.asList(first, second));

	}
}
