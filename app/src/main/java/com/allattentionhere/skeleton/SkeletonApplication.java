package com.allattentionhere.skeleton;

import android.app.Activity;
import android.app.Application;

import com.allattentionhere.skeleton.dagger.ContextModule;
import com.allattentionhere.skeleton.dagger.DaggerSkeletonApplicationComponent;
import com.allattentionhere.skeleton.dagger.SkeletonApplicationComponent;
import com.allattentionhere.skeleton.network.SkeletonServiceAPI;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class SkeletonApplication extends Application {

    private SkeletonApplicationComponent component;

    public static SkeletonApplication get(Activity activity) {
        return (SkeletonApplication) activity.getApplication();
    }

    private SkeletonServiceAPI skeletonServiceAPI;

    private Picasso picasso;



    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        component = DaggerSkeletonApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        skeletonServiceAPI = component.getSkeletonServiceAPI();
        picasso = component.getPicasso();
    }

    public SkeletonApplicationComponent component() {
        return component;
    }
}