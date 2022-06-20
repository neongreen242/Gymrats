package com.example.gymrats;

import android.app.Application;
import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("MyoMLuJjTEQcZhFtOyp3TjUNLNLywCQgGbwSNw9F")
                .clientKey("QdjP317C8JZOez3cqrnmMZNFdm9QCUJio9ESToH3")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
