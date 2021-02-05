package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.EmployeeDTO;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author tobiaszimmermann
 */
@Path("employee")
public class EmployeeResource {

	private final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
	private final EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Context
	private UriInfo context;

	public EmployeeResource() {
	}

	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
		List<EmployeeDTO> dtos = ef.getAlEmployees();
		return Response.ok(gson.toJson(dtos)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(
		@PathParam("id") int id
	) {
		EmployeeDTO employee = ef.getEmployeeById(id);
		return Response.ok(gson.toJson(employee)).build();
	}

	@Path("/highestpaid")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHighestPaidEmployees() {
		List<EmployeeDTO> dtos = ef.getEmployeesWithHighestSalary();
		return Response.ok(gson.toJson(dtos)).build();
	}

	@Path("/highestpaid/{salary}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeesWithSalaryOver(
		@PathParam("salary") int salary
	) {
		List<EmployeeDTO> dtos = ef.getEmployeesWithSalary(salary);
		return Response.ok(gson.toJson(dtos)).build();
	}

	@Path("/name/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByName(
		@PathParam("name") String name
	) {
		List<EmployeeDTO> dtos = ef.getEmployeesByName(name);
		return Response.ok(gson.toJson(dtos)).build();
	}
}
