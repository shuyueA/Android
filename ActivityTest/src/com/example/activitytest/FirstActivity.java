package com.example.activitytest;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.*;
//import android.view.View.OnClickListener;


public class FirstActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏 必须在在setContentView之前
		setContentView(R.layout.first_layout);
		Button button1=(Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				/*Toast.makeText(FirstActivity.this, "you clicked button 1", Toast.LENGTH_SHORT).show();
				 *finish();
				//会按顺序执行Toast和finish
				 */
				
				//构建intent(显式)
				//Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				//startActivity(intent);//执行intent
			    
				//构建隐式intent
				/*Intent intent=new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");//添加一个category
				startActivity(intent);
				*/
				//访问网页
				Intent intent =new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
			
		});
		Button button2=(Button) findViewById(R.id.buttonTo3);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//String data="Hello ThirdActivtiy";
				Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				//intent.putExtra("extra_data", data);//第一个参数是键 第二个参数为传递的数据
				startActivityForResult(intent, 1);
				//finish();
			}
		});
		Button telButton=(Button) findViewById(R.id.telButton);
		telButton.setOnClickListener(new OnClickListener(){
			public void onClick (View v){
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
				finish();
			}
		});
		
	
	}
	@Override
	//在SecondActivity	被销毁之后会回调上一个活动的onActivityResult()方法
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
		if (resultCode == RESULT_OK) {
			String returnedData = data.getStringExtra("data_return");
			Log.d("FirstActivity", returnedData);
			}
			break;
		default:
		}
		}

	
	/*
	 * 调用getMenuInflater得到MenuInfalter对象,调用inflate创建菜单
	 * inflate接受两个参数第一个参数用于指定我们通过哪一个资源文件来创建菜单(R.mune.main)
	 * 第二个指定我们带菜单项添加到哪个menu中(这里直接使用了onCreateOptionMenu()方法传入的形参)
	*/
	@Override
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
