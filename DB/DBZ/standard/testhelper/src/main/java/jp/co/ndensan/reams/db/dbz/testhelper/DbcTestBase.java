/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase}のラッパークラスです。
 *
 * @author n3317 塚田萌
 */
public class DbcTestBase extends TestBase3 {

    /**
     * ダミーのControlDataを作成します。
     */
    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBC"));
    }
}
