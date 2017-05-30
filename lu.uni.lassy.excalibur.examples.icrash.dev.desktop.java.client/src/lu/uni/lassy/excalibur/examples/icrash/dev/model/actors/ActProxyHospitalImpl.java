package lu.uni.lassy.excalibur.examples.icrash.dev.model.actors;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActHospital;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActProxyHospital;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntHasServerSideActor;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtCrisis;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtCrisisStatus;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.RmiUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.Message;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.Message.MessageType;

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

	public PtBoolean oeCallNumber(DtPhoneNumber aDtPhoneNumber){
		if(serverSideActor != null)
			return serverSideActor.oeCallNumber(aDtPhoneNumber);
		else
			return new PtBoolean(false);
	}

	public PtBoolean oeSendBack(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus) 
			throws RemoteException, NotBoundException{
		
		if(serverSideActor != null)
			return serverSideActor.oeSendBack(aCtCrisis, aEtCrisisStatus);
		else
			return new PtBoolean(false);
	}

	public PtBoolean oeTreated(CtCrisis aCtCrisis, EtCrisisStatus aEtCrisisStatus)
			throws RemoteException, NotBoundException{
		if(serverSideActor != null)
			return serverSideActor.oeTreated(aCtCrisis, aEtCrisisStatus);
		else
			return new PtBoolean(false);
	}
	
	private Hashtable<String, CtCrisis> _listOfCtCrisis = new Hashtable<String, CtCrisis>();
	
	public ObservableMap<String, CtCrisis> MapOfCtCrisis = FXCollections.observableMap(_listOfCtCrisis);

	public PtBoolean ieReceiveCrisis(CtCrisis aCtCrisis) {
		Logger log = Log4JUtils.getInstance().getLogger();
		
		log.info("message ActHospital.ieReceiveCrisis received from system");
		log.info("crisis id '" + aCtCrisis.id.value.getValue().toString()
				+ "' " + "in status '" + aCtCrisis.status.toString() + "'");
		listOfMessages.add(new Message(MessageType.ieRecieveCrisis, "Crisis " + aCtCrisis.id.value.getValue() + " was received by " + name));
		this.MapOfCtCrisis.put(aCtCrisis.id.value.getValue(), aCtCrisis);
		return new PtBoolean(true);
	}
	private ArrayList<Message> _listOfMessages = new ArrayList<Message>();
	
	public ObservableList<Message> listOfMessages = FXCollections.observableArrayList(_listOfMessages);

}
