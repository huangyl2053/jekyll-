/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link KogakuGassanShikyuFushikyuKetteiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyuFushikyuKetteiBuilderTest extends DbcTestBase {

    private static DbT3074KogakuGassanShikyuFushikyuKetteiEntity KogakuGassanShikyuFushikyuKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static Decimal 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKetteiBuilder sut;
        private static KogakuGassanShikyuFushikyuKettei business;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = new DbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);

            business = new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            business = sut.set保険制度コード(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険制度コード).build();
            assertThat(business.get保険制度コード(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の国保_被保険者証記号は_設定した値と同じ国保_被保険者証記号を返す() {
            business = sut.set国保_被保険者証記号(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_国保_被保険者証記号).build();
            assertThat(business.get国保_被保険者証記号(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_国保_被保険者証記号));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            business = sut.set対象計算期間開始年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間開始年月日).build();
            assertThat(business.get対象計算期間開始年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            business = sut.set対象計算期間終了年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間終了年月日).build();
            assertThat(business.get対象計算期間終了年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の自己負担総額は_設定した値と同じ自己負担総額を返す() {
            business = sut.set自己負担総額(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担総額).build();
            assertThat(business.get自己負担総額(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_自己負担総額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            business = sut.set支給額(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給額).build();
            assertThat(business.get支給額(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の給付の種類は_設定した値と同じ給付の種類を返す() {
            business = sut.set給付の種類(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_給付の種類).build();
            assertThat(business.get給付の種類(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_給付の種類));
        }

        @Test
        public void 戻り値の不支給理由は_設定した値と同じ不支給理由を返す() {
            business = sut.set不支給理由(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_不支給理由).build();
            assertThat(business.get不支給理由(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_不支給理由));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の支払方法区分は_設定した値と同じ支払方法区分を返す() {
            business = sut.set支払方法区分(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払方法区分).build();
            assertThat(business.get支払方法区分(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払方法区分));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            business = sut.set支払場所(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払場所).build();
            assertThat(business.get支払場所(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            business = sut.set支払期間開始年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始年月日).build();
            assertThat(business.get支払期間開始年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            business = sut.set支払期間終了年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了年月日).build();
            assertThat(business.get支払期間終了年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            business = sut.set閉庁内容(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_閉庁内容).build();
            assertThat(business.get閉庁内容(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払期間開始時間は_設定した値と同じ支払期間開始時間を返す() {
            business = sut.set支払期間開始時間(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始時間).build();
            assertThat(business.get支払期間開始時間(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間開始時間));
        }

        @Test
        public void 戻り値の支払期間終了時間は_設定した値と同じ支払期間終了時間を返す() {
            business = sut.set支払期間終了時間(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了時間).build();
            assertThat(business.get支払期間終了時間(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支払期間終了時間));
        }

        @Test
        public void 戻り値の決定通知書作成年月日は_設定した値と同じ決定通知書作成年月日を返す() {
            business = sut.set決定通知書作成年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定通知書作成年月日).build();
            assertThat(business.get決定通知書作成年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_決定通知書作成年月日));
        }

        @Test
        public void 戻り値の振込通知書作成年月日は_設定した値と同じ振込通知書作成年月日を返す() {
            business = sut.set振込通知書作成年月日(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_振込通知書作成年月日).build();
            assertThat(business.get振込通知書作成年月日(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_振込通知書作成年月日));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            business = sut.set受取年月(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_受取年月).build();
            assertThat(business.get受取年月(), is(DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_受取年月));
        }

    }
}
