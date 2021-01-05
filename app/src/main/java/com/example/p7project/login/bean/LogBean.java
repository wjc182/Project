package com.example.p7project.login.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LogBean implements Parcelable {

    /**
     * errno : 0
     * errmsg :
     * data : {"code":200,"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicngzNHlvb2NoNiIsImlhdCI6MTYwOTY3ODk4Mn0.2CdH3dW5N1zbAEo7CjoX5JDrpOdec24-kxsC1pPcBKE","userInfo":{"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"passyou","gender":0,"avatar":"http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png","birthday":110022}}
     */

    @SerializedName("errno")
    private Integer errno;
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("data")
    private DataDTO data;

    protected LogBean(Parcel in) {
        if (in.readByte() == 0) {
            errno = null;
        } else {
            errno = in.readInt();
        }
        errmsg = in.readString();
    }

    public static final Creator<LogBean> CREATOR = new Creator<LogBean>() {
        @Override
        public LogBean createFromParcel(Parcel in) {
            return new LogBean(in);
        }

        @Override
        public LogBean[] newArray(int size) {
            return new LogBean[size];
        }
    };

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (errno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(errno);
        }
        dest.writeString(errmsg);
    }

    public static class DataDTO implements Parcelable {

        public DataDTO() {

        }

        public DataDTO(Integer code, String token, UserInfoDTO userInfo) {
            this.code = code;
            this.token = token;
            this.userInfo = userInfo;
        }

        /**
         * code : 200
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicngzNHlvb2NoNiIsImlhdCI6MTYwOTY3ODk4Mn0.2CdH3dW5N1zbAEo7CjoX5JDrpOdec24-kxsC1pPcBKE
         * userInfo : {"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"passyou","gender":0,"avatar":"http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png","birthday":110022}
         */


        @SerializedName("code")
        private Integer code;
        @SerializedName("token")
        private String token;
        @SerializedName("userInfo")
        private UserInfoDTO userInfo;

        protected DataDTO(Parcel in) {
            if (in.readByte() == 0) {
                code = null;
            } else {
                code = in.readInt();
            }
            token = in.readString();
        }

        public static final Creator<DataDTO> CREATOR = new Creator<DataDTO>() {
            @Override
            public DataDTO createFromParcel(Parcel in) {
                return new DataDTO(in);
            }

            @Override
            public DataDTO[] newArray(int size) {
                return new DataDTO[size];
            }
        };

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoDTO getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoDTO userInfo) {
            this.userInfo = userInfo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (code == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(code);
            }
            dest.writeString(token);
        }

        public static class UserInfoDTO implements Parcelable {
            /**
             * uid : 7b965656-70eb-4726-b4a7-c52366861485
             * username : z1234
             * nickname : passyou
             * gender : 0
             * avatar : http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png
             * birthday : 110022
             */

            @SerializedName("uid")
            private String uid;
            @SerializedName("username")
            private String username;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("gender")
            private Integer gender;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("birthday")
            private Integer birthday;

            protected UserInfoDTO(Parcel in) {
                uid = in.readString();
                username = in.readString();
                nickname = in.readString();
                if (in.readByte() == 0) {
                    gender = null;
                } else {
                    gender = in.readInt();
                }
                avatar = in.readString();
                if (in.readByte() == 0) {
                    birthday = null;
                } else {
                    birthday = in.readInt();
                }
            }

            public static final Creator<UserInfoDTO> CREATOR = new Creator<UserInfoDTO>() {
                @Override
                public UserInfoDTO createFromParcel(Parcel in) {
                    return new UserInfoDTO(in);
                }

                @Override
                public UserInfoDTO[] newArray(int size) {
                    return new UserInfoDTO[size];
                }
            };

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Integer getGender() {
                return gender;
            }

            public void setGender(Integer gender) {
                this.gender = gender;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public Integer getBirthday() {
                return birthday;
            }

            public void setBirthday(Integer birthday) {
                this.birthday = birthday;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(uid);
                dest.writeString(username);
                dest.writeString(nickname);
                if (gender == null) {
                    dest.writeByte((byte) 0);
                } else {
                    dest.writeByte((byte) 1);
                    dest.writeInt(gender);
                }
                dest.writeString(avatar);
                if (birthday == null) {
                    dest.writeByte((byte) 0);
                } else {
                    dest.writeByte((byte) 1);
                    dest.writeInt(birthday);
                }
            }
        }
    }
}

