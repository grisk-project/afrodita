package online.grisk.afrodita.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import online.grisk.afrodita.utils.Constant;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ParentResponseRestAPI {

    private String uuid;
    private HttpStatus status;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMAT_DATE_PATTERN, timezone = Constant.DATE_TIMEZONE)
    private Date date;

    public ParentResponseRestAPI(String uuid, HttpStatus status, String message, Date date) {
        super();
        this.uuid = uuid;
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public ParentResponseRestAPI() {
    }

    
    
    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}