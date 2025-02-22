import java.io.File;
import java.io.IOException;

public class CommitMaker {
    public static void main(String[] args) {

        //The root folder should contain sub-folders
        final String path = "C:\\";
        //The github repository https
        final String remote = "";

        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Error: La ruta especificada no es un directorio válido.");
            return;
        }

        String[] folders = dir.list((current, name) -> new File(current, name).isDirectory());
        if (folders == null || folders.length == 0) {
            System.err.println("No se encontraron carpetas dentro de: " + path);
            return;
        }

        try {
            initializeGit(path, remote);
            addEachFolderToGit(path, folders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addEachFolderToGit(String path, String[] folders) throws IOException, InterruptedException {
        for (String folder : folders) {
            System.out.println("Procesando carpeta: " + folder);
            executeGitCommand("git add " + folder, path);
            executeGitCommand("git commit -m \"add: " + folder + "\"", path);
            executeGitCommand("git push origin main", path);
        }
    }

    private static void executeGitCommand(String command, String path) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
        pb.directory(new File(path));
        Process process = pb.start();
        process.waitFor();
    }

    private static void initializeGit(String path, String remote) throws IOException, InterruptedException {
        executeGitCommand("git init", path);
        executeGitCommand("git remote add origin " + remote, path);
        executeGitCommand("git branch -M main", path);
    }
}
