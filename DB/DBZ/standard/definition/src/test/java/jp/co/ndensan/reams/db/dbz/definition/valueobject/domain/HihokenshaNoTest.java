/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * HihokenshaNoのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaNoTest {

    public HihokenshaNoTest() {
    }

    public static class valueAndGetColumnValue_createFromRString extends DbzTestBase {

        private HihokenshaNo sut;
        private RString value;

        @Test
        public void RStringから生成したとき_valueは_コンストラクタ引数と_同じ値を返す() {
            value = new RString("12");
            sut = new HihokenshaNo(value);
            assertThat(sut.value(), is(value));
        }

        @Test
        public void RStringのnullから生成したとき_valueは_nullを返す() {
            sut = new HihokenshaNo((RString) null);
            assertThat(sut.value(), is(nullValue()));
        }
    }

    public static class valueAndGetColumnValue_createFromString extends DbzTestBase {

        private HihokenshaNo sut;
        private String value;

        @Test
        public void Stringから生成したとき_valueは_コンストラクタ引数をRStringへ変換したものと_同じ値を返す() {
            value = "12";
            sut = new HihokenshaNo(value);
            assertThat(sut.value(), is(new RString(value)));
        }

        public void Stringのnullから生成した時_valueは_RString$EMPTYを返す() {
            sut = new HihokenshaNo((String) null);
            assertThat(sut.value(), is(RString.EMPTY));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_自身と値が同じものを比較したときは_0を返す() {
            HihokenshaNo sut = new HihokenshaNo("0");
            HihokenshaNo target = new HihokenshaNo("0");
            assertThat(sut.compareTo(target), is(0));
        }

        @Test
        public void compareToは_自身より値が小さいものと比較したときは_0より大きい値を返す() {
            HihokenshaNo sut = new HihokenshaNo(new RString("1"));
            HihokenshaNo target = new HihokenshaNo(new RString("0"));
            assertThat((0 < sut.compareTo(target)), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            HihokenshaNo sut = new HihokenshaNo("0");
            HihokenshaNo target = new HihokenshaNo("1");
            assertThat((sut.compareTo(target) < 0), is(true));
        }
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            HihokenshaNo sut = new HihokenshaNo("0");
            assertThat(sut.equals((HihokenshaNo) null), is(false));
        }

        @Test
        public void equalsは_比較対象がHihokenshaNoのインスタンスでないなら_falseを返す() {
            RString target = new RString("0");
            HihokenshaNo sut = new HihokenshaNo(target);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同じ文字列から生成されたインスタンス同士では_trueを返す() {
            HihokenshaNo sut = new HihokenshaNo("0");
            HihokenshaNo target = new HihokenshaNo("0");
            assertThat(sut.equals(target), is(true));
        }

        @Test
        public void equalsは_同じ値から生成されたインスタンス同士では_trueを返す() {
            HihokenshaNo sut = new HihokenshaNo("0");
            HihokenshaNo target = new HihokenshaNo(new RString("0"));
            assertThat(sut.equals(target), is(true));
        }

        @Test
        public void equalsは_異なった値で生成されたインスタンス同士では_falseを返す() {
            HihokenshaNo sut = new HihokenshaNo("1");
            HihokenshaNo target = new HihokenshaNo("0");
            assertThat(sut.equals(target), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同一の値で生成されたインスタンス同士は_同じ値を返す() {
            HihokenshaNo sut = new HihokenshaNo("12");
            HihokenshaNo other = new HihokenshaNo("12");
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_異なった値で生成されたインスタンス同士は_違う値を返す() {
            HihokenshaNo sut = new HihokenshaNo("12");
            HihokenshaNo other = new HihokenshaNo("13");
            assertThat(sut.hashCode(), is(not(other.hashCode())));
        }
    }
}
