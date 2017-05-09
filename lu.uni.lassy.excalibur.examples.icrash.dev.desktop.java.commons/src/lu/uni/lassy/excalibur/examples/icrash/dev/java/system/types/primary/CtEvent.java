package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtInteger;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;

import java.io.Serializable;

/**
 * Created by Adriano on 09-05-17.
 */
public class CtEvent implements Serializable {
    private static final long serialVersionUID = 227L;

    public PtInteger eventId;

    public EtEventType eventType;

    public PtString eventText;

    public DtTime eventTime;

/**
 * Initialises/create the envent.
 *
 * @param aeventid the id of the log entry
 * @param aeventType the type of the log entry
 * @param aeventText the details of the log entry
 * @param aeventTime the time of the occurance
 *
 * @return the success of the initialisation
 */

    public PtBoolean createEvent(PtInteger aeventid,EtEventType aeventType,PtString aeventText,DtTime aeventTime){
        eventId = aeventid;
        eventType=aeventType;
        eventText=aeventText;
        eventTime=aeventTime;

        return new PtBoolean(true);
    }
}
