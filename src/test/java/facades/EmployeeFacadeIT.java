/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.EmployeeDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tobiaszimmermann
 */
public class EmployeeFacadeIT {

	public EmployeeFacadeIT() {
	}

	@BeforeAll
	public static void setUpClass() {
	}

	@AfterAll
	public static void tearDownClass() {
	}

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
	}

	/**
	 * Test of getEmployeeFacade method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeeFacade() {
		System.out.println("getEmployeeFacade");
		EntityManagerFactory _emf = null;
		EmployeeFacade expResult = null;
		EmployeeFacade result = EmployeeFacade.getEmployeeFacade(_emf);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEntityManager method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEntityManager() {
		System.out.println("getEntityManager");
		EmployeeFacade instance = new EmployeeFacade();
		EntityManager expResult = null;
		EntityManager result = instance.getEntityManager();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEmployeeById method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeeById() {
		System.out.println("getEmployeeById");
		int id = 0;
		EmployeeFacade instance = new EmployeeFacade();
		EmployeeDTO expResult = null;
		EmployeeDTO result = instance.getEmployeeById(id);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEmployeesByName method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeesByName() {
		System.out.println("getEmployeesByName");
		String name = "";
		EmployeeFacade instance = new EmployeeFacade();
		List<EmployeeDTO> expResult = null;
		List<EmployeeDTO> result = instance.getEmployeesByName(name);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAlEmployees method, of class EmployeeFacade.
	 */
	@Test
	public void testGetAlEmployees() {
		System.out.println("getAlEmployees");
		EmployeeFacade instance = new EmployeeFacade();
		List<EmployeeDTO> expResult = null;
		List<EmployeeDTO> result = instance.getAlEmployees();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeesWithHighestSalary() {
		System.out.println("getEmployeesWithHighestSalary");
		int salary = 0;
		EmployeeFacade instance = new EmployeeFacade();
		List<EmployeeDTO> expResult = null;
		List<EmployeeDTO> result = instance.getEmployeesWithHighestSalary(salary);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of createEmployee method, of class EmployeeFacade.
	 */
	@Test
	public void testCreateEmployee() {
		System.out.println("createEmployee");
		EmployeeDTO employeeDTO = null;
		int salary = 0;
		EmployeeFacade instance = new EmployeeFacade();
		EmployeeDTO expResult = null;
		EmployeeDTO result = instance.createEmployee(employeeDTO, salary);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
