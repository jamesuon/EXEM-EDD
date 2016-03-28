package io.cloudine.template.esm.rest;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "code",
        "message",
        "cause",
        "exception"
})
@XmlRootElement(name = "error")
public class Error implements Serializable {

    /**
     * Serialization UID
     */
    private static final long serialVersionUID = 1;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String id;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String code;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String cause;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    String exception;

    public Error(String code) {
        this.code = code;
    }

    public Error() {
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Error(String code, String message, String cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}