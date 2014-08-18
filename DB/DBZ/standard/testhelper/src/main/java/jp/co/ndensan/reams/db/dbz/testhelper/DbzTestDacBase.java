
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
 * @author N3327 三浦 凌
 */
public class DbzTestDacBase extends TestDacBase3 {

    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBZ"));
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
