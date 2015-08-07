/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.testhelper.DbbTestBase;
import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
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
 * {@link HokenryoDankai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiTest extends DbbTestBase {

    private static DbT2013HokenryoDankaiEntity HokenryoDankaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoDankai(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoDankai(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT2013HokenryoDankaiEntityにセットされている() {
            sut = new HokenryoDankai(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するHokenryoDankaiIdentifierにセットされている() {
            sut = new HokenryoDankai(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HokenryoDankai(null);
        }

        @Test
        public void 指定したDbT2013HokenryoDankaiEntityのキー情報を識別子が持つ() {

            sut = new HokenryoDankai(HokenryoDankaiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(HokenryoDankaiEntity.getFukaNendo()));
        }

        @Test
        public void get段階インデックスは_entityが持つ段階インデックスを返す() {
            assertThat(sut.get段階インデックス(), is(HokenryoDankaiEntity.getDankaiIndex()));
        }

        @Test
        public void getランク区分は_entityが持つランク区分を返す() {
            assertThat(sut.getランク区分(), is(HokenryoDankaiEntity.getRankuKubun()));
        }

        @Test
        public void get段階区分は_entityが持つ段階区分を返す() {
            assertThat(sut.get段階区分(), is(HokenryoDankaiEntity.getDankaiKubun()));
        }

        @Test
        public void get保険料率は_entityが持つ保険料率を返す() {
            assertThat(sut.get保険料率(), is(HokenryoDankaiEntity.getHokenryoRitsu()));
        }

        @Test
        public void get特例表記は_entityが持つ特例表記を返す() {
            assertThat(sut.get特例表記(), is(HokenryoDankaiEntity.getTokureiHyoki()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HokenryoDankaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static HokenryoDankai sut;
        private static HokenryoDankai result;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setXXX(主キー名1);
            HokenryoDankaiEntity.setXXX(主キー名2);

        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static HokenryoDankai setStateHokenryoDankai(EntityDataState parentState) {
            HokenryoDankaiEntity.setState(parentState);
            return new HokenryoDankai(HokenryoDankaiEntity);
        }
    }
}
