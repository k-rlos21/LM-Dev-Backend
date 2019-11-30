
package com.loyalty.prueba.algoritmo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exp"
})
@Data
public class AlgoritmoRequest {

    @JsonProperty("exp")
    public String exp;

}
