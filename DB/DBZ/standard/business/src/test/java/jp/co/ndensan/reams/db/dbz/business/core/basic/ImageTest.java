/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5115ImageEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link Image}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ImageTest extends DbzTestBase {

    private static DbT5115ImageEntity imageEntity;
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
        申請書管理番号 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Image((ShinseishoKanriNo) null);
        }

        @Test
        public void 指定したキーが保持するDbT5115ImageEntityにセットされている() {
            sut = new Image(申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 指定したキーが保持するImageIdentifierにセットされている() {
            sut = new Image(申請書管理番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Image((ShinseishoKanriNo) null);
        }

        @Test
        public void 指定したDbT5115ImageEntityのキー情報を識別子が持つ() {

            sut = new Image(imageEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(imageEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(imageEntity.getShinseishoKanriNo()));
        }

        @Test
        public void getイメージ共有ファイルIDは_entityが持つイメージ共有ファイルIDを返す() {
            assertThat(sut.getイメージ共有ファイルID(), is(imageEntity.getImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(imageEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(imageEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(imageEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static Image sut;
        private static Image result;

        @BeforeClass
        public static void setUpClass() {
            imageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

        }

        @Test
        public void Imageが保持するDbT5115ImageEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりImageが保持するDbT5115ImageEntityのEntityDataStateがDeletedに指定されたImageが返る() {
            sut = TestSupport.setStateImage(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Imageが保持するDbT5115ImageEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりImageが保持するDbT5115ImageEntityのEntityDataStateがDeletedに指定されたImageが返る() {
            sut = TestSupport.setStateImage(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Imageが保持するDbT5115ImageEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりImageが保持するDbT5115ImageEntityのEntityDataStateがDeletedに指定されたImageが返る() {
            sut = TestSupport.setStateImage(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Imageが保持するDbT5115ImageEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateImage(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Image setStateImage(EntityDataState parentState) {
            imageEntity.setState(parentState);
            return new Image(imageEntity);
        }
    }
}
