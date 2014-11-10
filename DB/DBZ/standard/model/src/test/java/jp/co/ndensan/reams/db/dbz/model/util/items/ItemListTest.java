/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ItemListのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ItemListTest extends DbzTestBase {

    private static final RString VAL1;
    private static final RString VAL2;
    private static final RString VAL3;

    static {
        VAL1 = new RString("1");
        VAL2 = new RString("2");
        VAL3 = new RString("3");
    }

    private static List<RString> asList(RString... values) {
        return Arrays.asList(values);
    }

    public ItemListTest() {
    }

    @RunWith(Enclosed.class)
    public static class staticMethods {

        public static class empty extends DbzTestBase {

            private ItemList sut;
            private IItemList<RString> created;

            @Before
            public void setUp() {
                created = sut.empty();
            }

            @Test
            public void empty_から生成したIItemListは_isEmptyでtrueを返す() {
                assertThat(created.isEmpty(), is(true));
            }

            @Test
            public void empty_から生成したIItemListは_isOnlyでfalseを返す() {
                assertThat(created.isJustOne(), is(false));
            }

            @Test
            public void empty_から生成したIItemListは_onlyOneで空のIOptionalを返す() {
                assertThat(created.findFirst().isPresent(), is(false));
            }

            @Test
            public void empty_から生成したIItemListは_asListで空のlistを返す() {
                assertThat(created.asList().isEmpty(), is(true));
            }
        }

        public static class of extends DbzTestBase {

            private ItemList sut;
            private IItemList<RString> created;
            private final RString a = new RString("1"), b = new RString("2"), c = new RString("3");

            @Test
            public void of_により空でないListから生成したIItemListは_isEmptyでfalseを返す() {
                created = sut.of(Arrays.asList(a, b, c));
                assertThat(created.isEmpty(), is(false));
            }

            @Test(expected = NullPointerException.class)
            public void of_にnullを渡した時_NullPointerExceptionをスローする() {
                sut.of((RString) null);
            }

            @Test(expected = NullPointerException.class)
            public void of_にnullを含む引数を渡した時_NullPointerExceptionをスローする() {
                sut.of(VAL1, VAL2, null);
            }

            @Test(expected = NullPointerException.class)
            public void of_にnullを含むlistを渡した時_NullPointerExceptionをスローする() {
                sut.of(Arrays.asList(a, b, null, c));
            }
        }
    }

    public static class sortedByComparator extends DbzTestBase {

        private IItemList<RString> sut;
        private IItemList<RString> sorted;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = ItemList.of(input);
            sorted = sut.sorted(createComparator());
            Collections.sort(input, createComparator());
        }

        public Comparator<RString> createComparator() {
            return new Comparator<RString>() {
                @Override
                public int compare(RString o1, RString o2) {
                    return o1.compareTo(o2);
                }
            };
        }

        @Test
        public void sorted_Comparator指定_の戻り値の先頭は_コンストラクタ引数のcollectionを_引数のcomparatorで並び変えた結果の先頭と_一致する() {
            assertThat(sorted.asList().get(0), is(input.get(0)));
        }

        @Test
        public void sorted_Comparator指定_の戻り値の2番目は_コンストラクタ引数のcollectionを_引数のcomparatorで並び変えた結果の2番目と_一致する() {
            assertThat(sorted.asList().get(1), is(input.get(1)));
        }

        @Test
        public void sorted_Comparator指定_の戻り値の最後は_コンストラクタ引数のcollectionを_引数のcomparatorで並び変えた結果の最後と_一致する() {
            int lastOfInput = input.size() - 1;
            int lastOfSorted = sorted.size() - 1;
            assertThat(sorted.asList().get(lastOfSorted), is(input.get(lastOfInput)));
        }

        @Test
        public void sorted_Comparator指定_の戻り値は_コンストラクタ引数のcollectionの要素を_すべて含む() {
            assertThat(sorted.containsAll(input), is(true));
        }

        @Test
        public void sorted_Comparator指定_の戻り値のsizeは_コンストラクタ引数のcollectionと_一致する() {
            assertThat(sorted.size(), is(input.size()));
        }
    }

    public static class sortedNaturalOrder extends DbzTestBase {

        private IItemList<RString> sut;
        private IItemList<RString> sorted;
        private List<RString> input;

        @Before
        public void setUp() {
            input = Arrays.asList(VAL2, VAL1, VAL3);
            sut = ItemList.of(input);
            sorted = sut.sorted();
            Collections.sort(input);
        }

        @Test
        public void sorted_引数なし_の戻り値の先頭は_コンストラクタ引数のcollectionを_自然順に並び変えた結果の先頭と_一致する() {
            assertThat(sorted.asList().get(0), is(input.get(0)));
        }

        @Test
        public void sorted_引数なし_の戻り値の2番目は_コンストラクタ引数のcollectionを_自然順に並び変えた結果の2番目と_一致する() {
            assertThat(sorted.asList().get(1), is(input.get(1)));
        }

        @Test
        public void sorted_引数なし_の戻り値の最後は_コンストラクタ引数のcollectionを_自然順に並び変えた結果の最後と_一致する() {
            int lastOfInput = input.size() - 1;
            int lastOfSorted = sorted.size() - 1;
            assertThat(sorted.asList().get(lastOfSorted), is(input.get(lastOfInput)));
        }

        @Test
        public void sorted_引数なし_の戻り値は_コンストラクタ引数のcollectionの要素を_すべて含む() {
            assertThat(sorted.containsAll(input), is(true));
        }

        @Test
        public void sorted_引数なし_の戻り値のsizeは_コンストラクタ引数のcollectionと_一致する() {
            assertThat(sorted.size(), is(input.size()));
        }

        @Test(expected = ClassCastException.class)
        public void sorted_引数なし_は_保持する要素がComparableじゃないとき_ClassCastExceptionをスローする() {
            IItemList<Object> sut = ItemList.of(Arrays.asList(new Object(), new Object()));
            sut.sorted();
        }
    }

    public static class map extends DbzTestBase {

        private IItemList<RString> sut;
        private IItemList<String> mapped;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = ItemList.of(input);
            mapped = sut.map(createMapper());
        }

        private IFunction<RString, String> createMapper() {
            return new IFunction<RString, String>() {
                @Override
                public String apply(RString t) {
                    return t.toString();
                }
            };
        }

        @Test
        public void map_の戻り値は_生成に用いたlistの要素が_引数のIFunctionにより変換された結果を_すべて含む() {
            List<String> converted = new ArrayList<>();
            converted.add(createMapper().apply(VAL1));
            converted.add(createMapper().apply(VAL2));
            converted.add(createMapper().apply(VAL3));
            assertThat(mapped.containsAll(converted), is(true));
        }

        @Test
        public void map_の戻り値のsizeは_生成に用いたlistと_一致する() {
            assertThat(mapped.size(), is(input.size()));
        }
    }

    public static class filter extends DbzTestBase {

        private IItemList<IValue> sut;
        private IItemList<IValue> result;
        private IValue value1, value2, value3;

        @Before
        public void setUp() {
            value1 = initValue(true);
            value2 = initValue(false);
            value3 = initValue(true);
            sut = ItemList.of(value1, value2, value3);
            result = sut.filter(return_true());
        }

        private ICondition<IValue> return_true() {
            return new ICondition<IValue>() {
                @Override
                public boolean check(IValue t) {
                    return t.tureOrFalse();
                }
            };
        }

        private interface IValue {

            boolean tureOrFalse();
        }

        @Test
        public void filterは_引数に該当する要素が2件の時_2件の要素を保持するIItemListを返す() {
            assertThat(result.size(), is(2));
        }

        @Test
        public void filterの結果は_該当する要素が存在するとき_先頭の要素が条件に該当する() {
            assertThat(return_true().check(result.findFirst().get()), is(true));
        }

        private IValue initValue(boolean trueOrFalse) {
            IValue value = mock(IValue.class);
            when(value.tureOrFalse()).thenReturn(trueOrFalse);
            return value;
        }
    }
}
