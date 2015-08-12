/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

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

    private static DbT5206GaikyoTokkiEntity GaikyoTokkiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GaikyoTokki(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GaikyoTokki(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5206GaikyoTokkiEntityにセットされている() {
            sut = new GaikyoTokki(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するGaikyoTokkiIdentifierにセットされている() {
            sut = new GaikyoTokki(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GaikyoTokki(null);
        }

        @Test
        public void 指定したDbT5206GaikyoTokkiEntityのキー情報を識別子が持つ() {

            sut = new GaikyoTokki(GaikyoTokkiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(GaikyoTokkiEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(GaikyoTokkiEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(GaikyoTokkiEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get概況特記事項_主訴は_entityが持つ概況特記事項_主訴を返す() {
            assertThat(sut.get概況特記事項_主訴(), is(GaikyoTokkiEntity.getShuso()));
        }

        @Test
        public void get概況特記_主訴_イメージ共有ファイルIDは_entityが持つ概況特記_主訴_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_主訴_イメージ共有ファイルID(), is(GaikyoTokkiEntity.getShusoImageSharedFileId()));
        }

        @Test
        public void get概況特記_主訴_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_主訴_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_主訴_マスキングイメージ共有ファイルID(), is(GaikyoTokkiEntity.getShusoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_家族状況は_entityが持つ概況特記事項_家族状況を返す() {
            assertThat(sut.get概況特記事項_家族状況(), is(GaikyoTokkiEntity.getKazokuJokyo()));
        }

        @Test
        public void get概況特記_家族状況_イメージ共有ファイルIDは_entityが持つ概況特記_家族状況_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_家族状況_イメージ共有ファイルID(), is(GaikyoTokkiEntity.getKazokuJokyoImageSharedFileId()));
        }

        @Test
        public void get概況特記_家族状況_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_家族状況_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_家族状況_マスキングイメージ共有ファイルID(), is(GaikyoTokkiEntity.getKazokuJokyoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_居住環境は_entityが持つ概況特記事項_居住環境を返す() {
            assertThat(sut.get概況特記事項_居住環境(), is(GaikyoTokkiEntity.getKyojuKankyo()));
        }

        @Test
        public void get概況特記_居住環境_イメージ共有ファイルIDは_entityが持つ概況特記_居住環境_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_居住環境_イメージ共有ファイルID(), is(GaikyoTokkiEntity.getKyojuKankyoImageSharedFileId()));
        }

        @Test
        public void get概況特記_居住環境_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_居住環境_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_居住環境_マスキングイメージ共有ファイルID(), is(GaikyoTokkiEntity.getKyojuKankyoMaskingImageSharedFileId()));
        }

        @Test
        public void get概況特記事項_機器_器械は_entityが持つ概況特記事項_機器_器械を返す() {
            assertThat(sut.get概況特記事項_機器_器械(), is(GaikyoTokkiEntity.getKikaiKiki()));
        }

        @Test
        public void get概況特記_機器_器械_イメージ共有ファイルIDは_entityが持つ概況特記_機器_器械_イメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_機器_器械_イメージ共有ファイルID(), is(GaikyoTokkiEntity.getKikaiKikiImageSharedFileId()));
        }

        @Test
        public void get概況特記_機器_器械_マスキングイメージ共有ファイルIDは_entityが持つ概況特記_機器_器械_マスキングイメージ共有ファイルIDを返す() {
            assertThat(sut.get概況特記_機器_器械_マスキングイメージ共有ファイルID(), is(GaikyoTokkiEntity.getKikaiKikiMaskingImageSharedFileId()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(GaikyoTokkiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(GaikyoTokkiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GaikyoTokki sut;

        @BeforeClass
        public static void setUpClass() {
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

            sut = new GaikyoTokki(GaikyoTokkiEntity);
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
            GaikyoTokkiEntity = DbT5206GaikyoTokkiEntityGenerator.createDbT5206GaikyoTokkiEntity();

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
            GaikyoTokkiEntity.setState(parentState);
            return new GaikyoTokki(GaikyoTokkiEntity);
        }
    }
}
