/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMaster}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterTest extends DbeTestBase {

    private static DbT5051KoseiShichosonMasterEntity KoseiShichosonMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonMaster(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonMaster(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5051KoseiShichosonMasterEntityにセットされている() {
            sut = new KoseiShichosonMaster(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKoseiShichosonMasterIdentifierにセットされている() {
            sut = new KoseiShichosonMaster(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoseiShichosonMaster(null);
        }

        @Test
        public void 指定したDbT5051KoseiShichosonMasterEntityのキー情報を識別子が持つ() {

            sut = new KoseiShichosonMaster(KoseiShichosonMasterEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();

            sut = new KoseiShichosonMaster(KoseiShichosonMasterEntity);
        }

        @Test
        public void get市町村識別IDは_entityが持つ市町村識別IDを返す() {
            assertThat(sut.get市町村識別ID(), is(KoseiShichosonMasterEntity.getShichosonShokibetsuID()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();

            sut = new KoseiShichosonMaster(KoseiShichosonMasterEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoseiShichosonMasterEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();

            sut = new KoseiShichosonMaster(KoseiShichosonMasterEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static KoseiShichosonMaster sut;
        private static KoseiShichosonMaster result;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonMasterEntity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();

        }

        @Test
        public void KoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoseiShichosonMasterが保持するDbT5051KoseiShichosonMasterEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KoseiShichosonMaster setStateKoseiShichosonMaster(EntityDataState parentState) {
            KoseiShichosonMasterEntity.setState(parentState);
            return new KoseiShichosonMaster(KoseiShichosonMasterEntity);
        }
    }
}
