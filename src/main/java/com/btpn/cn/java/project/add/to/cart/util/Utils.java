package com.btpn.cn.java.project.add.to.cart.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getTransactionID(){

        String pattern = "ddHHmmSSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String strDate = simpleDateFormat.format(new Date());

        return strDate;
    }

}
