/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5304ShujiiIkenshoIkenItemEntityGenerator;
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
 * {@link ShujiiIkenshoIkenItem}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIkenItemTest extends DbzTestBase {

    private static DbT5304ShujiiIkenshoIkenItemEntity ShujiiIkenshoIkenItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoIkenItem(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoIkenItem(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5304ShujiiIkenshoIkenItemEntityにセットされている() {
            sut = new ShujiiIkenshoIkenItem(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShujiiIkenshoIkenItemIdentifierにセットされている() {
            sut = new ShujiiIkenshoIkenItem(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIkenshoIkenItem(null);
        }

        @Test
        public void 指定したDbT5304ShujiiIkenshoIkenItemEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();

            sut = new ShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(ShujiiIkenshoIkenItemEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(ShujiiIkenshoIkenItemEntity.getIkenshoIraiRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShujiiIkenshoIkenItemEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(ShujiiIkenshoIkenItemEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get意見項目は_entityが持つ意見項目を返す() {
            assertThat(sut.get意見項目(), is(ShujiiIkenshoIkenItemEntity.getIkenItem()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();

            sut = new ShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIkenshoIkenItemEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();

            sut = new ShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiIkenshoIkenItem sut;
        private static ShujiiIkenshoIkenItem result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIkenItemEntity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();

        }

        @Test
        public void ShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIkenItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoIkenItem(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIkenItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoIkenItem(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIkenItemが返る() {
            sut = TestSupport.setStateShujiiIkenshoIkenItem(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIkenshoIkenItemが保持するDbT5304ShujiiIkenshoIkenItemEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIkenshoIkenItem(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIkenshoIkenItem setStateShujiiIkenshoIkenItem(EntityDataState parentState) {
            ShujiiIkenshoIkenItemEntity.setState(parentState);
            return new ShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemEntity);
        }
    }
}
