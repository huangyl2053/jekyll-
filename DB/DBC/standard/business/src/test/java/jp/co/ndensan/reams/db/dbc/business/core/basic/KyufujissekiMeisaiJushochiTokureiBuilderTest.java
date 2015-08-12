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
 * {@link KyufujissekiMeisaiJushochiTokureiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiMeisaiJushochiTokureiBuilderTest extends DbcTestBase {

    private static DbT3106KyufujissekiMeisaiJushochiTokureiEntity KyufujissekiMeisaiJushochiTokureiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiMeisaiJushochiTokureiBuilder sut;
        private static KyufujissekiMeisaiJushochiTokurei business;

        @Before
        public void setUp() {
            KyufujissekiMeisaiJushochiTokureiEntity = new DbT3106KyufujissekiMeisaiJushochiTokureiEntity();
            KyufujissekiMeisaiJushochiTokureiEntity.setXXX(主キー名1);
            KyufujissekiMeisaiJushochiTokureiEntity.setXXX(主キー名2);

            business = new KyufujissekiMeisaiJushochiTokurei(KyufujissekiMeisaiJushochiTokureiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数・回数は_設定した値と同じ日数・回数を返す() {
            business = sut.set日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_日数・回数).build();
            assertThat(business.get日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_日数・回数));
        }

        @Test
        public void 戻り値の公費１対象日数・回数は_設定した値と同じ公費１対象日数・回数を返す() {
            business = sut.set公費１対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費１対象日数・回数).build();
            assertThat(business.get公費１対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費１対象日数・回数));
        }

        @Test
        public void 戻り値の公費２対象日数・回数は_設定した値と同じ公費２対象日数・回数を返す() {
            business = sut.set公費２対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費２対象日数・回数).build();
            assertThat(business.get公費２対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費２対象日数・回数));
        }

        @Test
        public void 戻り値の公費３対象日数・回数は_設定した値と同じ公費３対象日数・回数を返す() {
            business = sut.set公費３対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費３対象日数・回数).build();
            assertThat(business.get公費３対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費３対象日数・回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の公費１対象サービス単位数は_設定した値と同じ公費１対象サービス単位数を返す() {
            business = sut.set公費１対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費１対象サービス単位数).build();
            assertThat(business.get公費１対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費１対象サービス単位数));
        }

        @Test
        public void 戻り値の公費２対象サービス単位数は_設定した値と同じ公費２対象サービス単位数を返す() {
            business = sut.set公費２対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費２対象サービス単位数).build();
            assertThat(business.get公費２対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費２対象サービス単位数));
        }

        @Test
        public void 戻り値の公費３対象サービス単位数は_設定した値と同じ公費３対象サービス単位数を返す() {
            business = sut.set公費３対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費３対象サービス単位数).build();
            assertThat(business.get公費３対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_公費３対象サービス単位数));
        }

        @Test
        public void 戻り値の施設所在保険者番号は_設定した値と同じ施設所在保険者番号を返す() {
            business = sut.set施設所在保険者番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_施設所在保険者番号).build();
            assertThat(business.get施設所在保険者番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_施設所在保険者番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後・単位数は_設定した値と同じ後・単位数を返す() {
            business = sut.set後・単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・単位数).build();
            assertThat(business.get後・単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・単位数));
        }

        @Test
        public void 戻り値の後・日数・回数は_設定した値と同じ後・日数・回数を返す() {
            business = sut.set後・日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・日数・回数).build();
            assertThat(business.get後・日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・日数・回数));
        }

        @Test
        public void 戻り値の後・公費１対象日数・回数は_設定した値と同じ後・公費１対象日数・回数を返す() {
            business = sut.set後・公費１対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費１対象日数・回数).build();
            assertThat(business.get後・公費１対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費１対象日数・回数));
        }

        @Test
        public void 戻り値の後・公費２対象日数・回数は_設定した値と同じ後・公費２対象日数・回数を返す() {
            business = sut.set後・公費２対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費２対象日数・回数).build();
            assertThat(business.get後・公費２対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費２対象日数・回数));
        }

        @Test
        public void 戻り値の後・公費３対象日数・回数は_設定した値と同じ後・公費３対象日数・回数を返す() {
            business = sut.set後・公費３対象日数・回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費３対象日数・回数).build();
            assertThat(business.get後・公費３対象日数・回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費３対象日数・回数));
        }

        @Test
        public void 戻り値の後・サービス単位数は_設定した値と同じ後・サービス単位数を返す() {
            business = sut.set後・サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・サービス単位数).build();
            assertThat(business.get後・サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・サービス単位数));
        }

        @Test
        public void 戻り値の後・公費１対象サービス単位数は_設定した値と同じ後・公費１対象サービス単位数を返す() {
            business = sut.set後・公費１対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費１対象サービス単位数).build();
            assertThat(business.get後・公費１対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費１対象サービス単位数));
        }

        @Test
        public void 戻り値の後・公費２対象サービス単位数は_設定した値と同じ後・公費２対象サービス単位数を返す() {
            business = sut.set後・公費２対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費２対象サービス単位数).build();
            assertThat(business.get後・公費２対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費２対象サービス単位数));
        }

        @Test
        public void 戻り値の後・公費３対象サービス単位数は_設定した値と同じ後・公費３対象サービス単位数を返す() {
            business = sut.set後・公費３対象サービス単位数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費３対象サービス単位数).build();
            assertThat(business.get後・公費３対象サービス単位数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_後・公費３対象サービス単位数));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
