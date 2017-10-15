package br.com.campanha.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

    private List<String> errors = new ArrayList<>();

    public ErrorMessage (String error) {
        this.errors.add(error);
    }

    public ErrorMessage(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
