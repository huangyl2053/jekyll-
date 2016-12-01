/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2410001;

import jp.co.ndensan.reams.db.dbe.business.core.kojinirainaiyoukoshin.KojinIraiNaiyouBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.DBE2410001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.DBE2410001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.KojinIraiNaiyouKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410001.KojinIraiNaiyouKoshinHandler;
import jp.co.ndensan.reams.db.dbe.service.core.kojinirainaiyoukoshin.KojinIraiNaiyouKoshinFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)のコントローラです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public class KojinIraiNaiyouKoshin {

    /**
     * 画面初期化処理です。
     *
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> onLoad(KojinIraiNaiyouKoshinDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        KojinIraiNaiyouBusiness 今回調査情報 = KojinIraiNaiyouKoshinFinder.createInstance().getKonnkaiChousa(申請書管理番号);
        KojinIraiNaiyouBusiness 今回主治医情報 = KojinIraiNaiyouKoshinFinder.createInstance().getKonnkaiSyuji(申請書管理番号);
        KojinIraiNaiyouBusiness 前回調査情報 = KojinIraiNaiyouKoshinFinder.createInstance().getZennkaiChousa(申請書管理番号);
        KojinIraiNaiyouBusiness 前回主治医情報 = KojinIraiNaiyouKoshinFinder.createInstance().getZennkaiSyuji(申請書管理番号);
        getHandler(div).onLoad(申請書管理番号, 今回調査情報, 今回主治医情報, 前回調査情報, 前回主治医情報);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        
        RString モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if(モード != null && モード.equals(new RString("1件"))){
            return ResponseData.of(div).setState(DBE2410001StateName.初期表示_一件);
        }else{
            return ResponseData.of(div).respond();
        }
    }

    private KojinIraiNaiyouKoshinHandler getHandler(KojinIraiNaiyouKoshinDiv div) {
        return new KojinIraiNaiyouKoshinHandler(div);
    }

    /**
     * 戻るボタンを押下の場合、要介護認定申請検索へ遷移します。
     *
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> btn_Back(KojinIraiNaiyouKoshinDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE2410001TransitionEventName.検索へ戻る).respond();
    }
}
