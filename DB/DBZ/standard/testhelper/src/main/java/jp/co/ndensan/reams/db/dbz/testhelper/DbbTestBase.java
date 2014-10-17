/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.testhelper;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase3;
import org.junit.BeforeClass;

/**
 * {@link TestBase}のラッパークラスです。
 *
 * @author n8178 城間篤人
 */
public class DbbTestBase extends TestBase3 {

    /**
     * ダミーのControlDataを作成します。
     */
    @BeforeClass
    public static void setUpClass() {
        setDummyControlData(new RString("DBB"));
    }
}
