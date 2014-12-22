/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * ChoteiJiyuCodeのテストです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChoteiJiyuCodeTest extends DbzTestBase {

    private static final RString 調定事由コード1 = new RString("01");
    private static final RString 調定事由コード2 = new RString("02");

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            ChoteiJiyuCode sut = new ChoteiJiyuCode((RString) null);
        }
    }

    @RunWith(Enclosed.class)
    public static class ValueAndComparable extends DbzTestBase {

        public static class Value extends DbzTestBase {

            @Test
            public void valueは_コンストラクタの引数に指定したRStringと_同じ値を返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(調定事由コード1);
                assertThat(sut.value(), is(調定事由コード1));
            }
        }

        public static class Comparable extends DbzTestBase {

            @Test
            public void compareToは_同じ値から生成したオブジェクトを渡したとき_0を返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(new RString("00"));
                ChoteiJiyuCode target = new ChoteiJiyuCode(new RString("00"));
                assertThat(sut.compareTo(target), is(0));
            }

            @Test
            public void compareToは_辞書的に大きな値から生成したオブジェクトが渡されたとき_0より小さい値を返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(調定事由コード1);
                ChoteiJiyuCode target = new ChoteiJiyuCode(調定事由コード2);
                assertThat(sut.compareTo(target) < 0, is(true));
            }

            @Test
            public void compareToは_辞書的に小さな値から生成したオブジェクトが渡されたときは_0より大きな値を返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(調定事由コード2);
                ChoteiJiyuCode target = new ChoteiJiyuCode(調定事由コード1);
                assertThat(0 < sut.compareTo(target), is(true));
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class EqualsAndHashCode extends DbzTestBase {

        public static class Equals extends DbzTestBase {

            @Test
            public void equalsは_別クラスのオブジェクトが渡されたとき_falseを返す() {
                RString target = 調定事由コード1;
                ChoteiJiyuCode sut = new ChoteiJiyuCode(調定事由コード1);
                assertThat(sut.equals(target), is(false));
            }

            @Test
            public void equalsは_nullが渡されたとき_falseを返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(調定事由コード1);
                assertThat(sut.equals((ChoteiJiyuCode) null), is(false));
            }

            @Test
            public void equalsは_同じ値から生成したオブジェトが渡されたとき_trueを返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(new RString("00"));
                ChoteiJiyuCode target = new ChoteiJiyuCode(new RString("00"));
                assertThat(sut.equals(target), is(true));
            }
        }

        public static class HashCode extends DbzTestBase {

            @Test
            public void hashCodeは_同じ値から生成したオブジェクト同士は_同じ値を返す() {
                ChoteiJiyuCode sut = new ChoteiJiyuCode(new RString("00"));
                ChoteiJiyuCode target = new ChoteiJiyuCode(new RString("00"));
                assertThat(sut.hashCode(), is(target.hashCode()));
            }
        }
    }
}
