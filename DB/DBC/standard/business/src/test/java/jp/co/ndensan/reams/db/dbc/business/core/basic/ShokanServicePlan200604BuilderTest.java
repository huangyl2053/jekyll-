/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3046ShokanServicePlan200604EntityGenerator;
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
 * {@link ShokanServicePlan200604Builder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanServicePlan200604BuilderTest extends DbcTestBase {

    private static DbT3046ShokanServicePlan200604Entity ShokanServicePlan200604Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanServicePlan200604Builder sut;
        private static ShokanServicePlan200604 business;

        @Before
        public void setUp() {
            ShokanServicePlan200604Entity = new DbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604Entity.setHiHokenshaNo(主キー名1);
            ShokanServicePlan200604Entity.setServiceTeikyoYM(主キー名2);

            business = new ShokanServicePlan200604(ShokanServicePlan200604Entity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の指定_基準該当事業者区分コードは_設定した値と同じ指定_基準該当事業者区分コードを返す() {
            business = sut.set指定_基準該当事業者区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_指定_基準該当事業者区分コード).build();
            assertThat(business.get指定_基準該当事業者区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_指定_基準該当事業者区分コード));
        }

        @Test
        public void 戻り値の居宅サービス計画作成依頼届出年月日は_設定した値と同じ居宅サービス計画作成依頼届出年月日を返す() {
            business = sut.set居宅サービス計画作成依頼届出年月日(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日).build();
            assertThat(business.get居宅サービス計画作成依頼届出年月日(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            business = sut.set単位数単価(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数単価).build();
            assertThat(business.get単位数単価(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の請求金額は_設定した値と同じ請求金額を返す() {
            business = sut.set請求金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_請求金額).build();
            assertThat(business.get請求金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_請求金額));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            business = sut.set担当介護支援専門員番号(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_担当介護支援専門員番号).build();
            assertThat(business.get担当介護支援専門員番号(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            business = sut.set審査方法区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査方法区分コード).build();
            assertThat(business.get審査方法区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数_金額は_設定した値と同じ点数_金額を返す() {
            business = sut.set点数_金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_点数_金額).build();
            assertThat(business.get点数_金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_点数_金額)
            );
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            business = sut.set支給金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給金額).build();
            assertThat(business.get支給金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の増減点は_設定した値と同じ増減点を返す() {
            business = sut.set増減点(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減点).build();
            assertThat(business.get増減点(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減点));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            business = sut.set差額金額(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_差額金額).build();
            assertThat(business.get差額金額(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_差額金額));
        }

        @Test
        public void 戻り値の増減理由等は_設定した値と同じ増減理由等を返す() {
            business = sut.set増減理由等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減理由等).build();
            assertThat(business.get増減理由等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_増減理由等));
        }

        @Test
        public void 戻り値の不支給理由等は_設定した値と同じ不支給理由等を返す() {
            business = sut.set不支給理由等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_不支給理由等).build();
            assertThat(business.get不支給理由等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_不支給理由等));
        }

        @Test
        public void 戻り値の購入_改修履歴等は_設定した値と同じ購入_改修履歴等を返す() {
            business = sut.set購入_改修履歴等(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_購入_改修履歴等).build();
            assertThat(business.get購入_改修履歴等(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_購入_改修履歴等));
        }

    }
}
