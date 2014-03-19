package com.comfycouch.examples.util;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.comfycouch.examples.R;

/**
 * This Activity appears as a dialog. It lists any paired devices and
 * devices detected in the area after discovery. When a device is chosen
 * by the user, the MAC address of the device is sent back to the parent
 * Activity in the result Intent.
 * 
 * 
 * @author ron
 *
 */
public class BluetoothListDevicesActivity extends Activity {

	// ==========================================
	// CONSTANTS
	// ==========================================
	
	public static String EXTRA_DEVICE_ADDRESS = "device_address";
	
	// ==========================================
	// FIELDS
	// ==========================================
	private BluetoothAdapter mBluetoothAdapter;
	private ArrayAdapter<String> mPairedDevicesArrayAdapter;
	private ArrayAdapter<String> mNewDevicesArrayAdapter;
	
	private final OnItemClickListener mDeviceClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(final AdapterView<?> pAdapterView, final View pView, final int pPosition, final long pID) {
			//cancel discovery because it's costly and we're about to connect
			BluetoothListDevicesActivity.this.mBluetoothAdapter.cancelDiscovery();
			
			//get the device MAC address, which is the last 17 chars in the View
			final String info = ((TextView)pView).getText().toString();
			final String address = info.substring(info.length() - 17);
			
			//create the result intent and include the MAC address
			final Intent intent = new Intent();
			intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
			
			//set result and finish this activity
			BluetoothListDevicesActivity.this.setResult(Activity.RESULT_OK, intent);
			BluetoothListDevicesActivity.this.finish();
		}
		
	};
	
	//The BroadcastReceiver that listens for discovered devices and
	//changes the title when discovery is finished
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(final Context pContext, final Intent pIntent) {
			final String action = pIntent.getAction();
			
			if(action.equals(BluetoothDevice.ACTION_FOUND)) {
				final BluetoothDevice device = pIntent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				if(device.getBondState() != BluetoothDevice.BOND_BONDED) {
					BluetoothListDevicesActivity.this.mNewDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
				}
			} else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
				BluetoothListDevicesActivity.this.setProgressBarIndeterminateVisibility(false);
				BluetoothListDevicesActivity.this.setTitle("Select a device to connect...");
				if(BluetoothListDevicesActivity.this.mNewDevicesArrayAdapter.getCount() == 0) {
					BluetoothListDevicesActivity.this.mNewDevicesArrayAdapter.add("No devices found!");
				}
			}
		}
	}; 
	
	// ==========================================
	// CONSTRUCTOR
	// ==========================================
	
	@Override
	protected void onCreate(final Bundle pSavedInstanceState) {
		super.onCreate(pSavedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		this.setContentView(R.layout.list_bluetooth_devices);
		
		//set result CANCELED in case the user backs out
		this.setResult(Activity.RESULT_CANCELED);
		
		final Button scanButton = (Button) this.findViewById(R.id.button_scan);
		
		scanButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(final View v) {
				BluetoothListDevicesActivity.this.discoverBluetoothDevices();
				v.setVisibility(View.GONE);
			}
			
		});
		
		this.mPairedDevicesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		this.mNewDevicesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		final ListView pairedListView = (ListView) this.findViewById(R.id.paired_devices);
		pairedListView.setAdapter(this.mPairedDevicesArrayAdapter);
		pairedListView.setOnItemClickListener(this.mDeviceClickListener);
		
		final ListView newDevicesListView = (ListView) this.findViewById(R.id.new_devices);
		newDevicesListView.setAdapter(this.mNewDevicesArrayAdapter);
		newDevicesListView.setOnItemClickListener(this.mDeviceClickListener);
		
		//register for broadcasts when a device is discovered
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(this.mReceiver, filter);
		
		//register for broadcasts when discovery is finished
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(this.mReceiver, filter);
		
		this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		//get a set of currently paired devices
		final Set<BluetoothDevice> pairedDevices = this.mBluetoothAdapter.getBondedDevices();
		if(pairedDevices.size() > 0) {
			this.findViewById(R.id.title_paired_devices).setVisibility(View.VISIBLE);
			for(final BluetoothDevice device : pairedDevices) {
				this.mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
			}
		} else {
			this.mPairedDevicesArrayAdapter.add("No devices have been paired!");
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		//make sure we're not doing discovery anymore
		if(this.mBluetoothAdapter != null) {
			this.mBluetoothAdapter.cancelDiscovery();
		}
		
		//Unregister broadcast listeners
		this.unregisterReceiver(this.mReceiver);
	}
	
	// ==========================================
	// METHODS
	// ==========================================
	
	private void discoverBluetoothDevices() {
		this.setProgressBarIndeterminateVisibility(true);
		this.setTitle("Scanning for Devices...");
		
		this.findViewById(R.id.title_new_devices).setVisibility(View.VISIBLE);
		
		if(this.mBluetoothAdapter.isDiscovering()) {
			this.mBluetoothAdapter.cancelDiscovery();
		}
		
		this.mBluetoothAdapter.startDiscovery();
	}
}
