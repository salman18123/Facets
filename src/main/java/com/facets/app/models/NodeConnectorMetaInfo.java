package com.facets.app.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class NodeConnectorMetaInfo {
    private String name;

    private String nodeName;

    private String nodeId;
}
