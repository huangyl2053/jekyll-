
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * {@link TestDacBase}のラッパークラスです。
 *
 * @author n8178 城間篤人
 */
public class DbuTestDacBase extends TestDacBase3 {

    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBU"));
        openMainSession();
    }

    @After
    public void tearDown() {
        rollback();
    }

    @AfterClass
    public static void tearDownClass() {
        rollBackAndCloseSession();
    }
}
