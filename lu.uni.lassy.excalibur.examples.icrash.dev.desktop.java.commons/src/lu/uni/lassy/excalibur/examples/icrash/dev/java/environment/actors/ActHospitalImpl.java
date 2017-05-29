package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtCrisisID;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.RmiUtils;

public class ActHospitalImpl extends UnicastRemoteObject implements ActHospital{

	/**
	 * 
	 */
	private static final long serialVersionUID = 16L;
	private String _name;
	
	public ActHospitalImpl(String name) throws RemoteException {
		super(RmiUtils.getInstance().getPort());
		_name = name;
	}

	public String getName() {
		if(_name == null || _name.trim() == "")
			return "NoName";
		else
			return _name;
	}

	@Override
	public void addListener(ActProxyHospital actProxyHospital) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(ActProxyHospital actProxyHospital) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PtBoolean oeSendBack(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PtBoolean oeTreated(DtCrisisID aDtCrisisID, EtCrisisStatus aEtCrisisStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
