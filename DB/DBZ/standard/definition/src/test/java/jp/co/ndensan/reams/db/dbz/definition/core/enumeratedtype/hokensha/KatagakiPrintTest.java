/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * KatagakiPrintのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class KatagakiPrintTest extends DbzTestBase {

    public KatagakiPrintTest() {
    }

    public static class toValue extends DbzTestBase {

        private KatagakiPrint sut;

        @Test
        public void toValue_は引数のcodeに該当するオブジェクトが存在する時_それを返す() {
            KatagakiPrint item = KatagakiPrint.印字する;
            assertThat(sut.toValue(item.code()), is(item));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValue_は引数のcodeに該当するオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(new RString("99"));
        }
    }
}
