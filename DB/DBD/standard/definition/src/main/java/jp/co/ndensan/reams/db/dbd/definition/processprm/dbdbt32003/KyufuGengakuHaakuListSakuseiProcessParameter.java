/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 給付額減額滞納者把握情報の取得_Process処理パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuListSakuseiProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private ReportId 帳票ID;
    private Long 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     */
    public KyufuGengakuHaakuListSakuseiProcessParameter(FlexibleDate 基準日,
            ReportId 帳票ID,
            Long 出力順ID) {
        this.基準日 = 基準日;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }
}
