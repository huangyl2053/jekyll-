/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiListTest {

    private static GogitaiList sut;

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void 合議体Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new GogitaiList(null);
        }
    }

    public static class GogitaiListのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new GogitaiList(createList());
        }

        @Test
        public void 引数に年月日に1999_12_12を指定して_該当する合議体が存在するとき_有効期間開始年月日に1999_12_12を持つ合議体が返る() {
            assertThat(sut.get合議体(new GogitaiYukoKikanKaishiYMD("19991212")).get有効期間開始年月日(),
                    is(new GogitaiYukoKikanKaishiYMD("19991212")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に年月日に2028_12_12を指定して_該当する合議体が存在しないとき_IllegalArgumentExceptionが返る() {
            sut = new GogitaiList(createList());
            sut.get合議体(new GogitaiYukoKikanKaishiYMD("20281212"));
        }

        private List<Gogitai> createList() {
            List<Gogitai> list = new ArrayList<>();
            list.add(createGogitai(new GogitaiYukoKikanKaishiYMD("19991212")));
            list.add(createGogitai(new GogitaiYukoKikanKaishiYMD("20000101")));
            list.add(createGogitai(new GogitaiYukoKikanKaishiYMD("20040123")));
            return list;
        }

        private Gogitai createGogitai(GogitaiYukoKikanKaishiYMD 有効期間開始年月日) {

            Gogitai 合議体 = mock(Gogitai.class);
            when(合議体.get有効期間開始年月日()).thenReturn(有効期間開始年月日);
            return 合議体;
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void 合議体Listが空であるとき_trueが返る() {
            sut = new GogitaiList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 合議体Listが空でないとき_falseが返る() {
            sut = new GogitaiList(createMockList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void 合議体Listが3件の情報を持っている場合_3が返る() {
            sut = new GogitaiList(createMockList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<Gogitai> createMockList(int 件数) {
        List<Gogitai> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(mock(Gogitai.class));
        }
        return list;
    }
}
