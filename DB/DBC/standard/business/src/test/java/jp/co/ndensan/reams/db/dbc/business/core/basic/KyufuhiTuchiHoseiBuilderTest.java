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
 * {@link KyufuhiTuchiHoseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiTuchiHoseiBuilderTest extends DbcTestBase {

    private static DbT3067KyufuhiTuchiHoseiEntity KyufuhiTuchiHoseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufuhiTuchiHoseiBuilder sut;
        private static KyufuhiTuchiHosei business;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = new DbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);

            business = new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス費用合計額は_設定した値と同じサービス費用合計額を返す() {
            business = sut.setサービス費用合計額(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス費用合計額).build();
            assertThat(business.getサービス費用合計額(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス費用合計額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_利用者負担額));
        }

    }
}
