package com.iak.finalproject.listiani.popularmovielisti.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.iak.finalproject.listiani.popularmovielisti.R;
import com.iak.finalproject.listiani.popularmovielisti.model.MovieResponse;
import com.iak.finalproject.listiani.popularmovielisti.network.NetworkManager;

public class MainActivity extends AppCompatActivity implements NetworkManager.NetworkCallback {
    public static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    String SORT_BY = "POPULAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        if (savedInstanceState!=null)
        {
            SORT_BY = savedInstanceState.getString("SORT_BY");
            Log.d(TAG,"Status sorting : "+SORT_BY);
            switch (SORT_BY) {
                case "POPULAR":
                    NetworkManager.getPopularMovie(1, this);
                    break;

                case "TOP RATED":
                    NetworkManager.getTopRatedMovie(1, this);
                    break;
            }
        }
        else{
            NetworkManager.getPopularMovie(1, this);
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SORT_BY",SORT_BY);
    }

    //    TODO RECYCLER VIEW 1 > setUp RecyclerView, tentukan mau pake layout manager apa dia
//    TODO RECYCLER VIEW 2 > BUAT ADAPTER
    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
    }

    //    TODO RECYCLER VIEW 3 > SET ADAPTER
    public void onFailure(Throwable t) {
        Log.e(TAG, "", t);
    }

    public void onSuccess(MovieResponse movieResponse) {
        adapter.setItems(movieResponse.getResults());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        switch (SORT_BY) {
            case "POPULAR":
                menu.findItem(R.id.action_sort_by_popularity).setChecked(true);
                break;
            case "TOP RATED":
                menu.findItem(R.id.action_sort_by_rating).setChecked(true);
                break;
            case "FAVORITE":
                menu.findItem(R.id.action_sort_by_favourite).setChecked(true);
                break;
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // respond to menu item clicked
        int idClicked = item.getItemId();
        switch (idClicked) {
            case R.id.action_sort_by_popularity:
                SORT_BY = "POPULAR";
                NetworkManager.getPopularMovie(1, this);
                item.setChecked(true);
                break;

            case R.id.action_sort_by_rating:
                SORT_BY = "TOP RATED";
                NetworkManager.getTopRatedMovie(1, this);
                item.setChecked(true);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
