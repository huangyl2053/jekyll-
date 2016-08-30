/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuDiv;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のコントローラクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
public class KaigoKyufuhiKagoMositateTourokuHandler {

    private static final RString MENUID_DBCMN91001 = new RString("DBCMN91001");
    private static final RString MENUID_DBCMN91002 = new RString("DBCMN91002");
    private static final RString MENUID_DBCMN91003 = new RString("DBCMN91003");
    private final KaigoKyufuhiKagoMositateTourokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KaigoKyufuhiKagoMositateTourokuHandler(KaigoKyufuhiKagoMositateTourokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     */
    public void onLoad() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (MENUID_DBCMN91001.equals(menuID)) {
            div.setHdnKyuufuKubunn(new RString("1"));
        } else if (MENUID_DBCMN91002.equals(menuID)) {
            div.setHdnKyuufuKubunn(new RString("2"));
        } else if (MENUID_DBCMN91003.equals(menuID)) {
            div.setHdnKyuufuKubunn(new RString("3"));
        }
        div.setHdnKensaku(new RString("FLASE"));
    }

}
