package com.heartrate.hrmonitor.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"},
        d2 = {"Lcom/heartrate/hrmonitor/model/TMT;", "", "timestampString", "", "(J)V", "getTimestampString", "()J", "setTimestampString", "value", "", "getValue", "()I", "setValue", "(I)V", "toString", "", "app"}
)
public final class TMT {
    private int value;
    private long timestampString;

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int var1) {
        this.value = var1;
    }

    @NotNull
    public String toString() {
        return "timestamp:" + this.timestampString + " , value:" + this.value + '\n';
    }

    public final long getTimestampString() {
        return this.timestampString;
    }

    public final void setTimestampString(long var1) {
        this.timestampString = var1;
    }

    public TMT(long timestampString) {
        this.timestampString = timestampString;
    }
}

