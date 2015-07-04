package com.example.firebasetestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends ArrayAdapter<Message>
{

	private List<Message> mMessageList;
	private int mResourceId;
	private Context mContext;


	public ListAdapter(Context context, int resource, List<Message> list)
	{
		super(context, resource, list);
		mMessageList = list;
		mResourceId = resource;
		mContext = context;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{

		ViewHolder viewHolder;

    /*
	 * The convertView argument is essentially a "ScrapView" as described is Lucas post
     * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
     * It will have a non-null value when ListView is asking you recycle the row layout.
     * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
     */
		if(convertView == null)
		{

			// inflate the layout
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(mResourceId, parent, false);

			// well set up the ViewHolder
			viewHolder = new ViewHolder();
			viewHolder.mTxtMessage = (TextView) convertView.findViewById(R.id.txtMessage);
			viewHolder.mTxtName = (TextView) convertView.findViewById(R.id.txtName);

			// store the holder with the view.
			convertView.setTag(viewHolder);

		}
		else
		{
			// we've just avoided calling findViewById() on resource everytime
			// just use the viewHolder
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// object item based on the position
		Message message = mMessageList.get(position);

		// assign values if the object is not null
		if(message != null)
		{
			// get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
			viewHolder.mTxtMessage.setText(message.getMessage());
			viewHolder.mTxtName.setText(message.getName());
		}

		return convertView;

	}


	public static class ViewHolder
	{
		TextView mTxtMessage;
		TextView mTxtName;
	}

}
