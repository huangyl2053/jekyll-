/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ikenshojissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医意見書作成実績集計表のキー情報クラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJissekiIchiranKey {

    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 申請書管理番号;
    private RString 主治医意見書作成依頼履歴番号;
}
