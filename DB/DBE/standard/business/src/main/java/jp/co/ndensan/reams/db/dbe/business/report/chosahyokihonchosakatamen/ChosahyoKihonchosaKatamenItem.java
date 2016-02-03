/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査票（基本調査）のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoKihonchosaKatamenItem {

    private final RString chosaJyokyo;
    private final RString hokenshaNo;
    private final RString shinseiYMD;
    private final RString hihokenshaNo;

    /**
     * インスタンスを生成します。
     *
     * @param chosaJyokyo 概況調査区分
     * @param hokenshaNo 保険者番号
     * @param shinseiYMD 申請日
     * @param hihokenshaNo 被保険者番号
     */
    public ChosahyoKihonchosaKatamenItem(RString chosaJyokyo, RString hokenshaNo, RString shinseiYMD, RString hihokenshaNo) {
        this.chosaJyokyo = chosaJyokyo;
        this.hokenshaNo = hokenshaNo;
        this.shinseiYMD = shinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
    }
}
