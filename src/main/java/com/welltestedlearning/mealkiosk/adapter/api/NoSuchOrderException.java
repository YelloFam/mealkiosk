package com.welltestedlearning.mealkiosk.adapter.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No order with that ID was found.")
public class NoSuchOrderException extends RuntimeException {
}