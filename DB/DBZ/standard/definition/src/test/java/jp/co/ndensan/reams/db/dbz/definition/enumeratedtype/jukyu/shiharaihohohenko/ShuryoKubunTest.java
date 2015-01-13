/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShuryoKubun}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShuryoKubunTest {

    public ShuryoKubunTest() {
    }

    public static class toRString extends DbzTestBase {

        @Test
        public void toRStringは_nameをRStringへ変換した物を返す() {
            ShuryoKubun sut = ShuryoKubun.終了申請書受理;
            assertThat(sut.toRString(), is(new RString(sut.name())));
        }

        @Test
        public void toRStringは_EMPTYの時_RStringEMPTYを返す() {
            ShuryoKubun sut = ShuryoKubun.EMPTY;
            assertThat(sut.toRString(), is(RString.EMPTY));
        }

    }

    public static class toValue extends DbzTestBase {

        private ShuryoKubun sut;

        @Test
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが有る時_そのオブジェクトを返す() {
            ShuryoKubun result = sut.toValue(ShuryoKubun.差止措置終了依頼書受理.code());
            assertThat(result, is(ShuryoKubun.差止措置終了依頼書受理));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(new RString("100"));
        }
    }
}
