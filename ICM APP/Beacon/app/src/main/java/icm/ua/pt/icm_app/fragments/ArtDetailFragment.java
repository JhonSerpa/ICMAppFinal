package icm.ua.pt.icm_app.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import icm.ua.pt.icm_app.R;

public class ArtDetailFragment extends Fragment {

    private String description;
    private String id;
    private String imagePath;
    public ArtDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            description = getArguments().getString("DESCRIPTION");
            id = getArguments().getString("TITLE");
            imagePath = getArguments().getString("IMAGE");
        }

    }

    public static ArtDetailFragment newInstance(String description, String title,String image) {
        ArtDetailFragment fragment = new ArtDetailFragment();
        Bundle args = new Bundle();
        args.putString("DESCRIPTION",description);
        args.putString("TITLE",title);
        args.putString("IMAGE",image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_art_detail, container, false);

        TextView desc = rootView.findViewById(R.id.art_description_text);
        TextView id = rootView.findViewById(R.id.art_title_text);
        ImageView imageView = rootView.findViewById(R.id.image_detail);
        desc.setText(this.description);
        int resID = getResources().getIdentifier(this.imagePath, "drawable", getActivity().getPackageName());
        imageView.setImageResource(resID);
        id.setText(this.id);


        ImageView sound = (ImageView) rootView.findViewById(R.id.play_button);
        final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.sound);
        sound.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });


        return rootView;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
