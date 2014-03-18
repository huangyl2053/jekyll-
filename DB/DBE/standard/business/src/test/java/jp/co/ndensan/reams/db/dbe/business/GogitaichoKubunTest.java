/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体長区分クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaichoKubunTest {

    private static GogitaichoKubun sut;
    private static GogitaichoKubunCode 区分コード = new GogitaichoKubunCode(new RString("A001"));
    private static RString 区分名称 = new RString("長");

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 区分コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new GogitaichoKubun(null, 区分名称);
        }

        @Test(expected = NullPointerException.class)
        public void 区分名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new GogitaichoKubun(区分コード, null);
        }
    }
}
