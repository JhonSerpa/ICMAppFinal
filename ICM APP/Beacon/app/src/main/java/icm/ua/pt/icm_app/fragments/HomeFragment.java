package icm.ua.pt.icm_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import icm.ua.pt.icm_app.R;

public class HomeFragment extends Fragment{
    private Intent serviceIntent;


    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
      //  args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    //    if (getArguments() != null) {
     //       mParam1 = getArguments().getString(ARG_PARAM1);
     //       mParam2 = getArguments().getString(ARG_PARAM2);
     //   }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.content_main, container,         false);
        Button currentExhibition = (Button) rootView.findViewById(R.id.current_exhibition_button);
        currentExhibition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();
                ArtListFragment fragment = new ArtListFragment();
                fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

}
