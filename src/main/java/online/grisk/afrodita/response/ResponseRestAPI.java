package online.grisk.afrodita.response;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class ResponseRestAPI extends ParentResponseRestAPI {

    private Object response;

//    public ResponseRestAPI(HttpStatus status, String code, String message, Date date, List<Object> response) {
//        super(status, code, message, date);
//        this.response = response;
//    }

    public ResponseRestAPI(HttpStatus status, String code, String message, Date date, Object response) {
        super(status, code, message, date);
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(List<Object> response) {
        this.response = response;
    }
}
