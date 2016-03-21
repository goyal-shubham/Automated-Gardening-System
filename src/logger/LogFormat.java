package logger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import application.MyTimer;

public class LogFormat extends Formatter {
	
	private static SimpleDateFormat date = new SimpleDateFormat(
		      "MM-dd mm:ss");

		  /*
		   * (non-Javadoc)
		   * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
		   */
		  @Override
		  public String format(LogRecord myLogRecord) {
		    StringBuilder sb = new StringBuilder();
		    sb.append("\n" + myLogRecord.getLevel() + "\t " + date.format(new Date(myLogRecord.getMillis())) );
		    sb.append("\t "+ "Day : " + MyTimer.getDay()+ "\t "+ "Garden Time: " + MyTimer.getHour());
		    sb.append(" \t "+ myLogRecord.getMessage());
		    return sb.toString();
		  }

}
