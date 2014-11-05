/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * RenrakusakiKubunNoのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class RenrakusakiKubunNoTest extends DbzTestBase {

    public RenrakusakiKubunNoTest() {
    }

    public static class value_createFromRString extends DbzTestBase {

        private RenrakusakiKubunNo sut;
        private RString value;

        @Before
        public void setUp() {
            value = new RString("12");
            sut = new RenrakusakiKubunNo(value);
        }

        @Test
        public void RStringから生成したとき_valueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.value(), is(value));
        }
    }

    public static class value_createFromString extends DbzTestBase {

        private RenrakusakiKubunNo sut;
        private String value;

        @Before
        public void setUp() {
            value = "12";
            sut = new RenrakusakiKubunNo(value);
        }

        @Test
        public void Stringから生成したとき_valueは_コンストラクタ引数をRStringへ変換したものと_同じ値を返す() {
            assertThat(sut.value(), is(new RString(value)));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_自身と値が同じものを比較したときは_0を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("0");
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_equalsがtrueを返すオブジェクトと比較したとき_0を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("0");
            assertThat(sut.equals(other), is(true));
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_自身より値が小さいものと比較したときは_0より大きい値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("1"));
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("0"));
            assertThat((0 < sut.compareTo(other)), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("1");
            assertThat((sut.compareTo(other) < 0), is(true));
        }
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            assertThat(sut.equals((RenrakusakiKubunNo) null), is(false));
        }

        @Test
        public void equalsは_比較対象がRenrakusakiKubunNoのインスタンスでないなら_falseを返す() {
            RString target = new RString("0");
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(target);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同じ文字列から生成されたインスタンス同士では_trueを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("0");
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_同じ文字列を持ったRStringから生成されたインスタンス同士では_trueを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("0"));
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("0"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_ある文字列と_それと同じ文字列を持ったRStringから生成されたインスタンス同士では_trueを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("0"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_異なる文字列から生成されたインスタンス同士では_falseを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("1");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("0");
            assertThat(sut.equals(other), is(false));
        }

        @Test
        public void equalsは_異なる文字列を持ったRStringから生成されたインスタンス同士では_falseを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("1"));
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("0"));
            assertThat(sut.equals(other), is(false));
        }

        @Test
        public void equalsは_ある文字列と_それと異なる文字列を持ったRStringから生成されたインスタンス同士では_falseを返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("0");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("1"));
            assertThat(sut.equals(other), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同じ文字列から生成されたインスタンスは_同じ値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("12");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo("12");
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_同じ文字列を持ったRStringから生成されたインスタンスは_同じ値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("12"));
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("12"));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_ある文字列と_それと同じ文字列を持ったRStringから生成されたインスタンスは_同じ値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo("12");
            RenrakusakiKubunNo other = new RenrakusakiKubunNo(new RString("12"));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }
    }
}
