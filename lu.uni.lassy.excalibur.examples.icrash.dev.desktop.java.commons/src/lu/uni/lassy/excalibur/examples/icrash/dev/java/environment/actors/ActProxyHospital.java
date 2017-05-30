package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIsActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtCrisis;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public interface ActProxyHospital extends Remote, JIntIsActor {
	
	public String getName() throws RemoteException;
	
	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber) throws RemoteException, NotBoundException;
	
	public PtBoolean oeSendBack(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus) throws RemoteException, NotBoundException;
	
	public PtBoolean oeTreated(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus) throws RemoteException, NotBoundException;
	
	public PtBoolean ieReceiveCrisis(CtCrisis aCtCrisis);
	

}
