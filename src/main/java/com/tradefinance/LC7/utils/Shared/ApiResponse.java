package com.tradefinance.LC7.utils.Shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse<T> {
    public String message;
    public T entity;//{}
    public Integer statusCode;
}
