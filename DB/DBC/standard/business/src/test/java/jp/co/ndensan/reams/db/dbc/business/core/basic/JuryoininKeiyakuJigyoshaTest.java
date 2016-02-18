/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_契約事業者番号;
        主キー名2 = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyosha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3077JuryoininKeiyakuJigyoshaEntityにセットされている() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.get契約事業者番号(), is(主キー名1));
            assertThat(sut.get開始年月日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJuryoininKeiyakuJigyoshaIdentifierにセットされている() {
            sut = new JuryoininKeiyakuJigyosha(主キー名1, 主キー名2);
            assertThat(sut.identifier().get事業者契約番号(), is(主キー名1));
            assertThat(sut.identifier().get開始年月日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
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
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void get事業者契約番号は_entityが持つ事業者契約番号を返す() {
            assertThat(sut.get契約事業者番号(), is(JuryoininKeiyakuJigyoshaEntity.getKeiyakuJigyoshaNo()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(JuryoininKeiyakuJigyoshaEntity.getKaishiYMD()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(JuryoininKeiyakuJigyoshaEntity.getShuryoYMD()));
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
        public void get送付先部署は_entityが持つ送付先部署を返す() {
            assertThat(sut.get送付先部署(), is(JuryoininKeiyakuJigyoshaEntity.getSofusakiBusho()));
        }

        @Test
        public void get契約事業者番号は_entityが持つ契約事業者番号を返す() {
            assertThat(sut.get契約事業者番号(), is(JuryoininKeiyakuJigyoshaEntity.getKeiyakuJigyoshaNo()));
        }

    }

    public static class toEntityテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
            JuryoininKeiyakuJigyoshaEntity.setKaishiYMD(主キー名2);

            sut = new JuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JuryoininKeiyakuJigyoshaEntity));
        }
    }

    @Ignore
    public static class SerializationProxyテスト extends DbcTestBase {

        private static JuryoininKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoininKeiyakuJigyoshaEntity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
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
            JuryoininKeiyakuJigyoshaEntity.setKeiyakuJigyoshaNo(主キー名1);
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
