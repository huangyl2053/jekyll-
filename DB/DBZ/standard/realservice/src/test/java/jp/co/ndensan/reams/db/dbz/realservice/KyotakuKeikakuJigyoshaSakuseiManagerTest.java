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
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuJigyoshaSakuseiDac;
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
 * {link KyotakuKeikakuJigyoshaSakuseiManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJigyoshaSakuseiManagerTest {

    private static KyotakuKeikakuJigyoshaSakuseiDac dac;
    private static KyotakuKeikakuJigyoshaSakuseiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(KyotakuKeikakuJigyoshaSakuseiDac.class);
        sut = new KyotakuKeikakuJigyoshaSakuseiManager(dac);
    }

    public static class get居宅給付計画事業者作成Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画事業者作成が返る() {

            Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(居宅給付計画事業者作成モデル);

            Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成 = sut.get居宅給付計画事業者作成(
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号,
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月,
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_履歴番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画事業者作成.get().getJigyoshaHenkoJiyu(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由));
        }
    }

    public static class get居宅計画事業者作成一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画事業者作成のリストが返る() {

            List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成モデルリスト = new ArrayList<>();
            居宅給付計画事業者作成モデルリスト.add(createModel());
            居宅給付計画事業者作成モデルリスト.add(createModel());
            IItemList<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> list = ItemList.of(居宅給付計画事業者作成モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成リスト = sut.get居宅計画事業者作成一覧();

            assertThat(居宅給付計画事業者作成リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画事業者作成リスト.toList().get(0).getItakusakiJigyoshaNo(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号));
            assertThat(居宅給付計画事業者作成リスト.toList().get(1).getItakusakiJigyoshaNo(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号));
        }
    }

    public static class get直近居宅計画事業者作成Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画事業者作成が返る() {

            Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成モデル = Optional.ofNullable(createModel());

            when(dac.select直近居宅給付計画事業者作成(any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(居宅給付計画事業者作成モデル);

            Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成 = sut.get直近居宅計画事業者作成(
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号,
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月,
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_履歴番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画事業者作成.get().getJigyoshaHenkoJiyu(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由));
        }
    }

    public static class save居宅給付計画事業者作成 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class))).thenReturn(1);

            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成モデル = createModel();

            assertThat(sut.save居宅給付計画事業者作成(居宅給付計画事業者作成モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class))).thenReturn(1);

            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成モデル = createModel();
            居宅給付計画事業者作成モデル.initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            居宅給付計画事業者作成モデル.setJigyoshaHenkoJiyu(new RString("333"));

            assertThat(sut.save居宅給付計画事業者作成(居宅給付計画事業者作成モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class))).thenReturn(1);

            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成モデル = createModel();
            居宅給付計画事業者作成モデル.initializeMd5();
            居宅給付計画事業者作成モデル.setIsDeleted(true);

            assertThat(sut.save居宅給付計画事業者作成(居宅給付計画事業者作成モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成モデル = createModel();
            居宅給付計画事業者作成モデル.initializeMd5();

            sut.save居宅給付計画事業者作成(居宅給付計画事業者作成モデル);
        }
    }

    private static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity createModel() {
        return new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
    }

}
