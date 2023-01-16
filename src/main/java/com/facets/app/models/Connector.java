package com.facets.app.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SerialConnector.class, name = "SERIAL"),
        @JsonSubTypes.Type(value = ParallelConnector.class, name = "PARALLEL")

})
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class Connector implements Serializable {

    public Connector(ConnectorType connectorType) {
        this.type = connectorType;
    }

    public enum ConnectorType {
        SERIAL,
        PARALLEL
    }

    protected ConnectorType type;

}
