/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5202NinteichosahyoGaikyoChosaEntityGenerator;
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
 * {@link NinteichosahyoGaikyoChosa}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosahyoGaikyoChosaTest extends DbzTestBase {

    private static DbT5202NinteichosahyoGaikyoChosaEntity NinteichosahyoGaikyoChosaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoGaikyoChosa(null, 認定調査依頼履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5202NinteichosahyoGaikyoChosaEntityにセットされている() {
            sut = new NinteichosahyoGaikyoChosa(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoGaikyoChosaIdentifierにセットされている() {
            sut = new NinteichosahyoGaikyoChosa(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoGaikyoChosa(null);
        }

        @Test
        public void 指定したDbT5202NinteichosahyoGaikyoChosaEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();

            sut = new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoGaikyoChosaEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoGaikyoChosaEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoGaikyoChosaEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get認定調査依頼区分コードは_entityが持つ認定調査依頼区分コードを返す() {
            assertThat(sut.get認定調査依頼区分コード(), is(NinteichosahyoGaikyoChosaEntity.getNinteichousaIraiKubunCode()));
        }

        @Test
        public void get認定調査回数は_entityが持つ認定調査回数を返す() {
            assertThat(sut.get認定調査回数(), is(NinteichosahyoGaikyoChosaEntity.getNinteichosaIraiKaisu()));
        }

        @Test
        public void get認定調査実施年月日は_entityが持つ認定調査実施年月日を返す() {
            assertThat(sut.get認定調査実施年月日(), is(NinteichosahyoGaikyoChosaEntity.getNinteichosaJisshiYMD()));
        }

        @Test
        public void get認定調査受領年月日は_entityが持つ認定調査受領年月日を返す() {
            assertThat(sut.get認定調査受領年月日(), is(NinteichosahyoGaikyoChosaEntity.getNinteichosaJuryoYMD()));
        }

        @Test
        public void get調査委託区分コードは_entityが持つ調査委託区分コードを返す() {
            assertThat(sut.get調査委託区分コード(), is(NinteichosahyoGaikyoChosaEntity.getChosaItakuKubunCode()));
        }

        @Test
        public void get認定調査区分コードは_entityが持つ認定調査区分コードを返す() {
            assertThat(sut.get認定調査区分コード(), is(NinteichosahyoGaikyoChosaEntity.getNinteiChosaKubunCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(NinteichosahyoGaikyoChosaEntity.getChosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(NinteichosahyoGaikyoChosaEntity.getChosainCode()));
        }

        @Test
        public void get認定調査実施場所コードは_entityが持つ認定調査実施場所コードを返す() {
            assertThat(sut.get認定調査実施場所コード(), is(NinteichosahyoGaikyoChosaEntity.getChosaJisshiBashoCode()));
        }

        @Test
        public void get認定調査実施場所名称は_entityが持つ認定調査実施場所名称を返す() {
            assertThat(sut.get認定調査実施場所名称(), is(NinteichosahyoGaikyoChosaEntity.getChosaJisshiBashoMeisho()));
        }

        @Test
        public void get実施場所イメージ共有ファイルIDは_entityが持つ実施場所イメージ共有ファイルIDを返す() {
            assertThat(sut.get実施場所イメージ共有ファイルID(), is(NinteichosahyoGaikyoChosaEntity.getJisshiBashoImageSharedFileId()));
        }

//        @Test
//        public void get認定調査_現在の状況コードは_entityが持つ認定調査_現在の状況コードを返す() {
//            assertThat(sut.get認定調査_現在の状況コード(), is(NinteichosahyoGaikyoChosaEntity.getGenzainoJokyoCode()));
//        }
        @Test
        public void get認定調査_サービス区分コードは_entityが持つ認定調査_サービス区分コードを返す() {
            assertThat(sut.get認定調査_サービス区分コード(), is(NinteichosahyoGaikyoChosaEntity.getServiceKubunCode()));
        }

        @Test
        public void get利用施設名は_entityが持つ利用施設名を返す() {
            assertThat(sut.get利用施設名(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuShimei()));
        }

        @Test
        public void get利用施設住所は_entityが持つ利用施設住所を返す() {
            assertThat(sut.get利用施設住所(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuJusho()));
        }

        @Test
        public void get利用施設電話番号は_entityが持つ利用施設電話番号を返す() {
            assertThat(sut.get利用施設電話番号(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuTelNo()));
        }

        @Test
        public void get利用施設郵便番号は_entityが持つ利用施設郵便番号を返す() {
            assertThat(sut.get利用施設郵便番号(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuYubinNo()));
        }

        @Test
        public void get利用施設名イメージ共有ファイルIDは_entityが持つ利用施設名イメージ共有ファイルIDを返す() {
            assertThat(sut.get利用施設名イメージ共有ファイルID(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuNameImageSharedFileId()));
        }

        @Test
        public void get利用施設住所イメージ共有ファイルIDは_entityが持つ利用施設住所イメージ共有ファイルIDを返す() {
            assertThat(sut.get利用施設住所イメージ共有ファイルID(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuJushoImageSharedFileId()));
        }

        @Test
        public void get利用施設電話番号イメージ共有ファイルIDは_entityが持つ利用施設電話番号イメージ共有ファイルIDを返す() {
            assertThat(sut.get利用施設電話番号イメージ共有ファイルID(), is(NinteichosahyoGaikyoChosaEntity.getRiyoShisetsuTelNoImageSharedFileId()));
        }

        @Test
        public void get特記は_entityが持つ特記を返す() {
            assertThat(sut.get特記(), is(NinteichosahyoGaikyoChosaEntity.getTokki()));
        }

        @Test
        public void get特記イメージ共有ファイルIDは_entityが持つ特記イメージ共有ファイルIDを返す() {
            assertThat(sut.get特記イメージ共有ファイルID(), is(NinteichosahyoGaikyoChosaEntity.getTokkiImageSharedFileId()));
        }

        @Test
        public void get認定調査特記事項受付年月日は_entityが持つ認定調査特記事項受付年月日を返す() {
            assertThat(sut.get認定調査特記事項受付年月日(), is(NinteichosahyoGaikyoChosaEntity.getTokkijikoUketsukeYMD()));
        }

        @Test
        public void get認定調査特記事項受領年月日は_entityが持つ認定調査特記事項受領年月日を返す() {
            assertThat(sut.get認定調査特記事項受領年月日(), is(NinteichosahyoGaikyoChosaEntity.getTokkijikoJuryoYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();

            sut = new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoGaikyoChosaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();

            sut = new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoGaikyoChosa sut;
        private static NinteichosahyoGaikyoChosa result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoGaikyoChosaEntity = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.createDbT5202NinteichosahyoGaikyoChosaEntity();

        }

        @Test
        public void NinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoGaikyoChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoGaikyoChosa(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoGaikyoChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoGaikyoChosa(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoGaikyoChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoGaikyoChosa(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoGaikyoChosaが保持するDbT5202NinteichosahyoGaikyoChosaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoGaikyoChosa(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoGaikyoChosa setStateNinteichosahyoGaikyoChosa(EntityDataState parentState) {
            NinteichosahyoGaikyoChosaEntity.setState(parentState);
            return new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);
        }
    }
}
