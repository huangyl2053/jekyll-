/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3070KogakuGassanJikoFutanGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
 * {@link KogakuGassanJikoFutanGakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuBuilderTest extends DbcTestBase {

    private static DbT3070KogakuGassanJikoFutanGakuEntity KogakuGassanJikoFutanGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuBuilder sut;
        private static KogakuGassanJikoFutanGaku business;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuEntity = new DbT3070KogakuGassanJikoFutanGakuEntity();
            KogakuGassanJikoFutanGakuEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuEntity.setTaishoNendo(主キー名2);

            business = new KogakuGassanJikoFutanGaku(KogakuGassanJikoFutanGakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            business = sut.set保険制度コード(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険制度コード).build();
            assertThat(business.get保険制度コード(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の保険者名は_設定した値と同じ保険者名を返す() {
            business = sut.set保険者名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者名).build();
            assertThat(business.get保険者名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者名));
        }

        @Test
        public void 戻り値の国保被保険者証記号は_設定した値と同じ国保被保険者証記号を返す() {
            business = sut.set国保被保険者証記号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証記号).build();
            assertThat(business.get国保被保険者証記号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証記号));
        }

        @Test
        public void 戻り値の被保険者氏名カナは_設定した値と同じ被保険者氏名カナを返す() {
            business = sut.set被保険者氏名カナ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名カナ).build();
            assertThat(business.get被保険者氏名カナ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void 戻り値の被保険者氏名は_設定した値と同じ被保険者氏名を返す() {
            business = sut.set被保険者氏名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名).build();
            assertThat(business.get被保険者氏名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            business = sut.set生年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_生年月日).build();
            assertThat(business.get生年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別は_設定した値と同じ性別を返す() {
            business = sut.set性別(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_性別).build();
            assertThat(business.get性別(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void 戻り値の所得区分は_設定した値と同じ所得区分を返す() {
            business = sut.set所得区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_所得区分).build();
            assertThat(business.get所得区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_所得区分));
        }

        @Test
        public void 戻り値の70歳以上の者に係る所得区分は_設定した値と同じ70歳以上の者に係る所得区分を返す() {
            business = sut.set所得区分_70歳以上の者に係る(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_70歳以上の者に係る所得区分).build();
            assertThat(business.get70歳以上の者に係る所得区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_70歳以上の者に係る所得区分));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の後期保険者番号は_設定した値と同じ後期保険者番号を返す() {
            business = sut.set後期保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期保険者番号).build();
            assertThat(business.get後期保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期保険者番号));
        }

        @Test
        public void 戻り値の後期被保険者番号は_設定した値と同じ後期被保険者番号を返す() {
            business = sut.set後期被保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期被保険者番号).build();
            assertThat(business.get後期被保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期被保険者番号));
        }

        @Test
        public void 戻り値の国保保険者番号は_設定した値と同じ国保保険者番号を返す() {
            business = sut.set国保保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保保険者番号).build();
            assertThat(business.get国保保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保保険者番号));
        }

        @Test
        public void 戻り値の国保被保険者証番号は_設定した値と同じ国保被保険者証番号を返す() {
            business = sut.set国保被保険者証番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証番号).build();
            assertThat(business.get国保被保険者証番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証番号));
        }

        @Test
        public void 戻り値の国保個人番号は_設定した値と同じ国保個人番号を返す() {
            business = sut.set国保個人番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保個人番号).build();
            assertThat(business.get国保個人番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保個人番号));
        }

        @Test
        public void 戻り値の異動区分は_設定した値と同じ異動区分を返す() {
            business = sut.set異動区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_異動区分).build();
            assertThat(business.get異動区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_異動区分));
        }

        @Test
        public void 戻り値の補正済自己負担額送付区分は_設定した値と同じ補正済自己負担額送付区分を返す() {
            business = sut.set補正済自己負担額送付区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額送付区分).build();
            assertThat(business.get補正済自己負担額送付区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額送付区分));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            business = sut.set対象計算期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間開始年月日).build();
            assertThat(business.get対象計算期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            business = sut.set対象計算期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間終了年月日).build();
            assertThat(business.get対象計算期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の被保険者期間開始年月日は_設定した値と同じ被保険者期間開始年月日を返す() {
            business = sut.set被保険者期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間開始年月日).build();
            assertThat(business.get被保険者期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間開始年月日));
        }

        @Test
        public void 戻り値の被保険者期間終了年月日は_設定した値と同じ被保険者期間終了年月日を返す() {
            business = sut.set被保険者期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間終了年月日).build();
            assertThat(business.get被保険者期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間終了年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の合計_自己負担額は_設定した値と同じ合計_自己負担額を返す() {
            business = sut.set合計_自己負担額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_自己負担額).build();
            assertThat(business.get合計_自己負担額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_自己負担額));
        }

        @Test
        public void 戻り値の合計_70_74自己負担額_内訳は_設定した値と同じ合計_70_74自己負担額_内訳を返す() {
            business = sut.set合計_70_74自己負担額_内訳(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74自己負担額_内訳).build();
            assertThat(business.get合計_70_74自己負担額_内訳(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74自己負担額_内訳));
        }

        @Test
        public void 戻り値の合計_70未満高額支給額は_設定した値と同じ合計_70未満高額支給額を返す() {
            business = sut.set合計_70未満高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70未満高額支給額).build();
            assertThat(business.get合計_70未満高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70未満高額支給額));
        }

        @Test
        public void 戻り値の合計_70_74高額支給額は_設定した値と同じ合計_70_74高額支給額を返す() {
            business = sut.set合計_70_74高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74高額支給額).build();
            assertThat(business.get合計_70_74高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74高額支給額));
        }

        @Test
        public void 戻り値の補正済_合計_自己負担額は_設定した値と同じ補正済_合計_自己負担額を返す() {
            business = sut.set補正済_合計_自己負担額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_自己負担額).build();
            assertThat(business.get補正済_合計_自己負担額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_自己負担額));
        }

        @Test
        public void 戻り値の補正済_合計_70_74自己負担額_内訳は_設定した値と同じ補正済_合計_70_74自己負担額_内訳を返す() {
            business = sut.set補正済_合計_70_74自己負担額_内訳(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74自己負担額_内訳).build();
            assertThat(business.get補正済_合計_70_74自己負担額_内訳(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74自己負担額_内訳));
        }

        @Test
        public void 戻り値の補正済_合計_70未満高額支給額は_設定した値と同じ補正済_合計_70未満高額支給額を返す() {
            business = sut.set補正済_合計_70未満高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70未満高額支給額).build();
            assertThat(business.get補正済_合計_70未満高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70未満高額支給額));
        }

        @Test
        public void 戻り値の補正済_合計_70_74高額支給額は_設定した値と同じ補正済_合計_70_74高額支給額を返す() {
            business = sut.set補正済_合計_70_74高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74高額支給額).build();
            assertThat(business.get補正済_合計_70_74高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74高額支給額));
        }

        @Test
        public void 戻り値の宛先氏名は_設定した値と同じ宛先氏名を返す() {
            business = sut.set宛先氏名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先氏名).build();
            assertThat(business.get宛先氏名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先氏名));
        }

        @Test
        public void 戻り値の宛先郵便番号は_設定した値と同じ宛先郵便番号を返す() {
            business = sut.set宛先郵便番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先郵便番号).build();
            assertThat(business.get宛先郵便番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先郵便番号));
        }

        @Test
        public void 戻り値の宛先住所は_設定した値と同じ宛先住所を返す() {
            business = sut.set宛先住所(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先住所).build();
            assertThat(business.get宛先住所(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先住所));
        }

        @Test
        public void 戻り値の窓口払対象者判定コードは_設定した値と同じ窓口払対象者判定コードを返す() {
            business = sut.set窓口払対象者判定コード(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_窓口払対象者判定コード).build();
            assertThat(business.get窓口払対象者判定コード(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_窓口払対象者判定コード));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            business = sut.set支払場所(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払場所).build();
            assertThat(business.get支払場所(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            business = sut.set支払期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始年月日).build();
            assertThat(business.get支払期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            business = sut.set支払期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了年月日).build();
            assertThat(business.get支払期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            business = sut.set閉庁内容(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_閉庁内容).build();
            assertThat(business.get閉庁内容(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払期間開始時間は_設定した値と同じ支払期間開始時間を返す() {
            business = sut.set支払期間開始時間(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始時間).build();
            assertThat(business.get支払期間開始時間(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始時間));
        }

        @Test
        public void 戻り値の支払期間終了時間は_設定した値と同じ支払期間終了時間を返す() {
            business = sut.set支払期間終了時間(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了時間).build();
            assertThat(business.get支払期間終了時間(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了時間));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値のデータ作成区分は_設定した値と同じデータ作成区分を返す() {
            business = sut.setデータ作成区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_データ作成区分).build();
            assertThat(business.getデータ作成区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_データ作成区分));
        }

        @Test
        public void 戻り値の自己負担額確認情報受取年月は_設定した値と同じ自己負担額確認情報受取年月を返す() {
            business = sut.set自己負担額確認情報受取年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額確認情報受取年月).build();
            assertThat(business.get自己負担額確認情報受取年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額確認情報受取年月));
        }

        @Test
        public void 戻り値の補正済自己負担額情報送付年月は_設定した値と同じ補正済自己負担額情報送付年月を返す() {
            business = sut.set補正済自己負担額情報送付年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額情報送付年月).build();
            assertThat(business.get補正済自己負担額情報送付年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額情報送付年月));
        }

        @Test
        public void 戻り値の自己負担額証明書情報受取年月は_設定した値と同じ自己負担額証明書情報受取年月を返す() {
            business = sut.set自己負担額証明書情報受取年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書情報受取年月).build();
            assertThat(business.get自己負担額証明書情報受取年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書情報受取年月));
        }

        @Test
        public void 戻り値の再送フラグは_設定した値と同じ再送フラグを返す() {
            business = sut.set再送フラグ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_再送フラグ).build();
            assertThat(business.get再送フラグ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_再送フラグ));
        }

        @Test
        public void 戻り値の送付対象外フラグは_設定した値と同じ送付対象外フラグを返す() {
            business = sut.set送付対象外フラグ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_送付対象外フラグ).build();
            assertThat(business.get送付対象外フラグ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_送付対象外フラグ));
        }

        @Test
        public void 戻り値の自己負担額計算年月日は_設定した値と同じ自己負担額計算年月日を返す() {
            business = sut.set自己負担額計算年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額計算年月日).build();
            assertThat(business.get自己負担額計算年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額計算年月日));
        }

        @Test
        public void 戻り値の自己負担額証明書作成年月日は_設定した値と同じ自己負担額証明書作成年月日を返す() {
            business = sut.set自己負担額証明書作成年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書作成年月日).build();
            assertThat(business.get自己負担額証明書作成年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書作成年月日));
        }

        @Test
        public void 戻り値の後期_国保処理区分は_設定した値と同じ後期_国保処理区分を返す() {
            business = sut.set後期_国保処理区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期_国保処理区分).build();
            assertThat(business.get後期_国保処理区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期_国保処理区分));
        }

    }
}
