/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5123NinteiKeikakuJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
 * {@link NinteiKeikakuJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NinteiKeikakuJohoTest extends DbeTestBase {

    private static DbT5123NinteiKeikakuJohoEntity NinteiKeikakuJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5123NinteiKeikakuJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new NinteiKeikakuJoho(申請書管理番号);
        }

        @Test
        public void 指定したキーが保持するDbT5123NinteiKeikakuJohoEntityにセットされている() {
            sut = new NinteiKeikakuJoho(申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 指定したキーが保持するNinteiKeikakuJohoIdentifierにセットされている() {
            sut = new NinteiKeikakuJoho(申請書管理番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            申請書管理番号 = null;
            sut = new NinteiKeikakuJoho(申請書管理番号);
        }

        @Test
        public void 指定したDbT5123NinteiKeikakuJohoEntityのキー情報を識別子が持つ() {

            sut = new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();

            sut = new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteiKeikakuJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼予定年月日は_entityが持つ認定調査依頼予定年月日を返す() {
            assertThat(sut.get認定調査依頼予定年月日(), is(NinteiKeikakuJohoEntity.getNinteichosaIraiYoteiYMD()));
        }

        @Test
        public void get認定調査予定年月日は_entityが持つ認定調査予定年月日を返す() {
            assertThat(sut.get認定調査予定年月日(), is(NinteiKeikakuJohoEntity.getNinteichosaYoteiYMD()));
        }

        @Test
        public void get主治医意見書作成依頼予定年月日は_entityが持つ主治医意見書作成依頼予定年月日を返す() {
            assertThat(sut.get主治医意見書作成依頼予定年月日(), is(NinteiKeikakuJohoEntity.getIkenshoSakuseiIraiYoteiYMD()));
        }

        @Test
        public void get主治医意見書登録予定年月日は_entityが持つ主治医意見書登録予定年月日を返す() {
            assertThat(sut.get主治医意見書登録予定年月日(), is(NinteiKeikakuJohoEntity.getIkenshoTorokuYoteiYMD()));
        }

        @Test
        public void get要介護認定一次判定予定年月日は_entityが持つ要介護認定一次判定予定年月日を返す() {
            assertThat(sut.get要介護認定一次判定予定年月日(), is(NinteiKeikakuJohoEntity.getIchijiHanteiYoteiYMD()));
        }

        @Test
        public void get要介護認定1_5次判定予定年月日は_entityが持つ要介護認定1_5次判定予定年月日を返す() {
            assertThat(sut.get要介護認定1_5次判定予定年月日(), is(NinteiKeikakuJohoEntity.getIchiGoHanteiYoteiYMD()));
        }

        @Test
        public void get認定審査会割当予定年月日は_entityが持つ認定審査会割当予定年月日を返す() {
            assertThat(sut.get認定審査会割当予定年月日(), is(NinteiKeikakuJohoEntity.getNinteiShinsakaiWariateYoteiYMD()));
        }

        @Test
        public void get認定審査会予定年月日は_entityが持つ認定審査会予定年月日を返す() {
            assertThat(sut.get認定審査会予定年月日(), is(NinteiKeikakuJohoEntity.getNinteiShinsakaiYoteiYMD()));
        }

        @Test
        public void getセンター送信予定年月日は_entityが持つセンター送信予定年月日を返す() {
            assertThat(sut.getセンター送信予定年月日(), is(NinteiKeikakuJohoEntity.getCenterSoshinYoteiYMD()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();

            sut = new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteiKeikakuJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();

            sut = new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static NinteiKeikakuJoho sut;
        private static NinteiKeikakuJoho result;

        @BeforeClass
        public static void setUpClass() {
            NinteiKeikakuJohoEntity = DbT5123NinteiKeikakuJohoEntityGenerator.createDbT5123NinteiKeikakuJohoEntity();

        }

        @Test
        public void NinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがDeletedに指定されたNinteiKeikakuJohoが返る() {
            sut = TestSupport.setStateNinteiKeikakuJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがDeletedに指定されたNinteiKeikakuJohoが返る() {
            sut = TestSupport.setStateNinteiKeikakuJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがDeletedに指定されたNinteiKeikakuJohoが返る() {
            sut = TestSupport.setStateNinteiKeikakuJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteiKeikakuJohoが保持するDbT5123NinteiKeikakuJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteiKeikakuJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteiKeikakuJoho setStateNinteiKeikakuJoho(EntityDataState parentState) {
            NinteiKeikakuJohoEntity.setState(parentState);
            return new NinteiKeikakuJoho(NinteiKeikakuJohoEntity);
        }
    }
}
