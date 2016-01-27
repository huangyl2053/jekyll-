/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況調査）を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteichosahyoGaikyoChosaMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int ninteichosaRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaRirekiNo int
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteichosahyoGaikyoChosaMapperParameter(
            @lombok.NonNull ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo) {

        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaRirekiNo int
     * @return 認定調査票（概況調査）検索パラメータ
     */
    public static NinteichosahyoGaikyoChosaMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo) {
        return new NinteichosahyoGaikyoChosaMapperParameter(shinseishoKanriNo, ninteichosaRirekiNo);
    }
}
