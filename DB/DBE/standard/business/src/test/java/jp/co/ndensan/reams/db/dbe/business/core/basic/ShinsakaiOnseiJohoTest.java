/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
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
 * {@link ShinsakaiOnseiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiOnseiJohoTest extends DbeTestBase {

    private static DbT5512ShinsakaiOnseiJohoEntity ShinsakaiOnseiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinsakaiOnseiJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinsakaiOnseiJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5512ShinsakaiOnseiJohoEntityにセットされている() {
            sut = new ShinsakaiOnseiJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShinsakaiOnseiJohoIdentifierにセットされている() {
            sut = new ShinsakaiOnseiJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinsakaiOnseiJoho(null);
        }

        @Test
        public void 指定したDbT5512ShinsakaiOnseiJohoEntityのキー情報を識別子が持つ() {

            sut = new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);
        }

        @Test
        public void get介護認定審査会開催番号は_entityが持つ介護認定審査会開催番号を返す() {
            assertThat(sut.get介護認定審査会開催番号(), is(ShinsakaiOnseiJohoEntity.getShinsakaiKaisaiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShinsakaiOnseiJohoEntity.getRenban()));
        }

        @Test
        public void get審査会音声ファイルは_entityが持つ審査会音声ファイルを返す() {
            assertThat(sut.get審査会音声ファイル(), is(ShinsakaiOnseiJohoEntity.getShinsakaiOnseiFile()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinsakaiOnseiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;
        private static ShinsakaiOnseiJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

        }

        @Test
        public void ShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJohoが返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJohoが返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJohoが返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinsakaiOnseiJohoが保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinsakaiOnseiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinsakaiOnseiJoho setStateShinsakaiOnseiJoho(EntityDataState parentState) {
            ShinsakaiOnseiJohoEntity.setState(parentState);
            return new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);
        }
    }
}
