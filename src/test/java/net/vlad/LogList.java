package net.vlad;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

/**
 * Created by vlad on 6/28/16.
 */
@Slf4j
public class LogList {

    @ClassRule
    public static ListLoggerRule rule = new ListLoggerRule();

    @Before
    public void before() throws Exception {
       rule.before();
    }

    @After
    public void after() {
      rule.after();
    }


    @Test
    public void xxx() {
        log.info("my info");
        log.error("my error");
        //Assert.assertTrue("check log message", contains("my info"));
        Assert.assertTrue("check log message", rule.contains("my info"));
    }
}
