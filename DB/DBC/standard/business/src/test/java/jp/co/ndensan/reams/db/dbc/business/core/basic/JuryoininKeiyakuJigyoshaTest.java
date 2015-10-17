/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoininKeiyakuJigyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaTest extends DbcTestBase {

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

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyosha(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3077JuryoininKeiyakuJigyoshaEntityにセットされている() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get事業者契約番号(), is(主キー名1));
            assertThat(sut.get開始年月日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJuryoininKeiyakuJigyoshaIdentifierにセットされている() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get事業者契約番号(), is(主キー名1));
            assertThat(sut.identifier().get開始年月日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JuryoininKeiyakuJigyosha(null);
        }

        @Test
        public void 指定したDbT3077JuryoininKeiyakuJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);

            assertThat(sut.identifier().get事業者契約番号(), is(主キー名1));
            assertThat(sut.identifier().get開始年月日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void get事業者契約番号は_entityが持つ事業者契約番号を返す() {
            assertThat(sut.get事業者契約番号(), is(JuryoininKeiyakuJigyoshaEntity.getJigyoshaKeiyakuNo()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(JuryoininKeiyakuJigyoshaEntity.getKaishiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JuryoininKeiyakuJigyoshaEntity.getRirekiNo()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(JuryoininKeiyakuJigyoshaEntity.getShuryoYMD()));
        }

        @Test
        public void get届出年月日は_entityが持つ届出年月日を返す() {
            assertThat(sut.get届出年月日(), is(JuryoininKeiyakuJigyoshaEntity.getTodokedeYMD()));
        }

        @Test
        public void get届出者住所は_entityが持つ届出者住所を返す() {
            assertThat(sut.get届出者住所(), is(JuryoininKeiyakuJigyoshaEntity.getTodokedeAddress()));
        }

        @Test
        public void get届出者事業者名称は_entityが持つ届出者事業者名称を返す() {
            assertThat(sut.get届出者事業者名称(), is(JuryoininKeiyakuJigyoshaEntity.getTodokedeJigyoshaName()));
        }

        @Test
        public void get届出者代表者氏名は_entityが持つ届出者代表者氏名を返す() {
            assertThat(sut.get届出者代表者氏名(), is(JuryoininKeiyakuJigyoshaEntity.getTodokedeDaihyoshaName()));
        }

        @Test
        public void get金融機関コードは_entityが持つ金融機関コードを返す() {
            assertThat(sut.get金融機関コード(), is(JuryoininKeiyakuJigyoshaEntity.getKinyuKikanCode()));
        }

        @Test
        public void get支店コードは_entityが持つ支店コードを返す() {
            assertThat(sut.get支店コード(), is(JuryoininKeiyakuJigyoshaEntity.getShitenCode()));
        }

        @Test
        public void get口座種別は_entityが持つ口座種別を返す() {
            assertThat(sut.get口座種別(), is(JuryoininKeiyakuJigyoshaEntity.getKozaShubetsu()));
        }

        @Test
        public void get口座番号は_entityが持つ口座番号を返す() {
            assertThat(sut.get口座番号(), is(JuryoininKeiyakuJigyoshaEntity.getKozaNo()));
        }

        @Test
        public void get通帳記号は_entityが持つ通帳記号を返す() {
            assertThat(sut.get通帳記号(), is(JuryoininKeiyakuJigyoshaEntity.getTsuchoKigo()));
        }

        @Test
        public void get通帳番号は_entityが持つ通帳番号を返す() {
            assertThat(sut.get通帳番号(), is(JuryoininKeiyakuJigyoshaEntity.getTsuchoNo()));
        }

        @Test
        public void get口座名義人は_entityが持つ口座名義人を返す() {
            assertThat(sut.get口座名義人(), is(JuryoininKeiyakuJigyoshaEntity.getKozaMeiginin()));
        }

        @Test
        public void get口座名義人漢字は_entityが持つ口座名義人漢字を返す() {
            assertThat(sut.get口座名義人漢字(), is(JuryoininKeiyakuJigyoshaEntity.getKozaMeigininKanji()));
        }

        @Test
        public void get事業者FAX番号は_entityが持つ事業者FAX番号を返す() {
            assertThat(sut.get事業者FAX番号(), is(JuryoininKeiyakuJigyoshaEntity.getJigyoshaFaxNo()));
        }

        @Test
        public void get契約登録年月日は_entityが持つ契約登録年月日を返す() {
            assertThat(sut.get契約登録年月日(), is(JuryoininKeiyakuJigyoshaEntity.getKeiyakuTorokuYMD()));
        }

        @Test
        public void get送付先部署は_entityが持つ送付先部署を返す() {
            assertThat(sut.get送付先部署(), is(JuryoininKeiyakuJigyoshaEntity.getSofusakiBusho()));
        }

        @Test
        public void get営業形態は_entityが持つ営業形態を返す() {
            assertThat(sut.get営業形態(), is(JuryoininKeiyakuJigyoshaEntity.getEigyoKeitai()));
        }

        @Test
        public void get住宅改修契約有無は_entityが持つ住宅改修契約有無を返す() {
            assertThat(sut.get住宅改修契約有無(), is(JuryoininKeiyakuJigyoshaEntity.getJutakuKaishuKeiyakuUmu()));
        }

        @Test
        public void get特定福祉用具販売契約有無は_entityが持つ特定福祉用具販売契約有無を返す() {
            assertThat(sut.get特定福祉用具販売契約有無(), is(JuryoininKeiyakuJigyoshaEntity.getTokuteiFukushiYoguHanbaiKeiyakuUmu()));
        }

        @Test
        public void get償還払給付契約有無は_entityが持つ償還払給付契約有無を返す() {
            assertThat(sut.get償還払給付契約有無(), is(JuryoininKeiyakuJigyoshaEntity.getShokanbaraiKyufuKeiyakuUmu()));
        }

        @Test
        public void get高額給付契約有無は_entityが持つ高額給付契約有無を返す() {
            assertThat(sut.get高額給付契約有無(), is(JuryoininKeiyakuJigyoshaEntity.getKogakuKyufuKeiyakuUmu()));
        }

        @Test
        public void get契約事業者番号は_entityが持つ契約事業者番号を返す() {
            assertThat(sut.get契約事業者番号(), is(JuryoininKeiyakuJigyoshaEntity.getKeiyakuJigyoshaNo()));
        }

        @Test
        public void get取扱確約書有無は_entityが持つ取扱確約書有無を返す() {
            assertThat(sut.get取扱確約書有無(), is(JuryoininKeiyakuJigyoshaEntity.getToriatsukaiKakuyakushoUmu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JuryoininKeiyakuJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;
        private static JuryoininKeiyakuJigyosha result;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setJigyoshaKeiyakuNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

        }

        @Test
        public void JuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JuryoininKeiyakuJigyoshaが保持するDbT3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JuryoininKeiyakuJigyosha setStateJuryoininKeiyakuJigyosha(EntityDataState parentState) {
            JuryoininKeiyakuJigyoshaEntity.setState(parentState);
            return new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }
    }
}
