package br.com.syncinfo.calendar.model.dao;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.model.*;

import java.util.Arrays;
import java.util.List;

import br.com.syncinfo.clinicapp.MyActivity;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by mmartins on 13/06/2016.
 */
public class GoogleCalendarDAO {

//    static final public int REQUEST_ACCOUNT_PICKER = 1000;
//    static final public int REQUEST_AUTHORIZATION = 1001;
//    static final public int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
//    static final public int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;
//    static final public String PREF_ACCOUNT_NAME = "accountName";
//
//    private static final String[] SCOPES = { CalendarScopes.CALENDAR_READONLY };
//
//    static private GoogleCalendarDAO instance = null;
//
//    public static GoogleCalendarDAO getInstance() {
//        return instance;
//    }
//
//    public static void setInstance(GoogleCalendarDAO instance) {
//        GoogleCalendarDAO.instance = instance;
//    }
//
//    private final GoogleAccountCredential mCredential;
//    private final MyActivity mFragmentActivity;
//
//    public GoogleCalendarDAO(MyActivity fragmentActivity) {
//        this.mFragmentActivity = fragmentActivity;
//
//        // Initialize credentials and service object.
//        mCredential = GoogleAccountCredential.usingOAuth2(
//                this.mFragmentActivity.getApplicationContext(), Arrays.asList(SCOPES))
//                .setBackOff(new ExponentialBackOff());
//    }
//
//    public GoogleAccountCredential getGoogleAccountCredential() {
//        return mCredential;
//    }
//
//    public void init() {
//        if (! isGooglePlayServicesAvailable()) {
//            acquireGooglePlayServices();
//        } else if (mCredential.getSelectedAccountName() == null) {
//            this.mFragmentActivity.chooseAccount();
//        } else if (! isDeviceOnline()) {
//            throw new IllegalStateException("No network connection available.");
//        }
//    }
//
//    /**
//     * Check that Google Play services APK is installed and up to date.
//     * @return true if Google Play Services is available and up to
//     *     date on this device; false otherwise.
//     */
//    private boolean isGooglePlayServicesAvailable() {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        final int connectionStatusCode =
//                apiAvailability.isGooglePlayServicesAvailable(mFragmentActivity);
//        return connectionStatusCode == ConnectionResult.SUCCESS;
//    }
//
//    /**
//     * Checks whether the device currently has a network connection.
//     * @return true if the device has a network connection, false otherwise.
//     */
//    private boolean isDeviceOnline() {
//        ConnectivityManager connMgr =
//                (ConnectivityManager) mFragmentActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        return (networkInfo != null && networkInfo.isConnected());
//    }
//
//    /**
//     * Attempt to resolve a missing, out-of-date, invalid or disabled Google
//     * Play Services installation via a user dialog, if possible.
//     */
//    private void acquireGooglePlayServices() {
//        GoogleApiAvailability apiAvailability =
//                GoogleApiAvailability.getInstance();
//        final int connectionStatusCode =
//                apiAvailability.isGooglePlayServicesAvailable(this.mFragmentActivity);
//        if (apiAvailability.isUserResolvableError(connectionStatusCode)) {
//            showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
//        }
//    }
//
//    /**
//     * Display an error dialog showing that Google Play Services is missing
//     * or out of date.
//     * @param connectionStatusCode code describing the presence (or lack of)
//     *     Google Play Services on this device.
//     */
//    public void showGooglePlayServicesAvailabilityErrorDialog(
//            final int connectionStatusCode) {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        Dialog dialog = apiAvailability.getErrorDialog(
//                this.mFragmentActivity,
//                connectionStatusCode,
//                REQUEST_GOOGLE_PLAY_SERVICES);
//        dialog.show();
//    }
}
