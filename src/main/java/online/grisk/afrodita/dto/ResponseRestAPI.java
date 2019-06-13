package online.grisk.afrodita.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class ResponseRestAPI extends ParentResponseRestAPI {

    private Object response;

    public ResponseRestAPI(String uuid, HttpStatus status, String message, Date date, Object response) {
        super(uuid, status, message, date);
        this.response = response;
    }

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
