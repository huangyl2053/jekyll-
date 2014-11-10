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
public class _ItemsTest extends DbzTestBase {

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

    public _ItemsTest() {
    }

    public static class constructor extends DbzTestBase {

        private _Items<RString> sut;

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            sut = new _Items<>(null);
        }
    }

    public static class asList extends DbzTestBase {

        private _Items<RString> sut;
        private Collection<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _Items<>(input);
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
            sut = new _Items<>(Collections.<RString>emptyList());
            assertThat(sut.asList().isEmpty(), is(true));
        }
    }

    public static class filter extends DbzTestBase {

        private _Items<IValue> sut;
        private IItems<IValue> result;
        private IValue value1, value2, value3;

        @Before
        public void setUp() {
            value1 = initValue(true);
            value2 = initValue(false);
            value3 = initValue(true);
            sut = new _Items<>(Arrays.asList(value1, value2, value3));
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

    public static class map extends DbzTestBase {

        private _Items<RString> sut;
        private Collection<RString> input;
        private IItems<String> mapped;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _Items<>(input);
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

        private _Items<RString> sut;

        @Test
        public void isEmpty_はコンストラクタ引数のcollectionがemptyの時_trueを返す() {
            sut = new _Items<>(Collections.<RString>emptyList());
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void isEmpty_はコンストラクタ引数のcollectionがemptyでない時_falseを返す() {
            sut = new _Items<>(asList(VAL1, VAL2, VAL3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbzTestBase {

        private _Items<RString> sut;

        @Test
        public void size_はコンストラクタ引数のcollectionのsizeと_一致する() {
            List<RString> input = asList(VAL1);
            sut = new _Items<>(input);
            assertThat(sut.size(), is(input.size()));
        }
    }

    public static class isJustOne extends DbzTestBase {

        private _Items<RString> sut;

        @Test
        public void isJustOne_はsizeが0の時_falseを返す() {
            sut = new _Items<>(Collections.<RString>emptyList());
            assertThat(sut.isJustOne(), is(false));
        }

        @Test
        public void isJustOne_はsizeが1の時_trueを返す() {
            sut = new _Items<>(asList(VAL1));
            assertThat(sut.isJustOne(), is(true));
        }

        @Test
        public void isJustOne_はsizeが2の時_falseを返す() {
            sut = new _Items<>(asList(VAL1, VAL2));
            assertThat(sut.isJustOne(), is(false));
        }
    }

    public static class findJustOne extends DbzTestBase {

        private _Items<RString> sut;

        @Test
        public void findJustOne_はコンストラクタ引数のCollectionがemptyの時_空のIOptionalを返す() {
            sut = new _Items<>(Collections.<RString>emptyList());
            assertThat(sut.findJustOne().isPresent(), is(false));
        }

        @Test
        public void findJustOne_は引数のCollectionのsizeが1の時_その要素を持ったIOptionalを返す() {
            sut = new _Items<>(asList(VAL1));
            assertThat(sut.findJustOne().get(), is(VAL1));
        }

        @Test
        public void findJustOne_は引数のCollectionのsizeが2の時_空のIOptionalを返す() {
            sut = new _Items<>(asList(VAL1, VAL2));
            assertThat(sut.findJustOne().isPresent(), is(false));
        }
    }

    public static class findFirst extends DbzTestBase {

        private _Items<RString> sut;

        @Test
        public void findFirst_はコンストラクタ引数のCollectionがemptyの時_空のIOptionalを返す() {
            sut = new _Items<>(Collections.<RString>emptyList());
            assertThat(sut.findFirst().isPresent(), is(false));
        }

        @Test
        public void findFirst_は引数のCollectionのsizeが1の時_その要素を持ったIOptionalを返す() {
            sut = new _Items<>(asList(VAL1));
            assertThat(sut.findFirst().get(), is(VAL1));
        }

        @Test
        public void findFisrt_は引数のCollectionのsizeが2の時_要素を持ったIOptionalを返す() {
            sut = new _Items<>(asList(VAL1, VAL2));
            assertThat(sut.findFirst().isPresent(), is(true));
        }
    }

    public static class iterator extends DbzTestBase {

        private _Items<RString> sut;
        private Collection<RString> input;

        @Before
        public void setUp() {
            input = mock(Collection.class);
            Iterator<RString> iterator = mock(Iterator.class);
            when(input.iterator()).thenReturn(iterator);
            sut = new _Items<>(input);
        }

        @Test
        public void iterator_はコンストラクタ引数のcollectionの物と_一致する() {
            assertThat(sut.iterator(), is(input.iterator()));
        }
    }

    public static class contains extends DbzTestBase {

        private _Items<RString> sut;
        private List<RString> input;

        @Before
        public void setUp() {
            input = asList(VAL1, VAL2, VAL3);
            sut = new _Items<>(input);
        }

        @Test
        public void contains_は引数のオブジェクトをコンストラクタ引数のcollectionが保持する時_trueを返す() {
            assertThat(sut.contains(VAL1), is(true));
        }
    }

    public static class containsAllItems extends DbzTestBase {

        private _Items<RString> sut;
        private _Items<RString> target;
        private List<RString> input;

        @Before
        public void setUp() {
            sut = new _Items<>(asList(VAL1, VAL2, VAL3));
        }

        @Test
        public void containsAllItems_は引数のitemsが保持する要素をコンストラクタ引数のcollectionが保持する時_trueを返す() {
            target = new _Items<>(asList(VAL1, VAL2, VAL3, VAL1));
            assertThat(sut.containsAllItems(target), is(true));
        }
    }

    public static class anyMatch extends DbzTestBase {

        private _Items<RString> sut;

        @Before
        public void setUp() {
            sut = new _Items<>(asList(VAL1, VAL2, VAL3));
        }

        @Test
        public void anyMatch_は引数の条件に当てはまるオブジェクトがある時_trueを返す() {
            assertThat(sut.anyMatch(equalsVAL1()), is(true));
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
        public void anyMatch_は引数の条件に当てはまるオブジェクトが無い時_falseを返す() {
            assertThat(sut.anyMatch(lengthIsFive()), is(false));
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

    public static class allMatch extends DbzTestBase {

        @Test
        public void allMatchは_全ての要素が条件に当てはまるとき_trueを返す() {
            _Items<RString> sut = new _Items<>(asList(VAL1, VAL2, VAL3));
            assertThat(sut.allMatch(lengthIsOne()), is(true));
        }

        @Test
        public void allMatchは_条件に当てはまらない要素を含むとき_falseを返す() {
            _Items<RString> sut = new _Items<>(asList(VAL1, VAL2, VAL3, new RString("12")));
            assertThat(sut.allMatch(lengthIsOne()), is(false));
        }

        private ICondition<RString> lengthIsOne() {
            return new ICondition<RString>() {
                @Override
                public boolean check(RString t) {
                    return t.length() == 1;
                }
            };
        }
    }

    public static class noneMatch extends DbzTestBase {

        @Test
        public void noneMatchは_全ての要素が条件に当てはまらないとき_trueを返す() {
            _Items<RString> sut = new _Items<>(asList(VAL1, VAL2, VAL3));
            assertThat(sut.noneMatch(lengthIsTwo()), is(true));
        }

        @Test
        public void noneMatchは_条件に当てはまる要素を含むとき_falseを返す() {
            _Items<RString> sut = new _Items<>(asList(VAL1, VAL2, VAL3, new RString("12")));
            assertThat(sut.noneMatch(lengthIsTwo()), is(false));
        }

        private ICondition<RString> lengthIsTwo() {
            return new ICondition<RString>() {
                @Override
                public boolean check(RString t) {
                    return t.length() == 2;
                }
            };
        }
    }
}
