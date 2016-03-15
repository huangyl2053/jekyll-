/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseiRenrakusakiJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinseirenrakusakijoho.NinteiShinseiRenrakusakiJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 認定申請連絡先情報のクラスです。
 */
public class NinteiShinseiRenrakusakiJoho {
    
    private final NinteiShinseiRenrakusakiJohoFinder service;
    
    /**
     * コンストラクタです。
     */
    public NinteiShinseiRenrakusakiJoho() {
        service = NinteiShinseiRenrakusakiJohoFinder.createInstance();
    }
    
    /**
     * 認定申請連絡先情報の初期化処理です。
     * @param div 画面情報
     * @return ResponseData<NinteiShinseiRenrakusakiJohoDiv>
     */
    public ResponseData<NinteiShinseiRenrakusakiJohoDiv> intialize(NinteiShinseiRenrakusakiJohoDiv div) {
        // TODO QA #78455 支所管理判定不明です、支所情報の取得不明です。
        getHandler(div).setClear();
        NinteiShinseiBusinessCollection collection = DataPassingConverter.deserialize(div.getNinteiShinseiBusinessCollection(),
                NinteiShinseiBusinessCollection.class);
        if (SubGyomuCode.DBE認定支援.equals(collection.getHdnDatabaseSubGyomuCode())) {
            List<NinteiShinseiRenrakusakiKihon> ninteiShinseiList = service
                    .getShinsakaiNinteiShinseiJoho(collection.getShinseishoKanriNo()).records();
            getHandler(div).setDBERenrakusaki(ninteiShinseiList);
            collection.setDbeBusiness(ninteiShinseiList);
        } else if (SubGyomuCode.DBD介護受給.equals(collection.getHdnDatabaseSubGyomuCode())) {
            List<RenrakusakiJoho> renrakusakiJohoList = service.getHokenshaNinteiShinseiJoho(collection.getShinseishoKanriNo()).records();
            getHandler(div).setDBDRenrakusaki(renrakusakiJohoList);
            collection.setDbdBusiness(renrakusakiJohoList);
        }
        return ResponseData.of(div).respond();
    }
    
    private NinteiShinseiRenrakusakiJohoHandler getHandler(NinteiShinseiRenrakusakiJohoDiv div) {
        return new NinteiShinseiRenrakusakiJohoHandler(div);
    }
}
