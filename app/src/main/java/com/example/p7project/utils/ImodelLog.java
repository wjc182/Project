package com.example.p7project.utils;

import java.util.HashMap;

public interface ImodelLog {

    <T> void iModelLog(String string, HashMap<String,String> map,CallBack<T> callback);

}
