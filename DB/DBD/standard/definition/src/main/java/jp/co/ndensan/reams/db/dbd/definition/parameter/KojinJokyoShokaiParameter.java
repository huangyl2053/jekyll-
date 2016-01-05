/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.parameter;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class KojinJokyoShokaiParameter {

    private ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KojinJokyoShokaiParameter(ShinseishoKanriNo shinseishoKanriNo) {
	this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public static KojinJokyoShokaiParameter createSelectByKeyParam(ShinseishoKanriNo shinseishoKanriNo) {

	return new KojinJokyoShokaiParameter(shinseishoKanriNo);
    }

}
