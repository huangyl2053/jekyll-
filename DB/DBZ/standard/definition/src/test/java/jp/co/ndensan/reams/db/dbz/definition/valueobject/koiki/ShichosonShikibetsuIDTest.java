/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.util.IllegalInitialValueException;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ShichosonShikibetsuIDのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShichosonShikibetsuIDTest extends DbzTestBase {

    public ShichosonShikibetsuIDTest() {
    }

    @RunWith(Enclosed.class)
    public static class Constructor extends DbzTestBase {

        public static class Constructor_String extends DbzTestBase {

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数がnullの時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID((String) null);
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数に半角数字以外を含む時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID("a1");
                assertThat(sut, isA(ShichosonShikibetsuID.class));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数が1桁の時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID("1");
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数が3桁の時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID("123");
            }

            @Test
            public void コンストラクタは_引数が2桁の時_ShichosonShikibetsuIDのインスタンスを生成する() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
                assertThat(sut, isA(ShichosonShikibetsuID.class));
            }
        }

        public static class Constructor_RString extends DbzTestBase {

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数がnullの時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID((RString) null);
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数に半角数字以外を含む時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID(new RString("愛それは愛"));
                assertThat(sut, isA(ShichosonShikibetsuID.class));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数が1桁の時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID(new RString("1"));
            }

            @Test(expected = IllegalInitialValueException.class)
            public void コンストラクタは_引数が3桁の時_IllegalInitialValueExceptionをスローする() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID(new RString("123"));
            }

            @Test
            public void コンストラクタは_引数が2桁の時_ShichosonShikibetsuIDのインスタンスを生成する() {
                ShichosonShikibetsuID sut = new ShichosonShikibetsuID(new RString("12"));
                assertThat(sut, isA(ShichosonShikibetsuID.class));
            }
        }
    }

    public static class valueAndGetColumnValue_createFromRString extends DbzTestBase {

        private ShichosonShikibetsuID sut;
        private RString value;

        @Before
        public void setUp() {
            value = new RString("12");
            sut = new ShichosonShikibetsuID(value);
        }

        @Test
        public void RStringから生成したとき_valueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.value(), is(value));
        }

    }

    public static class valueAndGetColumnValue_createFromString extends DbzTestBase {

        private ShichosonShikibetsuID sut;
        private String value;

        @Before
        public void setUp() {
            value = "12";
            sut = new ShichosonShikibetsuID(value);
        }

        @Test
        public void Stringから生成したとき_valueは_コンストラクタ引数をRStringへ変換したものと_同じ値を返す() {
            assertThat(sut.value(), is(new RString(value)));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_値が同じものと比較したときは_0を返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("12");
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_値が小さいものと比較したときは_0より大きい値を返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("11");
            assertThat(0 < sut.compareTo(other), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("99");
            assertThat(sut.compareTo(other) < 0, is(true));
        }
    }

    public static class equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            assertThat(sut.equals((ShichosonShikibetsuID) null), is(false));
        }

        @Test
        public void equalsは_比較対象がShichosonShikibetsuID型でないなら_falseを返す() {
            RString otherType = new RString("12");
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            assertThat(sut.equals(otherType), is(false));
        }

        @Test
        public void equalsは_同一の値で生成されたインスタンス同士では_trueを返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("12");
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_同じ文字列で生成されたインスタンス同士では_trueを返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID(new RString("12"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_異なった値で生成されたインスタンス同士では_falseを返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("13");
            assertThat(sut.equals(other), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同一の値で生成されたインスタンス同士は_同じ値を返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("12");
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_異なった値で生成されたインスタンス同士は_違う値を返す() {
            ShichosonShikibetsuID sut = new ShichosonShikibetsuID("12");
            ShichosonShikibetsuID other = new ShichosonShikibetsuID("13");
            assertThat(sut.hashCode(), is(not(other.hashCode())));
        }
    }
}
