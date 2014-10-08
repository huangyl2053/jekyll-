/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 賦課エラー一覧のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorInternalReportTest extends DbbTestBase {

    public static class constructor extends DbbTestBase {

        private FukaErrorInternalReport sut;

        private SubGyomuCode subGyomuCode;
        private IInternalReportCommon common;
        private FukaErrorInternalReportItemList itemList;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            common = mock(IInternalReportCommon.class);
            itemList = new FukaErrorInternalReportItemList(Collections.EMPTY_LIST);
        }

        @Test(expected = NullPointerException.class)
        public void 内部帳票情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorInternalReport(null, itemList);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 内部帳票項目Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorInternalReport(common, null);
            fail();
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            sut = new FukaErrorInternalReport(common, itemList);
            assertThat(sut, is(instanceOf(FukaErrorInternalReport.class)));
        }
    }

}
