package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

// TODO Rename this class
class TemplatePlugin implements Plugin<Project> {
    @Override
    void apply(Project target) {
        target.extensions.create(TemplateExtension.NAME, TemplateExtension)
        target.tasks.create(TemplateTask.NAME, TemplateTask)
    }
}
