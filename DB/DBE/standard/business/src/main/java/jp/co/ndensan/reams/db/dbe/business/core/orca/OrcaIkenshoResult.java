/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.orca;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * オルカ医意書の取込結果を保持します。
 */
@lombok.AllArgsConstructor
@lombok.Getter
public class OrcaIkenshoResult {

    private final RString 申請書管理番号;
    private final int 主治医意見書作成依頼履歴番号;
    private final RString 厚労省IF識別コード;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;
    private final OrcaIkenshoCsv csvRow;

}
