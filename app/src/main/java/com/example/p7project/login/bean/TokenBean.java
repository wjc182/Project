package com.example.p7project.login.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.ParagraphStyle;

import com.google.gson.annotations.SerializedName;

public class TokenBean implements Parcelable {

    /**
     * errno : 0
     * errmsg :
     * data : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoiNDZxdjN2N3czdCIsImlhdCI6MTYwOTY3NDMzNX0.H5f7wl19To-PNd-nQb5HsNWbqxA0rZ3eQCDf2wjz3_c
     */

    @SerializedName("errno")
    private int errno;
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("data")
    private String data;

    protected TokenBean(Parcel in) {
        errno = in.readInt();
        errmsg = in.readString();
        data = in.readString();
    }

    public static final Creator<TokenBean> CREATOR = new Creator<TokenBean>() {
        @Override
        public TokenBean createFromParcel(Parcel in) {
            return new TokenBean(in);
        }

        @Override
        public TokenBean[] newArray(int size) {
            return new TokenBean[size];
        }
    };

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(errno);
        dest.writeString(errmsg);
        dest.writeString(data);
    }
}
