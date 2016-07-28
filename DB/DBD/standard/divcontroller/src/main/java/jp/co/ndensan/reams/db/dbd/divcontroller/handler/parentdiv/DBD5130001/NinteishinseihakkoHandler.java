/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5130001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.NinteishinseihakkoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請書発行ハンドラクラスです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class NinteishinseihakkoHandler {

    private final NinteishinseihakkoDiv div;
    private static final RString 市町村コード = new RString("123456");
    private static final RString 識別コード = new RString("000000000000010");
    private static final RString HDN_SETAI_KODO = new RString("1234567");
    private static final RString 被保険者番号 = new RString("0000000001");
    private static final RString コード = new RString("1");

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
        // ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        // TODO
        //IKaigoNinteiAtenaInfoDivの共通方法に問題があります、QAを提出しました、KaigoDonyuKeitaiとShoriTypeを固定に設定
        // RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().getKey();
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(識別コード);
        div.getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(コード);
        div.getCcdKaigoNinteiAtenaInfo().setShoriType(コード);
        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        div.getCcdKaigoninteiShikakuInfo().initialize(市町村コード, 識別コード, HDN_SETAI_KODO, 被保険者番号);
    }
}
