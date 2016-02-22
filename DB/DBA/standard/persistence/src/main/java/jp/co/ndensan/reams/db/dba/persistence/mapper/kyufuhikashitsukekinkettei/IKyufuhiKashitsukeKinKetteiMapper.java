/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.kyufuhikashitsukekinkettei;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 給付費貸付金決定情報のマッパーインタフェースです。
 */
public interface IKyufuhiKashitsukeKinKetteiMapper {

    /**
     * 貸付管理番号を取得します。
     *
     * @param hihokenshaNo 貸付管理番号
     * @return
     */
    KyufuhiKashitsukeKinKetteiEntity getKashitsukeKanriNo(HihokenshaNo hihokenshaNo);
}
