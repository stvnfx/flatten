import groovyx.gpars.actor.*

/* FileList Keeper.
*
* Does the Renames too.
*
*
* */
class FileList extends DefaultActor {
    def files = []

    @Override
    protected void act() {
        loop {
            react { msg ->
                if (msg instanceof File) {
                    files.push([msg.getName(), msg])
                } else if (msg instanceof String) {
                    switch (msg) {
                        case "size":
                            reply files.size()
                            break
                        case "get":
                            try {
                                reply files.pop()
                            } catch (NoSuchElementException) {
                                reply "empty"
                            }
                            break
                        case "dups":
                            files.each {
                                def current = it[0]
                                files.each {
                                    if (it[0] == current)
                                        println "Holy cow, we got a clone!"
                                        //Auto Rename?
                                        //AutoCloseable Rename is tricky. We add a number like _01
                                }

                            }
                            break
                    }
                }
            }
        }
    }
}
