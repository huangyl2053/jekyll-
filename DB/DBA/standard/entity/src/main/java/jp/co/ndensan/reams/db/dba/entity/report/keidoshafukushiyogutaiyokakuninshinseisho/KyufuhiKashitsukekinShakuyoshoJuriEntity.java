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

    public FlexibleDate getKariukeYMD() {
        return kariukeYMD;
    }

    public void setKariukeYMD(FlexibleDate kariukeYMD) {
        this.kariukeYMD = kariukeYMD;
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

}
