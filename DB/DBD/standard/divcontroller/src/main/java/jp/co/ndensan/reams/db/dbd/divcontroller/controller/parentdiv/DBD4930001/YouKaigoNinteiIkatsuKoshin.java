/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4930001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD560001.DBD560001Parameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定一括更新画面のDivControllerです。
 *
 * @reamsid_L DBD-2120-010 x_liuwei
 */
public class YouKaigoNinteiIkatsuKoshin {

    /**
     * 画面初期化。
     *
     * @param div　YouKaigoNinteiIkatsuKoshinDiv
     * @return ResponseData<YouKaigoNinteiIkatsuKoshinDiv>
     */
    public ResponseData<YouKaigoNinteiIkatsuKoshinDiv> onLoad(YouKaigoNinteiIkatsuKoshinDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択する時の処理です。
     *
     * @param div　YouKaigoNinteiIkatsuKoshinDiv
     * @return ResponseData<YouKaigoNinteiIkatsuKoshinDiv>
     */
    public ResponseData<YouKaigoNinteiIkatsuKoshinDiv> onChange(YouKaigoNinteiIkatsuKoshinDiv div) {
        getHandler(div).changeTxtNinTeiBi();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定日チェック。
     *
     * @param div　YouKaigoNinteiIkatsuKoshinDiv
     * @return ResponseData<YouKaigoNinteiIkatsuKoshinDiv>
     */
    public ResponseData<YouKaigoNinteiIkatsuKoshinDiv> onClickCheck(YouKaigoNinteiIkatsuKoshinDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (!div.getTxtNinteibi().isDisabled()) {
            getValidationHandler(div).validateFor認定日(pairs);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを呼び出す。
     *
     * @param div　YouKaigoNinteiIkatsuKoshinDiv
     * @return ResponseData<DBD560001Parameter>
     */
    public ResponseData<DBD560001Parameter> onClickNext(YouKaigoNinteiIkatsuKoshinDiv div) {

        DBD560001Parameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private YouKaigoNinteiIkatsuKoshinHandler getHandler(YouKaigoNinteiIkatsuKoshinDiv div) {
        return new YouKaigoNinteiIkatsuKoshinHandler(div);
    }

    private YouKaigoNinteiIkatsuKoshinValidationHandler getValidationHandler(YouKaigoNinteiIkatsuKoshinDiv div) {
        return new YouKaigoNinteiIkatsuKoshinValidationHandler(div);
    }
}
