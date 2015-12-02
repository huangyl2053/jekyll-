/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiKaisaiYoteiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -7771312999194130485L;
    private final RString 介護認定審査会開催番号;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiYoteiJohoIdentifier(RString 介護認定審査会開催番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
    }

}
