/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
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
 * {@link ChikuNinteiChosain}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuNinteiChosainTest extends DbzTestBase {

    private static DbT5223ChikuNinteiChosainEntity ChikuNinteiChosainEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5223ChikuNinteiChosainEntityにセットされている() {
            sut = new ChikuNinteiChosain(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChikuNinteiChosainIdentifierにセットされている() {
            sut = new ChikuNinteiChosain(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChikuNinteiChosain(null);
        }

        @Test
        public void 指定したDbT5223ChikuNinteiChosainEntityのキー情報を識別子が持つ() {

            sut = new ChikuNinteiChosain(ChikuNinteiChosainEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(ChikuNinteiChosainEntity);
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(ChikuNinteiChosainEntity.getChosaChikuCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(ChikuNinteiChosainEntity.getNinteiChosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(ChikuNinteiChosainEntity.getNinteiChosainCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ChikuNinteiChosainEntity.getShichosonCode()));
        }

        @Test
        public void get優先番号は_entityが持つ優先番号を返す() {
            assertThat(sut.get優先番号(), is(ChikuNinteiChosainEntity.getYusenNo()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(ChikuNinteiChosainEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(ChikuNinteiChosainEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChikuNinteiChosainEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(ChikuNinteiChosainEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;
        private static ChikuNinteiChosain result;

        @BeforeClass
        public static void setUpClass() {
            ChikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChikuNinteiChosain setStateChikuNinteiChosain(EntityDataState parentState) {
            ChikuNinteiChosainEntity.setState(parentState);
            return new ChikuNinteiChosain(ChikuNinteiChosainEntity);
        }
    }
}
