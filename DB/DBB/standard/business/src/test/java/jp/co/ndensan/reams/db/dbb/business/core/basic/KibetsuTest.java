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
 * {@link Kibetsu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuTest extends DbbTestBase {

    private static DbT2003KibetsuEntity KibetsuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2003KibetsuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static Kibetsu sut;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT2003KibetsuEntityにセットされている() {
            sut = new Kibetsu(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKibetsuIdentifierにセットされている() {
            sut = new Kibetsu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static Kibetsu sut;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Kibetsu(null);
        }

        @Test
        public void 指定したDbT2003KibetsuEntityのキー情報を識別子が持つ() {

            sut = new Kibetsu(KibetsuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static Kibetsu sut;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);

            sut = new Kibetsu(KibetsuEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(KibetsuEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(KibetsuEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(KibetsuEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KibetsuEntity.getRirekiNo()));
        }

        @Test
        public void get徴収方法は_entityが持つ徴収方法を返す() {
            assertThat(sut.get徴収方法(), is(KibetsuEntity.getChoshuHouhou()));
        }

        @Test
        public void get期は_entityが持つ期を返す() {
            assertThat(sut.get期(), is(KibetsuEntity.getKi()));
        }

        @Test
        public void get調定IDは_entityが持つ調定IDを返す() {
            assertThat(sut.get調定ID(), is(KibetsuEntity.getChoteiId()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static Kibetsu sut;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);

            sut = new Kibetsu(KibetsuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KibetsuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static Kibetsu sut;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);

            sut = new Kibetsu(KibetsuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static Kibetsu sut;
        private static Kibetsu result;

        @Before
        public void setUp() {
            KibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            KibetsuEntity.setXXX(主キー名1);
            KibetsuEntity.setXXX(主キー名2);

        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Kibetsu setStateKibetsu(EntityDataState parentState) {
            KibetsuEntity.setState(parentState);
            return new Kibetsu(KibetsuEntity);
        }
    }
}
