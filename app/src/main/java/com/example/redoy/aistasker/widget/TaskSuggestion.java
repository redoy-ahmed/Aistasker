package com.example.redoy.aistasker.widget;

import com.example.redoy.aistasker.R;

/**
 * Created by Redoy on 3/27/2018.
 */

public enum TaskSuggestion {

    PICKUP(R.string.suggestion_name_pickup, R.string.suggestion_example_pickup, TrackFeature.POST_TASK_PICKUP_DELIVERY),
    FURNITURE(R.string.suggestion_name_furniture, R.string.suggestion_example_furniture, TrackFeature.POST_TASK_FURNITURE_ASSEMBLY),
    HANDYMAN(R.string.suggestion_name_handyman, R.string.suggestion_example_handyman, TrackFeature.POST_TASK_HANDYMAN),
    CLEANING(R.string.suggestion_name_cleaning, R.string.suggestion_example_cleaning, TrackFeature.POST_TASK_CLEANING),
    MOVING(R.string.suggestion_name_moving, R.string.suggestion_example_moving, TrackFeature.POST_TASK_MOVING),
    GARDEN(R.string.suggestion_name_garden, R.string.suggestion_example_garden, TrackFeature.POST_TASK_GARDEN),
    PHOTOGRAPHY(R.string.suggestion_name_photography, R.string.suggestion_example_photography, TrackFeature.POST_TASK_PHOTOGRAPHY),
    OFFICE(R.string.suggestion_name_office, R.string.suggestion_example_office, TrackFeature.POST_TASK_OFFICE_ADMIN),
    IT(R.string.suggestion_name_it, R.string.suggestion_example_it, TrackFeature.POST_TASK_IT_SUPPORT),
    COLES(R.string.suggestion_name_coles, R.string.misc_empty_string, TrackFeature.POST_TASK_COLES),
    OTHER(R.string.suggestion_name_other, R.string.suggestion_example_other, TrackFeature.POST_TASK_OTHER_TASK);

    private final int i;
    private final int i2;
    private final TrackFeature trackFeature;

    private TaskSuggestion(int i, int i2, TrackFeature trackFeature) {
        this.i = i;
        this.i2 = i2;
        this.trackFeature = trackFeature;
    }

    public int getI2() {
        return this.i2;
    }

    public TrackFeature getTrackFeature() {
        return this.trackFeature;
    }
}
