/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinchishoKoreishaJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認知症高齢者自立度項目のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinchishoKoreishaJiritsudoKomokuTest {

    private static NinchishoKoreishaJiritsudoKomoku sut;

    public static class get認知症高齢者自立度コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NinchishoKoreishaJiritsudoKomoku(new NinchishoKoreishaJiritsudoCode(new RString("001")), new RString("名称"));
        }

        @Test
        public void get認知症高齢者自立度コードと_getCodeで取得した内容が_同一になる() {
            assertThat(sut.get認知症高齢者自立度コード().value(), is(sut.getCode().value()));
        }
    }
}
