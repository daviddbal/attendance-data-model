package net.balsoftware.attendance.model;

import java.time.ZonedDateTime;
import java.util.Collection;

public class Event {
    private Teacher teacher;
    private Collection<Student> students;
    private ZonedDateTime timeOccurred;
    private String name;
}
