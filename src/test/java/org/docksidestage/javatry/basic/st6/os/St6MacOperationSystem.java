package org.docksidestage.javatry.basic.st6.os;

/**
 * @author subaru
 */
public class St6MacOperationSystem extends St6AbstractOperationSystem {
    public St6MacOperationSystem(String loginId) {
        super(loginId);
    }

    @Override
    String getFileSeparator() {
        return "/";
    }

    @Override
    String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
