/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
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
 * {@link ChohyoBunruiKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoBunruiKanriTest extends DbzTestBase {

    private static DbT7068ChohyoBunruiKanriEntity ChohyoBunruiKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoBunruiKanri(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoBunruiKanri(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7068ChohyoBunruiKanriEntityにセットされている() {
            sut = new ChohyoBunruiKanri(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChohyoBunruiKanriIdentifierにセットされている() {
            sut = new ChohyoBunruiKanri(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChohyoBunruiKanri(null);
        }

        @Test
        public void 指定したDbT7068ChohyoBunruiKanriEntityのキー情報を識別子が持つ() {

            sut = new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);

            sut = new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(ChohyoBunruiKanriEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票IDは_entityが持つ帳票IDを返す() {
            assertThat(sut.get帳票ID(), is(ChohyoBunruiKanriEntity.getReportID()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(ChohyoBunruiKanriEntity.getChohyoBunruiID()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);

            sut = new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChohyoBunruiKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);

            sut = new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;
        private static ChohyoBunruiKanri result;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);

        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChohyoBunruiKanri setStateChohyoBunruiKanri(EntityDataState parentState) {
            ChohyoBunruiKanriEntity.setState(parentState);
            return new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);
        }
    }
}
