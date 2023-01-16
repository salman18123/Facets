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
        @JsonSubTypes.Type(value = SimpleVirtualNode.class, name = "BASIC_VIRTUAL_NODE"),

})
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class Node implements Serializable {
    public enum NodeType{
       BASIC_VIRTUAL_NODE;
    }
    protected NodeType type;

    protected String name;



    protected int id;

    protected Connector nodeConnector;

    public Node(NodeType type){
        this.type=type;
    }
}
