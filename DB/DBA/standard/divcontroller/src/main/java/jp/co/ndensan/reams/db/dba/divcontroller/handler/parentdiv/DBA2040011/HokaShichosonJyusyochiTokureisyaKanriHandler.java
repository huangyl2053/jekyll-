/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.HokaShichosonJyusyochiTokureisyaKanriDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 他市町村住所地特例者管理のHandlerクラスです。
 *
 * @reamsid_L DBA-0400-100 yaodongsheng
 */
public class HokaShichosonJyusyochiTokureisyaKanriHandler {

    private final HokaShichosonJyusyochiTokureisyaKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他市町村住所地特例者管理Div
     */
    public HokaShichosonJyusyochiTokureisyaKanriHandler(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        this.div = div;
    }

    /**
     * 初期化です。
     *
     * @param 識別コード 識別コード
     */
    public void onLoad(ShikibetsuCode 識別コード) {
        div.getShikakuKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().initialize(識別コード);
    }
}
