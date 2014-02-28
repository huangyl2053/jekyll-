/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催地区のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiChikuTest extends DbeTestBase {

    private static RString code = new RString("code");
    private static RString name = new RString("name");

    public static class コンストラクタのテスト {

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            ShinsainKubun sut = new ShinsainKubun(null, name);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            ShinsainKubun sut = new ShinsainKubun(code, null);
        }
    }
}
