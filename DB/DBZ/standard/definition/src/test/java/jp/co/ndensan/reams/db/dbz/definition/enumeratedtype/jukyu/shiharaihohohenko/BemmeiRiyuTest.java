/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.jukyu.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeiRiyu}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class BemmeiRiyuTest {

    public BemmeiRiyuTest() {
    }

    public static class toValue extends DbzTestBase {

        private BemmeiRiyu sut;

        @Test
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが有る時_そのオブジェクトを返す() {
            BemmeiRiyu result = sut.toValue(BemmeiRiyu.保険料完納.code());
            assertThat(result, is(BemmeiRiyu.保険料完納));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(null);
        }
    }
}
