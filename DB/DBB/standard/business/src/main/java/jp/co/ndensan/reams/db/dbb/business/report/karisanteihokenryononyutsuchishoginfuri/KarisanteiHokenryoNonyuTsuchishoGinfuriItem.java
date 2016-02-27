/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import lombok.Getter;

/**
 *
 * @author wangjie2
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiHokenryoNonyuTsuchishoGinfuriItem {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;

    public KarisanteiHokenryoNonyuTsuchishoGinfuriItem(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
    }

}
