package com.btpn.cn.java.project.add.to.cart.util;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void getTransactionID() {
        Utils utils = new Utils();
        String transId = utils.getTransactionID();
        assertNotNull(transId);
    }

    @Ignore
    public void testing(){
        String str = "16104673709";

        Integer.parseInt(str);

        assertNotNull(str);

    }
}