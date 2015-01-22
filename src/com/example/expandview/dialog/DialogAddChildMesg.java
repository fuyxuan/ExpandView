package com.example.expandview.dialog;

import com.example.expandview.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

public class DialogAddChildMesg extends Dialog{

	public DialogAddChildMesg(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.diaog_add_child_mesg);
	}

}
