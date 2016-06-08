/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.Test;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.Test.TestBunshoBangoInput.TestBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * テスト文書番号入力Divの画面イベントを記述するクラスです。
 */
public class TestBunshoBangoInput {

    /**
     * initialize基準日無しボタンクリック時のイベント
     *
     * @param div div
     * @return ResponseData<TestBunshoBangoInputDiv>
     */
    public ResponseData<TestBunshoBangoInputDiv> onClick_BtnIntializeKijunbiNashi(TestBunshoBangoInputDiv div) {

        ReportId reportId = new ReportId(div.getTxtChohyoId().getValue());
        div.getCcdBunshoBangoInput().initialize(reportId);

        return ResponseData.of(div).respond();
    }

    /**
     * initialize基準日有りボタンクリック時のイベント
     *
     * @param div div
     * @return ResponseData<TestBunshoBangoInputDiv>
     */
    public ResponseData<TestBunshoBangoInputDiv> onClick_BtnIntializeKijunbiAri(TestBunshoBangoInputDiv div) {

        ReportId reportId = new ReportId(div.getTxtChohyoId().getValue());
        FlexibleDate date = div.getTxtKijunbi().getValue();
        div.getCcdBunshoBangoInput().initialize(reportId, date);

        return ResponseData.of(div).respond();
    }

    /**
     * get文書番号ボタンクリック時のイベント
     *
     * @param div div
     * @return ResponseData<TestBunshoBangoInputDiv>
     */
    public ResponseData<TestBunshoBangoInputDiv> onClick_BthGetBunshoNo(TestBunshoBangoInputDiv div) {

        RString bunsho = div.getCcdBunshoBangoInput().get文書番号();
        div.getTxtBunshoNo().setValue(bunsho);

        return ResponseData.of(div).respond();
    }

}
