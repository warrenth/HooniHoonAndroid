package pe.hoonihoon.bootstrap.view.vo;

import java.util.HashMap;

/**
 * Created by 152317 on 2017-04-07.
 */

public class ObjectItem {

    private int viewType;
    private Object item;
    private Object tag;
    private HashMap<String, Object> extraTags = new HashMap<>();

    public ObjectItem() {
    }

    public ObjectItem(int viewType, Object item) {
        this.viewType = viewType;
        this.item = item;
    }

    public ObjectItem(int viewType, Object item, Object tag) {
        this.viewType = viewType;
        this.item = item;
        this.tag = tag;
    }

    public void addExtraTag(String key, Object value) {
        extraTags.put(key, value);
    }

    public String getExtraTagString(String key, String defaultValue) {
        final String s = getExtraTagString(key);
        return (s == null) ? defaultValue : s;
    }

    public String getExtraTagString(String key) {
        final Object o = extraTags.get(key);
        try {
            return (String) o;
        } catch (ClassCastException e) {
            return null;
        }
    }

    public boolean getExtraTagBoolean(String key) {
        return getExtraTagBoolean(key, false);
    }

    public boolean getExtraTagBoolean(String key, boolean defaultValue) {
        Object o = extraTags.get(key);
        if(o == null) {
            return defaultValue;
        }
        try {
            return (Boolean) o;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public int getExtraTagInt(String key) {
        return getExtraTagInt(key, 0);
    }

    public int getExtraTagInt(String key, int defaultValue) {
        Object o = extraTags.get(key);
        if(o == null) {
            return defaultValue;
        }
        try {
            return (Integer) o;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }
}
