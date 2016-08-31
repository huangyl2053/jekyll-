/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB3140001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB314001.DBB314001_GemmenParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.IkkatsuGenmenDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.IkkatsuGenmenHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.IkkatsuGenmenValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class IkkatsuGenmen {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div IkkatsuGenmenDiv
     * @return ResponseData
     */
    public ResponseData<IkkatsuGenmenDiv> onLoad(IkkatsuGenmenDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div IkkatsuGenmenDiv
     * @return ResponseData
     */
    public ResponseData<IkkatsuGenmenDiv> onBeforeOpenCheck(IkkatsuGenmenDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor決定日が未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<DBB314001_GemmenParameter> onClick_IkkatsuGenmen(IkkatsuGenmenDiv div) {

        DBB314001_GemmenParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBB314001_GemmenParameter setBatchParameter(IkkatsuGenmenDiv div) {

        DBB314001_GemmenParameter parameter = new DBB314001_GemmenParameter();
        parameter.setChoteiNendo(new FlexibleYear(div.getTxtChoteiNendo().getValue().toString()));
        parameter.setFukaNendo(new FlexibleYear(div.getTxtFukaNendo().getValue().toString()));
        //TODO
        parameter.setShinseiYMD(new FlexibleDate(div.getTxtShinseiYMD().getValue().toString()));
        parameter.setGemmenJiyuCode(new Code(div.getTxtGemmenShurui().getValue()));
        parameter.setShinseiJiyu(div.getTxtShinseiRiyu().getValue());
        parameter.setKetteiYMD(div.getTxtKetteiYMD().getValue());
        parameter.setGemmenJiyu(div.getTxtKetteiRiyu().getValue());
        return parameter;
    }

    private IkkatsuGenmenHandler getHandler(IkkatsuGenmenDiv div) {
        return new IkkatsuGenmenHandler(div);
    }

    private IkkatsuGenmenValidationHandler getValidationHandler(IkkatsuGenmenDiv div) {
        return new IkkatsuGenmenValidationHandler(div);
    }
}
