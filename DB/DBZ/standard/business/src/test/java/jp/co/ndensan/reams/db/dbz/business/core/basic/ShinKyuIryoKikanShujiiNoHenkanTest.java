/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinKyuIryoKikanShujiiNoHenkan}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShinKyuIryoKikanShujiiNoHenkanTest extends DbzTestBase {

    private static DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity ShinKyuIryoKikanShujiiNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧医療機関番号;
    private static RString 旧主治医番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧医療機関番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号;
        旧主治医番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuIryoKikanShujiiNoHenkan(null, 旧医療機関番号, 旧主治医番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧医療機関番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuIryoKikanShujiiNoHenkan(市町村コード, null, 旧主治医番号);
        }

        @Test
        public void 指定したキーが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityにセットされている() {
            sut = new ShinKyuIryoKikanShujiiNoHenkan(市町村コード, 旧医療機関番号, 旧主治医番号);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get旧医療機関番号(), is(旧医療機関番号));
            assertThat(sut.get旧主治医番号(), is(旧主治医番号));
        }

        @Test
        public void 指定したキーが保持するShinKyuIryoKikanShujiiNoHenkanIdentifierにセットされている() {
            sut = new ShinKyuIryoKikanShujiiNoHenkan(市町村コード, 旧医療機関番号, 旧主治医番号);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get旧医療機関番号(), is(旧医療機関番号));
            assertThat(sut.identifier().get旧主治医番号(), is(旧主治医番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinKyuIryoKikanShujiiNoHenkan(null);
        }

        @Test
        public void 指定したDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get旧医療機関番号(), is(旧医療機関番号));
            assertThat(sut.identifier().get旧主治医番号(), is(旧主治医番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);

            sut = new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getShichosonCode()));
        }

        @Test
        public void get新医療機関番号は_entityが持つ新医療機関番号を返す() {
            assertThat(sut.get新医療機関番号(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getShinIryoKikanNo()));
        }

        @Test
        public void get新主治医番号は_entityが持つ新主治医番号を返す() {
            assertThat(sut.get新主治医番号(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getShinShujiiNo()));
        }

        @Test
        public void get旧医療機関番号は_entityが持つ旧医療機関番号を返す() {
            assertThat(sut.get旧医療機関番号(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getKyuIryoKikanNo()));
        }

        @Test
        public void get旧主治医番号は_entityが持つ旧主治医番号を返す() {
            assertThat(sut.get旧主治医番号(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getKyuShujiiNo()));
        }

        @Test
        public void get市町村コード２は_entityが持つ市町村コード２を返す() {
            assertThat(sut.get市町村コード２(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getShichosonCode2()));
        }

        @Test
        public void get旧医療機関番号２は_entityが持つ旧医療機関番号２を返す() {
            assertThat(sut.get旧医療機関番号２(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getKyuIryoKikanNo2()));
        }

        @Test
        public void get旧主治医番号２は_entityが持つ旧主治医番号２を返す() {
            assertThat(sut.get旧主治医番号２(), is(ShinKyuIryoKikanShujiiNoHenkanEntity.getKyuShujiiNo2()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);

            sut = new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinKyuIryoKikanShujiiNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);

            sut = new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkan sut;
        private static ShinKyuIryoKikanShujiiNoHenkan result;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);

        }

        @Test
        public void ShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuIryoKikanShujiiNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuIryoKikanShujiiNoHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuIryoKikanShujiiNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuIryoKikanShujiiNoHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuIryoKikanShujiiNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuIryoKikanShujiiNoHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinKyuIryoKikanShujiiNoHenkanが保持するDbT7030ShinKyuIryoKikanShujiiNoHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinKyuIryoKikanShujiiNoHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinKyuIryoKikanShujiiNoHenkan setStateShinKyuIryoKikanShujiiNoHenkan(EntityDataState parentState) {
            ShinKyuIryoKikanShujiiNoHenkanEntity.setState(parentState);
            return new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);
        }
    }
}
