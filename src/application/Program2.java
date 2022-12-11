package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = new Department();
		
		System.out.println("Teste 1 ======Find by Id======");
		department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\nTeste 2 ======Find All======");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\nTeste 3 ======Insert======");
		System.out.print("Informe o nome do novo departamento: ");
		String nameDepartment = sc.next();
		Department newDepartment = new Department(null, nameDepartment);
		departmentDao.insert(newDepartment);
		System.out.println("Inclusão completa! New id = " + newDepartment.getId());
		
		System.out.println("\nTeste 4 ======Update======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("update concluido");
		
		
		System.out.print("Informe um Departamento para atualizar: ");
		int atualizarDp = sc.nextInt();
		Department department2 = departmentDao.findById(atualizarDp);
		System.out.print("Novo nome: ");
		String newNameDepartment = sc.next();
		department2.setName(newNameDepartment);
		departmentDao.update(department2);
		System.out.println("update concluido");
		
		System.out.println("\nTeste 5 ======Delete by Id======");
		System.out.print("Entre com Id para deletar: ");
		int delId = sc.nextInt();
		departmentDao.deleteById(delId);
		System.out.println("Delete Completo");
		
		sc.close();
	}

}
