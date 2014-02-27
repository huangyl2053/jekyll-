/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票情報を扱うクラスのファクトリークラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoFactoryTest {

    public static class createInstance {

        @Test
        public void 調査票改定年度の指定がある時_createInstanceは_Ninteichosahyoのインスタンスを返す() {
            assertThat(NinteichosahyoFactory.createInstance(2006), instanceOf(Ninteichosahyo.class));
        }
    }
}
