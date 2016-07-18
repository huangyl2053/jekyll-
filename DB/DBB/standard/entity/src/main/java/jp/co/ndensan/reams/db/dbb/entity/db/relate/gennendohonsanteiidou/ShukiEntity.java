/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 住基抽出一時Entityクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShukiEntity implements IDbAccessable {

    private ShikibetsuCode shikibetsuCode;
}
