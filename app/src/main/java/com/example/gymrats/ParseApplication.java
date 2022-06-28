package com.example.gymrats;

import android.app.Application;

import com.example.gymrats.models.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("MyoMLuJjTEQcZhFtOyp3TjUNLNLywCQgGbwSNw9F")
                .clientKey("QdjP317C8JZOez3cqrnmMZNFdm9QCUJio9ESToH3")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
