package lu.uni.lassy.excalibur.examples.icrash.dev.model.actors;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActHospital;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActProxyHospital;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntHasServerSideActor;
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
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.RmiUtils;

public class ActProxyHospitalImpl extends UnicastRemoteObject implements
	ActProxyHospital, JIntHasServerSideActor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 227L;
	
	private String name;
	
	ActHospital serverSideActor;

	public ActProxyHospitalImpl(ActHospital serverSideActor) throws RemoteException,NotBoundException {
		super(RmiUtils.getInstance().getPortClient());
		this.serverSideActor = serverSideActor;
		name = serverSideActor.getName();
		if(serverSideActor != null)
			serverSideActor.addListener(this);
	}

	public void destroy() throws RemoteException, NotBoundException {
		if(serverSideActor != null)
			serverSideActor.removeListener(this);
		
	}

	public String getName() throws RemoteException {
		return name;
	}

	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber) throws RemoteException, NotBoundException {
		if(serverSideActor != null)
			return serverSideActor.oeCallNumber(aDtPhoneNumber);
		else
			return new PtBoolean(false);
	}

	public PtBoolean oeSendBack(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus) {
		if(serverSideActor != null)
			return serverSideActor.oeSendBack(aDtCrisisID, aEtCrisisStatus);
		else
			return new PtBoolean(false);
	}

	public PtBoolean oeTreated(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus) {
		if(serverSideActor != null)
			return serverSideActor.oeTreated(aDtCrisisID, aEtCrisisStatus);
		else
			return new PtBoolean(false);
	}

	public PtBoolean ieReceiveCrisis(EtService aEtService, DtCrisisID aDtCrisisID, DtDateAndTime aDtDateAndTime,
			EtCrisisType aEtCrisisType, EtCrisisCategory aEtCrisisCategory, DtPhoneNumber aDtPhoneNumber,
			DtGPSLocation aDtGPSLocation, DtComment aDtComment) {
		// TODO Auto-generated method stub
		return null;
	}

}
