/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * RenrakusakiKubunNoのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class RenrakusakiKubunNoTest extends DbeTestBase {

    private static RString n0000000 = new RString("n0000000");
    private static RString n0000001 = new RString("n0000001");

    public static class Constructor extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo((RString) null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタは_引数が8桁でないとき_IllegalArgumentExceptionをスローする() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("1"));
        }
    }

    public static class Value extends DbeTestBase {

        @Test
        public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
            RString value = n0000000;
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(value);
            assertThat(sut.value(), is(value));
        }
    }

    public static class Comparable extends DbeTestBase {

        @Test
        public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("n0000000"));
            RenrakusakiKubunNo target = new RenrakusakiKubunNo(new RString("n0000000"));
            assertThat(sut.compareTo(target), is(0));
        }

        @Test
        public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(n0000000);
            RenrakusakiKubunNo target = new RenrakusakiKubunNo(n0000001);
            assertThat(sut.compareTo(target) < 0, is(true));
        }

        @Test
        public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
            RenrakusakiKubunNo sut = new RenrakusakiKubunNo(n0000001);
            RenrakusakiKubunNo target = new RenrakusakiKubunNo(n0000000);
            assertThat(0 < sut.compareTo(target), is(true));
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbeTestBase {

        public static class Equals extends DbeTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = n0000000;
                RenrakusakiKubunNo sut = new RenrakusakiKubunNo(n0000000);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                RenrakusakiKubunNo sut = new RenrakusakiKubunNo(n0000000);
                assertThat(sut.equals((RenrakusakiKubunNo) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("n0000000"));
                RenrakusakiKubunNo target = new RenrakusakiKubunNo(new RString("n0000000"));
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbeTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                RenrakusakiKubunNo sut = new RenrakusakiKubunNo(new RString("n0000000"));
                RenrakusakiKubunNo target = new RenrakusakiKubunNo(new RString("n0000000"));
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
