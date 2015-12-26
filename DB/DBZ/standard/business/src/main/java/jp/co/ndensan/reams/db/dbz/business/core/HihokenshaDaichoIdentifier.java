/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 被保険者台帳管理の識別子です。
 */
@Value
public class HihokenshaDaichoIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 異動日;
    private final RString 枝番;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public HihokenshaDaichoIdentifier(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        this.被保険者番号 = 被保険者番号;
        this.異動日 = 異動日;
        this.枝番 = 枝番;
    }

    /**
     * get被保険者番号
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * get異動日
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return 異動日;
    }

    /**
     * get枝番
     *
     * @return 枝番
     */
    public RString get枝番() {
        return 枝番;
    }

}
