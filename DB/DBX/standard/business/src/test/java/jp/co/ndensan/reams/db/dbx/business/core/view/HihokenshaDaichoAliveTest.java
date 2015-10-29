/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
 * {@link HihokenshaDaichoAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaDaichoAliveTest extends DbxTestBase {

    private static DbV1001HihokenshaDaichoEntity HihokenshaDaichoAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static RString edaNo;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaichoAlive(null, 主キー名2, edaNo);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaichoAlive(主キー名1, null, edaNo);
        }

        @Test
        public void 指定したキーが保持するDbV1001HihokenshaDaichoEntityにセットされている() {
            sut = new HihokenshaDaichoAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get異動日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するHihokenshaDaichoAliveIdentifierにセットされている() {
            sut = new HihokenshaDaichoAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HihokenshaDaichoAlive(null);
        }

        @Test
        public void 指定したDbV1001HihokenshaDaichoEntityのキー情報を識別子が持つ() {

            sut = new HihokenshaDaichoAlive(HihokenshaDaichoAliveEntity);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);

            sut = new HihokenshaDaichoAlive(HihokenshaDaichoAliveEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(HihokenshaDaichoAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(HihokenshaDaichoAliveEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(HihokenshaDaichoAliveEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(HihokenshaDaichoAliveEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(HihokenshaDaichoAliveEntity.getShichosonCode()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(HihokenshaDaichoAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get資格取得事由コードは_entityが持つ資格取得事由コードを返す() {
            assertThat(sut.get資格取得事由コード(), is(HihokenshaDaichoAliveEntity.getShikakuShutokuJiyuCode()));
        }

        @Test
        public void get資格取得年月日は_entityが持つ資格取得年月日を返す() {
            assertThat(sut.get資格取得年月日(), is(HihokenshaDaichoAliveEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格取得届出年月日は_entityが持つ資格取得届出年月日を返す() {
            assertThat(sut.get資格取得届出年月日(), is(HihokenshaDaichoAliveEntity.getShikakuShutokuTodokedeYMD()));
        }

        @Test
        public void get第1号資格取得年月日は_entityが持つ第1号資格取得年月日を返す() {
            assertThat(sut.get第1号資格取得年月日(), is(HihokenshaDaichoAliveEntity.getIchigoShikakuShutokuYMD()));
        }

        @Test
        public void get被保険者区分コードは_entityが持つ被保険者区分コードを返す() {
            assertThat(sut.get被保険者区分コード(), is(HihokenshaDaichoAliveEntity.getHihokennshaKubunCode()));
        }

        @Test
        public void get資格喪失事由コードは_entityが持つ資格喪失事由コードを返す() {
            assertThat(sut.get資格喪失事由コード(), is(HihokenshaDaichoAliveEntity.getShikakuSoshitsuJiyuCode()));
        }

        @Test
        public void get資格喪失年月日は_entityが持つ資格喪失年月日を返す() {
            assertThat(sut.get資格喪失年月日(), is(HihokenshaDaichoAliveEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失届出年月日は_entityが持つ資格喪失届出年月日を返す() {
            assertThat(sut.get資格喪失届出年月日(), is(HihokenshaDaichoAliveEntity.getShikakuSoshitsuTodokedeYMD()));
        }

        @Test
        public void get資格変更事由コードは_entityが持つ資格変更事由コードを返す() {
            assertThat(sut.get資格変更事由コード(), is(HihokenshaDaichoAliveEntity.getShikakuHenkoJiyuCode()));
        }

        @Test
        public void get資格変更年月日は_entityが持つ資格変更年月日を返す() {
            assertThat(sut.get資格変更年月日(), is(HihokenshaDaichoAliveEntity.getShikakuHenkoYMD()));
        }

        @Test
        public void get資格変更届出年月日は_entityが持つ資格変更届出年月日を返す() {
            assertThat(sut.get資格変更届出年月日(), is(HihokenshaDaichoAliveEntity.getShikakuHenkoTodokedeYMD()));
        }

        @Test
        public void get住所地特例適用事由コードは_entityが持つ住所地特例適用事由コードを返す() {
            assertThat(sut.get住所地特例適用事由コード(), is(HihokenshaDaichoAliveEntity.getJushochitokureiTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(HihokenshaDaichoAliveEntity.getJushochitokureiTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(HihokenshaDaichoAliveEntity.getJushochitokureiTekiyoTodokedeYMD()));
        }

        @Test
        public void get住所地特例解除事由コードは_entityが持つ住所地特例解除事由コードを返す() {
            assertThat(sut.get住所地特例解除事由コード(), is(HihokenshaDaichoAliveEntity.getJushochitokureiKaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(HihokenshaDaichoAliveEntity.getJushochitokureiKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(HihokenshaDaichoAliveEntity.getJushochitokureiKaijoTodokedeYMD()));
        }

        @Test
        public void get住所地特例フラグは_entityが持つ住所地特例フラグを返す() {
            assertThat(sut.get住所地特例フラグ(), is(HihokenshaDaichoAliveEntity.getJushochiTokureiFlag()));
        }

        @Test
        public void get広域内住所地特例フラグは_entityが持つ広域内住所地特例フラグを返す() {
            assertThat(sut.get広域内住所地特例フラグ(), is(HihokenshaDaichoAliveEntity.getKoikinaiJushochiTokureiFlag()));
        }

        @Test
        public void get広住特措置元市町村コードは_entityが持つ広住特措置元市町村コードを返す() {
            assertThat(sut.get広住特措置元市町村コード(), is(HihokenshaDaichoAliveEntity.getKoikinaiTokureiSochimotoShichosonCode()));
        }

        @Test
        public void get旧市町村コードは_entityが持つ旧市町村コードを返す() {
            assertThat(sut.get旧市町村コード(), is(HihokenshaDaichoAliveEntity.getKyuShichosonCode()));
        }

        @Test
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(HihokenshaDaichoAliveEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);

            sut = new HihokenshaDaichoAlive(HihokenshaDaichoAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HihokenshaDaichoAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);

            sut = new HihokenshaDaichoAlive(HihokenshaDaichoAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static HihokenshaDaichoAlive sut;
        private static HihokenshaDaichoAlive result;

        @Before
        public void setUp() {
            HihokenshaDaichoAliveEntity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            HihokenshaDaichoAliveEntity.setHihokenshaNo(主キー名1);
            HihokenshaDaichoAliveEntity.setIdoYMD(主キー名2);
        }

        @Test
        public void HihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoAliveが返る() {
            sut = TestSupport.setStateHihokenshaDaichoAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoAliveが返る() {
            sut = TestSupport.setStateHihokenshaDaichoAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoAliveが返る() {
            sut = TestSupport.setStateHihokenshaDaichoAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HihokenshaDaichoAliveが保持するDbV1001HihokenshaDaichoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHihokenshaDaichoAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static HihokenshaDaichoAlive setStateHihokenshaDaichoAlive(EntityDataState parentState) {
            HihokenshaDaichoAliveEntity.setState(parentState);
            return new HihokenshaDaichoAlive(HihokenshaDaichoAliveEntity);
        }
    }
}
