/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinShikakuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * 審査会委員資格のテストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikakuTest {

    private static ShinsakaiIinShikaku sut;
    private static Code 区分コード = new Code("A001");
    private static RString 名称 = new RString("薬剤師");
    private static RString 略称 = new RString("薬剤師");

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test
        public void get区分コードと_getCodeで取得できる内容が_同一である() {
            sut = new ShinsakaiIinShikaku(区分コード, 名称, 略称);
            assertThat(sut.get区分コード().value(), is(sut.getCode().value()));
        }
    }
}
