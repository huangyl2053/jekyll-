/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsainKubunCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査員区分クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsainKubunTest {

    private static ShinsainKubun sut;
    private static ShinsainKubunCode 区分コード = new ShinsainKubunCode(new RString("A001"));
    private static RString 区分名称 = new RString("委員");

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 区分コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsainKubun(null, 区分名称);
        }

        @Test(expected = NullPointerException.class)
        public void 区分名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsainKubun(区分コード, null);
        }
    }
}
