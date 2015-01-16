/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaKubun}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HihokenshaKubunTest {

    public HihokenshaKubunTest() {
    }

    public static class toRString extends DbzTestBase {

        @Test
        public void toRStringは_nameをRStringへ変換した物を返す() {
            HihokenshaKubun sut = HihokenshaKubun.第1号被保険者;
            assertThat(sut.toRString(), is(new RString(sut.name())));
        }
    }

    public static class toValue extends DbzTestBase {

        private HihokenshaKubun sut;

        @Test
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが有る時_そのオブジェクトを返す() {
            HihokenshaKubun result = sut.toValue(HihokenshaKubun.第1号被保険者.code());
            assertThat(result, is(HihokenshaKubun.第1号被保険者));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(null);
        }
    }
}
