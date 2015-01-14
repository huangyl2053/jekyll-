/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectors.groupingBy;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectors.minBy;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectorsSupport.gatheringPresentItems;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbCollectors}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class DbCollectorsTest extends DbzTestBase {

    public DbCollectorsTest() {
    }

    private static class TestValue {

        private final int key;
        private final String value;

        public TestValue(int key, String value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return key;
        }

        String getValue() {
            return value;
        }
    }

    public static class toList extends DbzTestBase {

        private IDbCollector<TestValue, ?, List<TestValue>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, List<TestValue>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.<TestValue>toList();
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, List<TestValue>>) sut.finisher();
        }

        @Test
        public void toListの結果が返すDbCollectorの生成する各要素について_containerをaccumulatorへ渡した後_finisherで変換すると_accumulatorの第2引数を保持するListを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue = new TestValue(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).contains(testValue), is(true));
        }
    }

    public static class toMap extends DbzTestBase {

        private IDbCollector<TestValue, ?, Map<Integer, String>> sut;
        private IFunction<TestValue, Integer> keyMapper;
        private IFunction<TestValue, String> valueMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, Map<Integer, String>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<TestValue, Integer>() {
                @Override
                public Integer apply(TestValue t) {
                    return t.getKey();
                }
            };
            valueMapper = new IFunction<TestValue, String>() {
                @Override
                public String apply(TestValue t) {
                    return t.getValue();
                }
            };
            sut = DbCollectors.toMap(keyMapper, valueMapper);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, Map<Integer, String>>) sut.finisher();
        }

        @Test
        public void toMapの結果が返すDbCollectorの生成する各要素について_containerをaccumulatorへ渡した後_finisherで変換すると_accumulatorの第2引数を保持するMapを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue = new TestValue(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).containsKey(keyMapper.apply(testValue)), is(true));
            assertThat(finisher.apply(container).containsValue(valueMapper.apply(testValue)), is(true));
        }
    }

    public static class toIItemList extends DbzTestBase {

        private IDbCollector<TestValue, ?, IItemList<TestValue>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, IItemList<TestValue>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.toIItemList();
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, IItemList<TestValue>>) sut.finisher();
        }

        @Test
        public void toIItemListの結果が返すDbCollectorの生成する各要素について_containerをaccumulatorへ渡した後_finisherで変換すると_accumulatorの第2引数を保持するIItemListを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue = new TestValue(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).contains(testValue), is(true));
        }
    }

    public static class groupingBy_IFunction extends DbzTestBase {

        private IDbCollector<TestValue, ?, Map<Integer, IItemList<TestValue>>> sut;
        private IFunction<TestValue, Integer> keyMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, Map<Integer, IItemList<TestValue>>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<TestValue, Integer>() {
                @Override
                public Integer apply(TestValue t) {
                    return t.getKey();
                }
            };
            sut = DbCollectors.groupingBy(keyMapper);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, Map<Integer, IItemList<TestValue>>>) sut.finisher();
        }

        @Test
        public void groupingBy_IFunctionの結果が返すDbCollectorの生成する各要素について_containerをaccumulatorへ渡した後_finisherで変換すると_accumulatorの第2引数をIFunctionで変換した値をキーに_accumulatorの第2引数を持ったIItemListを紐付けたMapを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue = new TestValue(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).get(keyMapper.apply(testValue)).contains(testValue), is(true));
        }
    }

    private enum TestValueComparators implements Comparator<TestValue> {

        Key {
                    @Override
                    public int compare(TestValue o1, TestValue o2) {
                        return o1.key - o2.key;
                    }
                },
        Value {
                    @Override
                    public int compare(TestValue o1, TestValue o2) {
                        return o1.value.compareTo(o2.value);
                    }
                };
    }

    public static class maxBy extends DbzTestBase {

        private IDbCollector<TestValue, ?, Optional<TestValue>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, Optional<TestValue>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.maxBy(TestValueComparators.Value);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, Optional<TestValue>>) sut.finisher();
        }

        @Test
        public void maxByの結果が返すDbCollectorDbCollectorの生成する各要素について_containerを何回か第2引数を変えながらaccumulatorへ渡した後_finisherで変換すると_accumulatorに渡した第2引数の中で最大を保持するOptionalを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue1 = new TestValue(10, "value1");
            TestValue testValue2 = new TestValue(11, "value2");
            TestValue testValue3 = new TestValue(12, "value3");
            TestValue testValue4 = new TestValue(13, "value4");
            TestValue testValue5 = new TestValue(14, "value5");
            accumulator.accept(container, testValue1);
            accumulator.accept(container, testValue2);
            accumulator.accept(container, testValue3);
            accumulator.accept(container, testValue4);
            accumulator.accept(container, testValue5);
            assertThat(finisher.apply(container).get().value,
                    is(maxOf(TestValueComparators.Value, testValue1, testValue2, testValue3, testValue4, testValue5).value)
            );
        }
    }

    private static TestValue maxOf(Comparator<TestValue> c, TestValue... values) {
        List<TestValue> list = Arrays.asList(values);
        Collections.sort(list, c);
        Collections.reverse(list);
        return list.isEmpty() ? null : list.get(0);
    }

    public static class minBy extends DbzTestBase {

        private IDbCollector<TestValue, ?, Optional<TestValue>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, Optional<TestValue>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.minBy(TestValueComparators.Value);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, Optional<TestValue>>) sut.finisher();
        }

        @Test
        public void minByの結果が返すDbCollectorの生成する各要素について_containerを何回か第2引数を変えながらaccumulatorへ渡した後_finisherで変換すると_accumulatorに渡した第2引数の中で最小を保持するOptionalを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue1 = new TestValue(10, "value1");
            TestValue testValue2 = new TestValue(11, "value2");
            TestValue testValue3 = new TestValue(12, "value3");
            TestValue testValue4 = new TestValue(13, "value4");
            TestValue testValue5 = new TestValue(14, "value5");
            accumulator.accept(container, testValue1);
            accumulator.accept(container, testValue2);
            accumulator.accept(container, testValue3);
            accumulator.accept(container, testValue4);
            accumulator.accept(container, testValue5);
            assertThat(finisher.apply(container).get().value,
                    is(minOf(TestValueComparators.Value, testValue1, testValue2, testValue3, testValue4, testValue5).value)
            );
        }
    }

    private static TestValue minOf(Comparator<TestValue> c, TestValue... values) {
        List<TestValue> list = Arrays.asList(values);
        Collections.sort(list, c);
        return list.isEmpty() ? null : list.get(0);
    }

    public static class sortBy extends DbzTestBase {

        private IDbCollector<TestValue, ?, IItemList<TestValue>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, IItemList<TestValue>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.sortBy(TestValueComparators.Value);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, IItemList<TestValue>>) sut.finisher();
        }

        @Test
        public void sortByの結果が返すDbCollectorの生成する各要素について_containerを何回か第2引数を変えながらaccumulatorへ渡した後_finisherで変換すると_accumulatorに渡した第2引数の中で最小を保持するOptionalを返す_が成立する() {
            Object container = supplier.get();
            TestValue testValue1 = new TestValue(10, "value1");
            TestValue testValue2 = new TestValue(11, "value2");
            TestValue testValue3 = new TestValue(12, "value3");
            accumulator.accept(container, testValue1);
            accumulator.accept(container, testValue2);
            accumulator.accept(container, testValue3);
            List<TestValue> list = Arrays.asList(testValue1, testValue2, testValue3);
            Collections.sort(list, TestValueComparators.Value);
            assertThat(finisher.apply(container).toList().get(0), is(list.get(0)));
            assertThat(finisher.apply(container).toList().get(1), is(list.get(1)));
            assertThat(finisher.apply(container).toList().get(2), is(list.get(2)));
        }
    }

    public static class collectingAndThen_groupingBy_IDbCollector extends DbzTestBase {

        private IDbCollector<TestValue, ?, IItemList<TestValue>> sut;
        private IFunction<TestValue, Integer> keyMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, TestValue> accumulator;
        private IFunction<Object, IItemList<TestValue>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<TestValue, Integer>() {
                @Override
                public Integer apply(TestValue t) {
                    return t.getKey();
                }
            };
            sut = DbCollectors.collectingAndThen(
                    groupingBy(keyMapper, minBy(TestValueComparators.Value)),
                    gatheringPresentItems(Integer.class, TestValue.class)
            );
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, TestValue>) sut.accumulator();
            finisher = (IFunction<Object, IItemList<TestValue>>) sut.finisher();
        }

        @Test
        public void DbCollectorの生成する各要素について_keyMapperで変換した値をキーにグルーピングし_グループの中での最小値だけを持つMapを生成した後_空でない値だけを集めたIItemListが生成される_が成立する() {
            Object container = supplier.get();
            TestValue testValue1 = new TestValue(10, "value1");
            TestValue testValue2 = new TestValue(10, "value2");
            TestValue testValue3 = new TestValue(10, "value3");
            TestValue testValue4 = new TestValue(10, "value4");
            accumulator.accept(container, testValue1);
            accumulator.accept(container, testValue2);
            accumulator.accept(container, testValue3);
            accumulator.accept(container, testValue4);
            assertThat(finisher.apply(container).contains(
                    minOf(TestValueComparators.Value, testValue1, testValue2, testValue3, testValue4)
            ), is(true));
        }
    }
}
