package com.example.redoy.aistasker.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskStateProgress {
    public int selected;
    public List<Integer> statesList;

    public TaskStateProgress() {
        this.selected = -1;
        this.statesList = new ArrayList();
    }

    public TaskStateProgress(Integer num, Integer... numArr) {
        this.selected = -1;
        this.selected = num.intValue();
        this.statesList = Arrays.asList(numArr);
    }

    public int indexOfSelected() {
        if (this.statesList == null || this.statesList.isEmpty() || this.selected <= 0) {
            return -1;
        }
        return this.statesList.indexOf(Integer.valueOf(this.selected));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TaskStateProgress taskStateProgress = (TaskStateProgress) obj;
        if (taskStateProgress.statesList.equals(this.statesList) && taskStateProgress.selected == this.selected) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Segments: ");
        stringBuilder.append(this.statesList.isEmpty() ? "empty" : this.statesList);
        stringBuilder.append(" Selected: ");
        stringBuilder.append(this.selected > 0 ? Integer.valueOf(this.selected) : "invalid");
        return stringBuilder.toString();
    }
}
