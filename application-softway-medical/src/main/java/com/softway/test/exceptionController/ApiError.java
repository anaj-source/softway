package com.softway.test.exceptionController;

import java.time.OffsetDateTime;

//This class represents a standard API error response structure.
//It uses Java's record feature 
public record ApiError(int status, String label, String message, String path, OffsetDateTime timestamp) {

	// This is a static method that returns a new ApiErrorBuilder object.
	// The builder pattern is used for creating instances of ApiError in a more
	// flexible and readable way.
	public static ApiErrorBuilder builder() {
		return new ApiErrorBuilder();
	}
	// This nested class is the builder for creating ApiError objects.
	public static class ApiErrorBuilder {
		// Private fields to hold the error details.
		private int status;
		private String label;
		private String message;
		private String path;
		private OffsetDateTime timestamp;

		// Private constructor to prevent direct instantiation.
		ApiErrorBuilder() {
		}

		// Methods to set the error details, each returning 'this' for method chaining.
		public ApiErrorBuilder status(int status) {
			this.status = status;
			return this;
		}

		public ApiErrorBuilder label(String label) {
			this.label = label;
			return this;
		}

		public ApiErrorBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorBuilder path(String path) {
			this.path = path;
			return this;
		}

		public ApiErrorBuilder timestamp(OffsetDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		// Method to build the final ApiError object.
		public ApiError build() {
			return new ApiError(status, label, message, path, timestamp);
		}

	}
}
