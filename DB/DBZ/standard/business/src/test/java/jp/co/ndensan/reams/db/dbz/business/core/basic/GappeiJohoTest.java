/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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

    private static DbT7055GappeiJohoEntity GappeiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7055GappeiJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7055GappeiJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7055GappeiJohoEntityにセットされている() {
            sut = new GappeiJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するGappeiJohoIdentifierにセットされている() {
            sut = new GappeiJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GappeiJoho(null);
        }

        @Test
        public void 指定したDbT7055GappeiJohoEntityのキー情報を識別子が持つ() {

            sut = new GappeiJoho(GappeiJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);

            sut = new GappeiJoho(GappeiJohoEntity);
        }

        @Test
        public void get合併年月日は_entityが持つ合併年月日を返す() {
            assertThat(sut.get合併年月日(), is(GappeiJohoEntity.getGappeiYMD()));
        }

        @Test
        public void get地域番号は_entityが持つ地域番号を返す() {
            assertThat(sut.get地域番号(), is(GappeiJohoEntity.getChiikiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(GappeiJohoEntity.getShichosonCode()));
        }

        @Test
        public void get合併種類は_entityが持つ合併種類を返す() {
            assertThat(sut.get合併種類(), is(GappeiJohoEntity.getGappeiShurui()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(GappeiJohoEntity.getHokenshaNo()));
        }

        @Test
        public void get旧市町村情報付与終了年月日は_entityが持つ旧市町村情報付与終了年月日を返す() {
            assertThat(sut.get旧市町村情報付与終了年月日(), is(GappeiJohoEntity.getKyuJohoFuyoToYMD()));
        }

        @Test
        public void get国保連データ連携開始年月日は_entityが持つ国保連データ連携開始年月日を返す() {
            assertThat(sut.get国保連データ連携開始年月日(), is(GappeiJohoEntity.getKokuhorenDataFromYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);

            sut = new GappeiJoho(GappeiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(GappeiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GappeiJoho sut;

        @Before
        public void setUp() {
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);

            sut = new GappeiJoho(GappeiJohoEntity);
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
            GappeiJohoEntity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            GappeiJohoEntity.setXXX(主キー名1);
            GappeiJohoEntity.setXXX(主キー名2);

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
            GappeiJohoEntity.setState(parentState);
            return new GappeiJoho(GappeiJohoEntity);
        }
    }
}
