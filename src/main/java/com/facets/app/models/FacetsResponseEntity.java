package com.facets.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacetsResponseEntity<T> {

    public FacetsResponseEntity(T data) {
        this(data,new ArrayList<>());
    }

    private T data;

   private  List<ApiError> error;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiError {
        private int errorCode;

        private String errorMessage;
    }
}
