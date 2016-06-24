/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikensho.ninteishinseijoho;

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
    private final boolean usesShinseishoKanriNo;
    private final int ikenshoIraiRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param usesShinseishoKanriNo usesShinseishoKanriNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiShinseiJohoMapperParameter(
            ShinseishoKanriNo shinseishoKanriNo,
            boolean usesShinseishoKanriNo,
            int ikenshoIraiRirekiNo) {

        this.shinseishoKanriNo = shinseishoKanriNo;
        this.usesShinseishoKanriNo = usesShinseishoKanriNo;
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @return 身体手帳検索パラメータ
     */
    public static NinteiShinseiJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiShinseiJohoMapperParameter(shinseishoKanriNo, true, 0);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @return 身体手帳検索パラメータ
     */
    public static NinteiShinseiJohoMapperParameter createSelectListParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiShinseiJohoMapperParameter(shinseishoKanriNo, false, 0);
    }

    /**
     * 主治医意見書登録用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @return 要介護認定申請情報パラメータ
     */
    public static NinteiShinseiJohoMapperParameter create主治医意見書登録Param(
            ShinseishoKanriNo shinseishoKanriNo, int ikenshoIraiRirekiNo) {
        return new NinteiShinseiJohoMapperParameter(shinseishoKanriNo, false, ikenshoIraiRirekiNo);
    }
}
