/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催場所情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiKaisaiBashoJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -4298610896060671314L;
    private final RString 介護認定審査会開催場所コード;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     */
    public ShinsakaiKaisaiBashoJohoIdentifier(RString 介護認定審査会開催場所コード) {
        this.介護認定審査会開催場所コード = 介護認定審査会開催場所コード;
    }
}
