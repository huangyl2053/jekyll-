/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinShikakuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 * 審査会委員資格のテストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikakuTest {

    private static ShinsakaiIinShikaku sut;
    private static ShinsakaiIinShikakuCode 区分コード = new ShinsakaiIinShikakuCode(new RString("A001"));
    private static RString 区分名称 = new RString("薬剤師");

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 区分コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiIinShikaku(null, 区分名称);
        }

        @Test(expected = NullPointerException.class)
        public void 区分名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiIinShikaku(区分コード, null);
        }
    }
}
