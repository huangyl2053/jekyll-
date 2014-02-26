/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員資格のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinShikakuTest extends TestBase {

    public static class コンストラクタのテスト {

        private static RString code = new RString("code");
        private static RString name = new RString("name");

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            new ShinsakaiIinShikaku(null, name);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            new ShinsakaiIinShikaku(code, null);
        }
    }
}
