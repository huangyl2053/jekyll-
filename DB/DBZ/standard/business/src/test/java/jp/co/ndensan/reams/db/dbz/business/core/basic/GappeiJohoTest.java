/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link GappeiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoTest extends DbzTestBase {

    private static DbT7055GappeiJohoEntity gappeiJohoEntity;
    private static FlexibleDate 合併年月日;
    private static RString 地域番号;

    @BeforeClass
    public static void setUpClass() {
        合併年月日 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiJoho(null, 地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiJoho(合併年月日, null);
        }

        @Test
        public void 指定したキーが保持するDbT7055GappeiJohoEntityにセットされている() {
            sut = new GappeiJoho(合併年月日, 地域番号);
            assertThat(sut.get合併年月日(), is(合併年月日));
            assertThat(sut.get地域番号(), is(地域番号));
        }

        @Test
        public void 指定したキーが保持するGappeiJohoIdentifierにセットされている() {
            sut = new GappeiJoho(合併年月日, 地域番号);
            assertThat(sut.identifier().get合併年月日(), is(合併年月日));
            assertThat(sut.identifier().get地域番号(), is(地域番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GappeiJoho(null);
        }

        @Test
        public void 指定したDbT7055GappeiJohoEntityのキー情報を識別子が持つ() {

            sut = new GappeiJoho(gappeiJohoEntity);

            assertThat(sut.identifier().get合併年月日(), is(合併年月日));
            assertThat(sut.identifier().get地域番号(), is(地域番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);

            sut = new GappeiJoho(gappeiJohoEntity);
        }

        @Test
        public void get合併年月日は_entityが持つ合併年月日を返す() {
            assertThat(sut.get合併年月日(), is(gappeiJohoEntity.getGappeiYMD()));
        }

        @Test
        public void get地域番号は_entityが持つ地域番号を返す() {
            assertThat(sut.get地域番号(), is(gappeiJohoEntity.getChiikiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(gappeiJohoEntity.getShichosonCode()));
        }

        @Test
        public void get合併種類は_entityが持つ合併種類を返す() {
            assertThat(sut.get合併種類(), is(gappeiJohoEntity.getGappeiShurui()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(gappeiJohoEntity.getHokenshaNo()));
        }

        @Test
        public void get旧市町村情報付与終了年月日は_entityが持つ旧市町村情報付与終了年月日を返す() {
            assertThat(sut.get旧市町村情報付与終了年月日(), is(gappeiJohoEntity.getKyuJohoFuyoToYMD()));
        }

        @Test
        public void get国保連データ連携開始年月日は_entityが持つ国保連データ連携開始年月日を返す() {
            assertThat(sut.get国保連データ連携開始年月日(), is(gappeiJohoEntity.getKokuhorenDataFromYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);

            sut = new GappeiJoho(gappeiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(gappeiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);

            sut = new GappeiJoho(gappeiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static GappeiJoho sut;
        private static GappeiJoho result;

        @Before
        public void setUp() {
            gappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoEntity.setGappeiYMD(合併年月日);
            gappeiJohoEntity.setChiikiNo(地域番号);

        }

        @Test
        public void GappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりGappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがDeletedに指定されたGappeiJohoが返る() {
            sut = TestSupport.setStateGappeiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりGappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがDeletedに指定されたGappeiJohoが返る() {
            sut = TestSupport.setStateGappeiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりGappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがDeletedに指定されたGappeiJohoが返る() {
            sut = TestSupport.setStateGappeiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void GappeiJohoが保持するDbT7055GappeiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateGappeiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static GappeiJoho setStateGappeiJoho(EntityDataState parentState) {
            gappeiJohoEntity.setState(parentState);
            return new GappeiJoho(gappeiJohoEntity);
        }
    }
}
