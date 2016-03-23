/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.shikakutokusojouho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ShikakuRirekiInfo_資格履歴情報のParameterクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShikakuTokusoJouhoParameter {

    private final HihokenshaNo hihokenshaNo;
    private final boolean isHihokenshaNo;
    private final ShikibetsuCode shikibetsuCode;
    private final RString 単一広域区分;

    ShikakuTokusoJouhoParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            RString 単一広域区分) {
        this.hihokenshaNo = hihokenshaNo;
        this.isHihokenshaNo = isHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.単一広域区分 = 単一広域区分;
    }

    /**
     * パラメータ設定。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コー
     * @param 単一広域区分 RString
     * @return JigyoshaInputGuideParameter
     */
    public static ShikakuTokusoJouhoParameter createParam(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            RString 単一広域区分) {
        boolean isHihokenshaNo = false;

        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            isHihokenshaNo = true;
        }
        return new ShikakuTokusoJouhoParameter(
                hihokenshaNo,
                isHihokenshaNo,
                shikibetsuCode,
                単一広域区分);
    }

    /**
     * 保険者番号があるを返します。
     *
     * @return 保険者番号
     */
    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

}
