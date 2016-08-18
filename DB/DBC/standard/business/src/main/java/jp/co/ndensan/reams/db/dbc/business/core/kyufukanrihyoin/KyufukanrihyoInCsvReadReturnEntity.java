/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin;

import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * CSVファイル取込・登録の結果です。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoInCsvReadReturnEntity {

    private ShichosonSecurityJoho 市町村セキュリティ情報;
    private FlexibleDate 変換基準日;
    private FlexibleYearMonth 処理対象年月;
    private int レコード件数合算;
    private int 明細件数合算;
    private int 集計件数合算;

}
