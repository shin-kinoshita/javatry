package org.docksidestage.javatry.basic.st6.os;

/**
 * @author subaru
 */
public class St6WindowsOperationSystem extends St6AbstractOperationSystem {
    public St6WindowsOperationSystem(String loginId) {
        super(loginId);
    }

    @Override
    String getFileSeparator() {
        return "\\";
    }

    @Override
    String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
