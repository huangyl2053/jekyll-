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
 * {@link JutakuKaishuRiyushoTesuryoKetteiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoKetteiBuilderTest extends DbcTestBase {

    private static DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity JutakuKaishuRiyushoTesuryoKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static JutakuKaishuRiyushoTesuryoKetteiBuilder sut;
        private static JutakuKaishuRiyushoTesuryoKettei business;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = new DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setXXX(主キー名2);

            business = new JutakuKaishuRiyushoTesuryoKettei(JutakuKaishuRiyushoTesuryoKetteiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の介護住宅改修理由書作成事業者番号は_設定した値と同じ介護住宅改修理由書作成事業者番号を返す() {
            business = sut.set介護住宅改修理由書作成事業者番号(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号).build();
            assertThat(business.get介護住宅改修理由書作成事業者番号(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の支給・不支給決定年月日は_設定した値と同じ支給・不支給決定年月日を返す() {
            business = sut.set支給・不支給決定年月日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給・不支給決定年月日).build();
            assertThat(business.get支給・不支給決定年月日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給・不支給決定年月日));
        }

        @Test
        public void 戻り値の支給・不支給区分は_設定した値と同じ支給・不支給区分を返す() {
            business = sut.set支給・不支給区分(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給・不支給区分).build();
            assertThat(business.get支給・不支給区分(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給・不支給区分));
        }

        @Test
        public void 戻り値の償還不支給理由等は_設定した値と同じ償還不支給理由等を返す() {
            business = sut.set償還不支給理由等(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_償還不支給理由等).build();
            assertThat(business.get償還不支給理由等(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_償還不支給理由等));
        }

        @Test
        public void 戻り値の住宅改修理由書作成手数料支払予定日は_設定した値と同じ住宅改修理由書作成手数料支払予定日を返す() {
            business = sut.set住宅改修理由書作成手数料支払予定日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_住宅改修理由書作成手数料支払予定日).build();
            assertThat(business.get住宅改修理由書作成手数料支払予定日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_住宅改修理由書作成手数料支払予定日));
        }

    }
}
