/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShikyuGakuKeisanKekkaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyuGakuKeisanKekkaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanShikyuGakuKeisanKekkaModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanShikyuGakuKeisanKekkaModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            sut.set保険制度コード(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_保険制度コード);
            assertThat(sut.get保険制度コード(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            sut.set自己負担額証明書整理番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_自己負担額証明書整理番号);
            assertThat(sut.get自己負担額証明書整理番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            sut.set対象計算期間開始年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間開始年月日);
            assertThat(sut.get対象計算期間開始年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            sut.set対象計算期間終了年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間終了年月日);
            assertThat(sut.get対象計算期間終了年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の世帯負担総額は_設定した値と同じ世帯負担総額を返す() {
            sut.set世帯負担総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯負担総額);
            assertThat(sut.get世帯負担総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯負担総額));
        }

        @Test
        public void 戻り値の介護等合算一部負担金等世帯合算額は_設定した値と同じ介護等合算一部負担金等世帯合算額を返す() {
            sut.set介護等合算一部負担金等世帯合算額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算一部負担金等世帯合算額);
            assertThat(sut.get介護等合算一部負担金等世帯合算額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算一部負担金等世帯合算額));
        }

        @Test
        public void 戻り値の70歳以上介護等合算一部負担金等世帯合算額は_設定した値と同じ70歳以上介護等合算一部負担金等世帯合算額を返す() {
            sut.set70歳以上介護等合算一部負担金等世帯合算額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算一部負担金等世帯合算額);
            assertThat(sut.get70歳以上介護等合算一部負担金等世帯合算額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算一部負担金等世帯合算額));
        }

        @Test
        public void 戻り値の所得区分は_設定した値と同じ所得区分を返す() {
            sut.set所得区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_所得区分);
            assertThat(sut.get所得区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_所得区分));
        }

        @Test
        public void 戻り値の70歳以上の者に係る所得区分は_設定した値と同じ70歳以上の者に係る所得区分を返す() {
            sut.set70歳以上の者に係る所得区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上の者に係る所得区分);
            assertThat(sut.get70歳以上の者に係る所得区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上の者に係る所得区分));
        }

        @Test
        public void 戻り値の介護等合算算定基準額は_設定した値と同じ介護等合算算定基準額を返す() {
            sut.set介護等合算算定基準額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算算定基準額);
            assertThat(sut.get介護等合算算定基準額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算算定基準額));
        }

        @Test
        public void 戻り値の70歳以上介護等合算算定基準額は_設定した値と同じ70歳以上介護等合算算定基準額を返す() {
            sut.set70歳以上介護等合算算定基準額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算算定基準額);
            assertThat(sut.get70歳以上介護等合算算定基準額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算算定基準額));
        }

        @Test
        public void 戻り値の世帯支給総額は_設定した値と同じ世帯支給総額を返す() {
            sut.set世帯支給総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯支給総額);
            assertThat(sut.get世帯支給総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯支給総額));
        }

        @Test
        public void 戻り値のうち70歳以上分世帯支給総額は_設定した値と同じうち70歳以上分世帯支給総額を返す() {
            sut.setうち70歳以上分世帯支給総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分世帯支給総額);
            assertThat(sut.getうち70歳以上分世帯支給総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分世帯支給総額));
        }

        @Test
        public void 戻り値の按分後支給額は_設定した値と同じ按分後支給額を返す() {
            sut.set按分後支給額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_按分後支給額);
            assertThat(sut.get按分後支給額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_按分後支給額));
        }

        @Test
        public void 戻り値のうち70歳以上分按分後支給額は_設定した値と同じうち70歳以上分按分後支給額を返す() {
            sut.setうち70歳以上分按分後支給額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分按分後支給額);
            assertThat(sut.getうち70歳以上分按分後支給額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分按分後支給額));
        }

        @Test
        public void 戻り値の介護低所得者Ⅰ再計算実施の有無は_設定した値と同じ介護低所得者Ⅰ再計算実施の有無を返す() {
            sut.set介護低所得者Ⅰ再計算実施の有無(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護低所得者Ⅰ再計算実施の有無);
            assertThat(sut.get介護低所得者Ⅰ再計算実施の有無(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護低所得者Ⅰ再計算実施の有無));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            sut.set備考(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_備考);
            assertThat(sut.get備考(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先郵便番号は_設定した値と同じ支給額計算結果連絡先郵便番号を返す() {
            sut.set支給額計算結果連絡先郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先郵便番号);
            assertThat(sut.get支給額計算結果連絡先郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先郵便番号));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先住所は_設定した値と同じ支給額計算結果連絡先住所を返す() {
            sut.set支給額計算結果連絡先住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先住所);
            assertThat(sut.get支給額計算結果連絡先住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先住所));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先名称1は_設定した値と同じ支給額計算結果連絡先名称1を返す() {
            sut.set支給額計算結果連絡先名称1(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称1);
            assertThat(sut.get支給額計算結果連絡先名称1(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称1));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先名称2は_設定した値と同じ支給額計算結果連絡先名称2を返す() {
            sut.set支給額計算結果連絡先名称2(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称2);
            assertThat(sut.get支給額計算結果連絡先名称2(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称2));
        }

        @Test
        public void 戻り値の通知年月日は_設定した値と同じ通知年月日を返す() {
            sut.set通知年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_通知年月日);
            assertThat(sut.get通知年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_通知年月日));
        }

        @Test
        public void 戻り値の連絡票発行者名は_設定した値と同じ連絡票発行者名を返す() {
            sut.set連絡票発行者名(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者名);
            assertThat(sut.get連絡票発行者名(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者名));
        }

        @Test
        public void 戻り値の連絡票発行者郵便番号は_設定した値と同じ連絡票発行者郵便番号を返す() {
            sut.set連絡票発行者郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者郵便番号);
            assertThat(sut.get連絡票発行者郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者郵便番号));
        }

        @Test
        public void 戻り値の連絡票発行者住所は_設定した値と同じ連絡票発行者住所を返す() {
            sut.set連絡票発行者住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者住所);
            assertThat(sut.get連絡票発行者住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者住所));
        }

        @Test
        public void 戻り値の問い合わせ先郵便番号は_設定した値と同じ問い合わせ先郵便番号を返す() {
            sut.set問い合わせ先郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先郵便番号);
            assertThat(sut.get問い合わせ先郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先郵便番号));
        }

        @Test
        public void 戻り値の問い合わせ先住所は_設定した値と同じ問い合わせ先住所を返す() {
            sut.set問い合わせ先住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先住所);
            assertThat(sut.get問い合わせ先住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先住所));
        }

        @Test
        public void 戻り値の問い合わせ先名称1は_設定した値と同じ問い合わせ先名称1を返す() {
            sut.set問い合わせ先名称1(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称1);
            assertThat(sut.get問い合わせ先名称1(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称1));
        }

        @Test
        public void 戻り値の問い合わせ先名称2は_設定した値と同じ問い合わせ先名称2を返す() {
            sut.set問い合わせ先名称2(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称2);
            assertThat(sut.get問い合わせ先名称2(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称2));
        }

        @Test
        public void 戻り値の問い合わせ先電話番号は_設定した値と同じ問い合わせ先電話番号を返す() {
            sut.set問い合わせ先電話番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先電話番号);
            assertThat(sut.get問い合わせ先電話番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先電話番号));
        }

        @Test
        public void 戻り値の70歳以上負担額合計は_設定した値と同じ70歳以上負担額合計を返す() {
            sut.set70歳以上負担額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上負担額合計);
            assertThat(sut.get70歳以上負担額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上負担額合計));
        }

        @Test
        public void 戻り値の70歳以上支給額合計は_設定した値と同じ70歳以上支給額合計を返す() {
            sut.set70歳以上支給額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上支給額合計);
            assertThat(sut.get70歳以上支給額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上支給額合計));
        }

        @Test
        public void 戻り値の70歳未満負担額合計は_設定した値と同じ70歳未満負担額合計を返す() {
            sut.set70歳未満負担額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満負担額合計);
            assertThat(sut.get70歳未満負担額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満負担額合計));
        }

        @Test
        public void 戻り値の負担額の合計額は_設定した値と同じ負担額の合計額を返す() {
            sut.set負担額の合計額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_負担額の合計額);
            assertThat(sut.get負担額の合計額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_負担額の合計額));
        }

        @Test
        public void 戻り値の70歳未満支給額合計は_設定した値と同じ70歳未満支給額合計を返す() {
            sut.set70歳未満支給額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満支給額合計);
            assertThat(sut.get70歳未満支給額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満支給額合計));
        }

        @Test
        public void 戻り値の支給額合計額は_設定した値と同じ支給額合計額を返す() {
            sut.set支給額合計額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額合計額);
            assertThat(sut.get支給額合計額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額合計額));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            sut.setデータ区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_データ区分);
            assertThat(sut.getデータ区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            sut.set受取年月(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_受取年月);
            assertThat(sut.get受取年月(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            sut.set送付年月(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_送付年月);
            assertThat(sut.get送付年月(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_送付年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanShikyuGakuKeisanKekkaModel sut = new KogakuGassanShikyuGakuKeisanKekkaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanShikyuGakuKeisanKekkaModel sut = new KogakuGassanShikyuGakuKeisanKekkaModel();
        //sut.setEntity(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanShikyuGakuKeisanKekkaModel sut = new KogakuGassanShikyuGakuKeisanKekkaModel();
            sut.setEntity(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanShikyuGakuKeisanKekkaModel sut = new KogakuGassanShikyuGakuKeisanKekkaModel();
            sut.setEntity(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
