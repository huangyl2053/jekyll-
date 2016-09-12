/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.taishoshakensaku;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）（画面）
 *
 * @reamsid_L DBC-2101-040 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaKensakuResult {

    private JukyushaIdoRenrakuhyo 対象者一覧情報Entity;

}
