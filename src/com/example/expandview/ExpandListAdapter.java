package com.example.expandview;

import java.util.ArrayList;
import java.util.List;

import com.example.expandview.ShowDialog.confirmListener;
import com.example.expandview.model.ChildInfo;
import com.example.expandview.model.GroupInfo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<ListObj> arrayList = new ArrayList<ListObj>(),
							   groupTitleList = new ArrayList<ListObj>();
	private ShowDialog showDialog;
	private Activity activity;
	private ArrayList<List<String>> itemList;
	private List<GroupInfo> groupInfos;

	public ExpandListAdapter(Context context, Activity activity,List<GroupInfo> groupInfos) {
		this.context = context;
		this.activity = activity;
		this.groupInfos = groupInfos;
	}

	interface ChildPositionListen {
		public void getChildInfo( ChildInfo childInfo);
	}

	// 位置
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	// 個數
	public int getChildrenCount(int groupPosition) {
		return groupInfos.get(groupPosition).getChildInfos().size();

	}

	public int getGroupCount() {
		return groupInfos.size();
	}

	// 數據
	public Object getGroup(int groupPosition) {
		return groupInfos.get(groupPosition);
	}

	@SuppressWarnings("deprecation")
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		ViewHolder holderGroup = null;
		if (convertView == null) {
			holderGroup = new ViewHolder();
			LayoutInflater mInflater = LayoutInflater.from(context);
			convertView = mInflater.inflate(R.layout.list_item_group, null);
			convertView.setBackgroundColor(Color.parseColor("#FA8000"));
			holderGroup.title = (TextView) convertView.findViewById(R.id.groupText);
			convertView.setTag(holderGroup);
		} else {
			holderGroup = (ViewHolder) convertView.getTag();
		}
		// groupInfos.get(location)
		// ListObj dataGroup = groupTitleList.get(groupPosition);
		holderGroup.title.setText(groupInfos.get(groupPosition).getTitle());
		return convertView;
	}

	// 小孩的數據
	public ChildInfo getChild(int groupPosition, int childPosition) {
		return groupInfos.get(groupPosition).getChildInfos().get(childPosition);
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		ChildInfo child = getChild(groupPosition, childPosition);
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater mInflater = LayoutInflater.from(context);
			convertView = mInflater.inflate(R.layout.list_item, null);
			convertView.setBackgroundColor(Color.parseColor("#FDFF73"));
			
			holder.titleItem = (TextView) convertView.findViewById(R.id.text_title);
			holder.message = (TextView) convertView.findViewById(R.id.text_message);
			holder.imgs = (ImageView) convertView.findViewById(R.id.image_view);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		setView(convertView, holder, child);
//		showDialogView(convertView,child);
		
		return convertView;
	}

	

	private void setView(View convertView, final ViewHolder holder, final ChildInfo childInfo) {
		holder.titleItem.setText(childInfo.itemTitle);
		holder.message.setText(childInfo.message);
		holder.imgs.setImageResource(childInfo.img);

	}
	private void showDialogView(View convertView,ChildInfo child) {
		notifyDataSetChanged();
//		convertView.setOnClickListener(new View.OnClickListener() {// 監聽使用者點到哪一個item
//				@Override
//				public void onClick(View v) {
//					Toast.makeText(context.getApplicationContext(),"!!!" ,Toast.LENGTH_SHORT).show();
//					showDialog = new ShowDialog(context, new confirmListener() {
//						
//						@Override
//						public void onCheck(String str) {
//							Log.i("msg","String:"+str);
//						}
//						
//						@Override
//						public void onCancel() {
//							
//						}
//					});
//					
//					//showDialog.show();
//					 
//					 //監聽item被點擊
//				}
//		});
		
	}
	// ?
	public boolean hasStableIds() {
		return false;
	}

	
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	
	private class ViewHolder {
		TextView title;
		TextView message;
		TextView titleItem;
		ImageView imgs;
	}

}
