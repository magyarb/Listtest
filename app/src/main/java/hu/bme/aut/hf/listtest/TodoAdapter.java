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
 * Created by Bal�zs on 2015.05.16..
 */
public class TodoAdapter extends BaseAdapter{

    private final List<Todo> todos;

    public TodoAdapter(final Context context, final ArrayList<Todo> aTodos) { //elt�roljuk a megjelen�tend� arraylistet
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
     * Sor megjelen�t�s�nek be�ll�t�sa
     */
    public View getView(int position, View convertView, ViewGroup parent) { //visszaadja view-k�nt az adott poz�ci�ban l�v� elemet

        final Todo todo = todos.get(position); //lek�ri a todo-t, amit fel kell f�jni

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService( //beszerz�nk egy inflatert
                Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.todorow, null); //amivel felf�junk egy �j view-t(lehetne �jrafelhaszn�lni, gyorsabb)

        ImageView imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewPriority); //megkeress�k a k�pet

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

        TextView textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle); //meg a sz�vegeket, �s be is �ll�tjuk
        textViewTitle.setText(todo.getTitle());

        TextView textViewDueDate = (TextView) itemView.findViewById(R.id.textViewDueDate);
        textViewDueDate.setText(todo.getDueDate());

        return itemView; //majd visszaadjuk
    }

    /**
     * Egy elem t�rl�se
     */
    public void deleteRow(Todo aTodo) {
        if(todos.contains(aTodo)) {
            todos.remove(aTodo);
        }
    }
}
