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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護度ガイドのクラス。
 */
public class YokaigodoGuide {

    private final int 桁数_6 = 6;

    /**
     * 要介護度ガイド一覧。<br/>
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ResponseData<YokaigodoGuideDiv>
     */
    public ResponseData<YokaigodoGuideDiv> onLoad(YokaigodoGuideDiv godoDiv) {
        ResponseData<YokaigodoGuideDiv> responseData = new ResponseData<>();
        FlexibleDate kizyuniti = new FlexibleDate(godoDiv.getKijunYMD().substring(0, 桁数_6));
        if (kizyuniti.isBefore(new FlexibleDate("200003"))) {
            ValidationMessageControlPairs validationMessages = createHandlerOf(godoDiv).check_btnKakuninn(godoDiv);
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(godoDiv).addValidationMessages(validationMessages).respond();
            }
        }
        createHandlerOf(godoDiv).initialize();
        responseData.data = godoDiv;
        return responseData;
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
        return createResponseData(godoDiv);
    }

    /**
     * 「戻る」ボタン。<br/>
     *
     * @param godoDiv YokaigodoGuideDiv
     * @return ResponseData<YokaigodoGuideDiv>
     */
    public ResponseData<YokaigodoGuideDiv> onClick_btnModoru(YokaigodoGuideDiv godoDiv) {
        return createResponseData(godoDiv);
    }

    private YokaigodoGuideHandler createHandlerOf(YokaigodoGuideDiv godoDiv) {
        return new YokaigodoGuideHandler(godoDiv);
    }

    private ResponseData<YokaigodoGuideDiv> createResponseData(YokaigodoGuideDiv godoDiv) {
        ResponseData<YokaigodoGuideDiv> response = new ResponseData();
        response.data = godoDiv;
        return response;
    }

}
