/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5001NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.NinteiShinseiJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.relate.NinteiShinseiJohoDac;
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
 * {link NinteiShinseiJohoManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoManagerTest {

    private static NinteiShinseiJohoDac dac;
    private static NinteiShinseiJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(NinteiShinseiJohoDac.class);
        sut = new NinteiShinseiJohoManager(dac);
    }

    public static class get要介護認定申請情報Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定申請情報が返る() {

            Optional<NinteiShinseiJohoModel> 要介護認定申請情報モデル = Optional.ofNullable(createModel());

            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(YMDHMS.class))).thenReturn(要介護認定申請情報モデル);

            Optional<NinteiShinseiJohoModel> 要介護認定申請情報 = sut.get要介護認定申請情報(
                    new ShinseishoKanriNo(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号),
                    DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定申請情報.get().getみなし要介護区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード));
        }
    }

    public static class get要介護認定申請情報一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定申請情報のリストが返る() {

            List<NinteiShinseiJohoModel> 要介護認定申請情報モデルリスト = new ArrayList<>();
            要介護認定申請情報モデルリスト.add(createModel());
            要介護認定申請情報モデルリスト.add(createModel());
            IItemList<NinteiShinseiJohoModel> list = ItemList.of(要介護認定申請情報モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<NinteiShinseiJohoModel> 要介護認定申請情報リスト = sut.get要介護認定申請情報一覧();

            assertThat(要介護認定申請情報リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定申請情報リスト.toList().get(0).getみなし要介護区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード));
            assertThat(要介護認定申請情報リスト.toList().get(1).getみなし要介護区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード));
        }
    }

    public static class get要介護認定申請情報By申請書管理番号Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定申請情報が返る() {

            Optional<NinteiShinseiJohoModel> 要介護認定申請情報モデル = Optional.ofNullable(createModel());

            when(dac.select要介護認定申請情報By申請書管理番号(any(ShinseishoKanriNo.class))).thenReturn(要介護認定申請情報モデル);

            Optional<NinteiShinseiJohoModel> 要介護認定申請情報 = sut.get要介護認定申請情報(
                    new ShinseishoKanriNo(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号));

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定申請情報.get().getみなし要介護区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード));
        }
    }

    public static class save要介護認定申請情報 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(NinteiShinseiJohoModel.class))).thenReturn(1);

            NinteiShinseiJohoModel 要介護認定申請情報モデル = createModel();

            assertThat(sut.save要介護認定申請情報(要介護認定申請情報モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(NinteiShinseiJohoModel.class))).thenReturn(1);

            NinteiShinseiJohoModel 要介護認定申請情報モデル = createModel();
            要介護認定申請情報モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            要介護認定申請情報モデル.setみなし要介護区分コード(new RString("9"));

            assertThat(sut.save要介護認定申請情報(要介護認定申請情報モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(NinteiShinseiJohoModel.class))).thenReturn(1);

            NinteiShinseiJohoModel 要介護認定申請情報モデル = createModel();
            要介護認定申請情報モデル.getEntity().initializeMd5();
            要介護認定申請情報モデル.setDeletedState(true);

            assertThat(sut.save要介護認定申請情報(要介護認定申請情報モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            NinteiShinseiJohoModel 要介護認定申請情報モデル = createModel();
            要介護認定申請情報モデル.getEntity().initializeMd5();

            sut.save要介護認定申請情報(要介護認定申請情報モデル);
        }
    }

    private static NinteiShinseiJohoModel createModel() {
        return new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
    }

}
