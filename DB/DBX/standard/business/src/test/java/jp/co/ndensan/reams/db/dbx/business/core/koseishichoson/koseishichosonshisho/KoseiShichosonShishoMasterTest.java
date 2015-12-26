/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
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
 * {@link KoseiShichosonShishoMaster}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterTest extends DbzTestBase {

    private static DbT7052KoseiShichosonShishoMasterEntity KoseiShichosonShishoMasterEntity;

    private static LasdecCode 市町村コード;
    private static ShishoCode 支所コード;

    @BeforeClass
    public static void setUpClass() {

        市町村コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
        支所コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonShishoMaster(null, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonShishoMaster(市町村コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7052KoseiShichosonShishoMasterEntityにセットされている() {
            sut = new KoseiShichosonShishoMaster(市町村コード, 支所コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get支所コード(), is(支所コード));
        }

        @Test
        public void 指定したキーが保持するKoseiShichosonShishoMasterIdentifierにセットされている() {
            sut = new KoseiShichosonShishoMaster(市町村コード, 支所コード);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get支所コード(), is(支所コード));
        }

    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したKoseiShichosonShishoMasterRelateEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoseiShichosonShishoMaster(null);
        }

        @Test
        public void 指定したKoseiShichosonShishoMasterRelateEntityの保持するDbT7052KoseiShichosonShishoMasterEntityのキー情報を識別子が持つ() {

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get支所コード(), is(支所コード));
        }

    }

    public static class getterテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KoseiShichosonShishoMasterEntity.getShichosonCode()));
        }

        @Test
        public void get支所コードは_entityが持つ支所コードを返す() {
            assertThat(sut.get支所コード(), is(KoseiShichosonShishoMasterEntity.getShishoCode()));
        }

        @Test
        public void get支所名は_entityが持つ支所名を返す() {
            assertThat(sut.get支所名(), is(KoseiShichosonShishoMasterEntity.getShishoMei()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoseiShichosonShishoMasterEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;
        private static KoseiShichosonShishoMaster result;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);

        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoseiShichosonShishoMasterが保持するDbT7052KoseiShichosonShishoMasterEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KoseiShichosonShishoMaster setStateKoseiShichosonShishoMaster(EntityDataState parentState) {
            KoseiShichosonShishoMasterEntity.setState(parentState);
            return new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

    }
}
