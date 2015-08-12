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
 * {@link RiyoshaFutanWariaiKonkyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiKonkyoTest extends DbcTestBase {

    private static DbT3115RiyoshaFutanWariaiKonkyoEntity RiyoshaFutanWariaiKonkyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariaiKonkyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariaiKonkyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityにセットされている() {
            sut = new RiyoshaFutanWariaiKonkyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するRiyoshaFutanWariaiKonkyoIdentifierにセットされている() {
            sut = new RiyoshaFutanWariaiKonkyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RiyoshaFutanWariaiKonkyo(null);
        }

        @Test
        public void 指定したDbT3115RiyoshaFutanWariaiKonkyoEntityのキー情報を識別子が持つ() {

            sut = new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);

            sut = new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);
        }

        @Test
        public void get年度は_entityが持つ年度を返す() {
            assertThat(sut.get年度(), is(RiyoshaFutanWariaiKonkyoEntity.getNendo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(RiyoshaFutanWariaiKonkyoEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(RiyoshaFutanWariaiKonkyoEntity.getRirekiNo()));
        }

        @Test
        public void get枝番号は_entityが持つ枝番号を返す() {
            assertThat(sut.get枝番号(), is(RiyoshaFutanWariaiKonkyoEntity.getEdaNo()));
        }

        @Test
        public void get世帯員被保険者番号は_entityが持つ世帯員被保険者番号を返す() {
            assertThat(sut.get世帯員被保険者番号(), is(RiyoshaFutanWariaiKonkyoEntity.getSetaiinHihokenshaNo()));
        }

        @Test
        public void get世帯員所得履歴番号は_entityが持つ世帯員所得履歴番号を返す() {
            assertThat(sut.get世帯員所得履歴番号(), is(RiyoshaFutanWariaiKonkyoEntity.getSetaiinShotokuRirekiNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);

            sut = new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RiyoshaFutanWariaiKonkyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);

            sut = new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyo sut;
        private static RiyoshaFutanWariaiKonkyo result;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);

        }

        @Test
        public void RiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiKonkyoが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiKonkyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiKonkyoが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiKonkyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiKonkyoが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiKonkyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RiyoshaFutanWariaiKonkyoが保持するDbT3115RiyoshaFutanWariaiKonkyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRiyoshaFutanWariaiKonkyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RiyoshaFutanWariaiKonkyo setStateRiyoshaFutanWariaiKonkyo(EntityDataState parentState) {
            RiyoshaFutanWariaiKonkyoEntity.setState(parentState);
            return new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);
        }
    }
}
