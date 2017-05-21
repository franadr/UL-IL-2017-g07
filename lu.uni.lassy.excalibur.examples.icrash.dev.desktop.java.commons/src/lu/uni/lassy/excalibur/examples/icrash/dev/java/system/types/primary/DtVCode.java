package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtString;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;

public class DtVCode  extends DtString implements JIntIs{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 227L;

	/**
	 * Instantiates a new datatype verification code.
	 *
	 * @param s The primitive type of the string to create the datatype 
	 */
	public DtVCode(PtString s) {
		super(s);
	}
	
	/** The length of a verification code is fixed. */
	private int _Length = 6;
	
	
	/* (non-Javadoc)
	 * @see lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.DtIs#is()
	 */
	public PtBoolean is(){
		return new PtBoolean(this.value.getValue().length() == _Length);
	}
	
	/* (non-Javadoc)
	 * @see lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.DtIs#getExpectedDataStructure()
	 */
	public PtString getExpectedDataStructure(){
		return new PtString("Expected strucutre of the password is to have a minimum length of " + _Length); 
	}
}