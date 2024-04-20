package labs.yates.controller;

import labs.yates.view.components.FSViewer;
import labs.yates.view.panel.FileLister;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class FileListerController {
    private final FileLister fileLister;

    public FileListerController(FileLister fileLister) {
        this.fileLister = fileLister;
    }

    /**
     * Given a directory & a FSViewer, it populates the FSViewer
     * with the filenames discovered inside that directory, recursively
     * found.
     *
     * @param directory the directory to look in
     * @param viewer    the FSViewer to populate
     */
   private void buildViewer(Path directory, FSViewer viewer) {
        for (File file : Objects.requireNonNull(directory.toFile().listFiles())) {
            if (file.isDirectory()) {
                buildViewer(file.toPath(), viewer);
            } else {
                String fileName = file.getName();
                viewer.inject(fileName);
            }
        }
   }

    /**
     * Recurses into the specified directory, then adds
     * the found paths into the FileLister attached to
     * this class.
     *
     * @param directory the directory to recurse in
     */
    public void recurse(Path directory) {
        FSViewer viewer = new FSViewer();
        buildViewer(directory, viewer);
        viewer.finish();
        fileLister.setFSViewer(viewer);
    }
}
