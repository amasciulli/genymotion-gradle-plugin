package com.genymotion

import main.groovy.com.genymotion.GenymotionTool
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenymotionEndTask extends DefaultTask {

    @TaskAction
    def exec() {

        //we set the config inside the GenymotionTool
        GenymotionTool.CONFIG = project.genymotion.config

        println("Stopping devices")
        //get the declared devices
        project.genymotion.getDevices().each(){

            println("Stopping ${it.name}")
            GenymotionTool.stopDevice(it)
        }
    }
}