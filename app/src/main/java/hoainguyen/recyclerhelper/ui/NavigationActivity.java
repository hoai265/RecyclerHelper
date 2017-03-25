package hoainguyen.recyclerhelper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import hoainguyen.recyclerhelper.ui.gallery.ChooseImageActivity;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.ui.mvp.MVPEndlessFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_baseFragment:
                BaseFragment baseFragment = new BaseFragment();
                replaceFragment(baseFragment);
                break;
            case R.id.nav_endlessFragment:
                EndlessFragment endlessFragment = new EndlessFragment();
                replaceFragment(endlessFragment);
                break;
            case R.id.nav_mvpEndlessFragment:
                MVPEndlessFragment mvpEndlessFragment = new MVPEndlessFragment();
                replaceFragment(mvpEndlessFragment);
                break;
            case R.id.nav_imageEndlessFragment:
                Intent intent = new Intent(this, ChooseImageActivity.class);
                startActivity(intent);
//                ImageGalleryFragment imageGalleryFragment = new ImageGalleryFragment();
//                replaceFragment(imageGalleryFragment);
                break;
            case R.id.nav_bindingItem:
                BindingItemFragment bindingItemFragment = new BindingItemFragment();
                replaceFragment(bindingItemFragment);
                break;
            case R.id.nav_GroupAdapter:
                GroupAdapterFragment groupAdapterFragment = new GroupAdapterFragment();
                replaceFragment(groupAdapterFragment);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentFragment != null) {
            transaction = transaction.remove(mCurrentFragment);
        }
        transaction.replace(R.id.fragment_holder, fragment).commit();
        mCurrentFragment = fragment;
    }
}
