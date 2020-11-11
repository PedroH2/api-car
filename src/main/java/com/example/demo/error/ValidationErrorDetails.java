package com.example.demo.error;

import lombok.Data;

@Data
public class ValidationErrorDetails extends ErrorDetail {
	private String field;
	private String fieldMessage;
	
	public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String field;
    	private String fieldMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }
        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }
        
        public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getFieldMessage() {
			return fieldMessage;
		}

		public void setFieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
		}

		public ValidationErrorDetails build() {
        	ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
        	validationErrorDetails.setDeveloperMessage(developerMessage);
        	validationErrorDetails.setTitle(title);
        	validationErrorDetails.setDetail(detail);
        	validationErrorDetails.setTimestamp(timestamp);
        	validationErrorDetails.setStatus(status);
        	validationErrorDetails.setField(field);
        	validationErrorDetails.setFieldMessage(fieldMessage);
            return validationErrorDetails;
        }
    }
	
}
