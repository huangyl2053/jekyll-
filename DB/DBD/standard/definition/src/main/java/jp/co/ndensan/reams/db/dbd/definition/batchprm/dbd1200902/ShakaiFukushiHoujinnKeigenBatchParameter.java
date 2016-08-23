/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等利用者負担額軽減確認証・通知書一括発行フローバッチパラメタークラスです．
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHoujinnKeigenBatchParameter extends BatchParameterBase {

    private TanpyoHakkoKubun 単票発行区分;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private FlexibleDate 対象日FROM;
    private FlexibleDate 対象日TO;
    private boolean 認定証発行フラグ;
    private FlexibleDate 認定証の交付日;
    private boolean 通知書発行フラグ;
    private FlexibleDate 通知書の発行日;
    private RString 通知書の文書番号;
    private RString 改頁出力順ID;
}
