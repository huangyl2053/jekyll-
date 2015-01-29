/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link JukyushaDaichoManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoManagerTest {

    private static JukyushaDaichoDac dac;
    private static JukyushaDaichoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(JukyushaDaichoDac.class);
        sut = new JukyushaDaichoManager(dac);
    }

    public static class get受給者台帳Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳が返る() {

            Optional<JukyushaDaichoModel> 受給者台帳モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(HihokenshaNo.class), any(ShinseishoKanriNo.class), any(YMDHMS.class))).thenReturn(受給者台帳モデル);

            Optional<JukyushaDaichoModel> 受給者台帳 = sut.get受給者台帳(
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_証記載保険者番号,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号,
                    DbT4001JukyushaDaichoEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳.get().get地区コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_地区コード));
        }
    }

    public static class get受給者台帳一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳のリストが返る() {

            List<JukyushaDaichoModel> 受給者台帳モデルリスト = new ArrayList<>();
            受給者台帳モデルリスト.add(createModel());
            IItemList list = ItemList.of(受給者台帳モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<JukyushaDaichoModel> 受給者台帳リスト = sut.get受給者台帳一覧();

            assertThat(受給者台帳リスト.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳リスト.toList().get(0).get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class get受給者台帳履歴Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_受給者台帳のリストが返る() {

            List<JukyushaDaichoModel> 受給者台帳モデルリスト = new ArrayList<>();
            受給者台帳モデルリスト.add(createModel());
            IItemList list = ItemList.of(受給者台帳モデルリスト);

            when(dac.select受給者台帳履歴By被保険者番号(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<JukyushaDaichoModel> 受給者台帳リスト = sut.get受給者台帳履歴(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号);

            assertThat(受給者台帳リスト.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(受給者台帳リスト.toList().get(0).get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class save受給者台帳 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(JukyushaDaichoModel.class))).thenReturn(1);

            JukyushaDaichoModel 受給者台帳モデル = createModel();

            assertThat(sut.save受給者台帳(受給者台帳モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(JukyushaDaichoModel.class))).thenReturn(1);

            JukyushaDaichoModel 受給者台帳モデル = createModel();
            受給者台帳モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            受給者台帳モデル.set支給限度単位数(new Decimal("20"));

            assertThat(sut.save受給者台帳(受給者台帳モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(JukyushaDaichoModel.class))).thenReturn(1);

            JukyushaDaichoModel 受給者台帳モデル = createModel();
            受給者台帳モデル.getEntity().initializeMd5();
            受給者台帳モデル.setDeletedState(true);

            assertThat(sut.save受給者台帳(受給者台帳モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            JukyushaDaichoModel 受給者台帳モデル = createModel();
            受給者台帳モデル.getEntity().initializeMd5();

            sut.save受給者台帳(受給者台帳モデル);
        }
    }

    private static JukyushaDaichoModel createModel() {
        return new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
    }

}
