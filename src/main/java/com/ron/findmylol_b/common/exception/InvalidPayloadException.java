package com.ron.findmylol_b.common.exception;

public class InvalidPayloadException extends RuntimeException {
	private static final long serialVersionUID = 6966602510347595621L;

	public InvalidPayloadException(String message) {
		super(message);
	}
}
