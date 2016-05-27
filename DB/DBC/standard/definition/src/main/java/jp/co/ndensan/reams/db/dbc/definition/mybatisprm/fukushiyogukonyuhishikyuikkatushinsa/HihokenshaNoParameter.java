/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 福祉用具購入費支給申請一括審査・決定パラメータ
 *
 * @reamsid_L DBC-1021-100 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaNoParameter {

    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public HihokenshaNoParameter(HihokenshaNo 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

}
