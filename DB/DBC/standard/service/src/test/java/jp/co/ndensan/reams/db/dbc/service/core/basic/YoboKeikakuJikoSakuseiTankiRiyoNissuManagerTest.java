/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link YoboKeikakuJikoSakuseiTankiRiyoNissuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class YoboKeikakuJikoSakuseiTankiRiyoNissuManagerTest {

    private static DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac dac;
    private static YoboKeikakuJikoSakuseiTankiRiyoNissuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac.class);
        sut = new YoboKeikakuJikoSakuseiTankiRiyoNissuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get予防給付計画自己作成短期利用日数 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_対象年月;
            Decimal 主キー3 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_履歴番号;
            sut.get予防給付計画自己作成短期利用日数(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_履歴番号;
            sut.get予防給付計画自己作成短期利用日数(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_対象年月;
            sut.get予防給付計画自己作成短期利用日数(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_対象年月;
            Decimal 主キー3 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_履歴番号;
            YoboKeikakuJikoSakuseiTankiRiyoNissu result = sut.get予防給付計画自己作成短期利用日数(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

//        @Test
//        public void 検索結果が存在する場合() {
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(entity);
//            HihokenshaNo 主キー1 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号;
//            FlexibleYearMonth 主キー2 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_対象年月;
//            Decimal 主キー3 = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_履歴番号;
//            YoboKeikakuJikoSakuseiTankiRiyoNissu result = sut.get予防給付計画自己作成短期利用日数(主キー1, 主キー2, 主キー3);
//
//            assertThat(result.get被保険者番号().value(), is(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号.value()));
//        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get予防給付計画自己作成短期利用日数一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<YoboKeikakuJikoSakuseiTankiRiyoNissu> result = sut.get予防給付計画自己作成短期利用日数一覧();

            assertThat(result.isEmpty(), is(true));
        }

//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity> entityList = Arrays.asList(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<YoboKeikakuJikoSakuseiTankiRiyoNissu> result = sut.get予防給付計画自己作成短期利用日数一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get被保険者番号().value(), is(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.DEFAULT_被保険者番号.value()));
//        }
    }

    public static class save予防給付計画自己作成短期利用日数 extends DbcTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(1);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(0);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(1);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//            予防給付計画自己作成短期利用日数 = 予防給付計画自己作成短期利用日数.createBuilderForEdit().set前回迄利用日数(new Decimal(11)).build();
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(0);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//            予防給付計画自己作成短期利用日数 = 予防給付計画自己作成短期利用日数.createBuilderForEdit().set前回迄利用日数(new Decimal(11)).build();
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(1);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//            予防給付計画自己作成短期利用日数 = 予防給付計画自己作成短期利用日数.deleted();
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity.class))).thenReturn(0);
//
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//            予防給付計画自己作成短期利用日数 = 予防給付計画自己作成短期利用日数.deleted();
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity entity = DbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntityGenerator.createDbT3013NichijoSeikatsuYoboKeikakuJikoSakuseiTankiNyushoRiyoNissEntity();
//            entity.initializeMd5();
//            YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数 = new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
//
//            assertThat(sut.save予防給付計画自己作成短期利用日数(予防給付計画自己作成短期利用日数), is(false));
//        }
    }
}
