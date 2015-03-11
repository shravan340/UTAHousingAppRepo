package utahousing.seproject.com.utahousing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewApartmentFragment extends Fragment {


    public ViewApartmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_view_apartment, container, false);
        populateApartmentList(rootView);
        return rootView;
    }

    private void populateApartmentList(View rootView) {
        Spinner apartmentListSpinner=(Spinner) rootView.findViewById(R.id.sp_apartmentlist);
        ArrayAdapter<CharSequence> apartmentListAdapter=
                ArrayAdapter.createFromResource(this.getActivity(), R.array.apartmentsList,android.R.layout.simple_spinner_item);
        apartmentListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        apartmentListSpinner.setAdapter(apartmentListAdapter);
    }
}
