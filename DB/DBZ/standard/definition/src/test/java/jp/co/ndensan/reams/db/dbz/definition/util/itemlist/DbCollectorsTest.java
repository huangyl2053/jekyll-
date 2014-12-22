/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Collectorsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class DbCollectorsTest extends DbzTestBase {

    private static DbCollectors sut;

    public DbCollectorsTest() {
    }

    public static class toMap extends DbzTestBase {

        private IDbCollector<Sample1, ?, Map<Integer, String>> result;
        private IFunction<Sample1, Integer> keyMapper;
        private IFunction<Sample1, String> valueMapper;

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
            result = sut.toMap(keyMapper, valueMapper);
        }

        @Test
        public void testToMap() {
            assertThat(result, isA(IDbCollector.class));
        }

        @Test
        public void testA() {
            assertThat(result.container().get(), is(instanceOf(Map.class)));
        }

        @Test
        public void testB() {
            Map<Integer, String> container = (Map<Integer, String>) result.container().get();
            Sample1 item = new Sample1(100, "value");
            ((IBiConsumer<Map<Integer, String>, Sample1>) result.accumulator()).accept(
                    container, item);
            assertThat(container.get(keyMapper.apply(item)), is(valueMapper.apply(item)));
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
    }
}
