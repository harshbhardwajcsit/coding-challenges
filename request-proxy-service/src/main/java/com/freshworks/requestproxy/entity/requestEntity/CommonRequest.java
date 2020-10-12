package com.freshworks.requestproxy.entity.requestEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.json.JSONObject;

import java.io.Serializable;

@Data
@ApiModel(description = "A common request entity for incoming request to replay by the system")
public class CommonRequest implements Serializable {

    @ApiModelProperty(value = "A client Id could be unique identifier for a requesting client")
    private Long clientId;

    @ApiModelProperty(value = "A Url where the HTTPS request has to be made")
    private String url;

    @ApiModelProperty(value = "Header that need to be sent along with URL")
    private JSONObject headers;

    @ApiModelProperty(value = "A request type, eg. GET, POST, PUT, DELETE, PATCH")
    private String request;

    @ApiModelProperty(value = "A Body that has to be sent along with the URL")
    private String body;

    public CommonRequest() {
    }

    public CommonRequest(Long clientId, String url, JSONObject headers, String request, String body) {
        this.clientId = clientId;
        this.url = url;
        this.headers = headers;
        this.request = request;
        this.body = body;
    }
}
