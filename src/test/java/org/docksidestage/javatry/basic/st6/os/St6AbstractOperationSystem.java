package org.docksidestage.javatry.basic.st6.os;

/**
 * @author subaru
 */
public abstract class St6AbstractOperationSystem {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final String loginId;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public St6AbstractOperationSystem(String loginId) {
        this.loginId = loginId;
    }

    // ===================================================================================
    //                                                                      User Directory
    //                                                                      ==============
    public String buildUserResourcePath(String relativePath) {
        String fileSeparator = getFileSeparator();
        String userDirectory = getUserDirectory();
        String resourcePath = userDirectory + fileSeparator + relativePath;
        return resourcePath.replace("/", fileSeparator);
    }

    abstract String getFileSeparator();

    abstract String getUserDirectory();
}
