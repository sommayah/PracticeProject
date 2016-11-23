package com.sommayah.practiceproject;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ShareFragment.OnFragmentInteractionListener {

    //private me.tatarka.support.job.JobScheduler mJobScheduler;
    private JobScheduler mJobScheduler;
    private static final int JOB_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //mJobScheduler = me.tatarka.support.job.JobScheduler.getInstance(this);
       // constructJob();
        mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        constructJobLolli();

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*private void constructJob(){
        me.tatarka.support.job.JobInfo.Builder builder = new me.tatarka.support.job.JobInfo.Builder(JOB_ID, new ComponentName(this, MyJobService.class));
        builder.setPeriodic(2000)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
        .setPersisted(true);
        mJobScheduler.schedule(builder.build());
    }*/

    private void constructJobLolli(){
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(this, MyJobService.class));
        builder.setPeriodic(2000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true);
        mJobScheduler.schedule(builder.build());
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action

            CameraFragment cameraFragment = new CameraFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment, cameraFragment, cameraFragment.getTag()).commit();

        } else if (id == R.id.nav_gallery) {
            GallaryFragment gallaryFragment = GallaryFragment.newInstance("some1","some2");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment,
                    gallaryFragment, gallaryFragment.getTag()).commit();




        } else if (id == R.id.nav_slideshow) {


        } else if (id == R.id.nav_manage) {


        } else if (id == R.id.nav_share) {
            ShareFragment shareFragment = ShareFragment.newInstance(5);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragment,
                    shareFragment, shareFragment.getTag()).commit();


        } else if (id == R.id.nav_send) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String data) {

        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
