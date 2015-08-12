/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link UwanoseShokanShuruiShikyuGendoGakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class UwanoseShokanShuruiShikyuGendoGakuBuilderTest extends DbcTestBase {

    private static DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity UwanoseShokanShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static UwanoseShokanShuruiShikyuGendoGakuBuilder sut;
        private static UwanoseShokanShuruiShikyuGendoGaku business;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = new DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            business = new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の適用開始年月は_設定した値と同じ適用開始年月を返す() {
            business = sut.set適用開始年月(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月).build();
            assertThat(business.get適用開始年月(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用終了年月は_設定した値と同じ適用終了年月を返す() {
            business = sut.set適用終了年月(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月).build();
            assertThat(business.get適用終了年月(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月));
        }

        @Test
        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
            business = sut.set支給限度単位数(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数).build();
            assertThat(business.get支給限度単位数(), is(DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_支給限度単位数));
        }

    }
}
