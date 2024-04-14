package employeemanagement.dao;

import java.util.List; 

import javax.persistence.EntityManager; 
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import employeemanagement.dto.Employee;


@Repository
public class EmployeeDAO {
	EntityManager em = Persistence.createEntityManagerFactory("sai").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Employee saveEmployee(Employee employee) throws Exception{
		et.begin();
		em.persist(employee);
		et.commit();
		return employee;
	}
	public Employee fetchByEmail(String email) throws Exception{
		Query q=em.createQuery("select e from Employee e where e.email=?1");
		q.setParameter(1, email);
		return (Employee)q.getSingleResult();
	}
	public Employee fetchById(int id) {
		Employee ob = em.find(Employee.class,id);
		return ob;
	}
	public List<Employee> fetchAll() {
		Query q=em.createQuery("select e from Employee e");
		List<Employee> res = q.getResultList();
		return res;
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee e = em.find(Employee.class, employee.getId());
		if(e!=null) {
			et.begin();
			em.merge(employee);
			et.commit();
		}
		
		return e;
	}
	
	public Employee deleteEmployee(Employee employee) {
		et.begin();
		em.remove(employee);
		et.commit();
		
		return employee;
	}
}
