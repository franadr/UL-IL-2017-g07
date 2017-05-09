package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

}
