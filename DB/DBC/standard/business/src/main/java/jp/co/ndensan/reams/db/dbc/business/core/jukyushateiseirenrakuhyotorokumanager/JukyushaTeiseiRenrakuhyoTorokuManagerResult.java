/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokumanager;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（画面）
 *
 * @reamsid_L DBC-2101-030 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoTorokuManagerResult {

    private RString メッセージコード;
    private int 登録件数;

}
