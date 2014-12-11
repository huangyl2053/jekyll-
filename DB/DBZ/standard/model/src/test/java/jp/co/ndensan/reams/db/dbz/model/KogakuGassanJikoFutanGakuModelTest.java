/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3070KogakuGassanJikoFutanGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanJikoFutanGakuModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanJikoFutanGakuModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanJikoFutanGakuModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            sut.set保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号);
            assertThat(sut.get保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            sut.set保険制度コード(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険制度コード);
            assertThat(sut.get保険制度コード(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の保険者名は_設定した値と同じ保険者名を返す() {
            sut.set保険者名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者名);
            assertThat(sut.get保険者名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_保険者名));
        }

        @Test
        public void 戻り値の国保被保険者証記号は_設定した値と同じ国保被保険者証記号を返す() {
            sut.set国保被保険者証記号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証記号);
            assertThat(sut.get国保被保険者証記号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証記号));
        }

        @Test
        public void 戻り値の被保険者氏名カナは_設定した値と同じ被保険者氏名カナを返す() {
            sut.set被保険者氏名カナ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名カナ);
            assertThat(sut.get被保険者氏名カナ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名カナ));
        }

        @Test
        public void 戻り値の被保険者氏名は_設定した値と同じ被保険者氏名を返す() {
            sut.set被保険者氏名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名);
            assertThat(sut.get被保険者氏名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者氏名));
        }

        @Test
        public void 戻り値の生年月日は_設定した値と同じ生年月日を返す() {
            sut.set生年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_生年月日);
            assertThat(sut.get生年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_生年月日));
        }

        @Test
        public void 戻り値の性別は_設定した値と同じ性別を返す() {
            sut.set性別(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_性別);
            assertThat(sut.get性別(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_性別));
        }

        @Test
        public void 戻り値の所得区分は_設定した値と同じ所得区分を返す() {
            sut.set所得区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_所得区分);
            assertThat(sut.get所得区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_所得区分));
        }

        @Test
        public void 戻り値の70歳以上の者に係る所得区分は_設定した値と同じ70歳以上の者に係る所得区分を返す() {
            sut.set70歳以上の者に係る所得区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_70歳以上の者に係る所得区分);
            assertThat(sut.get70歳以上の者に係る所得区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_70歳以上の者に係る所得区分));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の後期保険者番号は_設定した値と同じ後期保険者番号を返す() {
            sut.set後期保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期保険者番号);
            assertThat(sut.get後期保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期保険者番号));
        }

        @Test
        public void 戻り値の後期被保険者番号は_設定した値と同じ後期被保険者番号を返す() {
            sut.set後期被保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期被保険者番号);
            assertThat(sut.get後期被保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期被保険者番号));
        }

        @Test
        public void 戻り値の国保保険者番号は_設定した値と同じ国保保険者番号を返す() {
            sut.set国保保険者番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保保険者番号);
            assertThat(sut.get国保保険者番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保保険者番号));
        }

        @Test
        public void 戻り値の国保被保険者証番号は_設定した値と同じ国保被保険者証番号を返す() {
            sut.set国保被保険者証番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証番号);
            assertThat(sut.get国保被保険者証番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保被保険者証番号));
        }

        @Test
        public void 戻り値の国保個人番号は_設定した値と同じ国保個人番号を返す() {
            sut.set国保個人番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保個人番号);
            assertThat(sut.get国保個人番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_国保個人番号));
        }

        @Test
        public void 戻り値の異動区分は_設定した値と同じ異動区分を返す() {
            sut.set異動区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_異動区分);
            assertThat(sut.get異動区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_異動区分));
        }

        @Test
        public void 戻り値の補正済自己負担額送付区分は_設定した値と同じ補正済自己負担額送付区分を返す() {
            sut.set補正済自己負担額送付区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額送付区分);
            assertThat(sut.get補正済自己負担額送付区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額送付区分));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            sut.set対象計算期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間開始年月日);
            assertThat(sut.get対象計算期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            sut.set対象計算期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間終了年月日);
            assertThat(sut.get対象計算期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の被保険者期間開始年月日は_設定した値と同じ被保険者期間開始年月日を返す() {
            sut.set被保険者期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間開始年月日);
            assertThat(sut.get被保険者期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間開始年月日));
        }

        @Test
        public void 戻り値の被保険者期間終了年月日は_設定した値と同じ被保険者期間終了年月日を返す() {
            sut.set被保険者期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間終了年月日);
            assertThat(sut.get被保険者期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_被保険者期間終了年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            sut.set申請年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_申請年月日);
            assertThat(sut.get申請年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の合計_自己負担額は_設定した値と同じ合計_自己負担額を返す() {
            sut.set合計_自己負担額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_自己負担額);
            assertThat(sut.get合計_自己負担額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_自己負担額));
        }

        @Test
        public void 戻り値の合計_70_74自己負担額_内訳は_設定した値と同じ合計_70_74自己負担額_内訳を返す() {
            sut.set合計_70_74自己負担額_内訳(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74自己負担額_内訳);
            assertThat(sut.get合計_70_74自己負担額_内訳(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74自己負担額_内訳));
        }

        @Test
        public void 戻り値の合計_70未満高額支給額は_設定した値と同じ合計_70未満高額支給額を返す() {
            sut.set合計_70未満高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70未満高額支給額);
            assertThat(sut.get合計_70未満高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70未満高額支給額));
        }

        @Test
        public void 戻り値の合計_70_74高額支給額は_設定した値と同じ合計_70_74高額支給額を返す() {
            sut.set合計_70_74高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74高額支給額);
            assertThat(sut.get合計_70_74高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_合計_70_74高額支給額));
        }

        @Test
        public void 戻り値の補正済_合計_自己負担額は_設定した値と同じ補正済_合計_自己負担額を返す() {
            sut.set補正済_合計_自己負担額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_自己負担額);
            assertThat(sut.get補正済_合計_自己負担額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_自己負担額));
        }

        @Test
        public void 戻り値の補正済_合計_70_74自己負担額_内訳は_設定した値と同じ補正済_合計_70_74自己負担額_内訳を返す() {
            sut.set補正済_合計_70_74自己負担額_内訳(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74自己負担額_内訳);
            assertThat(sut.get補正済_合計_70_74自己負担額_内訳(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74自己負担額_内訳));
        }

        @Test
        public void 戻り値の補正済_合計_70未満高額支給額は_設定した値と同じ補正済_合計_70未満高額支給額を返す() {
            sut.set補正済_合計_70未満高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70未満高額支給額);
            assertThat(sut.get補正済_合計_70未満高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70未満高額支給額));
        }

        @Test
        public void 戻り値の補正済_合計_70_74高額支給額は_設定した値と同じ補正済_合計_70_74高額支給額を返す() {
            sut.set補正済_合計_70_74高額支給額(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74高額支給額);
            assertThat(sut.get補正済_合計_70_74高額支給額(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済_合計_70_74高額支給額));
        }

        @Test
        public void 戻り値の宛先氏名は_設定した値と同じ宛先氏名を返す() {
            sut.set宛先氏名(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先氏名);
            assertThat(sut.get宛先氏名(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先氏名));
        }

        @Test
        public void 戻り値の宛先郵便番号は_設定した値と同じ宛先郵便番号を返す() {
            sut.set宛先郵便番号(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先郵便番号);
            assertThat(sut.get宛先郵便番号(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先郵便番号));
        }

        @Test
        public void 戻り値の宛先住所は_設定した値と同じ宛先住所を返す() {
            sut.set宛先住所(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先住所);
            assertThat(sut.get宛先住所(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_宛先住所));
        }

        @Test
        public void 戻り値の窓口払対象者判定コードは_設定した値と同じ窓口払対象者判定コードを返す() {
            sut.set窓口払対象者判定コード(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_窓口払対象者判定コード);
            assertThat(sut.get窓口払対象者判定コード(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_窓口払対象者判定コード));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            sut.set支払場所(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払場所);
            assertThat(sut.get支払場所(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            sut.set支払期間開始年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始年月日);
            assertThat(sut.get支払期間開始年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            sut.set支払期間終了年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了年月日);
            assertThat(sut.get支払期間終了年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            sut.set閉庁内容(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_閉庁内容);
            assertThat(sut.get閉庁内容(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払期間開始時間は_設定した値と同じ支払期間開始時間を返す() {
            sut.set支払期間開始時間(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始時間);
            assertThat(sut.get支払期間開始時間(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間開始時間));
        }

        @Test
        public void 戻り値の支払期間終了時間は_設定した値と同じ支払期間終了時間を返す() {
            sut.set支払期間終了時間(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了時間);
            assertThat(sut.get支払期間終了時間(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_支払期間終了時間));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値のデータ作成区分は_設定した値と同じデータ作成区分を返す() {
            sut.setデータ作成区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_データ作成区分);
            assertThat(sut.getデータ作成区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_データ作成区分));
        }

        @Test
        public void 戻り値の自己負担額確認情報受取年月は_設定した値と同じ自己負担額確認情報受取年月を返す() {
            sut.set自己負担額確認情報受取年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額確認情報受取年月);
            assertThat(sut.get自己負担額確認情報受取年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額確認情報受取年月));
        }

        @Test
        public void 戻り値の補正済自己負担額情報送付年月は_設定した値と同じ補正済自己負担額情報送付年月を返す() {
            sut.set補正済自己負担額情報送付年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額情報送付年月);
            assertThat(sut.get補正済自己負担額情報送付年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_補正済自己負担額情報送付年月));
        }

        @Test
        public void 戻り値の自己負担額証明書情報受取年月は_設定した値と同じ自己負担額証明書情報受取年月を返す() {
            sut.set自己負担額証明書情報受取年月(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書情報受取年月);
            assertThat(sut.get自己負担額証明書情報受取年月(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書情報受取年月));
        }

        @Test
        public void 戻り値の再送フラグは_設定した値と同じ再送フラグを返す() {
            sut.set再送フラグ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_再送フラグ);
            assertThat(sut.get再送フラグ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_再送フラグ));
        }

        @Test
        public void 戻り値の送付対象外フラグは_設定した値と同じ送付対象外フラグを返す() {
            sut.set送付対象外フラグ(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_送付対象外フラグ);
            assertThat(sut.get送付対象外フラグ(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_送付対象外フラグ));
        }

        @Test
        public void 戻り値の自己負担額計算年月日は_設定した値と同じ自己負担額計算年月日を返す() {
            sut.set自己負担額計算年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額計算年月日);
            assertThat(sut.get自己負担額計算年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額計算年月日));
        }

        @Test
        public void 戻り値の自己負担額証明書作成年月日は_設定した値と同じ自己負担額証明書作成年月日を返す() {
            sut.set自己負担額証明書作成年月日(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書作成年月日);
            assertThat(sut.get自己負担額証明書作成年月日(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_自己負担額証明書作成年月日));
        }

        @Test
        public void 戻り値の後期_国保処理区分は_設定した値と同じ後期_国保処理区分を返す() {
            sut.set後期_国保処理区分(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期_国保処理区分);
            assertThat(sut.get後期_国保処理区分(), is(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.DEFAULT_後期_国保処理区分));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanJikoFutanGakuModel sut = new KogakuGassanJikoFutanGakuModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanJikoFutanGakuModel sut = new KogakuGassanJikoFutanGakuModel();
        //sut.setEntity(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanJikoFutanGakuModel sut = new KogakuGassanJikoFutanGakuModel();
            sut.setEntity(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanJikoFutanGakuModel sut = new KogakuGassanJikoFutanGakuModel();
            sut.setEntity(DbT3070KogakuGassanJikoFutanGakuEntityGenerator.createDbT3070KogakuGassanJikoFutanGakuEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
