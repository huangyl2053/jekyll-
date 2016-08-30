/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2050011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiDiv.DisplayMode;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.TekiyoJogaiTotalDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外者管理のハンドラークラスです。
 *
 * @reamsid_L DBA-0410-080 dingyi
 */
public class TekiyoJogaiTotalHandler {

    private final TekiyoJogaiTotalDiv div;
    private static final RString 遷移元メニューID_適用 = new RString("DBAMN32001");
    private static final RString 遷移元メニューID_解除 = new RString("DBAMN32002");
    private static final RString 遷移元メニューID_変更 = new RString("DBAMN32003");

    /**
     * コンストラクタです。
     *
     * @param div 適用除外者管理Div
     */
    public TekiyoJogaiTotalHandler(TekiyoJogaiTotalDiv div) {
        this.div = div;
    }

    /**
     * 適用除外者管理に初期化を設定します。
     *
     * @param 識別コード 識別コード
     * @param 遷移元メニューID 遷移元メニューID
     */
    public void initialize(ShikibetsuCode 識別コード, RString 遷移元メニューID) {
        div.getShikakuKihonJoho().getCcdAtenaJoho().initialize(識別コード);
        if (遷移元メニューID_適用.equals(遷移元メニューID)) {
//            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().set状態(new RString(DisplayMode.適用登録モード.toString()));
            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().setDiplayMode(DisplayMode.適用登録モード);
        } else if (遷移元メニューID_解除.equals(遷移元メニューID)) {
//            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().set状態(new RString(DisplayMode.解除モード.toString()));
            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().setDiplayMode(DisplayMode.解除モード);
        } else if (遷移元メニューID_変更.equals(遷移元メニューID)) {
//            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().set状態(new RString(DisplayMode.照会モード.toString()));
            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().setDiplayMode(DisplayMode.照会モード);
        }
        div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().initialize(識別コード);
        div.getTekiyoJogaiJohoIchiran().getCddShisetsuNyutaishoRirekiKanri().initialize(識別コード, DaichoType.適用除外者.getコード());
    }

}
