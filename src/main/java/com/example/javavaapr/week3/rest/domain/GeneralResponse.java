package com.example.javavaapr.week3.rest.domain;

import java.util.Date;
import java.util.List;

public class GeneralResponse {

    private Date timestamp;
    private List<DemoPojo> content;

    public GeneralResponse(Date timestamp, List<DemoPojo> content) {
        this.timestamp = timestamp;
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<DemoPojo> getContent() {
        return content;
    }

    public void setContent(List<DemoPojo> content) {
        this.content = content;
    }
}
