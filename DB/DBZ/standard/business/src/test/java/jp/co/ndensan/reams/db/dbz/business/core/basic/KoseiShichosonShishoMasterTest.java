/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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

    private static DbT7052KoseiShichosonShishoMasterEntity KoseiShichosonShishoMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 主キー名1;
    private static ShishoCode 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
        主キー名2 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonShishoMaster(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonShishoMaster(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7052KoseiShichosonShishoMasterEntityにセットされている() {
            sut = new KoseiShichosonShishoMaster(主キー名1, 主キー名2);
            assertThat(sut.get市町村コード(), is(主キー名1));
            assertThat(sut.get支所コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKoseiShichosonShishoMasterIdentifierにセットされている() {
            sut = new KoseiShichosonShishoMaster(主キー名1, 主キー名2);
            assertThat(sut.identifier().get市町村コード(), is(主キー名1));
            assertThat(sut.identifier().get支所コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoseiShichosonShishoMaster(null);
        }

        @Test
        public void 指定したDbT7052KoseiShichosonShishoMasterEntityのキー情報を識別子が持つ() {

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);

            assertThat(sut.identifier().get市町村コード(), is(主キー名1));
            assertThat(sut.identifier().get支所コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);

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
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);

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
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoseiShichosonShishoMaster sut;
        private static KoseiShichosonShishoMaster result;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(主キー名1);
            KoseiShichosonShishoMasterEntity.setShishoCode(主キー名2);

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
