package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

public enum EtAuthenticatedStatus {
	    /**The actor is in the 1st Login Window */
	    isIn1stLoginPhase,
	    /**The actor is in the Window asking the phone number */
	    isInRequestPhone,
	    /**The actor is in the 2nd Login Window (with the verfication code)*/
	    isIn2ndLoginPhase,
	    /**The actor is in neither of the above windows */
	    isNotShown
	}