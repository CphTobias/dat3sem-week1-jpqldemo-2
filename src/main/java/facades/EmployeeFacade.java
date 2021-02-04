package facades;

import dtos.EmployeeDTO;
import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EmployeeFacade {

	private static EntityManagerFactory emf;
	private static EmployeeFacade instance;

	public EmployeeFacade() {
	}

	public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
		if (instance == null) {
			instance = new EmployeeFacade();
			emf = _emf;
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public EmployeeDTO getEmployeeById(int id) {
		EntityManager em = getEntityManager();
		return new EmployeeDTO(em.find(Employee.class, id));
	}

	public List<EmployeeDTO> getEmployeesByName(String name) {
		EntityManager em = getEntityManager();
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class)
			.setParameter("name", name)
			.getResultList();
		return EmployeeDTO.getDtos(employees);
	}

	public List<EmployeeDTO> getAlEmployees() {
		EntityManager em = getEntityManager();
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		return EmployeeDTO.getDtos(employees);
	}

	public List<EmployeeDTO> getEmployeesWithHighestSalary(int salary) {
		EntityManager em = getEntityManager();
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.salary > :salary")
			.setParameter("salary", salary)
			.getResultList();
		return EmployeeDTO.getDtos(employees);
	}

	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, int salary) {
		EntityManager em = getEntityManager();
		Employee e = new Employee(employeeDTO.getName(), employeeDTO.getAddress(), salary);
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return new EmployeeDTO(e);
	}
}
