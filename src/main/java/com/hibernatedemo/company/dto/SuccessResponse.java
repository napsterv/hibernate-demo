package com.hibernatedemo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SuccessResponse<T> {
    private T data;
}
