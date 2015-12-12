/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator;
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
 * {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanTokuteiShinryoTokubetsuRyoyoBuilderTest extends DbcTestBase {

    private static DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity ShokanTokuteiShinryoTokubetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanTokuteiShinryoTokubetsuRyoyoBuilder sut;
        private static ShokanTokuteiShinryoTokubetsuRyoyo business;

        @Before
        public void setUp() {
            ShokanTokuteiShinryoTokubetsuRyoyoEntity = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryoTokubetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanTokuteiShinryoTokubetsuRyoyo(ShokanTokuteiShinryoTokubetsuRyoyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            business = sut.set傷病名(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名).build();
            assertThat(business.get傷病名(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の識別番号は_設定した値と同じ識別番号を返す() {
            business = sut.set識別番号(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号).build();
            assertThat(business.get識別番号(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_識別番号));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数は_設定した値と同じ回数を返す() {
            business = sut.set回数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_回数).build();
            assertThat(business.get回数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の合計単位数は_設定した値と同じ合計単位数を返す() {
            business = sut.set合計単位数(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_合計単位数).build();
            assertThat(business.get合計単位数(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_合計単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator.DEFAULT_摘要));
        }

    }
}
