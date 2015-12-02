/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.shikakutokuso;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * @author soft863
 */
public class ShikakuTokusoInputGuideParameter {

    public final HihokenshaNo hihokenshaNo;
    public final boolean isHihokenshaNo;
    public final ShikibetsuCode shikibetsuCode;

    private ShikakuTokusoInputGuideParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNo,
            ShikibetsuCode shikibetsuCode) {
        this.hihokenshaNo = hihokenshaNo;
        this.isHihokenshaNo = isHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 共通パラメータ設定
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コー
     * @return JigyoshaInputGuideParameter
     */
    public static ShikakuTokusoInputGuideParameter createParam(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode) {
        boolean isHihokenshaNo = false;

        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            isHihokenshaNo = true;
        }

        return new ShikakuTokusoInputGuideParameter(
                hihokenshaNo,
                isHihokenshaNo,
                shikibetsuCode);
    }

    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

}
