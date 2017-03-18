package com.tegabet.dropped;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tegabet.dropped.data_layer.Product;
import com.tegabet.dropped.main_activity.MainActivity;
import com.tegabet.dropped.service_layer.FavoriteProductService;

public class ProductActivity extends AppCompatActivity {

    CoordinatorLayout clCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Retrieve product
        final Product product = (Product) getIntent().getSerializableExtra("product");

        // Set Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(product.getTitle());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        clCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.clCoordinatorLayout);

        FloatingActionButton fabFloatingActionButton = (FloatingActionButton) findViewById(R.id.fabFloatingActionButton);
        fabFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteProductService.getInstance().addFavorite(product);
                Snackbar bar = Snackbar.make(clCoordinatorLayout, "Added To Favorites!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("See Favorites", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });

                bar.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
