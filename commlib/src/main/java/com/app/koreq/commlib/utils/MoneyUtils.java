package com.app.koreq.commlib.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * project : CommListView
 * author : YanBin on 5/20/17
 * version : v4.0
 * description : 金额 格式化   比如 1,000,000.00
 */
public class MoneyUtils {
    //保留后两位小数的格式
    public static String getParseMoney(String money){
        String parseMoney="0.00";
        if(TextUtils.isEmpty(money)){
            parseMoney="0.00";
        }else {
            try {
                parseMoney = parseMoney(",###,###,###.00", money).startsWith(".") ?
                        ("0" + parseMoney(",###,###,###.00", money)) :
                        parseMoney(",###,###,###.00", money);
            }catch (Exception e){
                parseMoney="--";
            }
        }
        return parseMoney;
    }

    private static String parseMoney(String pattern, String parameter){
        BigDecimal bd = new BigDecimal(parameter);
        DecimalFormat df=new DecimalFormat(pattern);
        return df.format(bd);
    }
}
