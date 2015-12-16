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
 * 資格得喪履歴補助のParameterクラスです。
 */
public final class ShikakuTokusoParameter {

    private final HihokenshaNo hihokenshaNo;
    private final boolean isHihokenshaNo;
    private final ShikibetsuCode shikibetsuCode;

    private ShikakuTokusoParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNo,
            ShikibetsuCode shikibetsuCode) {
        this.hihokenshaNo = hihokenshaNo;
        this.isHihokenshaNo = isHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * パラメータ設定。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コー
     * @return JigyoshaInputGuideParameter
     */
    public static ShikakuTokusoParameter createParam(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode) {
        boolean isHihokenshaNo = false;

        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            isHihokenshaNo = true;
        }

        return new ShikakuTokusoParameter(
                hihokenshaNo,
                isHihokenshaNo,
                shikibetsuCode);
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 保険者番号があるを返します。
     *
     * @return 保険者番号
     */
    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

}
