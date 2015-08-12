/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5303ShujiiIkenshoKinyuItemEntityGenerator;
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
 * {@link ShujiiIkenshoKinyuItem}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoKinyuItemTest extends DbzTestBase {

    private static DbT5303ShujiiIkenshoKinyuItemEntity ShujiiIkenshoKinyuItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoKinyuItem(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoKinyuItem(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5303ShujiiIkenshoKinyuItemEntityにセットされている() {
            sut = new ShujiiIkenshoKinyuItem(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShujiiIkenshoKinyuItemIdentifierにセットされている() {
            sut = new ShujiiIkenshoKinyuItem(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIkenshoKinyuItem(null);
        }

        @Test
        public void 指定したDbT5303ShujiiIkenshoKinyuItemEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();

            sut = new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(ShujiiIkenshoKinyuItemEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(ShujiiIkenshoKinyuItemEntity.getIkenshoIraiRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShujiiIkenshoKinyuItemEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(ShujiiIkenshoKinyuItemEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get記入項目は_entityが持つ記入項目を返す() {
            assertThat(sut.get記入項目(), is(ShujiiIkenshoKinyuItemEntity.getKinyuItem()));
        }

        @Test
        public void get記入項目イメージ共有ファイルIDは_entityが持つ記入項目イメージ共有ファイルIDを返す() {
            assertThat(sut.get記入項目イメージ共有ファイルID(), is(ShujiiIkenshoKinyuItemEntity.getKinyuItemImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();

            sut = new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIkenshoKinyuItemEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();

            sut = new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiIkenshoKinyuItem sut;
        private static ShujiiIkenshoKinyuItem result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoKinyuItemEntity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();

        }

        @Test
        public void ShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoKinyuItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoKinyuItem(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoKinyuItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoKinyuItem(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoKinyuItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoKinyuItem(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIkenshoKinyuItemが保持するDbT5303ShujiiIkenshoKinyuItemEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIkenshoKinyuItem(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIkenshoKinyuItem setStateShujiiIkenshoKinyuItem(EntityDataState parentState) {
            ShujiiIkenshoKinyuItemEntity.setState(parentState);
            return new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);
        }
    }
}
