/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3057KogakuShikyuHanteiKekkaEntityGenerator;
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
 * {@link KogakuShikyuHanteiKekkaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuShikyuHanteiKekkaBuilderTest extends DbcTestBase {

    private static DbT3057KogakuShikyuHanteiKekkaEntity KogakuShikyuHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuShikyuHanteiKekkaBuilder sut;
        private static KogakuShikyuHanteiKekka business;

        @Before
        public void setUp() {
            KogakuShikyuHanteiKekkaEntity = new DbT3057KogakuShikyuHanteiKekkaEntity();
            KogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            business = new KogakuShikyuHanteiKekka(KogakuShikyuHanteiKekkaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の本人支払額は_設定した値と同じ本人支払額を返す() {
            business = sut.set本人支払額(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_本人支払額).build();
            assertThat(business.get本人支払額(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_本人支払額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            business = sut.set支給金額(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給金額).build();
            assertThat(business.get支給金額(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の不支給理由は_設定した値と同じ不支給理由を返す() {
            business = sut.set不支給理由(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_不支給理由).build();
            assertThat(business.get不支給理由(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_不支給理由));
        }

        @Test
        public void 戻り値の審査方法区分は_設定した値と同じ審査方法区分を返す() {
            business = sut.set審査方法区分(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査方法区分).build();
            assertThat(business.get審査方法区分(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査方法区分));
        }

        @Test
        public void 戻り値の判定結果送付年月は_設定した値と同じ判定結果送付年月を返す() {
            business = sut.set判定結果送付年月(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付年月).build();
            assertThat(business.get判定結果送付年月(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付年月));
        }

        @Test
        public void 戻り値の再送付フラグは_設定した値と同じ再送付フラグを返す() {
            business = sut.set再送付フラグ(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_再送付フラグ).build();
            assertThat(business.is再送付フラグ(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_再送付フラグ));
        }

        @Test
        public void 戻り値の判定結果送付不要フラグは_設定した値と同じ判定結果送付不要フラグを返す() {
            business = sut.set判定結果送付不要フラグ(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付不要フラグ).build();
            assertThat(business.is判定結果送付不要フラグ(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付不要フラグ));
        }

        @Test
        public void 戻り値の審査結果反映区分は_設定した値と同じ審査結果反映区分を返す() {
            business = sut.set審査結果反映区分(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査結果反映区分).build();
            assertThat(business.get審査結果反映区分(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査結果反映区分));
        }

        @Test
        public void 戻り値の決定通知書作成年月日は_設定した値と同じ決定通知書作成年月日を返す() {
            business = sut.set決定通知書作成年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定通知書作成年月日).build();
            assertThat(business.get決定通知書作成年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定通知書作成年月日));
        }

        @Test
        public void 戻り値の振込明細書作成年月日は_設定した値と同じ振込明細書作成年月日を返す() {
            business = sut.set振込明細書作成年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_振込明細書作成年月日).build();
            assertThat(business.get振込明細書作成年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_振込明細書作成年月日));
        }

    }
}
