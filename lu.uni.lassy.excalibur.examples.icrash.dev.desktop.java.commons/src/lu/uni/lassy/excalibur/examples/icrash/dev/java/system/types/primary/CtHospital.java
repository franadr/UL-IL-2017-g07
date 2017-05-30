package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import java.io.Serializable;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public class CtHospital implements Serializable{

	/** The constant serialVersionUID. */
	private static final long serialVersionUID = 227L;
	
	/** The location of the hospital */
	public DtGPSLocation location;
	
	/** The name of the hospital */
	public DtHospitalName name;
	
	/** The service the hospital provides */
	public EtService service;
	
	/**
	 * Initialises the hospital information.
	 * @param aDtGPSLocation the location of the hospital
	 * @param aDtHospitalName the name of the hospital
	 * @param aEtService the service the hospital provides
	 * @return the success of the initialisation of the alert
	 */
	
	public PtBoolean init(DtGPSLocation aDtGPSLocation, DtHospitalName aDtHospitalName, EtService aEtService){
		
		location = aDtGPSLocation;
		name = aDtHospitalName;
		service = aEtService;
		
		return new PtBoolean(true);
		
	}

}
