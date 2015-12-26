package com.example

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

// TODO Rename this class
class TemplateTask extends DefaultTask {
    // TODO Edit this value to your desired task name. Note that this value will be used by users in command line.
    public static String NAME = 'greet'
    TemplateExtension extension

    TemplateTask() {
        project.afterEvaluate {
            extension = project.extensions."${TemplateExtension.NAME}"
        }
    }

    @TaskAction
    void exec() {
        // TODO Implement your awesome features here
        println "Hello, world!"
    }
}
