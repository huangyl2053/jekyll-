/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import lombok.Getter;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】KarisanteiNonyuTsuchishoCVSKigotoItem
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiNonyuTsuchishoCVSKigotoItem {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 雛形部品CompNinshosha
     */
    public KarisanteiNonyuTsuchishoCVSKigotoItem(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

}
