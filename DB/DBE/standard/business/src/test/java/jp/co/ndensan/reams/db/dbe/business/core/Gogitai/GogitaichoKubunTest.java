/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Gogitai;

import jp.co.ndensan.reams.db.dbe.business.core.gogitai.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体長区分クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
@Ignore
public class GogitaichoKubunTest {

    private static GogitaichoKubun sut;
    private static Code 区分コード = new Code("A001");
    private static RString 名称 = new RString("委員");
    private static RString 略称 = new RString("委員");

    public static class get区分コードのテスト extends DbeTestBase {

        @Test
        public void get区分コードとgetCodeで取得した内容は_同一になる() {
            sut = new GogitaichoKubun(区分コード, 名称, 略称);
            assertThat(sut.getGogitaichoKubunCode().value(), is(sut.getGogitaichoKubunCode().asCode().value()));
        }
    }
}
