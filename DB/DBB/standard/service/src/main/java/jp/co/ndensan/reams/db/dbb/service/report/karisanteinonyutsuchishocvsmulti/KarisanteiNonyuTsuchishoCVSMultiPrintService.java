/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書のPrintServiceです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiPrintService {

    /**
     * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書 printメソッド
     *
     * @param target KariSanteiNonyuTsuchiShoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho target) {
        KarisanteiNonyuTsuchishoCVSMultiProperty property = new KarisanteiNonyuTsuchishoCVSMultiProperty();
        return new Printer<KarisanteiNonyuTsuchishoCVSMultiSource>().spool(property,
                new KarisanteiNonyuTsuchishoCVSMultiReport(target));
    }
}
