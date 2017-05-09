package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtInteger;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;

import java.io.Serializable;

/**
 * Created by Adriano on 09-05-17.
 */
public class CtLogEntry implements Serializable {
    private static final long serialVersionUID = 227L;

    public PtInteger eId;

    public EtEventType eType;

    public PtString eText;

    public DtTime eTime;
    /**
     * Initialises/create the logEntry.
     *
     * @param aeid the id of the log entry
     * @param aeType the type of the log entry
     * @param aeText the details of the log entry
     * @param aeTime the time of the occurance
     *
     * @return the success of the initialisation
     */
    public PtBoolean createEntry(PtInteger aeid,EtEventType aeType,PtString aeText,DtTime aeTime){
        eId = aeid;
        eType=aeType;
        eText=aeText;
        eTime=aeTime;

        return new PtBoolean(true);
    }
}
