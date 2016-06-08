/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiKashitsukeKinKetteiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinKetteiBuilderTest extends DbcTestBase {

    private static DbT3087KyufuhiKashitsukeKinKetteiEntity KyufuhiKashitsukeKinKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日;
        主キー名3 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuhiKashitsukeKinKetteiBuilder sut;
        private static KyufuhiKashitsukeKinKettei business;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = new DbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);

            business = new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の借入申請年月日は_設定した値と同じ借入申請年月日を返す() {
            business = sut.set借入申請年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日).build();
            assertThat(business.get借入申請年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の貸付審査決定年月日は_設定した値と同じ貸付審査決定年月日を返す() {
            business = sut.set貸付審査決定年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付審査決定年月日).build();
            assertThat(business.get貸付審査決定年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付審査決定年月日));
        }

        @Test
        public void 戻り値の貸付承認_不承認区分は_設定した値と同じ貸付承認_不承認区分を返す() {
            business = sut.set貸付承認_不承認区分(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付承認_不承認区分).build();
            assertThat(business.get貸付承認_不承認区分(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付承認_不承認区分));
        }

        @Test
        public void 戻り値の貸付管理番号は_設定した値と同じ貸付管理番号を返す() {
            business = sut.set貸付管理番号(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付管理番号).build();
            assertThat(business.get貸付管理番号(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付管理番号));
        }

        @Test
        public void 戻り値の貸付金額は_設定した値と同じ貸付金額を返す() {
            business = sut.set貸付金額(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付金額).build();
            assertThat(business.get貸付金額(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付金額));
        }

        @Test
        public void 戻り値の償還方法は_設定した値と同じ償還方法を返す() {
            business = sut.set償還方法(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還方法).build();
            assertThat(business.get償還方法(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還方法));
        }

        @Test
        public void 戻り値の償還期限は_設定した値と同じ償還期限を返す() {
            business = sut.set償還期限(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還期限).build();
            assertThat(business.get償還期限(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_償還期限));
        }

        @Test
        public void 戻り値の貸付年月日は_設定した値と同じ貸付年月日を返す() {
            business = sut.set貸付年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付年月日).build();
            assertThat(business.get貸付年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付年月日));
        }

        @Test
        public void 戻り値の貸付支払方法は_設定した値と同じ貸付支払方法を返す() {
            business = sut.set貸付支払方法(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付支払方法).build();
            assertThat(business.get貸付支払方法(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付支払方法));
        }

        @Test
        public void 戻り値の貸付窓口支払場所は_設定した値と同じ貸付窓口支払場所を返す() {
            business = sut.set貸付窓口支払場所(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口支払場所).build();
            assertThat(business.get貸付窓口支払場所(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口支払場所));
        }

        @Test
        public void 戻り値の貸付窓口開始年月日は_設定した値と同じ貸付窓口開始年月日を返す() {
            business = sut.set貸付窓口開始年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始年月日).build();
            assertThat(business.get貸付窓口開始年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始年月日));
        }

        @Test
        public void 戻り値の貸付窓口終了年月日は_設定した値と同じ貸付窓口終了年月日を返す() {
            business = sut.set貸付窓口終了年月日(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了年月日).build();
            assertThat(business.get貸付窓口終了年月日(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了年月日));
        }

        @Test
        public void 戻り値の貸付窓口閉庁内容は_設定した値と同じ貸付窓口閉庁内容を返す() {
            business = sut.set貸付窓口閉庁内容(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口閉庁内容).build();
            assertThat(business.get貸付窓口閉庁内容(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口閉庁内容));
        }

        @Test
        public void 戻り値の貸付窓口開始時間は_設定した値と同じ貸付窓口開始時間を返す() {
            business = sut.set貸付窓口開始時間(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始時間).build();
            assertThat(business.get貸付窓口開始時間(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口開始時間));
        }

        @Test
        public void 戻り値の貸付窓口終了時間は_設定した値と同じ貸付窓口終了時間を返す() {
            business = sut.set貸付窓口終了時間(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了時間).build();
            assertThat(business.get貸付窓口終了時間(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付窓口終了時間));
        }

        @Test
        public void 戻り値の貸付不承認理由は_設定した値と同じ貸付不承認理由を返す() {
            business = sut.set貸付不承認理由(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付不承認理由).build();
            assertThat(business.get貸付不承認理由(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_貸付不承認理由));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_識別コード));
        }

    }
}
