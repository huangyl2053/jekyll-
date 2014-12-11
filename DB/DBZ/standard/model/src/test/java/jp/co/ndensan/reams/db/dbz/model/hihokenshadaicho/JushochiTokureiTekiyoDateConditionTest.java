/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.JushochiTokureiTekiyoDateCondition}
 * のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiTekiyoDateConditionTest {

    private static JushochiTokureiTekiyoDateCondition sut;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            sut = new JushochiTokureiTekiyoDateCondition(null);
            fail();
        }
    }

    public static class check extends DbzTestBase {

        private HihokenshaDaichoModel condition;
        private HihokenshaDaichoModel target_match;
        private HihokenshaDaichoModel target_difTekiyoDate;

        @Before
        public void setUp() {
            condition = createModel("20141231");
            target_match = createModel("20141231");
            target_difTekiyoDate = createModel("20141230");

            sut = new JushochiTokureiTekiyoDateCondition(condition);
        }

        @Test
        public void 全ての条件を満たすModelが渡された場合_trueが返る() {
            assertThat(sut.check(target_match), is(true));
        }

        @Test
        public void 適用日が一致しない場合_falseを返す() {
            assertThat(sut.check(target_difTekiyoDate), is(false));
        }
    }

    private static HihokenshaDaichoModel createModel(String tekiyoDate) {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set適用年月日(new FlexibleDate(tekiyoDate));
        return model;
    }
}
