package com.cropdeal.farmerservice.Exception;

@SuppressWarnings("serial")
public class FarmerNotFoundException  extends Exception
{
	public FarmerNotFoundException()
	{
		super();
	}
	
	public FarmerNotFoundException(String message)
	{
		super(message);
	}
	
	public FarmerNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
