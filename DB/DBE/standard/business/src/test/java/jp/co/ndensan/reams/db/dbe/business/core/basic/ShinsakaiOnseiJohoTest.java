/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link ShinsakaiOnseiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShinsakaiOnseiJohoTest extends DbeTestBase {

    private static DbT5512ShinsakaiOnseiJohoEntity ShinsakaiOnseiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 介護認定審査会開催番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        介護認定審査会開催番号 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
        連番 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJohoEntity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test
        public void 指定したキーが保持するDbT5512ShinsakaiOnseiJohoEntityにセットされている() {
            sut = new ShinsakaiOnseiJoho(介護認定審査会開催番号, 連番);
            assertThat(sut.get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.get連番(), is(連番));
        }

        @Test
        public void 指定したキーが保持するShinsakaiOnseiJohoIdentifierにセットされている() {
            sut = new ShinsakaiOnseiJoho(介護認定審査会開催番号, 連番);
            assertThat(sut.identifier().get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.identifier().get連番(), is(連番));
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

            assertThat(sut.identifier().get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.identifier().get連番(), is(連番));
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
