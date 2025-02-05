package com.example.navigation_drawer2.ui;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.FormBody;

public class AmadeusApiClient {
    private static final String BASE_URL = "https://test.api.amadeus.com/";
    private static final String CLIENT_ID = "Abpb7XNtnAqqfsvY9LVqm0xP2AEEIYYd";
    private static final String CLIENT_SECRET = "CjGItGmRh7vM2q2P";

    private static Retrofit retrofit = null;
    private static String accessToken = null;

    public interface AmadeusApiService {
        @GET("v1/security/oauth2/token")
        Call<TokenResponse> getToken(@Query("grant_type") String grantType,
                                     @Query("client_id") String clientId,
                                     @Query("client_secret") String clientSecret);

        @GET("v1/reference-data/locations/pois")
        Call<PointsOfInterestResponse> getPointsOfInterest(@Header("Authorization") String authHeader,
                                                           @Query("latitude") double latitude,
                                                           @Query("longitude") double longitude,
                                                           @Query("radius") int radius);
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static void getAccessToken(final TokenCallback callback) {
        AmadeusApiService apiService = getClient().create(AmadeusApiService.class);
        Call<TokenResponse> call = apiService.getToken("client_credentials", CLIENT_ID, CLIENT_SECRET);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    accessToken = response.body().getAccessToken();
                    callback.onTokenReceived(accessToken);
                } else {
                    callback.onFailure("Failed to get access token");
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getPointsOfInterest(double latitude, double longitude, int radius, final PointsOfInterestCallback callback) {
        if (accessToken == null) {
            getAccessToken(new TokenCallback() {
                @Override
                public void onTokenReceived(String token) {
                    fetchPointsOfInterest(token, latitude, longitude, radius, callback);
                }

                @Override
                public void onFailure(String error) {
                    callback.onFailure(error);
                }
            });
        } else {
            fetchPointsOfInterest(accessToken, latitude, longitude, radius, callback);
        }
    }

    private static void fetchPointsOfInterest(String token, double latitude, double longitude, int radius, final PointsOfInterestCallback callback) {
        AmadeusApiService apiService = getClient().create(AmadeusApiService.class);
        Call<PointsOfInterestResponse> call = apiService.getPointsOfInterest("Bearer " + token, latitude, longitude, radius);
        call.enqueue(new Callback<PointsOfInterestResponse>() {
            @Override
            public void onResponse(Call<PointsOfInterestResponse> call, Response<PointsOfInterestResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onPointsOfInterestReceived(response.body());
                } else {
                    callback.onFailure("Failed to get points of interest");
                }
            }

            @Override
            public void onFailure(Call<PointsOfInterestResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface TokenCallback {
        void onTokenReceived(String token);
        void onFailure(String error);
    }

    public interface PointsOfInterestCallback {
        void onPointsOfInterestReceived(PointsOfInterestResponse response);
        void onFailure(String error);
    }
}

// Estas clases deben coincidir con la estructura de la respuesta JSON de la API
class TokenResponse {
    private String access_token;

    public String getAccessToken() {
        return access_token;
    }
}

class PointsOfInterestResponse {
    // Define esta clase según la estructura de la respuesta de la API de Amadeus
    // para Points of Interest
}
