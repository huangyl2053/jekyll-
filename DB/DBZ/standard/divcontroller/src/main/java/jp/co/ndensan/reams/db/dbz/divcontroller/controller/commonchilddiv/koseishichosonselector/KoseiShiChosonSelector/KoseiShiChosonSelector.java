/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichosonselector.KoseiShiChosonSelectorParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector.KoseiShiChosonSelectorDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.koseishichosonselector.KoseiShiChosonSelectorHandler;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.koseishichosonselector.KoseiShiChosonSelectorFinder;
import jp.co.ndensan.reams.db.dbz.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * 構成市町村選択のクラスです。
 * @reamsid_L DBE-3000-060 dongyabin
 */
public class KoseiShiChosonSelector {
    
    private final KoseiShiChosonSelectorFinder service;
    
    /**
     * コンストラクタです。
     */
    public KoseiShiChosonSelector() {
        service = KoseiShiChosonSelectorFinder.createInstance();
    }
    
    /**
     * 画面初期化処理です。
     * @param div 画面情報
     * @return ResponseData<KoseiShiChosonSelectorDiv>
     */
    public ResponseData<KoseiShiChosonSelectorDiv> onLoad(KoseiShiChosonSelectorDiv div) {
        KoseiShiChosonSelectorParamter param = KoseiShiChosonSelectorParamter.createParam();
        List<KoseiShichoson> koseiShichosonList = service.getKoseiShichoson(param).records();
        List<HokenshaSummary> hokenshaList = new ArrayList<>(
                HokenshaListLoader.createInstance()
                .getShichosonCodeNameList(GyomuBunrui.介護認定)
                .getAll()
        );
        if (koseiShichosonList.isEmpty()) {
            return ResponseData.of(div).addValidationMessages(getHandler(div).getMessage()).respond();
        }
        getHandler(div).onLoad(hokenshaList);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 構成市町村一覧データを選択の処理です。
     * @param div 画面情報
     * @return ResponseData<KoseiShiChosonSelectorDiv>
     */
    public ResponseData<KoseiShiChosonSelectorDiv> onClick_Kensaku(KoseiShiChosonSelectorDiv div) {
        if (div.getDgKoseiShichosonList().getClickedItem() != null) {
            getHandler(div).onClick_Kensaku();
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 戻るボタンを押下します。
     * @param div 画面情報
     * @return ResponseData<KoseiShiChosonSelectorDiv>
     */
    public ResponseData<KoseiShiChosonSelectorDiv> onClick_Moderu(KoseiShiChosonSelectorDiv div) {
        return ResponseData.of(div).respond();
    }
    
    private KoseiShiChosonSelectorHandler getHandler(KoseiShiChosonSelectorDiv div) {
        return new KoseiShiChosonSelectorHandler(div);
    }
}
