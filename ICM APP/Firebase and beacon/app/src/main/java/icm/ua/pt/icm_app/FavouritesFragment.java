package icm.ua.pt.icm_app;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import icm.ua.pt.icm_app.fragments.ArtDetailFragment;
import icm.ua.pt.icm_app.fragments.HomeFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment {


    View v;
    LinearLayout l_layout;

    private FirebaseAuth mAuth;
    private FirebaseUser mFirebaseUser;
    private ArrayList<String> titleText = new ArrayList<>();
    private ArtDetailFragment fragment;
    private ProgressDialog progress;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private ArrayList<String> Favs = new ArrayList<>();
    private ArrayList<String> info = new ArrayList<>();
    private String _Title;

    public FavouritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        return inflater.inflate(R.layout.fragment_favourites, container, false);

    }

    /*
    *
        txt2 = (TextView) rootView.findViewById(R.id.txtFav2);
        txt2.setVisibility(View.VISIBLE);
        txt3 = (TextView) rootView.findViewById(R.id.txtFav3);
        txt4 = (TextView) rootView.findViewById(R.id.txtFav4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                String a = (String) btn1.getText();
                DatabaseReference ref = root.child("Exhibits").child(a);
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                            String infos = (String) singleSnapshot.getValue();
                            info.add(infos);
                        }

                        Iterator it = info.iterator();
                        String beaconID = info.get(0);
                        String desc = info.get(1);
                        String img = info.get(2);
                        String Title = info.get(3);

                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction fragmentTransaction;
                        fragmentTransaction = fragmentManager.beginTransaction();

                        fragment = ArtDetailFragment.newInstance(desc, Title, img);
                        fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



        didiid();
        // Inflate the layout for this fragment
    *
    * **/


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;
        init();
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Syncing");
        progress.setCancelable(false);
        progress.show();
        loadData();

    }


    public void loadData() {

        DatabaseReference dbr = FirebaseDatabase.getInstance().getReference("Users").child(mFirebaseUser.getUid()).child("Favs");
        dbr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot single : dataSnapshot.getChildren()) {
                    titleText.add((String) single.getValue());
                }
                btn1 = (Button) v.findViewById(R.id.txtFav1);
                btn1.setText(titleText.get(0));
                btn1.setVisibility(View.VISIBLE);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mAuth = FirebaseAuth.getInstance();
                        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                        String a = (String) btn1.getText();
                        DatabaseReference ref = root.child("Exhibits").child(a);
                        ref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                                    String infos = (String) singleSnapshot.getValue();
                                    info.add(infos);
                                }

                                Iterator it = info.iterator();
                                String beaconID = info.get(0);
                                String desc = info.get(1);
                                String img = info.get(2);
                                String Title = info.get(3);

                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                android.support.v4.app.FragmentTransaction fragmentTransaction;
                                fragmentTransaction = fragmentManager.beginTransaction();

                                fragment = ArtDetailFragment.newInstance(desc, Title, img);
                                fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                                fragmentTransaction.commit();
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                    }
                });


                //FOR THE SECOND FAVE
                try {
                    btn2 = (Button) v.findViewById(R.id.txtFav2);
                    btn2.setText(titleText.get(1));
                    btn2.setVisibility(View.VISIBLE);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mAuth = FirebaseAuth.getInstance();
                            mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                            String a = (String) btn2.getText();
                            DatabaseReference ref = root.child("Exhibits").child(a);
                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                                        String infos = (String) singleSnapshot.getValue();
                                        info.add(infos);
                                    }

                                    Iterator it = info.iterator();
                                    String beaconID = info.get(0);
                                    String desc = info.get(1);
                                    String img = info.get(2);
                                    String Title = info.get(3);

                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction;
                                    fragmentTransaction = fragmentManager.beginTransaction();

                                    fragment = ArtDetailFragment.newInstance(desc, Title, img);
                                    fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                                    fragmentTransaction.commit();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });


                        }
                    });

                } catch (Exception ex) {
                }


                //FOR THE Third FAVE
                try {
                    btn3 = (Button) v.findViewById(R.id.txtFav3);
                    btn3.setText(titleText.get(2));
                    btn3.setVisibility(View.VISIBLE);
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mAuth = FirebaseAuth.getInstance();
                            mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                            String a = (String) btn3.getText();
                            DatabaseReference ref = root.child("Exhibits").child(a);
                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                                        String infos = (String) singleSnapshot.getValue();
                                        info.add(infos);
                                    }

                                    Iterator it = info.iterator();
                                    String beaconID = info.get(0);
                                    String desc = info.get(1);
                                    String img = info.get(2);
                                    String Title = info.get(3);

                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction;
                                    fragmentTransaction = fragmentManager.beginTransaction();

                                    fragment = ArtDetailFragment.newInstance(desc, Title, img);
                                    fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                                    fragmentTransaction.commit();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });


                        }
                    });

                } catch (Exception ex) {
                }

                //lAST
                //FOR THE Third FAVE
                try {
                    btn4 = (Button) v.findViewById(R.id.txtFav4);
                    btn4.setText(titleText.get(3));
                    btn4.setVisibility(View.VISIBLE);
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mAuth = FirebaseAuth.getInstance();
                            mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                            String a = (String) btn4.getText();
                            DatabaseReference ref = root.child("Exhibits").child(a);
                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                                        String infos = (String) singleSnapshot.getValue();
                                        info.add(infos);
                                    }

                                    Iterator it = info.iterator();
                                    String beaconID = info.get(0);
                                    String desc = info.get(1);
                                    String img = info.get(2);
                                    String Title = info.get(3);

                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction;
                                    fragmentTransaction = fragmentManager.beginTransaction();

                                    fragment = ArtDetailFragment.newInstance(desc, Title, img);
                                    fragmentTransaction.replace(R.id.frame, fragment).addToBackStack("tag");
                                    fragmentTransaction.commit();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });


                        }
                    });

                } catch (Exception ex) {
                }


                progress.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void init() {
        l_layout = (LinearLayout) v.findViewById(R.id.linear_lay);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


    }

}

