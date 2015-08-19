/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5115ImageEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Image}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ImageTest extends DbzTestBase {

    private static DbT5115ImageEntity ImageEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 取込ページ番号;
    private static Code 原本マスク分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
        取込ページ番号 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
        原本マスク分 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Image(null, 取込ページ番号, 原本マスク分);
        }

        @Test(expected = NullPointerException.class)
        public void 原本マスク分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Image(申請書管理番号, 取込ページ番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT5115ImageEntityにセットされている() {
            sut = new Image(申請書管理番号, 取込ページ番号, 原本マスク分);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get原本マスク分(), is(原本マスク分));
        }

        @Test
        public void 指定したキーが保持するImageIdentifierにセットされている() {
            sut = new Image(申請書管理番号, 取込ページ番号, 原本マスク分);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get原本マスク分(), is(原本マスク分));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Image(null);
        }

        @Test
        public void 指定したDbT5115ImageEntityのキー情報を識別子が持つ() {

            sut = new Image(ImageEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get原本マスク分(), is(原本マスク分));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(ImageEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(ImageEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get取込ページ番号は_entityが持つ取込ページ番号を返す() {
            assertThat(sut.get取込ページ番号(), is(ImageEntity.getTorikomiPageNo()));
        }

        @Test
        public void get原本マスク分は_entityが持つ原本マスク分を返す() {
            assertThat(sut.get原本マスク分(), is(ImageEntity.getGenponMaskKubun()));
        }

        @Test
        public void getイメージ共有ファイルIDは_entityが持つイメージ共有ファイルIDを返す() {
            assertThat(sut.getイメージ共有ファイルID(), is(ImageEntity.getImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(ImageEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ImageEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static Image sut;

        @BeforeClass
        public static void setUpClass() {
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

            sut = new Image(ImageEntity);
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
            ImageEntity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();

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
            ImageEntity.setState(parentState);
            return new Image(ImageEntity);
        }
    }
}
