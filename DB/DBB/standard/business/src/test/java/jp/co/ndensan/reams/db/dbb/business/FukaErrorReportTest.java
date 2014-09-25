/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラー一覧のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorReportTest extends DbbTestBase {

    public static class constructor extends DbbTestBase {

        private FukaErrorReport sut;

        private SubGyomuCode subGyomuCode;
        private InternalReportInfo reportInfo;
        private InternalReportBatchInfo batchInfo;
        private List<FukaErrorReportItem> itemList;

        @Before
        public void setUp() {
            subGyomuCode = SubGyomuCode.DBB介護賦課;
            reportInfo = new InternalReportInfo(RString.EMPTY, RString.EMPTY, RDateTime.MAX);
            batchInfo = new InternalReportBatchInfo(RString.EMPTY, RString.EMPTY, RDateTime.MAX);
            itemList = Collections.EMPTY_LIST;
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReport(null, reportInfo, batchInfo, itemList);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 内部帳票情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReport(subGyomuCode, null, batchInfo, itemList);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void バッチ情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReport(subGyomuCode, reportInfo, null, itemList);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 内部帳票項目Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReport(subGyomuCode, reportInfo, batchInfo, null);
            fail();
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            sut = new FukaErrorReport(subGyomuCode, reportInfo, batchInfo, itemList);
            assertThat(sut, is(instanceOf(FukaErrorReport.class)));
        }
    }

}
