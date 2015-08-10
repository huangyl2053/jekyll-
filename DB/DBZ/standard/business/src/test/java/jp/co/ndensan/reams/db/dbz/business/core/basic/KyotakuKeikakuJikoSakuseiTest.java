/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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

/**
 * {@link KyotakuKeikakuJikoSakusei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTest extends DbzTestBase {

    private static DbT3007KyotakuKeikakuJikoSakuseiEntity KyotakuKeikakuJikoSakuseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakusei(null, 対象年月, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakusei(被保険者番号, null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakusei(被保険者番号, 対象年月, null);
        }

        @Test
        public void 指定したキーが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakusei(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get対象年月(), is(対象年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakusei(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakusei(null);
        }

        @Test
        public void 指定したDbT3007KyotakuKeikakuJikoSakuseiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikoSakuseiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikoSakuseiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikoSakuseiEntity.getRirekiNo()));
        }

        @Test
        public void get居宅_総合事業区分は_entityが持つ居宅_総合事業区分を返す() {
            assertThat(sut.get居宅_総合事業区分(), is(KyotakuKeikakuJikoSakuseiEntity.getKyotaku_SogoJigyoKubun()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get作成区分コードは_entityが持つ作成区分コードを返す() {
            assertThat(sut.get作成区分コード(), is(KyotakuKeikakuJikoSakuseiEntity.getSakuseiKubunCode()));
        }

        @Test
        public void get計画作成年月日は_entityが持つ計画作成年月日を返す() {
            assertThat(sut.get計画作成年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuSakuseiYMD()));
        }

        @Test
        public void get計画変更年月日は_entityが持つ計画変更年月日を返す() {
            assertThat(sut.get計画変更年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuHenkoYMD()));
        }

        @Test
        public void get計画変更事由は_entityが持つ計画変更事由を返す() {
            assertThat(sut.get計画変更事由(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuHenkoJiyu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikoSakuseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;
        private static KyotakuKeikakuJikoSakusei result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakusei setStateKyotakuKeikakuJikoSakusei(EntityDataState parentState) {
            KyotakuKeikakuJikoSakuseiEntity.setState(parentState);
            return new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }
    }
}
