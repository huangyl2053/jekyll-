/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
 * {@link KyodoShoriyoJukyushaIdoKihonSofuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoKihonSofuBuilderTest extends DbcTestBase {

    private static DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity KyodoShoriyoJukyushaIdoKihonSofuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofuBuilder sut;
        private static KyodoShoriyoJukyushaIdoKihonSofu business;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);

            business = new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            business = sut.set異動年月日(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動年月日).build();
            assertThat(business.get異動年月日(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の異動区分コードは_設定した値と同じ異動区分コードを返す() {
            business = sut.set異動区分コード(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動区分コード).build();
            assertThat(business.get異動区分コード(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動区分コード));
        }

        @Test
        public void 戻り値の受給者異動事由は_設定した値と同じ受給者異動事由を返す() {
            business = sut.set受給者異動事由(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_受給者異動事由).build();
            assertThat(business.get受給者異動事由(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_受給者異動事由));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の被保険者氏名は_設定した値と同じ被保険者氏名を返す() {
            business = sut.set被保険者氏名(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者氏名).build();
            assertThat(business.get被保険者氏名(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者氏名));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所カナは_設定した値と同じ住所カナを返す() {
            business = sut.set住所カナ(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_住所カナ).build();
            assertThat(business.get住所カナ(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_住所カナ));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の帳票出力順序コードは_設定した値と同じ帳票出力順序コードを返す() {
            business = sut.set帳票出力順序コード(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_帳票出力順序コード).build();
            assertThat(business.get帳票出力順序コード(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_帳票出力順序コード));
        }

        @Test
        public void 戻り値の訂正連絡票フラグは_設定した値と同じ訂正連絡票フラグを返す() {
            business = sut.set訂正連絡票フラグ(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_訂正連絡票フラグ).build();
            assertThat(business.is訂正連絡票フラグ(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_訂正連絡票フラグ));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_送付年月));
        }

    }
}
