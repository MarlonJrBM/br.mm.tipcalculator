package itp341.barbosa.marlon.a3.app;

import itp341.pizzaorder.MainActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String TAG = MainActivity.class.getSimpleName();
	
	private float billAmount = 0;
	EditText editAmount;
	SeekBar seekBarPercent;
	TextView displayTip;
	TextView displayTotal;
	Spinner spinnerSplit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getReferences();
	}
	
	
	
	private void getReferences() {
		Log.d(TAG, "getReferences()");
		editAmount = (EditText) findViewById(R.id.editAmount);
		seekBarPercent = (SeekBar) findViewById(R.id.seekBarPercent);
		displayTip = (TextView) findViewById(R.id.displayTip);
		displayTotal = (TextView) findViewById(R.id.displayTotal);
		spinnerSplit = (Spinner) findViewById(R.id.spinnerSplit);
	}
}
