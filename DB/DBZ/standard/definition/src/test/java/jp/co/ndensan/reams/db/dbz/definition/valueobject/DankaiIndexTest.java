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
 * DankaiIndexのテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DankaiIndexTest extends DbzTestBase {

    private static final RString 段階インデックス1 = new RString("01");
    private static final RString 段階インデックス2 = new RString("02");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            DankaiIndex sut = new DankaiIndex((RString) null);
        }
    }

    @RunWith(Enclosed.class)
    public static class ValueAndComparable extends DbzTestBase {

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                DankaiIndex sut = new DankaiIndex(段階インデックス1);
                assertThat(sut.value(), is(段階インデックス1));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                DankaiIndex sut = new DankaiIndex(new RString("00"));
                DankaiIndex target = new DankaiIndex(new RString("00"));
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                DankaiIndex sut = new DankaiIndex(段階インデックス1);
                DankaiIndex target = new DankaiIndex(段階インデックス2);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                DankaiIndex sut = new DankaiIndex(段階インデックス2);
                DankaiIndex target = new DankaiIndex(段階インデックス1);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = 段階インデックス1;
                DankaiIndex sut = new DankaiIndex(段階インデックス1);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                DankaiIndex sut = new DankaiIndex(段階インデックス1);
                assertThat(sut.equals((DankaiIndex) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                DankaiIndex sut = new DankaiIndex(new RString("00"));
                DankaiIndex target = new DankaiIndex(new RString("00"));
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                DankaiIndex sut = new DankaiIndex(new RString("00"));
                DankaiIndex target = new DankaiIndex(new RString("00"));
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
