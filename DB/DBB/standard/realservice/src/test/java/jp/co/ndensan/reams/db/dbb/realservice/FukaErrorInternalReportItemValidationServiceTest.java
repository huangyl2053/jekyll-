/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportValidationMessage;
import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 賦課エラー一覧のデータに対するValidetionを提供するサービスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorInternalReportItemValidationServiceTest extends DbbTestBase {

    private static FukaErrorInternalReportItemValidationService sut;

    public static class validate extends DbbTestBase {

        FlexibleYear fukaNendo = new FlexibleYear("1999");
        TsuchishoNo tsuchishoNo = new TsuchishoNo(new RString("0123"));

        @Before
        public void setUp() {
            sut = new FukaErrorInternalReportItemValidationService(createItem(fukaNendo, tsuchishoNo, InternalReportShoriKubun.未処理),
                    createService(fukaNendo, tsuchishoNo, InternalReportShoriKubun.処理中));
        }

        @Test
        public void 最新の処理区分が未処理以外である場合_更正対象が未処理状態でないことを示すメッセージを_戻り値が保持している() {
            IValidationMessages result = sut.validate();
            assertThat(result.contains(InternalReportValidationMessage.更正対象が未処理状態ではないため実行不可), is(true));
        }

    }

    private static FukaErrorInternalReportItem createItem(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo, InternalReportShoriKubun kubun) {
        FukaErrorModel model = new FukaErrorModel();
        model.set賦課年度(fukaNendo);
        model.set通知書番号(tsuchishoNo);
        model.set処理区分(kubun);
        return new FukaErrorInternalReportItem(model);
    }

    private static FukaErrorInternalReportService createService(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo, InternalReportShoriKubun kubun) {
        FukaErrorInternalReportService service = mock(FukaErrorInternalReportService.class);
        when(service.getFukaErrorInternalReportItem(fukaNendo, tsuchishoNo))
                .thenReturn(createItem(fukaNendo, tsuchishoNo, kubun));
        return service;
    }

}
