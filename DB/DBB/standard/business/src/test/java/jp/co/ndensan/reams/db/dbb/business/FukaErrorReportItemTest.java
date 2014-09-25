/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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
public class FukaErrorReportItemTest extends DbbTestBase {

    public static class constructor extends DbbTestBase {

        private FukaErrorReportItem sut;

        private RYear 賦課年度;
        private RString 通知書番号;
        private FukaError エラー内容;
        private KaigoHihokenshaNo 被保険者番号;
        private ShikibetsuCode 識別コード;
        private InternalReportShoriKubun 処理区分;

        @Before
        public void setUp() {
            賦課年度 = new RYear(2014);
            通知書番号 = new RString("12341234");
            エラー内容 = new FukaError(new Code("010"), RString.EMPTY, RString.EMPTY);
            被保険者番号 = new KaigoHihokenshaNo(new RString("0123123123"));
            識別コード = new ShikibetsuCode("012345678900001");
            処理区分 = InternalReportShoriKubun.処理無し;
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReportItem(null, 通知書番号, エラー内容, 被保険者番号, 識別コード, 処理区分);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReportItem(賦課年度, null, エラー内容, 被保険者番号, 識別コード, 処理区分);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 処理区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new FukaErrorReportItem(賦課年度, 通知書番号, エラー内容, 被保険者番号, 識別コード, null);
            fail();
        }

        @Test
        public void 必須項目に値が渡されたとき_インスタンスが生成される() {
            sut = new FukaErrorReportItem(賦課年度, 通知書番号, null, null, null, 処理区分);
            assertThat(sut, is(instanceOf(FukaErrorReportItem.class)));
        }
    }

}
