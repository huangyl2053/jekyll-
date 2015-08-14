/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator;
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
 * {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuTekiyoJogaiShisetsuNoHenkanTest extends DbzTestBase {

    private static DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧適用除外施設番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧適用除外施設番号 = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(null, 旧適用除外施設番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧適用除外施設番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(市町村コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityにセットされている() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(市町村コード, 旧適用除外施設番号);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get旧適用除外施設番号(), is(旧適用除外施設番号));
        }

        @Test
        public void 指定したキーが保持するShinKyuTekiyoJogaiShisetsuNoHenkanIdentifierにセットされている() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(市町村コード, 旧適用除外施設番号);
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(旧適用除外施設番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(null);
        }

        @Test
        public void 指定したDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);

//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(旧適用除外施設番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);

            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.getShichosonCode()));
        }

        @Test
        public void get新適用除外施設番号は_entityが持つ新適用除外施設番号を返す() {
            assertThat(sut.get新適用除外施設番号(), is(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.getShinTekiyoJogaiShisetsuNo()));
        }

        @Test
        public void get旧適用除外施設番号は_entityが持つ旧適用除外施設番号を返す() {
            assertThat(sut.get旧適用除外施設番号(), is(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.getKyuTekiyoJogaiShisetsuNo()));
        }

        @Test
        public void get市町村コード２は_entityが持つ市町村コード２を返す() {
            assertThat(sut.get市町村コード２(), is(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.getShichosonCode2()));
        }

        @Test
        public void get旧適用除外施設番号２は_entityが持つ旧適用除外施設番号２を返す() {
            assertThat(sut.get旧適用除外施設番号２(), is(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.getKyuTekiyoJogaiShisetsuNo2()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);

            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);

            sut = new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkan sut;
        private static ShinKyuTekiyoJogaiShisetsuNoHenkan result;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);

        }

        @Test
        public void ShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuTekiyoJogaiShisetsuNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuTekiyoJogaiShisetsuNoHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuTekiyoJogaiShisetsuNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuTekiyoJogaiShisetsuNoHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがDeletedに指定されたShinKyuTekiyoJogaiShisetsuNoHenkanが返る() {
            sut = TestSupport.setStateShinKyuTekiyoJogaiShisetsuNoHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShinKyuTekiyoJogaiShisetsuNoHenkanが保持するDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShinKyuTekiyoJogaiShisetsuNoHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShinKyuTekiyoJogaiShisetsuNoHenkan setStateShinKyuTekiyoJogaiShisetsuNoHenkan(EntityDataState parentState) {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setState(parentState);
            return new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);
        }
    }
}
