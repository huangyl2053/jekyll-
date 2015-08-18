/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link KyotakuKeikakuTodokedeManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeManagerTest {

    private static KyotakuKeikakuTodokedeDac dac;
    private static KyotakuKeikakuTodokedeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(KyotakuKeikakuTodokedeDac.class);
        sut = new KyotakuKeikakuTodokedeManager(dac);
    }

    public static class get居宅給付計画届出Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画届出が返る() {

            Optional<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class)))
                    .thenReturn(居宅給付計画届出モデル);

            Optional<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出 = sut.get居宅給付計画届出(
                    DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号,
                    DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月,
                    DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画届出.get().getTodokedeKubun(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
        }
    }

    public static class get居宅給付計画届出一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画届出のリストが返る() {

            List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出モデルリスト = new ArrayList<>();
            居宅給付計画届出モデルリスト.add(createModel());
            居宅給付計画届出モデルリスト.add(createModel());
            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> list = ItemList.of(居宅給付計画届出モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出リスト = sut.get居宅給付計画届出一覧();

            assertThat(居宅給付計画届出リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画届出リスト.toList().get(0).getTodokedeKubun(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
            assertThat(居宅給付計画届出リスト.toList().get(1).getTodokedeKubun(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
        }
    }

    public static class get居宅給付計画届出一覧By被保険者Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画届出のリストが返る() {

            List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出モデルリスト = new ArrayList<>();
            居宅給付計画届出モデルリスト.add(createModel());
            居宅給付計画届出モデルリスト.add(createModel());
            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> list = ItemList.of(居宅給付計画届出モデルリスト);

            when(dac.select居宅給付計画届出一覧By被保険者番号(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出リスト = sut.get居宅給付計画届出一覧(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号);

            assertThat(居宅給付計画届出リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画届出リスト.toList().get(0).getTodokedeKubun(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
            assertThat(居宅給付計画届出リスト.toList().get(1).getTodokedeKubun(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
        }
    }

    public static class save居宅給付計画届出 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出モデル = createModel();

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出モデル = createModel();
            居宅給付計画届出モデル.initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            居宅給付計画届出モデル.setTodokedeKubun(new RString("3"));

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT3005KyotakuKeikakuTodokedeEntity.class))).thenReturn(1);

            DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出モデル = createModel();
            居宅給付計画届出モデル.initializeMd5();
            居宅給付計画届出モデル.setIsDeleted(true);

            assertThat(sut.save居宅給付計画届出(居宅給付計画届出モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出モデル = createModel();
            居宅給付計画届出モデル.initializeMd5();

            sut.save居宅給付計画届出(居宅給付計画届出モデル);
        }
    }

    private static DbT3005KyotakuKeikakuTodokedeEntity createModel() {
        return new DbT3005KyotakuKeikakuTodokedeEntity();
    }
}
