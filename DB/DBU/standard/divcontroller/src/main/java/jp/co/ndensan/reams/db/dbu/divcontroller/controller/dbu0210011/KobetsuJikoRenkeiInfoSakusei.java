/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.dbu0210011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】情報Divを制御します。
 */
public class KobetsuJikoRenkeiInfoSakusei {

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData onLoad(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        ResponseData<KobetsuJikoRenkeiInfoSakuseiDiv> response = new ResponseData<>();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnJikko"), true);

        return response;
    }
}
