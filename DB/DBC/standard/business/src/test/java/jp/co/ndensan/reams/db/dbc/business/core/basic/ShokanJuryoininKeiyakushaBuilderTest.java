/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
 * {@link ShokanJuryoininKeiyakushaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininKeiyakushaBuilderTest extends DbcTestBase {

    private static DbT3078ShokanJuryoininKeiyakushaEntity ShokanJuryoininKeiyakushaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static ShoKisaiHokenshaNo 主キー名2;
    private static FlexibleDate 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
        主キー名4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanJuryoininKeiyakushaBuilder sut;
        private static ShokanJuryoininKeiyakusha business;

        @Before
        public void setUp() {
            ShokanJuryoininKeiyakushaEntity = new DbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaEntity.setHihokenshaNo(主キー名1);
            ShokanJuryoininKeiyakushaEntity.setShoKisaiHokenshaNo(主キー名2);

            business = new ShokanJuryoininKeiyakusha(ShokanJuryoininKeiyakushaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の事業者契約番号は_設定した値と同じ事業者契約番号を返す() {
            business = sut.set事業者契約番号(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_事業者契約番号).build();
            assertThat(business.get事業者契約番号(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_事業者契約番号));
        }

        @Test
        public void 戻り値の契約サービス種類は_設定した値と同じ契約サービス種類を返す() {
            business = sut.set契約サービス種類(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約サービス種類).build();
            assertThat(business.get契約サービス種類(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約サービス種類));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の承認結果区分は_設定した値と同じ承認結果区分を返す() {
            business = sut.set承認結果区分(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果区分).build();
            assertThat(business.get承認結果区分(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果区分));
        }

        @Test
        public void 戻り値の受領委任払適用開始年月日は_設定した値と同じ受領委任払適用開始年月日を返す() {
            business = sut.set受領委任払適用開始年月日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受領委任払適用開始年月日).build();
            assertThat(business.get受領委任払適用開始年月日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受領委任払適用開始年月日));
        }

        @Test
        public void 戻り値の受領委任払適用終了年月日は_設定した値と同じ受領委任払適用終了年月日を返す() {
            business = sut.set受領委任払適用終了年月日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受領委任払適用終了年月日).build();
            assertThat(business.get受領委任払適用終了年月日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受領委任払適用終了年月日));
        }

        @Test
        public void 戻り値の契約番号は_設定した値と同じ契約番号を返す() {
            business = sut.set契約番号(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約番号).build();
            assertThat(business.get契約番号(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約番号));
        }

        @Test
        public void 戻り値の不承認理由は_設定した値と同じ不承認理由を返す() {
            business = sut.set不承認理由(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_不承認理由).build();
            assertThat(business.get不承認理由(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_不承認理由));
        }

        @Test
        public void 戻り値の費用額合計は_設定した値と同じ費用額合計を返す() {
            business = sut.set費用額合計(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_費用額合計).build();
            assertThat(business.get費用額合計(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_費用額合計));
        }

        @Test
        public void 戻り値の保険対象費用額は_設定した値と同じ保険対象費用額を返す() {
            business = sut.set保険対象費用額(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_保険対象費用額).build();
            assertThat(business.get保険対象費用額(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_保険対象費用額));
        }

        @Test
        public void 戻り値の利用者自己負担額は_設定した値と同じ利用者自己負担額を返す() {
            business = sut.set利用者自己負担額(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_利用者自己負担額).build();
            assertThat(business.get利用者自己負担額(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_利用者自己負担額));
        }

        @Test
        public void 戻り値の保険給付費額は_設定した値と同じ保険給付費額を返す() {
            business = sut.set保険給付費額(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_保険給付費額).build();
            assertThat(business.get保険給付費額(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_保険給付費額));
        }

        @Test
        public void 戻り値の承認結果通知書作成日は_設定した値と同じ承認結果通知書作成日を返す() {
            business = sut.set承認結果通知書作成日(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果通知書作成日).build();
            assertThat(business.get承認結果通知書作成日(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果通知書作成日));
        }

        @Test
        public void 戻り値の承認結果通知書再発行区分は_設定した値と同じ承認結果通知書再発行区分を返す() {
            business = sut.set承認結果通知書再発行区分(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果通知書再発行区分).build();
            assertThat(business.get承認結果通知書再発行区分(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_承認結果通知書再発行区分));
        }

    }
}
