/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 連携用データ送付記録の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class RenkeiyoDataSofuKirokuIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final FlexibleDate 資料作成日;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 資料作成日 資料作成日
     */
    public RenkeiyoDataSofuKirokuIdentifier(ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 資料作成日) {
        this.申請書管理番号 = 申請書管理番号;
        this.資料作成日 = 資料作成日;
    }
}
