/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5508ShinsakaiJizenKekkaJohoEntityGenerator;
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
 * {@link ShinsakaiJizenKekkaJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiJizenKekkaJohoTest extends DbeTestBase {

    private static DbT5508ShinsakaiJizenKekkaJohoEntity ShinsakaiJizenKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinsakaiJizenKekkaJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinsakaiJizenKekkaJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5508ShinsakaiJizenKekkaJohoEntityにセットされている() {
            sut = new ShinsakaiJizenKekkaJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShinsakaiJizenKekkaJohoIdentifierにセットされている() {
            sut = new ShinsakaiJizenKekkaJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinsakaiJizenKekkaJoho(null);
        }

        @Test
        public void 指定したDbT5508ShinsakaiJizenKekkaJohoEntityのキー情報を識別子が持つ() {

            sut = new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();

            sut = new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);
        }

        @Test
        public void get介護認定審査会開催番号は_entityが持つ介護認定審査会開催番号を返す() {
            assertThat(sut.get介護認定審査会開催番号(), is(ShinsakaiJizenKekkaJohoEntity.getShinsakaiKaisaiNo()));
        }

        @Test
        public void get介護認定審査会委員コードは_entityが持つ介護認定審査会委員コードを返す() {
            assertThat(sut.get介護認定審査会委員コード(), is(ShinsakaiJizenKekkaJohoEntity.getShinsakaiIinCode()));
        }

        @Test
        public void get介護認定審査会審査順は_entityが持つ介護認定審査会審査順を返す() {
            assertThat(sut.get介護認定審査会審査順(), is(ShinsakaiJizenKekkaJohoEntity.getShinsakaiOrder()));
        }

        @Test
        public void get一次判定結果変更理由は_entityが持つ一次判定結果変更理由を返す() {
            assertThat(sut.get一次判定結果変更理由(), is(ShinsakaiJizenKekkaJohoEntity.getIchijiHanteiHenkoRiyu()));
        }

        @Test
        public void get二次判定結果コードは_entityが持つ二次判定結果コードを返す() {
            assertThat(sut.get二次判定結果コード(), is(ShinsakaiJizenKekkaJohoEntity.getNijiHanteiKekkaCode()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();

            sut = new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinsakaiJizenKekkaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();

            sut = new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static ShinsakaiJizenKekkaJoho sut;
        private static ShinsakaiJizenKekkaJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShinsakaiJizenKekkaJohoEntity = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.createDbT5508ShinsakaiJizenKekkaJohoEntity();

        }

        @Test
        public void ShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiJizenKekkaJohoが返る() {
            sut = TestSupport.setStateShinsakaiJizenKekkaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiJizenKekkaJohoが返る() {
            sut = TestSupport.setStateShinsakaiJizenKekkaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがDeletedに指定されたShinsakaiJizenKekkaJohoが返る() {
            sut = TestSupport.setStateShinsakaiJizenKekkaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinsakaiJizenKekkaJohoが保持するDbT5508ShinsakaiJizenKekkaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinsakaiJizenKekkaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinsakaiJizenKekkaJoho setStateShinsakaiJizenKekkaJoho(EntityDataState parentState) {
            ShinsakaiJizenKekkaJohoEntity.setState(parentState);
            return new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);
        }
    }
}
