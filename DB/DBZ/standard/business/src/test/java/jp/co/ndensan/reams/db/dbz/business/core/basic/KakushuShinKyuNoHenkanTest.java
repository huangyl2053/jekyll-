/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link KakushuShinKyuNoHenkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KakushuShinKyuNoHenkanTest extends DbzTestBase {

    private static DbT7028KakushuShinKyuNoHenkanEntity KakushuShinKyuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 番号区分;
    private static RString 旧番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
        番号区分 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
        旧番号 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuShinKyuNoHenkan(null, 番号区分, 旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 番号区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuShinKyuNoHenkan(被保険者番号, null, 旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuShinKyuNoHenkan(被保険者番号, 番号区分, null);
        }

        @Test
        public void 指定したキーが保持するDbT7028KakushuShinKyuNoHenkanEntityにセットされている() {
            sut = new KakushuShinKyuNoHenkan(被保険者番号, 番号区分, 旧番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get番号区分(), is(番号区分));
        }

        @Test
        public void 指定したキーが保持するKakushuShinKyuNoHenkanIdentifierにセットされている() {
            sut = new KakushuShinKyuNoHenkan(被保険者番号, 番号区分, 旧番号);
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(番号区分));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KakushuShinKyuNoHenkan(null);
        }

        @Test
        public void 指定したDbT7028KakushuShinKyuNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);

//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(番号区分));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);

            sut = new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KakushuShinKyuNoHenkanEntity.getHihokenshaNo()));
        }

        @Test
        public void get番号区分は_entityが持つ番号区分を返す() {
            assertThat(sut.get番号区分(), is(KakushuShinKyuNoHenkanEntity.getNoKubun()));
        }

        @Test
        public void get新番号は_entityが持つ新番号を返す() {
            assertThat(sut.get新番号(), is(KakushuShinKyuNoHenkanEntity.getShinNo()));
        }

        @Test
        public void get旧番号は_entityが持つ旧番号を返す() {
            assertThat(sut.get旧番号(), is(KakushuShinKyuNoHenkanEntity.getKyuNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);

            sut = new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KakushuShinKyuNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);

            sut = new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KakushuShinKyuNoHenkan sut;
        private static KakushuShinKyuNoHenkan result;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);

        }

        @Test
        public void KakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたKakushuShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateKakushuShinKyuNoHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたKakushuShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateKakushuShinKyuNoHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたKakushuShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateKakushuShinKyuNoHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KakushuShinKyuNoHenkanが保持するDbT7028KakushuShinKyuNoHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKakushuShinKyuNoHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KakushuShinKyuNoHenkan setStateKakushuShinKyuNoHenkan(EntityDataState parentState) {
            KakushuShinKyuNoHenkanEntity.setState(parentState);
            return new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);
        }
    }
}
