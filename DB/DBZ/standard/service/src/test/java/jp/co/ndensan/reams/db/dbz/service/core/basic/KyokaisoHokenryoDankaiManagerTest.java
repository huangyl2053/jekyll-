/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1007KyokaisoHokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1007KyokaisoHokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyokaisoHokenryoDankaiManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyokaisoHokenryoDankaiManagerTest {

    private static DbT1007KyokaisoHokenryoDankaiDac dac;
    private static KyokaisoHokenryoDankaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1007KyokaisoHokenryoDankaiDac.class);
        sut = new KyokaisoHokenryoDankaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get境界層保険料段階 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー2 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_履歴番号;
            FlexibleYearMonth 主キー3 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月;
            sut.get境界層保険料段階(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー2 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_履歴番号;
            HihokenshaNo 主キー1 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号;
            sut.get境界層保険料段階(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class), any(FlexibleYearMonth.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号;
            int 主キー2 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_履歴番号;
            FlexibleYearMonth 主キー3 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月;
            KyokaisoHokenryoDankai result = sut.get境界層保険料段階(主キー1, 主キー2, 主キー3);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class), any(FlexibleYearMonth.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号;
            int 主キー2 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_履歴番号;
            FlexibleYearMonth 主キー3 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月;
            KyokaisoHokenryoDankai result = sut.get境界層保険料段階(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get境界層保険料段階一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyokaisoHokenryoDankai> result = sut.get境界層保険料段階一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1007KyokaisoHokenryoDankaiEntity> entityList = Arrays.asList(DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyokaisoHokenryoDankai> result = sut.get境界層保険料段階一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save境界層保険料段階 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(1);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(0);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(1);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.initializeMd5();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);
            境界層保険料段階 = 境界層保険料段階.createBuilderForEdit().set適用終了年月(new FlexibleYearMonth("201412")).build();

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(0);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.initializeMd5();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);
            境界層保険料段階 = 境界層保険料段階.createBuilderForEdit().set適用終了年月(new FlexibleYearMonth("201412")).build();

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(1);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.initializeMd5();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);
            境界層保険料段階 = 境界層保険料段階.deleted();

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1007KyokaisoHokenryoDankaiEntity.class))).thenReturn(0);

            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.initializeMd5();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);
            境界層保険料段階 = 境界層保険料段階.deleted();

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.initializeMd5();
            KyokaisoHokenryoDankai 境界層保険料段階 = new KyokaisoHokenryoDankai(entity);

            assertThat(sut.save境界層保険料段階(境界層保険料段階), is(false));
        }
    }
}
