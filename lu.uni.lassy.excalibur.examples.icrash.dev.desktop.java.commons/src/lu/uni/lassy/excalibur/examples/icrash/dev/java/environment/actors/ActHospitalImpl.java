package lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.IcrashSystem;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtCrisis;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.RmiUtils;

public class ActHospitalImpl extends UnicastRemoteObject implements ActHospital{

	/**
	 * 
	 */
	private static final long serialVersionUID = 227L;
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
	
	protected List<ActProxyHospital> listeners = new ArrayList<ActProxyHospital>();

	@Override
	public void addListener(ActProxyHospital aActProxyHospital) throws RemoteException, NotBoundException {
		if (listeners.contains(aActProxyHospital))
			listeners.remove(aActProxyHospital);
		listeners.add(aActProxyHospital);
		
	}

	@Override
	public void removeListener(ActProxyHospital aActProxyHospital) throws RemoteException, NotBoundException {
		listeners.remove(aActProxyHospital);
		
	}

	@Override
	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber) {
		Logger log = Log4JUtils.getInstance().getLogger();
		
		log.info("Calling phone number: " + aDtPhoneNumber.toString());
		
		PtBoolean res = new PtBoolean(true);
		
		if(res.getValue() == true)
			log.info("operation oeCallNumber successfully executed");
		
		return res;
	}

	@Override
	synchronized public PtBoolean oeSendBack(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus) throws RemoteException, NotBoundException {
		Logger log = Log4JUtils.getInstance().getLogger();
		
		Registry registry = LocateRegistry.getRegistry(RmiUtils.getInstance().getHost(),RmiUtils.getInstance().getPort());
		
		IcrashSystem iCrashSys_Server = (IcrashSystem) registry.lookup("iCrashServer");
		
		iCrashSys_Server.setCurrentConnectedHospital(this);
		
		log.info("message ActHospital.oeSendBack sent to the system");
		PtBoolean res = iCrashSys_Server.oeSendBack(aCtCrisis, aEtCrisisStatus);
		
		if(res.getValue() == true)
			log.info("operation oeSendBack successfully executed by the system");
		
		return res;
	}

	@Override
	synchronized public PtBoolean oeTreated(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus) throws RemoteException, NotBoundException {
		Logger log = Log4JUtils.getInstance().getLogger();
		
		Registry registry = LocateRegistry.getRegistry(RmiUtils.getInstance().getHost(),RmiUtils.getInstance().getPort());
		
		IcrashSystem iCrashSys_Server = (IcrashSystem) registry.lookup("iCrashServer");
		
		iCrashSys_Server.setCurrentConnectedHospital(this);
		
		log.info("message ActHospital.oeSendBack sent to the system");
		PtBoolean res = iCrashSys_Server.oeTreated(aCtCrisis, aEtCrisisStatus);
		
		if(res.getValue() == true)
			log.info("operation oeTreated successfully executed by the system");
		
		return res;
	}

	@Override
	public PtBoolean ieReceiveCrisis(CtCrisis aCtCrisis) throws RemoteException {
		Logger log = Log4JUtils.getInstance().getLogger();

		log.info("message ActHospital.ieReceiveCrisis received from system");
		log.info("Crisis ID: " + aCtCrisis.id.toString());
		boolean messageSent = false;
		for (Iterator<ActProxyHospital> iterator = listeners.iterator(); iterator
				.hasNext();) {
			ActProxyHospital aProxy = iterator.next();
			aProxy.ieReceiveCrisis(aCtCrisis);
			messageSent = true;
		}
		return new PtBoolean(messageSent);
	}
	
	public String toString(){
		return this.getName();
	}
	
	public int hashCode(){
		return this.getName().length();
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof ActHospitalImpl))
			return false;
		ActHospitalImpl aActHospital = (ActHospitalImpl)obj;
		if (this._name != aActHospital._name)
			return false;
		if (!this.getName().equals(aActHospital.getName()))
			return false;
		return true;
	}
	
	

}
