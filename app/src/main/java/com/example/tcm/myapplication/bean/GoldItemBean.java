package com.example.tcm.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/4/28 16:09
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/4/28 16:09
 * @see
 */
@Entity
public class GoldItemBean implements Parcelable {

    @Id(autoincrement = true)
    private Long id;

    private int position;

    private boolean isSelect;

    @Keep
    public GoldItemBean(int position, boolean isSelet) {
        this.position = position;
        this.isSelect = isSelet;
    }

    @Keep
    @Generated(hash = 2130581356)
    public GoldItemBean(Long id, int position, boolean isSelet) {
        this.id = id;
        this.position = position;
        this.isSelect = isSelet;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsSelet() {
        return this.isSelect;
    }

    public void setIsSelet(boolean isSelet) {
        this.isSelect = isSelet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.position);
        dest.writeInt(this.isSelect ? 1 : 0);
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    @Keep
    @Generated(hash = 1447084728)
    protected GoldItemBean(Parcel in) {
        this.id = in.readLong();
        this.position = in.readInt();
        this.isSelect = in.readInt() != 0;
    }

    @Generated(hash = 1447084728)
    public GoldItemBean() {
    }

    public static final Parcelable.Creator<GoldItemBean> CREATOR = new Parcelable.Creator<GoldItemBean>() {
        @Override
        public GoldItemBean createFromParcel(Parcel source) {
            return new GoldItemBean(source);
        }

        @Override
        public GoldItemBean[] newArray(int size) {
            return new GoldItemBean[size];
        }
    };
}
