/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyodoShoriyoJukyushaIdoShokanSofuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoShokanSofuBuilderTest extends DbcTestBase {

    private static DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity KyodoShoriyoJukyushaIdoShokanSofuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static ShoKisaiHokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static int 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoShokanSofuBuilder sut;
        private static KyodoShoriyoJukyushaIdoShokanSofu business;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoShokanSofuEntity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoShokanSofuEntity.setIdoKubunCode(主キー名2);

            business = new KyodoShoriyoJukyushaIdoShokanSofu(KyodoShoriyoJukyushaIdoShokanSofuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            business = sut.set異動年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日).build();
            assertThat(business.get異動年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の異動区分コードは_設定した値と同じ異動区分コードを返す() {
            business = sut.set異動区分コード(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード).build();
            assertThat(business.get異動区分コード(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_異動区分コード));
        }

        @Test
        public void 戻り値の受給者異動事由は_設定した値と同じ受給者異動事由を返す() {
            business = sut.set受給者異動事由(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由).build();
            assertThat(business.get受給者異動事由(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_受給者異動事由));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の保険給付支払一時差止開始年月日は_設定した値と同じ保険給付支払一時差止開始年月日を返す() {
            business = sut.set保険給付支払一時差止開始年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止開始年月日).build();
            assertThat(business.get保険給付支払一時差止開始年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止開始年月日));
        }

        @Test
        public void 戻り値の保険給付支払一時差止終了年月日は_設定した値と同じ保険給付支払一時差止終了年月日を返す() {
            business = sut.set保険給付支払一時差止終了年月日(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止終了年月日).build();
            assertThat(business.get保険給付支払一時差止終了年月日(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止終了年月日));
        }

        @Test
        public void 戻り値の保険給付支払一時差止区分コードは_設定した値と同じ保険給付支払一時差止区分コードを返す() {
            business = sut.set保険給付支払一時差止区分コード(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止区分コード).build();
            assertThat(business.get保険給付支払一時差止区分コード(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止区分コード));
        }

        @Test
        public void 戻り値の保険給付支払一時差止金額は_設定した値と同じ保険給付支払一時差止金額を返す() {
            business = sut.set保険給付支払一時差止金額(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止金額).build();
            assertThat(business.get保険給付支払一時差止金額(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_保険給付支払一時差止金額));
        }

        @Test
        public void 戻り値の訂正連絡票フラグは_設定した値と同じ訂正連絡票フラグを返す() {
            business = sut.set訂正連絡票フラグ(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_訂正連絡票フラグ).build();
            assertThat(business.is訂正連絡票フラグ(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_訂正連絡票フラグ));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_送付年月));
        }

    }
}
