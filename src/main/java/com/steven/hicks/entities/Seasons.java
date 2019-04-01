package com.steven.hicks.entities;

import java.util.stream.Stream;

public enum Seasons
{
    WINTER(0),
    SPRING(1),
    SUMMER(2),
    FALL(3);

    private int seq;

    public int getSeq()
    {
        return seq;
    }

    public void setSeq(int seq)
    {
        this.seq = seq;
    }

    Seasons(int seq)
    {
        this.seq = seq;
    }

    public static Seasons getSeasonsFromValue(int value)
    {
        return Stream.of(values()).filter(x -> x.getSeq() == value).findFirst().orElse(null);
    }
}
