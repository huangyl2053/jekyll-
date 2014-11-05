/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * HokenKyufuRitsuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HokenKyufuRitsuTest {

    public HokenKyufuRitsuTest() {
    }

    public static class valueAndGetColumnValue extends DbzTestBase {

        private HokenKyufuRitsu sut;
        private Decimal value;

        @Before
        public void setUp() {
            value = new Decimal(100);
            sut = new HokenKyufuRitsu(value);
        }

        @Test
        public void valueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.value(), is(value));
        }

        @Test
        public void getColumnValueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.getColumnValue(), is(value));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_自身と値が同じものを比較したときは_0を返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_equalsがtrueを返すオブジェクトと比較したとき_0を返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.equals(other), is(true));
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_自身より値が小さいものと比較したときは_0より大きい値を返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(90));
            assertThat((0 < sut.compareTo(other)), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(110));
            assertThat((sut.compareTo(other) < 0), is(true));
        }
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.equals((HokenKyufuRitsu) null), is(false));
        }

        @Test
        public void equalsは_比較対象がHokenKyufuRitsuのインスタンスでないなら_falseを返す() {
            Decimal target = new Decimal(100);
            HokenKyufuRitsu sut = new HokenKyufuRitsu(target);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同じ値から生成されたインスタンス同士では_trueを返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_異なる値から生成されたインスタンス同士では_falseを返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(101));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.equals(other), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同じ文字列から生成されたインスタンスは_同じ値を返す() {
            HokenKyufuRitsu sut = new HokenKyufuRitsu(new Decimal(100));
            HokenKyufuRitsu other = new HokenKyufuRitsu(new Decimal(100));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }
    }
}
