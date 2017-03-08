/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3213
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiWariateJohoKenshuIdentifier implements Serializable {
    
    private final RString 審査会開催番号;
    private final ShinseishoKanriNo 申請管理番号;

    /**
     * コンストラクタです。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 申請管理番号 申請管理番号
     */
    public ShinsakaiWariateJohoKenshuIdentifier(RString 審査会開催番号, ShinseishoKanriNo 申請管理番号) {
        this.審査会開催番号 = 審査会開催番号;
        this.申請管理番号 = 申請管理番号;
    }
}
