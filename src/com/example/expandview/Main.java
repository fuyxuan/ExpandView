package com.example.expandview;

import java.util.ArrayList;
import java.util.List;

import com.example.expandview.ExpandListAdapter.ChildPositionListen;
import com.example.expandview.ShowDialog.confirmListener;
import com.example.expandview.dialog.DialogAddChildMesg;
import com.example.expandview.model.ChildInfo;
import com.example.expandview.model.GroupInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;


public class Main extends Activity {
	
	Context context;
	private ExpandListAdapter listAdapter;
	private ExpandableListView listView;
	private LayoutInflater inflater;
	private GroupInfo groupInfoA,groupInfoB;
	private ArrayList<ChildInfo> childInfoListsA = new ArrayList<ChildInfo>(),
								 childInfoListsB = new ArrayList<ChildInfo>();
	private ChildInfo childInfo;
	private ArrayList<GroupInfo> groupInfos = new ArrayList<GroupInfo>();
	private String modifyChildMesg="";
	Activity activity;
	ShowDialog showDialog ;
	Button buttonMainAdd;
	EditText editAddChildMesg;
	private DialogAddChildMesg dialogAddChildMesg;
	private String[] title = { "A","B"};
	private String[] 
					 titleitemA = {"AA","BB","CC","DD"},
					 titleitemB = {"EE","FF","GG","HH"},
					 messageA   = {"aa","bb","cc","dd"},
				     messageB   = {"ee","ff","gg","hh"};
	
	private int[] imgs = { 
			R.drawable.cycle, 
			R.drawable.mintop,
			R.drawable.ball, 
			R.drawable.ic_launcher
			};
	int len = title.length;
					 
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        activity = Main.this;
        dialogAddChildMesg = new DialogAddChildMesg(context);
        buttonMainAdd = (Button)findViewById(R.id.buttonMainAdd);
        editAddChildMesg = (EditText)findViewById(R.id.editAddChild);
       
        for(int i =0;i<titleitemA.length;i++){
        	ChildInfo childInfo = new ChildInfo();
        	childInfo.itemTitle = titleitemA[i];
        	childInfo.message = messageA[i];
        	childInfo.img = imgs[i];
        	childInfoListsA.add(childInfo);
        	
        }
        groupInfoA = new GroupInfo(title[0], childInfoListsA);
        
        
        for(int i=0;i<titleitemB.length;i++){
        	ChildInfo childInfo = new ChildInfo();
        	childInfo.itemTitle = titleitemB[i];
        	childInfo.message = messageB[i];
        	childInfo.img = imgs[i];
        	childInfoListsB.add(childInfo);
        }
        groupInfoB = new GroupInfo(title[1], childInfoListsB);
       
        groupInfos.add(groupInfoA);
        groupInfos.add(groupInfoB);
//      setListView();
		findView();
		setAction();
		// setView();
		// dialogCallback();
		
        
    }
    private void findView() {
    	
    	listView = (ExpandableListView) findViewById(R.id.expand_view);
    	listAdapter = new ExpandListAdapter(context, activity, groupInfos);
    	listView.setAdapter(listAdapter);
    	
    
    }
    private void setAction() {
    	
    	
    	listView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, final int groupPosition, final int childPosition, long id) {
				// TODO Auto-generated method stub
				Log.i("msg", "child: " + groupInfos.get(groupPosition).getChildInfos().get(childPosition).getMessage());
				Log.i("msg","groupPosition: " + groupPosition + " + childPosition: " + childPosition + " + modifyChildMesg: " + modifyChildMesg);
				
				new ShowDialog(context, new confirmListener() {
					
					@Override
					public void onCheck(String str) {
						Log.i("msg","getStr"+str);
						modifyChildMesg = str;
						ChildInfo childInfo = groupInfos.get(groupPosition).getChildInfos().get(childPosition);
						childInfo.setMessage(modifyChildMesg);
						listAdapter.notifyDataSetChanged();
					}
					
					@Override
					public void onCancel() {
						
					}
				}).show();
				
				return false;
			}
			
		});
    	
    	buttonMainAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("msg","AAA");
				dialogAddChildMesg.show();
				// TODO Auto-generated method stub
				
			}
		});
    	
    }
    
    private void dialogCallback(){
    }
    
    public void setListView() {
	}
    
    
    private void setView() {
    }
    
    
    
}
