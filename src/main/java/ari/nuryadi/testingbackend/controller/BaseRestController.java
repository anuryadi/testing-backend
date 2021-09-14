package ari.nuryadi.testingbackend.controller;

import ari.nuryadi.testingbackend.utils.response.StatusResponse;
import ari.nuryadi.testingbackend.utils.response.SuccessResponse;
import ari.nuryadi.testingbackend.utils.response.SuccessResponseList;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseRestController<E> {

    static final String RESPONSE_TYPE_CREATE = "create";
    static final String RESPONSE_TYPE_READ = "read";
    static final String RESPONSE_TYPE_ALL = "all";
    static final String RESPONSE_TYPE_UPDATE = "update";
    static final String RESPONSE_TYPE_DELETE = "delete";
    static final String RESPONSE_TYPE_ERROR = "error";

    SuccessResponse successResponse;
    SuccessResponseList successResponseList;

    public abstract ResponseEntity retrieveAll();

    public abstract ResponseEntity retrieveById(Long id);

    public abstract ResponseEntity delete(Long id);

    public abstract ResponseEntity create(E entity);

    public abstract ResponseEntity update(E entity);


    SuccessResponse getSuccessResponseObject(Object data, String responseType) {
        successResponse = new SuccessResponse();

        switch (responseType) {
            case RESPONSE_TYPE_CREATE:
                successResponse.setCode(StatusResponse.SUCCESS.getCode());
                successResponse.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_READ:
                successResponse.setCode(StatusResponse.SUCCESS.getCode());
                successResponse.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_UPDATE:
                successResponse.setCode(StatusResponse.SUCCESS.getCode());
                successResponse.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_DELETE:
                successResponse.setCode(StatusResponse.SUCCESS.getCode());
                successResponse.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_ERROR:
                successResponse.setCode(StatusResponse.ERROR_ENTITY_NOT_FOUND.getCode());
                successResponse.setMessage(StatusResponse.ERROR_ENTITY_NOT_FOUND.getValue());
                break;

            default:
                successResponse.setCode(data.equals("") ?
                        StatusResponse.EMPTY_RESULT_SET.getCode() : StatusResponse.SUCCESS.getCode());
                successResponse.setMessage(data.equals("") ?
                        StatusResponse.EMPTY_RESULT_SET.getValue() : StatusResponse.SUCCESS.getValue());
                break;

        }

        successResponse.setData(data);

        return successResponse;
    }

    SuccessResponseList getSuccessResponseList(List list, String responseType) {
        successResponseList = new SuccessResponseList();

        switch (responseType) {
            case RESPONSE_TYPE_CREATE:
                successResponseList.setCode(StatusResponse.SUCCESS_CREATED.getCode());
                successResponseList.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_READ:
                successResponseList.setCode(StatusResponse.SUCCESS.getCode());
                successResponseList.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_UPDATE:
                successResponseList.setCode(StatusResponse.SUCCESS_UPDATED.getCode());
                successResponseList.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_DELETE:
                successResponseList.setCode(StatusResponse.SUCCESS_DELETED.getCode());
                successResponseList.setMessage(StatusResponse.SUCCESS.getValue());
                break;

            case RESPONSE_TYPE_ERROR:
                successResponseList.setCode(StatusResponse.ERROR_ENTITY_NOT_FOUND.getCode());
                successResponseList.setMessage(StatusResponse.ERROR_ENTITY_NOT_FOUND.getValue());
                break;

            default:
                successResponseList.setCode(list.isEmpty() ?
                        StatusResponse.EMPTY_RESULT_SET.getCode() : StatusResponse.SUCCESS.getCode());
                successResponseList.setMessage(list.isEmpty() ?
                        StatusResponse.EMPTY_RESULT_SET.getValue() : StatusResponse.SUCCESS.getValue());
                break;

        }

        System.out.println(list);

        successResponseList.setDetails(list);

        return successResponseList;
    }

}
