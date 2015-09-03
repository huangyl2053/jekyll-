/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
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
 * {@link DaisanshaKoiKyushoMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoMeisaiBuilderTest extends DbcTestBase {

    private static DbT3083DaisanshaKoiKyushoMeisaiEntity DaisanshaKoiKyushoMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static FlexibleYearMonth 主キー名4;
    private static JigyoshaNo 主キー名5;
    private static ServiceShuruiCode 主キー名6;
    private static Decimal 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号;
        主キー名4 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名5 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
        主キー名6 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        主キー名7 = DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static DaisanshaKoiKyushoMeisaiBuilder sut;
        private static DaisanshaKoiKyushoMeisai business;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoMeisaiEntity = new DbT3083DaisanshaKoiKyushoMeisaiEntity();
            DaisanshaKoiKyushoMeisaiEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoMeisaiEntity.setTodokedeKanriNo(主キー名2);

            business = new DaisanshaKoiKyushoMeisai(DaisanshaKoiKyushoMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            business = sut.set第三者行為求償請求番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号).build();
            assertThat(business.get第三者行為求償請求番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            business = sut.setサービス提供事業者番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号).build();
            assertThat(business.getサービス提供事業者番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の給付額は_設定した値と同じ給付額を返す() {
            business = sut.set給付額(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_給付額).build();
            assertThat(business.get給付額(), is(DbT3083DaisanshaKoiKyushoMeisaiEntityGenerator.DEFAULT_給付額));
        }

    }
}
