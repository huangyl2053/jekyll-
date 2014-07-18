/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定の取下げを扱います。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiTorisage {

    private final Code torisageKubunCode;
    private final TorisageRiyu torisageRiyu;
    private final FlexibleDate torisageDate;

    /**
     * 新しいYokaigoNinteiTorisageを生成します。
     *
     * @param 取下げ区分コード 取下げ区分コード
     * @param 取下げ理由 取下げ理由
     * @param 取下げ年月日 取下げ年月日
     */
    public YokaigoNinteiTorisage(Code 取下げ区分コード, TorisageRiyu 取下げ理由, FlexibleDate 取下げ年月日) {
        this.torisageKubunCode = 取下げ区分コード;
        this.torisageRiyu = 取下げ理由;
        this.torisageDate = 取下げ年月日;
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return 取下げ区分コード
     */
    public Code get取下げ区分コード() {
        return this.torisageKubunCode;
    }

    /**
     * 取下げ理由を返します。
     *
     * @return 取下げ理由
     */
    public TorisageRiyu get取下げ理由() {
        return this.torisageRiyu;
    }

    /**
     * 取下げ年月日を返します。
     *
     * @return 取下げ年月日
     */
    public FlexibleDate get取下げ年月日() {
        return this.torisageDate;
    }
}
