/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.jukyu.shiharaihohohenko.ShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShuryoShinseiShinsaKekkaKubun}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShuryoShinseiShinsaKekkaKubunTest {

    public ShuryoShinseiShinsaKekkaKubunTest() {
    }

    public static class toRString extends DbzTestBase {

        @Test
        public void toRStringは_nameをRStringへ変換した物を返す() {
            ShuryoShinseiShinsaKekkaKubun sut = ShuryoShinseiShinsaKekkaKubun.申請却下;
            assertThat(sut.toRString(), is(new RString(sut.name())));
        }
    }

    public static class toValue extends DbzTestBase {

        private ShuryoShinseiShinsaKekkaKubun sut;

        @Test
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが有る時_そのオブジェクトを返す() {
            ShuryoShinseiShinsaKekkaKubun result = sut.toValue(ShuryoShinseiShinsaKekkaKubun.申請却下.code());
            assertThat(result, is(ShuryoShinseiShinsaKekkaKubun.申請却下));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(null);
        }
    }
}
