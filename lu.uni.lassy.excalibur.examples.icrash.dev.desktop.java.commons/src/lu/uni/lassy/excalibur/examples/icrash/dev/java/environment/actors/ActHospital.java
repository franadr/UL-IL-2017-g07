package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtCrisisID;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public interface ActHospital {

	public String getName() throws RemoteException;

	public void addListener(ActProxyHospital actProxyHospital) throws RemoteException, NotBoundException;

	public void removeListener(ActProxyHospital actProxyHospital) throws RemoteException, NotBoundException;

	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber);

	public PtBoolean oeSendBack(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus);

	public PtBoolean oeTreated(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus);

}
