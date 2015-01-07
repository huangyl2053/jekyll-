/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link HihokenshaDaichoManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoManagerTest {

    private static HihokenshaDaichoDac dac;
    private static HihokenshaDaichoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(HihokenshaDaichoDac.class);
        sut = new HihokenshaDaichoManager(dac);
    }

    public static class get被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            IOptional<HihokenshaDaichoModel> 被保険者台帳モデル = DbOptional.ofNullable(createModel());

            when(dac.selectByKey(any(LasdecCode.class), any(HihokenshaNo.class), any(YMDHMS.class))).thenReturn(被保険者台帳モデル);

            IOptional<HihokenshaDaichoModel> 被保険者台帳 = sut.get被保険者台帳(
                    DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード,
                    DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号,
                    DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(被保険者台帳.get().get被保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }
    }

    public static class get被保険者台帳一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳のリストが返る() {

            List<HihokenshaDaichoModel> 被保険者台帳モデルリスト = new ArrayList<>();
            被保険者台帳モデルリスト.add(createModel());
            IItemList list = ItemList.of(被保険者台帳モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<HihokenshaDaichoModel> 被保険者台帳リスト = sut.get被保険者台帳一覧();

            assertThat(被保険者台帳リスト.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(被保険者台帳リスト.toList().get(0).get識別コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class get直近被保険者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_被保険者台帳が返る() {

            IOptional<HihokenshaDaichoModel> 被保険者台帳モデル = DbOptional.ofNullable(createModel());

            when(dac.select直近被保険者台帳(any(HihokenshaNo.class))).thenReturn(被保険者台帳モデル);

            IOptional<HihokenshaDaichoModel> 被保険者台帳 = sut.get直近被保険者台帳(
                    DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(被保険者台帳.get().get被保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }
    }

    public static class save被保険者台帳 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = createModel();

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = createModel();
            被保険者台帳モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            被保険者台帳モデル.set住所地特例フラグ(new RString("9"));

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(HihokenshaDaichoModel.class))).thenReturn(1);

            HihokenshaDaichoModel 被保険者台帳モデル = createModel();
            被保険者台帳モデル.getEntity().initializeMd5();
            被保険者台帳モデル.setDeletedState(true);

            assertThat(sut.save被保険者台帳(被保険者台帳モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            HihokenshaDaichoModel 被保険者台帳モデル = createModel();
            被保険者台帳モデル.getEntity().initializeMd5();

            sut.save被保険者台帳(被保険者台帳モデル);
        }
    }

    private static HihokenshaDaichoModel createModel() {
        return new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());
    }
}
