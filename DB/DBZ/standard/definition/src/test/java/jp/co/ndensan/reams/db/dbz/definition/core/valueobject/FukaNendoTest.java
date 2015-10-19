/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * FukaNendoのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class FukaNendoTest extends DbzTestBase {

    public FukaNendoTest() {
    }

    public static class value_createFromFlexibleYear extends DbzTestBase {

        private FukaNendo sut;
        private FlexibleYear value;

        @Before
        public void setUp() {
            value = new FlexibleYear("2000");
            sut = new FukaNendo(value);
        }

        @Test
        public void FlexibleYearから生成したとき_valueは_コンストラクタ引数と_同じ値を返す() {
            assertThat(sut.value(), is(value));
        }
    }

    public static class value_createFromString extends DbzTestBase {

        private FukaNendo sut;
        private String value;

        @Before
        public void setUp() {
            value = "2000";
            sut = new FukaNendo(value);
        }

        @Test
        public void Stringから生成したとき_valueは_コンストラクタ引数をFlexibleYearへ変換したものと_同じ値を返す() {
            assertThat(sut.value(), is(new FlexibleYear(value)));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_自身と値が同じものを比較したときは_0を返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo("2000");
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_equalsがtrueを返すオブジェクトと比較したとき_0を返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo("2000");
            assertThat(sut.equals(other), is(true));
            assertThat(sut.compareTo(other), is(0));
        }

        @Test
        public void compareToは_自身より値が小さいものと比較したときは_0より大きい値を返す() {
            FukaNendo sut = new FukaNendo(new FlexibleYear("2001"));
            FukaNendo other = new FukaNendo(new FlexibleYear("2000"));
            assertThat((0 < sut.compareTo(other)), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo("2001");
            assertThat((sut.compareTo(other) < 0), is(true));
        }
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            FukaNendo sut = new FukaNendo("2000");
            assertThat(sut.equals((FukaNendo) null), is(false));
        }

        @Test
        public void equalsは_比較対象がFukaNendoのインスタンスでないなら_falseを返す() {
            FlexibleYear target = new FlexibleYear("2000");
            FukaNendo sut = new FukaNendo(target);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同じ値から生成されたインスタンス同士では_trueを返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo("2000");
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_同じ値を持ったFlexibleYearから生成されたインスタンス同士では_trueを返す() {
            FukaNendo sut = new FukaNendo(new FlexibleYear("2000"));
            FukaNendo other = new FukaNendo(new FlexibleYear("2000"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_ある値と_それと同じ値を持ったFlexibleYearから生成されたインスタンス同士では_trueを返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo(new FlexibleYear("2000"));
            assertThat(sut.equals(other), is(true));
        }

        @Test
        public void equalsは_異なる値から生成されたインスタンス同士では_falseを返す() {
            FukaNendo sut = new FukaNendo("2001");
            FukaNendo other = new FukaNendo("2000");
            assertThat(sut.equals(other), is(false));
        }

        @Test
        public void equalsは_異なる値を持ったFlexibleYearから生成されたインスタンス同士では_falseを返す() {
            FukaNendo sut = new FukaNendo(new FlexibleYear("2001"));
            FukaNendo other = new FukaNendo(new FlexibleYear("2000"));
            assertThat(sut.equals(other), is(false));
        }

        @Test
        public void equalsは_ある値と_それと異なる値を持ったFlexibleYearから生成されたインスタンス同士では_falseを返す() {
            FukaNendo sut = new FukaNendo("2000");
            FukaNendo other = new FukaNendo(new FlexibleYear("2001"));
            assertThat(sut.equals(other), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同じ値から生成されたインスタンスは_同じ値を返す() {
            FukaNendo sut = new FukaNendo("2012");
            FukaNendo other = new FukaNendo("2012");
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_同じ値を持ったFlexibleYearから生成されたインスタンスは_同じ値を返す() {
            FukaNendo sut = new FukaNendo(new FlexibleYear("2012"));
            FukaNendo other = new FukaNendo(new FlexibleYear("2012"));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_ある値と_それと同じ値を持ったFlexibleYearから生成されたインスタンスは_同じ値を返す() {
            FukaNendo sut = new FukaNendo("2012");
            FukaNendo other = new FukaNendo(new FlexibleYear("2012"));
            assertThat(sut.hashCode(), is(other.hashCode()));
        }
    }
}
