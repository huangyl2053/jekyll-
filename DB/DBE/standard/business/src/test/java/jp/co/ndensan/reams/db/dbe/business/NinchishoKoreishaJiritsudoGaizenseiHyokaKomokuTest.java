/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.core.NinchishoKoreishaJiritsudo.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認知症高齢者自立度蓋然性評価項目のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinchishoKoreishaJiritsudoGaizenseiHyokaKomokuTest {

    private static NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku sut;

    public static class get認知症高齢者自立度蓋然性評価コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
        }

        @Test
        public void get認知症高齢者自立度蓋然性評価コードと_getCodeで取得した内容が_同一になる() {
            assertThat(sut.get認知症高齢者自立度蓋然性評価コード().value(), is(sut.get認知症高齢者自立度蓋然性評価コード().asCode().value()));
        }
    }
}
