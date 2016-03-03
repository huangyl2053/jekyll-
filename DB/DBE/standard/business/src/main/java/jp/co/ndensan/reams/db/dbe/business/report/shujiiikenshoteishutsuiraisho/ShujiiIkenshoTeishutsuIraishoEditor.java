/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護保険指定医依頼兼主治医意見書提出依頼書Editorです。
 */
class ShujiiIkenshoTeishutsuIraishoEditor implements IShujiiIkenshoTeishutsuIraishoEditor {

    private final ShujiiIkenshoTeishutsuIraishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoTeishutsuIraishoItem}
     */
    protected ShujiiIkenshoTeishutsuIraishoEditor(ShujiiIkenshoTeishutsuIraishoItem item) {
        this.item = item;
    }

    @Override
    public ShujiiIkenshoTeishutsuIraishoReportSource edit(ShujiiIkenshoTeishutsuIraishoReportSource source) {
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.shichosonMei = item.getShichosonMei();
        source.shuchoMei = item.getShuchoMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.bunshoNo = item.getBunshoNo();
        source.hakkoYMD = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.title = ReportIdDBE.DBE236001.getReportName();
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
        source.tsuchibun3 = item.getTsuchibun3();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.birthYMD = item.getBirthYMD();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.tsuchibun4 = item.getTsuchibun4();
        source.tsuchibun5 = item.getTsuchibun5();
        source.tsuchibun6 = item.getTsuchibun6();
        source.tsuchibun7 = item.getTsuchibun7();
        source.tsuchibun8 = item.getTsuchibun8();
        source.tsuchibun9 = item.getTsuchibun9();
        source.tsuchibun10 = item.getTsuchibun10();
        source.tsuchibun11 = item.getTsuchibun11();
        source.tsuchibun12 = item.getTsuchibun12();
        source.tsuchibun13 = item.getTsuchibun13();
        source.tsuchibun14 = item.getTsuchibun14();
        source.tsuchibun15 = item.getTsuchibun15();
        source.tsuchibun16 = item.getTsuchibun16();
        source.tsuchibun17 = item.getTsuchibun17();
        source.tsuchibun18 = item.getTsuchibun18();
        source.tsuchibun19 = item.getTsuchibun19();
        source.tsuchibun20 = item.getTsuchibun20();
        source.remban = item.getRemban();
        return source;
    }
}
