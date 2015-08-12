/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5209NinteichosahyoKinyuItemEntityGenerator;
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
 * {@link NinteichosahyoKinyuItem}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKinyuItemTest extends DbzTestBase {

    private static DbT5209NinteichosahyoKinyuItemEntity NinteichosahyoKinyuItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5209NinteichosahyoKinyuItemEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5209NinteichosahyoKinyuItemEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKinyuItem(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKinyuItem(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5209NinteichosahyoKinyuItemEntityにセットされている() {
            sut = new NinteichosahyoKinyuItem(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoKinyuItemIdentifierにセットされている() {
            sut = new NinteichosahyoKinyuItem(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoKinyuItem(null);
        }

        @Test
        public void 指定したDbT5209NinteichosahyoKinyuItemEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoKinyuItem(NinteichosahyoKinyuItemEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();

            sut = new NinteichosahyoKinyuItem(NinteichosahyoKinyuItemEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoKinyuItemEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoKinyuItemEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoKinyuItemEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoKinyuItemEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void getサービスの状況記入は_entityが持つサービスの状況記入を返す() {
            assertThat(sut.getサービスの状況記入(), is(NinteichosahyoKinyuItemEntity.getServiceJokyoKinyu()));
        }

        @Test
        public void getサービスの状況イメージ共有ファイルIDは_entityが持つサービスの状況イメージ共有ファイルIDを返す() {
            assertThat(sut.getサービスの状況イメージ共有ファイルID(), is(NinteichosahyoKinyuItemEntity.getServiceJokyoImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();

            sut = new NinteichosahyoKinyuItem(NinteichosahyoKinyuItemEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoKinyuItemEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();

            sut = new NinteichosahyoKinyuItem(NinteichosahyoKinyuItemEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoKinyuItem sut;
        private static NinteichosahyoKinyuItem result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKinyuItemEntity = DbT5209NinteichosahyoKinyuItemEntityGenerator.createDbT5209NinteichosahyoKinyuItemEntity();

        }

        @Test
        public void NinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKinyuItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKinyuItem(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKinyuItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKinyuItem(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKinyuItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKinyuItem(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoKinyuItemが保持するDbT5209NinteichosahyoKinyuItemEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoKinyuItem(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoKinyuItem setStateNinteichosahyoKinyuItem(EntityDataState parentState) {
            NinteichosahyoKinyuItemEntity.setState(parentState);
            return new NinteichosahyoKinyuItem(NinteichosahyoKinyuItemEntity);
        }
    }
}
