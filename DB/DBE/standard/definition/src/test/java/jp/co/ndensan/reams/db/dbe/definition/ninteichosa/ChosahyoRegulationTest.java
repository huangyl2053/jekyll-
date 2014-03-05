/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票定義情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosahyoRegulationTest {

    public static class get調査票定義 {

        @Test
        public void 調査票定義に設定がある時_get調査票定義は_該当の調査票定義を返す() {
            assertThat(new ChosahyoRegulation.Of2006().get調査票定義().size(), is(78));
        }
    }
}
