/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 介護被保険者番号のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class KaigoHihokenshaNoTest extends DbzTestBase {

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo((RString) null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタは_引数が10桁でないとき_IllegalArgumentExceptionをスローする() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString(""));
        }
    }

    public static class CompareTo extends DbzTestBase {

        @Test
        public void compareToは_自身と値が同じものを比較したときは_0を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("0000000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("0000000000"));
            assertThat(sut.compareTo(target), is(0));
        }

        @Test
        public void compareToは_自身より値が小さいものと比較したときは_0より大きい値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("1000000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("0000000001"));
            assertThat((0 < sut.compareTo(target)), is(true));
        }

        @Test
        public void compareToは_自身より値が大きいものと比較したときは_0より小さい値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("0000000001"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("1000000000"));
            assertThat((sut.compareTo(target) < 0), is(true));
        }

        @Test
        public void compareToは_H始まりでない自身とH始まりの物を比較したとき_0より小さい値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("1000000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("H000000001"));
            assertThat((sut.compareTo(target) < 0), is(true));
        }

        @Test
        public void compareToは_H始まりの自身とH始まりの値が小さい物を比較したとき_0より大きい値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("H100000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("H000000001"));
            assertThat((0 < sut.compareTo(target)), is(true));
        }
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("0000000001"));
            assertThat(sut.equals((KaigoHihokenshaNo) null), is(false));
        }

        @Test
        public void equalsは_比較対象がKaigoHihokenshaNoのインスタンスでないなら_falseを返す() {
            RString target = new RString("0000000001");
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(target);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同一の値で生成されたインスタンス同士では_trueを返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("0000000001"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("0000000001"));
            assertThat(sut.equals(target), is(true));
        }

        @Test
        public void equalsは_異なった値で生成されたインスタンス同士では_falseを返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("1000000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("H000000001"));
            assertThat(sut.equals(target), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同一の値で生成されたインスタンス同士は_同じ値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("0000000001"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("0000000001"));
            assertThat((sut.hashCode() == target.hashCode()), is(true));
        }

        @Test
        public void hashCodeは_異なった値で生成されたインスタンス同士は_違う値を返す() {
            KaigoHihokenshaNo sut = new KaigoHihokenshaNo(new RString("1000000000"));
            KaigoHihokenshaNo target = new KaigoHihokenshaNo(new RString("H000000001"));
            assertThat((sut.hashCode() == target.hashCode()), is(false));
        }
    }
}
