/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5130001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.NinteishinseihakkoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請書発行ハンドラクラスです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class NinteishinseihakkoHandler {

    private final NinteishinseihakkoDiv div;
    private static final RString 識別コード = new RString("000000001011002");
    private static final RString 被保険者番号 = new RString("2190000003");
    private static final RString コード = new RString("3");
    private static final RString コード111 = new RString("111");
    private static final RString コード112 = new RString("112");
    private static final RString コード120 = new RString("120");
    private static final RString コード211 = new RString("211");
    private static final RString 単一市町村 = new RString("1");
    private static final RString 広域市町村 = new RString("2");
    private static final RString 広域保険者 = new RString("3");
    private static final RString 広域審査会 = new RString("4");

    /**
     * コンストラクタです。
     *
     * @param div NinteishinseihakkoDiv
     */
    public NinteishinseihakkoHandler(NinteishinseihakkoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     */
    public void initialize() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().value();
        if (介護導入形態.equals(コード111)) {
            介護導入形態 = 広域保険者;
        }
        if (介護導入形態.equals(コード112)) {
            介護導入形態 = 広域市町村;
        }
        if (介護導入形態.equals(コード120)) {
            介護導入形態 = 単一市町村;
        }
        if (介護導入形態.equals(コード211)) {
            介護導入形態 = 広域審査会;
        }
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(識別コード);
        div.getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        div.getCcdKaigoninteiShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().code市町村RString(),
                RString.EMPTY, RString.EMPTY, 被保険者番号);
    }
}
