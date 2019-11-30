
package com.loyalty.prueba.algoritmo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "infix",
    "postfix",
    "result"
})
@Data
public class AlgoritmoSuccessResponse {

    @JsonProperty("infix")
    public String infix;
    @JsonProperty("postfix")
    public String postfix;
    @JsonProperty("result")
    public float result;

}
