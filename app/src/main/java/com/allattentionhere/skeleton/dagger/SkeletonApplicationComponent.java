package com.allattentionhere.skeleton.dagger;

import com.allattentionhere.skeleton.network.SkeletonServiceAPI;
import com.squareup.picasso.Picasso;

import dagger.Component;

@SkeletonApplicationScope
@Component(modules = {SkeletonServiceModule.class, PicassoModule.class})
public interface SkeletonApplicationComponent {

    Picasso getPicasso();

    SkeletonServiceAPI getSkeletonServiceAPI();
}
