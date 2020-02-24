package com.github.mkopylec.projectmanager.core.project;

import static com.github.mkopylec.projectmanager.core.common.Utilities.allEmpty;
import static com.github.mkopylec.projectmanager.core.common.Utilities.isEmpty;
import static com.github.mkopylec.projectmanager.core.project.Requirement.NECESSARY;
import static com.github.mkopylec.projectmanager.core.project.Status.DONE;
import static com.github.mkopylec.projectmanager.core.project.Status.TO_DO;

public class Feature {

    private String name;
    private Status status;
    private Requirement requirement;

    static Feature feature(String name, Requirement requirement) {
        return allEmpty(name, requirement) ? null : new Feature(name, TO_DO, requirement);
    }

    static Feature feature(String name, Status status, Requirement requirement) {
        return allEmpty(name, status, requirement) ? null : new Feature(name, status, requirement);
    }

    private Feature(String name, Status status, Requirement requirement) {
        this.name = name;
        this.status = status;
        this.requirement = requirement;
    }

    String getName() {
        return name;
    }

    Status getStatus() {
        return status;
    }

    Requirement getRequirement() {
        return requirement;
    }

    boolean isUnnamed() {
        return isEmpty(name);
    }

    boolean hasNoStatus() {
        return isEmpty(status);
    }

    boolean hasNoRequirement() {
        return isEmpty(requirement);
    }

    boolean isUndone() {
        return status != DONE;
    }

    boolean isNecessaryAndUndone() {
        return requirement == NECESSARY && isUndone();
    }

    public static class FeaturePersistenceHelper {

        public Feature createFeature(String name, Status status, Requirement requirement) {
            return allEmpty(name, status, requirement) ? null : new Feature(name, status, requirement);
        }

        public String getName(Feature feature) {
            return feature.name;
        }

        public Status getStatus(Feature feature) {
            return feature.status;
        }

        public Requirement getRequirement(Feature feature) {
            return feature.requirement;
        }
    }
}
