/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteisaikinshorisha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定支援システムの最近処理者を扱います。
 */
public class NinteiSaikinShorisha implements Serializable {

    private static final long serialVersionUID = -3505014208994476910L;

    private final DbT7501NinteiSaikinShorishaEntity entity;

    /**
     * @param entity {@link DbT7501NinteiSaikinShorishaEntity}
     */
    NinteiSaikinShorisha(DbT7501NinteiSaikinShorishaEntity entity) {
        this.entity = entity;
    }

    /**
     * @return 個人を特定するためのキー
     */
    public RString getKey() {
        ShoKisaiHokenshaNo s = getShoKisaiHokenshaNo();
        return (s == null ? RString.EMPTY : s.value()).concat(getHihokenshaNo());
    }

    /**
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return this.entity.getShoKisaiHokenshaNo();
    }

    /**
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return this.entity.getHihokenshaNo();
    }

    /**
     * @return 被保険者名
     */
    public RString getHihokenshaName() {
        return this.entity.getHihokenshaName();
    }

    /**
     * @return 生成した表示名称
     */
    public RString composeDisplayName() {
        return this.entity.getHihokenshaNo().concat("　").concat(this.entity.getHihokenshaName());
    }

}
