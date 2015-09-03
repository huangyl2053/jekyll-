/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator;
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
 * {@link SaishinsaKetteiShukeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SaishinsaKetteiShukeiBuilderTest extends DbcTestBase {

    private static DbT3063SaishinsaKetteiShukeiEntity SaishinsaKetteiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
        主キー名2 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
        主キー名3 = DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static SaishinsaKetteiShukeiBuilder sut;
        private static SaishinsaKetteiShukei business;

        @Before
        public void setUp() {
            SaishinsaKetteiShukeiEntity = new DbT3063SaishinsaKetteiShukeiEntity();
            SaishinsaKetteiShukeiEntity.setToriatsukaiYM(主キー名1);
            SaishinsaKetteiShukeiEntity.setHokenshaKubun(主キー名2);

            business = new SaishinsaKetteiShukei(SaishinsaKetteiShukeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            business = sut.set取扱年月(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取扱年月).build();
            assertThat(business.get取扱年月(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            business = sut.set保険者区分(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_保険者区分).build();
            assertThat(business.get保険者区分(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の介護給付費_請求_件数は_設定した値と同じ介護給付費_請求_件数を返す() {
            business = sut.set介護給付費_請求_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_件数).build();
            assertThat(business.get介護給付費_請求_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_件数));
        }

        @Test
        public void 戻り値の介護給付費_請求_単位数は_設定した値と同じ介護給付費_請求_単位数を返す() {
            business = sut.set介護給付費_請求_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_単位数).build();
            assertThat(business.get介護給付費_請求_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_単位数));
        }

        @Test
        public void 戻り値の介護給付費_請求_保険者負担額は_設定した値と同じ介護給付費_請求_保険者負担額を返す() {
            business = sut.set介護給付費_請求_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_保険者負担額).build();
            assertThat(business.get介護給付費_請求_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_請求_保険者負担額));
        }

        @Test
        public void 戻り値の介護給付費_決定_件数は_設定した値と同じ介護給付費_決定_件数を返す() {
            business = sut.set介護給付費_決定_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_件数).build();
            assertThat(business.get介護給付費_決定_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_件数));
        }

        @Test
        public void 戻り値の介護給付費_決定_単位数は_設定した値と同じ介護給付費_決定_単位数を返す() {
            business = sut.set介護給付費_決定_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_単位数).build();
            assertThat(business.get介護給付費_決定_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_単位数));
        }

        @Test
        public void 戻り値の介護給付費_決定_保険者負担額は_設定した値と同じ介護給付費_決定_保険者負担額を返す() {
            business = sut.set介護給付費_決定_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_保険者負担額).build();
            assertThat(business.get介護給付費_決定_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_決定_保険者負担額));
        }

        @Test
        public void 戻り値の介護給付費_調整_件数は_設定した値と同じ介護給付費_調整_件数を返す() {
            business = sut.set介護給付費_調整_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_件数).build();
            assertThat(business.get介護給付費_調整_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_件数));
        }

        @Test
        public void 戻り値の介護給付費_調整_単位数は_設定した値と同じ介護給付費_調整_単位数を返す() {
            business = sut.set介護給付費_調整_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_単位数).build();
            assertThat(business.get介護給付費_調整_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_単位数));
        }

        @Test
        public void 戻り値の介護給付費_調整_保険者負担額は_設定した値と同じ介護給付費_調整_保険者負担額を返す() {
            business = sut.set介護給付費_調整_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_保険者負担額).build();
            assertThat(business.get介護給付費_調整_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_介護給付費_調整_保険者負担額));
        }

        @Test
        public void 戻り値の高額介護サービス費_請求_件数は_設定した値と同じ高額介護サービス費_請求_件数を返す() {
            business = sut.set高額介護サービス費_請求_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_件数).build();
            assertThat(business.get高額介護サービス費_請求_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_件数));
        }

        @Test
        public void 戻り値の高額介護サービス費_請求_単位数は_設定した値と同じ高額介護サービス費_請求_単位数を返す() {
            business = sut.set高額介護サービス費_請求_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_単位数).build();
            assertThat(business.get高額介護サービス費_請求_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_単位数));
        }

        @Test
        public void 戻り値の高額介護サービス費_請求_保険者負担額は_設定した値と同じ高額介護サービス費_請求_保険者負担額を返す() {
            business = sut.set高額介護サービス費_請求_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_保険者負担額).build();
            assertThat(business.get高額介護サービス費_請求_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_請求_保険者負担額));
        }

        @Test
        public void 戻り値の高額介護サービス費_決定_件数は_設定した値と同じ高額介護サービス費_決定_件数を返す() {
            business = sut.set高額介護サービス費_決定_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_件数).build();
            assertThat(business.get高額介護サービス費_決定_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_件数));
        }

        @Test
        public void 戻り値の高額介護サービス費_決定_単位数は_設定した値と同じ高額介護サービス費_決定_単位数を返す() {
            business = sut.set高額介護サービス費_決定_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_単位数).build();
            assertThat(business.get高額介護サービス費_決定_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_単位数));
        }

        @Test
        public void 戻り値の高額介護サービス費_決定_保険者負担額は_設定した値と同じ高額介護サービス費_決定_保険者負担額を返す() {
            business = sut.set高額介護サービス費_決定_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_保険者負担額).build();
            assertThat(business.get高額介護サービス費_決定_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_決定_保険者負担額));
        }

        @Test
        public void 戻り値の高額介護サービス費_調整_件数は_設定した値と同じ高額介護サービス費_調整_件数を返す() {
            business = sut.set高額介護サービス費_調整_件数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_件数).build();
            assertThat(business.get高額介護サービス費_調整_件数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_件数));
        }

        @Test
        public void 戻り値の高額介護サービス費_調整_単位数は_設定した値と同じ高額介護サービス費_調整_単位数を返す() {
            business = sut.set高額介護サービス費_調整_単位数(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_単位数).build();
            assertThat(business.get高額介護サービス費_調整_単位数(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_単位数));
        }

        @Test
        public void 戻り値の高額介護サービス費_調整_保険者負担額は_設定した値と同じ高額介護サービス費_調整_保険者負担額を返す() {
            business = sut.set高額介護サービス費_調整_保険者負担額(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_保険者負担額).build();
            assertThat(business.get高額介護サービス費_調整_保険者負担額(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費_調整_保険者負担額));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            business = sut.set公費負担者番号(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号).build();
            assertThat(business.get公費負担者番号(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の作成年月日は_設定した値と同じ作成年月日を返す() {
            business = sut.set作成年月日(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_作成年月日).build();
            assertThat(business.get作成年月日(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_作成年月日));
        }

        @Test
        public void 戻り値の審査委員会名は_設定した値と同じ審査委員会名を返す() {
            business = sut.set審査委員会名(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_審査委員会名).build();
            assertThat(business.get審査委員会名(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_審査委員会名));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
