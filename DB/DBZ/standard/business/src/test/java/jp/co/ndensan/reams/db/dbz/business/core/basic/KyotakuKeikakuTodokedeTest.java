/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KyotakuKeikakuTodokede}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeTest extends DbzTestBase {

    private static DbT3005KyotakuKeikakuTodokedeEntity KyotakuKeikakuTodokedeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuTodokede(null, 対象年月, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuTodokede(被保険者番号, null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuTodokede(被保険者番号, 対象年月, null);
        }

        @Test
        public void 指定したキーが保持するDbT3005KyotakuKeikakuTodokedeEntityにセットされている() {
            sut = new KyotakuKeikakuTodokede(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get対象年月(), is(対象年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuTodokedeIdentifierにセットされている() {
            sut = new KyotakuKeikakuTodokede(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuTodokede(null);
        }

        @Test
        public void 指定したDbT3005KyotakuKeikakuTodokedeEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuTodokedeEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuTodokedeEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuTodokedeEntity.getRirekiNo()));
        }

        @Test
        public void get届出区分は_entityが持つ届出区分を返す() {
            assertThat(sut.get届出区分(), is(KyotakuKeikakuTodokedeEntity.getTodokedeKubun()));
        }

        @Test
        public void get届出年月日は_entityが持つ届出年月日を返す() {
            assertThat(sut.get届出年月日(), is(KyotakuKeikakuTodokedeEntity.getTodokedeYMD()));
        }

        @Test
        public void get届出者氏名は_entityが持つ届出者氏名を返す() {
            assertThat(sut.get届出者氏名(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaShimei()));
        }

        @Test
        public void get届出者氏名カナは_entityが持つ届出者氏名カナを返す() {
            assertThat(sut.get届出者氏名カナ(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaShimeiKana()));
        }

        @Test
        public void get届出者郵便番号は_entityが持つ届出者郵便番号を返す() {
            assertThat(sut.get届出者郵便番号(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaYubinNo()));
        }

        @Test
        public void get届出者住所は_entityが持つ届出者住所を返す() {
            assertThat(sut.get届出者住所(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaJusho()));
        }

        @Test
        public void get届出者電話番号は_entityが持つ届出者電話番号を返す() {
            assertThat(sut.get届出者電話番号(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaTelNo()));
        }

        @Test
        public void get届出者関係区分は_entityが持つ届出者関係区分を返す() {
            assertThat(sut.get届出者関係区分(), is(KyotakuKeikakuTodokedeEntity.getTodokedeshaKankeiKubun()));
        }

        @Test
        public void get暫定区分は_entityが持つ暫定区分を返す() {
            assertThat(sut.get暫定区分(), is(KyotakuKeikakuTodokedeEntity.getZanteiKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuTodokedeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuTodokede sut;
        private static KyotakuKeikakuTodokede result;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuTodokedeが返る() {
            sut = TestSupport.setStateKyotakuKeikakuTodokede(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuTodokedeが返る() {
            sut = TestSupport.setStateKyotakuKeikakuTodokede(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuTodokedeが返る() {
            sut = TestSupport.setStateKyotakuKeikakuTodokede(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuTodokedeが保持するDbT3005KyotakuKeikakuTodokedeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuTodokede(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuTodokede setStateKyotakuKeikakuTodokede(EntityDataState parentState) {
            KyotakuKeikakuTodokedeEntity.setState(parentState);
            return new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);
        }
    }
}
