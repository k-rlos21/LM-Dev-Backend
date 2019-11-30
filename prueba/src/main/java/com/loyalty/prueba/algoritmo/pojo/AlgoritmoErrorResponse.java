
package com.loyalty.prueba.algoritmo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message"
})
@Data
public class AlgoritmoErrorResponse {

    @JsonProperty("message")
    public String message;

}
