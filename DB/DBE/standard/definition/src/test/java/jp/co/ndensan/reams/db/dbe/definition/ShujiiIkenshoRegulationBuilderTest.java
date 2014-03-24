/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書の定義を扱うBuilderクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoRegulationBuilderTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 意見書定義がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ShujiiIkenshoRegulationBuilder(null);
        }
    }

    public static class set意見書項目グループ {

        @Test
        public void 意見書項目グループの指定がある時_set意見書項目グループは_指定した意見書項目グループを設定する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get意見書項目グループ(), is((IShujiiIkenshoItemGroup) ShujiiIkenshoItemGroup.Of2009.傷病));
        }

        @Test
        public void 意見書項目サブグループの指定がある時_set意見書項目グループは_指定した意見書項目サブグループを設定する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get意見書項目サブグループ(), is((IShujiiIkenshoItemSubGroup) ShujiiIkenshoItemSubGroup.Of2009.診断名_発症年月日));
        }

        @Test
        public void 意見書項目グループ変更あり_意見書項目サブグループ変更ありの時_set意見書項目グループは_意見書項目グループ内番号を初期化する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.点滴の管理).get意見書項目グループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更あり_意見書項目サブグループ変更なしの時_set意見書項目グループは_意見書項目グループ内番号を初期化する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度).get意見書項目グループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更なし_意見書項目サブグループ変更ありの時_set意見書項目グループは_意見書項目グループ内番号を初期化しない() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.症状の安定性).get意見書項目グループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更なし_意見書項目サブグループ変更なしの時_set意見書項目グループは_意見書項目グループ内番号を初期化しない() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.中心静脈栄養).get意見書項目グループ内番号(), is(2));
        }

        @Test
        public void 意見書項目グループ変更あり_意見書項目サブグループ変更ありの時_set意見書項目グループは_意見書項目サブグループ内番号を初期化する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.点滴の管理).get意見書項目サブグループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更あり_意見書項目サブグループ変更なしの時_set意見書項目グループは_意見書項目サブグループ内番号を初期化する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.障害高齢者日常生活自立度).get意見書項目サブグループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更なし_意見書項目サブグループ変更ありの時_set意見書項目グループは_意見書項目サブグループ内番号を初期化する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.症状の安定性).get意見書項目サブグループ内番号(), is(1));
        }

        @Test
        public void 意見書項目グループ変更なし_意見書項目サブグループ変更なしの時_set意見書項目グループは_意見書項目サブグループ内番号を初期化しない() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get意見書項目サブグループ内番号(), is(2));
        }
    }

    public static class set意見書項目 {

        @Test
        public void 意見書項目の指定がある時_set意見書項目は_指定した意見書項目グループを設定する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get表示名称(), is(new RString("２．診断名")));
        }

        @Test
        public void 意見書項目サブグループ外の意見書項目の指定がある時_set意見書項目は_意見書項目グループ内番号を加算する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.中心静脈栄養).get意見書項目グループ内番号(), is(2));
        }

        @Test
        public void 意見書項目サブグループ内の意見書項目の指定がある時_set意見書項目は_意見書項目グループ内番号を加算しない() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get意見書項目グループ内番号(), is(1));
        }

        @Test
        public void 意見書項目サブグループ外の意見書項目の指定がある時_set意見書項目は_意見書項目サブグループ内番号を加算しない() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.中心静脈栄養).get意見書項目サブグループ内番号(), is(1));
        }

        @Test
        public void 意見書項目サブグループ内の意見書項目の指定がある時_set意見書項目は_意見書項目サブグループ内番号を加算する() {
            assertThat(create意見書定義().get(ShujiiIkenshoItemKubun.診断名2).get意見書項目サブグループ内番号(), is(2));
        }
    }

    private static Map<ShujiiIkenshoItemKubun, IShujiiIkenshoItem> create意見書定義() {
        Map<ShujiiIkenshoItemKubun, IShujiiIkenshoItem> 意見書定義 = new EnumMap<>(ShujiiIkenshoItemKubun.class);
        ShujiiIkenshoRegulationBuilder builder = new ShujiiIkenshoRegulationBuilder(意見書定義);
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.傷病, ShujiiIkenshoItemSubGroup.Of2009.診断名_発症年月日);
        builder.set意見書項目("1-1", ShujiiIkenshoItemKubun.診断名1, "１．診断名", Choice.FreeInput.values());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.傷病, ShujiiIkenshoItemSubGroup.Of2009.診断名_発症年月日);
        builder.set意見書項目("1-1", ShujiiIkenshoItemKubun.診断名2, "２．診断名", Choice.FreeInput.values());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.傷病, ShujiiIkenshoItemSubGroup.Of2009.安定性);
        builder.set意見書項目("1-2", ShujiiIkenshoItemKubun.症状の安定性, "症状の安定性", Choice.Antei.values());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.特別医療, ShujiiIkenshoItemSubGroup.OfCommon.なし);
        builder.set意見書項目("2-1", ShujiiIkenshoItemKubun.点滴の管理, "点滴の管理", Choice.Checked.values());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.特別医療, ShujiiIkenshoItemSubGroup.OfCommon.なし);
        builder.set意見書項目("2-1", ShujiiIkenshoItemKubun.中心静脈栄養, "中心静脈栄養", Choice.Checked.values());
        builder.set意見書項目グループ(ShujiiIkenshoItemGroup.Of2009.心身状態, ShujiiIkenshoItemSubGroup.OfCommon.なし);
        builder.set意見書項目("3-1", ShujiiIkenshoItemKubun.障害高齢者日常生活自立度, "障害高齢者の日常生活自立度(寝たきり度)", Choice.ShogaiJiritsu.values());
        return 意見書定義;
    }
}
