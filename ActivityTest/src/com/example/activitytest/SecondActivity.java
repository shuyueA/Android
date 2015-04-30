package com.example.activitytest;

import android.R.string;

import java.lang.String;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.*;

public class SecondActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.secont_layout);
		//Intent intent=getIntent();//获取用于启动SecondActivity的Intent
		//String data= intent.getStringExtra("extra_data");
		//getIntExtra getBooleanExtra 以此类推
		//Log.d("SecondActivtiy",data);
		Button button2=(Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent();
				intent.putExtra("data_return", "hello FirstActivtiy");
				setResult(RESULT_OK,intent);
				//setResult()方法接收两个参数， 第一个参数用于向上一个活动返回处理结果，
				//一般只使用RESULT_OK或RESULT_CANCELED 这两个值，第二个参数则是把带有数据的Intent 传递回去，
				//然后调用了finish()方法来销毁当前活动
				finish();
			}
		});
	}
	@Override
	public void onBackPressed() {
	Intent intent = new Intent();
	intent.putExtra("data_return", "Hello FirstActivity");
	setResult(RESULT_OK, intent);
	finish();
	}
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);		
		return true;//返回true允许显示出来, false将无法显示
	}
	public boolean onOptionItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.add_item:
			Toast.makeText(this, "you clicked add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this,"you clicked remove",Toast.LENGTH_SHORT).show();
			break;
		default:
		}
		return true;
	}

}
