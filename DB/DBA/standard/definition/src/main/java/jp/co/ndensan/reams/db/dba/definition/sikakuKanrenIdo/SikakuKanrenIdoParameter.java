/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.sikakuKanrenIdo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author soft863
 */
public class SikakuKanrenIdoParameter {

    public final HihokenshaNo hihokenshaNo;
    public final boolean isHihokenshaNo;
    public final ShikibetsuCode shikibetsuCode;
    public final FlexibleDate shikakuShutokuYMD;

    private SikakuKanrenIdoParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate shikakuShutokuYMD) {
        this.hihokenshaNo = hihokenshaNo;
        this.isHihokenshaNo = isHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 共通パラメータ設定
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コー
     * @param shikakuShutokuYMD 取得日
     * @return JigyoshaInputGuideParameter
     */
    public static SikakuKanrenIdoParameter createParam(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate shikakuShutokuYMD) {
        boolean isHihokenshaNo = false;

        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            isHihokenshaNo = true;
        }

        return new SikakuKanrenIdoParameter(
                hihokenshaNo,
                isHihokenshaNo,
                shikibetsuCode,
                shikakuShutokuYMD);
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

    public ShikibetsuCode getshikibetsuCode() {
        return shikibetsuCode;
    }

    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

}
