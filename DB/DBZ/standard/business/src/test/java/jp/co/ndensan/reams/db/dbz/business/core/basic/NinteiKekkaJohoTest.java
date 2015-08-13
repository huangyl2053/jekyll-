/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKekkaJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiKekkaJohoTest extends DbzTestBase {

    private static DbT5102NinteiKekkaJohoEntity NinteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new NinteiKekkaJoho(申請書管理番号);
        }

        @Test
        public void 指定したキーが保持するDbT5102NinteiKekkaJohoEntityにセットされている() {
            sut = new NinteiKekkaJoho(申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 指定したキーが保持するNinteiKekkaJohoIdentifierにセットされている() {
            sut = new NinteiKekkaJoho(申請書管理番号);
//            assertThat(sut.identifier().getXXX(), is(申請書管理番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            申請書管理番号 = null;
            sut = new NinteiKekkaJoho(申請書管理番号);
        }

        @Test
        public void 指定したDbT5102NinteiKekkaJohoEntityのキー情報を識別子が持つ() {

            sut = new NinteiKekkaJoho(NinteiKekkaJohoEntity);

//            assertThat(sut.identifier().getXXX(), is(申請書管理番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();

            sut = new NinteiKekkaJoho(NinteiKekkaJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteiKekkaJohoEntity.getShinseishoKanriNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();

            sut = new NinteiKekkaJoho(NinteiKekkaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteiKekkaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();

            sut = new NinteiKekkaJoho(NinteiKekkaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteiKekkaJoho sut;
        private static NinteiKekkaJoho result;

        @BeforeClass
        public static void setUpClass() {
            NinteiKekkaJohoEntity = DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity();

        }

        @Test
        public void NinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたNinteiKekkaJohoが返る() {
            sut = TestSupport.setStateNinteiKekkaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたNinteiKekkaJohoが返る() {
            sut = TestSupport.setStateNinteiKekkaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたNinteiKekkaJohoが返る() {
            sut = TestSupport.setStateNinteiKekkaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteiKekkaJohoが保持するDbT5102NinteiKekkaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteiKekkaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteiKekkaJoho setStateNinteiKekkaJoho(EntityDataState parentState) {
            NinteiKekkaJohoEntity.setState(parentState);
            return new NinteiKekkaJoho(NinteiKekkaJohoEntity);
        }
    }
}
