/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wangchao
 */
public class GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakkoTest {

    public GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakkoTest() {
    }

    /**
     * Test of createInstance method, of class GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.
     */
    @Test
    public void testCreateInstance() {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        RString AA = new RString("平02.01.01");
        RString BB = new RString("平02年01月01日");
        RString A1 = AA.substring(0, 1);
        RString A2 = AA.substring(1, 3);
        RString A3 = AA.substring(4, 6);
        RString A4 = AA.substring(7, 9);
        System.out.println("A1:" + A1);
        System.out.println("A2:" + A2);
        System.out.println("A3:" + A3);
        System.out.println("A4:" + A4);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        RString B1 = BB.substring(1, 3);
        RString B2 = BB.substring(4, 6);
        RString B3 = BB.substring(7, 9);
        System.out.println("B1:" + B1);
        System.out.println("B2:" + B2);
        System.out.println("B3:" + B3);
        // TODO review the generated test code and remove the default call to fail.
    }

}
