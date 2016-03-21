
package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

  private static Logger myLogger;
  private static FileHandler myLogFile;

  public static Logger getLogger() {
	    if (myLogger == null) {
	      init();
	      return myLogger;
	    }

	    return myLogger;
	  }

  public static void close() 
  {
	    if (myLogger == null) 
	    {
	      return ;
	    }
	    
	     myLogger.removeHandler(myLogFile);
  }

  private static void init() {
	try {
		myLogFile = new FileHandler("Data/myGardenLog.txt", true);
	} 
	catch (SecurityException | IOException e) {
		e.printStackTrace();
	}
    myLogFile.setFormatter(new LogFormat());
    myLogger = Logger.getLogger("MyLogger");
    myLogger.addHandler(myLogFile);
    myLogger.setLevel(Level.ALL);
    myLogger.log(Level.CONFIG, "Logger: logger created");
  }

}
