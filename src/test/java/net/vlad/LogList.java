package net.vlad;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.junit.LoggerContextRule;
import org.apache.logging.log4j.test.appender.ListAppender;
import org.junit.*;

import java.util.List;

/**
 * Created by vlad on 6/28/16.
 */
@Slf4j
public class LogList {
    private static final String CONFIG = "log4j-list.xml";
    @ClassRule
    public static LoggerContextRule context = new LoggerContextRule(CONFIG);

    private ListAppender listAppender;

    @Before
    public void before() throws Exception {
        listAppender = context.getListAppender("List");
    }

    @After
    public void after() {
        listAppender.clear();
    }
    boolean contains(String msg) {
        for(String s: listAppender.getMessages()) {
            if(s.contains(msg))
                return true;
        }
        return false;
    }

    @Test
    public void xxx() {
        log.info("my info");
        log.error("my error");
/*
        List<String> list = listAppender.getMessages();
        for(String s: list) {
            System.out.println(s);
        }
*/
        Assert.assertTrue("check log message", contains("my info"));
    }
}
