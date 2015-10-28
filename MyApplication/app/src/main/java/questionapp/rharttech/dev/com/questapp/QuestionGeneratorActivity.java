package questionapp.rharttech.dev.com.questapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;


public class QuestionGeneratorActivity extends ActionBarActivity {

    private ArrayAdapter<CharSequence> adapterQuantifierUpper;
    private ArrayAdapter<CharSequence> adapterQuantifierLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_generator);

        //verb spinner
        Spinner spinnerVerb = (Spinner) findViewById(R.id.spinnerVerb);
        ArrayAdapter<CharSequence> adapterVerb = ArrayAdapter.createFromResource(this,
                R.array.array_verbs, android.R.layout.simple_spinner_item);
        adapterVerb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVerb.setAdapter(adapterVerb);

        //quantities spinner
        final Spinner spinnerQuantifier = (Spinner) findViewById(R.id.spinnerQuantifier);

         adapterQuantifierUpper = ArrayAdapter.createFromResource(this,
                R.array.array_quantifier_upper, android.R.layout.simple_spinner_item);
        adapterQuantifierUpper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       adapterQuantifierLower = ArrayAdapter.createFromResource(this,
                R.array.array_quantifier_lower, android.R.layout.simple_spinner_item);
        adapterQuantifierLower.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set it to be lower to start with
        spinnerQuantifier.setAdapter(adapterQuantifierLower);


        spinnerVerb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

              //work out whether to show the upper or lower quantifiers
                if(i < 10){
                    //set to be lower
                    spinnerQuantifier.setAdapter(adapterQuantifierLower);
                } else {
                    //set to be higher
                    spinnerQuantifier.setAdapter(adapterQuantifierUpper);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //don't worry here
            }
        });




    }
}
