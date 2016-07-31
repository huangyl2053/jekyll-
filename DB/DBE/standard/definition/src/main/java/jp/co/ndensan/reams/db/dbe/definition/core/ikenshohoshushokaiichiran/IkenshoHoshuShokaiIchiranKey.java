/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬合計額リストのキー情報クラスです。
 *
 * @reamsid_L DBE-1930-030 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoHoshuShokaiIchiranKey {

    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 申請書管理番号;
    private int 主治医意見書作成依頼履歴番号;

    /**
     * コンストラクタ
     */
    public IkenshoHoshuShokaiIchiranKey() {
    }

    /**
     * コンストラクタ
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public IkenshoHoshuShokaiIchiranKey(RString 主治医医療機関コード, RString 主治医コード, RString 申請書管理番号, int 主治医意見書作成依頼履歴番号) {
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.申請書管理番号 = 申請書管理番号;
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
    }
}
