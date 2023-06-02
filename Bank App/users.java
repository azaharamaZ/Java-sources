
public class Usuario {
	private String nombre;
	private int edad;
	private String DNI;
	
	//Construct
	public Usuario() {
		
	}
	
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean setDNI(String DNI) {
		String checkDNI = "^[0-9]{8}-?[A-Z$]";
		if(DNI.matches(checkDNI)) {
			this.DNI = DNI;
			return true;
		} else {
			return false;
		}
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getDNI() {
		return DNI; 
	}
	
	@Override
	
	public String toString() {
		return "Nombre: " + nombre + "\nDNI: " + DNI + "\nEdad: " + edad;
	}
}
