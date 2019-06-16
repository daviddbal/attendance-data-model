package net.balsoftware.attendance.dao;

import com.google.inject.AbstractModule;
import net.balsoftware.attendance.connection.ConnectionHelper;

public class AttendanceTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ConnectionHelper.class).to(PostgresTestConnectionHelper.class);
    }
}
