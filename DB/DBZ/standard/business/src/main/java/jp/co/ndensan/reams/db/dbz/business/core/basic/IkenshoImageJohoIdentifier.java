/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定意見書イメージ情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class IkenshoImageJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 主治医意見書作成依頼履歴番号;
    private final Code 帳票ID;
    private final RString マスキングデータ区分;
//    private final int 取込みページ番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 帳票ID 帳票ID
     * @param マスキングデータ区分 マスキングデータ区分
     * @param 取込みページ番号 取込みページ番号
     */
    public IkenshoImageJohoIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            Code 帳票ID,
            RString マスキングデータ区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
        this.帳票ID = 帳票ID;
        this.マスキングデータ区分 = マスキングデータ区分;
//        this.取込みページ番号 = 取込みページ番号;
    }
}
