package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import java.util.regex.Pattern;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtString;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;

public class DtHospitalName extends DtString implements JIntIs{
	
	/** The constant serialVersionUID. */
	private static final long serialVersionUID = 227L;

	/**
	 * Instantiates a new name for the hospital.
	 * @param The primitive type of the string to create the datatype 
	 */
	public DtHospitalName(PtString s) {
		super(s);
	}

	@Override
	public PtBoolean is() {
		return new PtBoolean(Pattern.matches("[a-zA-Z0-9]", this.value.getValue().toString()));
	}
	
	public PtString getExpectedDataStructure(){
		return new PtString("Expected structure of the name is composed of letters and numbers "); 
	}

}
