/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定申請者基本情報を取得するのParameterクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiShinseishaKihonInfoParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;

    private NinteiShinseishaKihonInfoParameter(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * パラメータ設定です
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @return NinteiShinseishaKihonInfoParameter
     */
    public static NinteiShinseishaKihonInfoParameter createParam(ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiShinseishaKihonInfoParameter(shinseishoKanriNo);
    }
}
