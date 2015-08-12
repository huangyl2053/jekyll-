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
 * {@link KyufuhiKashitsukekinShakuyoshoJuriBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShakuyoshoJuriBuilderTest extends DbcTestBase {

    private static DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity KyufuhiKashitsukekinShakuyoshoJuriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufuhiKashitsukekinShakuyoshoJuriBuilder sut;
        private static KyufuhiKashitsukekinShakuyoshoJuri business;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShakuyoshoJuriEntity = new DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity();
            KyufuhiKashitsukekinShakuyoshoJuriEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShakuyoshoJuriEntity.setXXX(主キー名2);

            business = new KyufuhiKashitsukekinShakuyoshoJuri(KyufuhiKashitsukekinShakuyoshoJuriEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            business = sut.set借入申請年月日(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借入申請年月日).build();
            assertThat(business.get借入申請年月日(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の借受年月日は_設定した値と同じ借受年月日を返す() {
            business = sut.set借受年月日(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受年月日).build();
            assertThat(business.get借受年月日(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受年月日));
        }

        @Test
        public void 戻り値の借受人郵便番号は_設定した値と同じ借受人郵便番号を返す() {
            business = sut.set借受人郵便番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人郵便番号).build();
            assertThat(business.get借受人郵便番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人郵便番号));
        }

        @Test
        public void 戻り値の借受人住所は_設定した値と同じ借受人住所を返す() {
            business = sut.set借受人住所(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人住所).build();
            assertThat(business.get借受人住所(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人住所));
        }

        @Test
        public void 戻り値の借受人氏名カナは_設定した値と同じ借受人氏名カナを返す() {
            business = sut.set借受人氏名カナ(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名カナ).build();
            assertThat(business.get借受人氏名カナ(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名カナ));
        }

        @Test
        public void 戻り値の借受人氏名は_設定した値と同じ借受人氏名を返す() {
            business = sut.set借受人氏名(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名).build();
            assertThat(business.get借受人氏名(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人氏名));
        }

        @Test
        public void 戻り値の借受人電話番号は_設定した値と同じ借受人電話番号を返す() {
            business = sut.set借受人電話番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人電話番号).build();
            assertThat(business.get借受人電話番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_借受人電話番号));
        }

        @Test
        public void 戻り値の保証人氏名カナは_設定した値と同じ保証人氏名カナを返す() {
            business = sut.set保証人氏名カナ(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名カナ).build();
            assertThat(business.get保証人氏名カナ(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名カナ));
        }

        @Test
        public void 戻り値の保証人氏名は_設定した値と同じ保証人氏名を返す() {
            business = sut.set保証人氏名(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名).build();
            assertThat(business.get保証人氏名(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人氏名));
        }

        @Test
        public void 戻り値の保証人郵便番号は_設定した値と同じ保証人郵便番号を返す() {
            business = sut.set保証人郵便番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人郵便番号).build();
            assertThat(business.get保証人郵便番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人郵便番号));
        }

        @Test
        public void 戻り値の保証人住所は_設定した値と同じ保証人住所を返す() {
            business = sut.set保証人住所(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人住所).build();
            assertThat(business.get保証人住所(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人住所));
        }

        @Test
        public void 戻り値の保証人電話番号は_設定した値と同じ保証人電話番号を返す() {
            business = sut.set保証人電話番号(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人電話番号).build();
            assertThat(business.get保証人電話番号(), is(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntityGenerator.DEFAULT_保証人電話番号));
        }

    }
}
