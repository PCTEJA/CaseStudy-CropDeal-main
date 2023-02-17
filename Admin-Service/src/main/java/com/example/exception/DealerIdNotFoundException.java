package com.example.exception;


	public class DealerIdNotFoundException extends Exception{
		
		public DealerIdNotFoundException(String s) {
			super(s);
	}

		public DealerIdNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DealerIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public DealerIdNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public DealerIdNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
	}