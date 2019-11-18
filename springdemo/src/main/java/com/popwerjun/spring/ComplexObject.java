package com.popwerjun.spring;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/26.
 */
public class ComplexObject {

    private List<String> names;

    private Map<String, String> map;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
