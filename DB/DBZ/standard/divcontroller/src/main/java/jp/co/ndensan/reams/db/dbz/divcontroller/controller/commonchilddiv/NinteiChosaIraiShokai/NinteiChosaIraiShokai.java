/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaIraiShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiChosaIraiShokai.NinteiChosaIraiShokaiHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai.NinteiChosaIraiShokaiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 認定調査依頼照会のダイアログのDivControllerです
 */
public class NinteiChosaIraiShokai {

    /**
     * 認定調査依頼照会の初期化処理ください。
     *
     * @param div NinteiChosaIraiShokaiDiv
     * @return 認定調査情報div
     */
    public ResponseData<NinteiChosaIraiShokaiDiv> load(NinteiChosaIraiShokaiDiv div) {

        RString 被保険者番号 = new RString((ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class)).toString());
        List<NinteiChosaIraiShokaiMaster> ninteiChosaList
                = NinteiChosaIraiShokaiFinder.createInstance().getNinteiChousaJouhou(被保険者番号).records();
        getHandler(div).load(ninteiChosaList);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンを押下する場合、元画面へ遷移する。
     */
    // TODO 閉じるbtn 原画面がない。
//    public ResponseData<NinteiChosaIraiShokaiDiv> onClick_btnClose(NinteiChosaIraiShokaiDiv div) {
//
//        return ResponseData.of(div).respond();
//    }
    private NinteiChosaIraiShokaiHandler getHandler(NinteiChosaIraiShokaiDiv div) {
        return new NinteiChosaIraiShokaiHandler(div);
    }
}
