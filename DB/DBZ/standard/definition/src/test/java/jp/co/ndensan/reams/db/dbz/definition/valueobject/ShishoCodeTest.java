/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ShishoCodeのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShishoCodeTest extends DbzTestBase {

    private static RString n00000 = new RString("n00000");
    private static RString n00001 = new RString("n00001");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            ShishoCode sut = new ShishoCode((RString) null);
        }
    }

    @RunWith(Enclosed.class)
    public static class ValueAndComparable extends DbzTestBase {

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                ShishoCode sut = new ShishoCode(n00000);
                assertThat(sut.value(), is(n00000));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                ShishoCode sut = new ShishoCode(new RString("n00000"));
                ShishoCode target = new ShishoCode(new RString("n00000"));
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                ShishoCode sut = new ShishoCode(n00000);
                ShishoCode target = new ShishoCode(n00001);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                ShishoCode sut = new ShishoCode(n00001);
                ShishoCode target = new ShishoCode(n00000);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class DbColumnMappable extends DbzTestBase {

        public static class Implements extends DbzTestBase {

            @Test
            public void ShishoCodeは_IDbColumnMappableを実装している() {
                ShishoCode sut = new ShishoCode(n00000);
                assertThat(sut, is(instanceOf(IDbColumnMappable.class)));
            }
        }

        public static class GetColumnValue extends DbzTestBase {

            @Test
            public void getColumnValueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                ShishoCode sut = new ShishoCode(n00000);
                assertThat(sut.getColumnValue(), is(n00000));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = n00000;
                ShishoCode sut = new ShishoCode(n00000);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                ShishoCode sut = new ShishoCode(n00000);
                assertThat(sut.equals((ShishoCode) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                ShishoCode sut = new ShishoCode(new RString("n00000"));
                ShishoCode target = new ShishoCode(new RString("n00000"));
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                ShishoCode sut = new ShishoCode(new RString("n00000"));
                ShishoCode target = new ShishoCode(new RString("n00000"));
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
