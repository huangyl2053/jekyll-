/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.Shotoku;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
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
 * {@link Shotoku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShotokuTest extends DbzTestBase {

    private static DbT2008ShotokuEntity ShotokuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2008ShotokuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2008ShotokuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Shotoku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Shotoku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT2008ShotokuEntityにセットされている() {
            sut = new Shotoku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShotokuIdentifierにセットされている() {
            sut = new Shotoku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Shotoku(null);
        }

        @Test
        public void 指定したDbT2008ShotokuEntityのキー情報を識別子が持つ() {

            sut = new Shotoku(ShotokuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void get所得年度は_entityが持つ所得年度を返す() {
            assertThat(sut.get所得年度(), is(ShotokuEntity.getShotokuNendo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShotokuEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShotokuEntity.getRirekiNo()));
        }

        @Test
        public void get非課税区分（住民税減免前）は_entityが持つ非課税区分（住民税減免前）を返す() {
            assertThat(sut.get非課税区分（住民税減免前）(), is(ShotokuEntity.getHiKazeiKubun()));
        }

        @Test
        public void get非課税区分（住民税減免後）は_entityが持つ非課税区分（住民税減免後）を返す() {
            assertThat(sut.get非課税区分（住民税減免後）(), is(ShotokuEntity.getHiKazeiKubunGemmenGo()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(ShotokuEntity.getGokeiShotokuGaku()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(ShotokuEntity.getNenkiniShunyuGaku()));
        }

        @Test
        public void get激変緩和措置区分は_entityが持つ激変緩和措置区分を返す() {
            assertThat(sut.get激変緩和措置区分(), is(ShotokuEntity.getGekihenKanwaKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShotokuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static Shotoku sut;
        private static Shotoku result;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuEntityGenerator.createDbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);

        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Shotokuが保持するDbT2008ShotokuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShotoku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Shotoku setStateShotoku(EntityDataState parentState) {
            ShotokuEntity.setState(parentState);
            return new Shotoku(ShotokuEntity);
        }
    }
}
