/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5224ChikuShichosonEntityGenerator;
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
 * {@link ChikuShichoson}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuShichosonTest extends DbzTestBase {

    private static DbT5224ChikuShichosonEntity ChikuShichosonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5224ChikuShichosonEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5224ChikuShichosonEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuShichoson(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuShichoson(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5224ChikuShichosonEntityにセットされている() {
            sut = new ChikuShichoson(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChikuShichosonIdentifierにセットされている() {
            sut = new ChikuShichoson(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChikuShichoson(null);
        }

        @Test
        public void 指定したDbT5224ChikuShichosonEntityのキー情報を識別子が持つ() {

            sut = new ChikuShichoson(ChikuShichosonEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();

            sut = new ChikuShichoson(ChikuShichosonEntity);
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(ChikuShichosonEntity.getChosaChikuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ChikuShichosonEntity.getShichosonCode()));
        }

        @Test
        public void get優先番号は_entityが持つ優先番号を返す() {
            assertThat(sut.get優先番号(), is(ChikuShichosonEntity.getYusenNo()));
        }

        @Test
        public void get自地区フラグは_entityが持つ自地区フラグを返す() {
            assertThat(sut.get自地区フラグ(), is(ChikuShichosonEntity.getJiChikuFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();

            sut = new ChikuShichoson(ChikuShichosonEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChikuShichosonEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();

            sut = new ChikuShichoson(ChikuShichosonEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChikuShichoson sut;
        private static ChikuShichoson result;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();

        }

        @Test
        public void ChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがDeletedに指定されたChikuShichosonが返る() {
            sut = TestSupport.setStateChikuShichoson(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがDeletedに指定されたChikuShichosonが返る() {
            sut = TestSupport.setStateChikuShichoson(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがDeletedに指定されたChikuShichosonが返る() {
            sut = TestSupport.setStateChikuShichoson(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChikuShichosonが保持するDbT5224ChikuShichosonEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChikuShichoson(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChikuShichoson setStateChikuShichoson(EntityDataState parentState) {
            ChikuShichosonEntity.setState(parentState);
            return new ChikuShichoson(ChikuShichosonEntity);
        }
    }
}
