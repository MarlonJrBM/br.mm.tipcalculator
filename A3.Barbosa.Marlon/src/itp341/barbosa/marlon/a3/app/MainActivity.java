package itp341.barbosa.marlon.a3.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private float billAmount = 0;
	private float tipAmount = 0;
	private float totalAmount = 0;
	private float perPerson = 0;
	int numPpl = 1;
	EditText editAmount;
	SeekBar seekBarPercent;
	TextView displayPercent;
	TextView displayTip;
	TextView displayTotal;
	TextView textPerPerson;
	TextView displayPerPerson;
	Spinner spinnerSplit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getReferences();
		setListeners();

	}

	private void getReferences() {
		Log.d(TAG, "getReferences()");
		editAmount = (EditText) findViewById(R.id.editAmount);
		seekBarPercent = (SeekBar) findViewById(R.id.seekBarPercent);
		displayTip = (TextView) findViewById(R.id.displayTip);
		displayPercent = (TextView) findViewById(R.id.percentDisplay);
		displayTotal = (TextView) findViewById(R.id.displayTotal);
		spinnerSplit = (Spinner) findViewById(R.id.spinnerSplit);
		displayPerPerson = (TextView) findViewById(R.id.displayPerPerson);
		textPerPerson = (TextView) findViewById(R.id.textPerPerson);
	}

	private void setTotal() {
		Log.d(TAG, "setTotal()");
		setBillAmount();
		setTipAmount();
		totalAmount = billAmount + tipAmount;
		Log.d(TAG, String.valueOf(totalAmount));
		if (displayTotal != null)
			displayTotal.setText(String.format("$%.2f", totalAmount));
		setPerPerson();

	}

	private void setPerPerson() {
		Log.d(TAG, "setPerPerson()");
		perPerson = totalAmount / numPpl;
		if (numPpl == 1) {

			if (textPerPerson != null) {
				textPerPerson.setVisibility(View.GONE);

			}
			if (displayPerPerson != null) {
				displayPerPerson.setVisibility(View.GONE);

			}

		} else {

			if (textPerPerson != null) {
				textPerPerson.setVisibility(View.VISIBLE);

			}
			if (displayPerPerson != null) {
				displayPerPerson.setText(String.format("$%.2f", perPerson));
				displayPerPerson.setVisibility(View.VISIBLE);

			}
		}

	}

	private void setBillAmount() {
		Log.d(TAG, "setBillAmount()");
		if (editAmount != null) {
			String value = ((EditText) editAmount).getText().toString();
			if (!value.trim().isEmpty()) {
				billAmount = Float.parseFloat(value);
			} else {
				billAmount = 0;
			}
		}

	}
	
	private void setTipAmount() {
		int percentage = seekBarPercent.getProgress();
		tipAmount = (percentage * billAmount) / 100;
		if (displayPercent != null) {
			displayPercent.setText(String.format("%d%%", percentage
					));
		}
		if (displayTip != null) {
			displayTip.setText(String
					.format("$%.2f", tipAmount));
		}
		
	}

	private void setListeners() {
		Log.d(TAG, "setListeners()");

		// editAmount listener

		editAmount.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				Log.d(TAG, "onEditorAction - billAmount");
				setTotal();
				return false;
			}
		});

		// seekBarPercentlistener
		seekBarPercent
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						// TODO Auto-generated method stub
						Log.d(TAG, "onProgressChanged - seekBarPercent");
						setTotal();

					}
				});

		// spinnerSplit listener

		spinnerSplit.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.d(TAG, "OnItemSelectedListener() - " + position);
				numPpl = position + 1;
				setTotal();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

}
