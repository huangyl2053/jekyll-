/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書の定義を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoRegulationTest {

    public static class get意見書定義 {

        @Test
        public void 意見書定義に設定がある時_get意見書定義は_該当の意見書定義を返す() {
            assertThat(new ShujiiIkenshoRegulationOf2009().get意見書定義().size(), is(136));
        }
    }
}
