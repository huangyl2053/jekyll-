/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TekiyoJogaisha}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class TekiyoJogaishaTest extends DbzTestBase {

    private static DbT1002TekiyoJogaishaEntity TekiyoJogaishaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
        識別コード = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
        異動日 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaisha(null, 異動日, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaisha(識別コード, null, 枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TekiyoJogaisha(識別コード, 異動日, null);
        }

        @Test
        public void 指定したキーが保持するDbT1002TekiyoJogaishaEntityにセットされている() {
            sut = new TekiyoJogaisha(識別コード, 異動日, 枝番);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get異動日(), is(異動日));
            assertThat(sut.get枝番(), is(枝番));
        }

        @Test
        public void 指定したキーが保持するTekiyoJogaishaIdentifierにセットされている() {
            sut = new TekiyoJogaisha(識別コード, 異動日, 枝番);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TekiyoJogaisha(null);
        }

        @Test
        public void 指定したDbT1002TekiyoJogaishaEntityのキー情報を識別子が持つ() {

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get異動日(), is(異動日));
            assertThat(sut.identifier().get枝番(), is(枝番));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(TekiyoJogaishaEntity.getShikibetsuCode()));
        }

        @Test
        public void get異動日は_entityが持つ異動日を返す() {
            assertThat(sut.get異動日(), is(TekiyoJogaishaEntity.getIdoYMD()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(TekiyoJogaishaEntity.getEdaNo()));
        }

        @Test
        public void get異動事由コードは_entityが持つ異動事由コードを返す() {
            assertThat(sut.get異動事由コード(), is(TekiyoJogaishaEntity.getIdoJiyuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(TekiyoJogaishaEntity.getShichosonCode()));
        }

        @Test
        public void get適用除外適用事由コードは_entityが持つ適用除外適用事由コードを返す() {
            assertThat(sut.get適用除外適用事由コード(), is(TekiyoJogaishaEntity.getTekiyoJogaiTekiyoJiyuCode()));
        }

        @Test
        public void get適用年月日は_entityが持つ適用年月日を返す() {
            assertThat(sut.get適用年月日(), is(TekiyoJogaishaEntity.getTekiyoYMD()));
        }

        @Test
        public void get適用届出年月日は_entityが持つ適用届出年月日を返す() {
            assertThat(sut.get適用届出年月日(), is(TekiyoJogaishaEntity.getTekiyoTodokedeYMD()));
        }

        @Test
        public void get適用受付年月日は_entityが持つ適用受付年月日を返す() {
            assertThat(sut.get適用受付年月日(), is(TekiyoJogaishaEntity.getTekiyoUketsukeYMD()));
        }

        @Test
        public void get適用除外解除事由コードは_entityが持つ適用除外解除事由コードを返す() {
            assertThat(sut.get適用除外解除事由コード(), is(TekiyoJogaishaEntity.getTekiyoJogaikaijokaijoJiyuCode()));
        }

        @Test
        public void get解除年月日は_entityが持つ解除年月日を返す() {
            assertThat(sut.get解除年月日(), is(TekiyoJogaishaEntity.getKaijoYMD()));
        }

        @Test
        public void get解除届出年月日は_entityが持つ解除届出年月日を返す() {
            assertThat(sut.get解除届出年月日(), is(TekiyoJogaishaEntity.getKaijoTodokedeYMD()));
        }

        @Test
        public void get解除受付年月日は_entityが持つ解除受付年月日を返す() {
            assertThat(sut.get解除受付年月日(), is(TekiyoJogaishaEntity.getKaijoUketsukeYMD()));
        }

        @Test
        public void get入所通知発行日は_entityが持つ入所通知発行日を返す() {
            assertThat(sut.get入所通知発行日(), is(TekiyoJogaishaEntity.getNyushoTsuchiHakkoYMD()));
        }

        @Test
        public void get退所通知発行日は_entityが持つ退所通知発行日を返す() {
            assertThat(sut.get退所通知発行日(), is(TekiyoJogaishaEntity.getTaishoTsuchiHakkoYMD()));
        }

        @Test
        public void get変更通知発行日は_entityが持つ変更通知発行日を返す() {
            assertThat(sut.get変更通知発行日(), is(TekiyoJogaishaEntity.getHenkoTsuchiHakkoYMD()));
        }

        @Test
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(TekiyoJogaishaEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TekiyoJogaishaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);

            sut = new TekiyoJogaisha(TekiyoJogaishaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static TekiyoJogaisha sut;
        private static TekiyoJogaisha result;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);

        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがDeletedに指定されたTekiyoJogaishaが返る() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TekiyoJogaishaが保持するDbT1002TekiyoJogaishaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTekiyoJogaisha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TekiyoJogaisha setStateTekiyoJogaisha(EntityDataState parentState) {
            TekiyoJogaishaEntity.setState(parentState);
            return new TekiyoJogaisha(TekiyoJogaishaEntity);
        }
    }
}
