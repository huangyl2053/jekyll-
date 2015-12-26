/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiWariateJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 4807488577740704806L;
    private final RString 介護認定審査会開催番号;
    private final ShinseishoKanriNo 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinsakaiWariateJohoIdentifier(RString 介護認定審査会開催番号,
            ShinseishoKanriNo 申請書管理番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.申請書管理番号 = 申請書管理番号;
    }

}
