/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラーのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorTest extends DbbTestBase {

    public static class getFukaErrorCode extends DbbTestBase {

        private FukaError sut;
        private Code code;

        @Test
        public void 引数から渡したCodeと_getFukaErrorCodeで取得できる賦課エラーコードが_一致する() {
            code = new Code("010");
            sut = new FukaError(code, RString.EMPTY, RString.EMPTY);
            assertThat(sut.getFukaErrorCode().asCode(), is(code));
        }
    }

}
