/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5205NinteichosahyoTokkijikoEntityGenerator;
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
 * {@link NinteichosahyoTokkijiko}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTokkijikoTest extends DbzTestBase {

    private static DbT5205NinteichosahyoTokkijikoEntity NinteichosahyoTokkijikoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoTokkijiko(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoTokkijiko(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5205NinteichosahyoTokkijikoEntityにセットされている() {
            sut = new NinteichosahyoTokkijiko(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoTokkijikoIdentifierにセットされている() {
            sut = new NinteichosahyoTokkijiko(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoTokkijiko(null);
        }

        @Test
        public void 指定したDbT5205NinteichosahyoTokkijikoEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();

            sut = new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoTokkijikoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoTokkijikoEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get認定調査特記事項番号は_entityが持つ認定調査特記事項番号を返す() {
            assertThat(sut.get認定調査特記事項番号(), is(NinteichosahyoTokkijikoEntity.getNinteichosaTokkijikoNo()));
        }

        @Test
        public void get認定調査特記事項連番は_entityが持つ認定調査特記事項連番を返す() {
            assertThat(sut.get認定調査特記事項連番(), is(NinteichosahyoTokkijikoEntity.getNinteichosaTokkijikoRenban()));
        }

        @Test
        public void get特記事項テキスト_イメージ区分は_entityが持つ特記事項テキスト_イメージ区分を返す() {
            assertThat(sut.get特記事項テキスト_イメージ区分(), is(NinteichosahyoTokkijikoEntity.getTokkijikoTextImageKubun()));
        }

        @Test
        public void get原本マスク区分は_entityが持つ原本マスク区分を返す() {
            assertThat(sut.get原本マスク区分(), is(NinteichosahyoTokkijikoEntity.getGenponMaskKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();

            sut = new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoTokkijikoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();

            sut = new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoTokkijiko sut;
        private static NinteichosahyoTokkijiko result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoTokkijikoEntity = DbT5205NinteichosahyoTokkijikoEntityGenerator.createDbT5205NinteichosahyoTokkijikoEntity();

        }

        @Test
        public void NinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoTokkijikoが返る() {
            sut = TestSupport.setStateNinteichosahyoTokkijiko(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoTokkijikoが返る() {
            sut = TestSupport.setStateNinteichosahyoTokkijiko(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoTokkijikoが返る() {
            sut = TestSupport.setStateNinteichosahyoTokkijiko(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoTokkijikoが保持するDbT5205NinteichosahyoTokkijikoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoTokkijiko(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoTokkijiko setStateNinteichosahyoTokkijiko(EntityDataState parentState) {
            NinteichosahyoTokkijikoEntity.setState(parentState);
            return new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);
        }
    }
}
