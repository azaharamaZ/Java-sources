
public class Ingreso extends Dinero{
	
	public Ingreso(double ingreso, String description) {
		this.setDinero(ingreso);
		super.setDescription(description);
	}
	
	/*Override*/
	@Override
	
	public String toString() {
		return "Concepto: " + super.getDescription() + ", cantidad: " + Main.euro(this.getDinero());
	}
	
}
