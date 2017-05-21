package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActComCompany;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.environment.actors.ActComCompanyImpl;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtHuman;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.CtVCode;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtPhoneNumber;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.DtVCode;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary.EtHumanKind;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtDate;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtDateAndTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.DtTime;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtString;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.utils.ICrashUtils;

public class DbVCode  extends DbAbstract{

	/**
	 * Insert verification code into the database.
	 *
	 * @param aCtVCode The CtVcode of which to use the information to insert into the database
	 */
	static public void insertVCode(CtVCode aCtVCode){
	
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			log.debug("Connected to the database");

			/********************/
			//Insert
			
			try{
				Statement st = conn.createStatement();
				
				String vcode = aCtVCode.vCode.value.getValue();
				
				int year = aCtVCode.instant.date.year.value.getValue();
				int month = aCtVCode.instant.date.month.value.getValue();
				int day = aCtVCode.instant.date.day.value.getValue();

				int hour = aCtVCode.instant.time.hour.value.getValue();
				int min = aCtVCode.instant.time.minute.value.getValue();
				int sec = aCtVCode.instant.time.second.value.getValue();
				
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Calendar calendar = new GregorianCalendar(year, month, day,
						hour, min, sec);
				String instant = sdf.format(calendar.getTime());
				
				Byte isValidated = (byte) (aCtVCode.isValidated.getValue() ? 1 : 0 );
	
				log.debug("[DATABASE]-Insert human");
				int val = st.executeUpdate("INSERT INTO "+ dbName+ ".vcode" +
											"(vcode,instant,isValidated)" + 
											"VALUES("+"'"+vcode+"','"+instant+"','"+isValidated+"')");
				
				log.debug(val + " row affected");
			}
			catch (SQLException s){
				log.error("SQL statement is not executed! "+s);
			}

	
			conn.close();
			log.debug("Disconnected from database");
		} catch (Exception e) {
			logException(e);
		}
	
	
	}
	
	/**
	 * Gets a vcode details from the database, using the vcode to retrieve the data.
	 *
	 * @param vcode The verification code to use to get the data from the database
	 * @return The vcode data that is retrieved from the database. This could be empty
	 */
	static public CtVCode getVCode(String vcode){
		
		CtVCode aCtVCode = new CtVCode();
		
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			log.debug("Connected to the database");

			/********************/
			//Select
			
			try{
				String sql = "SELECT * FROM "+ dbName + ".vcode WHERE vcode = " + vcode;

				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet  res = statement.executeQuery(sql);
				
				if(res.next()) {				
					
					aCtVCode = new CtVCode();
					//vcode's key
					DtVCode aDtVCode = new DtVCode(new PtString(res.getString("vCode")));
					//vcode's dateAndTime  
					Timestamp instant = res.getTimestamp("dateAndTime");
					Calendar cal = Calendar.getInstance();
					cal.setTime(instant);

					int d = cal.get(Calendar.DATE);
					int m = cal.get(Calendar.MONTH);
					int y = cal.get(Calendar.YEAR);
					DtDate aDtDate = ICrashUtils.setDate(y, m, d);
					int h = cal.get(Calendar.HOUR_OF_DAY);
					int min = cal.get(Calendar.MINUTE);
					int sec = cal.get(Calendar.SECOND);
					DtTime aDtTime = ICrashUtils.setTime(h, min, sec);
					DtDateAndTime aInstant = new DtDateAndTime(aDtDate, aDtTime);
					
					//vcode's boolean
					PtBoolean aIsValidated;
					int tmpIsValidated = res.getInt("isValidated");
					if(tmpIsValidated == 1)
						aIsValidated = new PtBoolean(true);
					else
						aIsValidated = new PtBoolean(false);

					aCtVCode.init(aDtVCode,aInstant, aIsValidated);
					
				}
								
			}
			catch (SQLException s){
				log.error("SQL statement is not executed! "+s);
			}
			conn.close();
			log.debug("Disconnected from database");
			
			
		} catch (Exception e) {
			logException(e);
		}
		
		return aCtVCode;
	}
	
	/**
	 * Gets all verifications codes from the database.
	 *
	 * @return A hashtable of the verification codes using their vcode as a key value
	 */
	static public Hashtable<String, CtVCode> getSystemVCodes(){
	
		Hashtable<String, CtVCode> cmpSystemCtVCode = new Hashtable<String, CtVCode>();
		
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			log.debug("Connected to the database");

			

			/********************/
			//Select
			
			try{
				String sql = "SELECT * FROM "+ dbName + ".vcode ";
				

				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet  res = statement.executeQuery(sql);
				
				CtVCode aCtVCode = null;
				
				while(res.next()) {				
					
					aCtVCode = new CtVCode();
					//vcode's key
					DtVCode aDtVCode = new DtVCode(new PtString(res.getString("vCode")));
					//vcode's dateAndTime  
					Timestamp instant = res.getTimestamp("dateAndTime");
					Calendar cal = Calendar.getInstance();
					cal.setTime(instant);

					int d = cal.get(Calendar.DATE);
					int m = cal.get(Calendar.MONTH);
					int y = cal.get(Calendar.YEAR);
					DtDate aDtDate = ICrashUtils.setDate(y, m, d);
					int h = cal.get(Calendar.HOUR_OF_DAY);
					int min = cal.get(Calendar.MINUTE);
					int sec = cal.get(Calendar.SECOND);
					DtTime aDtTime = ICrashUtils.setTime(h, min, sec);
					DtDateAndTime aInstant = new DtDateAndTime(aDtDate, aDtTime);
					
					//vcode's boolean
					PtBoolean aIsValidated;
					int tmpIsValidated = res.getInt("isValidated");
					if(tmpIsValidated == 1)
						aIsValidated = new PtBoolean(true);
					else
						aIsValidated = new PtBoolean(false);

					aCtVCode.init(aDtVCode,aInstant, aIsValidated);
					
					//add instance to the hash
					cmpSystemCtVCode.put(aCtVCode.vCode.value.getValue(), aCtVCode);
					
				}
				
								
			}
			catch (SQLException s){
				log.error("SQL statement is not executed! "+s);
			}
			conn.close();
			log.debug("Disconnected from database");
			
			
		} catch (Exception e) {
			logException(e);
		}
		
		return cmpSystemCtVCode;
		
	}
	
	
	/**
	 * Deletes a verification code from the database.
	 *
	 * @param aCtVCode The verification code to delete from the database, it will use the vcode to delete the row
	 */
	static public void deleteVCode(CtVCode aCtVCode){
	
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			log.debug("Connected to the database");

			/********************/
			//Delete
			
			try{
				String sql = "DELETE FROM "+ dbName+ ".vcode WHERE vCode = ?";
				String vCode = aCtVCode.vCode.value.getValue();

				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, vCode);
				int rows = statement.executeUpdate();
				log.debug(rows+" row deleted");				
			}
			catch (SQLException s){
				log.error("SQL statement is not executed! "+s);
			}


			conn.close();
			log.debug("Disconnected from database");
		} catch (Exception e) {
			logException(e);
		}
	}
}
