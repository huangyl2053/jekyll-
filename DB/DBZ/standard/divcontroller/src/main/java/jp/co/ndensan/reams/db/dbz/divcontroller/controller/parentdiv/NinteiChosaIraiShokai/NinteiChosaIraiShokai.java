/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.NinteiChosaIraiShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiChosaIraiShokai.NinteiChosaIraiShokaiHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai.NinteiChosaIraiShokaiManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査依頼照会のダイアログのDivControllerです
 */
public class NinteiChosaIraiShokai {

    private static final RString 被保険者番号 = new RString("2016");

    /**
     *
     * @param div
     * @return
     */
    public ResponseData<NinteiChosaIraiShokaiDiv> load(NinteiChosaIraiShokaiDiv div) {
        List<NinteiChosaIraiShokaiMaster> ninteiChosaList
                = NinteiChosaIraiShokaiManager.createInstance().getNinteiChousaJouhou(被保険者番号).records();
        getHandler(div).load(ninteiChosaList);
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIraiShokaiHandler getHandler(NinteiChosaIraiShokaiDiv div) {
        return new NinteiChosaIraiShokaiHandler(div);
    }
}
