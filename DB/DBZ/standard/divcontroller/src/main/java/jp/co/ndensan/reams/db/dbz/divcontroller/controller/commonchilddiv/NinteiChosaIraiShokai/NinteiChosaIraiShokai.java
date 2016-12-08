/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaIraiShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokai.NinteiChosaIraiShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.NinteiChosaIraiShokai.NinteiChosaIraiShokaiHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai.NinteiChosaIraiShokaiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査依頼照会のダイアログのDivControllerです
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public class NinteiChosaIraiShokai {

    /**
     * 認定調査依頼照会の初期化処理ください。
     *
     * @param div NinteiChosaIraiShokaiDiv
     * @return 認定調査情報div
     */
    public ResponseData<NinteiChosaIraiShokaiDiv> onLoad(NinteiChosaIraiShokaiDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 証記載保険者番号 = RString.EMPTY;
        RString 市町村コード = RString.EMPTY;
        ShichosonSecurityJohoFinder finder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村セキュリティ情報 != null) {
            if (!市町村セキュリティ情報.get市町村情報().get市町村識別ID().equals(new ShichosonShikibetsuID("00"))) {
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード().value();
            }
            証記載保険者番号 = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号().value();
        }
        List<NinteiChosaIraiShokaiMaster> ninteiChosaList
                = NinteiChosaIraiShokaiFinder.createInstance().getNinteiChousaJouhou(被保険者番号.value()).records();
        if (ninteiChosaList != null && !RString.isNullOrEmpty(証記載保険者番号)) {
            List<NinteiChosaIraiShokaiMaster> ninteiChosaListCopy = new ArrayList<>(ninteiChosaList);
            ninteiChosaList = get対象証記載保険者認定調査List(ninteiChosaListCopy, 証記載保険者番号);
            if (!RString.isNullOrEmpty(市町村コード)) {
                List<NinteiChosaIraiShokaiMaster> ninteiChosaListCopy2 = new ArrayList<>(ninteiChosaList);
                ninteiChosaList = get対象市町村認定調査List(ninteiChosaListCopy2, 市町村コード);
            }
        }
        getHandler(div).onLoad(ninteiChosaList, 被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンを押下する場合、元画面へ遷移する。
     *
     * @param div NinteiChosaIraiShokaiDiv
     * @return 認定調査情報div
     */
    public ResponseData<NinteiChosaIraiShokaiDiv> onClick_btnClose(NinteiChosaIraiShokaiDiv div) {
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIraiShokaiHandler getHandler(NinteiChosaIraiShokaiDiv div) {
        return new NinteiChosaIraiShokaiHandler(div);
    }

    private List<NinteiChosaIraiShokaiMaster> get対象証記載保険者認定調査List(List<NinteiChosaIraiShokaiMaster> 認定調査List, RString 証記載保険者番号) {
        List<NinteiChosaIraiShokaiMaster> 対象認定調査List = new ArrayList<>();
        for (NinteiChosaIraiShokaiMaster 認定調査Entity : 認定調査List) {
            if (証記載保険者番号.equals(認定調査Entity.getShoKisaiHokenshaNo())) {
                対象認定調査List.add(認定調査Entity);
            }
        }
        return 対象認定調査List;
    }
    
    private List<NinteiChosaIraiShokaiMaster> get対象市町村認定調査List(List<NinteiChosaIraiShokaiMaster> 認定調査List, RString 市町村コード) {
        List<NinteiChosaIraiShokaiMaster> 対象認定調査List = new ArrayList<>();
        for (NinteiChosaIraiShokaiMaster 認定調査Entity : 認定調査List) {
            if (市町村コード.substring(0, 5).equals(認定調査Entity.getShinseishoKanriNo().value().substring(0, 5))) {
                対象認定調査List.add(認定調査Entity);
            }
        }
        return 対象認定調査List;
    }
}
