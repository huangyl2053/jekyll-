/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体長区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaichoKubunTest {

    public static class コンストラクタのテスト extends DbeTestBase {

        private RString code;
        private RString name;

        @Before
        public void setUp() {
            code = new RString("0001");
            name = new RString("name");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが返る() {
            GogitaichoKubun sut = new GogitaichoKubun(null, name);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが返る() {
            GogitaichoKubun sut = new GogitaichoKubun(code, null);
        }
    }
}
