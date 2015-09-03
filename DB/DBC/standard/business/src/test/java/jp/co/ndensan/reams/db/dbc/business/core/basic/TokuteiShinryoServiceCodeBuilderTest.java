/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
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
 * {@link TokuteiShinryoServiceCodeBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TokuteiShinryoServiceCodeBuilderTest extends DbcTestBase {

    private static DbT7120TokuteiShinryoServiceCodeEntity TokuteiShinryoServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static ServiceKomokuCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static TokuteiShinryoServiceCodeBuilder sut;
        private static TokuteiShinryoServiceCode business;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = new DbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setServiceShuruiCode(主キー名1);
            TokuteiShinryoServiceCodeEntity.setServiceKomokuCode(主キー名2);

            business = new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            business = sut.setサービス名称(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス名称).build();
            assertThat(business.getサービス名称(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の単位数識別は_設定した値と同じ単位数識別を返す() {
            business = sut.set単位数識別(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数識別).build();
            assertThat(business.get単位数識別(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_単位数識別));
        }

        @Test
        public void 戻り値の算定単位は_設定した値と同じ算定単位を返す() {
            business = sut.set算定単位(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定単位).build();
            assertThat(business.get算定単位(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定単位));
        }

        @Test
        public void 戻り値の合成識別区分は_設定した値と同じ合成識別区分を返す() {
            business = sut.set合成識別区分(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_合成識別区分).build();
            assertThat(business.get合成識別区分(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_合成識別区分));
        }

        @Test
        public void 戻り値の特定診療区分コードは_設定した値と同じ特定診療区分コードを返す() {
            business = sut.set特定診療区分コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療区分コード).build();
            assertThat(business.get特定診療区分コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療区分コード));
        }

        @Test
        public void 戻り値の特定診療項目コードは_設定した値と同じ特定診療項目コードを返す() {
            business = sut.set特定診療項目コード(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療項目コード).build();
            assertThat(business.get特定診療項目コード(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_特定診療項目コード));
        }

        @Test
        public void 戻り値の算定制約期間は_設定した値と同じ算定制約期間を返す() {
            business = sut.set算定制約期間(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約期間).build();
            assertThat(business.get算定制約期間(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約期間));
        }

        @Test
        public void 戻り値の算定制約回数は_設定した値と同じ算定制約回数を返す() {
            business = sut.set算定制約回数(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約回数).build();
            assertThat(business.get算定制約回数(), is(DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_算定制約回数));
        }

    }
}
