/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.Minashi2GoHihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * みなし2号被保険者区分コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class Minashi2GoHihokenshaKubunCodeTest {

    private static Minashi2GoHihokenshaKubunCode sut;
    private static Minashi2GoHihokenshaKubunCode comparison;

    public static class constructorのテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Minashi2GoHihokenshaKubunCode(null);
        }
    }

    public static class equalsのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut = new Minashi2GoHihokenshaKubunCode(new Code("1"));
        }

        @Test
        public void 引数に_nullを渡したとき_falseを返す() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数に_型の違うインスタンスを渡したとき_falseを返す() {
            assertThat(sut.equals(new RString("1")), is(false));
        }

        @Test
        public void 引数に_値の一致しない被保険者区分コード型インスタンスを渡したとき_falseを返す() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("2"));
            assertThat(sut.equals(comparison), is(false));
        }

        @Test
        public void 引数に_同値の被保険者区分コード型インスタンスを渡したとき_trueを返す() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("1"));
            assertThat(sut.equals(comparison), is(true));
        }
    }

    public static class hashCodeのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut = new Minashi2GoHihokenshaKubunCode(new Code("1"));
        }

        @Test
        public void 同値を持つ被保険者区分コードクラスの場合_hashCodeも一致する() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("1"));
            assertThat(sut.hashCode(), is(comparison.hashCode()));
        }
    }

    public static class compareToのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut = new Minashi2GoHihokenshaKubunCode(new Code("1"));
        }

        @Test
        public void 小さい値と比較した場合_0より大きい値を返す() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("0"));
            assertThat(0 < sut.compareTo(comparison), is(true));
        }

        @Test
        public void 同値と比較した場合_0を返す() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("1"));
            assertThat(sut.compareTo(comparison) == 0, is(true));
        }

        @Test
        public void 大きい値と比較した場合_0より小さい値を返す() {
            comparison = new Minashi2GoHihokenshaKubunCode(new Code("2"));
            assertThat(sut.compareTo(comparison) < 0, is(true));
        }
    }

}
