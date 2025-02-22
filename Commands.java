public enum Commands {
    GIT_INIT("git init"),
    GIT_ADD("git add"),
    GIT_COMMIT("git commit"),
    GIT_PUSH("git push"),
    GIT_PULL("git pull"),
    GIT_CLONE("git clone"),
    GIT_CHECKOUT("git checkout"),
    GIT_STATUS("git status"),
    GIT_LOG("git log"),
    GIT_REMOTE_ADD("git remote add"),
    GIT_RENAME_BRANCH("git branch -m");

    private final String command;
    private Commands(String command) {
        this.command = command;
    }
    
    public String getCommand() {
        return command;
    }
}
