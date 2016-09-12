/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukeiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukeiBuilder;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3053ShokanShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanShukeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShukeiBuilderTest extends DbcTestBase {

    private static DbT3053ShokanShukeiEntity ShokanShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static RString 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanShukeiBuilder sut;
        private static ShokanShukei business;

        @Before
        public void setUp() {
            ShokanShukeiEntity = new DbT3053ShokanShukeiEntity();
            ShokanShukeiEntity.setHiHokenshaNo(主キー名1);
            ShokanShukeiEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanShukei(ShokanShukeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス実日数は_設定した値と同じサービス実日数を返す() {
            business = sut.setサービス実日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス実日数).build();
            assertThat(business.getサービス実日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_サービス実日数));
        }

        @Test
        public void 戻り値の計画単位数は_設定した値と同じ計画単位数を返す() {
            business = sut.set計画単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_計画単位数).build();
            assertThat(business.get計画単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_計画単位数));
        }

        @Test
        public void 戻り値の限度額管理対象単位数は_設定した値と同じ限度額管理対象単位数を返す() {
            business = sut.set限度額管理対象単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象単位数).build();
            assertThat(business.get限度額管理対象単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象単位数));
        }

        @Test
        public void 戻り値の限度額管理対象外単位数は_設定した値と同じ限度額管理対象外単位数を返す() {
            business = sut.set限度額管理対象外単位数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数).build();
            assertThat(business.get限度額管理対象外単位数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_限度額管理対象外単位数));
        }

        @Test
        public void 戻り値の短期入所計画日数は_設定した値と同じ短期入所計画日数を返す() {
            business = sut.set短期入所計画日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所計画日数).build();
            assertThat(business.get短期入所計画日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所計画日数));
        }

        @Test
        public void 戻り値の短期入所実日数は_設定した値と同じ短期入所実日数を返す() {
            business = sut.set短期入所実日数(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所実日数).build();
            assertThat(business.get短期入所実日数(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_短期入所実日数));
        }

        @Test
        public void 戻り値の単位数合計は_設定した値と同じ単位数合計を返す() {
            business = sut.set単位数合計(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数合計).build();
            assertThat(business.get単位数合計(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数合計));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            business = sut.set単位数単価(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数単価).build();
            assertThat(business.get単位数単価(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の請求額は_設定した値と同じ請求額を返す() {
            business = sut.set請求額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額).build();
            assertThat(business.get請求額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の出来高医療費単位数合計は_設定した値と同じ出来高医療費単位数合計を返す() {
            business = sut.set出来高医療費単位数合計(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費単位数合計).build();
            assertThat(business.get出来高医療費単位数合計(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費単位数合計));
        }

        @Test
        public void 戻り値の出来高医療費請求額は_設定した値と同じ出来高医療費請求額を返す() {
            business = sut.set出来高医療費請求額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費請求額).build();
            assertThat(business.get出来高医療費請求額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費請求額));
        }

        @Test
        public void 戻り値の出来高医療費利用者負担額は_設定した値と同じ出来高医療費利用者負担額を返す() {
            business = sut.set出来高医療費利用者負担額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費利用者負担額).build();
            assertThat(business.get出来高医療費利用者負担額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高医療費利用者負担額));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            business = sut.set審査方法区分コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査方法区分コード).build();
            assertThat(business.get審査方法区分コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数_金額は_設定した値と同じ点数_金額を返す() {
            business = sut.set点数_金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_点数_金額).build();
            assertThat(business.get点数_金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_点数_金額));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            business = sut.set支払金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支払金額).build();
            assertThat(business.get支払金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            business = sut.set増減点(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減点).build();
            assertThat(business.get増減点(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の請求額差額金額は_設定した値と同じ請求額差額金額を返す() {
            business = sut.set請求額差額金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額差額金額).build();
            assertThat(business.get請求額差額金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_請求額差額金額));
        }

        @Test
        public void 戻り値の出来高請求額差額金額は_設定した値と同じ出来高請求額差額金額を返す() {
            business = sut.set出来高請求額差額金額(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高請求額差額金額).build();
            assertThat(business.get出来高請求額差額金額(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_出来高請求額差額金額));
        }

        @Test
        public void 戻り値の増減理由等は_設定した値と同じ増減理由等を返す() {
            business = sut.set増減理由等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減理由等).build();
            assertThat(business.get増減理由等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_増減理由等));
        }

        @Test
        public void 戻り値の不支給理由等は_設定した値と同じ不支給理由等を返す() {
            business = sut.set不支給理由等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_不支給理由等).build();
            assertThat(business.get不支給理由等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_不支給理由等));
        }

        @Test
        public void 戻り値の購入_改修履歴等は_設定した値と同じ購入_改修履歴等を返す() {
            business = sut.set購入_改修履歴等(DbT3053ShokanShukeiEntityGenerator.DEFAULT_購入_改修履歴等).build();
            assertThat(business.get購入_改修履歴等(), is(DbT3053ShokanShukeiEntityGenerator.DEFAULT_購入_改修履歴等));
        }

    }
}
