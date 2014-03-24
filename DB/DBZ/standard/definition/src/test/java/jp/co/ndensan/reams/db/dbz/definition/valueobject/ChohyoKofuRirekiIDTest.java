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
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * ChohyoKofuRirekiIDのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ChohyoKofuRirekiIDTest extends DbzTestBase {

    private static RString n0000000000 = new RString("n000000000");
    private static RString n0000000001 = new RString("n000000001");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID((RString) null);
        }
    }

    @RunWith(Enclosed.class)
    public static class KaigoValueObject extends DbzTestBase {

        public static class Implements extends DbzTestBase {

            @Test
            public void ChohyoKofuRirekiIDは_IKaigoValueObjectのインスタンスである() {
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(n0000000000);
                assertThat(sut, is(instanceOf(IKaigoValueObject.class)));
            }
        }

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                RString sameValue = n0000000000;
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(sameValue);
                assertThat(sut.value(), is(sameValue));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                RString sameValue = n0000000000;
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(sameValue);
                ChohyoKofuRirekiID target = new ChohyoKofuRirekiID(sameValue);
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(n0000000000);
                ChohyoKofuRirekiID target = new ChohyoKofuRirekiID(n0000000001);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(n0000000001);
                ChohyoKofuRirekiID target = new ChohyoKofuRirekiID(n0000000000);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = n0000000000;
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(n0000000000);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(n0000000000);
                assertThat(sut.equals((ChohyoKofuRirekiID) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                RString sameValue = n0000000000;
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(sameValue);
                ChohyoKofuRirekiID target = new ChohyoKofuRirekiID(sameValue);
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                RString sameValue = n0000000000;
                ChohyoKofuRirekiID sut = new ChohyoKofuRirekiID(sameValue);
                ChohyoKofuRirekiID target = new ChohyoKofuRirekiID(sameValue);
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
