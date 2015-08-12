/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoServiceJokyoFlag}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoServiceJokyoFlagTest extends DbzTestBase {

    private static DbT5208NinteichosahyoServiceJokyoFlagEntity NinteichosahyoServiceJokyoFlagEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoServiceJokyoFlag(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoServiceJokyoFlag(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityにセットされている() {
            sut = new NinteichosahyoServiceJokyoFlag(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoServiceJokyoFlagIdentifierにセットされている() {
            sut = new NinteichosahyoServiceJokyoFlag(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoServiceJokyoFlag(null);
        }

        @Test
        public void 指定したDbT5208NinteichosahyoServiceJokyoFlagEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();

            sut = new NinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoServiceJokyoFlagEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoServiceJokyoFlagEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoServiceJokyoFlagEntity.getRemban()));
        }

        @Test
        public void getサービスの状況は_entityが持つサービスの状況を返す() {
            assertThat(sut.getサービスの状況(), is(NinteichosahyoServiceJokyoFlagEntity.getServiceJokyo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();

            sut = new NinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoServiceJokyoFlagEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();

            sut = new NinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyoFlag sut;
        private static NinteichosahyoServiceJokyoFlag result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoFlagEntity = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.createDbT5208NinteichosahyoServiceJokyoFlagEntity();

        }

        @Test
        public void NinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoFlagが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyoFlag(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoFlagが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyoFlag(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoFlagが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyoFlag(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoServiceJokyoFlagが保持するDbT5208NinteichosahyoServiceJokyoFlagEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyoFlag(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoServiceJokyoFlag setStateNinteichosahyoServiceJokyoFlag(EntityDataState parentState) {
            NinteichosahyoServiceJokyoFlagEntity.setState(parentState);
            return new NinteichosahyoServiceJokyoFlag(NinteichosahyoServiceJokyoFlagEntity);
        }
    }
}
