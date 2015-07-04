package com.example.firebasetestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{

	public static final String FIREBASE_URL = "https://developers-workshop.firebaseio.com/";
	public static final String FIREBASE_MESSAGES = "messages";
	public static final String FIREBASE_MESSAGE = "message";
	public static final String FIREBASE_NAME = "name";

	private ListAdapter mListAdapter;
	private List<Message> mMessageList = new ArrayList<>();
	private EditText mEditText;
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initList();

		initSendButton();

		initFirebase();
	}


	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		//TODO
	}


	private void initList()
	{
		mListView = (ListView) findViewById(R.id.listView);
		mListAdapter = new ListAdapter(this, R.layout.list_item, mMessageList);
		mListView.setAdapter(mListAdapter);
	}


	private void initFirebase()
	{
		//TODO
	}


	private void initSendButton()
	{
		mEditText = (EditText) findViewById(R.id.editText);
		Button button = (Button) findViewById(R.id.buttonSend);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				sendMessageToFirebase(mEditText.getText().toString());
			}
		});
	}


	private void sendMessageToFirebase(String messageText)
	{
		//TODO
	}
	
}
