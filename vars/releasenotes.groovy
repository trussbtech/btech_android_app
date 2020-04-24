import java.io.*;
import groovy.io.*;

@NonCPS
def call(Map config=[:]) {

    def dir = new File(pwd());

    new File(dir.path + '/releaseotes.txt').withWriter('utf-8')
            {
                writer ->
                    dir.eachFileRecurse(FileType.ANY) { file ->
                        if (file.isDirectory()) {
                   writer.writeLine(file.name); 
                }
                else
                { 
                    writer.writeLine('\t' + file.name + '\t' + file.length());
                }
           }
    }
    if(config.changes != "false") {
    echo "Changes"
    }
}
