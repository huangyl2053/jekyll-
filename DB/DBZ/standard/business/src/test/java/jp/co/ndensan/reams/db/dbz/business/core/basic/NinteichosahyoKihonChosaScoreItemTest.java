/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
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
 * {@link NinteichosahyoKihonChosaScoreItem}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreItemTest extends DbzTestBase {

    private static DbT5212NinteichosahyoKihonChosaScoreItemEntity NinteichosahyoKihonChosaScoreItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 要介護認定調査履歴番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_申請書管理番号;
        要介護認定調査履歴番号 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_要介護認定調査履歴番号;
        連番 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void DEFAULT_申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKihonChosaScoreItem(null, 要介護認定調査履歴番号, 連番);
        }

        @Test(expected = NullPointerException.class)
        public void DEFAULT_要介護認定調査履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKihonChosaScoreItem(申請書管理番号, 0, 連番);
        }

        @Test
        public void 指定したキーが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityにセットされている() {
            sut = new NinteichosahyoKihonChosaScoreItem(申請書管理番号, 要介護認定調査履歴番号, 連番);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
            assertThat(sut.get連番(), is(連番));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoKihonChosaScoreItemIdentifierにセットされている() {
            sut = new NinteichosahyoKihonChosaScoreItem(申請書管理番号, 要介護認定調査履歴番号, 連番);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoKihonChosaScoreItem(null);
        }

        @Test
        public void 指定したDbT5212NinteichosahyoKihonChosaScoreItemEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();

            sut = new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoKihonChosaScoreItemEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get要介護認定調査履歴番号は_entityが持つ要介護認定調査履歴番号を返す() {
            assertThat(sut.get要介護認定調査履歴番号(), is(NinteichosahyoKihonChosaScoreItemEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteichosahyoKihonChosaScoreItemEntity.getRemban()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoKihonChosaScoreItemEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get素点項目は_entityが持つ素点項目を返す() {
            assertThat(sut.get素点項目(), is(NinteichosahyoKihonChosaScoreItemEntity.getResearchItem01()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();

            sut = new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoKihonChosaScoreItemEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();

            sut = new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItem sut;
        private static NinteichosahyoKihonChosaScoreItem result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreItemEntity = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.createDbT5212NinteichosahyoKihonChosaScoreItemEntity();

        }

        @Test
        public void NinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScoreItem(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScoreItem(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreItemが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScoreItem(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoKihonChosaScoreItemが保持するDbT5212NinteichosahyoKihonChosaScoreItemEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScoreItem(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoKihonChosaScoreItem setStateNinteichosahyoKihonChosaScoreItem(EntityDataState parentState) {
            NinteichosahyoKihonChosaScoreItemEntity.setState(parentState);
            return new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);
        }
    }
}
