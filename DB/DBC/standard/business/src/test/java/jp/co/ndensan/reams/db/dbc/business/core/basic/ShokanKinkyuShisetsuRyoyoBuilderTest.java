/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator;
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
 * {@link ShokanKinkyuShisetsuRyoyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanKinkyuShisetsuRyoyoBuilderTest extends DbcTestBase {

    private static DbT3040ShokanKinkyuShisetsuRyoyoEntity ShokanKinkyuShisetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyoBuilder sut;
        private static ShokanKinkyuShisetsuRyoyo business;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の緊急時傷病名１は_設定した値と同じ緊急時傷病名１を返す() {
            business = sut.set緊急時傷病名１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１).build();
            assertThat(business.get緊急時傷病名１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１));
        }

        @Test
        public void 戻り値の緊急時傷病名２は_設定した値と同じ緊急時傷病名２を返す() {
            business = sut.set緊急時傷病名２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２).build();
            assertThat(business.get緊急時傷病名２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２));
        }

        @Test
        public void 戻り値の緊急時傷病名３は_設定した値と同じ緊急時傷病名３を返す() {
            business = sut.set緊急時傷病名３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３).build();
            assertThat(business.get緊急時傷病名３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日１は_設定した値と同じ緊急時治療開始年月日１を返す() {
            business = sut.set緊急時治療開始年月日１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１).build();
            assertThat(business.get緊急時治療開始年月日１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日２は_設定した値と同じ緊急時治療開始年月日２を返す() {
            business = sut.set緊急時治療開始年月日２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２).build();
            assertThat(business.get緊急時治療開始年月日２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日３は_設定した値と同じ緊急時治療開始年月日３を返す() {
            business = sut.set緊急時治療開始年月日３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３).build();
            assertThat(business.get緊急時治療開始年月日３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３));
        }

        @Test
        public void 戻り値の往診日数は_設定した値と同じ往診日数を返す() {
            business = sut.set往診日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数).build();
            assertThat(business.get往診日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数));
        }

        @Test
        public void 戻り値の往診医療機関名は_設定した値と同じ往診医療機関名を返す() {
            business = sut.set往診医療機関名(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名).build();
            assertThat(business.get往診医療機関名(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名));
        }

        @Test
        public void 戻り値の通院日数は_設定した値と同じ通院日数を返す() {
            business = sut.set通院日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数).build();
            assertThat(business.get通院日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数));
        }

        @Test
        public void 戻り値の通院医療機関名は_設定した値と同じ通院医療機関名を返す() {
            business = sut.set通院医療機関名(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名).build();
            assertThat(business.get通院医療機関名(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名));
        }

        @Test
        public void 戻り値の緊急時治療管理単位数は_設定した値と同じ緊急時治療管理単位数を返す() {
            business = sut.set緊急時治療管理単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数).build();
            assertThat(business.get緊急時治療管理単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数));
        }

        @Test
        public void 戻り値の緊急時治療管理日数は_設定した値と同じ緊急時治療管理日数を返す() {
            business = sut.set緊急時治療管理日数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数).build();
            assertThat(business.get緊急時治療管理日数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数));
        }

        @Test
        public void 戻り値の緊急時治療管理小計は_設定した値と同じ緊急時治療管理小計を返す() {
            business = sut.set緊急時治療管理小計(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計).build();
            assertThat(business.get緊急時治療管理小計(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計));
        }

        @Test
        public void 戻り値のリハビリテーション単位数は_設定した値と同じリハビリテーション単位数を返す() {
            business = sut.setリハビリテーション単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション単位数).build();
            assertThat(business.getリハビリテーション単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション単位数));
        }

        @Test
        public void 戻り値の処置単位数は_設定した値と同じ処置単位数を返す() {
            business = sut.set処置単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置単位数).build();
            assertThat(business.get処置単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置単位数));
        }

        @Test
        public void 戻り値の手術単位数は_設定した値と同じ手術単位数を返す() {
            business = sut.set手術単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術単位数).build();
            assertThat(business.get手術単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術単位数));
        }

        @Test
        public void 戻り値の麻酔単位数は_設定した値と同じ麻酔単位数を返す() {
            business = sut.set麻酔単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔単位数).build();
            assertThat(business.get麻酔単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔単位数));
        }

        @Test
        public void 戻り値の放射線治療単位数は_設定した値と同じ放射線治療単位数を返す() {
            business = sut.set放射線治療単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療単位数).build();
            assertThat(business.get放射線治療単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            business = sut.set摘要１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１).build();
            assertThat(business.get摘要１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            business = sut.set摘要２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２).build();
            assertThat(business.get摘要２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            business = sut.set摘要３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３).build();
            assertThat(business.get摘要３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            business = sut.set摘要４(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４).build();
            assertThat(business.get摘要４(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            business = sut.set摘要５(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５).build();
            assertThat(business.get摘要５(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            business = sut.set摘要６(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６).build();
            assertThat(business.get摘要６(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            business = sut.set摘要７(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７).build();
            assertThat(business.get摘要７(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            business = sut.set摘要８(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８).build();
            assertThat(business.get摘要８(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            business = sut.set摘要９(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９).build();
            assertThat(business.get摘要９(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            business = sut.set摘要１０(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０).build();
            assertThat(business.get摘要１０(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            business = sut.set摘要１１(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１).build();
            assertThat(business.get摘要１１(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            business = sut.set摘要１２(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２).build();
            assertThat(business.get摘要１２(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            business = sut.set摘要１３(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３).build();
            assertThat(business.get摘要１３(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            business = sut.set摘要１４(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４).build();
            assertThat(business.get摘要１４(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            business = sut.set摘要１５(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５).build();
            assertThat(business.get摘要１５(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            business = sut.set摘要１６(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６).build();
            assertThat(business.get摘要１６(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            business = sut.set摘要１７(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７).build();
            assertThat(business.get摘要１７(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            business = sut.set摘要１８(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８).build();
            assertThat(business.get摘要１８(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            business = sut.set摘要１９(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９).build();
            assertThat(business.get摘要１９(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            business = sut.set摘要２０(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０).build();
            assertThat(business.get摘要２０(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０));
        }

        @Test
        public void 戻り値の緊急時施設療養費合計単位数は_設定した値と同じ緊急時施設療養費合計単位数を返す() {
            business = sut.set緊急時施設療養費合計単位数(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計単位数).build();
            assertThat(business.get緊急時施設療養費合計単位数(), is(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計単位数));
        }

    }
}
