package com.facets.app.models;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
public class SimpleVirtualNode extends Node {

    public SimpleVirtualNode() {
        super(NodeType.BASIC_VIRTUAL_NODE);
    }

}
