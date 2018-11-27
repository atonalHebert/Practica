package com.practica.hebert.fragmentsmenus;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.practica.hebert.fragmentsmenus.adapters.PageAdapter;
import com.practica.hebert.fragmentsmenus.fragments.ListaMascotas;
import com.practica.hebert.fragmentsmenus.fragments.MiMascotaPerfil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        tabLayout = (TabLayout) findViewById(R.id.tabLayout) ;
        viewPager = (ViewPager) findViewById(R.id.viewPager) ;
        setupViewPager() ;
        if(toolbar!=null) setSupportActionBar(toolbar);


    } // fin del método onCreate

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, Contacto.class) ;
                startActivity(intent) ;
                break ;
            case R.id.mAcercade:
                Intent intent0 = new Intent(this, AcercaDe.class) ;
                startActivity(intent0) ;
                break ;
            case R.id.mFavoritos:
                Toast.makeText(this, getString(R.string.menu_favoritos) , Toast.LENGTH_SHORT).show() ;
                break ;
        } // fin del switch
        return super.onOptionsItemSelected(item);
    } // fin del método onOptionsItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu) ;
        return true;
    } // fin del método onCreateOptionMenu

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), listaFragments())) ;
        tabLayout.setupWithViewPager(viewPager) ;
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home) ;
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_poke) ;

    } // fin del método setupViewPager

    private ArrayList<Fragment> listaFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>() ;
        fragments.add(new ListaMascotas()) ;
        fragments.add(new MiMascotaPerfil()) ;
        return fragments ;
    } // fin del método listaFragments

} // fin de la clase MainActivity
