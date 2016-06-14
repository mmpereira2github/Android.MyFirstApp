package br.com.syncinfo.clinicapp.android;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

/**
 * Created by mmartins on 13/06/2016.
 */
public class AppContext {

    private static final AppContext instance = new AppContext();

    public static AppContext getAppContext() {
        return instance;
    }

    private GoogleCredentialResolver googleCredentialResolver = new GoogleCredentialResolver();

    public GoogleCredentialResolver getGoogleCredentialResolver() {
        return googleCredentialResolver;
    }

    public void setGoogleCredentialResolver(GoogleCredentialResolver googleCredentialResolver) {
        this.googleCredentialResolver = googleCredentialResolver;
    }
}
