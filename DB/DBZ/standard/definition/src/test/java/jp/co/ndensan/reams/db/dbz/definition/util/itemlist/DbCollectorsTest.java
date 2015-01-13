
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IDbCollector;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectors.groupingBy;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectors.minBy;
import static jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectorsSupport.gatheringPresentItems;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.DbCollectors;
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
public class DbCollectorsTest {

    public DbCollectorsTest() {
    }

    public static class toList {

        private IDbCollector<Sample1, ?, List<Sample1>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, Sample1> accumulator;
        private IFunction<Object, List<Sample1>> finisher;

        @Before

        public void setUp() {
            sut = DbCollectors.<Sample1>toList();
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, Sample1>) sut.accumulator();
            finisher = (IFunction<Object, List<Sample1>>) sut.finisher();
        }

        @Test
        public void accumulator() {
            Object container = supplier.get();
            Sample1 testValue = new Sample1(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).contains(testValue), is(true));
        }

        @Test
        public void result() {
            assertThat(finisher.apply(supplier.get()), isA(List.class));
        }
    }

    private static class Sample1 {

        private final int key;
        private final String value;

        public Sample1(int key, String value) {
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

    public static class toMap {

        private IDbCollector<Sample1, ?, Map<Integer, String>> sut;
        private IFunction<Sample1, Integer> keyMapper;
        private IFunction<Sample1, String> valueMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, Sample1> accumulator;
        private IFunction<Object, Map<Integer, String>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<Sample1, Integer>() {
                @Override
                public Integer apply(Sample1 t) {
                    return t.getKey();
                }
            };
            valueMapper = new IFunction<Sample1, String>() {
                @Override
                public String apply(Sample1 t) {
                    return t.getValue();
                }
            };
            sut = DbCollectors.toMap(keyMapper, valueMapper);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, Sample1>) sut.accumulator();
            finisher = (IFunction<Object, Map<Integer, String>>) sut.finisher();
        }

        @Test
        public void accumlate() {
            Object container = supplier.get();
            Sample1 testValue = new Sample1(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).containsKey(keyMapper.apply(testValue)), is(true));
            assertThat(finisher.apply(container).containsValue(valueMapper.apply(testValue)), is(true));
        }

        @Test
        public void result() {
            assertThat(finisher.apply(supplier.get()), isA(Map.class));
        }
    }

    public static class toIItemList {

        private IDbCollector<Sample1, ?, IItemList<Sample1>> sut;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, Sample1> accumulator;
        private IFunction<Object, IItemList<Sample1>> finisher;

        @Before
        public void setUp() {
            sut = DbCollectors.toIItemList();
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, Sample1>) sut.accumulator();
            finisher = (IFunction<Object, IItemList<Sample1>>) sut.finisher();
        }

        @Test
        public void accumlate() {
            Object container = supplier.get();
            Sample1 testValue = new Sample1(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).contains(testValue), is(true));
        }

        @Test
        public void result() {
            assertThat(finisher.apply(supplier.get()), isA(IItemList.class));
        }
    }

    public static class groupingBy_keyMapper {

        private IDbCollector<Sample1, ?, Map<Integer, IItemList<Sample1>>> sut;
        private IFunction<Sample1, Integer> keyMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, Sample1> accumulator;
        private IFunction<Object, Map<Integer, IItemList<Sample1>>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<Sample1, Integer>() {
                @Override
                public Integer apply(Sample1 t) {
                    return t.getKey();
                }
            };
            sut = DbCollectors.groupingBy(keyMapper);
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, Sample1>) sut.accumulator();
            finisher = (IFunction<Object, Map<Integer, IItemList<Sample1>>>) sut.finisher();
        }

        @Test
        public void accumlate() {
            Object container = supplier.get();
            Sample1 testValue = new Sample1(10, "value");
            accumulator.accept(container, testValue);
            assertThat(finisher.apply(container).get(keyMapper.apply(testValue)).contains(testValue), is(true));
        }

        @Test
        public void accumlate2() {
            Object container = supplier.get();
            Sample1 testValue = new Sample1(10, null);
            Sample1 testValue2 = new Sample1(10, "value2");
            accumulator.accept(container, testValue);
            accumulator.accept(container, testValue2);
            assertThat(finisher.apply(container).get(keyMapper.apply(testValue)).contains(testValue2), is(true));
        }

        @Test
        public void result() {
            assertThat(finisher.apply(supplier.get()), isA(Map.class));
        }
    }

    public static class collectingAndThen {

        private IDbCollector<Sample1, ?, IItemList<Sample1>> sut;
        private IFunction<Sample1, Integer> keyMapper;
        private ISupplier<Object> supplier;
        private IBiConsumer<Object, Sample1> accumulator;
        private IFunction<Object, IItemList<Sample1>> finisher;

        @Before
        public void setUp() {
            keyMapper = new IFunction<Sample1, Integer>() {
                @Override
                public Integer apply(Sample1 t) {
                    return t.getKey();
                }
            };
            sut = DbCollectors.collectingAndThen(
                    groupingBy(keyMapper, minBy(Sample1Comparators.Value)),
                    gatheringPresentItems(Integer.class, Sample1.class)
            );
            supplier = (ISupplier<Object>) sut.container();
            accumulator = (IBiConsumer<Object, Sample1>) sut.accumulator();
            finisher = (IFunction<Object, IItemList<Sample1>>) sut.finisher();
        }

        @Test
        public void collectingAndThen_accumlate() {
            Object container = supplier.get();
            Sample1 testValue1 = new Sample1(10, "value1");
            Sample1 testValue2 = new Sample1(10, "value2");
            Sample1 testValue3 = new Sample1(10, "value3");
            Sample1 testValue4 = new Sample1(10, "value4");
            accumulator.accept(container, testValue1);
            accumulator.accept(container, testValue2);
            accumulator.accept(container, testValue3);
            accumulator.accept(container, testValue4);
            assertThat(finisher.apply(container).contains(
                    minOrNull(Sample1Comparators.Value, testValue1, testValue2, testValue3, testValue4)
            ), is(true));
        }

        private Sample1 minOrNull(Comparator<Sample1> c, Sample1... values) {
            List<Sample1> list = Arrays.asList(values);
            Collections.sort(list, c);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    private enum Sample1Comparators implements Comparator<Sample1> {

        Key {
                    @Override
                    public int compare(Sample1 o1, Sample1 o2) {
                        return o1.key - o2.key;
                    }
                },
        Value {
                    @Override
                    public int compare(Sample1 o1, Sample1 o2) {
                        return o1.value.compareTo(o2.value);
                    }
                };
    }
}
