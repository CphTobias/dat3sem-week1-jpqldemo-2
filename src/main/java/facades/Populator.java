package facades;

import dtos.EmployeeDTO;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Populator {

	public static void populate() {
		EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
		EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
		ef.createEmployee(new EmployeeDTO("Bob", "bobvej"), 100);
		ef.createEmployee(new EmployeeDTO("Bob", "bobvej"), 100);
		ef.createEmployee(new EmployeeDTO("Bob", "bobvej"), 100);
	}

	public static void main(String[] args) {
		populate();
	}

}
