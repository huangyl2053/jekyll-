/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekkaBuilder;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanHanteiKekkaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanHanteiKekkaBuilderTest extends DbdTestBase {

    private static DbT3036ShokanHanteiKekkaEntity ShokanHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
    }

    public static class getterSetterTest extends DbdTestBase {

        private static ShokanHanteiKekkaBuilder sut;
        private static ShokanHanteiKekka business;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = new DbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanHanteiKekka(ShokanHanteiKekkaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の支給_不支給決定区分は_設定した値と同じ支給_不支給決定区分を返す() {
            business = sut.set支給_不支給決定区分(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支給_不支給決定区分).build();
            assertThat(business.get支給_不支給決定区分(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支給_不支給決定区分));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            business = sut.set支払金額(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額).build();
            assertThat(business.get支払金額(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の支払金額内訳_利用者分は_設定した値と同じ支払金額内訳_利用者分を返す() {
            business = sut.set支払金額内訳_利用者分(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額内訳_利用者分).build();
            assertThat(business.get支払金額内訳_利用者分(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_支払金額内訳_利用者分));
        }

        @Test
        public void 戻り値の決定一覧取込年月は_設定した値と同じ決定一覧取込年月を返す() {
            business = sut.set決定一覧取込年月(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定一覧取込年月).build();
            assertThat(business.get決定一覧取込年月(), is(DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_決定一覧取込年月));
        }

    }
}
