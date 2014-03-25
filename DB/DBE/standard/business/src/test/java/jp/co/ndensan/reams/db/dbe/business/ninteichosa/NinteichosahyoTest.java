/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosahyoRegulationOf2009;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査票定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new Ninteichosahyo(null, NinteichosaItemGroupOf2009.values());
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new Ninteichosahyo(new NinteichosahyoRegulationOf2009().get基本調査定義(), null);
        }
    }

    public static class get調査項目 {

        @Test
        public void 調査項目区分の指定がある時_get調査項目は_該当の調査項目を返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目(NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢).get表示名称(), is(new RString("左上肢")));
        }

        @Test
        public void 調査項目区分がNULLの時_get調査項目は_NULLを返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目(null), is(nullValue()));
        }
    }

    public static class get調査項目List {

        @Test
        public void 調査項目グループの指定がある時_get調査項目Listは_該当の調査項目を返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目List(NinteichosaItemGroupOf2009.第１群).size(), is(22));
        }

        @Test
        public void 調査項目グループがNULLの時_get調査項目Listは_0件の調査項目を返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目List(null).size(), is(0));
        }
    }

    public static class get調査項目ListAll {

        @Test
        public void 調査項目の設定がある時_get調査項目ListAllは_全調査項目を返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目ListAll().size(), is(78));
        }
    }

    public static class get調査項目グループ {

        @Test
        public void 調査項目グループの設定がある時_get調査項目グループは_全調査項目グループを返す() {
            assertThat(NinteichosahyoFactory.create基本情報Instance(KoroshoIFKubun.V09A).get調査項目グループ().length, is(9));
        }
    }
}
