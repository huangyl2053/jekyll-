/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoininKeiyakuJigyoshaAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaAliveTest extends DbzTestBase {

    private static DbV3077JuryoininKeiyakuJigyoshaEntity JuryoininKeiyakuJigyoshaAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 事業者契約番号;
    private static FlexibleDate 開始年月日;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        事業者契約番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
        開始年月日 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
        履歴番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 事業者契約番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyoshaAlive(null, 開始年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyoshaAlive(事業者契約番号, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbV3077JuryoininKeiyakuJigyoshaEntityにセットされている() {
            sut = new JuryoininKeiyakuJigyoshaAlive(事業者契約番号, 開始年月日, 履歴番号);
            assertThat(sut.get事業者契約番号(), is(事業者契約番号));
            assertThat(sut.get開始年月日(), is(開始年月日));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するJuryoininKeiyakuJigyoshaAliveIdentifierにセットされている() {
            sut = new JuryoininKeiyakuJigyoshaAlive(事業者契約番号, 開始年月日, 履歴番号);
            //TODO
//            assertThat(sut.identifier().getXXX(), is(事業者契約番号));
//            assertThat(sut.identifier().getXXX(), is(開始年月日));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JuryoininKeiyakuJigyoshaAlive(null);
        }

        @Test
        public void 指定したDbV3077JuryoininKeiyakuJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new JuryoininKeiyakuJigyoshaAlive(JuryoininKeiyakuJigyoshaAliveEntity);

            //TODO
//            assertThat(sut.identifier().getXXX(), is(事業者契約番号));
//            assertThat(sut.identifier().getXXX(), is(開始年月日));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();

            sut = new JuryoininKeiyakuJigyoshaAlive(JuryoininKeiyakuJigyoshaAliveEntity);
        }

        @Test
        public void get事業者契約番号は_entityが持つ事業者契約番号を返す() {
            assertThat(sut.get事業者契約番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getJigyoshaKeiyakuNo()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKaishiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getRirekiNo()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(JuryoininKeiyakuJigyoshaAliveEntity.getShuryoYMD()));
        }

        @Test
        public void get届出年月日は_entityが持つ届出年月日を返す() {
            assertThat(sut.get届出年月日(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTodokedeYMD()));
        }

        @Test
        public void get届出者住所は_entityが持つ届出者住所を返す() {
            assertThat(sut.get届出者住所(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTodokedeAddress()));
        }

        @Test
        public void get届出者事業者名称は_entityが持つ届出者事業者名称を返す() {
            assertThat(sut.get届出者事業者名称(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTodokedeJigyoshaName()));
        }

        @Test
        public void get届出者代表者氏名は_entityが持つ届出者代表者氏名を返す() {
            assertThat(sut.get届出者代表者氏名(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTodokedeDaihyoshaName()));
        }

        @Test
        public void get口座種別は_entityが持つ口座種別を返す() {
            assertThat(sut.get口座種別(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKozaShubetsu()));
        }

        @Test
        public void get口座番号は_entityが持つ口座番号を返す() {
            assertThat(sut.get口座番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKozaNo()));
        }

        @Test
        public void get通帳記号は_entityが持つ通帳記号を返す() {
            assertThat(sut.get通帳記号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTsuchoKigo()));
        }

        @Test
        public void get通帳番号は_entityが持つ通帳番号を返す() {
            assertThat(sut.get通帳番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTsuchoNo()));
        }

        @Test
        public void get口座名義人は_entityが持つ口座名義人を返す() {
            assertThat(sut.get口座名義人(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKozaMeiginin()));
        }

        @Test
        public void get口座名義人漢字は_entityが持つ口座名義人漢字を返す() {
            assertThat(sut.get口座名義人漢字(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKozaMeigininKanji()));
        }

        @Test
        public void get事業者FAX番号は_entityが持つ事業者FAX番号を返す() {
            assertThat(sut.get事業者FAX番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getJigyoshaFaxNo()));
        }

        @Test
        public void get契約登録年月日は_entityが持つ契約登録年月日を返す() {
            assertThat(sut.get契約登録年月日(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKeiyakuTorokuYMD()));
        }

        @Test
        public void get送付先部署は_entityが持つ送付先部署を返す() {
            assertThat(sut.get送付先部署(), is(JuryoininKeiyakuJigyoshaAliveEntity.getSofusakiBusho()));
        }

        @Test
        public void get営業形態は_entityが持つ営業形態を返す() {
            assertThat(sut.get営業形態(), is(JuryoininKeiyakuJigyoshaAliveEntity.getEigyoKeitai()));
        }

        @Test
        public void get住宅改修契約有無は_entityが持つ住宅改修契約有無を返す() {
            assertThat(sut.get住宅改修契約有無(), is(JuryoininKeiyakuJigyoshaAliveEntity.getJutakuKaishuKeiyakuUmu()));
        }

        @Test
        public void get特定福祉用具販売契約有無は_entityが持つ特定福祉用具販売契約有無を返す() {
            assertThat(sut.get特定福祉用具販売契約有無(), is(JuryoininKeiyakuJigyoshaAliveEntity.getTokuteiFukushiYoguHanbaiKeiyakuUmu()));
        }

        @Test
        public void get償還払給付契約有無は_entityが持つ償還払給付契約有無を返す() {
            assertThat(sut.get償還払給付契約有無(), is(JuryoininKeiyakuJigyoshaAliveEntity.getShokanbaraiKyufuKeiyakuUmu()));
        }

        @Test
        public void get高額給付契約有無は_entityが持つ高額給付契約有無を返す() {
            assertThat(sut.get高額給付契約有無(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKogakuKyufuKeiyakuUmu()));
        }

        @Test
        public void get契約事業者番号は_entityが持つ契約事業者番号を返す() {
            assertThat(sut.get契約事業者番号(), is(JuryoininKeiyakuJigyoshaAliveEntity.getKeiyakuJigyoshaNo()));
        }

        @Test
        public void get取扱確約書有無は_entityが持つ取扱確約書有無を返す() {
            assertThat(sut.get取扱確約書有無(), is(JuryoininKeiyakuJigyoshaAliveEntity.getToriatsukaiKakuyakushoUmu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();

            sut = new JuryoininKeiyakuJigyoshaAlive(JuryoininKeiyakuJigyoshaAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JuryoininKeiyakuJigyoshaAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();

            sut = new JuryoininKeiyakuJigyoshaAlive(JuryoininKeiyakuJigyoshaAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static JuryoininKeiyakuJigyoshaAlive sut;
        private static JuryoininKeiyakuJigyoshaAlive result;

        @BeforeClass
        public static void setUpClass() {
            JuryoininKeiyakuJigyoshaAliveEntity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();

        }

        @Test
        public void JuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaAliveが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyoshaAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaAliveが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyoshaAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoininKeiyakuJigyoshaAliveが返る() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyoshaAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JuryoininKeiyakuJigyoshaAliveが保持するDbV3077JuryoininKeiyakuJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJuryoininKeiyakuJigyoshaAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JuryoininKeiyakuJigyoshaAlive setStateJuryoininKeiyakuJigyoshaAlive(EntityDataState parentState) {
            JuryoininKeiyakuJigyoshaAliveEntity.setState(parentState);
            return new JuryoininKeiyakuJigyoshaAlive(JuryoininKeiyakuJigyoshaAliveEntity);
        }
    }
}
