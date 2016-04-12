/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseiRenrakusakiJoho;

import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定申請連絡先情報のクラスです。
 *
 * @reamsid_L DBE-1300-100 dongyabin
 */
public class NinteiShinseiRenrakusakiJoho {
    
    private static final RString IMPUTMODE = new RString("ImputMode");

    /**
     * 認定申請連絡先情報の初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> intialize(NinteiShinseiRenrakusakiJohoDiv div) {
        getHandler(div).setClear();
        getHandler(div).onLoad();
        NinteiShinseiBusinessCollection deta = DataPassingConverter.deserialize(div.
                getNinteiShinseiBusinessCollection(), NinteiShinseiBusinessCollection.class);
        getHandler(div).setRenrakusaki(deta.getDbdBusiness());
        return ResponseData.of(div).respond();
    }
    
    /**
     * 選択行を複写して追加するボタンを押します。
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClilck_btnFukushaTsuika(NinteiShinseiRenrakusakiJohoDiv div) {
        if (div.getDgRenrakusakiIchiran().getClickedItem() == null) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 新規追加するボタンを押します。
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> onClilck_btnShinkiTsuika(NinteiShinseiRenrakusakiJohoDiv div) {
        div.setHdnShoriType(IMPUTMODE);
        getHandler(div).set連絡先入力の各項目をクリア();
        return ResponseData.of(div).respond();
    }
    

    private NinteiShinseiRenrakusakiJohoHandler getHandler(NinteiShinseiRenrakusakiJohoDiv div) {
        return new NinteiShinseiRenrakusakiJohoHandler(div);
    }
}
