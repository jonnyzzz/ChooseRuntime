// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package bootRuntime.command

import bootRuntime.main.BinTrayUtil
import bootRuntime.main.Controller
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.io.FileUtil
import java.awt.event.ActionEvent
import java.util.function.Consumer

class UseDefault(project: Project?, controller: Controller?) : Command(project!!, controller!!, "Use Default") {
    override fun actionPerformed(e: ActionEvent?) {
        runWithProgress("Uninstalling...", Consumer { indicator: ProgressIndicator? ->
            FileUtil.delete(BinTrayUtil.getJdkConfigFilePath())
            myController.restart()
        })
    }
}