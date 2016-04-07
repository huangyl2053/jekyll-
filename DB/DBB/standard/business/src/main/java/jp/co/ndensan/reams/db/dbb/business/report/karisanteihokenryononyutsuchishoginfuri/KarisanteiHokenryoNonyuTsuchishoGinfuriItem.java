/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import lombok.Getter;

/**
 * 納入通知書の帳票の作成用のクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiHokenryoNonyuTsuchishoGinfuriItem {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 雛形部品CompNinshosha
     */
    public KarisanteiHokenryoNonyuTsuchishoGinfuriItem(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

}
