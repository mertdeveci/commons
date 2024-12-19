package com.application.model;

import com.application.enums.ResponseStatus;

import static com.application.enums.ResponseStatus.FAIL;

public class ResponseBuilder {

    public Response ok(){
        return new Builder().build();
    }

    public Response ok(String message){
        return new Builder().message(message).build();
    }

    public <T> Response ok(T body){
        return new Builder().build(body);
    }

    public Response error(){
        return new Builder().error(true).status(FAIL).build();
    }

    public Response error(String errorCode, String errorMessage){
        return new Builder().error(true).errorCode(errorCode).message(errorMessage).status(FAIL).build();
    }

    public Builder builder(){
        return new Builder();
    }

    public class Builder{
        private Response response;

        protected Builder() {
            this.response = new Response();
        }

        public Builder status(ResponseStatus responseStatus){
            this.response.setStatus(responseStatus);
            return this;
        }

        public Builder message(String message){
            this.response.setMessage(message);
            return this;
        }

        public Builder error(boolean error){
            this.response.setError(error);
            return this;
        }

        public Builder errorCode(String errorCode){
            this.response.setErrorCode(errorCode);
            return this;
        }

        public Builder local(String local){
            this.response.setLocal(local);
            return this;
        }

        public Response build(){
            return response;
        }

        public <T> Response build(T body){
            Response response = build();
            response.setBody(new ResponseBody<>(body));
            return response;
        }
    }
}
