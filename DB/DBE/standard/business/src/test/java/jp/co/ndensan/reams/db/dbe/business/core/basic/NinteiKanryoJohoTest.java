/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5105NinteiKanryoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKanryoJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NinteiKanryoJohoTest extends DbeTestBase {

    private static DbT5105NinteiKanryoJohoEntity NinteiKanryoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    //private static 主キー型1 主キー名1;
    //private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        //主キー名1 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主キー名1;
        //主キー名2 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            //sut = new NinteiKanryoJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            //sut = new NinteiKanryoJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5105NinteiKanryoJohoEntityにセットされている() {
            //sut = new NinteiKanryoJoho(主キー名1, 主キー名2);
            //assertThat(sut.get主キー名1(), is(主キー名1));
            //assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteiKanryoJohoIdentifierにセットされている() {
            //sut = new NinteiKanryoJoho(主キー名1, 主キー名2);
            //assertThat(sut.identifier().getXXX(), is(主キー名1));
            //assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
//            /sut = new NinteiKanryoJoho(null);
        }

        @Test
        public void 指定したDbT5105NinteiKanryoJohoEntityのキー情報を識別子が持つ() {

            sut = new NinteiKanryoJoho(NinteiKanryoJohoEntity);

            //assertThat(sut.identifier().getXXX(), is(主キー名1));
            //assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();

            sut = new NinteiKanryoJoho(NinteiKanryoJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteiKanryoJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定申請情報登録完了年月日は_entityが持つ認定申請情報登録完了年月日を返す() {
            assertThat(sut.get認定申請情報登録完了年月日(), is(NinteiKanryoJohoEntity.getNinteiShinseiJohoTorokuKanryoYMD()));
        }

        @Test
        public void get認定調査依頼完了年月日は_entityが持つ認定調査依頼完了年月日を返す() {
            assertThat(sut.get認定調査依頼完了年月日(), is(NinteiKanryoJohoEntity.getNinteichosaIraiKanryoYMD()));
        }

        @Test
        public void get認定調査完了年月日は_entityが持つ認定調査完了年月日を返す() {
            assertThat(sut.get認定調査完了年月日(), is(NinteiKanryoJohoEntity.getNinteichosaKanryoYMD()));
        }

        @Test
        public void get主治医意見書作成依頼完了年月日は_entityが持つ主治医意見書作成依頼完了年月日を返す() {
            assertThat(sut.get主治医意見書作成依頼完了年月日(), is(NinteiKanryoJohoEntity.getIkenshoSakuseiIraiKanryoYMD()));
        }

        @Test
        public void get主治医意見書登録完了年月日は_entityが持つ主治医意見書登録完了年月日を返す() {
            assertThat(sut.get主治医意見書登録完了年月日(), is(NinteiKanryoJohoEntity.getIkenshoTorokuKanryoYMD()));
        }

        @Test
        public void get要介護認定一次判定完了年月日は_entityが持つ要介護認定一次判定完了年月日を返す() {
            assertThat(sut.get要介護認定一次判定完了年月日(), is(NinteiKanryoJohoEntity.getIchijiHanteiKanryoYMD()));
        }

        @Test
        public void getマスキング完了年月日は_entityが持つマスキング完了年月日を返す() {
            assertThat(sut.getマスキング完了年月日(), is(NinteiKanryoJohoEntity.getMaskingKanryoYMD()));
        }

        @Test
        public void get認定審査会割当完了年月日は_entityが持つ認定審査会割当完了年月日を返す() {
            assertThat(sut.get認定審査会割当完了年月日(), is(NinteiKanryoJohoEntity.getNinteiShinsakaiWariateKanryoYMD()));
        }

        @Test
        public void get認定審査会完了年月日は_entityが持つ認定審査会完了年月日を返す() {
            assertThat(sut.get認定審査会完了年月日(), is(NinteiKanryoJohoEntity.getNinteiShinsakaiKanryoYMD()));
        }

        @Test
        public void getセンター送信年月日は_entityが持つセンター送信年月日を返す() {
            assertThat(sut.getセンター送信年月日(), is(NinteiKanryoJohoEntity.getCenterSoshinYMD()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();

            sut = new NinteiKanryoJoho(NinteiKanryoJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteiKanryoJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();

            sut = new NinteiKanryoJoho(NinteiKanryoJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            //assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static NinteiKanryoJoho sut;
        private static NinteiKanryoJoho result;

        @BeforeClass
        public static void setUpClass() {
            NinteiKanryoJohoEntity = DbT5105NinteiKanryoJohoEntityGenerator.createDbT5105NinteiKanryoJohoEntity();

        }

        @Test
        public void NinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがDeletedに指定されたNinteiKanryoJohoが返る() {
            sut = TestSupport.setStateNinteiKanryoJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがDeletedに指定されたNinteiKanryoJohoが返る() {
            sut = TestSupport.setStateNinteiKanryoJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがDeletedに指定されたNinteiKanryoJohoが返る() {
            sut = TestSupport.setStateNinteiKanryoJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteiKanryoJohoが保持するDbT5105NinteiKanryoJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteiKanryoJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteiKanryoJoho setStateNinteiKanryoJoho(EntityDataState parentState) {
            NinteiKanryoJohoEntity.setState(parentState);
            return new NinteiKanryoJoho(NinteiKanryoJohoEntity);
        }
    }
}
