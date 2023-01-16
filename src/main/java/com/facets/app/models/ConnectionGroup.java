package com.facets.app.models;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionGroup implements Serializable {
    @NotBlank
    private String name;

    private Date creationDate;

    private Date lastEditedAt;

    @Valid
    List<Node> nodes;
}
