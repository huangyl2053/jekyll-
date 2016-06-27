/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshoirai.ninteishinseijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定申請情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiShinseiJohoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiShinseiJohoMapperParameter(
            ShinseishoKanriNo shinseishoKanriNo) {

        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @return 要介護認定申請情報検索パラメータ
     */
    public static NinteiShinseiJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiShinseiJohoMapperParameter(shinseishoKanriNo);
    }
}
