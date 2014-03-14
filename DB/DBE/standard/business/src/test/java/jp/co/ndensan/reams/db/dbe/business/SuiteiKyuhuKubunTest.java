/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.SuiteiKyuhuKubunCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 推定給付区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class SuiteiKyuhuKubunTest {

    private static SuiteiKyuhuKubun sut;

    public static class get推定給付区分コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new SuiteiKyuhuKubun(new SuiteiKyuhuKubunCode(new RString("001")), new RString("名称"));
        }

        @Test
        public void get推定給付区分コードと_getCodeで取得した内容が_同一になる() {
            assertThat(sut.get推定給付区分コード().value(), is(sut.getCode().value()));
        }
    }
}
