/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.YokaigodoGuideCommonChildDiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide.YokaigodoGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide.dgYokaigodoGuide_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.yokaigodoguide.YokaigodoGuideHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護度ガイドのクラス。
 *
 * @reamsid_L DBZ-4540-010 lizhuoxuan
 */
public class YokaigodoGuide {

    /**
     * 要介護度ガイド一覧。<br/>
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ResponseData<YokaigodoGuideDiv>
     */
    public ResponseData<YokaigodoGuideDiv> onLoad(YokaigodoGuideDiv godoDiv) {
        if (RString.isNullOrEmpty(godoDiv.getKijunYMD())) {
            godoDiv.setKijunYMD(new RString(FlexibleDate.getNowDate().toString()));
        }
        FlexibleYearMonth kizyuniti = RString.isNullOrEmpty(godoDiv.getKijunYMD()) ? FlexibleYearMonth.EMPTY : new FlexibleDate(godoDiv.getKijunYMD()).getYearMonth();
        if (FlexibleYearMonth.EMPTY.equals(kizyuniti) || kizyuniti.isBefore(new FlexibleYearMonth("200003"))) {
            ValidationMessageControlPairs validationMessages = createHandlerOf(godoDiv).check_btnKakuninn(godoDiv);
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(godoDiv).addValidationMessages(validationMessages).respond();
            }
        }
        createHandlerOf(godoDiv).initialize();
        return ResponseData.of(godoDiv).respond();
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ResponseData<YokaigodoGuideDiv>
     */
    public ResponseData<YokaigodoGuideDiv> onSelect_Yokaigodo(YokaigodoGuideDiv godoDiv) {
        dgYokaigodoGuide_Row dgYokaigodoGuideRow = godoDiv.getDgYokaigodoGuide().getSelectedItems().get(0);
        godoDiv.setCode(dgYokaigodoGuideRow.getCode());
        godoDiv.setMeisho(dgYokaigodoGuideRow.getMeisho());
        return ResponseData.of(godoDiv).respond();
    }

    /**
     * 「戻る」ボタン。<br/>
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ResponseData<YokaigodoGuideDiv>
     */
    public ResponseData<YokaigodoGuideDiv> onClick_btnModoru(YokaigodoGuideDiv godoDiv) {
        return ResponseData.of(godoDiv).respond();
    }

    private YokaigodoGuideHandler createHandlerOf(YokaigodoGuideDiv godoDiv) {
        return new YokaigodoGuideHandler(godoDiv);
    }

}
