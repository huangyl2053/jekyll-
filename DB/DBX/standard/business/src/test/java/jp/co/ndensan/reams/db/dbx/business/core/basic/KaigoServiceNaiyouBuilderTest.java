/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceNaiyouBuilder}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouBuilderTest extends DbxTestBase {

    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyouEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoServiceShuruiCode 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoServiceNaiyouBuilder sut;
        private static KaigoServiceNaiyou business;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = new DbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);

            business = new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の提供開始年月は_設定した値と同じ提供開始年月を返す() {
            business = sut.set提供開始年月(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供開始年月).build();
            assertThat(business.get提供開始年月(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の提供終了年月は_設定した値と同じ提供終了年月を返す() {
            business = sut.set提供終了年月(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供終了年月).build();
            assertThat(business.get提供終了年月(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_提供終了年月));
        }

        @Test
        public void 戻り値のサービス名称は_設定した値と同じサービス名称を返す() {
            business = sut.setサービス名称(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス名称).build();
            assertThat(business.getサービス名称(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス名称));
        }

        @Test
        public void 戻り値のサービス略称は_設定した値と同じサービス略称を返す() {
            business = sut.setサービス略称(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス略称).build();
            assertThat(business.getサービス略称(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス略称));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の単位数識別は_設定した値と同じ単位数識別を返す() {
            business = sut.set単位数識別(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数識別.value()).build();
            assertThat(business.get単位数識別(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数識別.value()));
        }

        @Test
        public void 戻り値の単位数算定単位は_設定した値と同じ単位数算定単位を返す() {
            business = sut.set単位数算定単位(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数算定単位.value()).build();
            assertThat(business.get単位数算定単位(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_単位数算定単位.value()));
        }

        @Test
        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
            business = sut.set異動事由(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_異動事由.value()).build();
            assertThat(business.get異動事由(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_異動事由.value()));
        }

    }
}
