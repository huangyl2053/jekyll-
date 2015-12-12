/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3041ShokanTokuteiShinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanTokuteiShinryohiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiShinryohiBuilderTest extends DbcTestBase {

    private static DbT3041ShokanTokuteiShinryohiEntity ShokanTokuteiShinryohiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static Decimal 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanTokuteiShinryohiBuilder sut;
        private static ShokanTokuteiShinryohi business;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = new DbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);

            sut = business.createBuilderForEdit();
        }

//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            business = sut.set傷病名(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_傷病名).build();
            assertThat(business.get傷病名(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の指導管理料等単位数は_設定した値と同じ指導管理料等単位数を返す() {
            business = sut.set指導管理料等単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_指導管理料等単位数).build();
            assertThat(business.get指導管理料等単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_指導管理料等単位数));
        }

        @Test
        public void 戻り値の単純エックス線単位数は_設定した値と同じ単純エックス線単位数を返す() {
            business = sut.set単純エックス線単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_単純エックス線単位数).build();
            assertThat(business.get単純エックス線単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_単純エックス線単位数));
        }

        @Test
        public void 戻り値のリハビリテーション単位数は_設定した値と同じリハビリテーション単位数を返す() {
            business = sut.setリハビリテーション単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_リハビリテーション単位数).build();
            assertThat(business.getリハビリテーション単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_リハビリテーション単位数));
        }

        @Test
        public void 戻り値の精神科専門療法単位数は_設定した値と同じ精神科専門療法単位数を返す() {
            business = sut.set精神科専門療法単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_精神科専門療法単位数).build();
            assertThat(business.get精神科専門療法単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_精神科専門療法単位数));
        }

        @Test
        public void 戻り値の合計単位数は_設定した値と同じ合計単位数を返す() {
            business = sut.set合計単位数(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_合計単位数).build();
            assertThat(business.get合計単位数(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_合計単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            business = sut.set摘要１(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１).build();
            assertThat(business.get摘要１(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            business = sut.set摘要２(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２).build();
            assertThat(business.get摘要２(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            business = sut.set摘要３(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要３).build();
            assertThat(business.get摘要３(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            business = sut.set摘要４(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要４).build();
            assertThat(business.get摘要４(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            business = sut.set摘要５(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要５).build();
            assertThat(business.get摘要５(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            business = sut.set摘要６(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要６).build();
            assertThat(business.get摘要６(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            business = sut.set摘要７(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要７).build();
            assertThat(business.get摘要７(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            business = sut.set摘要８(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要８).build();
            assertThat(business.get摘要８(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            business = sut.set摘要９(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要９).build();
            assertThat(business.get摘要９(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            business = sut.set摘要１０(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１０).build();
            assertThat(business.get摘要１０(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            business = sut.set摘要１１(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１１).build();
            assertThat(business.get摘要１１(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            business = sut.set摘要１２(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１２).build();
            assertThat(business.get摘要１２(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            business = sut.set摘要１３(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１３).build();
            assertThat(business.get摘要１３(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            business = sut.set摘要１４(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１４).build();
            assertThat(business.get摘要１４(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            business = sut.set摘要１５(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１５).build();
            assertThat(business.get摘要１５(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            business = sut.set摘要１６(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１６).build();
            assertThat(business.get摘要１６(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            business = sut.set摘要１７(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１７).build();
            assertThat(business.get摘要１７(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            business = sut.set摘要１８(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１８).build();
            assertThat(business.get摘要１８(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            business = sut.set摘要１９(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１９).build();
            assertThat(business.get摘要１９(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            business = sut.set摘要２０(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２０).build();
            assertThat(business.get摘要２０(), is(DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_摘要２０));
        }

    }
}
