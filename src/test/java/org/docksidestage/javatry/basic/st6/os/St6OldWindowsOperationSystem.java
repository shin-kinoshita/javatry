package org.docksidestage.javatry.basic.st6.os;

/**
 * @author subaru
 */
public class St6OldWindowsOperationSystem extends St6AbstractOperationSystem {
    public St6OldWindowsOperationSystem(String loginId) {
        super(loginId);
    }

    @Override
    String getFileSeparator() {
        return "\\";
    }

    @Override
    String getUserDirectory() {
        return "/Documents and Settigs/" + loginId;
    }
}
