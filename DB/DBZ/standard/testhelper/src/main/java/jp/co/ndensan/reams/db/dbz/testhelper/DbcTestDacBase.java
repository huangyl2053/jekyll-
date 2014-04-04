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
 * @author n3317 塚田萌
 */
public class DbcTestDacBase extends TestDacBase3 {

    /**
     * ダミーのControlDataを作成します。<br/>
     * DBセッションを開き、sqlSessionオブジェクトにDBセッションを代入します。
     */
    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBC"));
        openMainSession();
    }

    /**
     * ロールバックし、DBセッションを閉じます。
     */
    @AfterClass
    public static void tearDownClass() {
        rollBackAndCloseSession();
    }
}
