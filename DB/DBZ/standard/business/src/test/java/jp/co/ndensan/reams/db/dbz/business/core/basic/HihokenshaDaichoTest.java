/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
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
 * {@link HihokenshaDaicho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoTest extends DbzTestBase {

    private static DbT1001HihokenshaDaichoEntity HihokenshaDaichoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaicho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaicho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT1001HihokenshaDaichoEntityにセットされている() {
            sut = new HihokenshaDaicho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するHihokenshaDaichoIdentifierにセットされている() {
            sut = new HihokenshaDaicho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HihokenshaDaicho(null);
        }

        @Test
        public void 指定したDbT1001HihokenshaDaichoEntityのキー情報を識別子が持つ() {

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(HihokenshaDaichoEntity.getHihokenshaNo()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(HihokenshaDaichoEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(HihokenshaDaichoEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(HihokenshaDaichoEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(HihokenshaDaichoEntity.getShichosonCode()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(HihokenshaDaichoEntity.getShikibetsuCode()));
        }

        @Test
        public void get資格取得事由コードは_entityが持つ資格取得事由コードを返す() {
            assertThat(sut.get資格取得事由コード(), is(HihokenshaDaichoEntity.getShikakuShutokuJiyuCode()));
        }

        @Test
        public void get資格取得年月日は_entityが持つ資格取得年月日を返す() {
            assertThat(sut.get資格取得年月日(), is(HihokenshaDaichoEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格取得届出年月日は_entityが持つ資格取得届出年月日を返す() {
            assertThat(sut.get資格取得届出年月日(), is(HihokenshaDaichoEntity.getShikakuShutokuTodokedeYMD()));
        }

        @Test
        public void get第1号資格取得年月日は_entityが持つ第1号資格取得年月日を返す() {
            assertThat(sut.get第1号資格取得年月日(), is(HihokenshaDaichoEntity.getIchigoShikakuShutokuYMD()));
        }

        @Test
        public void get被保険者区分コードは_entityが持つ被保険者区分コードを返す() {
            assertThat(sut.get被保険者区分コード(), is(HihokenshaDaichoEntity.getHihokennshaKubunCode()));
        }

        @Test
        public void get資格喪失事由コードは_entityが持つ資格喪失事由コードを返す() {
            assertThat(sut.get資格喪失事由コード(), is(HihokenshaDaichoEntity.getShikakuSoshitsuJiyuCode()));
        }

        @Test
        public void get資格喪失年月日は_entityが持つ資格喪失年月日を返す() {
            assertThat(sut.get資格喪失年月日(), is(HihokenshaDaichoEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失届出年月日は_entityが持つ資格喪失届出年月日を返す() {
            assertThat(sut.get資格喪失届出年月日(), is(HihokenshaDaichoEntity.getShikakuSoshitsuTodokedeYMD()));
        }

        @Test
        public void get資格変更事由コードは_entityが持つ資格変更事由コードを返す() {
            assertThat(sut.get資格変更事由コード(), is(HihokenshaDaichoEntity.getShikakuHenkoJiyuCode()));
        }

        @Test
        public void get資格変更年月日は_entityが持つ資格変更年月日を返す() {
            assertThat(sut.get資格変更年月日(), is(HihokenshaDaichoEntity.getShikakuHenkoYMD()));
        }

        @Test
        public void get資格変更届出年月日は_entityが持つ資格変更届出年月日を返す() {
            assertThat(sut.get資格変更届出年月日(), is(HihokenshaDaichoEntity.getShikakuHenkoTodokedeYMD()));
        }

        @Test
        public void get住所地特例適用事由コードは_entityが持つ住所地特例適用事由コードを返す() {
            assertThat(sut.get住所地特例適用事由コード(), is(HihokenshaDaichoEntity.getJushochitokureiTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(HihokenshaDaichoEntity.getJushochitokureiTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(HihokenshaDaichoEntity.getJushochitokureiTekiyoTodokedeYMD()));
        }

        @Test
        public void get住所地特例解除事由コードは_entityが持つ住所地特例解除事由コードを返す() {
            assertThat(sut.get住所地特例解除事由コード(), is(HihokenshaDaichoEntity.getJushochitokureiKaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(HihokenshaDaichoEntity.getJushochitokureiKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(HihokenshaDaichoEntity.getJushochitokureiKaijoTodokedeYMD()));
        }

        @Test
        public void get住所地特例フラグは_entityが持つ住所地特例フラグを返す() {
            assertThat(sut.get住所地特例フラグ(), is(HihokenshaDaichoEntity.getJushochiTokureiFlag()));
        }

        @Test
        public void get広域内住所地特例フラグは_entityが持つ広域内住所地特例フラグを返す() {
            assertThat(sut.get広域内住所地特例フラグ(), is(HihokenshaDaichoEntity.getKoikinaiJushochiTokureiFlag()));
        }

        @Test
        public void get広住特措置元市町村コードは_entityが持つ広住特措置元市町村コードを返す() {
            assertThat(sut.get広住特措置元市町村コード(), is(HihokenshaDaichoEntity.getKoikinaiTokureiSochimotoShichosonCode()));
        }

        @Test
        public void get旧市町村コードは_entityが持つ旧市町村コードを返す() {
            assertThat(sut.get旧市町村コード(), is(HihokenshaDaichoEntity.getKyuShichosonCode()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(HihokenshaDaichoEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HihokenshaDaichoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;
        private static HihokenshaDaicho result;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setXXX(主キー名1);
            HihokenshaDaichoEntity.setXXX(主キー名2);

        }

        @Test
        public void HihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoが返る() {
            sut = TestSupport.setStateHihokenshaDaicho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoが返る() {
            sut = TestSupport.setStateHihokenshaDaicho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがDeletedに指定されたHihokenshaDaichoが返る() {
            sut = TestSupport.setStateHihokenshaDaicho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HihokenshaDaichoが保持するDbT1001HihokenshaDaichoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHihokenshaDaicho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static HihokenshaDaicho setStateHihokenshaDaicho(EntityDataState parentState) {
            HihokenshaDaichoEntity.setState(parentState);
            return new HihokenshaDaicho(HihokenshaDaichoEntity);
        }
    }
}
