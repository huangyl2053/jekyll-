/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ShujiiIkensho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書を扱うクラスのファクトリークラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoFactoryTest extends DbeTestBase {

    public static class create主治医意見書Instance extends DbeTestBase {

        @Test
        public void 厚労省IF識別区分の指定がある時_create主治医意見書Instanceは_ShujiiIkenshoのインスタンスを返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A), instanceOf(ShujiiIkensho.class));
        }
    }
}
