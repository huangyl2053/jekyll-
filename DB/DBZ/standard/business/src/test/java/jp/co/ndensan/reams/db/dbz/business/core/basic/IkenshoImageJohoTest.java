/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5305IkenshoImageJohoEntityGenerator;
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
 * {@link IkenshoImageJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IkenshoImageJohoTest extends DbzTestBase {

    private static DbT5305IkenshoImageJohoEntity IkenshoImageJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new IkenshoImageJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new IkenshoImageJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5305IkenshoImageJohoEntityにセットされている() {
            sut = new IkenshoImageJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するIkenshoImageJohoIdentifierにセットされている() {
            sut = new IkenshoImageJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new IkenshoImageJoho(null);
        }

        @Test
        public void 指定したDbT5305IkenshoImageJohoEntityのキー情報を識別子が持つ() {

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(IkenshoImageJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(IkenshoImageJohoEntity.getIraiRirekiNo()));
        }

        @Test
        public void get帳票IDは_entityが持つ帳票IDを返す() {
            assertThat(sut.get帳票ID(), is(IkenshoImageJohoEntity.getChoyoID()));
        }

        @Test
        public void getマスキングデータ区分は_entityが持つマスキングデータ区分を返す() {
            assertThat(sut.getマスキングデータ区分(), is(IkenshoImageJohoEntity.getMaskDataKubun()));
        }

        @Test
        public void get取込みページ番号は_entityが持つ取込みページ番号を返す() {
            assertThat(sut.get取込みページ番号(), is(IkenshoImageJohoEntity.getTorikomiPageNo()));
        }

        @Test
        public void get認定申請年は_entityが持つ認定申請年を返す() {
            assertThat(sut.get認定申請年(), is(IkenshoImageJohoEntity.getNinteiShinseiNen()));
        }

        @Test
        public void get共有ファイルIDは_entityが持つ共有ファイルIDを返す() {
            assertThat(sut.get共有ファイルID(), is(IkenshoImageJohoEntity.getSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(IkenshoImageJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;
        private static IkenshoImageJoho result;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static IkenshoImageJoho setStateIkenshoImageJoho(EntityDataState parentState) {
            IkenshoImageJohoEntity.setState(parentState);
            return new IkenshoImageJoho(IkenshoImageJohoEntity);
        }
    }
}
