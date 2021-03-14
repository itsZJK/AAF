package com.itsz.lint

import com.android.SdkConstants
import com.android.tools.lint.detector.api.*
import org.w3c.dom.Element

/**
 * @author itsZ
 */

@Suppress("UnstableApiUsage")
class ZDetector : Detector(), XmlScanner {

    companion object {
        val ZIssueId = "ZIssueId"
        val ZIssueDescription = "ZIssueIDes"

        val ZIssue = Issue.create(
            id = ZIssueId,
            briefDescription = ZIssueDescription,
            explanation = ZIssueDescription,
            category = Category.CORRECTNESS,
            severity = Severity.INFORMATIONAL,
            implementation = Implementation(
                ZDetector::class.java,
                Scope.MANIFEST_SCOPE
            )
        )
    }


/**
     * 筛选我们关注的元素
     * 这里我们主要关注的是 activity 和 style 标签
     */

    override fun getApplicableElements(): Collection<String> {
        return listOf(SdkConstants.TAG_ACTIVITY, SdkConstants.TAG_STYLE)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        when (element.tagName) {
            SdkConstants.TAG_ACTIVITY -> {
                if (isFixedOrientation(element)) {
                    val theme =
                        element.getAttributeNS(SdkConstants.ANDROID_URI, SdkConstants.ATTR_THEME)
                    println("theme--$theme")
                    if ("@style/Theme.AppTheme.Transparent" == theme) {
                        reportError(context, element)
                    }
                }
            }
            SdkConstants.TAG_STYLE -> {

            }
            else -> {
            }
        }

    }


    private fun isFixedOrientation(element: Element): Boolean {
        return when (element.getAttributeNS(SdkConstants.ANDROID_URI, "screenOrientation")) {
            "landscape", "sensorLandscape", "reverseLandscape", "userLandscape", "portrait",
            "sensorPortrait", "reversePortrait", "userPortrait", "locked" -> true
            else -> false
        }
    }

    private fun isTranslucentOrFloating(element: Element): Boolean {
        var child = element.firstChild
        while (child != null) {
            if (child is Element
                && SdkConstants.TAG_ITEM == child.tagName && child.getFirstChild() != null && SdkConstants.VALUE_TRUE == child.getFirstChild().nodeValue
            ) {
                when (child.getAttribute(SdkConstants.ATTR_NAME)) {
                    "android:windowIsTranslucent", "android:windowSwipeToDismiss", "android:windowIsFloating" -> return true
                    else -> {
                    }
                }
            }
            child = child.nextSibling
        }
        return "Theme.AppTheme.Transparent" == element.getAttribute(SdkConstants.ATTR_PARENT)
    }

    private fun reportError(context: XmlContext, element: Element){
        context.report(ZIssue,element,context.getLocation(element),
        "请不要在 AndroidManifest.xml 文件里同时设置方向和透明主题")

    }

}
