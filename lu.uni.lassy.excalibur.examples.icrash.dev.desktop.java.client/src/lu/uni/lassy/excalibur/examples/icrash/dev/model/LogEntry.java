package lu.uni.lassy.excalibur.examples.icrash.dev.model;

import javafx.beans.property.IntegerProperty;

import java.util.Date;

/**
 * Created by Adriano on 14-05-17.
 */
public class LogEntry {



    private int logId;
    private String type;
    private String text;
    private Date date;

    public LogEntry(int logId, String type, String text, Date date) {
        this.logId = logId;
        this.type = type;
        this.text = text;
        this.date = date;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry logEntry = (LogEntry) o;

        if (logId != logEntry.logId) return false;
        if (type != null ? !type.equals(logEntry.type) : logEntry.type != null) return false;
        if (text != null ? !text.equals(logEntry.text) : logEntry.text != null) return false;
        return date != null ? date.equals(logEntry.date) : logEntry.date == null;
    }

//    @Override
//    public int hashCode() {
//        Integer result = logId;
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        result = 31 * result + (text != null ? text.hashCode() : 0);
//        result = 31 * result + (date != null ? date.hashCode() : 0);
//        return result;
//    }
}
