/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link KogakuKyufuTaishoshaGokeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuKyufuTaishoshaGokeiBuilderTest extends DbcTestBase {

    private static DbT3055KogakuKyufuTaishoshaGokeiEntity KogakuKyufuTaishoshaGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuKyufuTaishoshaGokeiBuilder sut;
        private static KogakuKyufuTaishoshaGokei business;

        @Before
        public void setUp() {
            KogakuKyufuTaishoshaGokeiEntity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokeiEntity.setHihokenshaNo(主キー名1);
            KogakuKyufuTaishoshaGokeiEntity.setServiceTeikyoYM(主キー名2);

            business = new KogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス費用合計額合計は_設定した値と同じサービス費用合計額合計を返す() {
            business = sut.setサービス費用合計額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス費用合計額合計).build();
            assertThat(business.getサービス費用合計額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス費用合計額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            business = sut.set利用者負担額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_利用者負担額合計).build();
            assertThat(business.get利用者負担額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の算定基準額は_設定した値と同じ算定基準額を返す() {
            business = sut.set算定基準額(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_算定基準額).build();
            assertThat(business.get算定基準額(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_算定基準額));
        }

        @Test
        public void 戻り値の支払済金額合計は_設定した値と同じ支払済金額合計を返す() {
            business = sut.set支払済金額合計(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_支払済金額合計).build();
            assertThat(business.get支払済金額合計(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_支払済金額合計));
        }

        @Test
        public void 戻り値の高額支給額は_設定した値と同じ高額支給額を返す() {
            business = sut.set高額支給額(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額支給額).build();
            assertThat(business.get高額支給額(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額支給額));
        }

        @Test
        public void 戻り値の対象者受取年月は_設定した値と同じ対象者受取年月を返す() {
            business = sut.set対象者受取年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者受取年月).build();
            assertThat(business.get対象者受取年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者受取年月));
        }

        @Test
        public void 戻り値の対象者判定審査年月は_設定した値と同じ対象者判定審査年月を返す() {
            business = sut.set対象者判定審査年月(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者判定審査年月).build();
            assertThat(business.get対象者判定審査年月(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_対象者判定審査年月));
        }

        @Test
        public void 戻り値の世帯集約番号は_設定した値と同じ世帯集約番号を返す() {
            business = sut.set世帯集約番号(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_世帯集約番号).build();
            assertThat(business.get世帯集約番号(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_世帯集約番号));
        }

        @Test
        public void 戻り値の境界層対象者フラグは_設定した値と同じ境界層対象者フラグを返す() {
            business = sut.set境界層対象者フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_境界層対象者フラグ).build();
            assertThat(business.is境界層対象者フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_境界層対象者フラグ));
        }

        @Test
        public void 戻り値の社会福祉法人軽減対象フラグは_設定した値と同じ社会福祉法人軽減対象フラグを返す() {
            business = sut.set社会福祉法人軽減対象フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_社会福祉法人軽減対象フラグ).build();
            assertThat(business.is社会福祉法人軽減対象フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_社会福祉法人軽減対象フラグ));
        }

        @Test
        public void 戻り値の高額対象外フラグは_設定した値と同じ高額対象外フラグを返す() {
            business = sut.set高額対象外フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額対象外フラグ).build();
            assertThat(business.is高額対象外フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_高額対象外フラグ));
        }

        @Test
        public void 戻り値の自動償還対象フラグは_設定した値と同じ自動償還対象フラグを返す() {
            business = sut.set自動償還対象フラグ(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_自動償還対象フラグ).build();
            assertThat(business.is自動償還対象フラグ(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_自動償還対象フラグ));
        }

    }
}
