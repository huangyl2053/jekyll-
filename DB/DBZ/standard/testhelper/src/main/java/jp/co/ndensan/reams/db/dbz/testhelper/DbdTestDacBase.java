package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * {@link TestDacBase}のラッパークラスです。
 *
 * @author n8233　朴義一
 */
public class DbdTestDacBase extends TestDacBase3 {

    /**
     * ダミーのControlDataを作成します。<br/>
     * DBセッションを開き、sqlSessionオブジェクトにDBセッションを代入します。
     */
    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBD"));
        openMainSession();
    }

    /**
     * ロールバックします。
     */
    @After
    public void afterTearDown() {
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
