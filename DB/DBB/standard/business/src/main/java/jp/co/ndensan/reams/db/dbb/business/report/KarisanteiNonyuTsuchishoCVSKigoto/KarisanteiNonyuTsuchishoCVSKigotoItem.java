/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.KarisanteiNonyuTsuchishoCVSKigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import lombok.Getter;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】KarisanteiNonyuTsuchishoCVSKigotoItem
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiNonyuTsuchishoCVSKigotoItem {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     */
    public KarisanteiNonyuTsuchishoCVSKigotoItem(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
    }

}
