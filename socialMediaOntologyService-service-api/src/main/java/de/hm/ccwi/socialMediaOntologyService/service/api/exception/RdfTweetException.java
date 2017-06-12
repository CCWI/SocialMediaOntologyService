package de.hm.ccwi.socialMediaOntologyService.service.api.exception;

/**
 * RdfTweet-Exception.
 */
public class RdfTweetException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a {@link RdfException} with {@code message}.
	 *
	 * @param message
	 */
	public RdfTweetException(final String message) {
		super(message);
	}

	/**
	 * Create a {@link RdfException} with cause {@code cause}.
	 *
	 * @param cause
	 *            {@link Throwable}
	 */
	public RdfTweetException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Create a {@link RdfException} with {@code message} and {@code cause}.
	 *
	 * @param message
	 *            String, message of the exception.
	 * @param cause
	 *            {@link Throwable}, which caused the exception.
	 */
	public RdfTweetException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
