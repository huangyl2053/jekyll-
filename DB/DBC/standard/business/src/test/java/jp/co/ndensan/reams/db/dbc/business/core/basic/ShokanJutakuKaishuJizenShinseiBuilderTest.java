/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link ShokanJutakuKaishuJizenShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJutakuKaishuJizenShinseiBuilderTest extends DbcTestBase {

    private static DbT3035ShokanJutakuKaishuJizenShinseiEntity ShokanJutakuKaishuJizenShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
//    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号;
//        主キー名4 = DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanJutakuKaishuJizenShinseiBuilder sut;
        private static ShokanJutakuKaishuJizenShinsei business;

        @Before
        public void setUp() {
            ShokanJutakuKaishuJizenShinseiEntity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
            ShokanJutakuKaishuJizenShinseiEntity.setHiHokenshaNo(主キー名1);
            ShokanJutakuKaishuJizenShinseiEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanJutakuKaishuJizenShinsei(ShokanJutakuKaishuJizenShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_整理番号));
        }

//        @Test
//        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
//            business = sut.set履歴番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号).build();
//            assertThat(business.get履歴番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_履歴番号));
//        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請事業者番号号は_設定した値と同じ申請事業者番号を返す() {
            business = sut.set申請事業者番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請事業者番号).build();
            assertThat(business.get申請事業者番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_申請事業者番号));
        }
//
//        @Test
//        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
//            business = sut.set事業者名称(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称).build();
//            assertThat(business.get事業者名称(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称));
//        }
//
//        @Test
//        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
//            business = sut.set事業者名称カナ(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称カナ).build();
//            assertThat(business.get事業者名称カナ(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者名称カナ));
//        }
//
//        @Test
//        public void 戻り値の事業者郵便番号は_設定した値と同じ事業者郵便番号を返す() {
//            business = sut.set事業者郵便番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者郵便番号).build();
//            assertThat(business.get事業者郵便番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者郵便番号));
//        }
//
//        @Test
//        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
//            business = sut.set事業者住所(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者住所).build();
//            assertThat(business.get事業者住所(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者住所));
//        }
//
//        @Test
//        public void 戻り値の事業者電話番号は_設定した値と同じ事業者電話番号を返す() {
//            business = sut.set事業者電話番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者電話番号).build();
//            assertThat(business.get事業者電話番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者電話番号));
//        }
//
//        @Test
//        public void 戻り値の事業者ＦＡＸ番号は_設定した値と同じ事業者ＦＡＸ番号を返す() {
//            business = sut.set事業者ＦＡＸ番号(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者ＦＡＸ番号).build();
//            assertThat(business.get事業者ＦＡＸ番号(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_事業者ＦＡＸ番号));
//        }

        @Test
        public void 戻り値の理由書作成者は_設定した値と同じ理由書作成者を返す() {
            business = sut.set理由書作成者(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者).build();
            assertThat(business.get理由書作成者(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者));
        }

        @Test
        public void 戻り値の理由書作成者カナは_設定した値と同じ理由書作成者カナを返す() {
            business = sut.set理由書作成者カナ(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者カナ).build();
            assertThat(business.get理由書作成者カナ(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_理由書作成者カナ));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の判定決定年月日は_設定した値と同じ判定決定年月日を返す() {
            business = sut.set判定決定年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_判定決定年月日).build();
            assertThat(business.get判定決定年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_判定決定年月日));
        }

        @Test
        public void 戻り値の判定区分は_設定した値と同じ判定区分を返す() {
            business = sut.set判定区分(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_判定区分).build();
            assertThat(business.get判定区分(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_判定区分));
        }

        @Test
        public void 戻り値のget不承認の理由は_設定した値と同じget不承認の理由を返す() {
            business = sut.set不承認の理由(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_不承認理由).build();
            assertThat(business.get不承認の理由(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_不承認理由));
        }

        @Test
        public void 戻り値の給付額等_費用額合計は_設定した値と同じ給付額等_費用額合計を返す() {
            business = sut.set給付額等_費用額合計(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_費用額合計).build();
            assertThat(business.get給付額等_費用額合計(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_費用額合計));
        }

        @Test
        public void 戻り値の給付額等_保険対象費用額は_設定した値と同じ給付額等_保険対象費用額を返す() {
            business = sut.set給付額等_保険対象費用額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険対象費用額).build();
            assertThat(business.get給付額等_保険対象費用額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険対象費用額));
        }

        @Test
        public void 戻り値の給付額等_利用者自己負担額は_設定した値と同じ給付額等_利用者自己負担額を返す() {
            business = sut.set給付額等_利用者自己負担額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_利用者自己負担額).build();
            assertThat(business.get給付額等_利用者自己負担額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_利用者自己負担額));
        }

        @Test
        public void 戻り値の給付額等_保険給付費額は_設定した値と同じ給付額等_保険給付費額を返す() {
            business = sut.set給付額等_保険給付費額(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険給付費額).build();
            assertThat(business.get給付額等_保険給付費額(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_給付額等_保険給付費額));
        }

        @Test
        public void 戻り値の施工完了予定年月日は_設定した値と同じ施工完了予定年月日を返す() {
            business = sut.set施工完了予定年月日(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_施工完了予定年月日).build();
            assertThat(business.get施工完了予定年月日(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_施工完了予定年月日));
        }

        @Test
        public void 戻り値の住宅改修申請取消事由コードは_設定した値と同じ住宅改修申請取消事由コードを返す() {
            business = sut.set住宅改修申請取消事由コード(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_住宅改修申請取消事由コード).build();
            assertThat(business.get住宅改修申請取消事由コード(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_住宅改修申請取消事由コード));
        }

//        @Test
//        public void 戻り値の備考は_設定した値と同じ備考を返す() {
//            business = sut.set備考(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_備考).build();
//            assertThat(business.get備考(), is(DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator.DEFAULT_備考));
//        }

    }
}
