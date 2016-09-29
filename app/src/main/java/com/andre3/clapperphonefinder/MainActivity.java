package com.andre3.clapperphonefinder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, new PlaceholderFragment())
                    .commit();
        }

        ///TODO: Move to service class
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean es = SP.getBoolean("enableSound",false);
        boolean el = SP.getBoolean("enableLight",false);

        System.out.println("Settings" + es);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.activity_main, container, false);

            btn = (Button)rootView.findViewById(R.id.button);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(rootView.getContext(), PreferenceFrag.class);
                    startActivity(i);
                }
            });
            return rootView;
        }

    } //end fragment
}
