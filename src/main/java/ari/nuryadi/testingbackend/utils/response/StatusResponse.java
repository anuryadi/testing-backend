package ari.nuryadi.testingbackend.utils.response;

public enum StatusResponse {

    SUCCESS(200, "success"),
    SUCCESS_CREATED(201, "Entity Created"),
    SUCCESS_UPDATED(202, "Entity Updated"),
    SUCCESS_DELETED(203, "Entity Deleted"),
    SUCCESS_ENTITY_FOUND(204, "success"),
    EMPTY_RESULT_SET(210, "Empty Result Set"),
    ERROR(400, "Failed"),
    ERROR_CREATE(401, "Create Entity, Failed"),
    ERROR_UPDATE(402, "Updated Entity, Failed"),
    ERROR_DELETE(403, "Entity Deletion Failed"),
    ERROR_ENTITY_NOT_FOUND(404, "Entity/Row Not Found"),
    ERROR_DUPLICATE_ENTITY(405, "Entity/Row Already Exists"),
    ERROR_VALIDATION(406, "Validation Failed"),
    ERROR_SERVER(500, "Server Error"),
    ERROR_EMPTY_REQUEST_BODY(407, "Missing Required request body")
    ;

    private int code;

    private String value;

    StatusResponse(int code, String value) {
        this.code = code;
        this.value= value;

    }

    StatusResponse(int code) {
        this.code = code;
    }

    StatusResponse(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }


    public String getValue() {
        return value;
    }

}
