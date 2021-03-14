package com.itsz.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue


/**
 * @author itsZ
 */
@Suppress("UnstableApiUsage")
class ZIssueRegistry : IssueRegistry() {


    override val issues: List<Issue>
        get() = listOf(ZDetector.ZIssue)


    override val api: Int
        get() = CURRENT_API
}
