/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラー一覧のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorInternalReportItemTest extends DbbTestBase {

    private static FukaErrorInternalReportItem sut;
    private static FukaErrorModel model;

    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static FukaError エラー内容;
    private static HihokenshaNo 被保険者番号;
    private static ShikibetsuCode 識別コード;
    private static InternalReportShoriKubun 処理区分;

    @BeforeClass
    public static void setUpBeforeClass() {
        賦課年度 = new FlexibleYear("2014");
        通知書番号 = new TsuchishoNo(new RString("12341234"));
        エラー内容 = new FukaError(new Code("010"), RString.EMPTY, RString.EMPTY);
        被保険者番号 = new HihokenshaNo(new RString("0123123123"));
        識別コード = new ShikibetsuCode("012345678900001");
        処理区分 = InternalReportShoriKubun.処理無し;

        setDefaultData();
    }

    public static class constructor extends DbbTestBase {

        @Before
        public void setUp() {
            setDefaultData();
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度にnullが渡されたとき_NullPointerExceptionが発生する() {
            model.set賦課年度(null);
            sut = new FukaErrorInternalReportItem(model);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            model.set通知書番号(null);
            sut = new FukaErrorInternalReportItem(model);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 処理区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            model.set処理区分(null);
            sut = new FukaErrorInternalReportItem(model);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void エラーコードにnullが渡されたとき_NullPointerExceptionが発生する() {
            model.setエラーコード(null);
            sut = new FukaErrorInternalReportItem(model);
            fail();
        }

        @Test
        public void 必須項目に値が渡されたとき_インスタンスが生成される() {
            model.set被保険者番号(null);
            model.set識別コード(null);
            sut = new FukaErrorInternalReportItem(model);
            assertThat(sut, is(instanceOf(FukaErrorInternalReportItem.class)));
        }
    }

    private static void setDefaultData() {
        model = new FukaErrorModel();
        model.set賦課年度(new FlexibleYear(賦課年度.toDateString()));
        model.set通知書番号(通知書番号);
        model.setエラーコード(エラー内容.getCode());
        model.set被保険者番号(被保険者番号);
        model.set識別コード(識別コード);
        model.set処理区分(処理区分);
    }
}
