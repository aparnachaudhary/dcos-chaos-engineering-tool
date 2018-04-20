package io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions;

/**
 * Generic exception.
 *
 * @since 20.04.2018
 */
public class DcosChaosException extends Exception {

    public DcosChaosException(String message) {
        super(message);
    }

    public DcosChaosException(String message, Throwable cause) {
        super(message, cause);
    }
}
