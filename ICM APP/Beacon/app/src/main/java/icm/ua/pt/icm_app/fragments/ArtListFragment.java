package icm.ua.pt.icm_app.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import icm.ua.pt.icm_app.R;
import icm.ua.pt.icm_app.database.DBManager;
import icm.ua.pt.icm_app.database.DatabaseHelper;

public class ArtListFragment extends Fragment {
    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.TITLE, DatabaseHelper.DESC, DatabaseHelper.IMAGE};

    final int[] to = new int[] { R.id.id, R.id.title, R.id.desc, R.id.image_path };

    public ArtListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_art_list, container,         false);

        dbManager = new DBManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setEmptyView(rootView.findViewById(R.id.empty));


        adapter = new SimpleCursorAdapter(rootView.getContext(), R.layout.activity_view_record, cursor, from, to, 0) ;
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView description = (TextView) view.findViewById(R.id.desc);
                TextView title = (TextView) view.findViewById(R.id.title);
                TextView image = (TextView) view.findViewById(R.id.image_path);



                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();


                ArtDetailFragment fragment = ArtDetailFragment.newInstance(description.getText().toString(),title.getText().toString(),image.getText().toString());
                fragment.setDescription(description.getText().toString());

                fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });
       /* Button addButton = (Button) rootView.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {    //nullpointerexception
            @Override
            public void onClick(View v) {
                Intent add_mem = new Intent(getActivity(), AddRecord.class);
                startActivity(add_mem);
            }
        });*/
        return rootView;
    }
}
