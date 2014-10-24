/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
 * _ItemCollectionのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _ItemCollectionTest extends DbzTestBase {

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

    public _ItemCollectionTest() {
    }

    public static class asList extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private Collection<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _ItemCollection<>(input);
        }

        @Test
        public void asList_の結果のlistのsizeは_コンストラクタ引数のcollectionのsizeと_一致する() {
            assertThat(sut.asList().size(), is(input.size()));
        }

        @Test
        public void asList_の結果のlistは_コンストラクタ引数のcollectionの要素を_すべて含む() {
            assertThat(sut.asList().containsAll(input), is(true));
        }

        @Test
        public void asList_の結果のlistは_コンストラクタ引数のcollectionが空の時_空である() {
            sut = new _ItemCollection<>(Collections.<RString>emptyList());
            assertThat(sut.asList().isEmpty(), is(true));
        }
    }

    public static class map extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private Collection<RString> input;
        private IItems<String> mapped;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _ItemCollection<>(input);
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
        public void map_の戻り値は_コンストラクタ引数のcollectionの要素が引数のIConverterにより変換された結果を_すべて含む() {
            List<String> converted = new ArrayList<>();
            converted.add(createMapper().apply(VAL1));
            converted.add(createMapper().apply(VAL2));
            converted.add(createMapper().apply(VAL3));
            assertThat(mapped.containsAll(converted), is(true));
        }

        @Test
        public void map_の戻り値のsizeは_コンストラクタ引数のcollectionと_一致する() {
            assertThat(mapped.size(), is(input.size()));
        }
    }

    public static class isEmpty extends DbzTestBase {

        private _ItemCollection<RString> sut;

        @Test
        public void isEmpty_はコンストラクタ引数のcollectionがemptyの時_trueを返す() {
            sut = new _ItemCollection<>(Collections.<RString>emptyList());
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void isEmpty_はコンストラクタ引数のcollectionがemptyでない時_falseを返す() {
            sut = new _ItemCollection<>(asList(VAL1, VAL2, VAL3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbzTestBase {

        private _ItemCollection<RString> sut;

        @Test
        public void size_はコンストラクタ引数のcollectionのsizeと_一致する() {
            List<RString> input = asList(VAL1);
            sut = new _ItemCollection<>(input);
            assertThat(sut.size(), is(input.size()));
        }
    }

    public static class isOnly extends DbzTestBase {

        private _ItemCollection<RString> sut;

        @Test
        public void isOnly_はsizeが0の時_falseを返す() {
            sut = new _ItemCollection<>(Collections.<RString>emptyList());
            assertThat(sut.isOnly(), is(false));
        }

        @Test
        public void isOnly_はsizeが1の時_trueを返す() {
            sut = new _ItemCollection<>(asList(VAL1));
            assertThat(sut.isOnly(), is(true));
        }

        @Test
        public void isOnly_はsizeが2の時_falseを返す() {
            sut = new _ItemCollection<>(asList(VAL1, VAL2));
            assertThat(sut.isOnly(), is(false));
        }
    }

    public static class getOnlyOne extends DbzTestBase {

        private _ItemCollection<RString> sut;

        @Test
        public void isOnly_はsizeが0の時_空のIOptionalを返す() {
            sut = new _ItemCollection<>(Collections.<RString>emptyList());
            assertThat(sut.getOnlyOne().isPresent(), is(false));
        }

        @Test
        public void isOnly_はsizeが1の時_要素を持ったIOptionalを返す() {
            sut = new _ItemCollection<>(asList(VAL1));
            assertThat(sut.getOnlyOne().isPresent(), is(true));
        }

        @Test
        public void isOnly_はsizeが2の時_空のIOptionalを返す() {
            sut = new _ItemCollection<>(asList(VAL1, VAL2));
            assertThat(sut.getOnlyOne().isPresent(), is(false));
        }
    }

    public static class iterator extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private Collection<RString> input;

        @Before
        public void setUp() {
            input = mock(Collection.class);
            Iterator<RString> iterator = mock(Iterator.class);
            when(input.iterator()).thenReturn(iterator);
            sut = new _ItemCollection<>(input);
        }

        @Test
        public void iterator_はコンストラクタ引数のcollectionの物と_一致する() {
            assertThat(sut.iterator(), is(input.iterator()));
        }
    }

    public static class contains extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _ItemCollection<>(input);
        }

        @Test
        public void contains_は引数のオブジェクトをコンストラクタ引数のcollectionが保持する時_trueを返す() {
            assertThat(sut.contains(VAL1), is(true));
        }
    }

    public static class containsAllItems extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private _ItemCollection<RString> target;
        private List<RString> input;

        @Before
        public void setUp() {
            sut = new _ItemCollection<>(asList(VAL1, VAL2, VAL3));
        }

        @Test
        public void containsAllItems_は引数のitemsが保持する要素をコンストラクタ引数のcollectionが保持する時_trueを返す() {
            target = new _ItemCollection<>(asList(VAL1, VAL2, VAL3, VAL1));
            assertThat(sut.containsAllItems(target), is(true));
        }
    }

    public static class containsAny extends DbzTestBase {

        private _ItemCollection<RString> sut;
        private _ItemCollection<RString> target;
        private List<RString> input;

        @Before
        public void setUp() {
            sut = new _ItemCollection<>(asList(VAL1, VAL2, VAL3));

        }

        @Test
        public void containsAny_は引数の条件に当てはまるオブジェクトがある時_trueを返す() {
            assertThat(sut.containsAny(equalsVAL1()), is(true));
        }

        private ICondition<RString> equalsVAL1() {
            return new ICondition<RString>() {
                @Override
                public boolean check(RString t) {
                    return t.equals(VAL1);
                }
            };
        }

        @Test
        public void containsAny_は引数の条件に当てはまるオブジェクトが無い時_falseを返す() {
            assertThat(sut.containsAny(lengthIsFive()), is(false));
        }

        private ICondition<RString> lengthIsFive() {
            return new ICondition<RString>() {
                @Override
                public boolean check(RString t) {
                    return t.length() == 5;
                }
            };
        }
    }
}
