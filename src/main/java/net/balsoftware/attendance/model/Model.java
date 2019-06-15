package net.balsoftware.attendance.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public abstract class Model<T extends Model> {
    private int id;
    private ZonedDateTime createdTimestamp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(ZonedDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public T withId(int id) {
        this.id = id;
        return (T) this;
    }

    public T withCreatedTimestamp(ZonedDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return (T) this;
    }
}
