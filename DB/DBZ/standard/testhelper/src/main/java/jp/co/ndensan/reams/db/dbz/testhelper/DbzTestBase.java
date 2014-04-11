/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase3}のラッパークラスです。
 *
 * @author N1013 松本直樹
 */
public class DbzTestBase extends TestBase3 {

    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBZ"));
    }
}
