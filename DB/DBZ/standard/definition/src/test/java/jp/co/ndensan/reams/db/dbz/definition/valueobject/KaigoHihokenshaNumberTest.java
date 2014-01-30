/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 介護保険被保険者番号のテストクラスです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class KaigoHihokenshaNumberTest extends TestBase {

    public static class CompareTo extends TestBase {

        @Test
        public void 自身と値が同じものを比較したときは_0を返す() {
            RString 同じ番号 = new RString("0000000001");

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(同じ番号);
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(同じ番号);

            assertThat(sut.compareTo(比較対象), is(0));
        }

        @Test
        public void 自身より値が小さいものと比較したときは_0より大きい値を返す() {

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("1000000000"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("0000000001"));

            assertThat((0 < sut.compareTo(比較対象)), is(true));
        }

        @Test
        public void 自身より値が大きいものと比較したときは_0より小さい値を返す() {

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("0000000001"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("1000000000"));

            assertThat((sut.compareTo(比較対象) < 0), is(true));
        }

        @Test
        public void Ｈ始まりでない自身とＨ始まりの物を比較したとき_0より小さい値を返す() {

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("1000000000"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("H000000001"));

            assertThat((sut.compareTo(比較対象) < 0), is(true));
        }

        @Test
        public void Ｈ始まりの自身とＨ始まりの値が小さい物を比較したとき_0より大きい値を返す() {

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("H100000000"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("H000000001"));

            assertThat((0 < sut.compareTo(比較対象)), is(true));
        }
    }

    public static class Equals extends TestBase {

        @Test
        public void 比較対象がnullなら_falseを返す() {
            RString 番号 = new RString("0000000001");

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(番号);

            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 比較対象がKaigoHihokenshaNoのインスタンスでないなら_falseを返す() {
            RString 番号 = new RString("0000000001");

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(番号);

            assertThat(sut.equals(番号), is(false));
        }

        @Test
        public void 同一の値で生成されたインスタンス同士は_trueを返す() {
            RString 同じ番号 = new RString("0000000001");

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(同じ番号);
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(同じ番号);

            assertThat(sut.equals(比較対象), is(true));
        }

        @Test
        public void 異なった値で生成されたインスタンス同士は_falseを返す() {
            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("1000000000"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("H000000001"));

            assertThat(sut.equals(比較対象), is(false));
        }
    }

    public static class HashCode extends TestBase {

        @Test
        public void 同一の値で生成されたインスタンス同士は_同じ値を返す() {
            RString 同じ番号 = new RString("0000000001");

            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(同じ番号);
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(同じ番号);

            assertThat((sut.hashCode() == 比較対象.hashCode()), is(true));
        }

        @Test
        public void 異なった値で生成されたインスタンス同士は_違う値を返す() {
            KaigoHihokenshaNumber sut = new KaigoHihokenshaNumber(new RString("1000000000"));
            KaigoHihokenshaNumber 比較対象 = new KaigoHihokenshaNumber(new RString("H000000001"));

            assertThat((sut.hashCode() == 比較対象.hashCode()), is(false));
        }
    }
}
