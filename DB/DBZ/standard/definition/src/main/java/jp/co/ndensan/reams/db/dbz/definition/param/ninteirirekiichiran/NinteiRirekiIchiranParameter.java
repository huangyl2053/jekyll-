/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.ninteirirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 受給者台帳情報の取得するクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiRirekiIchiranParameter {

    private final HihokenshaNo hihokenshaNo;

    private NinteiRirekiIchiranParameter(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 受給者台帳情報の検索パラメータ
     */
    public static NinteiRirekiIchiranParameter createParam(HihokenshaNo hihokenshaNo) {
        return new NinteiRirekiIchiranParameter(hihokenshaNo);
    }
}
