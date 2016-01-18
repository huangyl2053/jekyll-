/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.ninteichosairaishokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査情報を取得するのParameterクラスです。
 */
public class NinteiChosaIraiShokaiParameter {

    private final RString hihokenshaNo;

    private NinteiChosaIraiShokaiParameter(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * パラメータ設定
     *
     * @param hihokenshaNo 被保険者番号
     * @return NinteiChosaIraiShokaiParameter
     */
    public static NinteiChosaIraiShokaiParameter createParam(RString hihokenshaNo) {
        return new NinteiChosaIraiShokaiParameter(hihokenshaNo);
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }
}
