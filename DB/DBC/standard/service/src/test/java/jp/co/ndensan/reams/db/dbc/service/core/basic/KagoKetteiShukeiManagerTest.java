/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoKetteiShukei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3060KagoKetteiShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3060KagoKetteiShukeiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KagoKetteiShukeiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KagoKetteiShukeiManagerTest {

    private static DbT3060KagoKetteiShukeiDac dac;
    private static KagoKetteiShukeiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3060KagoKetteiShukeiDac.class);
        sut = new KagoKetteiShukeiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get過誤決定集計 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
            sut.get過誤決定集計(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
            Decimal 主キー3 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
            sut.get過誤決定集計(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
            sut.get過誤決定集計(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            FlexibleYearMonth 主キー1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
            KagoKetteiShukei result = sut.get過誤決定集計(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            when(dac.selectByKey(any(FlexibleYearMonth.class), any(RString.class), any(Decimal.class))).thenReturn(entity);

            FlexibleYearMonth 主キー1 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
            RString 主キー2 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
            Decimal 主キー3 = DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_履歴番号;
            KagoKetteiShukei result = sut.get過誤決定集計(主キー1, 主キー2, 主キー3);

            assertThat(result.get取扱年月().toDateString(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get過誤決定集計一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KagoKetteiShukei> result = sut.get過誤決定集計一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3060KagoKetteiShukeiEntity> entityList = Arrays.asList(DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KagoKetteiShukei> result = sut.get過誤決定集計一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get取扱年月().toDateString(), is(DbT3060KagoKetteiShukeiEntityGenerator.DEFAULT_取扱年月.toDateString()));
        }
    }

    public static class save過誤決定集計 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(1);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);

            assertThat(sut.save過誤決定集計(過誤決定集計), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(0);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);

            assertThat(sut.save過誤決定集計(過誤決定集計), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(1);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.initializeMd5();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);
            過誤決定集計 = 過誤決定集計.createBuilderForEdit().set保険者区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save過誤決定集計(過誤決定集計), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(0);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.initializeMd5();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);
            過誤決定集計 = 過誤決定集計.createBuilderForEdit().set保険者区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save過誤決定集計(過誤決定集計), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(1);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.initializeMd5();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);
            過誤決定集計 = 過誤決定集計.deleted();

            assertThat(sut.save過誤決定集計(過誤決定集計), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3060KagoKetteiShukeiEntity.class))).thenReturn(0);

            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.initializeMd5();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);
            過誤決定集計 = 過誤決定集計.deleted();

            assertThat(sut.save過誤決定集計(過誤決定集計), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.initializeMd5();
            KagoKetteiShukei 過誤決定集計 = new KagoKetteiShukei(entity);

            assertThat(sut.save過誤決定集計(過誤決定集計), is(false));
        }
    }
}
