
public class Gasto extends Dinero {
	
	public Gasto(double gasto, String description) {
		this.setDinero(gasto);
		super.setDescription(description);
	}
	

	@Override
	
	public String toString() { 
		return "Monto del cargo: " + Main.euro(this.getDinero()) + "\nConcepto: " + super.getDescription();
	}

}
