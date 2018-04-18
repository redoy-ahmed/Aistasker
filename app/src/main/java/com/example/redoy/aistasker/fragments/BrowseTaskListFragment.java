package com.example.redoy.aistasker.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.redoy.aistasker.R;
import com.example.redoy.aistasker.activities.BrowseTasksFilterActivity;
import com.example.redoy.aistasker.adapters.TaskListAdapter;
import com.example.redoy.aistasker.models.TaskItem;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pchmn.materialchips.ChipView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Redoy on 3/26/2018.
 */

public class BrowseTaskListFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    View rootView;

    //private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    //private MenuItem menuItem;

    @BindView(R.id.browse_tasks_button_empty_state_change_filter)
    Button mButtonEmptyStateChangeFilter;

    @BindView(R.id.browse_tasks_layout_empty)
    View mLayoutEmptyState;

    @BindView(R.id.browse_tasks_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.browse_tasks_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.browse_tasks_chip_widget_task_type)
    ChipView mChipWidgetTaskType;

    @BindView(R.id.browse_tasks_chip_widget_task_location)
    ChipView mChipWidgetTaskLocation;

    @BindView(R.id.browse_tasks_chip_widget_task_price)
    ChipView mChipWidgetTaskPrice;

    @BindView(R.id.browse_tasks_layout_map)
    MapView mapView;

    @BindView(R.id.browse_tasks_without_google_map)
    CoordinatorLayout mBrowseTaskLayout;

    private TaskListAdapter taskListAdapter;
    public LinearLayoutManager linearLayoutManager;
    FusedLocationProviderClient mFusedLocationClient;
    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    protected static long MIN_UPDATE_INTERVAL = 30 * 100;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    boolean isFirstTime = true;
    double latitude;
    double longitude;
    LatLng latLng;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_browse_task_list, container, false);
        ButterKnife.bind(this, rootView);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(rootView.getContext());
        setHasOptionsMenu(true);
        initializeData(savedInstanceState);

        return rootView;
    }

    private void initializeData(Bundle savedInstanceState) {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }

        if (!isGooglePlayServicesAvailable()) {
            Log.d("onCreate", "Google Play Services not available. Ending Test case.");
        } else {
            Log.d("onCreate", "Google Play Services available. Continuing.");
        }

        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        mChipWidgetTaskType.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_type_all));
        mChipWidgetTaskLocation.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_location));
        mChipWidgetTaskPrice.setLabel(rootView.getContext().getString(R.string.browse_tasks_chip_task_price_any));

        ArrayList<TaskItem> rowListItem = getAllItemList();

        linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        taskListAdapter = new TaskListAdapter(rootView.getContext(), rowListItem);
        mRecyclerView.setAdapter(taskListAdapter);
    }

    private ArrayList<TaskItem> getAllItemList() {

        ArrayList<TaskItem> allItems = new ArrayList<>();
        allItems.add(new TaskItem("Task 1", "Australia", "Saturday, Mar 31, 2018", "Clean my house", "Drafted", "additional information", "A$250"));
        allItems.add(new TaskItem("Task 2", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information", "A$250"));
        allItems.add(new TaskItem("Task 3", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information", "A$270"));
        allItems.add(new TaskItem("Task 4", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information", "A$280"));
        allItems.add(new TaskItem("Task 5", "Australia", "Saturday, Mar 31, 2018", "clean my clothes", "Drafted", "additional information", "A$300"));

        return allItems;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.browse_tasks_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.browse_task_action_filter:
                startActivity(new Intent(rootView.getContext(), BrowseTasksFilterActivity.class));
                return true;
            case R.id.browse_task_action_toggle:
                mBrowseTaskLayout.setVisibility(View.GONE);
                mapView.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(rootView.getContext());
        if (result != ConnectionResult.SUCCESS) {
            if (googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(getActivity(), result,
                        0).show();
            }
            return false;
        }
        return true;
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(MIN_UPDATE_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    Location currentLocation = locationResult.getLastLocation();
                    mLastLocation = currentLocation;

                    if (mCurrLocationMarker != null) {
                        mCurrLocationMarker.remove();
                    }
                    if (isFirstTime) {
                        latitude = currentLocation.getLatitude();
                        longitude = currentLocation.getLongitude();
                        latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title("Current Position");

                        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                        mCurrLocationMarker = mMap.addMarker(markerOptions);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                        isFirstTime = false;
                    }
                }
            }, Looper.myLooper());
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap mGoogleMap) {
        mMap = mGoogleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(rootView.getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(rootView.getContext(), "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
