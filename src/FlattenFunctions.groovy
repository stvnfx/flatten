import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import groovyx.gpars.actor.*
import javax.swing.JOptionPane

class FlattenStuff {
    private static Flatten dialog = new Flatten();
    private static FileList fileList;

    def flatten(source, to) {
        def fileList_old = []
        def fl = new File(source).eachFileRecurse{
            if (!it.isDirectory()) {
                fileList << it
                fileList_old.push(it)
            }
        }

        def completedFiles = 0
//        def uncompletedFiles = fileList.send("size")
//
//        def currentFile
//        while((currentFile = fileList.send("get")) != "empty")
//
//
        //Ok now copy to 'to'
//        fileList_old.each {
//            def newFile = new File(to + it.getName())
//            def newFileOutStream = newFile.newDataOutputStream()
//            def fileInputStream =  it.newDataInputStream()
//
//            //So we know how far we are...
//            def fileSize = new File(it.getPath()).size()
//            def completed = 0
//
//            newFileOutStream << fileInputStream
//            newFileOutStream.close()
//            fileInputStream.close()
//            completedFiles++
//            dialog.progressBar2.setValue((int)Math.round(completedFiles*100/fileList_old.size()))
//            dialog.progressBar2.setString(((int)Math.round(completedFiles*100/fileList_old.size())) + "% " + completedFiles + "/" + fileList_old.size() + " Completed")
//
//        }
//         dialog.progressBar2.setString("Completed")
        fileList.send("dups")
    }

    public static void main(String[] args) {
        fileList = new FileList()
        fileList.start()

        dialog.buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                FlattenStuff flat = new FlattenStuff()

                String d1 = dialog.textField1.getText()
                String d2 = dialog.textField2.getText()

                Runnable toRun = new Runnable() {
                    public void run() {
                        flat.flatten(d1, d2 + "/")
                    }
                };
                (new Thread(toRun)).start();

            }
        });

        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
