/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1002TekiyoJogaishaEntityGenerator;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TekiyoJogaishaAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaAliveTest extends DbxTestBase {

    private static DbV1002TekiyoJogaishaEntity TekiyoJogaishaAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static FlexibleDate 主キー名2;
    private static RString edaNo;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaishaAlive(null, 主キー名2, edaNo);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaishaAlive(主キー名1, null, edaNo);
        }

        @Test
        public void 指定したキーが保持するDbV1002TekiyoJogaishaEntityにセットされている() {
            sut = new TekiyoJogaishaAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.get識別コード(), is(主キー名1));
            assertThat(sut.get異動日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTekiyoJogaishaAliveIdentifierにセットされている() {
            sut = new TekiyoJogaishaAlive(主キー名1, 主キー名2, edaNo);
            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TekiyoJogaishaAlive(null);
        }

        @Test
        public void 指定したDbV1002TekiyoJogaishaEntityのキー情報を識別子が持つ() {

            sut = new TekiyoJogaishaAlive(TekiyoJogaishaAliveEntity);

            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get異動日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);

            sut = new TekiyoJogaishaAlive(TekiyoJogaishaAliveEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TekiyoJogaishaAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(TekiyoJogaishaAliveEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(TekiyoJogaishaAliveEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TekiyoJogaishaAliveEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TekiyoJogaishaAliveEntity.getShichosonCode()));
        }

        @Test
        public void get適用除外適用事由コードは_entityが持つ適用除外適用事由コードを返す() {
            assertThat(sut.get適用除外適用事由コード(), is(TekiyoJogaishaAliveEntity.getTekiyoJogaiTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(TekiyoJogaishaAliveEntity.getTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(TekiyoJogaishaAliveEntity.getTekiyoTodokedeYMD()));
        }

        @Test
        public void get適用受付年月日は_entityが持つ適用受付年月日を返す() {
            assertThat(sut.get適用受付年月日(), is(TekiyoJogaishaAliveEntity.getTekiyoUketsukeYMD()));
        }

        @Test
        public void get適用除外解除事由コードは_entityが持つ適用除外解除事由コードを返す() {
            assertThat(sut.get適用除外解除事由コード(), is(TekiyoJogaishaAliveEntity.getTekiyoJogaikaijokaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(TekiyoJogaishaAliveEntity.getKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(TekiyoJogaishaAliveEntity.getKaijoTodokedeYMD()));
        }

        @Test
        public void get解除受付年月日は_entityが持つ解除受付年月日を返す() {
            assertThat(sut.get解除受付年月日(), is(TekiyoJogaishaAliveEntity.getKaijoUketsukeYMD()));
        }

        @Test
        public void get入所通知発行日は_entityが持つ入所通知発行日を返す() {
            assertThat(sut.get入所通知発行日(), is(TekiyoJogaishaAliveEntity.getNyushoTsuchiHakkoYMD()));
        }

        @Test
        public void get退所通知発行日は_entityが持つ退所通知発行日を返す() {
            assertThat(sut.get退所通知発行日(), is(TekiyoJogaishaAliveEntity.getTaishoTsuchiHakkoYMD()));
        }

        @Test
        public void get変更通知発行日は_entityが持つ変更通知発行日を返す() {
            assertThat(sut.get変更通知発行日(), is(TekiyoJogaishaAliveEntity.getHenkoTsuchiHakkoYMD()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(TekiyoJogaishaAliveEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);

            sut = new TekiyoJogaishaAlive(TekiyoJogaishaAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TekiyoJogaishaAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);

            sut = new TekiyoJogaishaAlive(TekiyoJogaishaAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static TekiyoJogaishaAlive sut;
        private static TekiyoJogaishaAlive result;

        @Before
        public void setUp() {
            TekiyoJogaishaAliveEntity = DbV1002TekiyoJogaishaEntityGenerator.createDbV1002TekiyoJogaishaEntity();
            TekiyoJogaishaAliveEntity.setShikibetsuCode(主キー名1);
            TekiyoJogaishaAliveEntity.setIdoYMD(主キー名2);

        }

        @Test
        public void TekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaAliveが返る() {
            sut = TestSupport.setStateTekiyoJogaishaAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaAliveが返る() {
            sut = TestSupport.setStateTekiyoJogaishaAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaAliveが返る() {
            sut = TestSupport.setStateTekiyoJogaishaAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TekiyoJogaishaAliveが保持するDbV1002TekiyoJogaishaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTekiyoJogaishaAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TekiyoJogaishaAlive setStateTekiyoJogaishaAlive(EntityDataState parentState) {
            TekiyoJogaishaAliveEntity.setState(parentState);
            return new TekiyoJogaishaAlive(TekiyoJogaishaAliveEntity);
        }
    }
}
