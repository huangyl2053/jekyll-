/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5204NinteichosahyoKihonChosaScoreEntityGenerator;
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
 * {@link NinteichosahyoKihonChosaScore}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreTest extends DbzTestBase {

    private static DbT5204NinteichosahyoKihonChosaScoreEntity NinteichosahyoKihonChosaScoreEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 要介護認定調査履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_申請書管理番号;
        要介護認定調査履歴番号 = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.DEFAULT_要介護認定調査履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKihonChosaScore(null, 要介護認定調査履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5204NinteichosahyoKihonChosaScoreEntityにセットされている() {
            sut = new NinteichosahyoKihonChosaScore(申請書管理番号, 要介護認定調査履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosahyoKihonChosaScoreIdentifierにセットされている() {
            sut = new NinteichosahyoKihonChosaScore(申請書管理番号, 要介護認定調査履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosahyoKihonChosaScore(null);
        }

        @Test
        public void 指定したDbT5204NinteichosahyoKihonChosaScoreEntityのキー情報を識別子が持つ() {

            sut = new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get要介護認定調査履歴番号(), is(要介護認定調査履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();

            sut = new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosahyoKihonChosaScoreEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get要介護認定調査履歴番号は_entityが持つ要介護認定調査履歴番号を返す() {
            assertThat(sut.get要介護認定調査履歴番号(), is(NinteichosahyoKihonChosaScoreEntity.getNinteichosaRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosahyoKihonChosaScoreEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get素点合計_第１郡は_entityが持つ素点合計_第１郡を返す() {
            assertThat(sut.get素点合計_第１郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal1gun()));
        }

        @Test
        public void get素点合計_第２郡は_entityが持つ素点合計_第２郡を返す() {
            assertThat(sut.get素点合計_第２郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal2gun()));
        }

        @Test
        public void get素点合計_第３郡は_entityが持つ素点合計_第３郡を返す() {
            assertThat(sut.get素点合計_第３郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal3gun()));
        }

        @Test
        public void get素点合計_第４郡は_entityが持つ素点合計_第４郡を返す() {
            assertThat(sut.get素点合計_第４郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal4gun()));
        }

        @Test
        public void get素点合計_第５郡は_entityが持つ素点合計_第５郡を返す() {
            assertThat(sut.get素点合計_第５郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal5gun()));
        }

        @Test
        public void get素点合計_第６郡は_entityが持つ素点合計_第６郡を返す() {
            assertThat(sut.get素点合計_第６郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal6gun()));
        }

        @Test
        public void get素点合計_第７郡は_entityが持つ素点合計_第７郡を返す() {
            assertThat(sut.get素点合計_第７郡(), is(NinteichosahyoKihonChosaScoreEntity.getTokutenTotal7gun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();

            sut = new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosahyoKihonChosaScoreEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();

            sut = new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosahyoKihonChosaScore sut;
        private static NinteichosahyoKihonChosaScore result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosahyoKihonChosaScoreEntity = DbT5204NinteichosahyoKihonChosaScoreEntityGenerator.createDbT5204NinteichosahyoKihonChosaScoreEntity();

        }

        @Test
        public void NinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScore(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScore(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがDeletedに指定されたNinteichosahyoKihonChosaScoreが返る() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScore(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosahyoKihonChosaScoreが保持するDbT5204NinteichosahyoKihonChosaScoreEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosahyoKihonChosaScore(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosahyoKihonChosaScore setStateNinteichosahyoKihonChosaScore(EntityDataState parentState) {
            NinteichosahyoKihonChosaScoreEntity.setState(parentState);
            return new NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity);
        }
    }
}
