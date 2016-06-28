package net.vlad;

import org.apache.logging.log4j.junit.LoggerContextRule;
import org.apache.logging.log4j.test.appender.ListAppender;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by vlad on 6/28/16.
 */
public class ListLoggerRule implements TestRule {
    private static final String CONFIG = "log4j-list.xml";
    public static LoggerContextRule context = new LoggerContextRule(CONFIG);
    private ListAppender listAppender;

    public ListLoggerRule() {
    }
    public void before() {
        this.listAppender = context.getListAppender("List");
    }
    public void after() {
        listAppender.clear();
    }
    public boolean contains(String msg) {
        for(String s: listAppender.getMessages()) {
            if(s.contains(msg))
                return true;
        }
        return false;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return context.apply(base, description);
    }
}
