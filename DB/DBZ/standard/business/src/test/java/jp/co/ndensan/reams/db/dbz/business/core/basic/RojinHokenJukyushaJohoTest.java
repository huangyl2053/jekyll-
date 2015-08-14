/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link RojinHokenJukyushaJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RojinHokenJukyushaJohoTest extends DbzTestBase {

    private static DbT7005RojinHokenJukyushaJohoEntity RojinHokenJukyushaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            識別コード = null;
            sut = new RojinHokenJukyushaJoho(識別コード);
        }

        @Test
        public void 指定したキーが保持するDbT7005RojinHokenJukyushaJohoEntityにセットされている() {
            sut = new RojinHokenJukyushaJoho(識別コード);
            assertThat(sut.get識別コード(), is(識別コード));
        }

        @Test
        public void 指定したキーが保持するRojinHokenJukyushaJohoIdentifierにセットされている() {
            sut = new RojinHokenJukyushaJoho(識別コード);
//            assertThat(sut.identifier().getXXX(), is(識別コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            識別コード = null;
            sut = new RojinHokenJukyushaJoho(識別コード);
        }

        @Test
        public void 指定したDbT7005RojinHokenJukyushaJohoEntityのキー情報を識別子が持つ() {

            sut = new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);

//            assertThat(sut.identifier().getXXX(), is(識別コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);

            sut = new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(RojinHokenJukyushaJohoEntity.getShikibetsuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(RojinHokenJukyushaJohoEntity.getShichosonCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(RojinHokenJukyushaJohoEntity.getHihokenshaNo()));
        }

        @Test
        public void get老人保健市町村コードは_entityが持つ老人保健市町村コードを返す() {
            assertThat(sut.get老人保健市町村コード(), is(RojinHokenJukyushaJohoEntity.getRojinHokenShichosonCode()));
        }

        @Test
        public void get老人保健受給者番号は_entityが持つ老人保健受給者番号を返す() {
            assertThat(sut.get老人保健受給者番号(), is(RojinHokenJukyushaJohoEntity.getRojinHokenJukyushaNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);

            sut = new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RojinHokenJukyushaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);

            sut = new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static RojinHokenJukyushaJoho sut;
        private static RojinHokenJukyushaJoho result;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);

        }

        @Test
        public void RojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがDeletedに指定されたRojinHokenJukyushaJohoが返る() {
            sut = TestSupport.setStateRojinHokenJukyushaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがDeletedに指定されたRojinHokenJukyushaJohoが返る() {
            sut = TestSupport.setStateRojinHokenJukyushaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがDeletedに指定されたRojinHokenJukyushaJohoが返る() {
            sut = TestSupport.setStateRojinHokenJukyushaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RojinHokenJukyushaJohoが保持するDbT7005RojinHokenJukyushaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRojinHokenJukyushaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RojinHokenJukyushaJoho setStateRojinHokenJukyushaJoho(EntityDataState parentState) {
            RojinHokenJukyushaJohoEntity.setState(parentState);
            return new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);
        }
    }
}
