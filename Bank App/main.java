
import java.util.Scanner;

public class Main {

	/*
	 * Para solventar algunos errores con el flujo de datos
	 * que crea la clase Scanner, instancio el objeto 
	 * 
	 * */
	public static Scanner sc = new Scanner(System.in);
	
	//Variable de objeto
	private static Cuenta cuenta;
	
	public static void main(String[] args) {

		//Iniciamos la creacion de usuario
		user();
		
		//Creamos el recorrido del menú
		int option;
		do { 
			muestraMenu();
			option = sc.nextInt();
			switch (option) {
			case 1: 
				gasto();
				break;
			case 2: 
				ingreso();
				break;
			case 3: 
				mostrarGastos();
				break;
			case 4:
				mostrarIngresos();
				break;
			case 5: 
				mostrarSaldo();
				break;
			case 0:
				exit();
				break;
			default:
				System.out.println("Error inesperado.");
			}
		} while (option != 0);

	}
	

	//Funcion para crear usuarios
	private static void user() {
		
		Usuario user = new Usuario();
		
		System.out.println("Introduzca un nombre de usuario: ");
		String usuario = sc.nextLine();
		user.setNombre(usuario);
		
		System.out.println("Introduzca su edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		user.setEdad(edad);	
			//Checkeo DNI
		boolean okDNI = false;
		do {
			System.out.println("Ingrese su número nacional de identidad: ");
			String validaDNI = sc.nextLine();
			if (user.setDNI(validaDNI)) {
				okDNI = true;
			} else {
				System.out.println("El DNI introducido no es correcto, revise los datos introducidos.");
			}
		} while (!okDNI);
		
		System.out.println(user.toString());
		//Instancio Cuenta y 
		//pasamos por parametro el usuario que acabamos de crear
		cuenta = new Cuenta(user);
		
	}
	
	/*
	 * Creamos funciones y métodos útiles 
	 * para acceder a los métodos de las clases
	 * 
	 * */
	
	public static String euro(double number) {
	    String formatted = String.format("%.2f", number);
	    return formatted.replace(".", ",").concat("€");
	}
	
	public static void muestraMenu() {
		
		System.out.println("Realiza una nueva acción.");
		System.out.println("(1) Introducir un nuevo gasto");
		System.out.println("(2) Introducir un nuevo ingreso");
		System.out.println("(3) Mostrar gastos.");
		System.out.println("(4) Mostrar ingresos.");
		System.out.println("(5) Mostrar saldo.");
		System.out.println("(0) Salir.");
		
	} 
	
	private static void mostrarSaldo() {
		System.out.println("Saldo actual: [ " + euro(cuenta.getSaldo()) + " ]");
	}

	private static void ingreso() {
		
		System.out.println("Concepto: ");
		String concepto = sc.nextLine();
		sc.nextLine();
		System.out.println("Cantidad que desea ingresar: ");
		double cantidad =  sc.nextDouble();
		sc.nextLine();
		double saldo = cuenta.addIngresos(concepto, cantidad);
		System.out.println("Saldo actual de su cuenta corriente: " + euro(cuenta.getSaldo()));
		
	}
	
	private static void gasto() {
		
		System.out.println("Concepto: ");
		String concepto = sc.nextLine();
		sc.nextLine();
		System.out.println("Cantidad: ");
		double cantidad = sc.nextDouble();
		sc.nextLine();
		
		try {
			double saldo = cuenta.addGastos(concepto, cantidad);
			System.out.println("Saldo actual de su cuenta corriente: " + euro(saldo));
		} 
		catch (GastoException e) {
			System.out.println(e.getMessage()); //---->>>CAPTURA ERROR
		} 
		
	}
	
	private static void mostrarIngresos() {
		for(int i = 0; i < cuenta.getIngresos().size(); i++) {
			System.out.println(cuenta.getIngresos().get(i));
		}

	}
	
	private static void mostrarGastos() {
		
		for(int i = 0; i < cuenta.getGastos().size(); i++) {
			System.out.println(cuenta.getGastos().get(i));
		}
	
	}
		
	private static void exit() {
		System.out.println("Fin del programa.\r\n"
				+ "Gracias por utilizar la aplicación de M03B en el curso 2s2223.");
	}

}

