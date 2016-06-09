/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiKaisaiKekkaJoho2Identifier implements Serializable {

    private static final long serialVersionUID = -2256749691228526367L;
    private final RString 介護認定審査会開催番号;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiKekkaJoho2Identifier(RString 介護認定審査会開催番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
    }

}
