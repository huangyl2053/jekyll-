/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosa;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * INinteichosaContextMapperのパラメータです。
 */
@lombok.Getter
public class NinteichosaContextMapperParameter {

    private final RString shinseishoKanriNo;
    private final int ninteichosaIraiRirekiNo;

    private NinteichosaContextMapperParameter(RString shinseishoKanriNo, int ninteichosaIraiRirekiNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    /**
     * @param shinseishoKanriNo 申請書管理番号
     * @param ninteichosaIraiRirekiNo 認定調査依頼履歴番号
     * @return {@link NinteichosaContextMapperParameter}のインスタンス
     */
    public static NinteichosaContextMapperParameter hasBeenExaminedBefore(RString shinseishoKanriNo, int ninteichosaIraiRirekiNo) {
        return new NinteichosaContextMapperParameter(shinseishoKanriNo, ninteichosaIraiRirekiNo);
    }
}
