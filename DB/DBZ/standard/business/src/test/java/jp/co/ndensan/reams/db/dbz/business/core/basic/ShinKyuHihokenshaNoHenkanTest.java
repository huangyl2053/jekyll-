/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link ShinKyuHihokenshaNoHenkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuHihokenshaNoHenkanTest extends DbzTestBase {

    private static DbT7026ShinKyuHihokenshaNoHenkanEntity ShinKyuHihokenshaNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧番号 = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuHihokenshaNoHenkan(null, 旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuHihokenshaNoHenkan(市町村コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityにセットされている() {
            sut = new ShinKyuHihokenshaNoHenkan(市町村コード, 旧番号);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get旧番号(), is(旧番号));
        }

        @Test
        public void 指定したキーが保持するShinKyuHihokenshaNoHenkanIdentifierにセットされている() {
            sut = new ShinKyuHihokenshaNoHenkan(市町村コード, 旧番号);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get旧番号(), is(旧番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinKyuHihokenshaNoHenkan(null);
        }

        @Test
        public void 指定したDbT7026ShinKyuHihokenshaNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get旧番号(), is(旧番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);

            sut = new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShinKyuHihokenshaNoHenkanEntity.getShichosonCode()));
        }

        @Test
        public void get新番号は_entityが持つ新番号を返す() {
            assertThat(sut.get新番号(), is(ShinKyuHihokenshaNoHenkanEntity.getShinNo()));
        }

        @Test
        public void get旧番号は_entityが持つ旧番号を返す() {
            assertThat(sut.get旧番号(), is(ShinKyuHihokenshaNoHenkanEntity.getKyuNo()));
        }

        @Test
        public void get旧市町村コード２は_entityが持つ旧市町村コード２を返す() {
            assertThat(sut.get旧市町村コード２(), is(ShinKyuHihokenshaNoHenkanEntity.getKyuShichosonCode()));
        }

        @Test
        public void get旧番号２は_entityが持つ旧番号２を返す() {
            assertThat(sut.get旧番号２(), is(ShinKyuHihokenshaNoHenkanEntity.getKyuNo2()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);

            sut = new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinKyuHihokenshaNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);

            sut = new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkan sut;
        private static ShinKyuHihokenshaNoHenkan result;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);

        }

        @Test
        public void ShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuHihokenshaNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuHihokenshaNoHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuHihokenshaNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuHihokenshaNoHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuHihokenshaNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuHihokenshaNoHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinKyuHihokenshaNoHenkanが保持するDbT7026ShinKyuHihokenshaNoHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinKyuHihokenshaNoHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinKyuHihokenshaNoHenkan setStateShinKyuHihokenshaNoHenkan(EntityDataState parentState) {
            ShinKyuHihokenshaNoHenkanEntity.setState(parentState);
            return new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);
        }
    }
}
