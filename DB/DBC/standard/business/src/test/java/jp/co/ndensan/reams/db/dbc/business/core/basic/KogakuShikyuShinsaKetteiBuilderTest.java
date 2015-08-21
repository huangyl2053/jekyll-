/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3112KogakuShikyuShinsaKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuShikyuShinsaKetteiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinsaKetteiBuilderTest extends DbcTestBase {

    private static DbT3112KogakuShikyuShinsaKetteiEntity KogakuShikyuShinsaKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static HokenshaNo 主キー名2;
    private static HihokenshaNo 主キー名3;
    private static FlexibleYearMonth 主キー名4;
    private static RString 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月;
        主キー名2 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名3 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名4 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名5 = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuShikyuShinsaKetteiBuilder sut;
        private static KogakuShikyuShinsaKettei business;

        @Before
        public void setUp() {
            KogakuShikyuShinsaKetteiEntity = new DbT3112KogakuShikyuShinsaKetteiEntity();
            KogakuShikyuShinsaKetteiEntity.setKetteishaUketoriYM(主キー名1);
            KogakuShikyuShinsaKetteiEntity.setShoKisaiHokenshaNo(主キー名2);

            business = new KogakuShikyuShinsaKettei(KogakuShikyuShinsaKetteiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の決定者受取年月は_設定した値と同じ決定者受取年月を返す() {
            business = sut.set決定者受取年月(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月).build();
            assertThat(business.get決定者受取年月(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定者受取年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の決定年月は_設定した値と同じ決定年月を返す() {
            business = sut.set決定年月(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定年月).build();
            assertThat(business.get決定年月(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_決定年月));
        }

        @Test
        public void 戻り値の事業高額支給額は_設定した値と同じ事業高額支給額を返す() {
            business = sut.set事業高額支給額(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_事業高額支給額).build();
            assertThat(business.get事業高額支給額(), is(DbT3112KogakuShikyuShinsaKetteiEntityGenerator.DEFAULT_事業高額支給額));
        }

    }
}
