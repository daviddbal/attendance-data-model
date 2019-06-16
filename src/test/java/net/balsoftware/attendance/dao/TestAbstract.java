package net.balsoftware.attendance.dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestAbstract {
    protected static Injector injector;

    @BeforeClass
    public static void setupGuiceInjector() {
        injector = Guice.createInjector(new AttendanceTestModule());
    }

    @AfterClass
    public static void tearDown() {
        injector = null;
    }
}
