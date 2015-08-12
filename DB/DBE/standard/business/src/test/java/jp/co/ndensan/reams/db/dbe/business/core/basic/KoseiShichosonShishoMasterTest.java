/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class KoseiShichosonShishoMasterTest extends DbeTestBase {

    private static DbT5052KoseiShichosonShishoMasterEntity KoseiShichosonShishoMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
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
        public void 指定したキーが保持するDbT5052KoseiShichosonShishoMasterEntityにセットされている() {
            sut = new KoseiShichosonShishoMaster(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKoseiShichosonShishoMasterIdentifierにセットされている() {
            sut = new KoseiShichosonShishoMaster(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoseiShichosonShishoMaster(null);
        }

        @Test
        public void 指定したDbT5052KoseiShichosonShishoMasterEntityのキー情報を識別子が持つ() {

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();

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
    }

    public static class toEntityテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoseiShichosonShishoMasterEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();

            sut = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static KoseiShichosonShishoMaster sut;
        private static KoseiShichosonShishoMaster result;

        @BeforeClass
        public static void setUpClass() {
            KoseiShichosonShishoMasterEntity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();

        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonShishoMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonShishoMaster(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoseiShichosonShishoMasterが保持するDbT5052KoseiShichosonShishoMasterEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
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
