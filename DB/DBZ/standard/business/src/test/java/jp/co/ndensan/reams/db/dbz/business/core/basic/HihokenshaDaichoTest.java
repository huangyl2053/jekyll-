/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link HihokenshaDaicho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaDaichoTest extends DbzTestBase {

    private static DbT1001HihokenshaDaichoEntity HihokenshaDaichoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
        異動日 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = new DbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaicho(null, 異動日, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaicho(被保険者番号, null, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaicho(被保険者番号, 異動日, null);
        }

        @Test
        public void 指定したキーが保持するDbT1001HihokenshaDaichoEntityにセットされている() {
            sut = new HihokenshaDaicho(被保険者番号, 異動日, 枝番);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get異動日(), is(異動日));
            assertThat(sut.get枝番(), is(枝番));
        }

        @Test
        public void 指定したキーが保持するHihokenshaDaichoIdentifierにセットされている() {
            sut = new HihokenshaDaicho(被保険者番号, 異動日, 枝番);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = new DbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HihokenshaDaicho(null);
        }

        @Test
        public void 指定したDbT1001HihokenshaDaichoEntityのキー情報を識別子が持つ() {

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);

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
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(HihokenshaDaichoEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);

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
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);

            sut = new HihokenshaDaicho(HihokenshaDaichoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static HihokenshaDaicho sut;
        private static HihokenshaDaicho result;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);

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
