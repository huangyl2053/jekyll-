/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoModelComparators}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoModelComparatorsTest {

    public static class 資格取得日によるソート extends DbzTestBase {

        private List<HihokenshaDaichoModel> list;
        private HihokenshaDaichoModel min;
        private HihokenshaDaichoModel max;

        @Before
        public void setUp() {
            list = new ArrayList<>();
            min = createModel(new FlexibleDate("19990101"));
            HihokenshaDaichoModel model1 = createModel(new FlexibleDate("20010717"));
            HihokenshaDaichoModel model2 = createModel(new FlexibleDate("20061010"));
            HihokenshaDaichoModel model3 = createModel(new FlexibleDate("20080912"));
            max = createModel(new FlexibleDate("20141231"));

            list.add(model1);
            list.add(min);
            list.add(model2);
            list.add(max);
            list.add(model3);
        }

        @Test
        public void ascでソートした場合_一番小さい値が先頭に来る() {
            Collections.sort(list, HihokenshaDaichoModelComparators.資格取得日.getAsc());
            assertThat(list.get(0).get資格取得日(), is(min.get資格取得日()));
        }

        @Test
        public void ascでソートした場合_1番大きい値が最後になる() {
            Collections.sort(list, HihokenshaDaichoModelComparators.資格取得日.getAsc());
            assertThat(list.get(list.size() - 1).get資格取得日(), is(max.get資格取得日()));
        }

        @Test
        public void descでソートした場合_一番大きい値が先頭に来る() {
            Collections.sort(list, HihokenshaDaichoModelComparators.資格取得日.getDesc());
            assertThat(list.get(0).get資格取得日(), is(max.get資格取得日()));
        }

        @Test
        public void descでソートした場合_1番小さい値が最後になる() {
            Collections.sort(list, HihokenshaDaichoModelComparators.資格取得日.getDesc());
            assertThat(list.get(list.size() - 1).get資格取得日(), is(min.get資格取得日()));
        }
    }

    private static HihokenshaDaichoModel createModel(FlexibleDate shikakuShutokuDate) {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set資格取得日(shikakuShutokuDate);
        return model;
    }

}
