package compound;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// enum for Defining the Log Level
enum LogLevel {
    INFO,
    WARNING,
    DEBUG,
    ERROR
}

// Defines the contract for logging with different severity levels to ensure consistent logging interface across implementations.
interface Logger {
    void loginfo(String message);

    void logerror(String message);

    void logwarning(String message);

    void logdebug(String message);
}

// Manages a collection of loggers and provides iteration capability to apply logging operations across multiple logger instances.
class LoggerCollection implements Iterable<BaseLogger> {
    private final ArrayList<BaseLogger> loggers = new ArrayList<>();

    public void addLogger(BaseLogger logger) {
        this.loggers.add(logger);
    }

    @Override
    public Iterator<BaseLogger> iterator() {
        return this.loggers.iterator();
    }
}

// Abstract base class that implements the Logger interface and provides common functionality for delegating log messages to multiple loggers using the Composite pattern.
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

// Concrete logger implementation that writes log messages to the console for real-time visibility of application events.
class ConsoleLogger extends BaseLogger {

    @Override
    public void write(String message, LogLevel level) {
        System.out.printf("%s - %s%n", level.toString(), message);
    }
}

// Concrete logger implementation that persists log messages to a file for permanent record and future analysis of application behavior.
class FileLogger extends BaseLogger {

    @Override
    public void write(String message, LogLevel level) {
        try {
            FileWriter writer = new FileWriter("./app.log",true);
            writer.write("%s - %s\n".formatted(level.toString(), message
            ));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

// Concrete logger implementation that formats and outputs log messages with an application-specific prefix for identification.
class ApplicationLogger extends BaseLogger {
    @Override
    public void write(String message, LogLevel level) {
        System.out.printf("App - %s - %s%n", level.toString(), message);
    }
}

// Factory pattern implementation that creates and maintains a singleton logger instance with multiple composed loggers for unified logging across the application.
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

// Main entry point that demonstrates the compound logger system by logging messages at different severity levels through multiple logger implementations.
public class Logging {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger();

        logger.logdebug("Application Started");
        logger.loginfo("Application Initiated");
        logger.logerror("Application Failed");
        logger.logwarning("You Cannot Start Application Like These");

    }
}
