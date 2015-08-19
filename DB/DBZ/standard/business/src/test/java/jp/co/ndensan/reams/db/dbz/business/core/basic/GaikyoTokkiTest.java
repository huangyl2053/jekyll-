/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5206GaikyoTokkiEntityGenerator;
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
 * {@link GaikyoTokki}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GaikyoTokkiTest extends DbzTestBase {

    private static DbT5206GaikyoTokkiEntity gaikyoTokkiEntity;
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
        申請書管理番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GaikyoTokki(null, 認定調査依頼履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5206GaikyoTokkiEntityにセットされている() {
            sut = new GaikyoTokki(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するGaikyoTokkiIdentifierにセットされている() {
            sut = new GaikyoTokki(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GaikyoTokki(null);
        }

        @Test
        public void 指定したDbT5206GaikyoTokkiEntityのキー情報を識別子が持つ() {

            sut = new GaikyoTokki(gaikyoTokkiEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(gaikyoTokkiEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(gaikyoTokkiEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(gaikyoTokkiEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get概況特記事項_主訴は_entityが持つ概況特記事項_主訴を返す() {
            assertThat(sut.get概況特記事項_主訴(), is(gaikyoTokkiEntity.getShuso()));
        }

        @Test
        public void get概況特記_主訴_イメージ共有ファイルIDは_entityが持つ概況特記_主訴_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_主訴_イメージ共有ファイルID(), is(gaikyoTokkiEntity.getShusoImageSharedFileId()));
        }

        @Test
        public void get概況特記_主訴_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_主訴_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_主訴_マスキングイメージ共有ファイルID(), is(gaikyoTokkiEntity.getShusoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_家族状況は_entityが持つ概況特記事項_家族状況を返す() {
            assertThat(sut.get概況特記事項_家族状況(), is(gaikyoTokkiEntity.getKazokuJokyo()));
        }

        @Test
        public void get概況特記_家族状況_イメージ共有ファイルIDは_entityが持つ概況特記_家族状況_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_家族状況_イメージ共有ファイルID(), is(gaikyoTokkiEntity.getKazokuJokyoImageSharedFileId()));
        }

        @Test
        public void get概況特記_家族状況_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_家族状況_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_家族状況_マスキングイメージ共有ファイルID(), is(gaikyoTokkiEntity.getKazokuJokyoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_居住環境は_entityが持つ概況特記事項_居住環境を返す() {
            assertThat(sut.get概況特記事項_居住環境(), is(gaikyoTokkiEntity.getKyojuKankyo()));
        }

        @Test
        public void get概況特記_居住環境_イメージ共有ファイルIDは_entityが持つ概況特記_居住環境_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_居住環境_イメージ共有ファイルID(), is(gaikyoTokkiEntity.getKyojuKankyoImageSharedFileId()));
        }

        @Test
        public void get概況特記_居住環境_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_居住環境_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_居住環境_マスキングイメージ共有ファイルID(), is(gaikyoTokkiEntity.getKyojuKankyoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_機器_器械は_entityが持つ概況特記事項_機器_器械を返す() {
            assertThat(sut.get概況特記事項_機器_器械(), is(gaikyoTokkiEntity.getKikaiKiki()));
        }

        @Test
        public void get概況特記_機器_器械_イメージ共有ファイルIDは_entityが持つ概況特記_機器_器械_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_機器_器械_イメージ共有ファイルID(), is(gaikyoTokkiEntity.getKikaiKikiImageSharedFileId()));
        }

        @Test
        public void get概況特記_機器_器械_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_機器_器械_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_機器_器械_マスキングイメージ共有ファイルID(), is(gaikyoTokkiEntity.getKikaiKikiMaskingImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(gaikyoTokkiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(gaikyoTokkiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(gaikyoTokkiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static GaikyoTokki sut;
        private static GaikyoTokki result;

        @BeforeClass
        public static void setUpClass() {
            gaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

        }

        @Test
        public void GaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりGaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがDeletedに指定されたGaikyoTokkiが返る() {
            sut = TestSupport.setStateGaikyoTokki(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりGaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがDeletedに指定されたGaikyoTokkiが返る() {
            sut = TestSupport.setStateGaikyoTokki(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりGaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがDeletedに指定されたGaikyoTokkiが返る() {
            sut = TestSupport.setStateGaikyoTokki(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void GaikyoTokkiが保持するDbT5206GaikyoTokkiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateGaikyoTokki(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static GaikyoTokki setStateGaikyoTokki(EntityDataState parentState) {
            gaikyoTokkiEntity.setState(parentState);
            return new GaikyoTokki(gaikyoTokkiEntity);
        }
    }
}
