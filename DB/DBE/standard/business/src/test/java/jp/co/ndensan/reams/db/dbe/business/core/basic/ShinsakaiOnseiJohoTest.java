/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
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
 * {@link ShinsakaiOnseiJoho2}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShinsakaiOnseiJohoTest extends DbeTestBase {

    private static DbT5512ShinsakaiOnseiJohoEntity ShinsakaiOnseiJoho2Entity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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

        private static ShinsakaiOnseiJoho2 sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test
        public void 指定したキーが保持するDbT5512ShinsakaiOnseiJohoEntityにセットされている() {
            sut = new ShinsakaiOnseiJoho2(介護認定審査会開催番号, 連番);
            assertThat(sut.get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.get連番(), is(連番));
        }

        @Test
        public void 指定したキーが保持するShinsakaiOnseiJoho2Identifierにセットされている() {
            sut = new ShinsakaiOnseiJoho2(介護認定審査会開催番号, 連番);
            assertThat(sut.identifier().get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho2 sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinsakaiOnseiJoho2(null);
        }

        @Test
        public void 指定したDbT5512ShinsakaiOnseiJohoEntityのキー情報を識別子が持つ() {

            sut = new ShinsakaiOnseiJoho2(ShinsakaiOnseiJoho2Entity);

            assertThat(sut.identifier().get介護認定審査会開催番号(), is(介護認定審査会開催番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho2 sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho2(ShinsakaiOnseiJoho2Entity);
        }

        @Test
        public void get介護認定審査会開催番号は_entityが持つ介護認定審査会開催番号を返す() {
            assertThat(sut.get介護認定審査会開催番号(), is(ShinsakaiOnseiJoho2Entity.getShinsakaiKaisaiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShinsakaiOnseiJoho2Entity.getRenban()));
        }

        @Test
        public void get審査会音声ファイルは_entityが持つ審査会音声ファイルを返す() {
            assertThat(sut.get審査会音声ファイル(), is(ShinsakaiOnseiJoho2Entity.getShinsakaiOnseiFile()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho2 sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho2(ShinsakaiOnseiJoho2Entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinsakaiOnseiJoho2Entity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho2 sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

            sut = new ShinsakaiOnseiJoho2(ShinsakaiOnseiJoho2Entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static ShinsakaiOnseiJoho2 sut;
        private static ShinsakaiOnseiJoho2 result;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiOnseiJoho2Entity = DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity();

        }

        @Test
        public void ShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJoho2が返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho2(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJoho2が返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho2(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiOnseiJoho2が返る() {
            sut = TestSupport.setStateShinsakaiOnseiJoho2(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinsakaiOnseiJoho2が保持するDbT5512ShinsakaiOnseiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinsakaiOnseiJoho2(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinsakaiOnseiJoho2 setStateShinsakaiOnseiJoho2(EntityDataState parentState) {
            ShinsakaiOnseiJoho2Entity.setState(parentState);
            return new ShinsakaiOnseiJoho2(ShinsakaiOnseiJoho2Entity);
        }
    }
}
