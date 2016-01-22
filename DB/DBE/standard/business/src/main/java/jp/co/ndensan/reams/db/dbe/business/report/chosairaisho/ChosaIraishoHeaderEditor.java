/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 要介護認定調査依頼書ヘッダEditorです。
 */
class ChosaIraishoHeaderEditor implements IChosaIraishoEditor {

    private static final RString TITLE = new RString("認定調査依頼書");
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
        if (item.getHakkoYMD() == null && item.getHakkoYMD().isEmpty()) {
            source.hakkoYMD = item.getHakkoYMD();
        } else {
            source.hakkoYMD = パターン12(new RDate(item.getHakkoYMD().toString()));
        }
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.shichosonMei = item.getShichosonMei();
        source.shuchoMei = item.getShuchoMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin1 = item.getDenshiKoin1();
        source.title = TITLE;
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
        if (item.getBirthYMD() == null || item.getBirthYMD().isEmpty()) {
            source.birthYMD = RString.EMPTY;
        } else {
            source.birthYMD = パターン12(new RDate(item.getBirthYMD().toString()));
        }
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.telNo = item.getTelNo();
        source.homonChosasakiYubinNo = item.getHomonChosasakiYubinNo();
        //TODO 李 QA511 RESを生成するのフィールドと帳票設計書の項目は一致しない
        source.homonChosasakiJusho1 = item.getHomonChosasakiJusho1();
        source.homonChosasakiJusho2 = item.getHomonChosasakiJusho2();
        source.homonChosasakiJusho3 = item.getHomonChosasakiJusho3();
        source.homonChosasakiTelNo = item.getHomonChosasakiTelNo();
        if (item.getShinseiYMD() == null || item.getShinseiYMD().isEmpty()) {
            source.shinseiYMD = RString.EMPTY;
        } else {
            source.shinseiYMD = パターン12(new RDate(item.getShinseiYMD().toString()));
        }
        if (item.getTeishutsuKigen() == null || item.getTeishutsuKigen().isEmpty()) {
            source.teishutsuKigen = RString.EMPTY;
        } else {
            source.teishutsuKigen = パターン12(new RDate(item.getTeishutsuKigen().toString()));
        }
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

    private RString パターン12(RDate rDate) {
        return rDate.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
