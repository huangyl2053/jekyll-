/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanMeisaiJushochiTokureiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanMeisaiJushochiTokureiBuilderTest extends DbcTestBase {

    private static DbT3107ShokanMeisaiJushochiTokureiEntity ShokanMeisaiJushochiTokureiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShokanMeisaiJushochiTokureiBuilder sut;
        private static ShokanMeisaiJushochiTokurei business;

        @Before
        public void setUp() {
            ShokanMeisaiJushochiTokureiEntity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
            ShokanMeisaiJushochiTokureiEntity.setXXX(主キー名1);
            ShokanMeisaiJushochiTokureiEntity.setXXX(主キー名2);

            business = new ShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数・回数は_設定した値と同じ日数・回数を返す() {
            business = sut.set日数・回数(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_日数・回数).build();
            assertThat(business.get日数・回数(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_日数・回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の施設所在保険者番号は_設定した値と同じ施設所在保険者番号を返す() {
            business = sut.set施設所在保険者番号(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_施設所在保険者番号).build();
            assertThat(business.get施設所在保険者番号(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_施設所在保険者番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator.DEFAULT_摘要));
        }

    }
}
