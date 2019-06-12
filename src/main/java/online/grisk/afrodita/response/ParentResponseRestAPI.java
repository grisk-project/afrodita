package online.grisk.afrodita.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ParentResponseRestAPI {

    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Error interno del servidor.";
    public static final String REQUEST_SUCCESSFUL_MESSAGE = "Solicitud Exitosa.";
    public static final String ZERO_DATA_LIST_MESSAGE = "La Solicitud no retornó datos.";
    public static final String REGISTER_DOENST_EXIST_MESSAGE = "El registro solicitado no existe.";
    public static final String ERROR_SAVING_DATA_MESSAGE = "Ocurrió un problema al guardar el registro.";
    public static final String ERROR_VALIDATION_FIELD_MESSAGE = "Error de validación de campos.";
    public static final String ERROR_UPDATING_DATA_MESSAGE = "Error al modificar registro.";
    public static final String FORMAT_DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static final String DATE_TIMEZONE = "America/Santiago";

    private HttpStatus status;
    private String code;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FORMAT_DATE_PATTERN, timezone = DATE_TIMEZONE)
    private Date date;

    public ParentResponseRestAPI(HttpStatus status, String code, String message, Date date) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public ParentResponseRestAPI() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
}