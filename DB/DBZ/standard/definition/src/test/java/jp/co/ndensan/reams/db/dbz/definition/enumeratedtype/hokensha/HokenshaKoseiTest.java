/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * HokenshaKoseiのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HokenshaKoseiTest extends DbzTestBase {

    public HokenshaKoseiTest() {
    }

    public static class toValue extends DbzTestBase {

        private HokenshaKosei sut;

        @Test
        public void toValue_は引数のcodeに該当するオブジェクトが存在する時_それを返す() {
            HokenshaKosei item = HokenshaKosei.単一市町村;
            assertThat(sut.toValue(item.code()), is(item));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValue_は引数のcodeに該当するオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(new RString("99"));
        }
    }
}
