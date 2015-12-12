/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7902FukaSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link FukaSearchAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FukaSearchAliveTest extends DbzTestBase {

    private static DbV7902FukaSearchEntity FukaSearchAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbV7902FukaSearchEntityGenerator.DEFAULT_通知書番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static FukaSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 調定年度がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaSearchAlive(null, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaSearchAlive(調定年度, null, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaSearchAlive(調定年度, 賦課年度, null);
        }

        @Test
        public void 指定したキーが保持するDbV7902FukaSearchEntityにセットされている() {
            sut = new FukaSearchAlive(調定年度, 賦課年度, 通知書番号);
            assertThat(sut.get調定年度(), is(調定年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get通知書番号(), is(通知書番号));
        }

        @Test
        public void 指定したキーが保持するFukaSearchAliveIdentifierにセットされている() {
            sut = new FukaSearchAlive(調定年度, 賦課年度, 通知書番号);
            //TODO
//            assertThat(sut.identifier().getXXX(), is(調定年度));
//            assertThat(sut.identifier().getXXX(), is(賦課年度));
//            assertThat(sut.identifier().getXXX(), is(通知書番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static FukaSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new FukaSearchAlive(null);
        }

        @Test
        public void 指定したDbV7902FukaSearchEntityのキー情報を識別子が持つ() {

            sut = new FukaSearchAlive(FukaSearchAliveEntity);

            //TODO
//            assertThat(sut.identifier().getXXX(), is(調定年度));
//            assertThat(sut.identifier().getXXX(), is(賦課年度));
//            assertThat(sut.identifier().getXXX(), is(通知書番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static FukaSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();

            sut = new FukaSearchAlive(FukaSearchAliveEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(FukaSearchAliveEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(FukaSearchAliveEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(FukaSearchAliveEntity.getTsuchishoNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(FukaSearchAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(FukaSearchAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get被保台帳被保険者番号は_entityが持つ被保台帳被保険者番号を返す() {
            assertThat(sut.get被保台帳被保険者番号(), is(FukaSearchAliveEntity.getHihodaichoHihokenshaNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static FukaSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();

            sut = new FukaSearchAlive(FukaSearchAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(FukaSearchAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static FukaSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();

            sut = new FukaSearchAlive(FukaSearchAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static FukaSearchAlive sut;
        private static FukaSearchAlive result;

        @BeforeClass
        public static void setUpClass() {
            FukaSearchAliveEntity = DbV7902FukaSearchEntityGenerator.createDbV7902FukaSearchEntity();

        }

        @Test
        public void FukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりFukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがDeletedに指定されたFukaSearchAliveが返る() {
            sut = TestSupport.setStateFukaSearchAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりFukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがDeletedに指定されたFukaSearchAliveが返る() {
            sut = TestSupport.setStateFukaSearchAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりFukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがDeletedに指定されたFukaSearchAliveが返る() {
            sut = TestSupport.setStateFukaSearchAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void FukaSearchAliveが保持するDbV7902FukaSearchEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateFukaSearchAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static FukaSearchAlive setStateFukaSearchAlive(EntityDataState parentState) {
            FukaSearchAliveEntity.setState(parentState);
            return new FukaSearchAlive(FukaSearchAliveEntity);
        }
    }
}
