package com.cropdeal.dealerservice.models;

	import java.time.LocalDateTime;



	   import org.springframework.http.HttpStatus;



	   public class ErrorResponse
	    {
	       
	        private HttpStatus statusmessage;
	        private String message;
	        private LocalDateTime datetime;
	        public ErrorResponse() {
	            super();
	            // TODO Auto-generated constructor stub
	        }
	        public ErrorResponse( HttpStatus statusmessage, String message, LocalDateTime datetime) {
	            super();
	            
	            this.statusmessage = statusmessage;
	            this.message = message;
	            this.datetime = datetime;
	        }
	        
	        public HttpStatus getStatusmessage() {
	            return statusmessage;
	        }
	        public void setStatusmessage(HttpStatus statusmessage) {
	            this.statusmessage = statusmessage;
	        }
	        public String getMessage() {
	            return message;
	        }
	        public void setMessage(String message) {
	            this.message = message;
	        }
	        public LocalDateTime getDatetime() {
	            return datetime;
	        }
	        public void setDatetime(LocalDateTime datetime) {
	            this.datetime = datetime;
	        }
	        @Override
	        public String toString() {
	            return "ErrorResponse [ statusmessage=" + statusmessage + ", message=" + message
	                    + ", datetime=" + datetime + "]";
	        }
	        
	    
}
