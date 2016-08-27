/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyosakusei;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;

/**
 * ビジネス設計_DBCMN83001_受給者異動連絡票作成（画面）です
 *
 * @reamsid_L DBC-2102-020 lihang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoSakuseiRelateEntity {

    private JukyushaIdoRenrakuhyoTorokuEntity 変更前受給者訂正情報Entity;
    private JukyushaIdoRenrakuhyoTorokuEntity 変更後受給者訂正情報Entity;
    private JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity;

    /**
     * コンストラクタです。
     *
     * @param 変更前受給者訂正情報Entity 変更前受給者訂正情報Entity
     * @param 変更後受給者訂正情報Entity 変更後受給者訂正情報Entity
     * @param 出力用受給者訂正情報Entity 出力用受給者訂正情報Entity
     */
    public JukyushaIdoRenrakuhyoSakuseiRelateEntity(JukyushaIdoRenrakuhyoTorokuEntity 変更前受給者訂正情報Entity,
            JukyushaIdoRenrakuhyoTorokuEntity 変更後受給者訂正情報Entity,
            JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity) {
        this.変更前受給者訂正情報Entity = 変更前受給者訂正情報Entity;
        this.変更後受給者訂正情報Entity = 変更後受給者訂正情報Entity;
        this.出力用受給者訂正情報Entity = 出力用受給者訂正情報Entity;
    }

}
