package net.vlad;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by vlad on 6/24/16.
 */
@Slf4j
public class LogTest {
    @Test
    public void test() {
        log.info("sss");
        try {
            throw new RuntimeException("fuck") ;
        } catch (Exception ex) {
            log.error("very baad", ex);
        }

    }
}
