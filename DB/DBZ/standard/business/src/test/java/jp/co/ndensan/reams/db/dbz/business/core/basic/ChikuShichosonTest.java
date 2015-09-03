/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5224ChikuShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
    private static Code 調査地区コード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区コード = DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード;
        市町村コード = DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChikuShichoson sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuShichosonEntity = DbT5224ChikuShichosonEntityGenerator.createDbT5224ChikuShichosonEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuShichoson(null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuShichoson(調査地区コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5224ChikuShichosonEntityにセットされている() {
            sut = new ChikuShichoson(調査地区コード, 市町村コード);
            assertThat(sut.get調査地区コード(), is(調査地区コード));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するChikuShichosonIdentifierにセットされている() {
            sut = new ChikuShichoson(調査地区コード, 市町村コード);
            assertThat(sut.identifier().get調査地区コード(), is(調査地区コード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
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

            assertThat(sut.identifier().get調査地区コード(), is(調査地区コード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
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
