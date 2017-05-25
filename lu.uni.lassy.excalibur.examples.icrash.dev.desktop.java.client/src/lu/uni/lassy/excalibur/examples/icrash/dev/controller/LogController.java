package lu.uni.lassy.excalibur.examples.icrash.dev.controller;

import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerNotBoundException;
import lu.uni.lassy.excalibur.examples.icrash.dev.controller.exceptions.ServerOfflineException;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtLogEntry;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.Log4JUtils;
import lu.uni.lassy.excalibur.examples.icrash.dev.model.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Adriano on 24-05-17.
 */
public class LogController {
    private Server server = Server.getInstance();

    public ArrayList<CtLogEntry> getListOfLogEntries() throws ServerOfflineException, ServerNotBoundException {
        try {
            return server.sys().getAllLogEntries();
        } catch (RemoteException e) {
            Log4JUtils.getInstance().getLogger().error(e);
            throw new ServerOfflineException();
        } catch (NotBoundException e) {
            Log4JUtils.getInstance().getLogger().error(e);
            throw new ServerNotBoundException();
        }
    }
}
