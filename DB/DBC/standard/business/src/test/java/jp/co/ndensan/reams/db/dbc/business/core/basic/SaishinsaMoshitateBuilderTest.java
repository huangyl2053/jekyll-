/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3062SaishinsaMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SaishinsaMoshitateBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SaishinsaMoshitateBuilderTest extends DbcTestBase {

    private static DbT3062SaishinsaMoshitateEntity SaishinsaMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static ServiceShuruiCode 主キー名4;
    private static ServiceKomokuCode 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号;
        主キー名2 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月;
        主キー名4 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード;
        主キー名5 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード;
        主キー名6 = DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static SaishinsaMoshitateBuilder sut;
        private static SaishinsaMoshitate business;

        @Before
        public void setUp() {
            SaishinsaMoshitateEntity = new DbT3062SaishinsaMoshitateEntity();
            SaishinsaMoshitateEntity.setJigyoshoNo(主キー名1);
            SaishinsaMoshitateEntity.setHiHokenshaNo(主キー名2);

            business = new SaishinsaMoshitate(SaishinsaMoshitateEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申立年月日は_設定した値と同じ申立年月日を返す() {
            business = sut.set申立年月日(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立年月日).build();
            assertThat(business.get申立年月日(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立年月日));
        }

        @Test
        public void 戻り値の申立者区分コードは_設定した値と同じ申立者区分コードを返す() {
            business = sut.set申立者区分コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立者区分コード).build();
            assertThat(business.get申立者区分コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立者区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の申立単位数は_設定した値と同じ申立単位数を返す() {
            business = sut.set申立単位数(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立単位数).build();
            assertThat(business.get申立単位数(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立単位数));
        }

        @Test
        public void 戻り値の申立事由コードは_設定した値と同じ申立事由コードを返す() {
            business = sut.set申立事由コード(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立事由コード).build();
            assertThat(business.get申立事由コード(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_申立事由コード));
        }

        @Test
        public void 戻り値の国保連送付年月は_設定した値と同じ国保連送付年月を返す() {
            business = sut.set国保連送付年月(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連送付年月).build();
            assertThat(business.get国保連送付年月(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連送付年月));
        }

        @Test
        public void 戻り値の国保連再送付有フラグは_設定した値と同じ国保連再送付有フラグを返す() {
            business = sut.set国保連再送付有フラグ(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ).build();
            assertThat(business.get国保連再送付有フラグ(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3062SaishinsaMoshitateEntityGenerator.DEFAULT_備考));
        }

    }
}
