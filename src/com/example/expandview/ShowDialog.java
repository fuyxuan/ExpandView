package com.example.expandview;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class ShowDialog extends Dialog {
	
	private Button 
			modifyCheckButton,
			modifyCancelButton;
	private EditText modifyText;
	private confirmListener callBack;
	
	interface confirmListener {
		void onCheck(String str);
		void onCancel();
	}

	public ShowDialog(Context context, confirmListener callBack) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.show_dialog);
		
		modifyCheckButton = (Button) findViewById(R.id.modifyCheckButton);
		modifyCancelButton = (Button) findViewById(R.id.modifyCancelButton);
		modifyText = (EditText) findViewById(R.id.inPutModifyText);
	
		this.callBack = callBack;
		setAction();
	}

	private void setAction() {
		modifyCheckButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String str ="";
				str = modifyText.getText().toString();
				Log.i("msg", "Str: " + str);
				
				callBack.onCheck(str);
				dismiss();
			}
		});

		modifyCancelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
				callBack.onCancel();
			}
		});
	}

}
