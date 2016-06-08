/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ServiceCodeBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ServiceCodeBuilderTest extends DbcTestBase {

    private static DbT7119ServiceCodeEntity ServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static ServiceKomokuCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
        主キー名3 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月;
        主キー名4 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ServiceCodeBuilder sut;
        private static ServiceCode business;

        @Before
        public void setUp() {
            ServiceCodeEntity = new DbT7119ServiceCodeEntity();
            ServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ServiceCodeEntity.setServiceKomokuCode(主キー名2);

            business = new ServiceCode(ServiceCodeEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            business = sut.setサービス名称(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス名称).build();
            assertThat(business.getサービス名称(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の限度額対象外フラグは_設定した値と同じ限度額対象外フラグを返す() {
            business = sut.set限度額対象外フラグ(DbT7119ServiceCodeEntityGenerator.DEFAULT_限度額対象外フラグ).build();
            assertThat(business.get限度額対象外フラグ(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_限度額対象外フラグ));
        }

        @Test
        public void 戻り値の単位数識別コードは_設定した値と同じ単位数識別コードを返す() {
            business = sut.set単位数識別コード(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数識別コード).build();
            assertThat(business.get単位数識別コード(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_単位数識別コード));
        }

        @Test
        public void 戻り値の外部サービス利用型区分は_設定した値と同じ外部サービス利用型区分を返す() {
            business = sut.set外部サービス利用型区分(DbT7119ServiceCodeEntityGenerator.DEFAULT_外部サービス利用型区分).build();
            assertThat(business.get外部サービス利用型区分(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_外部サービス利用型区分));
        }

        @Test
        public void 戻り値の特別地域加算フラグは_設定した値と同じ特別地域加算フラグを返す() {
            business = sut.set特別地域加算フラグ(DbT7119ServiceCodeEntityGenerator.DEFAULT_特別地域加算フラグ).build();
            assertThat(business.get特別地域加算フラグ(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_特別地域加算フラグ));
        }

        @Test
        public void 戻り値の利用者負担定率_定額区分は_設定した値と同じ利用者負担定率_定額区分を返す() {
            business = sut.set利用者負担定率_定額区分(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担定率_定額区分).build();
            assertThat(business.get利用者負担定率_定額区分(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担定率_定額区分));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            business = sut.set給付率(DbT7119ServiceCodeEntityGenerator.DEFAULT_給付率).build();
            assertThat(business.get給付率(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_給付率));
        }

    }
}
