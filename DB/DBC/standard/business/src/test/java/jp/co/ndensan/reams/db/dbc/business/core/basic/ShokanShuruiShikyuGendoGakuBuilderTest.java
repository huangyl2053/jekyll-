/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator;
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
 * {@link ShokanShuruiShikyuGendoGakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShuruiShikyuGendoGakuBuilderTest extends DbcTestBase {

    private static DbT7112ShokanShuruiShikyuGendoGakuEntity ShokanShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGakuBuilder sut;
        private static ShokanShuruiShikyuGendoGaku business;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = new DbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            business = new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            business = sut.set支給限度単位数(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数).build();
            assertThat(business.get支給限度単位数(), is(DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }

    }
}
