package com.hibernatedemo.company.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class SuccessDTO<T> implements Serializable {
    private T data;
    private int length = 1;
    private String message = null;

    public SuccessDTO(T data, Integer length, String message) {
        this.data = data;
        if (this.length == 0) {
            if (this.data instanceof List) {
                this.length = ((List) this.data).size();
            }

            if (this.data instanceof Map) {
                this.length = ((Map) this.data).size();
            }
        }
    }
}