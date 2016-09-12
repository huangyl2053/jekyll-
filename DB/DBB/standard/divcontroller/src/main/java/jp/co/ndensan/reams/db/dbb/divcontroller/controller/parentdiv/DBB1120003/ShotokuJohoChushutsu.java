/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1120003;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003.ShotokuJohoChushutsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120003.ShotokuJohoChushutsuHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120003.ShotokuJohoChushutsuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShotokuJohoChushutsu {

    private static final RString 定値_他社 = new RString("3");
    private static final RString 定値_REAMS = new RString("1");

    /**
     * onLoad処理です。
     *
     * @param div ShotokuJohoChushutsuDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJohoChushutsuDiv> onLoad(ShotokuJohoChushutsuDiv div) {
        getHandler(div).initialize(div);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnSelectメソッドです。
     *
     * @param div ShotokuJohoChushutsuDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJohoChushutsuDiv> onClick_btnSelect(ShotokuJohoChushutsuDiv div) {
        RDate nowDate = RDate.getNowDate();
        RString 所得引出方法 = DbBusinessConfig.get(ConfigNameDBB.所得引出_所得引出方法, nowDate, SubGyomuCode.DBB介護賦課);
        if (定値_他社.equals(所得引出方法)) {
            div.getBtnUpload().setDisabled(false);
        } else if (定値_REAMS.equals(所得引出方法)) {
            div.getBtnUpload().setDisabled(true);
        }
        div.getUploadPanel().setDisplayNone(false);
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードButtonaを押します.
     *
     * @param div ShotokuJohoChushutsuDiv
     * @param files FileData[]
     * @return ResponseData<ShotokuJohoChushutsuDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShotokuJohoChushutsuDiv> onClick_btnUpload(ShotokuJohoChushutsuDiv div, FileData[] files) {
        ValidationMessageControlPairs validPairs = getValidationHandler().ファイルチェック(files);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).upLoad(files);
        return ResponseData.of(div).respond();
    }

    private ShotokuJohoChushutsuHandler getHandler(ShotokuJohoChushutsuDiv div) {
        return new ShotokuJohoChushutsuHandler(div);
    }

    private ShotokuJohoChushutsuValidationHandler getValidationHandler() {
        return new ShotokuJohoChushutsuValidationHandler();
    }
}
