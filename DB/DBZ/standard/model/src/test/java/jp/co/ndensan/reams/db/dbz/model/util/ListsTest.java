/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ItemsUtilのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ListsTest extends DbzTestBase {

    private static Lists sut;

    public ListsTest() {
    }

    public static class newArrayList_引数なし extends DbzTestBase {

        @Test
        public void newArrayList_はArrayListを生成する() {
            assertThat(sut.newArrayList(), isA(ArrayList.class));
        }

        @Test
        public void newArrayList_が生成したArrayListのsizeは_0である() {
            assertThat(sut.newArrayList().size(), is(0));
        }

        @Test
        public void newArrayList_が生成したArrayListのisEmptyは_trueである() {
            assertThat(sut.newArrayList().isEmpty(), is(true));
        }
    }

    public static class newArrayList_Iterable extends DbzTestBase {

        private List<String> iterable;
        private List<String> result;

        @Before
        public void setUp() {
            iterable = Arrays.asList("1", "2", "3");
            result = sut.newArrayList(iterable);
        }

        @Test
        public void newArrayList_が生成したArrayListと引数のArrayListの参照は_異なる() {
            assertThat(result, is(not(sameInstance(iterable))));
        }

        @Test
        public void newArrayList_が生成したArrayListと引数のArrayListが_一致する() {
            assertThat(result, is(iterable));
        }
    }

    public static class newArrayList_elements extends DbzTestBase {

        private List<String> iterable;
        private List<String> result;

        @Before
        public void setUp() {
            String str1 = "1";
            String str2 = "2";
            String str3 = "3";
            iterable = Arrays.asList(str1, str2, str3);
            result = sut.newArrayList(str1, str2, str3);
        }

        @Test
        public void newArrayList_が生成したArrayListとArrays$asListが生成したlistが_一致する() {
            assertThat(result, is(iterable));
        }
    }
}
