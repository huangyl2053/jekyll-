/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link TashichosonJushochiTokurei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiTest extends DbzTestBase {

    private static DbT1003TashichosonJushochiTokureiEntity TashichosonJushochiTokureiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
        異動日 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_枝番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new TashichosonJushochiTokurei(null, 異動日, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TashichosonJushochiTokurei(識別コード, null, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TashichosonJushochiTokurei(識別コード, 異動日, null);
        }

        @Test
        public void 指定したキーが保持するDbT1003TashichosonJushochiTokureiEntityにセットされている() {
            sut = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get異動日(), is(異動日));
            assertThat(sut.get枝番(), is(枝番));
        }

        @Test
        public void 指定したキーが保持するTashichosonJushochiTokureiIdentifierにセットされている() {
            sut = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TashichosonJushochiTokurei(null);
        }

        @Test
        public void 指定したDbT1003TashichosonJushochiTokureiEntityのキー情報を識別子が持つ() {

            sut = new TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);

            sut = new TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TashichosonJushochiTokureiEntity.getShikibetsuCode()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(TashichosonJushochiTokureiEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(TashichosonJushochiTokureiEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TashichosonJushochiTokureiEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TashichosonJushochiTokureiEntity.getShichosonCode()));
        }

        @Test
        public void get他市町村住所地特例適用事由コードは_entityが持つ他市町村住所地特例適用事由コードを返す() {
            assertThat(sut.get他市町村住所地特例適用事由コード(), is(TashichosonJushochiTokureiEntity.getTekiyoJiyuCode().getColumnValue().getColumnValue()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(TashichosonJushochiTokureiEntity.getTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(TashichosonJushochiTokureiEntity.getTekiyoTodokedeYMD()));
        }

        @Test
        public void get適用受付年月日は_entityが持つ適用受付年月日を返す() {
            assertThat(sut.get適用受付年月日(), is(TashichosonJushochiTokureiEntity.getTekiyoUketsukeYMD()));
        }

        @Test
        public void get他市町村住所地特例解除事由コードは_entityが持つ他市町村住所地特例解除事由コードを返す() {
            assertThat(sut.get他市町村住所地特例解除事由コード(), is(TashichosonJushochiTokureiEntity.getKaijoJiyuCode().getColumnValue().getColumnValue()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(TashichosonJushochiTokureiEntity.getKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(TashichosonJushochiTokureiEntity.getKaijoTodokedeYMD()));
        }

        @Test
        public void get解除受付年月日は_entityが持つ解除受付年月日を返す() {
            assertThat(sut.get解除受付年月日(), is(TashichosonJushochiTokureiEntity.getKaijoUketsukeYMD()));
        }

        @Test
        public void get措置保険者番号は_entityが持つ措置保険者番号を返す() {
            assertThat(sut.get措置保険者番号(), is(TashichosonJushochiTokureiEntity.getSochiHokenshaNo()));
        }

        @Test
        public void get措置被保険者番号は_entityが持つ措置被保険者番号を返す() {
            assertThat(sut.get措置被保険者番号(), is(TashichosonJushochiTokureiEntity.getSochiHihokenshaNo()));
        }

        @Test
        public void get他特例連絡票発行年月日は_entityが持つ他特例連絡票発行年月日を返す() {
            assertThat(sut.get他特例連絡票発行年月日(), is(TashichosonJushochiTokureiEntity.getTatokuRenrakuhyoHakkoYMD()));
        }

        @Test
        public void get施設退所通知発行年月日は_entityが持つ施設退所通知発行年月日を返す() {
            assertThat(sut.get施設退所通知発行年月日(), is(TashichosonJushochiTokureiEntity.getShisetsuTaishoTsuchiHakkoYMD()));
        }

        @Test
        public void get施設変更通知発行年月日は_entityが持つ施設変更通知発行年月日を返す() {
            assertThat(sut.get施設変更通知発行年月日(), is(TashichosonJushochiTokureiEntity.getShisetsuHenkoTsuchiHakkoYMD()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(TashichosonJushochiTokureiEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);

            sut = new TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TashichosonJushochiTokureiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);

            sut = new TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static TashichosonJushochiTokurei sut;
        private static TashichosonJushochiTokurei result;

        @Before
        public void setUp() {
            TashichosonJushochiTokureiEntity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            TashichosonJushochiTokureiEntity.setShikibetsuCode(識別コード);
            TashichosonJushochiTokureiEntity.setIdoYMD(異動日);
            TashichosonJushochiTokureiEntity.setEdaNo(枝番);

        }

        @Test
        public void TashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokurei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokurei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがDeletedに指定されたTashichosonJushochiTokureiが返る() {
            sut = TestSupport.setStateTashichosonJushochiTokurei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TashichosonJushochiTokureiが保持するDbT1003TashichosonJushochiTokureiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTashichosonJushochiTokurei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TashichosonJushochiTokurei setStateTashichosonJushochiTokurei(EntityDataState parentState) {
            TashichosonJushochiTokureiEntity.setState(parentState);
            return new TashichosonJushochiTokurei(TashichosonJushochiTokureiEntity);
        }
    }
}
