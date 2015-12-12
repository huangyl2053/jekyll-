/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3043ShokanShokujiHiyoEntityGenerator;
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
 * {@link ShokanShokujiHiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoBuilderTest extends DbcTestBase {

    private static DbT3043ShokanShokujiHiyoEntity ShokanShokujiHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanShokujiHiyoBuilder sut;
        private static ShokanShokujiHiyo business;

        @Before
        public void setUp() {
            ShokanShokujiHiyoEntity = new DbT3043ShokanShokujiHiyoEntity();
            ShokanShokujiHiyoEntity.setHiHokenshaNo(主キー名1);
            ShokanShokujiHiyoEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanShokujiHiyo(ShokanShokujiHiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の基本提供日数は_設定した値と同じ基本提供日数を返す() {
            business = sut.set基本提供日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供日数).build();
            assertThat(business.get基本提供日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供日数));
        }

        @Test
        public void 戻り値の基本提供単価は_設定した値と同じ基本提供単価を返す() {
            business = sut.set基本提供単価(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供単価).build();
            assertThat(business.get基本提供単価(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供単価));
        }

        @Test
        public void 戻り値の基本提供金額は_設定した値と同じ基本提供金額を返す() {
            business = sut.set基本提供金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供金額).build();
            assertThat(business.get基本提供金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_基本提供金額));
        }

        @Test
        public void 戻り値の特別提供日数は_設定した値と同じ特別提供日数を返す() {
            business = sut.set特別提供日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供日数).build();
            assertThat(business.get特別提供日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供日数));
        }

        @Test
        public void 戻り値の特別提供単価は_設定した値と同じ特別提供単価を返す() {
            business = sut.set特別提供単価(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供単価).build();
            assertThat(business.get特別提供単価(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供単価));
        }

        @Test
        public void 戻り値の特別提供金額は_設定した値と同じ特別提供金額を返す() {
            business = sut.set特別提供金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供金額).build();
            assertThat(business.get特別提供金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_特別提供金額));
        }

        @Test
        public void 戻り値の食事提供延べ日数は_設定した値と同じ食事提供延べ日数を返す() {
            business = sut.set食事提供延べ日数(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数).build();
            assertThat(business.get食事提供延べ日数(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供延べ日数));
        }

        @Test
        public void 戻り値の食事提供費合計は_設定した値と同じ食事提供費合計を返す() {
            business = sut.set食事提供費合計(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計).build();
            assertThat(business.get食事提供費合計(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費合計));
        }

        @Test
        public void 戻り値の標準負担額_月額は_設定した値と同じ標準負担額_月額を返す() {
            business = sut.set標準負担額_月額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額).build();
            assertThat(business.get標準負担額_月額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_月額));
        }

        @Test
        public void 戻り値の食事提供費請求額は_設定した値と同じ食事提供費請求額を返す() {
            business = sut.set食事提供費請求額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額).build();
            assertThat(business.get食事提供費請求額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_食事提供費請求額));
        }

        @Test
        public void 戻り値の標準負担額_日額は_設定した値と同じ標準負担額_日額を返す() {
            business = sut.set標準負担額_日額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額).build();
            assertThat(business.get標準負担額_日額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_標準負担額_日額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数_金額は_設定した値と同じ点数_金額を返す() {
            business = sut.set点数_金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_点数_金額).build();
            assertThat(business.get点数_金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_点数_金額));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            business = sut.set支給金額(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給金額).build();
            assertThat(business.get支給金額(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            business = sut.set増減点(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_増減点).build();
            assertThat(business.get増減点(), is(DbT3043ShokanShokujiHiyoEntityGenerator.DEFAULT_増減点));
        }

    }
}
