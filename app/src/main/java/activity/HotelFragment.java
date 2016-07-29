package activity;


import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import hermannozor.com.mytown_cameroon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener,
        LocationListener{


    GoogleMap mGoogleMap;
    MapView mapView;

    View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsInitializer.initialize(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_hotel, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) mView.findViewById(R.id.map);
        if (mapView != null) {
            // Initialise the MapView
            mapView.onCreate(null);
            mapView.onResume();
            // Set the map ready callback to receive the GoogleMap object
            mapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        LatLng marker = new LatLng(3.8573716,11.5043116);
        mGoogleMap.setOnMarkerClickListener(this);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 13));


        mGoogleMap.addMarker(new MarkerOptions()
                .position(marker)
                .title("E.U")
                .snippet("Express Union Ngoa Ekelle")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.bed_sleep_hotel_motel)));
        if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mGoogleMap.setMyLocationEnabled(true);


    }


    @Override
    public boolean onMarkerClick(Marker marker) {


        return true;
    }


    @Override
    public void onLocationChanged(Location location) {

    }
}
