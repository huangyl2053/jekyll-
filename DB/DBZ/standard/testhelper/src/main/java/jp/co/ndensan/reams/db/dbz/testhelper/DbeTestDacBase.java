package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.BeforeClass;
import org.junit.AfterClass;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * {@link TestDacBase}のラッパークラスです。
 *
 * @author N1013 松本直樹
 */
public class DbeTestDacBase extends TestDacBase3 {

    @BeforeClass
    public void setUpClass() {
        setDummyControlData(new RString("DBE"));
        openMainSession();
    }

    @AfterClass
    public static void tearDownClass() {
        rollBackAndCloseSession();
    }
}
