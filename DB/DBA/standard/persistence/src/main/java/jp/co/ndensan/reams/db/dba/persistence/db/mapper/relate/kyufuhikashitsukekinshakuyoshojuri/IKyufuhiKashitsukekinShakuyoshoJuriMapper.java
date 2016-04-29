/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kyufuhikashitsukekinshakuyoshojuri;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 給付費貸付金借用書受理情報のマッパーインタフェースです。
 * 
 * @reamsid_L DBA-0540-440  lijia
 * 
 */
public interface IKyufuhiKashitsukekinShakuyoshoJuriMapper {

    /**
     * 借受年月日を取得します。
     *
     * @param hihokenshaNo 貸付管理番号
     * @return KyufuhiKashitsukekinShakuyoshoJuriEntity 給付費貸付金借用書受理情報
     */
    KyufuhiKashitsukekinShakuyoshoJuriEntity getKariukeYMD(HihokenshaNo hihokenshaNo);
}
