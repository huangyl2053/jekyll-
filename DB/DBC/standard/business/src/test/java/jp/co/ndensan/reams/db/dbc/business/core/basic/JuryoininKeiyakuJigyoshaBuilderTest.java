/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号;
        主キー名2 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static JuryoininKeiyakuJigyoshaBuilder sut;
        private static JuryoininKeiyakuJigyosha business;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            business = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業者契約番号は_設定した値と同じ事業者契約番号を返す() {
            business = sut.set事業者契約番号(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号).build();
            assertThat(business.get契約事業者番号(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            business = sut.set終了年月日(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日).build();
            assertThat(business.get終了年月日(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_終了年月日));
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
        public void 戻り値の送付先部署は_設定した値と同じ送付先部署を返す() {
            business = sut.set送付先部署(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署).build();
            assertThat(business.get送付先部署(), is(DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_送付先部署));
        }

    }
}
