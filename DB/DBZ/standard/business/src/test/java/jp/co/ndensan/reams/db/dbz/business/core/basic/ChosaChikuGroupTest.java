/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.entity.dbasic.helper.DbT5225ChosaChikuGroupEntityGenerator;
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
 * {@link ChosaChikuGroup}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosaChikuGroupTest extends DbzTestBase {

    private static DbT5225ChosaChikuGroupEntity ChosaChikuGroupEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosaChikuGroup(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosaChikuGroup(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5225ChosaChikuGroupEntityにセットされている() {
            sut = new ChosaChikuGroup(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChosaChikuGroupIdentifierにセットされている() {
            sut = new ChosaChikuGroup(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChosaChikuGroup(null);
        }

        @Test
        public void 指定したDbT5225ChosaChikuGroupEntityのキー情報を識別子が持つ() {

            sut = new ChosaChikuGroup(ChosaChikuGroupEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(ChosaChikuGroupEntity);
        }

        @Test
        public void get調査地区グループコードは_entityが持つ調査地区グループコードを返す() {
            assertThat(sut.get調査地区グループコード(), is(ChosaChikuGroupEntity.getChosaChikuGroupCode()));
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(ChosaChikuGroupEntity.getChosaChikuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ChosaChikuGroupEntity.getShichosonCode()));
        }

        @Test
        public void get調査地区グループ名称は_entityが持つ調査地区グループ名称を返す() {
            assertThat(sut.get調査地区グループ名称(), is(ChosaChikuGroupEntity.getChosaChikuGroupName()));
        }

        @Test
        public void get優先番号は_entityが持つ優先番号を返す() {
            assertThat(sut.get優先番号(), is(ChosaChikuGroupEntity.getYusenNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(ChosaChikuGroupEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChosaChikuGroupEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(ChosaChikuGroupEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;
        private static ChosaChikuGroup result;

        @BeforeClass
        public static void setUpClass() {
            ChosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

        }

        @Test
        public void ChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがDeletedに指定されたChosaChikuGroupが返る() {
            sut = TestSupport.setStateChosaChikuGroup(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがDeletedに指定されたChosaChikuGroupが返る() {
            sut = TestSupport.setStateChosaChikuGroup(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがDeletedに指定されたChosaChikuGroupが返る() {
            sut = TestSupport.setStateChosaChikuGroup(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChosaChikuGroupが保持するDbT5225ChosaChikuGroupEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChosaChikuGroup(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChosaChikuGroup setStateChosaChikuGroup(EntityDataState parentState) {
            ChosaChikuGroupEntity.setState(parentState);
            return new ChosaChikuGroup(ChosaChikuGroupEntity);
        }
    }
}
