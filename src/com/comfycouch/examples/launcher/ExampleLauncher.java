package com.comfycouch.examples.launcher;

import java.util.Arrays;

import org.andengine.AndEngine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.comfycouch.examples.R;

public class ExampleLauncher extends ExpandableListActivity {

	// ==========================================
	// CONSTANTS
	// ==========================================
	private static final String PREF_LAST_APP_LAUNCH_VERSIONCODE_ID = "last.app.launch.versioncode";
	
	private static final int DIALOG_FIRST_APP_LAUNCH = 0;
	private static final int DIALOG_NEW_IN_THIS_VERSION = ExampleLauncher.DIALOG_FIRST_APP_LAUNCH + 1;
	private static final int DIALOG_BENCHMARKS_SUBMIT_PLEASE = ExampleLauncher.DIALOG_NEW_IN_THIS_VERSION + 1;
	private static final int DIALOG_DEVICE_NOT_SUPPORTED = ExampleLauncher.DIALOG_BENCHMARKS_SUBMIT_PLEASE + 1;
	
	// ==========================================
	// FIELDS
	// ==========================================
	private ExpandableExampleLauncherListAdapter mExpandableExampleLauncherListAdapter;
	
	private int mVersionCodeCurrent;
	private int mVersionCodeLastLaunch;
	
	// ==========================================
	// CONSTRUCTORS
	// ==========================================
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(!AndEngine.isDeviceSupported(null)) {
			this.showDialog(ExampleLauncher.DIALOG_DEVICE_NOT_SUPPORTED);
		}
		
		this.setContentView(R.layout.list_examples);
		
		this.mExpandableExampleLauncherListAdapter = new ExpandableExampleLauncherListAdapter(this);
		
		this.setListAdapter(this.mExpandableExampleLauncherListAdapter);
		
		this.findViewById(R.id.btn_get_involved).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				ExampleLauncher.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://andengine.org")));
			}
			
		});
		
		final SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
		
		this.mVersionCodeCurrent = this.getVersionCode();
		this.mVersionCodeLastLaunch = prefs.getInt(ExampleLauncher.PREF_LAST_APP_LAUNCH_VERSIONCODE_ID, -1);
		
		if(this.isFirstTime("first.app.launch")) {
			this.showDialog(ExampleLauncher.DIALOG_FIRST_APP_LAUNCH);
		} else if ((this.mVersionCodeLastLaunch != -1) && (this.mVersionCodeLastLaunch < this.mVersionCodeCurrent)) {
			this.showDialog(ExampleLauncher.DIALOG_NEW_IN_THIS_VERSION);
		} else if (this.isFirstTime("please.submit.benchmarks")) {
			this.showDialog(ExampleLauncher.DIALOG_BENCHMARKS_SUBMIT_PLEASE);
		}
		
		prefs.edit().putInt(ExampleLauncher.PREF_LAST_APP_LAUNCH_VERSIONCODE_ID, this.mVersionCodeCurrent).commit();
	}
	
	// ==========================================
	// GETTER & SETTER
	// ==========================================
	
	
	// ==========================================
	// METHODS FOR/FROM SUPERCLASS/INTERFACES
	// ==========================================
	
	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(final int pId) {
		switch(pId) {
			case DIALOG_DEVICE_NOT_SUPPORTED:
				return new AlertDialog.Builder(this)
					.setTitle(R.string.dialog_device_not_supported_title)
					.setMessage(R.string.dialog_device_not_supported_message)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setPositiveButton(android.R.string.ok, null)
					.create();
			case DIALOG_FIRST_APP_LAUNCH:
				return new AlertDialog.Builder(this)
					.setTitle(R.string.dialog_first_app_launch_title)
					.setMessage(R.string.dialog_first_app_launch_message)
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(android.R.string.ok, null)
					.create();
			case DIALOG_BENCHMARKS_SUBMIT_PLEASE:
				return new AlertDialog.Builder(this)
					.setTitle(R.string.dialog_benchmarks_submit_please_title)
					.setMessage(R.string.dialog_benchmarks_submit_please_message)
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(android.R.string.ok, null)
					.create();
			case DIALOG_NEW_IN_THIS_VERSION:
				final int[] versionCodes = this.getResources().getIntArray(R.array.new_in_version_versioncode);
				final int versionDescriptionsStartIndex = Math.max(0, Arrays.binarySearch(versionCodes, this.mVersionCodeLastLaunch)+ 1);
				
				final String[] versionDescriptions = this.getResources().getStringArray(R.array.new_in_version_changes);
				
				final StringBuilder sb = new StringBuilder();
				for(int i = versionDescriptions.length - 1; i >= versionDescriptionsStartIndex; i--) {
					sb.append("--------------------------\n");
					sb.append(">>> Version: " + versionCodes[i] + "\n");
					sb.append("--------------------------\n");
					sb.append(versionDescriptions[i]);
					
					if(i > versionDescriptionsStartIndex) {
						sb.append("\n\n");
					}
				}
				
				return new AlertDialog.Builder(this)
					.setTitle(R.string.dialog_new_in_this_version_title)
					.setMessage(sb.toString())
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton(android.R.string.ok, null)
					.create();
			default:
				return super.onCreateDialog(pId);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.example_launcher, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
