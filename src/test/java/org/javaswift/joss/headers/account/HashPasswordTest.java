package org.javaswift.joss.headers.account;

import org.javaswift.joss.headers.AbstractHeaderTest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HashPasswordTest extends AbstractHeaderTest {

    @Test
    public void addHeader() {
        testHeader(new HashPassword("somepwd"));
    }

}
