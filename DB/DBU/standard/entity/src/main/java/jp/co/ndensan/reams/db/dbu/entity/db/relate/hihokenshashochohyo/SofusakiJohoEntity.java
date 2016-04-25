/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付先情報Entityリストです。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SofusakiJohoEntity {

    /**
     * 識別コード。
     */
    private ShikibetsuCode shikibetsuCode;

    /**
     * 宛先種別。
     */
    private RString atesakiShubetsu;

    /**
     * 管内管外区分。
     */
    private RString kannaiKangaiKubun;

    /**
     * 住所。
     */
    private RString jusho;

    /**
     * 番地。
     */
    private RString banchi;

    /**
     * 方書。
     */
    private RString katagaki;
}
