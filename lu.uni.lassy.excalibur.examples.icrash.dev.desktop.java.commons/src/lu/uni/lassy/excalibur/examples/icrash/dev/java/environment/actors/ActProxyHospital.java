package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtComment;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtCrisisID;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtGPSLocation;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisCategory;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisType;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtService;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtDateAndTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public interface ActProxyHospital extends Remote, JIntIsActor {
	
	public String getName() throws RemoteException;
	
	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber) throws RemoteException, NotBoundException;
	
	public PtBoolean oeSendBack(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus);
	
	public PtBoolean oeTreated(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus);
	
	public PtBoolean ieReceiveCrisis(EtService aEtService, DtCrisisID aDtCrisisID,
									DtDateAndTime aDtDateAndTime, EtCrisisType aEtCrisisType,
									EtCrisisCategory aEtCrisisCategory, DtPhoneNumber aDtPhoneNumber,
									DtGPSLocation aDtGPSLocation, DtComment aDtComment);
	

}
