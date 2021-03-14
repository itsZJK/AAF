package com.itsz.lint;

import com.android.SdkConstants;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * @author itsZ
 */
public class re {

    private boolean isFixedOrientation(Element element) {
        switch (element.getAttributeNS(SdkConstants.ANDROID_URI, "screenOrientation")) {
            case "landscape":
            case "sensorLandscape":
            case "reverseLandscape":
            case "userLandscape":
            case "portrait":
            case "sensorPortrait":
            case "reversePortrait":
            case "userPortrait":
            case "locked":
                return true;
            default:
                return false;
        }
    }




}
