/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link TashichosonJushochiTokureiAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiAliveTest extends DbxTestBase {

    private static DbV1003TashichosonJushochiTokureiEntity TashichosonJushochiTokureiAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static FlexibleDate 主キー名2;
    private static RString edaNo;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TashichosonJushochiTokureiAlive(null, 主キー名2, edaNo);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TashichosonJushochiTokureiAlive(主キー名1, null, edaNo);
        }

        @Test
        public void 指定したキーが保持するDbV1003TashichosonJushochiTokureiEntityにセットされている() {
            sut = new TashichosonJushochiTokureiAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.get識別コード(), is(主キー名1));
            assertThat(sut.get異動日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTashichosonJushochiTokureiAliveIdentifierにセットされている() {
            sut = new TashichosonJushochiTokureiAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TashichosonJushochiTokureiAlive(null);
        }

        @Test
        public void 指定したDbV1003TashichosonJushochiTokureiEntityのキー情報を識別子が持つ() {

            sut = new TashichosonJushochiTokureiAlive(TashichosonJushochiTokureiAliveEntity);

            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);

            sut = new TashichosonJushochiTokureiAlive(TashichosonJushochiTokureiAliveEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TashichosonJushochiTokureiAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(TashichosonJushochiTokureiAliveEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(TashichosonJushochiTokureiAliveEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TashichosonJushochiTokureiAliveEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TashichosonJushochiTokureiAliveEntity.getShichosonCode()));
        }

        @Test
        public void get他市町村住所地特例適用事由コードは_entityが持つ他市町村住所地特例適用事由コードを返す() {
            assertThat(sut.get他市町村住所地特例適用事由コード(), is(TashichosonJushochiTokureiAliveEntity.getTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(TashichosonJushochiTokureiAliveEntity.getTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(TashichosonJushochiTokureiAliveEntity.getTekiyoTodokedeYMD()));
        }

        @Test
        public void get適用受付年月日は_entityが持つ適用受付年月日を返す() {
            assertThat(sut.get適用受付年月日(), is(TashichosonJushochiTokureiAliveEntity.getTekiyoUketsukeYMD()));
        }

        @Test
        public void get他市町村住所地特例解除事由コードは_entityが持つ他市町村住所地特例解除事由コードを返す() {
            assertThat(sut.get他市町村住所地特例解除事由コード(), is(TashichosonJushochiTokureiAliveEntity.getKaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(TashichosonJushochiTokureiAliveEntity.getKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(TashichosonJushochiTokureiAliveEntity.getKaijoTodokedeYMD()));
        }

        @Test
        public void get解除受付年月日は_entityが持つ解除受付年月日を返す() {
            assertThat(sut.get解除受付年月日(), is(TashichosonJushochiTokureiAliveEntity.getKaijoUketsukeYMD()));
        }

        @Test
        public void get措置保険者番号は_entityが持つ措置保険者番号を返す() {
            assertThat(sut.get措置保険者番号(), is(TashichosonJushochiTokureiAliveEntity.getSochiHokenshaNo()));
        }

        @Test
        public void get措置被保険者番号は_entityが持つ措置被保険者番号を返す() {
            assertThat(sut.get措置被保険者番号(), is(TashichosonJushochiTokureiAliveEntity.getSochiHihokenshaNo()));
        }

        @Test
        public void get他特例連絡票発行年月日は_entityが持つ他特例連絡票発行年月日を返す() {
            assertThat(sut.get他特例連絡票発行年月日(), is(TashichosonJushochiTokureiAliveEntity.getTatokuRenrakuhyoHakkoYMD()));
        }

        @Test
        public void get施設退所通知発行年月日は_entityが持つ施設退所通知発行年月日を返す() {
            assertThat(sut.get施設退所通知発行年月日(), is(TashichosonJushochiTokureiAliveEntity.getShisetsuTaishoTsuchiHakkoYMD()));
        }

        @Test
        public void get施設変更通知発行年月日は_entityが持つ施設変更通知発行年月日を返す() {
            assertThat(sut.get施設変更通知発行年月日(), is(TashichosonJushochiTokureiAliveEntity.getShisetsuHenkoTsuchiHakkoYMD()));
        }

        @Test
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(TashichosonJushochiTokureiAliveEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);

            sut = new TashichosonJushochiTokureiAlive(TashichosonJushochiTokureiAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TashichosonJushochiTokureiAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);

            sut = new TashichosonJushochiTokureiAlive(TashichosonJushochiTokureiAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static TashichosonJushochiTokureiAlive sut;
        private static TashichosonJushochiTokureiAlive result;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiAliveEntity = DbV1003TashichosonJushochiTokureiEntityGenerator.createDbV1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiAliveEntity.setShikibetsuCode(主キー名1);
            TashichosonJushochiTokureiAliveEntity.setIdoYMD(主キー名2);

        }

        @Test
        public void TashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiAliveが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokureiAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiAliveが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokureiAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiAliveが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokureiAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TashichosonJushochiTokureiAliveが保持するDbV1003TashichosonJushochiTokureiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTashichosonJushochiTokureiAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TashichosonJushochiTokureiAlive setStateTashichosonJushochiTokureiAlive(EntityDataState parentState) {
            TashichosonJushochiTokureiAliveEntity.setState(parentState);
            return new TashichosonJushochiTokureiAlive(TashichosonJushochiTokureiAliveEntity);
        }
    }
}
