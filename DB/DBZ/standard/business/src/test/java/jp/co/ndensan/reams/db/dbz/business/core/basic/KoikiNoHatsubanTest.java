/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7025KoikiNoHatsubanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KoikiNoHatsuban}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiNoHatsubanTest extends DbzTestBase {

    private static DbT7025KoikiNoHatsubanEntity KoikiNoHatsubanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiNoHatsuban(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiNoHatsuban(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7025KoikiNoHatsubanEntityにセットされている() {
            sut = new KoikiNoHatsuban(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKoikiNoHatsubanIdentifierにセットされている() {
            sut = new KoikiNoHatsuban(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoikiNoHatsuban(null);
        }

        @Test
        public void 指定したDbT7025KoikiNoHatsubanEntityのキー情報を識別子が持つ() {

            sut = new KoikiNoHatsuban(KoikiNoHatsubanEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);

            sut = new KoikiNoHatsuban(KoikiNoHatsubanEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KoikiNoHatsubanEntity.getShichosonCode()));
        }

        @Test
        public void getコード区分は_entityが持つコード区分を返す() {
            assertThat(sut.getコード区分(), is(KoikiNoHatsubanEntity.getCodeKubun()));
        }

        @Test
        public void get番号は_entityが持つ番号を返す() {
            assertThat(sut.get番号(), is(KoikiNoHatsubanEntity.getNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);

            sut = new KoikiNoHatsuban(KoikiNoHatsubanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoikiNoHatsubanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);

            sut = new KoikiNoHatsuban(KoikiNoHatsubanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoikiNoHatsuban sut;
        private static KoikiNoHatsuban result;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = DbT7025KoikiNoHatsubanEntityGenerator.createDbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);

        }

        @Test
        public void KoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがDeletedに指定されたKoikiNoHatsubanが返る() {
            sut = TestSupport.setStateKoikiNoHatsuban(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがDeletedに指定されたKoikiNoHatsubanが返る() {
            sut = TestSupport.setStateKoikiNoHatsuban(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがDeletedに指定されたKoikiNoHatsubanが返る() {
            sut = TestSupport.setStateKoikiNoHatsuban(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoikiNoHatsubanが保持するDbT7025KoikiNoHatsubanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoikiNoHatsuban(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KoikiNoHatsuban setStateKoikiNoHatsuban(EntityDataState parentState) {
            KoikiNoHatsubanEntity.setState(parentState);
            return new KoikiNoHatsuban(KoikiNoHatsubanEntity);
        }
    }
}
