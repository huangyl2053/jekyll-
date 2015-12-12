/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
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
 * {link KyotakuKeikakuTodokedeManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeManagerTest {

    private static DbT3005KyotakuKeikakuTodokedeDac dac;
    private static KyotakuKeikakuTodokedeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3005KyotakuKeikakuTodokedeDac.class);
        sut = new KyotakuKeikakuTodokedeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画届出 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            Decimal 主キー3 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅給付計画届出(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
            sut.get居宅給付計画届出(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            sut.get居宅給付計画届出(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            Decimal 主キー3 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
            KyotakuKeikakuTodokede result = sut.get居宅給付計画届出(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー2 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
            Decimal 主キー3 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
            KyotakuKeikakuTodokede result = sut.get居宅給付計画届出(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get居宅給付計画届出一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyotakuKeikakuTodokede> result = sut.get居宅給付計画届出一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3005KyotakuKeikakuTodokedeEntity> entityList = Arrays.asList(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyotakuKeikakuTodokede> result = sut.get居宅給付計画届出一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save居宅給付計画届出 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(0);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.initializeMd5();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);
            居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit().set届出者住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(0);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.initializeMd5();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);
            居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit().set届出者住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.initializeMd5();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);
            居宅給付計画届出 = 居宅給付計画届出.deleted();

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(0);

            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.initializeMd5();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);
            居宅給付計画届出 = 居宅給付計画届出.deleted();

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.initializeMd5();
            KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(entity);

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出), is(false));
        }
    }
}
