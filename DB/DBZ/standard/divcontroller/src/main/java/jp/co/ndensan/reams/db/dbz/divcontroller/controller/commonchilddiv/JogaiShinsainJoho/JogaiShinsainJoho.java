/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.JogaiShinsainJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinRelateJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.JogaiShinsainJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.JogaiShinsainJoho.JogaiShinsainJohoHandler;
import jp.co.ndensan.reams.db.dbz.service.core.jogaishinsainjoho.JogaiShinsainJohoFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外審査員情報の画面処理クラスです。
 *
 * @reamsid_L DBE-1300-040 dongyabin
 */
public class JogaiShinsainJoho {

    /**
     * 画面項目の初期化を行します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onLoad(JogaiShinsainJohoDiv div) {
        getHandler(div).画面項目にセットされている値をクリア();
        return ResponseData.of(div).respond();
    }

    private void set画面情報(JogaiShinsainJohoDiv div) {
        RString 申請書管理番号 = div.getHdnShinseishoKanriNo();
        List<ShinsakaiIinRelateJoho> johoList = getService().get審査会委員一覧検索して審査会委員情報(申請書管理番号).records();
        List<dgShinsakaiIinIchiran_Row> rowList = new ArrayList();
        for (ShinsakaiIinRelateJoho joho : johoList) {
            rowList.add(new dgShinsakaiIinIchiran_Row(joho.get介護認定審査会委員コード(), 申請書管理番号, 申請書管理番号));
        }
    }

    private JogaiShinsainJohoHandler getHandler(JogaiShinsainJohoDiv div) {
        return new JogaiShinsainJohoHandler(div);
    }

    private JogaiShinsainJohoFinder getService() {
        return JogaiShinsainJohoFinder.createInstance();
    }

}
