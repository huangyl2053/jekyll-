/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator;
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
 * {@link ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiNyushoshaKaigoServiceHiyoBuilderTest extends DbcTestBase {

    private static DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanTokuteiNyushoshaKaigoServiceHiyoBuilder sut;
        private static ShokanTokuteiNyushoshaKaigoServiceHiyo business;

        @Before
        public void setUp() {
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanTokuteiNyushoshaKaigoServiceHiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の費用単価は_設定した値と同じ費用単価を返す() {
            business = sut.set費用単価(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価).build();
            assertThat(business.get費用単価(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価));
        }

        @Test
        public void 戻り値の負担限度額は_設定した値と同じ負担限度額を返す() {
            business = sut.set負担限度額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額).build();
            assertThat(business.get負担限度額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額));
        }

        @Test
        public void 戻り値の日数は_設定した値と同じ日数を返す() {
            business = sut.set日数(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_日数).build();
            assertThat(business.get日数(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_日数));
        }

        @Test
        public void 戻り値の費用額は_設定した値と同じ費用額を返す() {
            business = sut.set費用額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額).build();
            assertThat(business.get費用額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額));
        }

        @Test
        public void 戻り値の保険分請求額は_設定した値と同じ保険分請求額を返す() {
            business = sut.set保険分請求額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額).build();
            assertThat(business.get保険分請求額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の費用額合計は_設定した値と同じ費用額合計を返す() {
            business = sut.set費用額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計).build();
            assertThat(business.get費用額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計));
        }

        @Test
        public void 戻り値の保険分請求額合計は_設定した値と同じ保険分請求額合計を返す() {
            business = sut.set保険分請求額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計).build();
            assertThat(business.get保険分請求額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            business = sut.set利用者負担額合計(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計).build();
            assertThat(business.get利用者負担額合計(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数_金額は_設定した値と同じ点数_金額を返す() {
            business = sut.set点数_金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_点数_金額).build();
            assertThat(business.get点数_金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_点数_金額));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            business = sut.set支給金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給金額).build();
            assertThat(business.get支給金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            business = sut.set増減点(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_増減点).build();
            assertThat(business.get増減点(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            business = sut.set差額金額(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_差額金額).build();
            assertThat(business.get差額金額(), is(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator.DEFAULT_差額金額));
        }

    }
}
