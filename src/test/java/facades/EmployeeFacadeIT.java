package facades;

import dtos.EmployeeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author tobiaszimmermann
 */
public class EmployeeFacadeIT {

	public EmployeeFacadeIT() {
	}

	//Som jeg kunne se det skulle jeg ikke benytte mig af test databasen i denne opgave.
	//Derfor bliver disse tests lidt underlige siden databasen ikke bliver resat hele tiden.
	EmployeeFacade instance;
	EntityManagerFactory emf;

	@BeforeEach
	public void setUp() {
		emf = EMF_Creator.createEntityManagerFactory();
		instance = EmployeeFacade.getEmployeeFacade(emf);
	}

	/**
	 * Test of getEmployeeFacade method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeeFacade() {
		System.out.println("getEmployeeFacade");
		EntityManagerFactory _emf = Persistence.createEntityManagerFactory("pu");
		EmployeeFacade expResult = EmployeeFacade.getEmployeeFacade(_emf);
		assertEquals(expResult, instance);
	}

	/**
	 * Test of createEmployee method, of class EmployeeFacade.
	 */
	@Test
	public void testCreateEmployee() {
		System.out.println("createEmployee");
		EmployeeDTO employeeDTO = new EmployeeDTO("BobTest", "BobTestVej");
		int salary = 1000;
		EmployeeDTO result = instance.createEmployee(employeeDTO, salary);
		EmployeeDTO expResult = instance.getEmployeeById(result.getId());
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getName(), result.getName());
		assertEquals(expResult.getAddress(), result.getAddress());
	}

	/**
	 * Test of getEmployeeById method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeeById() {
		System.out.println("getEmployeeById");
		int salary = 10000;
		EmployeeDTO edto = new EmployeeDTO("getid", "getidvej");
		EmployeeDTO expResult = instance.createEmployee(edto, salary);
		EmployeeDTO result = instance.getEmployeeById(expResult.getId());
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getName(), result.getName());
		assertEquals(expResult.getAddress(), result.getAddress());
	}

	/**
	 * Test of getEmployeesByName method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeesByName() {
		System.out.println("getEmployeesByName");
		String name = "getbynametest";
		EmployeeDTO edto = new EmployeeDTO("getbynametest", "getbynametestvej");

		List<EmployeeDTO> expResult = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			expResult.add(instance.createEmployee(edto, 9000));
		}

		List<EmployeeDTO> result = instance.getEmployeesByName(name);
		int resultLength = result.toArray().length;
		for (int i = 0; i < 5; i++) {
			assertEquals(expResult.get(i).getId(), result.get(resultLength - 5).getId());
			assertEquals(expResult.get(i).getName(), result.get(i).getName());
			assertEquals(expResult.get(i).getAddress(), result.get(i).getAddress());
			resultLength = resultLength + 1;
		}
	}

	/**
	 * Test of getAlEmployees method, of class EmployeeFacade.
	 */
	@Test
	public void testGetAlEmployees() {
		System.out.println("getAlEmployees");
		List<EmployeeDTO> allCurrent = instance.getAlEmployees();
		EmployeeDTO edto = new EmployeeDTO("getallemployees", "getallemployeesvej");
		List<EmployeeDTO> expResult = new ArrayList<>();

		allCurrent.forEach(e -> {
			expResult.add(e);
		});

		for (int i = 0; i < 5; i++) {
			expResult.add(instance.createEmployee(edto, 20));
		}
		List<EmployeeDTO> result = instance.getAlEmployees();

		for (EmployeeDTO e : result) {
			assertEquals(expResult.get(e.getId() - 1).getId(), result.get(e.getId() - 1).getId());
			assertEquals(expResult.get(e.getId() - 1).getName(), result.get(e.getId() - 1).getName());
			assertEquals(expResult.get(e.getId() - 1).getName(), result.get(e.getId() - 1).getName());
		}
	}

	@Test
	public void testGetEmploeesWithHighestSalary() {
		System.out.println("getEmployeesWithHighestSalary");
		int salary = 500000;
		EmployeeDTO edto = new EmployeeDTO("highsalary", "highsalaryvej");
		List<EmployeeDTO> expResult = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			expResult.add(instance.createEmployee(edto, salary));
		}
		List<EmployeeDTO> result = instance.getEmployeesWithHighestSalary();

		for (int i = 0; i < 5; i++) {
			assertEquals(expResult.get(i).getName(), result.get(i).getName());
			assertEquals(expResult.get(i).getAddress(), result.get(i).getAddress());
		}
	}

	/**
	 * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
	 */
	@Test
	public void testGetEmployeesWithSalary() {
		System.out.println("getEmployeesWithSalary");
		int salary = 500000;
		EmployeeDTO edto = new EmployeeDTO("highsalary", "highsalaryvej");
		List<EmployeeDTO> expResult = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			expResult.add(instance.createEmployee(edto, salary));
		}

		List<EmployeeDTO> result = instance.getEmployeesWithSalary(salary);

		int forResult = 5;
		int forCreated = 0;
		for (EmployeeDTO e : result) {
			assertEquals(expResult.get(forCreated).getId(), result.get(e.getId() - forResult));
			forResult = forResult - 1;
			forCreated = forCreated + 1;
		}
	}

}
