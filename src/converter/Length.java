package converter;
/**
 * Get all Length unit and a standard unit is meter.
 * @author Patcharapol Nirunpornputta
 *
 */
public enum Length {
	Mile(1609.344), Kilometer(1000.0), Meter(1.0), Centimeter(0.01), foot(0.3048), wa(2), AU(149597870700.0);
	private final double value;

	/**
	 * Initialize length unit.
	 * @param value is a value of length unit.
	 */
	private Length(double value) {
		this.value = value;
	}

	/**
	 * @return a value of length unit.
	 */
	public double getValue() {
		return this.value;
	}
}
