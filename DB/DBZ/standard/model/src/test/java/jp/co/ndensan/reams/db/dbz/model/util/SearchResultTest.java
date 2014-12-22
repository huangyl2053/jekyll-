/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SearchResult}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class SearchResultTest extends DbzTestBase {

    public SearchResultTest() {
    }

    @RunWith(Enclosed.class)
    public static class of_List_int_boolean extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            private final List<String> list = new ArrayList<>();

            @Test(expected = NullPointerException.class)
            public void ofは_引数のListがNullの時_NullPointerExceptionをスローする() {
                sut.of((List) null, 100, false);
            }

            @Test(expected = IllegalArgumentException.class)
            public void ofは_引数のtotalCountが0の時_IllegalArgumentExceptionをスローする() {
                sut.of(list, 0, true);
            }

            @Test
            public void ofは_引数のtotalCountが1以上の時_SearchResultを生成する() {
                assertThat(sut.of(list, 1, false), isA(SearchResult.class));
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private List<String> list;
            private int totalCount;
            private boolean exceedsLimit;

            @Before
            public void setUp() {
                totalCount = 100;
                list = Arrays.asList("01", "02", "03");
                exceedsLimit = true;
                created = sut.of(list, totalCount, exceedsLimit);
            }

            @Test
            public void recordsは_ofの引数と_すべて同じ値を持つ() {
                assertThat(created.records().toList(), is(list));
            }

            @Test
            public void totalCountは_ofの引数と_同じ値を返す() {
                assertThat(created.totalCount(), is(totalCount));
            }

            @Test
            public void exceedsLimitは_ofの引数と_同じ値を返す() {
                assertThat(created.exceedsLimit(), is(exceedsLimit));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class of_IItemList_int_boolean extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            private final IItemList<String> itemList = ItemList.of("01");

            @Test(expected = NullPointerException.class)
            public void ofは_引数のIItemListがNullの時_NullPointerExceptionをスローする() {
                sut.of((IItemList) null, 100, false);
            }

            @Test(expected = IllegalArgumentException.class)
            public void ofは_引数のtotalCountが0の時_IllegalArgumentExceptionをスローする() {
                sut.of(itemList, 0, true);
            }

            @Test
            public void ofは_引数のtotalCountが1以上の時_SearchResultを生成する() {
                assertThat(sut.of(itemList, 1, false), isA(SearchResult.class));
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private IItemList<String> itemList;
            private int totalCount;
            private boolean exceedsLimit;

            @Before
            public void setUp() {
                totalCount = 100;
                itemList = ItemList.of("01", "02", "03");
                exceedsLimit = true;
                created = sut.of(itemList, totalCount, exceedsLimit);
            }

            @Test
            public void recordsは_ofの引数と_すべて同じ値を持つ() {
                assertThat(created.records().toList(), is(itemList.toList()));
            }

            @Test
            public void totalCountは_ofの引数と_同じ値を返す() {
                assertThat(created.totalCount(), is(totalCount));
            }

            @Test
            public void exceedsLimitは_ofの引数と_同じ値を返す() {
                assertThat(created.exceedsLimit(), is(exceedsLimit));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class of_List_int extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            private final List<String> list = new ArrayList<>();

            @Test(expected = NullPointerException.class)
            public void ofは_引数のListがNullの時_NullPointerExceptionをスローする() {
                sut.of((List) null, 1);
            }

            @Test(expected = IllegalArgumentException.class)
            public void ofは_引数のtotalCountが0の時_IllegalArgumentExceptionをスローする() {
                sut.of(list, 0);
            }

            @Test
            public void ofは_引数のtotalCountが1以上の時_SearchResultを生成する() {
                assertThat(sut.of(list, 1), isA(SearchResult.class));
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private List<String> list;

            @Before
            public void setUp() {
                list = Arrays.asList("01", "02", "03");
            }

            @Test
            public void recordsは_ofの引数と_すべて同じ値を持つ() {
                created = sut.of(list, 10);
                assertThat(created.records().toList(), is(list));
            }

            @Test
            public void totalCountは_ofの引数と_同じ値を返す() {
                int totalCount = 100;
                created = sut.of(list, totalCount);
                assertThat(created.totalCount(), is(totalCount));
            }

            @Test
            public void exceedsLimitは_ofに渡したlistのsizeよりもtotalCountが小さい時_falseを返す() {
                int totalCount = list.size() - 1;
                created = sut.of(list, totalCount);
                assertThat(created.exceedsLimit(), is(false));
            }

            @Test
            public void exceedsLimitは_ofに渡したlistのsizeとtotalCountが同じ時_falseを返す() {
                int totalCount = list.size();
                created = sut.of(list, totalCount);
                assertThat(created.exceedsLimit(), is(false));
            }

            @Test
            public void exceedsLimitは_ofに渡したlistのsizeがtotalCountよりも小さい時_trueを返す() {
                int totalCount = list.size() + 1;
                created = sut.of(list, totalCount);
                assertThat(created.exceedsLimit(), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class of_IItemList_int extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            private final IItemList<String> itemList = ItemList.of("01");

            @Test(expected = NullPointerException.class)
            public void ofは_引数のIItemListがNullの時_NullPointerExceptionをスローする() {
                sut.of((IItemList) null, 100);
            }

            @Test(expected = IllegalArgumentException.class)
            public void ofは_引数のtotalCountが0の時_IllegalArgumentExceptionをスローする() {
                sut.of(itemList, 0);
            }

            @Test
            public void ofは_引数のtotalCountが1以上の時_SearchResultを生成する() {
                assertThat(sut.of(itemList, 1), isA(SearchResult.class));
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private IItemList<String> itemList;

            @Before
            public void setUp() {
                itemList = ItemList.of("01", "02", "03");
            }

            @Test
            public void recordsは_ofの引数と_すべて同じ値を持つ() {
                created = sut.of(itemList, 10);
                assertThat(created.records().toList(), is(itemList.toList()));
            }

            @Test
            public void totalCountは_ofの引数と_同じ値を返す() {
                int totalCount = 100;
                created = sut.of(itemList, totalCount);
                assertThat(created.totalCount(), is(totalCount));
            }

            @Test
            public void exceedsLimitは_ofに渡したitemListのsizeよりもtotalCountが小さい時_falseを返す() {
                int totalCount = itemList.size() - 1;
                created = sut.of(itemList, totalCount);
                assertThat(created.exceedsLimit(), is(false));
            }

            @Test
            public void exceedsLimitは_ofに渡したitemListのsizeとtotalCountが同じ時_falseを返す() {
                int totalCount = itemList.size();
                created = sut.of(itemList, totalCount);
                assertThat(created.exceedsLimit(), is(false));
            }

            @Test
            public void exceedsLimitは_ofに渡したitemListのsizeがtotalCountよりも小さい時_trueを返す() {
                int totalCount = itemList.size() + 1;
                created = sut.of(itemList, totalCount);
                assertThat(created.exceedsLimit(), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class of_List extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            @Test(expected = NullPointerException.class)
            public void ofは_引数のListがNullの時_NullPointerExceptionをスローする() {
                sut.of((List) null);
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private List<String> list;

            @Before
            public void setUp() {
                list = Arrays.asList("01", "02", "03");
            }

            @Test
            public void recordsは_ofに渡したlistと_すべて同じ値を持つ() {
                created = sut.of(list);
                assertThat(created.records().toList(), is(list));
            }

            @Test
            public void totalCountは_ofに渡したlistのsizeと_同じ値を返す() {
                created = sut.of(list);
                assertThat(created.totalCount(), is(list.size()));
            }

            @Test
            public void exceedsLimitは_falseを返す() {
                created = sut.of(list);
                assertThat(created.exceedsLimit(), is(false));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class of_ItemList extends DbzTestBase {

        private static SearchResult<String> sut;

        public static class argumentsCheck extends DbzTestBase {

            @Test(expected = NullPointerException.class)
            public void ofは_引数のListがNullの時_NullPointerExceptionをスローする() {
                sut.of((List) null);
            }
        }

        public static class created extends DbzTestBase {

            private SearchResult<String> created;
            private IItemList<String> itemList;

            @Before
            public void setUp() {
                itemList = ItemList.of("01", "02", "03");
            }

            @Test
            public void recordsは_ofに渡したlistと_すべて同じ値を持つ() {
                created = sut.of(itemList);
                assertThat(created.records().toList(), is(itemList.toList()));
            }

            @Test
            public void totalCountは_ofに渡したlistのsizeと_同じ値を返す() {
                created = sut.of(itemList);
                assertThat(created.totalCount(), is(itemList.size()));
            }

            @Test
            public void exceedsLimitは_falseを返す() {
                created = sut.of(itemList);
                assertThat(created.exceedsLimit(), is(false));
            }
        }
    }
}
