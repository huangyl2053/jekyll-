/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
//import static org.mockito.Mockito.*;

/**
 * TorisageRiyuのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class TorisageRiyuTest extends DbzTestBase {

    public static class asRString extends DbzTestBase {

        @Before
        public void setUp() {
        }

        @Test
        public void asRStringは_コンストラクタの引数と_同じ値を返す() {
            RString torisageRiyu = new RString("取下げ理由");
            TorisageRiyu sut = new TorisageRiyu(torisageRiyu);
            assertThat(sut.asRString(), is(torisageRiyu));
        }

        @Test
        public void asRStringは_コンストラクタの引数がnullのとき_RString$EMPTYを返す() {
            TorisageRiyu sut = new TorisageRiyu(null);
            assertThat(sut.asRString(), is(RString.EMPTY));
        }
    }

    public static class Equals extends DbzTestBase {

        private TorisageRiyu sut;

        @Before
        public void setUp() {
            sut = new TorisageRiyu(new RString("test"));
        }

        @Test
        public void equalsは_同じ値から生成されたインスタンス同士であれば_trueを返す() {
            assertThat(sut.equals(new TorisageRiyu(new RString("test"))), is(true));
        }

        @Test
        public void equlasは_異なる値から生成されたインスタンス同士では_falseを返す() {
            assertThat(sut.equals(new TorisageRiyu(new RString("test1"))), is(false));
        }

        @Test
        public void equalsは_nullとの比較であれば_falseを返す() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void equalsは_違う型のインスタンスとの比較であれば_falseを返す() {
            assertThat(sut.equals(new RString("test")), is(false));
        }
    }
}
