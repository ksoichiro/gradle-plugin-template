package com.example

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.assertTrue

class PluginTest {
    static final String PLUGIN_ID = 'com.example.template'

    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()
    File rootDir

    @Before
    void setup() {
        rootDir = testProjectDir.root
        if (!rootDir.exists()) {
            rootDir.mkdir()
        }
    }

    @Test
    void apply() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: PLUGIN_ID

        assertTrue(project.tasks."${TemplateTask.NAME}" instanceof TemplateTask)
    }

    @Test
    void executeTask() {
        Project project = ProjectBuilder.builder().withProjectDir(rootDir).build()
        project.apply plugin: PLUGIN_ID
        project.extensions."${TemplateExtension.NAME}".with {
            // TODO Configure extension
        }
        project.afterEvaluate {
            project.tasks."${TemplateTask.NAME}".execute()
            // TODO Add assertions here if required
        }
        project.evaluate()
    }
}
