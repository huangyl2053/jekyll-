/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.RankJohoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.RankJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link RankJohoManager}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class RankJohoManagerTest {

    private static RankJohoDac dac;
    private static RankJohoManager sut;
    private static final FlexibleYear 賦課年度1 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
    private static final FlexibleYear 賦課年度2 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度.plusYear(1);
    private static final RankKubun ランク区分1 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
    private static final RankKubun ランク区分2 = new RankKubun(new RString("02"));

    @BeforeClass
    public static void test() {
        dac = mock(RankJohoDac.class);
        sut = new RankJohoManager(dac);
    }

    public static class getランク情報Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_ランク情報が返る() {

            RankJohoModel ランク情報モデル = createRankJohoModel(賦課年度1, ランク区分1);

            when(dac.selectランク情報ByKey(any(FlexibleYear.class), any(RankKubun.class))).thenReturn(ランク情報モデル);

            IOptional<RankJohoModel> ランク情報 = sut.getランク情報(賦課年度1, ランク区分1);

            assertThat(ランク情報.get().get賦課年度(), is(賦課年度1));
        }
    }

    public static class getランク情報一覧_賦課年度Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_ランク情報のリストが返る() {

            List<RankJohoModel> ランク情報モデルリスト = new ArrayList<>();
            ランク情報モデルリスト.add(createRankJohoModel(賦課年度1, ランク区分1));
            ランク情報モデルリスト.add(createRankJohoModel(賦課年度1, ランク区分2));

            when(dac.selectランク情報一覧(any(FlexibleYear.class))).thenReturn(ランク情報モデルリスト);

            IItemList<RankJohoModel> ランク情報リスト = sut.getランク情報一覧(賦課年度1);

            assertThat(ランク情報リスト.size(), is(2));
            assertThat(ランク情報リスト.toList().get(0).getランク区分(), is(ランク区分1));
            assertThat(ランク情報リスト.toList().get(1).getランク区分(), is(ランク区分2));
        }
    }

    public static class saveランク情報 extends DbzTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(RankJohoModel.class))).thenReturn(1);

            RankJohoModel ランク情報モデル = createRankJohoModel(賦課年度1, ランク区分1);

            assertThat(sut.saveランク情報(ランク情報モデル), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(RankJohoModel.class))).thenReturn(1);

            RankJohoModel ランク情報モデル = createRankJohoModel(賦課年度1, ランク区分1);
            ランク情報モデル.getEntity().initializeMd5();
            ランク情報モデル.setランク名称(new RString("ランク名称変更"));

            assertThat(sut.saveランク情報(ランク情報モデル), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(RankJohoModel.class))).thenReturn(1);

            RankJohoModel ランク情報モデル = createRankJohoModel(賦課年度1, ランク区分1);
            ランク情報モデル.getEntity().initializeMd5();
            ランク情報モデル.setDeletedState(true);

            assertThat(sut.saveランク情報(ランク情報モデル), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void モデルの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            RankJohoModel ランク情報モデル = createRankJohoModel(賦課年度1, ランク区分1);
            ランク情報モデル.getEntity().initializeMd5();

            sut.saveランク情報(ランク情報モデル);
        }
    }

    private static RankJohoModel createRankJohoModel(FlexibleYear 賦課年度, RankKubun ランク区分) {
        DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
        entity.setFukaNendo(賦課年度);
        entity.setRankKubun(ランク区分);
        return new RankJohoModel(entity);
    }
}
