/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosaChikuGroup}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChosaChikuGroupTest extends DbzTestBase {

    private static DbT5225ChosaChikuGroupEntity chosaChikuGroupEntity;
    private static Code 調査地区グループコード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区グループコード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
        市町村コード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosaChikuGroup(null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosaChikuGroup(調査地区グループコード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5225ChosaChikuGroupEntityにセットされている() {
            sut = new ChosaChikuGroup(調査地区グループコード, 市町村コード);
            assertThat(sut.get調査地区グループコード(), is(調査地区グループコード));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するChosaChikuGroupIdentifierにセットされている() {
            sut = new ChosaChikuGroup(調査地区グループコード, 市町村コード);
            assertThat(sut.identifier().get調査地区グループコード(), is(調査地区グループコード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChosaChikuGroup(null);
        }

        @Test
        public void 指定したDbT5225ChosaChikuGroupEntityのキー情報を識別子が持つ() {

            sut = new ChosaChikuGroup(chosaChikuGroupEntity);

            assertThat(sut.identifier().get調査地区グループコード(), is(調査地区グループコード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(chosaChikuGroupEntity);
        }

        @Test
        public void get調査地区グループコードは_entityが持つ調査地区グループコードを返す() {
            assertThat(sut.get調査地区グループコード(), is(chosaChikuGroupEntity.getChosaChikuGroupCode()));
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(chosaChikuGroupEntity.getChosachikucode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(chosaChikuGroupEntity.getShichosonCode()));
        }

        @Test
        public void get調査地区グループ名称は_entityが持つ調査地区グループ名称を返す() {
            assertThat(sut.get調査地区グループ名称(), is(chosaChikuGroupEntity.getChosachikugroupname()));
        }

        @Test
        public void get優先番号は_entityが持つ優先番号を返す() {
            assertThat(sut.get優先番号(), is(chosaChikuGroupEntity.getYusenNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(chosaChikuGroupEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(chosaChikuGroupEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChosaChikuGroup sut;

        @BeforeClass
        public static void setUpClass() {
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

            sut = new ChosaChikuGroup(chosaChikuGroupEntity);
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
            chosaChikuGroupEntity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();

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
            chosaChikuGroupEntity.setState(parentState);
            return new ChosaChikuGroup(chosaChikuGroupEntity);
        }
    }
}
