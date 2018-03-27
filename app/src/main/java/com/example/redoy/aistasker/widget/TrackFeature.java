package com.example.redoy.aistasker.widget;

/**
 * Created by Redoy on 3/27/2018.
 */

public enum TrackFeature {
    POST_TASK_PICKUP_DELIVERY("post_task_pickup_delivery"),
    POST_TASK_FURNITURE_ASSEMBLY("post_task_furniture_assembly"),
    POST_TASK_HANDYMAN("post_task_handyman"),
    POST_TASK_CLEANING("post_task_cleaning"),
    POST_TASK_MOVING("post_task_movingremovals"),
    POST_TASK_GARDEN("post_task_garden_maintenance"),
    POST_TASK_PHOTOGRAPHY("post_task_photography"),
    POST_TASK_OFFICE_ADMIN("post_task_office_admin"),
    POST_TASK_IT_SUPPORT("post_task_computer_it_support"),
    POST_TASK_COLES(null),
    POST_TASK_OTHER_TASK("post_task_other"),
    POST_TASK_COPY_TASK("copy_task"),
    POST_TASK_DRAFT_TASK("draft_task"),
    POST_TASK_EDIT_TASK("edit_task"),
    POST_TASK_REQUEST_QUOTE("request_quote");

    private final String mTrackingString;

    private TrackFeature(String str) {
        this.mTrackingString = str;
    }

    public String getTrackingString() {
        return this.mTrackingString;
    }
}
