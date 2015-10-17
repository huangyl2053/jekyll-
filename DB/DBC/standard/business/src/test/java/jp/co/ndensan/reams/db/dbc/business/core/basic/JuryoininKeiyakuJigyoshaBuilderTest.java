/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
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
 * {@link JuryoininKeiyakuJigyoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaBuilderTest extends DbcTestBase {

    private static DbT3077JuryoininKeiyakuJigyoshaEntity JuryoininKeiyakuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
        主キー名2 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
        主キー名3 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static JuryoininKeiyakuJigyoshaBuilder sut;
        private static JuryoininKeiyakuJigyosha business;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            business = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業者契約番号は_設定した値と同じ事業者契約番号を返す() {
            business = sut.set事業者契約番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号).build();
            assertThat(business.get事業者契約番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            business = sut.set終了年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日).build();
            assertThat(business.get終了年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日));
        }

        @Test
        public void 戻り値の届出年月日は_設定した値と同じ届出年月日を返す() {
            business = sut.set届出年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出年月日).build();
            assertThat(business.get届出年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出年月日));
        }

        @Test
        public void 戻り値の届出者住所は_設定した値と同じ届出者住所を返す() {
            business = sut.set届出者住所(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者住所).build();
            assertThat(business.get届出者住所(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者住所));
        }

        @Test
        public void 戻り値の届出者事業者名称は_設定した値と同じ届出者事業者名称を返す() {
            business = sut.set届出者事業者名称(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者事業者名称).build();
            assertThat(business.get届出者事業者名称(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者事業者名称));
        }

        @Test
        public void 戻り値の届出者代表者氏名は_設定した値と同じ届出者代表者氏名を返す() {
            business = sut.set届出者代表者氏名(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者代表者氏名).build();
            assertThat(business.get届出者代表者氏名(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_届出者代表者氏名));
        }

        @Test
        public void 戻り値の金融機関コードは_設定した値と同じ金融機関コードを返す() {
            business = sut.set金融機関コード(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_金融機関コード).build();
            assertThat(business.get金融機関コード(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_金融機関コード));
        }

        @Test
        public void 戻り値の支店コードは_設定した値と同じ支店コードを返す() {
            business = sut.set支店コード(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_支店コード).build();
            assertThat(business.get支店コード(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_支店コード));
        }

        @Test
        public void 戻り値の口座種別は_設定した値と同じ口座種別を返す() {
            business = sut.set口座種別(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座種別).build();
            assertThat(business.get口座種別(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座種別));
        }

        @Test
        public void 戻り値の口座番号は_設定した値と同じ口座番号を返す() {
            business = sut.set口座番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座番号).build();
            assertThat(business.get口座番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座番号));
        }

        @Test
        public void 戻り値の通帳記号は_設定した値と同じ通帳記号を返す() {
            business = sut.set通帳記号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_通帳記号).build();
            assertThat(business.get通帳記号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_通帳記号));
        }

        @Test
        public void 戻り値の通帳番号は_設定した値と同じ通帳番号を返す() {
            business = sut.set通帳番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_通帳番号).build();
            assertThat(business.get通帳番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_通帳番号));
        }

        @Test
        public void 戻り値の口座名義人は_設定した値と同じ口座名義人を返す() {
            business = sut.set口座名義人(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座名義人).build();
            assertThat(business.get口座名義人(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座名義人));
        }

        @Test
        public void 戻り値の口座名義人漢字は_設定した値と同じ口座名義人漢字を返す() {
            business = sut.set口座名義人漢字(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座名義人漢字).build();
            assertThat(business.get口座名義人漢字(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_口座名義人漢字));
        }

        @Test
        public void 戻り値の事業者FAX番号は_設定した値と同じ事業者FAX番号を返す() {
            business = sut.set事業者FAX番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者FAX番号).build();
            assertThat(business.get事業者FAX番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者FAX番号));
        }

        @Test
        public void 戻り値の契約登録年月日は_設定した値と同じ契約登録年月日を返す() {
            business = sut.set契約登録年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約登録年月日).build();
            assertThat(business.get契約登録年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約登録年月日));
        }

        @Test
        public void 戻り値の送付先部署は_設定した値と同じ送付先部署を返す() {
            business = sut.set送付先部署(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署).build();
            assertThat(business.get送付先部署(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署));
        }

        @Test
        public void 戻り値の営業形態は_設定した値と同じ営業形態を返す() {
            business = sut.set営業形態(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_営業形態).build();
            assertThat(business.get営業形態(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_営業形態));
        }

        @Test
        public void 戻り値の住宅改修契約有無は_設定した値と同じ住宅改修契約有無を返す() {
            business = sut.set住宅改修契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_住宅改修契約有無).build();
            assertThat(business.get住宅改修契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_住宅改修契約有無));
        }

        @Test
        public void 戻り値の特定福祉用具販売契約有無は_設定した値と同じ特定福祉用具販売契約有無を返す() {
            business = sut.set特定福祉用具販売契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_特定福祉用具販売契約有無).build();
            assertThat(business.get特定福祉用具販売契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_特定福祉用具販売契約有無));
        }

        @Test
        public void 戻り値の償還払給付契約有無は_設定した値と同じ償還払給付契約有無を返す() {
            business = sut.set償還払給付契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_償還払給付契約有無).build();
            assertThat(business.get償還払給付契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_償還払給付契約有無));
        }

        @Test
        public void 戻り値の高額給付契約有無は_設定した値と同じ高額給付契約有無を返す() {
            business = sut.set高額給付契約有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_高額給付契約有無).build();
            assertThat(business.get高額給付契約有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_高額給付契約有無));
        }

        @Test
        public void 戻り値の契約事業者番号は_設定した値と同じ契約事業者番号を返す() {
            business = sut.set契約事業者番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号).build();
            assertThat(business.get契約事業者番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号));
        }

        @Test
        public void 戻り値の取扱確約書有無は_設定した値と同じ取扱確約書有無を返す() {
            business = sut.set取扱確約書有無(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_取扱確約書有無).build();
            assertThat(business.get取扱確約書有無(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_取扱確約書有無));
        }

    }
}
