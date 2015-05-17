package hu.bme.aut.hf.listtest;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ListActivity {
    TodoAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        todos.add(new Todo("title1", Todo.Priority.LOW, "2011. 09. 26.", "description1"));
        todos.add(new Todo("title2", Todo.Priority.MEDIUM, "2011. 09. 27.", "description2"));
        todos.add(new Todo("title3", Todo.Priority.HIGH, "2011. 09. 28.", "description3"));
        adapter = new TodoAdapter(this.getApplicationContext(), todos);
        setListAdapter(adapter);
        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.equals(getListView())) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(((Todo) getListAdapter().getItem(info.position))
                    .getTitle());
            String[] menuItems = getResources()
                    .getStringArray(R.array.todomenu);
            for (int i = 0; i < menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Todo selectedTodo = (Todo) getListAdapter().getItem(position);
        Intent i = new Intent(this.getApplicationContext(),Detail.class);
        Bundle b = new Bundle();
        b.putString("d", selectedTodo.getDescription());
        i.putExtras(b);
        startActivity(i);
    }
}
