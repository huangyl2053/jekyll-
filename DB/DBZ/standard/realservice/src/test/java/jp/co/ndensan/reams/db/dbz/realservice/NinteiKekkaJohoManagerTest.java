/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.NinteiKekkaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.NinteiKekkaJohoDac;
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
 * {link NinteiKekkaJohoManager}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiKekkaJohoManagerTest {

    private static NinteiKekkaJohoDac dac;
    private static NinteiKekkaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(NinteiKekkaJohoDac.class);
        sut = new NinteiKekkaJohoManager(dac);
    }

    public static class get要介護認定結果情報Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定結果情報が返る() {

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();

            when(dac.selectByKey(any(RString.class), any(YMDHMS.class))).thenReturn(要介護認定結果情報モデル);

            NinteiKekkaJohoModel 要介護認定結果情報 = sut.get要介護認定結果情報(
                    DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号,
                    DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_処理日時);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定結果情報.get一次判定結果変更理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }
    }

    public static class get要介護認定結果情報一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定結果情報のリストが返る() {

            List<NinteiKekkaJohoModel> 要介護認定結果情報モデルリスト = new ArrayList<>();
            要介護認定結果情報モデルリスト.add(createModel());
            要介護認定結果情報モデルリスト.add(createModel());
            IItemList<NinteiKekkaJohoModel> list = ItemList.of(要介護認定結果情報モデルリスト);

            when(dac.selectAll()).thenReturn(list);

            IItemList<NinteiKekkaJohoModel> 要介護認定結果情報リスト = sut.get要介護認定結果情報一覧();

            assertThat(要介護認定結果情報リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定結果情報リスト.toList().get(0).get一次判定結果変更理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
            assertThat(要介護認定結果情報リスト.toList().get(1).get一次判定結果変更理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }
    }

    public static class get要介護認定結果情報By申請書管理番号Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_要介護認定結果情報が返る() {

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();

            when(dac.select直近要介護認定結果情報By申請書管理番号(any(RString.class))).thenReturn(要介護認定結果情報モデル);

            NinteiKekkaJohoModel 要介護認定結果情報 = sut.get要介護認定結果情報(
                    DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(要介護認定結果情報.get一次判定結果変更理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }
    }

    public static class save要介護認定結果情報 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(NinteiKekkaJohoModel.class))).thenReturn(1);

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(NinteiKekkaJohoModel.class))).thenReturn(1);

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();
            要介護認定結果情報モデル.getEntity().initializeMd5();
            // 状態をModifiedにするため、任意の項目を変更してください。
            要介護認定結果情報モデル.set一次判定結果変更理由(new RString("9"));

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(NinteiKekkaJohoModel.class))).thenReturn(1);

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();
            要介護認定結果情報モデル.getEntity().initializeMd5();
            要介護認定結果情報モデル.setDeletedState(true);

            assertThat(sut.save要介護認定結果情報(要介護認定結果情報モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            NinteiKekkaJohoModel 要介護認定結果情報モデル = createModel();
            要介護認定結果情報モデル.getEntity().initializeMd5();

            sut.save要介護認定結果情報(要介護認定結果情報モデル);
        }
    }

    private static NinteiKekkaJohoModel createModel() {
        return new NinteiKekkaJohoModel(DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity());
    }

}
