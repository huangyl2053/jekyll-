/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3059KagoMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * {@link KagoMoshitateBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoMoshitateBuilderTest extends DbcTestBase {

    private static DbT3059KagoMoshitateEntity KagoMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_事業所番号;
        主キー名2 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_サービス提供年月;
        主キー名4 = DbT3059KagoMoshitateEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KagoMoshitateBuilder sut;
        private static KagoMoshitate business;

        @Before
        public void setUp() {
            KagoMoshitateEntity = new DbT3059KagoMoshitateEntity();
            KagoMoshitateEntity.setJigyoshoNo(主キー名1);
            KagoMoshitateEntity.setHiHokenshaNo(主キー名2);

            business = new KagoMoshitate(KagoMoshitateEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3059KagoMoshitateEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3059KagoMoshitateEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3059KagoMoshitateEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3059KagoMoshitateEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申立年月日は_設定した値と同じ申立年月日を返す() {
            business = sut.set申立年月日(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立年月日).build();
            assertThat(business.get申立年月日(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立年月日));
        }

        @Test
        public void 戻り値の申立者区分コードは_設定した値と同じ申立者区分コードを返す() {
            business = sut.set申立者区分コード(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立者区分コード).build();
            assertThat(business.get申立者区分コード(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立者区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3059KagoMoshitateEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の申立事由コードは_設定した値と同じ申立事由コードを返す() {
            business = sut.set申立事由コード(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立事由コード).build();
            assertThat(business.get申立事由コード(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立事由コード));
        }

        @Test
        public void 戻り値の国保連送付年月は_設定した値と同じ国保連送付年月を返す() {
            business = sut.set国保連送付年月(DbT3059KagoMoshitateEntityGenerator.DEFAULT_国保連送付年月).build();
            assertThat(business.get国保連送付年月(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_国保連送付年月));
        }

        @Test
        public void 戻り値の国保連再送付有フラグは_設定した値と同じ国保連再送付有フラグを返す() {
            business = sut.set国保連再送付有フラグ(DbT3059KagoMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ).build();
            assertThat(business.is国保連再送付有フラグ(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_国保連再送付有フラグ));
        }

        @Test
        public void 戻り値の同月審査有フラグは_設定した値と同じ同月審査有フラグを返す() {
            business = sut.set同月審査有フラグ(DbT3059KagoMoshitateEntityGenerator.DEFAULT_同月審査有フラグ).build();
            assertThat(business.is同月審査有フラグ(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_同月審査有フラグ));
        }

        @Test
        public void 戻り値の申立書区分コードは_設定した値と同じ申立書区分コードを返す() {
            business = sut.set申立書区分コード(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立書区分コード).build();
            assertThat(business.get申立書区分コード(), is(DbT3059KagoMoshitateEntityGenerator.DEFAULT_申立書区分コード));
        }

    }
}
