/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5210NinteichosahyoShisetsuRiyoEntityGenerator;
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
 * {@link NinteichosahyoShisetsuRiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoShisetsuRiyoTest extends DbzTestBase {

    private static DbT5210NinteichosahyoShisetsuRiyoEntity NinteichosahyoShisetsuRiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        連番 = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoShisetsuRiyo(null, 認定調査依頼履歴番号, 連番);
        }

        @Test
        public void 指定したキーが保持するDbT5210NinteichosahyoShisetsuRiyoEntityにセットされている() {
            sut = new NinteichosahyoShisetsuRiyo(申請書管理番号, 認定調査依頼履歴番号, 連番);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoShisetsuRiyoIdentifierにセットされている() {
            sut = new NinteichosahyoShisetsuRiyo(申請書管理番号, 認定調査依頼履歴番号, 連番);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoShisetsuRiyo(null);
        }

        @Test
        public void 指定したDbT5210NinteichosahyoShisetsuRiyoEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();

            sut = new NinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoShisetsuRiyoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoShisetsuRiyoEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoShisetsuRiyoEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoShisetsuRiyoEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get施設利用フラグは_entityが持つ施設利用フラグを返す() {
            assertThat(sut.get施設利用フラグ(), is(NinteichosahyoShisetsuRiyoEntity.getShisetsuRiyoFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();

            sut = new NinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoShisetsuRiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();

            sut = new NinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoShisetsuRiyo sut;
        private static NinteichosahyoShisetsuRiyo result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoShisetsuRiyoEntity = DbT5210NinteichosahyoShisetsuRiyoEntityGenerator.createDbT5210NinteichosahyoShisetsuRiyoEntity();

        }

        @Test
        public void NinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoShisetsuRiyoが返る() {
            sut = TestSupport.setStateNinteichosahyoShisetsuRiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoShisetsuRiyoが返る() {
            sut = TestSupport.setStateNinteichosahyoShisetsuRiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoShisetsuRiyoが返る() {
            sut = TestSupport.setStateNinteichosahyoShisetsuRiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoShisetsuRiyoが保持するDbT5210NinteichosahyoShisetsuRiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoShisetsuRiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoShisetsuRiyo setStateNinteichosahyoShisetsuRiyo(EntityDataState parentState) {
            NinteichosahyoShisetsuRiyoEntity.setState(parentState);
            return new NinteichosahyoShisetsuRiyo(NinteichosahyoShisetsuRiyoEntity);
        }
    }
}
