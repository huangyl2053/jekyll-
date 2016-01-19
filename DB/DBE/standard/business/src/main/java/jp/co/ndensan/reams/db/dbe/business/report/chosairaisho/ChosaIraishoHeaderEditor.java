/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 要介護認定調査依頼書ヘッダEditorです。
 */
class ChosaIraishoHeaderEditor implements IChosaIraishoEditor {

    private final ChosaIraishoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraishoHeadItem}
     */
    protected ChosaIraishoHeaderEditor(ChosaIraishoHeadItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 要介護認定調査依頼書Sourceクラス
     * @return ChosaIraishoReportSource 要介護認定調査依頼書Sourceクラス
     */
    @Override
    public ChosaIraishoReportSource edit(ChosaIraishoReportSource source) {
        return editHeader(source);
    }

    private ChosaIraishoReportSource editHeader(ChosaIraishoReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        source.hakkoYMD = new RDate(item.getHakkoYMD().toString()).wareki().fillType(FillType.ZERO).toDateString();
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.shichosonMei = item.getShichosonMei();
        source.shuchoMei = item.getShuchoMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin1 = item.getDenshiKoin1();
        source.title = new RString("認定調査依頼書");
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
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = new RDate(item.getBirthYMD().toString()).wareki().eraType(EraType.KANJI).toDateString();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.telNo = item.getTelNo();
        source.homonChosasakiYubinNo = item.getHomonChosasakiYubinNo();
        source.homonChosasakiJusho1 = item.getHomonChosasakiJusho1();
        source.homonChosasakiJusho2 = item.getHomonChosasakiJusho2();
        source.homonChosasakiJusho3 = item.getHomonChosasakiJusho3();
        source.homonChosasakiTelNo = item.getHomonChosasakiTelNo();
        source.shinseiYMD = new RDate(item.getShinseiYMD().toString()).wareki().eraType(EraType.KANJI).toDateString();
        source.teishutsuKigen = new RDate(item.getTeishutsuKigen().toString()).wareki().eraType(EraType.KANJI).toDateString();
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
        source.tsuchibun3 = item.getTsuchibun3();
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
        source.remban = item.getRemban();
        return source;
    }
}
