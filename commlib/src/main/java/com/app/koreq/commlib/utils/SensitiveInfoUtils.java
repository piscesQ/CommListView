package com.app.koreq.commlib.utils;

/**
 * project : CommListView
 * author : YanBin on 6/2/17
 * version : v4.0
 * description : 敏感信息处理工具
 */
public class SensitiveInfoUtils {

    /**
     * 处理银行卡号：只显示头部四位和尾部四位，其余位数用等量的星号代替
     * 处理方法：先替换星号，再加空格
     * @param bankCardNum String 银行卡号
     * @return 处理之后的卡号
     */
    private String handleBankCardNum(String bankCardNum) {
        //先替换星号，再加空格
        String tempNum = bankCardNum.replaceAll("(?<=\\d{4})\\d(?=\\d{4})", "*");
        StringBuilder sb = new StringBuilder(tempNum);
        int length = tempNum.length() / 4 + tempNum.length();

        for (int i = 0; i < length; i++) {
            if (i % 5 == 0) {
                sb.insert(i, " ");
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    /**
     * 处理手机号：只显示头部三位和尾部四位，其余位数用等量的星号代替
     * 处理方法：先替换星号，再加空格
     * @param phoneNum String 手机号
     * @return 处理之后的手机号
     */
    private String handPhoneNum(String phoneNum) {
        return phoneNum.replaceAll("(?<=\\d{3})\\d(?=\\d{4})", "*");
    }
}
