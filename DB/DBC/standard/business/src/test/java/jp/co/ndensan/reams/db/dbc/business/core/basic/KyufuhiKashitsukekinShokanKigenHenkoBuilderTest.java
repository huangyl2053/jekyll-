/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyufuhiKashitsukekinShokanKigenHenkoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShokanKigenHenkoBuilderTest extends DbcTestBase {

    private static DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity KyufuhiKashitsukekinShokanKigenHenkoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 貸付管理番号;
    private static FlexibleDate 償還期限延長受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号;
        貸付管理番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号;
        償還期限延長受付年月日 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日;
        履歴番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenkoBuilder sut;
        private static KyufuhiKashitsukekinShokanKigenHenko business;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = new DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);

            business = new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            business = sut.set貸付管理番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号).build();
            assertThat(business.get貸付管理番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の償還期限延長受付年月日は_設定した値と同じ償還期限延長受付年月日を返す() {
            business = sut.set償還期限延長受付年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日).build();
            assertThat(business.get償還期限延長受付年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の償還期限延長申請年月日は_設定した値と同じ償還期限延長申請年月日を返す() {
            business = sut.set償還期限延長申請年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長申請年月日).build();
            assertThat(business.get償還期限延長申請年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長申請年月日));
        }

        @Test
        public void 戻り値の借受人郵便番号は_設定した値と同じ借受人郵便番号を返す() {
            business = sut.set借受人郵便番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人郵便番号).build();
            assertThat(business.get借受人郵便番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人郵便番号));
        }

        @Test
        public void 戻り値の借受人住所は_設定した値と同じ借受人住所を返す() {
            business = sut.set借受人住所(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人住所).build();
            assertThat(business.get借受人住所(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人住所));
        }

        @Test
        public void 戻り値の借受人氏名カナは_設定した値と同じ借受人氏名カナを返す() {
            business = sut.set借受人氏名カナ(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名カナ).build();
            assertThat(business.get借受人氏名カナ(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名カナ));
        }

        @Test
        public void 戻り値の借受人氏名は_設定した値と同じ借受人氏名を返す() {
            business = sut.set借受人氏名(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名).build();
            assertThat(business.get借受人氏名(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人氏名));
        }

        @Test
        public void 戻り値の借受人電話番号は_設定した値と同じ借受人電話番号を返す() {
            business = sut.set借受人電話番号(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人電話番号).build();
            assertThat(business.get借受人電話番号(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_借受人電話番号));
        }

        @Test
        public void 戻り値の未償還金額は_設定した値と同じ未償還金額を返す() {
            business = sut.set未償還金額(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_未償還金額).build();
            assertThat(business.get未償還金額(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_未償還金額));
        }

        @Test
        public void 戻り値の償還期限延長希望期間開始年月日は_設定した値と同じ償還期限延長希望期間開始年月日を返す() {
            business = sut.set償還期限延長希望期間開始年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間開始年月日).build();
            assertThat(business.get償還期限延長希望期間開始年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間開始年月日));
        }

        @Test
        public void 戻り値の償還期限延長希望期間終了年月日は_設定した値と同じ償還期限延長希望期間終了年月日を返す() {
            business = sut.set償還期限延長希望期間終了年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間終了年月日).build();
            assertThat(business.get償還期限延長希望期間終了年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長希望期間終了年月日));
        }

        @Test
        public void 戻り値の償還期限延長理由等は_設定した値と同じ償還期限延長理由等を返す() {
            business = sut.set償還期限延長理由等(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長理由等).build();
            assertThat(business.get償還期限延長理由等(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長理由等));
        }

        @Test
        public void 戻り値の償還期限変更決定年月日は_設定した値と同じ償還期限変更決定年月日を返す() {
            business = sut.set償還期限変更決定年月日(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更決定年月日).build();
            assertThat(business.get償還期限変更決定年月日(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更決定年月日));
        }

        @Test
        public void 戻り値の償還期限変更承認_不承認区分は_設定した値と同じ償還期限変更承認_不承認区分を返す() {
            business = sut.set償還期限変更承認_不承認区分(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更承認_不承認区分).build();
            assertThat(business.get償還期限変更承認_不承認区分(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更承認_不承認区分));
        }

        @Test
        public void 戻り値の変更後償還期限は_設定した値と同じ変更後償還期限を返す() {
            business = sut.set変更後償還期限(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_変更後償還期限).build();
            assertThat(business.get変更後償還期限(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_変更後償還期限));
        }

        @Test
        public void 戻り値の償還期限変更不承認理由は_設定した値と同じ償還期限変更不承認理由を返す() {
            business = sut.set償還期限変更不承認理由(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更不承認理由).build();
            assertThat(business.get償還期限変更不承認理由(), is(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限変更不承認理由));
        }

    }
}
