/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JutakuKaishuRiyushoTesuryoShukeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoShukeiBuilderTest extends DbcTestBase {

    private static DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity JutakuKaishuRiyushoTesuryoShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
        主キー名3 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukeiBuilder sut;
        private static JutakuKaishuRiyushoTesuryoShukei business;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);

            business = new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の集計開始年月は_設定した値と同じ集計開始年月を返す() {
            business = sut.set集計開始年月(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月).build();
            assertThat(business.get集計開始年月(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号)).build();
            assertThat(business.get履歴番号(), is(new Decimal(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号)));
        }

        @Test
        public void 戻り値の集計終了年月は_設定した値と同じ集計終了年月を返す() {
            business = sut.set集計終了年月(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計終了年月).build();
            assertThat(business.get集計終了年月(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計終了年月));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成事業者番号は_設定した値と同じ介護住宅改修理由書作成事業者番号を返す() {
            business = sut.set介護住宅改修理由書作成事業者番号(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号).build();
            assertThat(business.get介護住宅改修理由書作成事業者番号(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成件数は_設定した値と同じ介護住宅改修理由書作成件数を返す() {
            business = sut.set介護住宅改修理由書作成件数(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成件数).build();
            assertThat(business.get介護住宅改修理由書作成件数(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成件数));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成単価は_設定した値と同じ介護住宅改修理由書作成単価を返す() {
            business = sut.set介護住宅改修理由書作成単価(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成単価).build();
            assertThat(business.get介護住宅改修理由書作成単価(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成単価));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成請求金額は_設定した値と同じ介護住宅改修理由書作成請求金額を返す() {
            business = sut.set介護住宅改修理由書作成請求金額(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成請求金額).build();
            assertThat(business.get介護住宅改修理由書作成請求金額(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成請求金額));
        }

//        @Test
//        public void 戻り値の介護住宅改修理由書作成申請年月日は_設定した値と同じ介護住宅改修理由書作成申請年月日を返す() {
//            business = sut.set介護住宅改修理由書作成申請年月日(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日).build();
//            assertThat(business.get介護住宅改修理由書作成申請年月日(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日));
//        }
//
//        @Test
//        public void 戻り値の介護住宅改修理由書作成受付年月日は_設定した値と同じ介護住宅改修理由書作成受付年月日を返す() {
//            business = sut.set介護住宅改修理由書作成受付年月日(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日).build();
//            assertThat(business.get介護住宅改修理由書作成受付年月日(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日));
//        }

        @Test
        public void 戻り値の介護支払方法区分は_設定した値と同じ介護支払方法区分を返す() {
            business = sut.set介護支払方法区分(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護支払方法区分).build();
            assertThat(business.get介護支払方法区分(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_介護支払方法区分));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_識別コード));
        }

    }
}
