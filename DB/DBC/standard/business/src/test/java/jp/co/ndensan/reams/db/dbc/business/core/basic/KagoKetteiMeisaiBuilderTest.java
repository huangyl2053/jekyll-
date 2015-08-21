/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator;
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
 * {@link KagoKetteiMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoKetteiMeisaiBuilderTest extends DbcTestBase {

    private static DbT3061KagoKetteiMeisaiEntity KagoKetteiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KagoKetteiMeisaiBuilder sut;
        private static KagoKetteiMeisai business;

        @Before
        public void setUp() {
            KagoKetteiMeisaiEntity = new DbT3061KagoKetteiMeisaiEntity();
            KagoKetteiMeisaiEntity.setToriatsukaiYM(主キー名1);
            KagoKetteiMeisaiEntity.setHokenshaKubun(主キー名2);

            business = new KagoKetteiMeisai(KagoKetteiMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            business = sut.set取扱年月(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月).build();
            assertThat(business.get取扱年月(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            business = sut.set保険者区分(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分).build();
            assertThat(business.get保険者区分(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の事業所名は_設定した値と同じ事業所名を返す() {
            business = sut.set事業所名(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所名).build();
            assertThat(business.get事業所名(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_事業所名));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の公費受給者番号は_設定した値と同じ公費受給者番号を返す() {
            business = sut.set公費受給者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号).build();
            assertThat(business.get公費受給者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_公費受給者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス種類名は_設定した値と同じサービス種類名を返す() {
            business = sut.setサービス種類名(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名).build();
            assertThat(business.getサービス種類名(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_サービス種類名));
        }

        @Test
        public void 戻り値の過誤申立事由コードは_設定した値と同じ過誤申立事由コードを返す() {
            business = sut.set過誤申立事由コード(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由コード).build();
            assertThat(business.get過誤申立事由コード(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由コード));
        }

        @Test
        public void 戻り値の過誤申立事由は_設定した値と同じ過誤申立事由を返す() {
            business = sut.set過誤申立事由(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由).build();
            assertThat(business.get過誤申立事由(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_過誤申立事由));
        }

        @Test
        public void 戻り値の単位数_特定入所者介護費等は_設定した値と同じ単位数_特定入所者介護費等を返す() {
            business = sut.set単位数_特定入所者介護費等(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_単位数_特定入所者介護費等).build();
            assertThat(business.get単位数_特定入所者介護費等(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_単位数_特定入所者介護費等));
        }

        @Test
        public void 戻り値の保険者負担額は_設定した値と同じ保険者負担額を返す() {
            business = sut.set保険者負担額(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額).build();
            assertThat(business.get保険者負担額(), is(DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者負担額));
        }

    }
}
