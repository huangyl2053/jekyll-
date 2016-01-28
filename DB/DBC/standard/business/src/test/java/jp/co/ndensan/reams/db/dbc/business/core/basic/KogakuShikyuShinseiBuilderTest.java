/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3056KogakuShikyuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link KogakuShikyuShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuShinseiBuilderTest extends DbcTestBase {

    private static DbT3056KogakuShikyuShinseiEntity KogakuShikyuShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuShikyuShinseiBuilder sut;
        private static KogakuShikyuShinsei business;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = new DbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            business = new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            business = sut.set申請理由(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請理由).build();
            assertThat(business.get申請理由(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の申請者区分は_設定した値と同じ申請者区分を返す() {
            business = sut.set申請者区分(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者区分).build();
            assertThat(business.get申請者区分(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者区分));
        }

        @Test
        public void 戻り値の申請者氏名は_設定した値と同じ申請者氏名を返す() {
            business = sut.set申請者氏名(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名).build();
            assertThat(business.get申請者氏名(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名));
        }

        @Test
        public void 戻り値の申請者氏名カナは_設定した値と同じ申請者氏名カナを返す() {
            business = sut.set申請者氏名カナ(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名カナ).build();
            assertThat(business.get申請者氏名カナ(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者氏名カナ));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            business = sut.set申請者住所(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者住所).build();
            assertThat(business.get申請者住所(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            business = sut.set申請者電話番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者電話番号).build();
            assertThat(business.get申請者電話番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請事業者番号は_設定した値と同じ申請事業者番号を返す() {
            business = sut.set申請事業者番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請事業者番号).build();
            assertThat(business.get申請事業者番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_申請事業者番号));
        }

        @Test
        public void 戻り値の支払方法区分コードは_設定した値と同じ支払方法区分コードを返す() {
            business = sut.set支払方法区分コード(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払方法区分コード).build();
            assertThat(business.get支払方法区分コード(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払方法区分コード));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            business = sut.set支払場所(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払場所).build();
            assertThat(business.get支払場所(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            business = sut.set支払期間開始年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払期間開始年月日).build();
            assertThat(business.get支払期間開始年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            business = sut.set支払期間終了年月日(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払期間終了年月日).build();
            assertThat(business.get支払期間終了年月日(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            business = sut.set閉庁内容(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_閉庁内容).build();
            assertThat(business.get閉庁内容(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払窓口開始時間は_設定した値と同じ支払窓口開始時間を返す() {
            business = sut.set支払窓口開始時間(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払窓口開始時間).build();
            assertThat(business.get支払窓口開始時間(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払窓口開始時間));
        }

        @Test
        public void 戻り値の支払窓口終了時間は_設定した値と同じ支払窓口終了時間を返す() {
            business = sut.set支払窓口終了時間(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払窓口終了時間).build();
            assertThat(business.get支払窓口終了時間(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_支払窓口終了時間));
        }

        @Test
        public void 戻り値の口座IDは_設定した値と同じ口座IDを返す() {
            business = sut.set口座ID(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_口座ID).build();
            assertThat(business.get口座ID(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_口座ID));
        }

        @Test
        public void 戻り値の受領委任契約番号は_設定した値と同じ受領委任契約番号を返す() {
            business = sut.set受領委任契約番号(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受領委任契約番号).build();
            assertThat(business.get受領委任契約番号(), is(DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_受領委任契約番号));
        }

    }
}
