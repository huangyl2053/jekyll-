/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5211NinteichosahyoChosaItemEntityGenerator;
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
 * {@link NinteichosahyoChosaItem}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoChosaItemTest extends DbzTestBase {

    private static DbT5211NinteichosahyoChosaItemEntity NinteichosahyoChosaItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5211NinteichosahyoChosaItemEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoChosaItem(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoChosaItem(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5211NinteichosahyoChosaItemEntityにセットされている() {
            sut = new NinteichosahyoChosaItem(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoChosaItemIdentifierにセットされている() {
            sut = new NinteichosahyoChosaItem(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoChosaItem(null);
        }

        @Test
        public void 指定したDbT5211NinteichosahyoChosaItemEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoChosaItem(NinteichosahyoChosaItemEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();

            sut = new NinteichosahyoChosaItem(NinteichosahyoChosaItemEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoChosaItemEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get要介護認定調査履歴番号は_entityが持つ要介護認定調査履歴番号を返す() {
            assertThat(sut.get要介護認定調査履歴番号(), is(NinteichosahyoChosaItemEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoChosaItemEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoChosaItemEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get調査項目は_entityが持つ調査項目を返す() {
            assertThat(sut.get調査項目(), is(NinteichosahyoChosaItemEntity.getReserchItem()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();

            sut = new NinteichosahyoChosaItem(NinteichosahyoChosaItemEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoChosaItemEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();

            sut = new NinteichosahyoChosaItem(NinteichosahyoChosaItemEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoChosaItem sut;
        private static NinteichosahyoChosaItem result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoChosaItemEntity = DbT5211NinteichosahyoChosaItemEntityGenerator.createDbT5211NinteichosahyoChosaItemEntity();

        }

        @Test
        public void NinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoChosaItemが返る() {
            sut = TestSupport.setStateNinteichosahyoChosaItem(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoChosaItemが返る() {
            sut = TestSupport.setStateNinteichosahyoChosaItem(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoChosaItemが返る() {
            sut = TestSupport.setStateNinteichosahyoChosaItem(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoChosaItemが保持するDbT5211NinteichosahyoChosaItemEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoChosaItem(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoChosaItem setStateNinteichosahyoChosaItem(EntityDataState parentState) {
            NinteichosahyoChosaItemEntity.setState(parentState);
            return new NinteichosahyoChosaItem(NinteichosahyoChosaItemEntity);
        }
    }
}
