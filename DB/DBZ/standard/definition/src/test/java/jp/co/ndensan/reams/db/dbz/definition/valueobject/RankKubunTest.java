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
 * RankKubunのテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class RankKubunTest extends DbzTestBase {

    private static final RString ランク区分1 = new RString("010");
    private static final RString ランク区分2 = new RString("020");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            RankKubun sut = new RankKubun((RString) null);
        }
    }

    @RunWith(Enclosed.class)
    public static class ValueAndComparable extends DbzTestBase {

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                RankKubun sut = new RankKubun(ランク区分1);
                assertThat(sut.value(), is(ランク区分1));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                RankKubun sut = new RankKubun(new RString("000"));
                RankKubun target = new RankKubun(new RString("000"));
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                RankKubun sut = new RankKubun(ランク区分1);
                RankKubun target = new RankKubun(ランク区分2);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                RankKubun sut = new RankKubun(ランク区分2);
                RankKubun target = new RankKubun(ランク区分1);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = ランク区分1;
                RankKubun sut = new RankKubun(ランク区分1);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                RankKubun sut = new RankKubun(ランク区分1);
                assertThat(sut.equals((RankKubun) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                RankKubun sut = new RankKubun(new RString("000"));
                RankKubun target = new RankKubun(new RString("000"));
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                RankKubun sut = new RankKubun(new RString("000"));
                RankKubun target = new RankKubun(new RString("000"));
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
