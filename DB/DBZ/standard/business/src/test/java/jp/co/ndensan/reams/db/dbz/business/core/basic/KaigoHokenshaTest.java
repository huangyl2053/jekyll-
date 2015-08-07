/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator;
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
 * {@link KaigoHokensha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoHokenshaTest extends DbzTestBase {

    private static DbT7050KaigoHokenshaEntity KaigoHokenshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7050KaigoHokenshaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7050KaigoHokenshaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KaigoHokensha sut;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoHokensha(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoHokensha(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7050KaigoHokenshaEntityにセットされている() {
            sut = new KaigoHokensha(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoHokenshaIdentifierにセットされている() {
            sut = new KaigoHokensha(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KaigoHokensha sut;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoHokensha(null);
        }

        @Test
        public void 指定したDbT7050KaigoHokenshaEntityのキー情報を識別子が持つ() {

            sut = new KaigoHokensha(KaigoHokenshaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KaigoHokensha sut;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);

            sut = new KaigoHokensha(KaigoHokenshaEntity);
        }

        @Test
        public void get広域保険者市町村コードは_entityが持つ広域保険者市町村コードを返す() {
            assertThat(sut.get広域保険者市町村コード(), is(KaigoHokenshaEntity.getKoikiHokenshaShichosonCode()));
        }

        @Test
        public void get広域保険者番号は_entityが持つ広域保険者番号を返す() {
            assertThat(sut.get広域保険者番号(), is(KaigoHokenshaEntity.getKoikiHokenshaNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KaigoHokensha sut;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);

            sut = new KaigoHokensha(KaigoHokenshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoHokenshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KaigoHokensha sut;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);

            sut = new KaigoHokensha(KaigoHokenshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KaigoHokensha sut;
        private static KaigoHokensha result;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setXXX(主キー名1);
            KaigoHokenshaEntity.setXXX(主キー名2);

        }

        @Test
        public void KaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがDeletedに指定されたKaigoHokenshaが返る() {
            sut = TestSupport.setStateKaigoHokensha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがDeletedに指定されたKaigoHokenshaが返る() {
            sut = TestSupport.setStateKaigoHokensha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがDeletedに指定されたKaigoHokenshaが返る() {
            sut = TestSupport.setStateKaigoHokensha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoHokenshaが保持するDbT7050KaigoHokenshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoHokensha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoHokensha setStateKaigoHokensha(EntityDataState parentState) {
            KaigoHokenshaEntity.setState(parentState);
            return new KaigoHokensha(KaigoHokenshaEntity);
        }
    }
}
