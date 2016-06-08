/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票定義を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoRegulationTest extends DbeTestBase {

    public static class getサービス状況調査定義 extends DbeTestBase {

        @Test
        public void サービス状況調査定義に設定がある時_getサービス状況調査定義は_該当の概況調査定義を返す() {
            assertThat(new NinteichosahyoRegulationOf2009().getサービス状況調査定義().size(), is(28));
        }
    }

    public static class get基本調査定義 extends DbeTestBase {

        @Test
        public void 基本調査定義に設定がある時_get基本調査定義は_該当の基本調査定義を返す() {
            assertThat(new NinteichosahyoRegulationOf2009().get基本調査定義().size(), is(78));
        }
    }
}
