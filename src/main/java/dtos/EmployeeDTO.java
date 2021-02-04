package dtos;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

	private int id;
	private String name;
	private String address;

	public EmployeeDTO(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public EmployeeDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public EmployeeDTO(Employee e) {
		this.id = e.getId();
		this.name = e.getName();
		this.address = e.getAddress();
	}

	public static List<EmployeeDTO> getDtos(List<Employee> e) {
		List<EmployeeDTO> dtos = new ArrayList<>();
		e.forEach(employee -> dtos.add(new EmployeeDTO(employee)));
		return dtos;
	}

	@Override
	public String toString() {
		return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
