/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiKaisaiKekkaJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -2256749691228526367L;
    private final RString 介護認定審査会開催番号;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiKekkaJohoIdentifier(RString 介護認定審査会開催番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
    }

}
