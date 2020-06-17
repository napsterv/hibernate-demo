package com.hibernatedemo.company.dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class SuccessResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  @NotNull MediaType mediaType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> aClass,
                                  @NotNull ServerHttpRequest serverHttpRequest,
                                  @NotNull ServerHttpResponse serverHttpResponse) {

        if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
            //if o is null send blank response
            return new SuccessResponse<>(o);
        }

        return o;
    }
}
