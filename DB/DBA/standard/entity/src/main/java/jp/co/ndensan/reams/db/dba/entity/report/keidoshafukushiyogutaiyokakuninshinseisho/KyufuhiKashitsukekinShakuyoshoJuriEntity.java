/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 給付費貸付金借用書受理情報を取得します.
 *
 */
public class KyufuhiKashitsukekinShakuyoshoJuriEntity {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate kariukeYMD;

    /**
     * 借受年月日の取得します。
     * @return 借受年月日
     */
    public FlexibleDate getKariukeYMD() {
        return kariukeYMD;
    }

    /**
     * 借受年月日の設定します。
     * @param kariukeYMD 借受年月日
     */
    public void setKariukeYMD(FlexibleDate kariukeYMD) {
        this.kariukeYMD = kariukeYMD;
    }

    /**
     * 被保険者番号の取得します。
     * @return 借受年月日
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号の設定します。
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

}
