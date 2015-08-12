/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KanrenHihokenshaNo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KanrenHihokenshaNoTest extends DbzTestBase {

    private static DbT7054KanrenHihokenshaNoEntity KanrenHihokenshaNoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KanrenHihokenshaNo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KanrenHihokenshaNo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7054KanrenHihokenshaNoEntityにセットされている() {
            sut = new KanrenHihokenshaNo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKanrenHihokenshaNoIdentifierにセットされている() {
            sut = new KanrenHihokenshaNo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KanrenHihokenshaNo(null);
        }

        @Test
        public void 指定したDbT7054KanrenHihokenshaNoEntityのキー情報を識別子が持つ() {

            sut = new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);

            sut = new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KanrenHihokenshaNoEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get最新被保険者番号は_entityが持つ最新被保険者番号を返す() {
            assertThat(sut.get最新被保険者番号(), is(KanrenHihokenshaNoEntity.getSaishinHihokenshaNo()));
        }

        @Test
        public void get旧被保険者番号は_entityが持つ旧被保険者番号を返す() {
            assertThat(sut.get旧被保険者番号(), is(KanrenHihokenshaNoEntity.getKyuuHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(KanrenHihokenshaNoEntity.getShikibetsuCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);

            sut = new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KanrenHihokenshaNoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);

            sut = new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KanrenHihokenshaNo sut;
        private static KanrenHihokenshaNo result;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);

        }

        @Test
        public void KanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがDeletedに指定されたKanrenHihokenshaNoが返る() {
            sut = TestSupport.setStateKanrenHihokenshaNo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがDeletedに指定されたKanrenHihokenshaNoが返る() {
            sut = TestSupport.setStateKanrenHihokenshaNo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがDeletedに指定されたKanrenHihokenshaNoが返る() {
            sut = TestSupport.setStateKanrenHihokenshaNo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KanrenHihokenshaNoが保持するDbT7054KanrenHihokenshaNoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKanrenHihokenshaNo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KanrenHihokenshaNo setStateKanrenHihokenshaNo(EntityDataState parentState) {
            KanrenHihokenshaNoEntity.setState(parentState);
            return new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);
        }
    }
}
