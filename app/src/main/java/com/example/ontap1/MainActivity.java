package com.example.ontap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.id_toolbar);
        recyclerView = findViewById(R.id.id_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = getListUser();
        userAdapter = new UserAdapter(userList);
        userAdapter.setData(getListUser());
        recyclerView.setAdapter(userAdapter);
        iNitToolBar();

    }

    private void iNitToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }


    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.anhgaixinh01,"Ngọc Huyền"));
        list.add(new User(R.drawable.anhgaixinh02,"Yến Nhi"));
        list.add(new User(R.drawable.anhgaixinh03,"Trâm Anh"));
        list.add(new User(R.drawable.anhgaixinh04,"Quỳnh Nga"));
        list.add(new User(R.drawable.anhgaixinh05,"Như Ngọc"));
        list.add(new User(R.drawable.anhleeminho,"Lee Min Hoo"));
        list.add(new User(R.drawable.anhmessi,"Messi"));
        list.add(new User(R.drawable.anhneimar,"Neir Ma"));
        list.add(new User(R.drawable.anhgaixinh01,"Lan Ngọc"));
        list.add(new User(R.drawable.anhgaixinh02,"Cẩm Tú"));
        list.add(new User(R.drawable.anhgaixinh03,"Hoài Thương"));
        list.add(new User(R.drawable.anhgaixinh04,"Thủy Tiên"));
        list.add(new User(R.drawable.anhgaixinh05,"Trang Anh"));
        list.add(new User(R.drawable.anhleeminho,"Kim Jong Park"));
        list.add(new User(R.drawable.anhmessi,"David Jack"));
        list.add(new User(R.drawable.anhneimar,"Joins Pydon"));
        list.add(new User(R.drawable.anhgaixinh01,"Thanh Thúy"));
        list.add(new User(R.drawable.anhgaixinh02,"Thu Thảo"));
        list.add(new User(R.drawable.anhgaixinh03,"Thảo Ly"));
        list.add(new User(R.drawable.anhgaixinh04,"Nguyễn Ngọc"));
        list.add(new User(R.drawable.anhgaixinh05,"Bình An"));
        list.add(new User(R.drawable.anhleeminho,"David Marcobus"));
        list.add(new User(R.drawable.anhmessi,"Jen Peter"));
        list.add(new User(R.drawable.anhneimar,"Doremon Gragon"));
        return list;
    }
}