package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.security.SecureRandom;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActCoordinator;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtDateAndTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;

public class CtVCode implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 227L;

	/** The verification code */
	public DtVCode vCode;
		
	/** The date and time of the initialization of the instance */
	public DtDateAndTime instant;
	
	/** The boolean indicating whether the verification has been successfully used or not */
	public PtBoolean isValidated;

	/**
	 * Initialises the verification code.
	 * @param aInstant the date and time of the initialization of the instance
	 * @param aPtBolean the boolean indicating whether the instance has been validated or not
	 * @return the success of the initialisation of the alert
	 */
	public PtBoolean init(DtDateAndTime aInstant, PtBoolean aPtBoolean) {
			
		vCode = new DtVCode(new PtString(randomString(6)));
		instant = aInstant;
		isValidated = aPtBoolean;
		
		return new PtBoolean(true);
	}
	
	/**
	 * Initialises the verification code.
	 * @param aDtVCode the vCode which we use to initialise the instance
	 * @param aInstant the date and time of the initialization of the instance
	 * @param aPtBolean the boolean indicating whether the instance has been validated or not
	 * @return the success of the initialisation of the alert
	 */
	public PtBoolean init(DtVCode aDtVCode, DtDateAndTime aInstant, PtBoolean aPtBoolean) {
			
		vCode = aDtVCode;
		instant = aInstant;
		isValidated = aPtBoolean;
		
		return new PtBoolean(true);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.vCode.value.getValue();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof CtVCode))
			return false;
		CtVCode aCtVCode = (CtVCode)obj;
		if (!(aCtVCode.vCode.value.getValue().equals(this.vCode.value.getValue())))
			return false;
		if (!(aCtVCode.instant.toString().equals(this.instant.toString())))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return this.vCode.value.getValue().length();
	}
	
	/*
	 * Generating a random verification code
	 */
	static final String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();

	private String randomString(int length){
	   StringBuilder sb = new StringBuilder( length );
	   for( int i = 0; i < length; i++ ) 
	      sb.append( LETTERS.charAt( rnd.nextInt(LETTERS.length()) ) );
	   return sb.toString();
	}
}
