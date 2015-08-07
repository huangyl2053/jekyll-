/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShikyuGakuKeisanKekkaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyuGakuKeisanKekkaBuilderTest extends DbcTestBase {

    private static DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity KogakuGassanShikyuGakuKeisanKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KogakuGassanShikyuGakuKeisanKekkaBuilder sut;
        private static KogakuGassanShikyuGakuKeisanKekka business;

        @Before
        public void setUp() {
            KogakuGassanShikyuGakuKeisanKekkaEntity = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
            KogakuGassanShikyuGakuKeisanKekkaEntity.setXXX(主キー名1);
            KogakuGassanShikyuGakuKeisanKekkaEntity.setXXX(主キー名2);

            business = new KogakuGassanShikyuGakuKeisanKekka(KogakuGassanShikyuGakuKeisanKekkaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            business = sut.set保険制度コード(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_保険制度コード).build();
            assertThat(business.get保険制度コード(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            business = sut.set対象計算期間開始年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間開始年月日).build();
            assertThat(business.get対象計算期間開始年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            business = sut.set対象計算期間終了年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間終了年月日).build();
            assertThat(business.get対象計算期間終了年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の世帯負担総額は_設定した値と同じ世帯負担総額を返す() {
            business = sut.set世帯負担総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯負担総額).build();
            assertThat(business.get世帯負担総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯負担総額));
        }

        @Test
        public void 戻り値の介護等合算一部負担金等世帯合算額は_設定した値と同じ介護等合算一部負担金等世帯合算額を返す() {
            business = sut.set介護等合算一部負担金等世帯合算額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算一部負担金等世帯合算額).build();
            assertThat(business.get介護等合算一部負担金等世帯合算額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算一部負担金等世帯合算額));
        }

        @Test
        public void 戻り値の70歳以上介護等合算一部負担金等世帯合算額は_設定した値と同じ70歳以上介護等合算一部負担金等世帯合算額を返す() {
            business = sut.set70歳以上介護等合算一部負担金等世帯合算額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算一部負担金等世帯合算額).build();
            assertThat(business.get70歳以上介護等合算一部負担金等世帯合算額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算一部負担金等世帯合算額));
        }

        @Test
        public void 戻り値の所得区分は_設定した値と同じ所得区分を返す() {
            business = sut.set所得区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_所得区分).build();
            assertThat(business.get所得区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_所得区分));
        }

        @Test
        public void 戻り値の70歳以上の者に係る所得区分は_設定した値と同じ70歳以上の者に係る所得区分を返す() {
            business = sut.set70歳以上の者に係る所得区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上の者に係る所得区分).build();
            assertThat(business.get70歳以上の者に係る所得区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上の者に係る所得区分));
        }

        @Test
        public void 戻り値の介護等合算算定基準額は_設定した値と同じ介護等合算算定基準額を返す() {
            business = sut.set介護等合算算定基準額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算算定基準額).build();
            assertThat(business.get介護等合算算定基準額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護等合算算定基準額));
        }

        @Test
        public void 戻り値の70歳以上介護等合算算定基準額は_設定した値と同じ70歳以上介護等合算算定基準額を返す() {
            business = sut.set70歳以上介護等合算算定基準額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算算定基準額).build();
            assertThat(business.get70歳以上介護等合算算定基準額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上介護等合算算定基準額));
        }

        @Test
        public void 戻り値の世帯支給総額は_設定した値と同じ世帯支給総額を返す() {
            business = sut.set世帯支給総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯支給総額).build();
            assertThat(business.get世帯支給総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_世帯支給総額));
        }

        @Test
        public void 戻り値のうち70歳以上分世帯支給総額は_設定した値と同じうち70歳以上分世帯支給総額を返す() {
            business = sut.setうち70歳以上分世帯支給総額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分世帯支給総額).build();
            assertThat(business.getうち70歳以上分世帯支給総額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分世帯支給総額));
        }

        @Test
        public void 戻り値の按分後支給額は_設定した値と同じ按分後支給額を返す() {
            business = sut.set按分後支給額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_按分後支給額).build();
            assertThat(business.get按分後支給額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_按分後支給額));
        }

        @Test
        public void 戻り値のうち70歳以上分按分後支給額は_設定した値と同じうち70歳以上分按分後支給額を返す() {
            business = sut.setうち70歳以上分按分後支給額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分按分後支給額).build();
            assertThat(business.getうち70歳以上分按分後支給額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_うち70歳以上分按分後支給額));
        }

        @Test
        public void 戻り値の介護低所得者Ⅰ再計算実施の有無は_設定した値と同じ介護低所得者Ⅰ再計算実施の有無を返す() {
            business = sut.set介護低所得者Ⅰ再計算実施の有無(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護低所得者Ⅰ再計算実施の有無).build();
            assertThat(business.get介護低所得者Ⅰ再計算実施の有無(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_介護低所得者Ⅰ再計算実施の有無));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先郵便番号は_設定した値と同じ支給額計算結果連絡先郵便番号を返す() {
            business = sut.set支給額計算結果連絡先郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先郵便番号).build();
            assertThat(business.get支給額計算結果連絡先郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先郵便番号));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先住所は_設定した値と同じ支給額計算結果連絡先住所を返す() {
            business = sut.set支給額計算結果連絡先住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先住所).build();
            assertThat(business.get支給額計算結果連絡先住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先住所));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先名称1は_設定した値と同じ支給額計算結果連絡先名称1を返す() {
            business = sut.set支給額計算結果連絡先名称1(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称1).build();
            assertThat(business.get支給額計算結果連絡先名称1(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称1));
        }

        @Test
        public void 戻り値の支給額計算結果連絡先名称2は_設定した値と同じ支給額計算結果連絡先名称2を返す() {
            business = sut.set支給額計算結果連絡先名称2(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称2).build();
            assertThat(business.get支給額計算結果連絡先名称2(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額計算結果連絡先名称2));
        }

        @Test
        public void 戻り値の通知年月日は_設定した値と同じ通知年月日を返す() {
            business = sut.set通知年月日(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_通知年月日).build();
            assertThat(business.get通知年月日(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_通知年月日));
        }

        @Test
        public void 戻り値の連絡票発行者名は_設定した値と同じ連絡票発行者名を返す() {
            business = sut.set連絡票発行者名(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者名).build();
            assertThat(business.get連絡票発行者名(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者名));
        }

        @Test
        public void 戻り値の連絡票発行者郵便番号は_設定した値と同じ連絡票発行者郵便番号を返す() {
            business = sut.set連絡票発行者郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者郵便番号).build();
            assertThat(business.get連絡票発行者郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者郵便番号));
        }

        @Test
        public void 戻り値の連絡票発行者住所は_設定した値と同じ連絡票発行者住所を返す() {
            business = sut.set連絡票発行者住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者住所).build();
            assertThat(business.get連絡票発行者住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_連絡票発行者住所));
        }

        @Test
        public void 戻り値の問い合わせ先郵便番号は_設定した値と同じ問い合わせ先郵便番号を返す() {
            business = sut.set問い合わせ先郵便番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先郵便番号).build();
            assertThat(business.get問い合わせ先郵便番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先郵便番号));
        }

        @Test
        public void 戻り値の問い合わせ先住所は_設定した値と同じ問い合わせ先住所を返す() {
            business = sut.set問い合わせ先住所(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先住所).build();
            assertThat(business.get問い合わせ先住所(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先住所));
        }

        @Test
        public void 戻り値の問い合わせ先名称1は_設定した値と同じ問い合わせ先名称1を返す() {
            business = sut.set問い合わせ先名称1(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称1).build();
            assertThat(business.get問い合わせ先名称1(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称1));
        }

        @Test
        public void 戻り値の問い合わせ先名称2は_設定した値と同じ問い合わせ先名称2を返す() {
            business = sut.set問い合わせ先名称2(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称2).build();
            assertThat(business.get問い合わせ先名称2(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先名称2));
        }

        @Test
        public void 戻り値の問い合わせ先電話番号は_設定した値と同じ問い合わせ先電話番号を返す() {
            business = sut.set問い合わせ先電話番号(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先電話番号).build();
            assertThat(business.get問い合わせ先電話番号(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_問い合わせ先電話番号));
        }

        @Test
        public void 戻り値の70歳以上負担額合計は_設定した値と同じ70歳以上負担額合計を返す() {
            business = sut.set70歳以上負担額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上負担額合計).build();
            assertThat(business.get70歳以上負担額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上負担額合計));
        }

        @Test
        public void 戻り値の70歳以上支給額合計は_設定した値と同じ70歳以上支給額合計を返す() {
            business = sut.set70歳以上支給額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上支給額合計).build();
            assertThat(business.get70歳以上支給額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳以上支給額合計));
        }

        @Test
        public void 戻り値の70歳未満負担額合計は_設定した値と同じ70歳未満負担額合計を返す() {
            business = sut.set70歳未満負担額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満負担額合計).build();
            assertThat(business.get70歳未満負担額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満負担額合計));
        }

        @Test
        public void 戻り値の負担額の合計額は_設定した値と同じ負担額の合計額を返す() {
            business = sut.set負担額の合計額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_負担額の合計額).build();
            assertThat(business.get負担額の合計額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_負担額の合計額));
        }

        @Test
        public void 戻り値の70歳未満支給額合計は_設定した値と同じ70歳未満支給額合計を返す() {
            business = sut.set70歳未満支給額合計(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満支給額合計).build();
            assertThat(business.get70歳未満支給額合計(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_70歳未満支給額合計));
        }

        @Test
        public void 戻り値の支給額合計額は_設定した値と同じ支給額合計額を返す() {
            business = sut.set支給額合計額(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額合計額).build();
            assertThat(business.get支給額合計額(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_支給額合計額));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            business = sut.setデータ区分(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_データ区分).build();
            assertThat(business.getデータ区分(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            business = sut.set受取年月(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_受取年月).build();
            assertThat(business.get受取年月(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator.DEFAULT_送付年月));
        }

    }
}
