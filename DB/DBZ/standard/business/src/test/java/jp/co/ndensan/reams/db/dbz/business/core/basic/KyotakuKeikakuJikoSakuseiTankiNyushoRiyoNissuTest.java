/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator;
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
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuTest extends DbzTestBase {

    private static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(null, 対象年月, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(被保険者番号, null, 履歴番号);
        }

//        @Test(expected = NullPointerException.class)
//        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(被保険者番号, 対象年月, null);
//        }

        @Test
        public void 指定したキーが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get対象年月(), is(対象年月));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(被保険者番号, 対象年月, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(null);
        }

        @Test
        public void 指定したDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get対象年月(), is(対象年月));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getRirekiNo()));
        }

        @Test
        public void get前回迄利用日数は_entityが持つ前回迄利用日数を返す() {
            assertThat(sut.get前回迄利用日数(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getZenkaiRiyoNissu()));
        }

        @Test
        public void get今回計画利用日数は_entityが持つ今回計画利用日数を返す() {
            assertThat(sut.get今回計画利用日数(), is(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.getKonkaiKeikakuRiyoNissu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);

            sut = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu sut;
        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuが保持するDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu setStateKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(EntityDataState parentState) {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setState(parentState);
            return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);
        }
    }
}
