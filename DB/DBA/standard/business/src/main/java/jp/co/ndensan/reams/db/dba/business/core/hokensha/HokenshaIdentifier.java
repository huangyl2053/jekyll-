/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokensha;

import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;

/**
 *
 * 保険者情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class HokenshaIdentifier {

    private final HokenjaShubetsu hokenjaShubetsu;
    private final HokenjaNo hokenjaNo;

    /**
     * コンストラクタです。
     *
     * @param hokenjaShubetsu 保険者種別
     * @param hokenjaNo 保険者番号
     */
    public HokenshaIdentifier(HokenjaShubetsu hokenjaShubetsu, HokenjaNo hokenjaNo) {
        this.hokenjaShubetsu = hokenjaShubetsu;
        this.hokenjaNo = hokenjaNo;
    }
}
