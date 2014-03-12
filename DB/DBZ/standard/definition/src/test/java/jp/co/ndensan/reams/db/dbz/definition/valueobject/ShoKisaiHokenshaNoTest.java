/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.definition.IKaigoValueObject;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShoKisaiHokenshaNoTest extends DbzTestBase {

    private static RString n00000 = new RString("n00000");
    private static RString n00001 = new RString("n00001");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo((RString) null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コンストラクタは_引数が6桁でないとき_IllegalArgumentExceptionをスローする() {
            ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(new RString(""));
        }
    }

    @RunWith(Enclosed.class)
    public static class KaigoValueObject extends DbzTestBase {

        public static class Implements extends DbzTestBase {

            @Test
            public void ShoKisaiHokenshaNoは_IKaigoValueObjectのインスタンスである() {
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
                assertThat(sut, is(instanceOf(IKaigoValueObject.class)));
            }
        }

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                RString sameValue = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
                assertThat(sut.value(), is(sameValue));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                RString sameValue = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
                ShoKisaiHokenshaNo target = new ShoKisaiHokenshaNo(sameValue);
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
                ShoKisaiHokenshaNo target = new ShoKisaiHokenshaNo(n00001);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00001);
                ShoKisaiHokenshaNo target = new ShoKisaiHokenshaNo(n00000);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class DbColumnMappable extends DbzTestBase {

        public static class Implements extends DbzTestBase {

            @Test
            public void ShoKisaiHokenshaNoは_IDbColumnMappableを実装している() {
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
                assertThat(sut, is(instanceOf(IDbColumnMappable.class)));
            }
        }

        public static class GetColumnValue extends DbzTestBase {

            @Test
            public void getColumnValueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                RString sameValue = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
                assertThat(sut.getColumnValue(), is(sameValue));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(n00000);
                assertThat(sut.equals((ShoKisaiHokenshaNo) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                RString sameValue = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
                ShoKisaiHokenshaNo target = new ShoKisaiHokenshaNo(sameValue);
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                RString sameValue = n00000;
                ShoKisaiHokenshaNo sut = new ShoKisaiHokenshaNo(sameValue);
                ShoKisaiHokenshaNo target = new ShoKisaiHokenshaNo(sameValue);
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
