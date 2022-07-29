package es.project.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creacion de objetos de tipo Empleado
		//Empleados EmpleadoEx = new DirectorEmpleados();
	
		//Uso de los objetos creados
		
		//System.out.println(EmpleadoEx.getTareas());
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		//
		Empleados examp = contexto.getBean("miEmpleado", Empleados.class);
		System.out.println(examp.getTareas());
		
		//una vez ya obtenido el bean hay que cerrarlo
		
		contexto.close();
		
		
	}

}
