package hu.bme.aut.hf.listtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balázs on 2015.05.16..
 */
public class TodoAdapter extends BaseAdapter{

    private final List<Todo> todos;

    public TodoAdapter(final Context context, final ArrayList<Todo> aTodos) { //eltároljuk a megjelenítendõ arraylistet
        todos = aTodos;
    }

    public void addItem(Todo aTodo)
    {
        todos.add(aTodo);
    }

    public int getCount() {
        return todos.size();
    }

    public Object getItem(int position) {
        return todos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    /**
     * Sor megjelenítésének beállítása
     */
    public View getView(int position, View convertView, ViewGroup parent) { //visszaadja view-ként az adott pozícióban lévõ elemet

        final Todo todo = todos.get(position); //lekéri a todo-t, amit fel kell fújni

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService( //beszerzünk egy inflatert
                Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.todorow, null); //amivel felfújunk egy új view-t(lehetne újrafelhasználni, gyorsabb)

        ImageView imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewPriority); //megkeressük a képet

        switch (todo.getPriority()) {
            case LOW:
                imageViewIcon.setImageResource(R.drawable.low);
                break;
            case MEDIUM:
                imageViewIcon.setImageResource(R.drawable.medium);
                break;
            case HIGH:
                imageViewIcon.setImageResource(R.drawable.high);
                break;
            default:
                imageViewIcon.setImageResource(R.drawable.high);
                break;
        }

        TextView textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle); //meg a szövegeket, és be is állítjuk
        textViewTitle.setText(todo.getTitle());

        TextView textViewDueDate = (TextView) itemView.findViewById(R.id.textViewDueDate);
        textViewDueDate.setText(todo.getDueDate());

        return itemView; //majd visszaadjuk
    }

    /**
     * Egy elem törlése
     */
    public void deleteRow(Todo aTodo) {
        if(todos.contains(aTodo)) {
            todos.remove(aTodo);
        }
    }
}
