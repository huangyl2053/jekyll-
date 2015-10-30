/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5207NinteichosahyoServiceJokyoEntityGenerator;
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
 * {@link NinteichosahyoServiceJokyo}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosahyoServiceJokyoTest extends DbzTestBase {

    private static DbT5207NinteichosahyoServiceJokyoEntity NinteichosahyoServiceJokyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        連番 = DbT5207NinteichosahyoServiceJokyoEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoServiceJokyo(null, 認定調査依頼履歴番号, 連番);
        }

        @Test
        public void 指定したキーが保持するDbT5207NinteichosahyoServiceJokyoEntityにセットされている() {
            sut = new NinteichosahyoServiceJokyo(申請書管理番号, 認定調査依頼履歴番号, 連番);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoServiceJokyoIdentifierにセットされている() {
            sut = new NinteichosahyoServiceJokyo(申請書管理番号, 認定調査依頼履歴番号, 連番);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoServiceJokyo(null);
        }

        @Test
        public void 指定したDbT5207NinteichosahyoServiceJokyoEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();

            sut = new NinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoServiceJokyoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosahyoServiceJokyoEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoServiceJokyoEntity.getRemban()));
        }

        @Test
        public void getサービスの状況は_entityが持つサービスの状況を返す() {
            assertThat(sut.getサービスの状況(), is(NinteichosahyoServiceJokyoEntity.getServiceJokyo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();

            sut = new NinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoServiceJokyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();

            sut = new NinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoServiceJokyo sut;
        private static NinteichosahyoServiceJokyo result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoServiceJokyoEntity = DbT5207NinteichosahyoServiceJokyoEntityGenerator.createDbT5207NinteichosahyoServiceJokyoEntity();

        }

        @Test
        public void NinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがDeletedに指定されたNinteichosahyoServiceJokyoが返る() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoServiceJokyoが保持するDbT5207NinteichosahyoServiceJokyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoServiceJokyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoServiceJokyo setStateNinteichosahyoServiceJokyo(EntityDataState parentState) {
            NinteichosahyoServiceJokyoEntity.setState(parentState);
            return new NinteichosahyoServiceJokyo(NinteichosahyoServiceJokyoEntity);
        }
    }
}
