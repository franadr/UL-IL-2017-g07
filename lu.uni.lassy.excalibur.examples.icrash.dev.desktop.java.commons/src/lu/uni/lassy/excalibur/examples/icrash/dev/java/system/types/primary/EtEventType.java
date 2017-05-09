package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIs;

/**
 * Created by Adriano on 09-05-17.
 */
public enum EtEventType  {
    /**The event is of type Crisis (new crisis creation, crisis status changed) */
    Crisis,
    /**The event is of type Alert (new alert arrived, alert dismiss) */
    Alert,
    /**The event is of type System (login, logout) */
    System
}
