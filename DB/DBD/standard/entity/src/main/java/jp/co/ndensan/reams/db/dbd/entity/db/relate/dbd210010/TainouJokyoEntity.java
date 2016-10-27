/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付制限対象者一覧CSVの滞納状況情報データEntityです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainouJokyoEntity {

    private HihokenshaNo 被保険者番号;
    private RString 管理区分;
    private int 履歴番号;
    private RString 滞納判定区分;
    private RString 通知書番号;
    private Decimal 集計滞納額;
}
