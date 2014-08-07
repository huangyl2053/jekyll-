/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * みなし2号被保険者区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class Minashi2GoHihokenshaKubunTest {

    private static Minashi2GoHihokenshaKubun sut;
    private static final Code みなし2号被保区分コード = new Code("1");
    private static final RString みなし2号被保区分 = new RString("みなし2号");

    public static class getterのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut = new Minashi2GoHihokenshaKubun(みなし2号被保区分コード, みなし2号被保区分);
        }

        @Test
        public void getみなし2号被保険者区分コードとgetCodeで取得した内容は_同一になる() {
            assertThat(sut.getみなし2号被保険者区分コード().value(), is(sut.getCode().value()));
        }

        @Test
        public void get被保険者区分とgetMeishoで取得した内容は_同一になる() {
            assertThat(sut.get被保険者区分(), is(sut.getMeisho()));
        }

    }

}
