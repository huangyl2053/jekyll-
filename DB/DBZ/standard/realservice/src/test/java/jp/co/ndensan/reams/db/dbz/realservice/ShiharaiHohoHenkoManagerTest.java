/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4021ShiharaiHohoHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ShiharaiHohoHenkoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
 * {link ShiharaiHohoHenkoManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShiharaiHohoHenkoManagerTest {

    private static ShiharaiHohoHenkoDac dac;
    private static ShiharaiHohoHenkoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(ShiharaiHohoHenkoDac.class);
        sut = new ShiharaiHohoHenkoManager(dac);
    }

    public static class get支払方法変更Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_支払方法変更が返る() {

            Optional<ShiharaiHohoHenkoModel> 支払方法変更モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(HihokenshaNo.class), any(KanriKubun.class), any(YMDHMS.class))).thenReturn(支払方法変更モデル);

            Optional<ShiharaiHohoHenkoModel> 支払方法変更 = sut.get支払方法変更(
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_証記載保険者番号,
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号,
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分,
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(支払方法変更.get().is差止対象(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_差止対象フラグ));
        }
    }

    public static class get支払方法変更一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_支払方法変更のリストが返る() {

            List<ShiharaiHohoHenkoModel> 支払方法変更モデルリスト = new ArrayList<>();
            支払方法変更モデルリスト.add(createModel());
            支払方法変更モデルリスト.add(createModel());
            IItemList<ShiharaiHohoHenkoModel> list = ItemList.of(支払方法変更モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<ShiharaiHohoHenkoModel> 支払方法変更リスト = sut.get支払方法変更一覧();

            assertThat(支払方法変更リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(支払方法変更リスト.toList().get(0).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
            assertThat(支払方法変更リスト.toList().get(1).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
        }
    }

    public static class get2号差止履歴Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_支払方法変更のリストが返る() {

            List<ShiharaiHohoHenkoModel> 支払方法変更モデルリスト = new ArrayList<>();
            ShiharaiHohoHenkoModel model = createModel();
            model.set管理区分(KanriKubun.ニ号差止);
            model.set登録区分(TorokuKubun.二号予告登録者);
            支払方法変更モデルリスト.add(model);
            支払方法変更モデルリスト.add(model);
            IItemList<ShiharaiHohoHenkoModel> list = ItemList.of(支払方法変更モデルリスト);

            when(dac.select2号差止履歴(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<ShiharaiHohoHenkoModel> 支払方法変更リスト = sut.get2号差止履歴(
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(支払方法変更リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(支払方法変更リスト.toList().get(0).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
            assertThat(支払方法変更リスト.toList().get(1).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
        }
    }

    public static class get1号償還払化履歴Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_支払方法変更のリストが返る() {

            List<ShiharaiHohoHenkoModel> 支払方法変更モデルリスト = new ArrayList<>();
            ShiharaiHohoHenkoModel model = createModel();
            model.set管理区分(KanriKubun.一号償還払い化);
            model.set登録区分(TorokuKubun.一号償還払い化登録);
            支払方法変更モデルリスト.add(model);
            支払方法変更モデルリスト.add(model);
            IItemList<ShiharaiHohoHenkoModel> list = ItemList.of(支払方法変更モデルリスト);

            when(dac.select1号償還払化履歴(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<ShiharaiHohoHenkoModel> 支払方法変更リスト = sut.get1号償還払化履歴(
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(支払方法変更リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(支払方法変更リスト.toList().get(0).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
            assertThat(支払方法変更リスト.toList().get(1).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
        }
    }

    public static class get1号減額履歴Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_支払方法変更のリストが返る() {

            List<ShiharaiHohoHenkoModel> 支払方法変更モデルリスト = new ArrayList<>();
            ShiharaiHohoHenkoModel model = createModel();
            model.set管理区分(KanriKubun.一号給付額減額);
            model.set登録区分(TorokuKubun.一号給付額減額登録);
            支払方法変更モデルリスト.add(model);
            支払方法変更モデルリスト.add(model);
            IItemList<ShiharaiHohoHenkoModel> list = ItemList.of(支払方法変更モデルリスト);

            when(dac.select1号減額履歴(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<ShiharaiHohoHenkoModel> 支払方法変更リスト = sut.get1号減額履歴(
                    DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(支払方法変更リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(支払方法変更リスト.toList().get(0).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
            assertThat(支払方法変更リスト.toList().get(1).has償還払化通知書再発行(), is(DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_予告通知書再発行フラグ));
        }
    }

    public static class save支払方法変更 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(ShiharaiHohoHenkoModel.class))).thenReturn(1);

            ShiharaiHohoHenkoModel 支払方法変更モデル = createModel();

            assertThat(sut.save支払方法変更(支払方法変更モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(ShiharaiHohoHenkoModel.class))).thenReturn(1);

            ShiharaiHohoHenkoModel 支払方法変更モデル = createModel();
            支払方法変更モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            支払方法変更モデル.set差止対象フラグ(false);

            assertThat(sut.save支払方法変更(支払方法変更モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(ShiharaiHohoHenkoModel.class))).thenReturn(1);

            ShiharaiHohoHenkoModel 支払方法変更モデル = createModel();
            支払方法変更モデル.getEntity().initializeMd5();
            支払方法変更モデル.setDeletedState(true);

            assertThat(sut.save支払方法変更(支払方法変更モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ShiharaiHohoHenkoModel 支払方法変更モデル = createModel();
            支払方法変更モデル.getEntity().initializeMd5();

            sut.save支払方法変更(支払方法変更モデル);
        }
    }

    private static ShiharaiHohoHenkoModel createModel() {
        return new ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());
    }
}
