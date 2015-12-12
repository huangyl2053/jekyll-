/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator;
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
 * {@link ShokanJutakuKaishuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuBuilderTest extends DbcTestBase {

    private static DbT3049ShokanJutakuKaishuEntity ShokanJutakuKaishuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanJutakuKaishuBuilder sut;
        private static ShokanJutakuKaishu business;

        @Before
        public void setUp() {
            ShokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
            ShokanJutakuKaishuEntity.setHiHokenshaNo(主キー名1);
            ShokanJutakuKaishuEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanJutakuKaishu(ShokanJutakuKaishuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の住宅改修着工年月日は_設定した値と同じ住宅改修着工年月日を返す() {
            business = sut.set住宅改修着工年月日(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修着工年月日).build();
            assertThat(business.get住宅改修着工年月日(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修着工年月日));
        }

        @Test
        public void 戻り値の住宅改修事業者名は_設定した値と同じ住宅改修事業者名を返す() {
            business = sut.set住宅改修事業者名(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修事業者名).build();
            assertThat(business.get住宅改修事業者名(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修事業者名));
        }

        @Test
        public void 戻り値の住宅改修住宅住所は_設定した値と同じ住宅改修住宅住所を返す() {
            business = sut.set住宅改修住宅住所(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修住宅住所).build();
            assertThat(business.get住宅改修住宅住所(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修住宅住所));
        }

        @Test
        public void 戻り値の改修金額は_設定した値と同じ改修金額を返す() {
            business = sut.set改修金額(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_改修金額).build();
            assertThat(business.get改修金額(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_改修金額));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            business = sut.set審査方法区分コード(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_審査方法区分コード).build();
            assertThat(business.get審査方法区分コード(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の住宅改修完成年月日は_設定した値と同じ住宅改修完成年月日を返す() {
            business = sut.set住宅改修完成年月日(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修完成年月日).build();
            assertThat(business.get住宅改修完成年月日(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_住宅改修完成年月日));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            business = sut.set差額金額(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_差額金額).build();
            assertThat(business.get差額金額(), is(DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_差額金額));
        }

    }
}
