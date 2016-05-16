/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のPrintServiceです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoPrintService {

    /**
     * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書 printメソッド
     *
     * @param target KariSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho target) {
        KarisanteiNonyuTsuchishoCVSKakukoProperty property = new KarisanteiNonyuTsuchishoCVSKakukoProperty();
        return new Printer<KarisanteiNonyuTsuchishoCVSKakukoSource>().spool(property,
                new KarisanteiNonyuTsuchishoCVSKakukoReport(target));
    }
}
