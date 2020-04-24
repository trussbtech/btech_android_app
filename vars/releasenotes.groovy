import java.io.*;
import groovy.io.*;
import java.util.Calendar.*;
import java.text.SimpleDateFormat
import hudson.model.*;

@NonCPS
def call(Map config=[:]) {

    def dir = new File(pwd());

    new File(dir.path + '/releaseotes.txt').withWriter('utf-8')
            {
                writer ->
                    dir.eachFileRecurse(FileType.ANY) { file ->
                        if (file.isDirectory()) {
                            writer.writeLine(file.name);
                        } else {
                            writer.writeLine('\t' + file.name + '\t' + file.length());
                        }
                    }

                    def date = new Date()
                    def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
                    echo "Date and Time is:  " + sdf.format(date)

                    echo "Build number is: ${BUILD_NUMBER}";

                    def changeLogSets = currentBuild.changeSets

                    for (change in changeLogSets) {
                        def entries = change.items;
                        for (entry in entries) {
                            writer.writeLine("${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}")
                            for (file in entry.affectedFiles) {
                                writer.writeLine(" ${file.editType.name} ${file.path}")
                            }
                        }
                    }

                    if(config.changes != "false") {
                        echo "Changes"
                    }
       }
}
