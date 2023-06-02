import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	//Atributos
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	//Constructor con parámetro 
	public Cuenta(Usuario usuario) {
		
		//inicializo las variables de clase
		this.saldo = 0.0;
		this.usuario = usuario;
		//inicializo las colecciones del constructor
		this.ingresos = new ArrayList<>();
		this.gastos = new ArrayList<>();
		
	}
	
	public void setSaldo(double saldo) { this.saldo =  saldo; }
	public double getSaldo() { return this.saldo; }
	
	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	public Usuario getUsuario() { return usuario; }
	
	public double addIngresos(String description, double cantidad) { 
		
		ingresos.add(new Ingreso(cantidad, description));
		this.saldo += cantidad;
		return this.getSaldo();
	}
	
	public double addGastos(String description, double cantidad) throws GastoException { 
		
		if(cantidad > this.getSaldo()) {
			throw new GastoException();
		}
		gastos.add(new Gasto(cantidad, description));
		
		this.saldo -= cantidad;
		return this.getSaldo();
	}
	
	public List<Ingreso> getIngresos(){ return ingresos; }
	public List<Gasto> getGastos() { return gastos; }
	
	@Override 
	
	public String toString() {
		return "Titular cuenta corriente " + "[" + this.getUsuario() + "]" + "\nSaldo: " + Main.euro(this.getSaldo());
	}
	
	

}
