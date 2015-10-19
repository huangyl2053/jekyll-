/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.IchijiHanteiResult;

import jp.co.ndensan.reams.db.dbe.business.core.IchijiHanteiResult.JotaiAnteiseiKubun;
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
 * 介護認定状態安定性区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JotaiAnteiseiKubunTest {

    private static JotaiAnteiseiKubun sut;

    public static class get介護認定状態安定性コードのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new JotaiAnteiseiKubun(new Code(new RString("001")), new RString("名称"), new RString("略称"));
        }

        @Test
        public void get介護認定状態安定性コードと_getCodeで取得した内容が_同一になる() {
            assertThat(sut.get介護認定状態安定性コード().value(), is(sut.get介護認定状態安定性コード().asCode().value()));
        }
    }
}
