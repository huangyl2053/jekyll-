/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link PlainCollectorsSupport}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class PlainCollectorsSupportTest {

    public PlainCollectorsSupportTest() {
    }

    public static class unmodifiableList extends DbzTestBase {

        private PlainCollectorsSupport sut;
        private List<String> list;

        @Before
        public void setUp() {
            list = Arrays.asList("1", "2");
        }

        @Test(expected = UnsupportedOperationException.class)
        public void unmodifiableList_Class指定_を適用したListは_addをすると_UnsupportedOperationExceptionをスローする() {
            sut.unmodifiableList(String.class).apply(list).add("testValue");
            fail();
        }

        @Test(expected = UnsupportedOperationException.class)
        public void unmodifiableListを適用したListは_addをすると_UnsupportedOperationExceptionをスローする() {
            sut.<String>unmodifiableList().apply(list).add("testValue");
            fail();
        }
    }

    public static class unmodifiableMap extends DbzTestBase {

        private PlainCollectorsSupport sut;
        private Map<String, String> map;

        @Before
        public void setUp() {
            map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }

        @Test(expected = UnsupportedOperationException.class)
        public void unmodifiableMap_Class指定_を適用したMapは_putをすると_UnsupportedOperationExceptionをスローする() {
            sut.unmodifiableMap(String.class, String.class).apply(map).put("key4", "value4");
            fail();
        }

        @Test(expected = UnsupportedOperationException.class)
        public void unmodifiableMapを適用したMapは_putをすると_UnsupportedOperationExceptionをスローする() {
            sut.<String, String>unmodifiableMap().apply(map).put("key4", "value4");
            fail();
        }
    }

    public static class gatheringPresentItems extends DbzTestBase {

        private PlainCollectorsSupport sut;
        private final Map<String, Optional<String>> INPUT_MAP;
        private final List<String> IDEAL_VALUES;

        {
            Map<String, Optional<String>> map = new HashMap<>();
            map.put("key1", Optional.of("value1"));
            map.put("key2", Optional.<String>empty());
            map.put("key3", Optional.of("value3"));
            INPUT_MAP = Collections.unmodifiableMap(map);

            List<String> list = new ArrayList<>();
            for (Map.Entry<String, Optional<String>> entry : map.entrySet()) {
                if (entry.getValue().isPresent()) {
                    list.add(entry.getValue().get());
                }
            }
            IDEAL_VALUES = Collections.unmodifiableList(list);
        }

        @Test
        public void Optionalを紐付けたMapに_gatheringPresentItems_Class指定_を適用すると_isPresentでtrueを返す要素だけを集めたIItemListを返す() {
            IItemList<String> result = sut.gatheringPresentItems(String.class, String.class).apply(INPUT_MAP);
            assertThat(result.toList(), is(IDEAL_VALUES));
        }

        @Test
        public void Optionalを紐付けたMapに_gatheringPresentItemsを適用すると_isPresentでtrueを返す要素だけを集めたIItemListを返す() {
            IItemList<String> result = sut.<String, String>gatheringPresentItems().apply(INPUT_MAP);
            assertThat(result.toList(), is(IDEAL_VALUES));
        }
    }
}
