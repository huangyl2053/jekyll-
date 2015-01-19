/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.model.helper.HihokenshaDaichoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
 * {link HihokenshaDaichoManager}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoManagerTest {

    private static HihokenshaDaichoDac dac;
    private static HihokenshaDaichoManager sut;

    private static final LasdecCode 市町村コード = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード;
    private static final HihokenshaNo 被保険者番号 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
    private static final ShoriTimestamp 処理日時 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時;
    private static final ShikibetsuCode 識別コード = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード;

    @BeforeClass
    public static void test() {
        dac = mock(HihokenshaDaichoDac.class);
        sut = new HihokenshaDaichoManager(dac);
    }

    public static class get被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            Optional<HihokenshaDaichoModel> 被保険者台帳モデル = Optional.ofNullable(HihokenshaDaichoModelTestHelper.createModel());

            when(dac.select被保険者台帳ByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(ShoriTimestamp.class))).thenReturn(被保険者台帳モデル);

            Optional<HihokenshaDaichoModel> result = sut.find被保険者台帳(市町村コード, 被保険者番号, 処理日時);

            assertThat(result.get().get資格取得事由(), is(被保険者台帳モデル.get().get資格取得事由()));
        }
    }

    public static class get被保険者台帳一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳のリストが返る() {

            List<HihokenshaDaichoModel> modelList = new ArrayList<>();
            modelList.add(HihokenshaDaichoModelTestHelper.createModel());
            modelList.add(HihokenshaDaichoModelTestHelper.createModel());
            IItemList<HihokenshaDaichoModel> 被保険者台帳モデルリスト = ItemList.of(modelList);

            when(dac.select被保険者台帳一覧(any(LasdecCode.class), any(HihokenshaNo.class))).thenReturn(被保険者台帳モデルリスト);

            IItemList<HihokenshaDaichoModel> result = sut.get被保険者台帳一覧(市町村コード, 被保険者番号);

            assertThat(result.size(), is(2));
            assertThat(result.toList().get(0).get資格取得事由(), is(被保険者台帳モデルリスト.toList().get(0).get資格取得事由()));
            assertThat(result.toList().get(1).get資格取得事由(), is(被保険者台帳モデルリスト.toList().get(0).get資格取得事由()));
        }
    }

    public static class get被保険者台帳一覧AllTest extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳のリストが返る() {

            List<HihokenshaDaichoModel> 被保険者台帳モデルリスト = new ArrayList<>();
            被保険者台帳モデルリスト.add(HihokenshaDaichoModelTestHelper.createModel());
            IItemList list = ItemList.of(被保険者台帳モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<HihokenshaDaichoModel> 被保険者台帳リスト = sut.get被保険者台帳一覧();

            assertThat(被保険者台帳リスト.size(), is(1));
            assertThat(被保険者台帳リスト.toList().get(0).get識別コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class get最新被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            Optional<HihokenshaDaichoModel> 被保険者台帳モデル = Optional.ofNullable(HihokenshaDaichoModelTestHelper.createModel());

            when(dac.select最新被保険者台帳(any(LasdecCode.class), any(ShikibetsuCode.class))).thenReturn(被保険者台帳モデル);

            Optional<HihokenshaDaichoModel> result = sut.get最新被保険者台帳(市町村コード, 識別コード);

            assertThat(result.get().get資格取得事由(), is(被保険者台帳モデル.get().get資格取得事由()));
        }
    }

    public static class get最新被保険者台帳被_保険者番号Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            Optional<HihokenshaDaichoModel> 被保険者台帳モデル = Optional.ofNullable(HihokenshaDaichoModelTestHelper.createModel());

            when(dac.select最新被保険者台帳(any(HihokenshaNo.class))).thenReturn(被保険者台帳モデル);

            Optional<HihokenshaDaichoModel> 被保険者台帳 = sut.get最新被保険者台帳(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(被保険者台帳.get().get被保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }
    }

    public static class save被保険者台帳 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();
            被保険者台帳モデル.getEntity().initializeMd5();
            被保険者台帳モデル.set資格取得事由(ShikakuShutokuJiyu.合併);

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();
            被保険者台帳モデル.getEntity().initializeMd5();
            被保険者台帳モデル.setDeletedState(true);

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();
            被保険者台帳モデル.getEntity().initializeMd5();

            sut.save被保険者台帳(被保険者台帳モデル);
        }
    }
}
