/*

Copyright 2015 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package com.akexorcist.googledirection.util;

import android.content.Context;
import android.util.DisplayMetrics;

import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.akexorcist.googledirection.model.Step;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import static androidx.annotation.Dimension.DP;

/**
 * Created by Akexorcist on 11/29/15 AD.
 */
public class DirectionConverter {
    public static ArrayList<LatLng> getDirectionPoint(List<Step> stepList) {
        ArrayList<LatLng> directionPointList = new ArrayList<>();
        if (stepList != null && stepList.size() > 0) {
            for (Step step : stepList) {
                convertStepToPosition(step, directionPointList);
            }
        }
        return directionPointList;
    }

    private static void convertStepToPosition(Step step, ArrayList<LatLng> directionPointList) {
        // Get start location
        directionPointList.add(step.getStartLocation().getCoordination());

        // Get encoded points location
        if (step.getPolyline() != null) {
            List<LatLng> decodedPointList = step.getPolyline().getPointList();
            if (decodedPointList != null && decodedPointList.size() > 0) {
                directionPointList.addAll(decodedPointList);
            }
        }

        // Get end location
        directionPointList.add(step.getEndLocation().getCoordination());
    }

    public static ArrayList<LatLng> getSectionPoint(List<Step> stepList) {
        ArrayList<LatLng> directionPointList = new ArrayList<>();
        if (stepList != null && stepList.size() > 0) {
            // Get start location only first position
            directionPointList.add(stepList.get(0).getStartLocation().getCoordination());
            for (Step step : stepList) {
                // Get end location
                directionPointList.add(step.getEndLocation().getCoordination());
            }
        }
        return directionPointList;
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @NonNull PathOption pathOption
    ) {
        return createPolyline(
                context,
                pathOption.locationList,
                pathOption.width,
                pathOption.color,
                pathOption.clickable,
                pathOption.jointType,
                pathOption.startCap,
                pathOption.endCap,
                pathOption.patternItemList
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color
    ) {
        return createPolyline(
                context,
                locationList,
                width,
                color,
                true,
                JointType.DEFAULT,
                null,
                null,
                null
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color,
            boolean clickable
    ) {
        return createPolyline(
                context,
                locationList,
                width,
                color,
                clickable,
                JointType.DEFAULT,
                null,
                null,
                null
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color,
            boolean clickable,
            @IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType
    ) {
        return createPolyline(
                context,
                locationList,
                width,
                color,
                clickable,
                jointType,
                null,
                null,
                null
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color,
            boolean clickable,
            @Nullable Cap startCap,
            @Nullable Cap endCap
    ) {
        return createPolyline(
                context,
                locationList,
                width,
                color,
                clickable,
                JointType.DEFAULT,
                startCap,
                endCap,
                null
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color,
            boolean clickable,
            @Nullable List<PatternItem> patternItemList
    ) {
        return createPolyline(
                context,
                locationList,
                width,
                color,
                clickable,
                JointType.DEFAULT,
                null,
                null,
                patternItemList
        );
    }

    public static PolylineOptions createPolyline(
            @NonNull Context context,
            @Nullable ArrayList<LatLng> locationList,
            @Dimension(unit = DP) int width,
            @ColorInt int color,
            boolean clickable,
            @IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType,
            @Nullable Cap startCap,
            @Nullable Cap endCap,
            @Nullable List<PatternItem> patternItemList) {
        PolylineOptions rectLine = new PolylineOptions().width(dpToPx(context, width)).color(color).geodesic(true);
        rectLine.clickable(clickable);
        rectLine.jointType(jointType);
        if (patternItemList != null) {
            rectLine.pattern(patternItemList);
        }
        if (startCap != null) {
            rectLine.startCap(startCap);
        }
        if (endCap != null) {
            rectLine.endCap(endCap);
        }
        if (locationList != null && locationList.size() > 0) {
            for (LatLng location : locationList) {
                rectLine.add(location);
            }
        }
        return rectLine;
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @NonNull TransitPathOption transitPathOption) {
        return createTransitPolyline(
                context,
                transitPathOption.stepList,
                transitPathOption.transitWidth,
                transitPathOption.transitColor,
                transitPathOption.transitPatternItemList,
                transitPathOption.walkingWidth,
                transitPathOption.walkingColor,
                transitPathOption.walkingPatternItemList,
                transitPathOption.clickable,
                transitPathOption.jointType,
                transitPathOption.startCap,
                transitPathOption.endCap
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @ColorInt int transitColor,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor) {
        return createTransitPolyline(
                context,
                stepList,
                transitWidth,
                transitColor,
                null,
                walkingWidth,
                walkingColor,
                null,
                true,
                JointType.DEFAULT,
                null,
                null
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @Nullable List<PatternItem> transitPatternItemList,
            @ColorInt int transitColor,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor,
            @Nullable List<PatternItem> walkingPatternItemList) {
        return createTransitPolyline(
                context,
                stepList,
                transitWidth,
                transitColor,
                transitPatternItemList,
                walkingWidth,
                walkingColor,
                walkingPatternItemList,
                true,
                JointType.DEFAULT,
                null,
                null
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @ColorInt int transitColor,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor,
            @Nullable boolean clickable) {
        return createTransitPolyline(
                context,
                stepList,
                transitWidth,
                transitColor,
                null,
                walkingWidth,
                walkingColor,
                null,
                clickable,
                JointType.DEFAULT,
                null,
                null
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @ColorInt int transitColor,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor,
            boolean clickable,
            @IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType) {
        return createTransitPolyline(
                context,
                stepList,
                transitWidth,
                transitColor,
                null,
                walkingWidth,
                walkingColor,
                null,
                clickable,
                jointType,
                null,
                null
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @ColorInt int transitColor,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor,
            boolean clickable,
            @Nullable Cap startCap,
            @Nullable Cap endCap) {
        return createTransitPolyline(
                context,
                stepList,
                transitWidth,
                transitColor,
                null,
                walkingWidth,
                walkingColor,
                null,
                clickable,
                JointType.DEFAULT,
                startCap,
                endCap
        );
    }

    public static ArrayList<PolylineOptions> createTransitPolyline(
            @NonNull Context context,
            @Nullable List<Step> stepList,
            @Dimension(unit = DP) int transitWidth,
            @ColorInt int transitColor,
            @Nullable List<PatternItem> transitPatternItemList,
            @Dimension(unit = DP) int walkingWidth,
            @ColorInt int walkingColor,
            @Nullable List<PatternItem> walkingPatternItemList,
            boolean clickable,
            @IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType,
            @Nullable Cap startCap,
            @Nullable Cap endCap
    ) {
        ArrayList<PolylineOptions> polylineOptionsList = new ArrayList<>();
        if (stepList != null && stepList.size() > 0) {
            for (Step step : stepList) {
                ArrayList<LatLng> directionPointList = new ArrayList<>();
                convertStepToPosition(step, directionPointList);
                if (step.isContainStepList()) {
                    polylineOptionsList.add(createPolyline(
                            context,
                            directionPointList,
                            walkingWidth,
                            walkingColor,
                            clickable,
                            jointType,
                            startCap,
                            endCap,
                            walkingPatternItemList
                    ));
                } else {
                    polylineOptionsList.add(createPolyline(
                            context,
                            directionPointList,
                            transitWidth,
                            transitColor,
                            clickable,
                            jointType,
                            startCap,
                            endCap,
                            transitPatternItemList
                    ));
                }
            }
        }
        return polylineOptionsList;
    }

    private static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static class PathOption {
        ArrayList<LatLng> locationList;
        int width;
        int color;
        boolean clickable;
        int jointType;
        Cap startCap;
        Cap endCap;
        List<PatternItem> patternItemList;

        public ArrayList<LatLng> getLocationList() {
            return locationList;
        }

        public PathOption setLocationList(ArrayList<LatLng> locationList) {
            this.locationList = locationList;
            return this;
        }

        public int getWidth() {
            return width;
        }

        public PathOption setWidth(@Dimension(unit = DP) int width) {
            this.width = width;
            return this;
        }

        public int getColor() {
            return color;
        }

        public PathOption setColor(@ColorInt int color) {
            this.color = color;
            return this;
        }

        public boolean isClickable() {
            return clickable;
        }

        public PathOption setClickable(boolean clickable) {
            this.clickable = clickable;
            return this;
        }

        public int getJointType() {
            return jointType;
        }

        public PathOption setJointType(@IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType) {
            this.jointType = jointType;
            return this;
        }

        public Cap getStartCap() {
            return startCap;
        }

        public PathOption setStartCap(Cap startCap) {
            this.startCap = startCap;
            return this;
        }

        public Cap getEndCap() {
            return endCap;
        }

        public PathOption setEndCap(Cap endCap) {
            this.endCap = endCap;
            return this;
        }

        public List<PatternItem> getPatternItemList() {
            return patternItemList;
        }

        public PathOption setPatternItemList(List<PatternItem> patternItemList) {
            this.patternItemList = patternItemList;
            return this;
        }
    }

    public static class TransitPathOption {
        List<Step> stepList = null;
        int transitWidth;
        int transitColor;
        List<PatternItem> transitPatternItemList;
        int walkingWidth;
        int walkingColor;
        List<PatternItem> walkingPatternItemList;
        boolean clickable;
        int jointType;
        Cap startCap;
        Cap endCap;

        public List<Step> getStepList() {
            return stepList;
        }

        public TransitPathOption setStepList(List<Step> stepList) {
            this.stepList = stepList;
            return this;
        }

        public int getTransitWidth() {
            return transitWidth;
        }

        public TransitPathOption setTransitWidth(@Dimension(unit = DP) int transitWidth) {
            this.transitWidth = transitWidth;
            return this;
        }

        public int getTransitColor() {
            return transitColor;
        }

        public TransitPathOption setTransitColor(@ColorInt int transitColor) {
            this.transitColor = transitColor;
            return this;
        }

        @Nullable
        public List<PatternItem> getTransitPatternItemList() {
            return transitPatternItemList;
        }

        public TransitPathOption setTransitPatternItemList(@Nullable List<PatternItem> transitPatternItemList) {
            this.transitPatternItemList = transitPatternItemList;
            return this;
        }

        public int getWalkingWidth() {
            return walkingWidth;
        }

        public TransitPathOption setWalkingWidth(@Dimension(unit = DP) int walkingWidth) {
            this.walkingWidth = walkingWidth;
            return this;
        }

        public int getWalkingColor() {
            return walkingColor;
        }

        public TransitPathOption setWalkingColor(@ColorInt int walkingColor) {
            this.walkingColor = walkingColor;
            return this;
        }

        @Nullable
        public List<PatternItem> getWalkingPatternItemList() {
            return walkingPatternItemList;
        }

        public TransitPathOption setWalkingPatternItemList(@Nullable List<PatternItem> walkingPatternItemList) {
            this.walkingPatternItemList = walkingPatternItemList;
            return this;
        }

        public boolean isClickable() {
            return clickable;
        }

        public TransitPathOption setClickable(boolean clickable) {
            this.clickable = clickable;
            return this;
        }

        public int getJointType() {
            return jointType;
        }

        public TransitPathOption setJointType(@IntRange(from = JointType.DEFAULT, to = JointType.ROUND) int jointType) {
            this.jointType = jointType;
            return this;
        }

        @Nullable
        public Cap getStartCap() {
            return startCap;
        }

        public TransitPathOption setStartCap(@Nullable Cap startCap) {
            this.startCap = startCap;
            return this;
        }

        @Nullable
        public Cap getEndCap() {
            return endCap;
        }

        public TransitPathOption setEndCap(@Nullable Cap endCap) {
            this.endCap = endCap;
            return this;
        }
    }
}
