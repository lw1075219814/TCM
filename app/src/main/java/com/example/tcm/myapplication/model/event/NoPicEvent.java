package com.example.tcm.myapplication.model.event;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/28 18:19
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/28 18:19
 * @see
 */
public class NoPicEvent {
    private boolean isNoPic;

    public NoPicEvent() {
    }

    public NoPicEvent(boolean isNoPic) {
        this.isNoPic = isNoPic;
    }

    public boolean isNoPic() {
        return isNoPic;
    }

    public void setNoPic(boolean noPic) {
        isNoPic = noPic;
    }
}
