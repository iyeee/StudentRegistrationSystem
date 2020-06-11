package com.ischoolbar.programmer.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.sql.Date;

public class JsonDateValueProcessor implements JsonValueProcessor {
    @Override
    public Object processArrayValue(Object obj, JsonConfig jsonconfig) {
        return process(obj);
    }
    @Override
    public Object processObjectValue(String s, Object obj, JsonConfig jsonconfig) {
        return process(obj);
    }
    private Object process(Object obj) {
        if (obj == null) {// ���ʱ��Ϊnull���򷵻ؿ��ִ�
            return "";
        }
        if (obj instanceof Date) {
            obj = new java.util.Date(((Date) obj).getTime());
        }
        if (obj instanceof java.util.Date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
                    Locale.CHINA);// ��ʽ��ʱ��Ϊyyyy-MM-dd����
            return sdf.format(obj);
        } else {
            return new Object();
        }
    }
}