/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kyufuhikashitsukekinkettei;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 給付費貸付金決定情報のマッパーインタフェースです。
 * 
 * @reamsid_L DBA-0540-440  lijia
 * 
 */
public interface IKyufuhiKashitsukeKinKetteiMapper {

    /**
     * 貸付管理番号を取得します。
     *
     * @param hihokenshaNo 貸付管理番号
     * @return 貸付管理番号
     */
    KyufuhiKashitsukeKinKetteiEntity getKashitsukeKanriNo(HihokenshaNo hihokenshaNo);
}
