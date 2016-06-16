/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021.TajutokuIdoTeiseiDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 他市町村住所地特例者異動の訂正の抽象Handlerクラスです。
 *
 * @reamsid_L DBA-0401-030 duanzhanli
 */
public class TajutokuIdoTeiseiHandler {

    private final TajutokuIdoTeiseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他市町村住所地特例者異動の訂正Div
     */
    public TajutokuIdoTeiseiHandler(TajutokuIdoTeiseiDiv div) {
        this.div = div;
    }

    /**
     *
     * 他市町村住所地特例者異動の訂正初期化の設定します。
     *
     * @param 識別コード 識別コード
     */
    public void load(ShikibetsuCode 識別コード) {
        div.getTajutokuIdoTeiseiKihonJoho().getCcdKaigoAtenaJoho().initialize(識別コード);
        div.getTajutokuIdoTeiseiIdoJoho().getCcdTaJushochiTokureishaKanri().initialize(識別コード);
        div.getTajutokuIdoTeiseiIdoJoho().getShisetsuIdoJoho().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
    }
}
