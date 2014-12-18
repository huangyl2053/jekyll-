/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJikoSakuseiModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyotakuKeikakuJikoSakuseiManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiManagerTest {

    private static KyotakuKeikakuJikoSakuseiDac dac;
    private static KyotakuKeikakuJikoSakuseiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(KyotakuKeikakuJikoSakuseiDac.class);
        sut = new KyotakuKeikakuJikoSakuseiManager(dac);
    }

    public static class get居宅給付計画自己作成Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画自己作成が返る() {

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();

            when(dac.selectByKey(any(HihokenshaNo.class), any(HokenshaNo.class), any(ShikibetsuCode.class),
                    any(FlexibleYearMonth.class), any(YMDHMS.class))).thenReturn(居宅給付計画自己作成モデル);

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成 = sut.get居宅給付計画自己作成(
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_証記載保険者番号,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_識別コード,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画自己作成.get計画変更年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日));
        }
    }

    public static class get居宅給付計画自己作成一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画自己作成のリストが返る() {

            List<KyotakuKeikakuJikoSakuseiModel> 居宅給付計画自己作成モデルリスト = new ArrayList<>();
            居宅給付計画自己作成モデルリスト.add(createModel());
            居宅給付計画自己作成モデルリスト.add(createModel());
            IItemList<KyotakuKeikakuJikoSakuseiModel> list = ItemList.of(居宅給付計画自己作成モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<KyotakuKeikakuJikoSakuseiModel> 居宅給付計画自己作成リスト = sut.get居宅給付計画自己作成一覧();

            assertThat(居宅給付計画自己作成リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画自己作成リスト.toList().get(0).get居宅_総合事業区分(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅_総合事業区分));
            assertThat(居宅給付計画自己作成リスト.toList().get(1).get居宅_総合事業区分(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅_総合事業区分));
        }
    }

    public static class get直近居宅給付計画自己作成Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画自己作成が返る() {

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();

            when(dac.select直近居宅給付計画自己作成(any(HihokenshaNo.class), any(HokenshaNo.class), any(ShikibetsuCode.class),
                    any(FlexibleYearMonth.class))).thenReturn(居宅給付計画自己作成モデル);

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成 = sut.get直近居宅給付計画自己作成(
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_証記載保険者番号,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_識別コード,
                    DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画自己作成.get計画変更年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日));
        }
    }

    public static class save居宅給付計画自己作成 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(KyotakuKeikakuJikoSakuseiModel.class))).thenReturn(1);

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();

            assertThat(sut.save居宅給付計画自己作成(居宅給付計画自己作成モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(KyotakuKeikakuJikoSakuseiModel.class))).thenReturn(1);

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();
            居宅給付計画自己作成モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            居宅給付計画自己作成モデル.set居宅_総合事業区分(new RString("9"));

            assertThat(sut.save居宅給付計画自己作成(居宅給付計画自己作成モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(KyotakuKeikakuJikoSakuseiModel.class))).thenReturn(1);

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();
            居宅給付計画自己作成モデル.getEntity().initializeMd5();
            居宅給付計画自己作成モデル.setDeletedState(true);

            assertThat(sut.save居宅給付計画自己作成(居宅給付計画自己作成モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            KyotakuKeikakuJikoSakuseiModel 居宅給付計画自己作成モデル = createModel();
            居宅給付計画自己作成モデル.getEntity().initializeMd5();

            sut.save居宅給付計画自己作成(居宅給付計画自己作成モデル);
        }
    }

    private static KyotakuKeikakuJikoSakuseiModel createModel() {
        return new KyotakuKeikakuJikoSakuseiModel(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity());
    }

}
