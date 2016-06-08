/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator;
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
 * {@link KakushuCodeHenkan}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KakushuCodeHenkanTest extends DbzTestBase {

    private static DbT7027KakushuCodeHenkanEntity KakushuCodeHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString コード区分;
    private static RString 外部コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
        外部コード = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuCodeHenkan(null, コード区分, 外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void コード区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuCodeHenkan(市町村コード, null, 外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void 外部コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KakushuCodeHenkan(市町村コード, コード区分, null);
        }

        @Test
        public void 指定したキーが保持するDbT7027KakushuCodeHenkanEntityにセットされている() {
            sut = new KakushuCodeHenkan(市町村コード, コード区分, 外部コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.getコード区分(), is(コード区分));
        }

        @Test
        public void 指定したキーが保持するKakushuCodeHenkanIdentifierにセットされている() {
            sut = new KakushuCodeHenkan(市町村コード, コード区分, 外部コード);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().getコード区分(), is(コード区分));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KakushuCodeHenkan(null);
        }

        @Test
        public void 指定したDbT7027KakushuCodeHenkanEntityのキー情報を識別子が持つ() {

            sut = new KakushuCodeHenkan(KakushuCodeHenkanEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().getコード区分(), is(コード区分));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);

            sut = new KakushuCodeHenkan(KakushuCodeHenkanEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KakushuCodeHenkanEntity.getShichosonCode()));
        }

        @Test
        public void getコード区分は_entityが持つコード区分を返す() {
            assertThat(sut.getコード区分(), is(KakushuCodeHenkanEntity.getCodeKubun()));
        }

        @Test
        public void get内部コードは_entityが持つ内部コードを返す() {
            assertThat(sut.get内部コード(), is(KakushuCodeHenkanEntity.getNaibuCode()));
        }

        @Test
        public void get内部番号は_entityが持つ内部番号を返す() {
            assertThat(sut.get内部番号(), is(KakushuCodeHenkanEntity.getNaibuNo()));
        }

        @Test
        public void get外部コードは_entityが持つ外部コードを返す() {
            assertThat(sut.get外部コード(), is(KakushuCodeHenkanEntity.getGaibuCode()));
        }

        @Test
        public void get市町村コード２は_entityが持つ市町村コード２を返す() {
            assertThat(sut.get市町村コード２(), is(KakushuCodeHenkanEntity.getShichosonCode2()));
        }

        @Test
        public void get外部コード２は_entityが持つ外部コード２を返す() {
            assertThat(sut.get外部コード２(), is(KakushuCodeHenkanEntity.getGaibuCode2()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);

            sut = new KakushuCodeHenkan(KakushuCodeHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KakushuCodeHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);

            sut = new KakushuCodeHenkan(KakushuCodeHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KakushuCodeHenkan sut;
        private static KakushuCodeHenkan result;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);

        }

        @Test
        public void KakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがDeletedに指定されたKakushuCodeHenkanが返る() {
            sut = TestSupport.setStateKakushuCodeHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがDeletedに指定されたKakushuCodeHenkanが返る() {
            sut = TestSupport.setStateKakushuCodeHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがDeletedに指定されたKakushuCodeHenkanが返る() {
            sut = TestSupport.setStateKakushuCodeHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KakushuCodeHenkanが保持するDbT7027KakushuCodeHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKakushuCodeHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KakushuCodeHenkan setStateKakushuCodeHenkan(EntityDataState parentState) {
            KakushuCodeHenkanEntity.setState(parentState);
            return new KakushuCodeHenkan(KakushuCodeHenkanEntity);
        }
    }
}
