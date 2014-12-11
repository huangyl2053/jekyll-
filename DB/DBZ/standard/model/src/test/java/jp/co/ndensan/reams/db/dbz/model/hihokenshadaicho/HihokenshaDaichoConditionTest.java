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
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoCondition}
 * のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoConditionTest {

    private static HihokenshaDaichoCondition sut;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            sut = new HihokenshaDaichoCondition(null);
            fail();
        }
    }

    public static class check extends DbzTestBase {

        private HihokenshaDaichoModel condition;
        private HihokenshaDaichoModel target_match;
        private HihokenshaDaichoModel target_difLasdecCode;
        private HihokenshaDaichoModel target_difHihokenshaNo;
        private HihokenshaDaichoModel target_difShoriDateTime;

        @Before
        public void setUp() {
            condition = createModel("202010", "1234500001", "20141231020506");
            target_match = createModel("202010", "1234500001", "20141231020506");
            target_difLasdecCode = createModel("202011", "1234500001", "20141231020506");
            target_difHihokenshaNo = createModel("202010", "1234500002", "20141231020506");
            target_difShoriDateTime = createModel("202010", "1234500001", "20141231020508");

            sut = new HihokenshaDaichoCondition(condition);
        }

        @Test
        public void 全ての条件を満たすModelが渡された場合_trueが返る() {
            assertThat(sut.check(target_match), is(true));
        }

        @Test
        public void 市町村コードが一致しない場合_falseを返す() {
            assertThat(sut.check(target_difLasdecCode), is(false));
        }

        @Test
        public void 被保険者番号が一致しない場合_falseを返す() {
            assertThat(sut.check(target_difHihokenshaNo), is(false));
        }

        @Test
        public void 処理日時が一致しない場合_falseを返す() {
            assertThat(sut.check(target_difShoriDateTime), is(false));
        }
    }

    private static HihokenshaDaichoModel createModel(String lasdecCode, String hihokenshaNo, String shoriDateTime) {
        HihokenshaDaichoModel model = new HihokenshaDaichoModel();
        model.set市町村コード(new LasdecCode(lasdecCode));
        model.set被保険者番号(new HihokenshaNo(hihokenshaNo));
        model.set処理日時(new YMDHMS(shoriDateTime));
        return model;
    }
}
