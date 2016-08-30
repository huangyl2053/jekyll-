/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1500011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のコントローラクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
public class KaigoKyufuhiKagoMositateTouroku {

    private static final RString MENUID_DBCMN91001 = new RString("DBCMN91001");
    private static final RString MENUID_DBCMN91002 = new RString("DBCMN91002");
    private static final RString MENUID_DBCMN91003 = new RString("DBCMN91003");

    /**
     * 画面初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoKyufuhiKagoMositateTouroku>
     */
    public ResponseData<KaigoKyufuhiKagoMositateTourokuDiv> onLoad(KaigoKyufuhiKagoMositateTourokuDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString loginUserId = controlData.getLoginInfo().getUserId();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務, loginUserId);
        if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
            div.getHokenshalist().setVisible(true);
            div.getHokenshalist().loadHokenshaList(GyomuBunrui.介護事務);
        }
        getHandler(div).onLoad();

        return ResponseData.of(div).respond();
    }

    private void get給付実績一覧(KaigoKyufuhiKagoMositateTourokuDiv div) {
        if (new RString("TRUE").equals(div.getHdnKensaku())) {
            div.getTxtTeikyoYMRange().getFromValue();
            div.getHokenshalist().getSelectedItem().get市町村コード();
        }
    }

    private KaigoKyufuhiKagoMositateTourokuHandler getHandler(KaigoKyufuhiKagoMositateTourokuDiv div) {
        return new KaigoKyufuhiKagoMositateTourokuHandler(div);
    }
}
