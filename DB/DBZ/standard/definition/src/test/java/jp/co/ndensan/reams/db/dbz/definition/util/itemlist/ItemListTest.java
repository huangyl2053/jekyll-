/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
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

        public static class newItemList extends DbzTestBase {

            private ItemList sut;

            @Test(expected = NullPointerException.class)
            public void newItemListは_引数がnullの時_NullPointerExceptionをスローする() {
                sut.newItemList(null);
            }
        }
    }

    public static class asList extends DbzTestBase {

        private ItemList<RString> sut;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = ItemList.of(input);
        }

        @Test
        public void asList_の結果のlistのsizeは_生成時に渡したlistのsizeと_一致する() {
            assertThat(sut.toList().size(), is(input.size()));
        }

        @Test
        public void asList_の結果のlistは_生成時に渡したlistの要素を_すべて含む() {
            assertThat(sut.toList().containsAll(input), is(true));
        }

        @Test
        public void asList_の結果のlistは_生成時に渡したlistが空の時_空である() {
            sut = ItemList.of(Collections.<RString>emptyList());
            assertThat(sut.toList().isEmpty(), is(true));
        }
    }

    public static class filter extends DbzTestBase {

        private ItemList<IValue> sut;
        private IItemList<IValue> result;
        private IValue value1, value2, value3;

        @Before
        public void setUp() {
            value1 = initValue(true);
            value2 = initValue(false);
            value3 = initValue(true);
            sut = ItemList.of(Arrays.asList(value1, value2, value3));
            result = sut.filter(return_true());
        }

        private IPredicate<IValue> return_true() {
            return new IPredicate<IValue>() {
                @Override
                public boolean evaluate(IValue t) {
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
            assertThat(return_true().evaluate(result.findFirst().get()), is(true));
        }

        private IValue initValue(boolean trueOrFalse) {
            IValue value = mock(IValue.class);
            when(value.tureOrFalse()).thenReturn(trueOrFalse);
            return value;
        }
    }

    public static class map extends DbzTestBase {

        private ItemList<RString> sut;
        private List<RString> input;
        private IItemList<String> mapped;

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
        public void map_の戻り値は_生成時に渡したlistが引数のIConverterにより変換された結果を_すべて含む() {
            List<String> converted = new ArrayList<>();
            converted.add(createMapper().apply(VAL1));
            converted.add(createMapper().apply(VAL2));
            converted.add(createMapper().apply(VAL3));
            assertThat(mapped.containsAll(converted), is(true));
        }

        @Test
        public void map_の戻り値のsizeは_生成時に渡したlistのものと_一致する() {
            assertThat(mapped.size(), is(input.size()));
        }
    }

    public static class isEmpty extends DbzTestBase {

        private ItemList<RString> sut;

        @Test
        public void isEmptyは_生成時に渡したlistがemptyの時_trueを返す() {
            sut = ItemList.of(Collections.<RString>emptyList());
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void isEmptyは_生成時に渡したlistがemptyでない時_falseを返す() {
            sut = ItemList.of(asList(VAL1, VAL2, VAL3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbzTestBase {

        private ItemList<RString> sut;

        @Test
        public void sizeは_保持するlistのsizeと_一致する() {
            List<RString> input = asList(VAL1);
            sut = ItemList.of(input);
            assertThat(sut.size(), is(input.size()));
        }
    }

    public static class isJustOne extends DbzTestBase {

        private ItemList<RString> sut;

        @Test
        public void isJustOneは_sizeが0の時_falseを返す() {
            sut = ItemList.of(Collections.<RString>emptyList());
            assertThat(sut.isJustOne(), is(false));
        }

        @Test
        public void isJustOneは_sizeが1の時_trueを返す() {
            sut = ItemList.of(asList(VAL1));
            assertThat(sut.isJustOne(), is(true));
        }

        @Test
        public void isJustOneは_sizeが2の時_falseを返す() {
            sut = ItemList.of(asList(VAL1, VAL2));
            assertThat(sut.isJustOne(), is(false));
        }
    }

    public static class findJustOne extends DbzTestBase {

        private ItemList<RString> sut;

        @Test
        public void findJustOneは_生成時に渡したlistがemptyの時_空のIOptionalを返す() {
            sut = ItemList.of(Collections.<RString>emptyList());
            assertThat(sut.findJustOne().isPresent(), is(false));
        }

        @Test
        public void findJustOneは_生成時に渡したlistのsizeが1の時_その要素を持ったIOptionalを返す() {
            sut = ItemList.of(asList(VAL1));
            assertThat(sut.findJustOne().get(), is(VAL1));
        }

        @Test
        public void findJustOneは_生成時に渡したlistのsizeが2の時_空のIOptionalを返す() {
            sut = ItemList.of(asList(VAL1, VAL2));
            assertThat(sut.findJustOne().isPresent(), is(false));
        }
    }

    public static class findFirst extends DbzTestBase {

        private ItemList<RString> sut;

        @Test
        public void findFirstは_生成時に渡したlistがemptyの時_空のIOptionalを返す() {
            sut = ItemList.of(Collections.<RString>emptyList());
            assertThat(sut.findFirst().isPresent(), is(false));
        }

        @Test
        public void findFirstは_生成時に渡したlistのsizeが1の時_その要素を持ったIOptionalを返す() {
            sut = ItemList.of(asList(VAL1));
            assertThat(sut.findFirst().get(), is(VAL1));
        }

        @Test
        public void findFisrtは_生成時に渡したlistのsizeが2の時_要素を持ったIOptionalを返す() {
            sut = ItemList.of(asList(VAL1, VAL2));
            assertThat(sut.findFirst().isPresent(), is(true));
        }
    }

    public static class iterator extends DbzTestBase {

        private ItemList<String> sut;

        @Before
        public void setUp() {
            sut = ItemList.of("1", "2");
        }

        @Test
        public void iteratorは_Iteratorを返す() {
            assertThat(sut.iterator(), isA(Iterator.class));
        }
    }

    public static class contains extends DbzTestBase {

        private ItemList<RString> sut;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = ItemList.of(input);
        }

        @Test
        public void containsは_生成時に渡したlistに引数のオブジェクトが含まれるとき_trueを返す() {
            assertThat(sut.contains(VAL1), is(true));
        }
    }

    public static class containsAllItems extends DbzTestBase {

        private ItemList<RString> sut;
        private ItemList<RString> target;
        private List<RString> input;

        @Before
        public void setUp() {
            sut = ItemList.of(asList(VAL1, VAL2, VAL3));
        }

        @Test
        public void containsAllItemsは_生成時に渡したlistに引数のitemsが保持する要素がすべて含まれる時_trueを返す() {
            target = ItemList.of(asList(VAL1, VAL2, VAL3, VAL1));
            assertThat(sut.containsAll(target), is(true));
        }
    }

    public static class anyMatch extends DbzTestBase {

        private ItemList<RString> sut;

        @Before
        public void setUp() {
            sut = ItemList.of(asList(VAL1, VAL2, VAL3));
        }

        @Test
        public void anyMatchは_引数の条件に当てはまるオブジェクトがある時_trueを返す() {
            assertThat(sut.anyMatch(equalsVAL1()), is(true));
        }

        private IPredicate<RString> equalsVAL1() {
            return new IPredicate<RString>() {
                @Override
                public boolean evaluate(RString t) {
                    return t.equals(VAL1);
                }
            };
        }

        @Test
        public void anyMatchは_引数の条件に当てはまるオブジェクトが無い時_falseを返す() {
            assertThat(sut.anyMatch(lengthIsFive()), is(false));
        }

        private IPredicate<RString> lengthIsFive() {
            return new IPredicate<RString>() {
                @Override
                public boolean evaluate(RString t) {
                    return t.length() == 5;
                }
            };
        }
    }

    public static class allMatch extends DbzTestBase {

        @Test
        public void allMatchは_全ての要素が条件に当てはまるとき_trueを返す() {
            ItemList<RString> sut = ItemList.of(asList(VAL1, VAL2, VAL3));
            assertThat(sut.allMatch(lengthIsOne()), is(true));
        }

        @Test
        public void allMatchは_条件に当てはまらない要素を含むとき_falseを返す() {
            ItemList<RString> sut = ItemList.of(asList(VAL1, VAL2, VAL3, new RString("12")));
            assertThat(sut.allMatch(lengthIsOne()), is(false));
        }

        private IPredicate<RString> lengthIsOne() {
            return new IPredicate<RString>() {
                @Override
                public boolean evaluate(RString t) {
                    return t.length() == 1;
                }
            };
        }
    }

    public static class noneMatch extends DbzTestBase {

        @Test
        public void noneMatchは_全ての要素が条件に当てはまらないとき_trueを返す() {
            ItemList<RString> sut = ItemList.of(asList(VAL1, VAL2, VAL3));
            assertThat(sut.noneMatch(lengthIsTwo()), is(true));
        }

        @Test
        public void noneMatchは_条件に当てはまる要素を含むとき_falseを返す() {
            ItemList<RString> sut = ItemList.of(asList(VAL1, VAL2, VAL3, new RString("12")));
            assertThat(sut.noneMatch(lengthIsTwo()), is(false));
        }

        private IPredicate<RString> lengthIsTwo() {
            return new IPredicate<RString>() {
                @Override
                public boolean evaluate(RString t) {
                    return t.length() == 2;
                }
            };
        }
    }

    public static class added extends DbzTestBase {

        private ItemList<String> sut;

        @Before
        public void setUp() {
            sut = ItemList.of("1", "2", "3");
        }

        @Test(expected = NullPointerException.class)
        public void addedは_引数がnullの時_NullPointerExceptionをスローする() {
            sut.added((String) null);
        }

        @Test
        public void addedは_sizeを1増やした_IItemListを返す() {
            int beforeSize = sut.size();
            assertThat(sut.added("4").size(), is(beforeSize + 1));
        }
    }

    public static class added_array extends DbzTestBase {

        private ItemList<String> sut;

        @Before
        public void setUp() {
            sut = ItemList.of("1", "2", "3");
        }

        @Test(expected = NullPointerException.class)
        public void added_array指定は_引数がnullの時_NullPointerExceptionをスローする() {
            sut.added((String[]) null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void added_array指定は_引数にnullを含むとき_IllegalArgumentExceptionをスローする() {
            sut.added("4", null, "5");
        }

        @Test
        public void addedは_引数に2個の要素を指定したとき_sizeを2増やした_IItemListを返す() {
            int beforeSize = sut.size();
            assertThat(sut.added("4", "5").size(), is(beforeSize + 2));
        }
    }
}
