/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KogakuKyufuTaishoshaGokeiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuKyufuTaishoshaGokeiManagerTest {

    private static DbT3055KogakuKyufuTaishoshaGokeiDac dac;
    private static KogakuKyufuTaishoshaGokeiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        sut = new KogakuKyufuTaishoshaGokeiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費給付対象者合計 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
            Decimal 主キー3 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者合計(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
            sut.get高額介護サービス費給付対象者合計(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
            sut.get高額介護サービス費給付対象者合計(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
            Decimal 主キー3 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
            KogakuKyufuTaishoshaGokei result = sut.get高額介護サービス費給付対象者合計(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_サービス提供年月;
            Decimal 主キー3 = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_履歴番号;
            KogakuKyufuTaishoshaGokei result = sut.get高額介護サービス費給付対象者合計(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額介護サービス費給付対象者合計一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuKyufuTaishoshaGokei> result = sut.get高額介護サービス費給付対象者合計一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3055KogakuKyufuTaishoshaGokeiEntity> entityList = Arrays.asList(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuKyufuTaishoshaGokei> result = sut.get高額介護サービス費給付対象者合計一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額介護サービス費給付対象者合計 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(1);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(0);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(1);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);
            高額介護サービス費給付対象者合計 = 高額介護サービス費給付対象者合計.createBuilderForEdit().set世帯集約番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(0);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);
            高額介護サービス費給付対象者合計 = 高額介護サービス費給付対象者合計.createBuilderForEdit().set世帯集約番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(1);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);
            高額介護サービス費給付対象者合計 = 高額介護サービス費給付対象者合計.deleted();

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3055KogakuKyufuTaishoshaGokeiEntity.class))).thenReturn(0);

            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);
            高額介護サービス費給付対象者合計 = 高額介護サービス費給付対象者合計.deleted();

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3055KogakuKyufuTaishoshaGokeiEntity entity = DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator.createDbT3055KogakuKyufuTaishoshaGokeiEntity();
            entity.initializeMd5();
            KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計 = new KogakuKyufuTaishoshaGokei(entity);

            assertThat(sut.save高額介護サービス費給付対象者合計(高額介護サービス費給付対象者合計), is(false));
        }
    }
}
