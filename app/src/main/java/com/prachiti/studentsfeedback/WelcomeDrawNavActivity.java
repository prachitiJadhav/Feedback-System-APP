package com.prachiti.studentsfeedback;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static android.system.Os.remove;

public class WelcomeDrawNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth firebaseAuth;
    TextView tvNavEmail;
    Button btnUpper,btnLower,btnEast,btnWest,btnsub;
    int countI=0, countB=0, countE=0, countD=0;
    SharedPreferences sp11,sp22,sp33,sp44;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_draw_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnEast=(Button)findViewById(R.id.btnEast);
        btnWest=(Button)findViewById(R.id.btnWest);
        btnLower=(Button)findViewById(R.id.btnLower);

        btnUpper=(Button)findViewById(R.id.btnUpper);
        btnsub=(Button)findViewById(R.id.btnsub);
        sp11=getSharedPreferences("f1",MODE_PRIVATE);
        sp22=getSharedPreferences("f2",MODE_PRIVATE);
        sp33=getSharedPreferences("f3",MODE_PRIVATE);
        sp44=getSharedPreferences("f4",MODE_PRIVATE);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeDrawNavActivity.this, ShowActivity.class);
                startActivity(i);
            }
        });



        firebaseAuth=FirebaseAuth.getInstance();
        tvNavEmail=(TextView)findViewById(R.id.tvNavEmail);

       btnUpper.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               countI++;
               String cI=String.valueOf(countI);

               SharedPreferences.Editor editor=sp11.edit();
               editor.putString("name",cI);
               editor.commit();
               editor.remove("name");


               /*btnLower.setEnabled(false);
               btnLower.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       btnLower.setEnabled(true);
                   }
               }, 60000);

               btnUpper.setEnabled(false);
               btnUpper.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       btnUpper.setEnabled(true);
                   }
               }, 60000);*/

               Intent i1=new Intent(WelcomeDrawNavActivity.this, ShowActivity.class);
               i1.putExtra("n1",countI);
               startActivity(i1);
           }
       });

        btnLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countB++;
                String cB=String.valueOf(countB);

                SharedPreferences.Editor editor=sp22.edit();
                editor.putString("name",cB);
                editor.commit();
                editor.remove("name");

               /* btnLower.setEnabled(false);
                btnLower.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnLower.setEnabled(true);
                    }
                }, 60000);

                btnUpper.setEnabled(false);
                btnUpper.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnUpper.setEnabled(true);
                    }
                }, 60000);*/

                Intent i2=new Intent(WelcomeDrawNavActivity.this, ShowActivity.class);
                i2.putExtra("n2",countB);
                startActivity(i2);
            }
        });


        btnEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countD++;
                String cD=String.valueOf(countD);

                SharedPreferences.Editor editor=sp33.edit();
                editor.putString("name",cD);
                editor.commit();
                editor.remove("name");

                /*btnEast.setEnabled(false);
                btnEast.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnEast.setEnabled(true);
                    }
                }, 60000);

                btnWest.setEnabled(false);
                btnWest.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnWest.setEnabled(true);
                    }
                }, 60000);*/



                Intent i3=new Intent(WelcomeDrawNavActivity.this, ShowActivity.class);
                i3.putExtra("n3",countD);
                startActivity(i3);
            }
        });


        btnWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countE++;
                String cE=String.valueOf(countE);

                SharedPreferences.Editor editor=sp44.edit();
                editor.putString("name",cE);
                editor.commit();
                editor.remove("name");
                /*btnEast.setEnabled(false);
                btnEast.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnEast.setEnabled(true);
                    }
                }, 60000);

                btnWest.setEnabled(false);
                btnWest.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnWest.setEnabled(true);
                    }
                }, 60000);*/

                Intent i4=new Intent(WelcomeDrawNavActivity.this, ShowActivity.class);
                i4.putExtra("n4",countE);
                startActivity(i4);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        View Headerview =navigationView.getHeaderView(0);
        tvNavEmail = (TextView) Headerview.findViewById(R.id.tvNavEmail);


        //tvNavEmail=(TextView)findViewById(R.id.tvNavEmail);
        String email=firebaseAuth.getCurrentUser().getEmail();
        tvNavEmail.setText(email);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome_draw_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Profile) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_Share) {

        } else if (id == R.id.nav_Logout) {
            firebaseAuth.signOut();
            startActivity(new Intent(WelcomeDrawNavActivity.this,MainActivity.class));
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
