package com.rca.demofeign;

import java.util.List;

public class CatFactResponse {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public  void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CatFactResponse{" + "data=" + data + '}';
    }
}
