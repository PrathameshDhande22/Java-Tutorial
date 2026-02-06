package compound;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

enum LogLevel {
    INFO,
    WARNING,
    DEBUG,
    ERROR
}


interface Logger {
    void loginfo(String message);

    void logerror(String message);

    void logwarning(String message);

    void logdebug(String message);
}

class LoggerCollection implements Iterable<BaseLogger> {
    private ArrayList<BaseLogger> loggers = new ArrayList<>();

    public void addLogger(BaseLogger logger) {
        this.loggers.add(logger);
    }

    @Override
    public Iterator<BaseLogger> iterator() {
        return this.loggers.iterator();
    }
}

abstract class BaseLogger implements Logger {
    public abstract void write(String message, LogLevel level);

    protected LoggerCollection loggercollection = new LoggerCollection();

    public void addLogger(BaseLogger logger) {
        this.loggercollection.addLogger(logger);
    }

    private void logMessage(String message, LogLevel level) {
        Iterator<BaseLogger> loggeriterator = this.loggercollection.iterator();

        while (loggeriterator.hasNext()) {
            BaseLogger logger = loggeriterator.next();
            logger.log(level, message);
        }
    }

    public void log(LogLevel level, String message) {
        write(message, level);
    }

    @Override
    public void logdebug(String message) {
        logMessage(message, LogLevel.DEBUG);
    }

    @Override
    public void logerror(String message) {
        logMessage(message, LogLevel.ERROR);
    }

    @Override
    public void loginfo(String message) {
        logMessage(message, LogLevel.INFO);
    }

    @Override
    public void logwarning(String message) {
        logMessage(message, LogLevel.WARNING);
    }
}

class ConsoleLogger extends BaseLogger {

    @Override
    public void write(String message, LogLevel level) {
        System.out.printf("%s - %s%n", level.toString(), message);
    }
}

class FileLogger extends BaseLogger {

    @Override
    public void write(String message, LogLevel level) {
        try {
            FileWriter writer = new FileWriter("./app.log",true);
            writer.write("%s - %s".formatted(level.toString(), message
            ));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class ApplicationLogger extends BaseLogger {
    @Override
    public void write(String message, LogLevel level) {
        System.out.printf("App - %s - %s%n", level.toString(), message);
    }
}

class LoggerFactory {
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            BaseLogger rootlogger = new ApplicationLogger();
            rootlogger.addLogger(new ConsoleLogger());
            rootlogger.addLogger(new FileLogger());

            logger = rootlogger;
        }
        return logger;
    }
}

public class Logging {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger();

        logger.logdebug("Application Started");
        logger.loginfo("Application Initiated");
        logger.logerror("Application Failed");
        logger.logwarning("You Cannot Start Application Like These");

    }
}
