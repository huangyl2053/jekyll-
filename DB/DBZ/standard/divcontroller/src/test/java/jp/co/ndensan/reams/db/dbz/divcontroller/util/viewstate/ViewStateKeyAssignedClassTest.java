/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ViewStateKeyAssignedClassのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ViewStateKeyAssignedClassTest {

    public ViewStateKeyAssignedClassTest() {
    }

    public static class Equals extends DbzTestBase {

        @Test
        public void equalsは_比較対象がnullなら_falseを返す() {
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            assertThat(sut.equals((ViewStateKeyAssignedClass) null), is(false));
        }

        @Test
        public void equalsは_比較対象がViewStateKeyAssignedClassのインスタンスでないなら_falseを返す() {
            RString target = new RString("0");
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            assertThat(sut.equals(target), is(false));
        }

        @Test
        public void equalsは_同じClassから生成されたインスタンス同士では_trueを返す() {
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            ViewStateKeyAssignedClass target = new ViewStateKeyAssignedClass(RString.class);
            assertThat(sut.equals(target), is(true));
        }

        @Test
        public void equalsは_異なったClassから生成されたインスタンス同士では_falseを返す() {
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            ViewStateKeyAssignedClass target = new ViewStateKeyAssignedClass(String.class);
            assertThat(sut.equals(target), is(false));
        }
    }

    public static class HashCode extends DbzTestBase {

        @Test
        public void hashCodeは_同一のClassから生成されたインスタンス同士は_同じ値を返す() {
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            ViewStateKeyAssignedClass other = new ViewStateKeyAssignedClass(RString.class);
            assertThat(sut.hashCode(), is(other.hashCode()));
        }

        @Test
        public void hashCodeは_異なったClassから生成されたインスタンス同士では_違う値を返す() {
            ViewStateKeyAssignedClass sut = new ViewStateKeyAssignedClass(RString.class);
            ViewStateKeyAssignedClass other = new ViewStateKeyAssignedClass(String.class);
            assertThat(sut.hashCode(), is(not(other.hashCode())));
        }
    }
}
