/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha.RokenShichosonNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * RokenShichosonNoのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class RokenShichosonNoTest {

    public RokenShichosonNoTest() {
    }

    public static class hasValidLength extends DbzTestBase {

        @Test
        public void hasValidLengthは_コンストラクタ引数がnullの時_trueを返す() {
            RokenShichosonNo sut = new RokenShichosonNo((RString) null);
            assertThat(sut.hasValidLength(), is(true));
        }

        @Test
        public void hasValidLengthは_コンストラクタ引数が8桁の時_trueを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            assertThat(sut.hasValidLength(), is(true));
        }

        @Test
        public void hasValidLengthは_コンストラクタは_引数が9桁の時_falseを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("123456789");
            assertThat(sut.hasValidLength(), is(false));
        }
    }

    public static class valueAndGetColumnValue_createFromRString extends DbzTestBase {

        private RokenShichosonNo sut;
        private RString value;

        @Before
        public void setUp() {
            value = new RString("12345678");
            sut = new RokenShichosonNo(value);
        }

        @Test
        public void RStringから生成したとき_valueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.value(), is(value));
        }
    }

    public static class valueAndGetColumnValue_createFromString extends DbzTestBase {

        private RokenShichosonNo sut;
        private String value;

        @Before
        public void setUp() {
            value = "12345678";
            sut = new RokenShichosonNo(value);
        }

        @Test
        public void Stringから生成したとき_valueは_コンストラクタ引数をRStringへ変換したものと_同じ値を返す() {
            assertThat(sut.value(), is(new RString(value)));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_値が同じものと比較したときは_0を返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("12345678");
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_値が小さいものと比較したときは_0より大きい値を返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("11111111");
            assertThat(0 < sut.compareTo(other), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("98765432");
            assertThat(sut.compareTo(other) < 0, is(true));
        }
    }

    public static class EMPTY extends DbzTestBase {

        private final RokenShichosonNo sut = RokenShichosonNo.EMPTY;

        @Test
        public void RokenShichosonNo$EMPTYは_valueで_RString$EMPTYを返す() {
            assertThat(sut.value(), is(RString.EMPTY));
        }
    }

    public static class equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            assertThat(sut.equals((RokenShichosonNo) null), is(false));
        }

        @Test
        public void equalsは_比較対象がRokenShichosonNo型でないなら_falseを返す() {
            RString otherType = new RString("12345678");
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            assertThat(sut.equals(otherType), is(false));
        }

        @Test
        public void equalsは_同一の値で生成されたインスタンス同士では_trueを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("12345678");
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_同じ文字列で生成されたインスタンス同士では_trueを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo(new RString("12345678"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_異なった値で生成されたインスタンス同士では_falseを返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("13345678");
            assertThat(sut.equals(other), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同一の値で生成されたインスタンス同士は_同じ値を返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("12345678");
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_異なった値で生成されたインスタンス同士は_違う値を返す() {
            RokenShichosonNo sut = new RokenShichosonNo("12345678");
            RokenShichosonNo other = new RokenShichosonNo("12345677");
            assertThat(sut.hashCode(), is(not(other.hashCode())));
        }
    }
}
