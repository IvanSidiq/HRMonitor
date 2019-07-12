package com.heartrate.hrmonitor.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0013"},
        d2 = {"Lcom/heartrate/hrmonitor/model/HeartRate;", "", "timestampString", "", "(J)V", "hrm_ir", "", "getHrm_ir", "()F", "setHrm_ir", "(F)V", "img_avg", "getHrm_red", "setHrm_red", "getTimestampString", "()J", "setTimestampString", "toString", "", "app"}
)
public final class HeartRate {

    private float img_avg;
    private long timestampString;

    public final float getImg_avg() {
        return this.img_avg;
    }

    public final void setImg_avg(float var1) {
        this.img_avg = var1;
    }

    @NotNull
    public String toString() {
        return "timestamp:" + this.timestampString + ", image avg: " + this.img_avg + '\n';
    }

    public final long getTimestampString() {
        return this.timestampString;
    }

    public final void setTimestampString(long var1) {
        this.timestampString = var1;
    }

    public HeartRate(long timestampString) {
        this.timestampString = timestampString;
    }
}

