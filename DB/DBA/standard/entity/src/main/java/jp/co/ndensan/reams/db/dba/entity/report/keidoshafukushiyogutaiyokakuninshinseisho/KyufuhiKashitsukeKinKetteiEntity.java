/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金決定情報を取得します.
 *
 */
public class KyufuhiKashitsukeKinKetteiEntity {

    private HihokenshaNo hihokenshaNo;
    private RString kashitsukeKanriNo;

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
    }
}
