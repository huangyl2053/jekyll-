/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ChoiceItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemSubGroupOf2009;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票定義を扱うBuilderクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoRegulationBuilderTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 調査票定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosahyoRegulationBuilder(null);
        }
    }

    public static class set調査項目グループ extends DbeTestBase {

        @Test
        public void 調査項目グループの指定がある時_set調査項目グループは_指定した調査項目グループを設定する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get調査項目グループ(), is((INinteichosaItemGroup) NinteichosaItemGroupOf2009.第１群));
        }

        @Test
        public void 調査項目サブグループの指定がある時_set調査項目グループは_指定した調査項目サブグループを設定する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get調査項目サブグループ(), is((INinteichosaItemSubGroup) NinteichosaItemSubGroupOf2009.麻痺等の有無));
        }

        @Test
        public void 調査項目グループ変更あり_調査項目サブグループ変更ありの時_set調査項目グループは_調査項目グループ内番号を初期化する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.移乗).get調査項目グループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更あり_調査項目サブグループ変更なしの時_set調査項目グループは_調査項目グループ内番号を初期化する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.意思の伝達).get調査項目グループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更なし_調査項目サブグループ変更ありの時_set調査項目グループは_調査項目グループ内番号を初期化しない() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節).get調査項目グループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更なし_調査項目サブグループ変更なしの時_set調査項目グループは_調査項目グループ内番号を初期化しない() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.移動).get調査項目グループ内番号(), is(2));
        }

        @Test
        public void 調査項目グループ変更あり_調査項目サブグループ変更ありの時_set調査項目グループは_調査項目サブグループ内番号を初期化する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.移乗).get調査項目サブグループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更あり_調査項目サブグループ変更なしの時_set調査項目グループは_調査項目サブグループ内番号を初期化する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.意思の伝達).get調査項目サブグループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更なし_調査項目サブグループ変更ありの時_set調査項目グループは_調査項目サブグループ内番号を初期化する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節).get調査項目サブグループ内番号(), is(1));
        }

        @Test
        public void 調査項目グループ変更なし_調査項目サブグループ変更なしの時_set調査項目グループは_調査項目サブグループ内番号を初期化しない() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get調査項目サブグループ内番号(), is(2));
        }
    }

    public static class set調査項目 extends DbeTestBase {

        @Test
        public void 調査項目の指定がある時_set調査項目は_指定した調査項目グループを設定する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get表示名称(), is(new RString("右上肢")));
        }

        @Test
        public void 調査項目サブグループ外の調査項目の指定がある時_set調査項目は_調査項目グループ内番号を加算する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.移動).get調査項目グループ内番号(), is(2));
        }

        @Test
        public void 調査項目サブグループ内の調査項目の指定がある時_set調査項目は_調査項目グループ内番号を加算しない() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get調査項目グループ内番号(), is(1));
        }

        @Test
        public void 調査項目サブグループ外の調査項目の指定がある時_set調査項目は_調査項目サブグループ内番号を加算しない() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.移動).get調査項目サブグループ内番号(), is(1));
        }

        @Test
        public void 調査項目サブグループ内の調査項目の指定がある時_set調査項目は_調査項目サブグループ内番号を加算する() {
            assertThat(create調査票定義().get(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢).get調査項目サブグループ内番号(), is(2));
        }
    }

    private static Map<NinteichosaItemKubunOfKihon, INinteichosaItem> create調査票定義() {
        Map<NinteichosaItemKubunOfKihon, INinteichosaItem> 調査票定義 = new EnumMap<>(NinteichosaItemKubunOfKihon.class);
        NinteichosahyoRegulationBuilder builder = new NinteichosahyoRegulationBuilder(調査票定義);
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroupOf2009.麻痺等の有無);
        builder.set調査項目("1-1", NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢, "左上肢", new ChoiceItem(Arrays.asList(ChoiceResultItem.Checked.values())));
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroupOf2009.麻痺等の有無);
        builder.set調査項目("1-1", NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, "右上肢", new ChoiceItem(Arrays.asList(ChoiceResultItem.Checked.values())));
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第１群, NinteichosaItemSubGroupOf2009.拘縮の有無);
        builder.set調査項目("1-2", NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節, "肩", new ChoiceItem(Arrays.asList(ChoiceResultItem.Checked.values())));
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第２群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("2-1", NinteichosaItemKubunOfKihon.移乗, "移乗", new ChoiceItem(Arrays.asList(ChoiceResultItem.Kaijo3.values())));
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第２群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("2-1", NinteichosaItemKubunOfKihon.移動, "移動", new ChoiceItem(Arrays.asList(ChoiceResultItem.Kaijo3.values())));
        builder.set調査項目グループ(NinteichosaItemGroupOf2009.第３群, NinteichosaItemSubGroup.なし);
        builder.set調査項目("3-1", NinteichosaItemKubunOfKihon.意思の伝達, "意思の伝達", new ChoiceItem(Arrays.asList(ChoiceResultItem.DekiruDekinai2.values())));
        return 調査票定義;
    }
}
