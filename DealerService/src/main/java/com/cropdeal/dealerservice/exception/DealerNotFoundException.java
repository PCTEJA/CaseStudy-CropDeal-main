package com.cropdeal.dealerservice.exception;

@SuppressWarnings("serial")
public class DealerNotFoundException  extends Exception
{
	public DealerNotFoundException()
	{
		super();
	}
	
	public DealerNotFoundException(String message)
	{
		super(message);
	}
	
	public DealerNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
