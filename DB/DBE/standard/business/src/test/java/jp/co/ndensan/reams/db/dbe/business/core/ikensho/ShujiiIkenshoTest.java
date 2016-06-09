/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ikensho.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 意見書定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ShujiiIkensho(null, Arrays.asList(ShujiiIkenshoItemGroupOf2009.values()));
        }

        @Test(expected = NullPointerException.class)
        public void 意見書項目グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ShujiiIkensho(new ShujiiIkenshoRegulationOf2009().get意見書定義(), null);
        }
    }

    public static class get意見書項目 extends DbeTestBase {

        @Test
        public void 意見書項目区分の指定がある時_get意見書項目は_該当の意見書項目を返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目(ShujiiIkenshoItemKubun.短期記憶).get表示名称(), is(new RString("短期記憶")));
        }

        @Test
        public void 意見書項目区分がNULLの時_get意見書項目は_NULLを返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目(null), is(nullValue()));
        }
    }

    public static class get意見書項目List extends DbeTestBase {

        @Test
        public void 意見書項目グループの指定がある時_get意見書項目Listは_該当の意見書項目を返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目List(ShujiiIkenshoItemGroupOf2009.傷病).size(), is(9));
        }

        @Test
        public void 意見書項目グループがNULLの時_get意見書項目Listは_0件の意見書項目を返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目List(null).size(), is(0));
        }
    }

    public static class get意見書項目ListAll extends DbeTestBase {

        @Test
        public void 意見書項目の設定がある時_get意見書項目ListAllは_全意見書項目を返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目ListAll().size(), is(136));
        }
    }

    public static class get主要意見書項目List extends DbeTestBase {

        @Test
        public void 主要意見書項目の設定がある時_get主要意見書項目Listは_該当の意見書項目を返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get主要意見書項目List().size(), is(5));
        }
    }

    public static class get意見書項目グループ extends DbeTestBase {

        @Test
        public void 意見書項目グループの設定がある時_get意見書項目グループは_全意見書項目グループを返す() {
            assertThat(ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目グループ().size(), is(5));
        }
    }
}
