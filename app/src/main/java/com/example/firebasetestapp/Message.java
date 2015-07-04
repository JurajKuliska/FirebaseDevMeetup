package com.example.firebasetestapp;

public class Message
{

	private String mMessage;
	private String mName;


	public Message()
	{
	}


	public Message(String message, String name)
	{
		mMessage = message;
		mName = name;
	}


	public String getMessage()
	{
		return mMessage;
	}


	public void setMessage(String message)
	{
		mMessage = message;
	}


	public String getName()
	{
		return mName;
	}


	public void setName(String name)
	{
		mName = name;
	}
}
