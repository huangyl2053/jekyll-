/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬実績情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShujiiIkenshoHoshuJissekiJohoIdentifier implements Serializable {

    private final RString 主治医医療機関コード;
    private final RString 主治医コード;
    private final ShinseishoKanriNo 申請書管理番号;
    private final int 主治医意見書作成依頼履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public ShujiiIkenshoHoshuJissekiJohoIdentifier(
            RString 主治医医療機関コード,
            RString 主治医コード,
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.申請書管理番号 = 申請書管理番号;
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
    }
}
