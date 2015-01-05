/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.helper.HihokenshaDaichoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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
    private static final YMDHMS 処理日時 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時;
    private static final ShikibetsuCode 識別コード = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード;

    @BeforeClass
    public static void test() {
        dac = mock(HihokenshaDaichoDac.class);
        sut = new HihokenshaDaichoManager(dac);
    }

    public static class get被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();

            when(dac.select被保険者台帳ByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(YMDHMS.class))).thenReturn(被保険者台帳モデル);

            HihokenshaDaichoModel 被保険者台帳 = sut.get被保険者台帳(市町村コード, 被保険者番号, 処理日時);

            assertThat(被保険者台帳.get資格取得事由(), is(ShikakuShutokuJiyu.転入));
        }
    }

    public static class get被保険者台帳一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳のリストが返る() {

            List<HihokenshaDaichoModel> 被保険者台帳モデルリスト = new ArrayList<>();
            被保険者台帳モデルリスト.add(HihokenshaDaichoModelTestHelper.createModel());
            被保険者台帳モデルリスト.add(HihokenshaDaichoModelTestHelper.createModel());

            when(dac.select被保険者台帳一覧(any(LasdecCode.class), any(HihokenshaNo.class))).thenReturn(被保険者台帳モデルリスト);

            List<HihokenshaDaichoModel> 被保険者台帳リスト = sut.get被保険者台帳一覧(市町村コード, 被保険者番号);

            assertThat(被保険者台帳リスト.size(), is(2));
            assertThat(被保険者台帳リスト.get(0).get資格取得事由(), is(ShikakuShutokuJiyu.転入));
            assertThat(被保険者台帳リスト.get(1).get資格喪失事由(), is(ShikakuSoshitsuJiyu.転出));
        }
    }

    public static class get最新被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            HihokenshaDaichoModel 被保険者台帳モデル = HihokenshaDaichoModelTestHelper.createModel();

            when(dac.select最新被保険者台帳(any(LasdecCode.class), any(ShikibetsuCode.class))).thenReturn(被保険者台帳モデル);

            HihokenshaDaichoModel 被保険者台帳 = sut.get最新被保険者台帳(市町村コード, 識別コード);

            assertThat(被保険者台帳.get資格取得事由(), is(ShikakuShutokuJiyu.転入));
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
