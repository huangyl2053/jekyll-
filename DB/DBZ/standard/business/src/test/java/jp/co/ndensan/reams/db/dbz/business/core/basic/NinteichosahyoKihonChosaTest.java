/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5203NinteichosahyoKihonChosaEntityGenerator;
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
 * {@link NinteichosahyoKihonChosa}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaTest extends DbzTestBase {

    private static DbT5203NinteichosahyoKihonChosaEntity NinteichosahyoKihonChosaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 要介護認定調査履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_申請書管理番号;
        要介護認定調査履歴番号 = DbT5203NinteichosahyoKihonChosaEntityGenerator.DEFAULT_要介護認定調査履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKihonChosa(null, 要介護認定調査履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5203NinteichosahyoKihonChosaEntityにセットされている() {
            sut = new NinteichosahyoKihonChosa(申請書管理番号, 要介護認定調査履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoKihonChosaIdentifierにセットされている() {
            sut = new NinteichosahyoKihonChosa(申請書管理番号, 要介護認定調査履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoKihonChosa(null);
        }

        @Test
        public void 指定したDbT5203NinteichosahyoKihonChosaEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();

            sut = new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoKihonChosaEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get要介護認定調査履歴番号は_entityが持つ要介護認定調査履歴番号を返す() {
            assertThat(sut.get要介護認定調査履歴番号(), is(NinteichosahyoKihonChosaEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoKihonChosaEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get認定調査_認知症高齢者の日常生活自立度コードは_entityが持つ認定調査_認知症高齢者の日常生活自立度コードを返す() {
            assertThat(sut.get認定調査_認知症高齢者の日常生活自立度コード(), is(NinteichosahyoKihonChosaEntity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        }

        @Test
        public void get認定調査_障害高齢者の日常生活自立度コードは_entityが持つ認定調査_障害高齢者の日常生活自立度コードを返す() {
            assertThat(sut.get認定調査_障害高齢者の日常生活自立度コード(), is(NinteichosahyoKihonChosaEntity.getShogaiNichijoSeikatsuJiritsudoCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();

            sut = new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoKihonChosaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();

            sut = new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosa sut;
        private static NinteichosahyoKihonChosa result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaEntity = DbT5203NinteichosahyoKihonChosaEntityGenerator.createDbT5203NinteichosahyoKihonChosaEntity();

        }

        @Test
        public void NinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosa(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosa(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosa(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoKihonChosaが保持するDbT5203NinteichosahyoKihonChosaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoKihonChosa(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoKihonChosa setStateNinteichosahyoKihonChosa(EntityDataState parentState) {
            NinteichosahyoKihonChosaEntity.setState(parentState);
            return new NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity);
        }
    }
}
