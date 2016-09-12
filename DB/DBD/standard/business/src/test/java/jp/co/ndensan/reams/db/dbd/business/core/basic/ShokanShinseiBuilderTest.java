/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3034ShokanShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link ShokanShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShinseiBuilderTest extends DbcTestBase {

    private static DbT3034ShokanShinseiEntity ShokanShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
//    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_整理番号;
//        主キー名4 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanShinseiBuilder sut;
        private static ShokanShinsei business;

        @Before
        public void setUp() {
            ShokanShinseiEntity = new DbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setHiHokenshaNo(主キー名1);
            ShokanShinseiEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanShinsei(ShokanShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3034ShokanShinseiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_整理番号));
        }

//        @Test
//        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
//            business = sut.set履歴番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_履歴番号).build();
//            assertThat(business.get履歴番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_履歴番号));
//        }
        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3034ShokanShinseiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            business = sut.set申請理由(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請理由).build();
            assertThat(business.get申請理由(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の申請者区分は_設定した値と同じ申請者区分を返す() {
            business = sut.set申請者区分(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者区分).build();
            assertThat(business.get申請者区分(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者区分));
        }

        @Test
        public void 戻り値の申請者氏名は_設定した値と同じ申請者氏名を返す() {
            business = sut.set申請者氏名(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者氏名).build();
            assertThat(business.get申請者氏名(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者氏名));
        }

        @Test
        public void 戻り値の申請者氏名カナは_設定した値と同じ申請者氏名カナを返す() {
            business = sut.set申請者氏名カナ(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者氏名カナ).build();
            assertThat(business.get申請者氏名カナ(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者氏名カナ));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            business = sut.set申請者住所(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者住所).build();
            assertThat(business.get申請者住所(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            business = sut.set申請者電話番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者電話番号).build();
            assertThat(business.get申請者電話番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請事業者コードは_設定した値と同じ申請事業者コードを返す() {
            business = sut.set申請事業者コード(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請事業者コード).build();
            assertThat(business.get申請事業者コード(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_申請事業者コード));
        }

        @Test
        public void 戻り値の支払金額合計は_設定した値と同じ支払金額合計を返す() {
            business = sut.set支払金額合計(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払金額合計).build();
            assertThat(business.get支払金額合計(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払金額合計));
        }

        @Test
        public void 戻り値の保険給付額は_設定した値と同じ保険給付額を返す() {
            business = sut.set保険給付額(DbT3034ShokanShinseiEntityGenerator.DEFAULT_保険給付額).build();
            assertThat(business.get保険給付額(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_保険給付額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3034ShokanShinseiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の支給申請審査区分は_設定した値と同じ支給申請審査区分を返す() {
            business = sut.set支給申請審査区分(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支給申請審査区分).build();
            assertThat(business.get支給申請審査区分(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支給申請審査区分));
        }

        @Test
        public void 戻り値の審査方法区分は_設定した値と同じ審査方法区分を返す() {
            business = sut.set審査方法区分(DbT3034ShokanShinseiEntityGenerator.DEFAULT_審査方法区分).build();
            assertThat(business.get審査方法区分(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_審査方法区分));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3034ShokanShinseiEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の支払方法区分コードは_設定した値と同じ支払方法区分コードを返す() {
            business = sut.set支払方法区分コード(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払方法区分コード).build();
            assertThat(business.get支払方法区分コード(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払方法区分コード));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            business = sut.set支払場所(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払場所).build();
            assertThat(business.get支払場所(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            business = sut.set支払期間開始年月日(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払期間開始年月日).build();
            assertThat(business.get支払期間開始年月日(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            business = sut.set支払期間終了年月日(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払期間終了年月日).build();
            assertThat(business.get支払期間終了年月日(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払期間終了年月日));
        }

//        @Test
//        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
//            business = sut.set閉庁内容(DbT3034ShokanShinseiEntityGenerator.DEFAULT_閉庁内容).build();
//            assertThat(business.get閉庁内容(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_閉庁内容));
//        }
        @Test
        public void 戻り値の支払窓口開始時間は_設定した値と同じ支払窓口開始時間を返す() {
            business = sut.set支払窓口開始時間(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払窓口開始時間).build();
            assertThat(business.get支払窓口開始時間(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払窓口開始時間));
        }

        @Test
        public void 戻り値の支払窓口終了時間は_設定した値と同じ支払窓口終了時間を返す() {
            business = sut.set支払窓口終了時間(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払窓口終了時間).build();
            assertThat(business.get支払窓口終了時間(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_支払窓口終了時間));
        }

        @Test
        public void 戻り値の口座IDは_設定した値と同じ口座IDを返す() {
            business = sut.set口座ID(DbT3034ShokanShinseiEntityGenerator.DEFAULT_口座ID).build();
            assertThat(business.get口座ID(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_口座ID));
        }

        @Test
        public void 戻り値の受領委任契約番号は_設定した値と同じ受領委任契約番号を返す() {
            business = sut.set受領委任契約番号(DbT3034ShokanShinseiEntityGenerator.DEFAULT_受領委任契約番号).build();
            assertThat(business.get受領委任契約番号(), is(DbT3034ShokanShinseiEntityGenerator.DEFAULT_受領委任契約番号));
        }

    }
}
