/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link KyufuhiKashitsukeKinKyoseiHenkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufuhiKashitsukeKinKyoseiHenkanTest extends DbcTestBase {

    private static DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity KyufuhiKashitsukeKinKyoseiHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_貸付管理番号;
        主キー名3 = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkan(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkan(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityにセットされている() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkan(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get貸付管理番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukeKinKyoseiHenkanIdentifierにセットされている() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkan(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get貸付管理番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukeKinKyoseiHenkan(null);
        }

        @Test
        public void 指定したDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukeKinKyoseiHenkan(KyufuhiKashitsukeKinKyoseiHenkanEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get貸付管理番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinKyoseiHenkan(KyufuhiKashitsukeKinKyoseiHenkanEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getHihokenshaNo()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getRirekiNo()));
        }

        @Test
        public void get返還金区分は_entityが持つ返還金区分を返す() {
            assertThat(sut.get返還金区分(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getHenkanKinKubun()));
        }

        @Test
        public void get返還金額は_entityが持つ返還金額を返す() {
            assertThat(sut.get返還金額(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getHenkanKingaku()));
        }

        @Test
        public void get返還期限は_entityが持つ返還期限を返す() {
            assertThat(sut.get返還期限(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getHenkanKigenYMD()));
        }

        @Test
        public void get返還理由は_entityが持つ返還理由を返す() {
            assertThat(sut.get返還理由(), is(KyufuhiKashitsukeKinKyoseiHenkanEntity.getHenkanRiyu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinKyoseiHenkan(KyufuhiKashitsukeKinKyoseiHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukeKinKyoseiHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinKyoseiHenkan(KyufuhiKashitsukeKinKyoseiHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKyoseiHenkan sut;
        private static KyufuhiKashitsukeKinKyoseiHenkan result;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKyoseiHenkanEntity = DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator.createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setKashitsukeKanriNo(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKyoseiHenkanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKyoseiHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKyoseiHenkanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKyoseiHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKyoseiHenkanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKyoseiHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukeKinKyoseiHenkanが保持するDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKyoseiHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukeKinKyoseiHenkan setStateKyufuhiKashitsukeKinKyoseiHenkan(EntityDataState parentState) {
            KyufuhiKashitsukeKinKyoseiHenkanEntity.setState(parentState);
            return new KyufuhiKashitsukeKinKyoseiHenkan(KyufuhiKashitsukeKinKyoseiHenkanEntity);
        }
    }
}
