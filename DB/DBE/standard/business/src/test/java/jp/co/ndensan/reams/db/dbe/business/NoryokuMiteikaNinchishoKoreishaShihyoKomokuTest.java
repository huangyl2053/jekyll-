/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 能力未低下認知症高齢者指標のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NoryokuMiteikaNinchishoKoreishaShihyoKomokuTest {

    private static NoryokuMiteikaNinchishoKoreishaShihyoKomoku sut;

    public static class get能力未低下認知症高齢者指標コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
        }

        @Test
        public void get能力未低下認知症高齢者指標コードと_getCodeで取得した内容が_同一になる() {
            assertThat(sut.get能力未低下認知症高齢者指標コード().value(), is(sut.getCode().value()));
        }
    }
}
