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
 * {@link KagoKetteiShukeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoKetteiShukeiBuilderTest extends DbcTestBase {

    private static DbT3060KagoKetteiShukeiEntity KagoKetteiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KagoKetteiShukeiBuilder sut;
        private static KagoKetteiShukei business;

        @Before
        public void setUp() {
            KagoKetteiShukeiEntity = new DbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukeiEntity.setXXX(主キー名1);
            KagoKetteiShukeiEntity.setXXX(主キー名2);

            business = new KagoKetteiShukei(KagoKetteiShukeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の取扱年月は_設定した値と同じ取扱年月を返す() {
            business = sut.set取扱年月(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月).build();
            assertThat(business.get取扱年月(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月));
        }

        @Test
        public void 戻り値の保険者区分は_設定した値と同じ保険者区分を返す() {
            business = sut.set保険者区分(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分).build();
            assertThat(business.get保険者区分(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の介護給付費件数は_設定した値と同じ介護給付費件数を返す() {
            business = sut.set介護給付費件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費件数).build();
            assertThat(business.get介護給付費件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費件数));
        }

        @Test
        public void 戻り値の介護給付費単位数は_設定した値と同じ介護給付費単位数を返す() {
            business = sut.set介護給付費単位数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費単位数).build();
            assertThat(business.get介護給付費単位数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費単位数));
        }

        @Test
        public void 戻り値の介護給付費保険者負担額は_設定した値と同じ介護給付費保険者負担額を返す() {
            business = sut.set介護給付費保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費保険者負担額).build();
            assertThat(business.get介護給付費保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_介護給付費保険者負担額));
        }

        @Test
        public void 戻り値の高額介護サービス費件数は_設定した値と同じ高額介護サービス費件数を返す() {
            business = sut.set高額介護サービス費件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費件数).build();
            assertThat(business.get高額介護サービス費件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費件数));
        }

        @Test
        public void 戻り値の高額介護サービス費単位数は_設定した値と同じ高額介護サービス費単位数を返す() {
            business = sut.set高額介護サービス費単位数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費単位数).build();
            assertThat(business.get高額介護サービス費単位数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費単位数));
        }

        @Test
        public void 戻り値の高額介護サービス費保険者負担額は_設定した値と同じ高額介護サービス費保険者負担額を返す() {
            business = sut.set高額介護サービス費保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費保険者負担額).build();
            assertThat(business.get高額介護サービス費保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_高額介護サービス費保険者負担額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等件数は_設定した値と同じ特定入所者介護サービス費等件数を返す() {
            business = sut.set特定入所者介護サービス費等件数(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等件数).build();
            assertThat(business.get特定入所者介護サービス費等件数(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等件数));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等費用額は_設定した値と同じ特定入所者介護サービス費等費用額を返す() {
            business = sut.set特定入所者介護サービス費等費用額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等費用額).build();
            assertThat(business.get特定入所者介護サービス費等費用額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等費用額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等保険者負担額は_設定した値と同じ特定入所者介護サービス費等保険者負担額を返す() {
            business = sut.set特定入所者介護サービス費等保険者負担額(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等保険者負担額).build();
            assertThat(business.get特定入所者介護サービス費等保険者負担額(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_特定入所者介護サービス費等保険者負担額));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            business = sut.set公費負担者番号(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号).build();
            assertThat(business.get公費負担者番号(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の作成年月日は_設定した値と同じ作成年月日を返す() {
            business = sut.set作成年月日(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_作成年月日).build();
            assertThat(business.get作成年月日(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_作成年月日));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
