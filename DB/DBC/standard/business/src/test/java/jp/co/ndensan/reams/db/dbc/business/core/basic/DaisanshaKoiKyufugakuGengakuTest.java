/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link DaisanshaKoiKyufugakuGengaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyufugakuGengakuTest extends DbcTestBase {

    private static DbT3081DaisanshaKoiKyufugakuGengakuEntity DaisanshaKoiKyufugakuGengakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyufugakuGengaku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyufugakuGengaku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityにセットされている() {
            sut = new DaisanshaKoiKyufugakuGengaku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiKyufugakuGengakuIdentifierにセットされている() {
            sut = new DaisanshaKoiKyufugakuGengaku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiKyufugakuGengaku(null);
        }

        @Test
        public void 指定したDbT3081DaisanshaKoiKyufugakuGengakuEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiKyufugakuGengakuEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiKyufugakuGengakuEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiKyufugakuGengakuEntity.getRirekiNo()));
        }

        @Test
        public void get減額対象金額は_entityが持つ減額対象金額を返す() {
            assertThat(sut.get減額対象金額(), is(DaisanshaKoiKyufugakuGengakuEntity.getGengakuTaishoKingaku()));
        }

        @Test
        public void get給付額減額期間開始年月日は_entityが持つ給付額減額期間開始年月日を返す() {
            assertThat(sut.get給付額減額期間開始年月日(), is(DaisanshaKoiKyufugakuGengakuEntity.getGengakuKaishiYMD()));
        }

        @Test
        public void get給付額減額期間終了年月日は_entityが持つ給付額減額期間終了年月日を返す() {
            assertThat(sut.get給付額減額期間終了年月日(), is(DaisanshaKoiKyufugakuGengakuEntity.getGengakuShuryoYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiKyufugakuGengakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);

            sut = new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengaku sut;
        private static DaisanshaKoiKyufugakuGengaku result;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setXXX(主キー名2);

        }

        @Test
        public void DaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyufugakuGengakuが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyufugakuGengaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyufugakuGengakuが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyufugakuGengaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyufugakuGengakuが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyufugakuGengaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiKyufugakuGengakuが保持するDbT3081DaisanshaKoiKyufugakuGengakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiKyufugakuGengaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiKyufugakuGengaku setStateDaisanshaKoiKyufugakuGengaku(EntityDataState parentState) {
            DaisanshaKoiKyufugakuGengakuEntity.setState(parentState);
            return new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);
        }
    }
}
