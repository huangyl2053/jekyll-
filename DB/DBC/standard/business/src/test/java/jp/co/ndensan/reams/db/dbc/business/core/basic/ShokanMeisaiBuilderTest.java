/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3039ShokanMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
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
 * {@link ShokanMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanMeisaiBuilderTest extends DbcTestBase {

    private static DbT3039ShokanMeisaiEntity ShokanMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3039ShokanMeisaiEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanMeisaiBuilder sut;
        private static ShokanMeisai business;

        @Before
        public void setUp() {
            ShokanMeisaiEntity = new DbT3039ShokanMeisaiEntity();
            ShokanMeisaiEntity.setHiHokenshaNo(主キー名1);
            ShokanMeisaiEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanMeisai(ShokanMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数_回数は_設定した値と同じ日数_回数を返す() {
            business = sut.set日数_回数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_日数_回数).build();
            assertThat(business.get日数_回数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_日数_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3039ShokanMeisaiEntityGenerator.DEFAULT_摘要));
        }

    }
}
