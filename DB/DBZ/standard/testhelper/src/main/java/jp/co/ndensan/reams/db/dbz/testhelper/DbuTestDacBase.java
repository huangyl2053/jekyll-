
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
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

    /**
     * ダミーのControlDataを作成します。<br/>
     * DBセッションを開き、sqlSessionオブジェクトにDBセッションを代入します。
     */
    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBU"));
        openMainSession();
    }

    /**
     * ロールバックします。
     */
    @After
    public void tearDown() {
        rollback();
    }

    /**
     * ロールバックし、DBセッションを閉じます。
     */
    @AfterClass
    public static void tearDownClass() {
        rollBackAndCloseSession();
    }
}
