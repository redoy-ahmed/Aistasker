package com.example.redoy.aistasker.dependencies;

import com.example.redoy.aistasker.activities.LogInActivity;
import com.example.redoy.aistasker.activities.MenuActivity;
import com.example.redoy.aistasker.activities.SignUpActivity;

import dagger.Component;

/**
 * Created by redoy.ahmed on 27-Mar-2018.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(LogInActivity activity);

    void inject(SignUpActivity activity);

    void inject(MenuActivity activity);
}
