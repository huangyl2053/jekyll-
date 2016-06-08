/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ZenkaiNinteiKekkaJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 前回結果情報の画面Controllerクラスです。
 * @reamsid_L DBE-3000-020 dongyabin
 */
public class ZenkaiNinteiKekkaJoho {
    
    /**
     * 「前回の認定内容を照会する」ボタンを押します。
     * @param div 画面情報
     * @return ResponseData<ZenkaiNinteiKekkaJohoDiv>
     */
    public ResponseData<ZenkaiNinteiKekkaJohoDiv> onBefore_Dialog(ZenkaiNinteiKekkaJohoDiv div) {
        RString zenkaiShinseishoKanriNo = RString.EMPTY;
        if (SubGyomuCode.DBD介護受給.getColumnValue().equals(div.getHdnDatabaseSubGyomuCode())) {
            zenkaiShinseishoKanriNo = getService().get前回申請管理番号_受給(ShinseishoKanriNo.EMPTY);
        } else if (SubGyomuCode.DBE認定支援.getColumnValue().equals(div.getHdnDatabaseSubGyomuCode())) {
            zenkaiShinseishoKanriNo = getService().get前回申請管理番号_認定(ShinseishoKanriNo.EMPTY);
        }
        div.setHdnZenkaiShinseishoKanriNo(zenkaiShinseishoKanriNo);
        return ResponseData.of(div).respond();
    }
    
    private ZenkaiNinteiKekkaJohoFinder getService() {
        return ZenkaiNinteiKekkaJohoFinder.createInstance();
    }
    
}
