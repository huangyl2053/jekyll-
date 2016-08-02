/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private static JigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
        主キー名2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
        主キー名3 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoKetteiBuilder sut;
        private static JutakuKaishuRiyushoTesuryoKettei business;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoKetteiEntity = new DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKetteiEntity.setRiyushoSakuseiJigyoshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoKetteiEntity.setKetteiYMD(主キー名2);

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
            business = sut.set履歴番号(new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号)).build();
            assertThat(business.get履歴番号(), is(new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号)));
        }

        @Test
        public void 戻り値の支給_不支給決定年月日は_設定した値と同じ支給_不支給決定年月日を返す() {
            business = sut.set支給_不支給決定年月日(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給決定年月日).build();
            assertThat(business.get支給_不支給決定年月日(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給決定年月日));
        }

        @Test
        public void 戻り値の支給_不支給区分は_設定した値と同じ支給_不支給区分を返す() {
            business = sut.set支給_不支給区分(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給区分).build();
            assertThat(business.get支給_不支給区分(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_支給_不支給区分));
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
