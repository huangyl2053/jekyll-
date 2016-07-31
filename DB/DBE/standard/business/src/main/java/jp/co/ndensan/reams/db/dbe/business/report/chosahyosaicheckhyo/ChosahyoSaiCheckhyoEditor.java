/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 前回認定調査結果との比較表Editorです。
 *
 * @reamsid_L DBE-0080-120 duanzhanli
 */
class ChosahyoSaiCheckhyoEditor implements IChosahyoSaiCheckhyoEditor {

    private final ChosahyoSaiCheckhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoSaiCheckhyoItem}
     */
    protected ChosahyoSaiCheckhyoEditor(ChosahyoSaiCheckhyoItem item) {
        this.item = item;
    }

    /**
     * @param source 前回認定調査結果との比較表のReportSource
     * @return ChosahyoSaiCheckhyoReportSource
     */
    @Override
    public ChosahyoSaiCheckhyoReportSource edit(ChosahyoSaiCheckhyoReportSource source) {
        source.title = item.getTitle();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.pageCount = item.getPageCount();
        source.printTimeStamp = item.getPrintTimeStamp();
        source.zenkaiIchijihanteikekka = item.getZenkaiIchijihanteikekka();
        source.konkaiIchijihanteikekka = item.getKonkaiIchijihanteikekka();
        RString shinsakaiYMD = item.getShinsakaiYMD();
        if (!RString.isNullOrEmpty(shinsakaiYMD)) {
            source.shinsakaiYMD = new FlexibleDate(shinsakaiYMD).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else {
            source.shinsakaiYMD = RString.EMPTY;
        }
        source.gogitaiNo = item.getGogitaiNo();
        source.zenkaiNijihanteikekka = item.getZenkaiNijihanteikekka();
        setZenkaiChosakekkaNo(source);
        setKonkaiChosakekkaNo(source);
        setTokkiFuraguNo(source);
        return source;
    }

    private void setZenkaiChosakekkaNo(ChosahyoSaiCheckhyoReportSource source) {
        source.zenkaiChosakekkaNo1 = setChosaAnser01(item.getZenkaiChosakekkaNo1());
        source.zenkaiChosakekkaNo2 = setChosaAnser01(item.getZenkaiChosakekkaNo2());
        source.zenkaiChosakekkaNo3 = setChosaAnser01(item.getZenkaiChosakekkaNo3());
        source.zenkaiChosakekkaNo4 = setChosaAnser01(item.getZenkaiChosakekkaNo4());
        source.zenkaiChosakekkaNo5 = setChosaAnser01(item.getZenkaiChosakekkaNo5());
        source.zenkaiChosakekkaNo6 = setChosaAnser01(item.getZenkaiChosakekkaNo6());
        source.zenkaiChosakekkaNo7 = setChosaAnser01(item.getZenkaiChosakekkaNo7());
        source.zenkaiChosakekkaNo8 = setChosaAnser01(item.getZenkaiChosakekkaNo8());
        source.zenkaiChosakekkaNo9 = setChosaAnser01(item.getZenkaiChosakekkaNo9());
        source.zenkaiChosakekkaNo10 = getChosaAnser02(item.getZenkaiChosakekkaNo10());
        source.zenkaiChosakekkaNo11 = getChosaAnser02(item.getZenkaiChosakekkaNo11());
        source.zenkaiChosakekkaNo12 = getChosaAnser03(item.getZenkaiChosakekkaNo12());
        source.zenkaiChosakekkaNo13 = getChosaAnser04(item.getZenkaiChosakekkaNo13());
        source.zenkaiChosakekkaNo14 = getChosaAnser02(item.getZenkaiChosakekkaNo14());
        source.zenkaiChosakekkaNo15 = getChosaAnser02(item.getZenkaiChosakekkaNo15());
        source.zenkaiChosakekkaNo16 = getChosaAnser04(item.getZenkaiChosakekkaNo16());
        source.zenkaiChosakekkaNo17 = getChosaAnser06(item.getZenkaiChosakekkaNo17());
        source.zenkaiChosakekkaNo18 = getChosaAnser07(item.getZenkaiChosakekkaNo18());
        source.zenkaiChosakekkaNo19 = getChosaAnser08(item.getZenkaiChosakekkaNo19());
        source.zenkaiChosakekkaNo20 = getChosaAnser09(item.getZenkaiChosakekkaNo20());
        source.zenkaiChosakekkaNo21 = getChosaAnser10(item.getZenkaiChosakekkaNo21());
        source.zenkaiChosakekkaNo22 = getChosaAnser10(item.getZenkaiChosakekkaNo22());
        source.zenkaiChosakekkaNo23 = getChosaAnser11(item.getZenkaiChosakekkaNo23());
        source.zenkaiChosakekkaNo24 = getChosaAnser10(item.getZenkaiChosakekkaNo24());
        source.zenkaiChosakekkaNo25 = getChosaAnser10(item.getZenkaiChosakekkaNo25());
        source.zenkaiChosakekkaNo26 = getChosaAnser10(item.getZenkaiChosakekkaNo26());
        source.zenkaiChosakekkaNo27 = getChosaAnser12(item.getZenkaiChosakekkaNo27());
        source.zenkaiChosakekkaNo28 = getChosaAnser12(item.getZenkaiChosakekkaNo28());
        source.zenkaiChosakekkaNo29 = getChosaAnser12(item.getZenkaiChosakekkaNo29());
        source.zenkaiChosakekkaNo30 = getChosaAnser10(item.getZenkaiChosakekkaNo30());
        source.zenkaiChosakekkaNo31 = getChosaAnser10(item.getZenkaiChosakekkaNo31());
        source.zenkaiChosakekkaNo32 = getChosaAnser13(item.getZenkaiChosakekkaNo32());
        source.zenkaiChosakekkaNo33 = getChosaAnser14(item.getZenkaiChosakekkaNo33());
        source.zenkaiChosakekkaNo34 = getChosaAnser15(item.getZenkaiChosakekkaNo34());
        source.zenkaiChosakekkaNo35 = getChosaAnser15(item.getZenkaiChosakekkaNo35());
        source.zenkaiChosakekkaNo36 = getChosaAnser15(item.getZenkaiChosakekkaNo36());
        source.zenkaiChosakekkaNo37 = getChosaAnser15(item.getZenkaiChosakekkaNo37());
        source.zenkaiChosakekkaNo38 = getChosaAnser15(item.getZenkaiChosakekkaNo38());
        source.zenkaiChosakekkaNo39 = getChosaAnser15(item.getZenkaiChosakekkaNo39());
        source.zenkaiChosakekkaNo40 = setChosaAnser16(item.getZenkaiChosakekkaNo40());
        source.zenkaiChosakekkaNo41 = setChosaAnser16(item.getZenkaiChosakekkaNo41());
        source.zenkaiChosakekkaNo42 = setChosaAnser16(item.getZenkaiChosakekkaNo42());
        source.zenkaiChosakekkaNo43 = setChosaAnser16(item.getZenkaiChosakekkaNo43());
        source.zenkaiChosakekkaNo44 = setChosaAnser16(item.getZenkaiChosakekkaNo44());
        source.zenkaiChosakekkaNo45 = setChosaAnser16(item.getZenkaiChosakekkaNo45());
        source.zenkaiChosakekkaNo46 = setChosaAnser16(item.getZenkaiChosakekkaNo46());
        source.zenkaiChosakekkaNo47 = setChosaAnser16(item.getZenkaiChosakekkaNo47());
        source.zenkaiChosakekkaNo48 = setChosaAnser16(item.getZenkaiChosakekkaNo48());
        source.zenkaiChosakekkaNo49 = setChosaAnser16(item.getZenkaiChosakekkaNo49());
        source.zenkaiChosakekkaNo50 = setChosaAnser16(item.getZenkaiChosakekkaNo50());
        source.zenkaiChosakekkaNo51 = setChosaAnser16(item.getZenkaiChosakekkaNo51());
        source.zenkaiChosakekkaNo52 = setChosaAnser16(item.getZenkaiChosakekkaNo52());
        source.zenkaiChosakekkaNo53 = setChosaAnser16(item.getZenkaiChosakekkaNo53());
        source.zenkaiChosakekkaNo54 = setChosaAnser16(item.getZenkaiChosakekkaNo54());
        source.zenkaiChosakekkaNo55 = setChosaAnser16(item.getZenkaiChosakekkaNo55());
        source.zenkaiChosakekkaNo56 = setChosaAnser16(item.getZenkaiChosakekkaNo56());
        source.zenkaiChosakekkaNo57 = getChosaAnser12(item.getZenkaiChosakekkaNo57());
        source.zenkaiChosakekkaNo58 = getChosaAnser12(item.getZenkaiChosakekkaNo58());
        source.zenkaiChosakekkaNo59 = getChosaAnser17(item.getZenkaiChosakekkaNo59());
        source.zenkaiChosakekkaNo60 = setChosaAnser16(item.getZenkaiChosakekkaNo60());
        source.zenkaiChosakekkaNo61 = getChosaAnser10(item.getZenkaiChosakekkaNo61());
        source.zenkaiChosakekkaNo62 = getChosaAnser10(item.getZenkaiChosakekkaNo62());
        source.zenkaiChosakekkaNo63 = setChosaAnser01(item.getZenkaiChosakekkaNo63());
        source.zenkaiChosakekkaNo64 = setChosaAnser01(item.getZenkaiChosakekkaNo64());
        source.zenkaiChosakekkaNo65 = setChosaAnser01(item.getZenkaiChosakekkaNo65());
        source.zenkaiChosakekkaNo66 = setChosaAnser01(item.getZenkaiChosakekkaNo66());
        source.zenkaiChosakekkaNo67 = setChosaAnser01(item.getZenkaiChosakekkaNo67());
        source.zenkaiChosakekkaNo68 = setChosaAnser01(item.getZenkaiChosakekkaNo68());
        source.zenkaiChosakekkaNo69 = setChosaAnser01(item.getZenkaiChosakekkaNo69());
        source.zenkaiChosakekkaNo70 = setChosaAnser01(item.getZenkaiChosakekkaNo70());
        source.zenkaiChosakekkaNo71 = setChosaAnser01(item.getZenkaiChosakekkaNo71());
        source.zenkaiChosakekkaNo72 = setChosaAnser01(item.getZenkaiChosakekkaNo72());
        source.zenkaiChosakekkaNo73 = setChosaAnser01(item.getZenkaiChosakekkaNo73());
        source.zenkaiChosakekkaNo74 = setChosaAnser01(item.getZenkaiChosakekkaNo74());
        source.zenkaiChosakekkaNo75 = item.getZenkaiChosakekkaNo75();
        source.zenkaiChosakekkaNo76 = item.getZenkaiChosakekkaNo76();
    }

    private void setKonkaiChosakekkaNo(ChosahyoSaiCheckhyoReportSource source) {
        source.konkaiChosakekkaNo1 = setChosaAnser01(item.getKonkaiChosakekkaNo1());
        source.konkaiChosakekkaNo2 = setChosaAnser01(item.getKonkaiChosakekkaNo2());
        source.konkaiChosakekkaNo3 = setChosaAnser01(item.getKonkaiChosakekkaNo3());
        source.konkaiChosakekkaNo4 = setChosaAnser01(item.getKonkaiChosakekkaNo4());
        source.konkaiChosakekkaNo5 = setChosaAnser01(item.getKonkaiChosakekkaNo5());
        source.konkaiChosakekkaNo6 = setChosaAnser01(item.getKonkaiChosakekkaNo6());
        source.konkaiChosakekkaNo7 = setChosaAnser01(item.getKonkaiChosakekkaNo7());
        source.konkaiChosakekkaNo8 = setChosaAnser01(item.getKonkaiChosakekkaNo8());
        source.konkaiChosakekkaNo9 = setChosaAnser01(item.getKonkaiChosakekkaNo9());
        source.konkaiChosakekkaNo10 = getChosaAnser02(item.getKonkaiChosakekkaNo10());
        source.konkaiChosakekkaNo11 = getChosaAnser02(item.getKonkaiChosakekkaNo11());
        source.konkaiChosakekkaNo12 = getChosaAnser03(item.getKonkaiChosakekkaNo12());
        source.konkaiChosakekkaNo13 = getChosaAnser04(item.getKonkaiChosakekkaNo13());
        source.konkaiChosakekkaNo14 = getChosaAnser02(item.getKonkaiChosakekkaNo14());
        source.konkaiChosakekkaNo15 = getChosaAnser02(item.getKonkaiChosakekkaNo15());
        source.konkaiChosakekkaNo16 = getChosaAnser04(item.getKonkaiChosakekkaNo16());
        source.konkaiChosakekkaNo17 = getChosaAnser06(item.getKonkaiChosakekkaNo17());
        source.konkaiChosakekkaNo18 = getChosaAnser07(item.getKonkaiChosakekkaNo18());
        source.konkaiChosakekkaNo19 = getChosaAnser08(item.getKonkaiChosakekkaNo19());
        source.konkaiChosakekkaNo20 = getChosaAnser09(item.getKonkaiChosakekkaNo20());
        source.konkaiChosakekkaNo21 = getChosaAnser10(item.getKonkaiChosakekkaNo21());
        source.konkaiChosakekkaNo22 = getChosaAnser10(item.getKonkaiChosakekkaNo22());
        source.konkaiChosakekkaNo23 = getChosaAnser11(item.getKonkaiChosakekkaNo23());
        source.konkaiChosakekkaNo24 = getChosaAnser10(item.getKonkaiChosakekkaNo24());
        source.konkaiChosakekkaNo25 = getChosaAnser10(item.getKonkaiChosakekkaNo25());
        source.konkaiChosakekkaNo26 = getChosaAnser10(item.getKonkaiChosakekkaNo26());
        source.konkaiChosakekkaNo27 = getChosaAnser12(item.getKonkaiChosakekkaNo27());
        source.konkaiChosakekkaNo28 = getChosaAnser12(item.getKonkaiChosakekkaNo28());
        source.konkaiChosakekkaNo29 = getChosaAnser12(item.getKonkaiChosakekkaNo29());
        source.konkaiChosakekkaNo30 = getChosaAnser10(item.getKonkaiChosakekkaNo30());
        source.konkaiChosakekkaNo31 = getChosaAnser10(item.getKonkaiChosakekkaNo31());
        source.konkaiChosakekkaNo32 = getChosaAnser13(item.getKonkaiChosakekkaNo32());
        source.konkaiChosakekkaNo33 = getChosaAnser14(item.getKonkaiChosakekkaNo33());
        source.konkaiChosakekkaNo34 = getChosaAnser15(item.getKonkaiChosakekkaNo34());
        source.konkaiChosakekkaNo35 = getChosaAnser15(item.getKonkaiChosakekkaNo35());
        source.konkaiChosakekkaNo36 = getChosaAnser15(item.getKonkaiChosakekkaNo36());
        source.konkaiChosakekkaNo37 = getChosaAnser15(item.getKonkaiChosakekkaNo37());
        source.konkaiChosakekkaNo38 = getChosaAnser15(item.getKonkaiChosakekkaNo38());
        source.konkaiChosakekkaNo39 = getChosaAnser15(item.getKonkaiChosakekkaNo39());
        source.konkaiChosakekkaNo40 = setChosaAnser16(item.getKonkaiChosakekkaNo40());
        source.konkaiChosakekkaNo41 = setChosaAnser16(item.getKonkaiChosakekkaNo41());
        source.konkaiChosakekkaNo42 = setChosaAnser16(item.getKonkaiChosakekkaNo42());
        source.konkaiChosakekkaNo43 = setChosaAnser16(item.getKonkaiChosakekkaNo43());
        source.konkaiChosakekkaNo44 = setChosaAnser16(item.getKonkaiChosakekkaNo44());
        source.konkaiChosakekkaNo45 = setChosaAnser16(item.getKonkaiChosakekkaNo45());
        source.konkaiChosakekkaNo46 = setChosaAnser16(item.getKonkaiChosakekkaNo46());
        source.konkaiChosakekkaNo47 = setChosaAnser16(item.getKonkaiChosakekkaNo47());
        source.konkaiChosakekkaNo48 = setChosaAnser16(item.getKonkaiChosakekkaNo48());
        source.konkaiChosakekkaNo49 = setChosaAnser16(item.getKonkaiChosakekkaNo49());
        source.konkaiChosakekkaNo50 = setChosaAnser16(item.getKonkaiChosakekkaNo50());
        source.konkaiChosakekkaNo51 = setChosaAnser16(item.getKonkaiChosakekkaNo51());
        source.konkaiChosakekkaNo52 = setChosaAnser16(item.getKonkaiChosakekkaNo52());
        source.konkaiChosakekkaNo53 = setChosaAnser16(item.getKonkaiChosakekkaNo53());
        source.konkaiChosakekkaNo54 = setChosaAnser16(item.getKonkaiChosakekkaNo54());
        source.konkaiChosakekkaNo55 = setChosaAnser16(item.getKonkaiChosakekkaNo55());
        source.konkaiChosakekkaNo56 = setChosaAnser16(item.getKonkaiChosakekkaNo56());
        source.konkaiChosakekkaNo57 = getChosaAnser12(item.getKonkaiChosakekkaNo57());
        source.konkaiChosakekkaNo58 = getChosaAnser12(item.getKonkaiChosakekkaNo58());
        source.konkaiChosakekkaNo59 = getChosaAnser17(item.getKonkaiChosakekkaNo59());
        source.konkaiChosakekkaNo60 = setChosaAnser16(item.getKonkaiChosakekkaNo60());
        source.konkaiChosakekkaNo61 = getChosaAnser10(item.getKonkaiChosakekkaNo61());
        source.konkaiChosakekkaNo62 = getChosaAnser10(item.getKonkaiChosakekkaNo62());
        source.konkaiChosakekkaNo63 = setChosaAnser01(item.getKonkaiChosakekkaNo63());
        source.konkaiChosakekkaNo64 = setChosaAnser01(item.getKonkaiChosakekkaNo64());
        source.konkaiChosakekkaNo65 = setChosaAnser01(item.getKonkaiChosakekkaNo65());
        source.konkaiChosakekkaNo66 = setChosaAnser01(item.getKonkaiChosakekkaNo66());
        source.konkaiChosakekkaNo67 = setChosaAnser01(item.getKonkaiChosakekkaNo67());
        source.konkaiChosakekkaNo68 = setChosaAnser01(item.getKonkaiChosakekkaNo68());
        source.konkaiChosakekkaNo69 = setChosaAnser01(item.getKonkaiChosakekkaNo69());
        source.konkaiChosakekkaNo70 = setChosaAnser01(item.getKonkaiChosakekkaNo70());
        source.konkaiChosakekkaNo71 = setChosaAnser01(item.getKonkaiChosakekkaNo71());
        source.konkaiChosakekkaNo72 = setChosaAnser01(item.getKonkaiChosakekkaNo72());
        source.konkaiChosakekkaNo73 = setChosaAnser01(item.getKonkaiChosakekkaNo73());
        source.konkaiChosakekkaNo74 = setChosaAnser01(item.getKonkaiChosakekkaNo74());
        source.konkaiChosakekkaNo75 = item.getKonkaiChosakekkaNo75();
        source.konkaiChosakekkaNo76 = item.getKonkaiChosakekkaNo76();
    }

    private void setTokkiFuraguNo(ChosahyoSaiCheckhyoReportSource source) {
        source.tokkiFuraguNo1 = item.getTokkiFuraguNo1();
        source.tokkiFuraguNo2 = item.getTokkiFuraguNo2();
        source.tokkiFuraguNo3 = item.getTokkiFuraguNo3();
        source.tokkiFuraguNo4 = item.getTokkiFuraguNo4();
        source.tokkiFuraguNo5 = item.getTokkiFuraguNo5();
        source.tokkiFuraguNo6 = item.getTokkiFuraguNo6();
        source.tokkiFuraguNo7 = item.getTokkiFuraguNo7();
        source.tokkiFuraguNo8 = item.getTokkiFuraguNo8();
        source.tokkiFuraguNo9 = item.getTokkiFuraguNo9();
        source.tokkiFuraguNo10 = item.getTokkiFuraguNo10();
        source.tokkiFuraguNo11 = item.getTokkiFuraguNo11();
        source.tokkiFuraguNo12 = item.getTokkiFuraguNo12();
        source.tokkiFuraguNo13 = item.getTokkiFuraguNo13();
        source.tokkiFuraguNo14 = item.getTokkiFuraguNo14();
        source.tokkiFuraguNo15 = item.getTokkiFuraguNo15();
        source.tokkiFuraguNo16 = item.getTokkiFuraguNo16();
        source.tokkiFuraguNo17 = item.getTokkiFuraguNo17();
        source.tokkiFuraguNo18 = item.getTokkiFuraguNo18();
        source.tokkiFuraguNo19 = item.getTokkiFuraguNo19();
        source.tokkiFuraguNo20 = item.getTokkiFuraguNo20();
        source.tokkiFuraguNo21 = item.getTokkiFuraguNo21();
        source.tokkiFuraguNo22 = item.getTokkiFuraguNo22();
        source.tokkiFuraguNo23 = item.getTokkiFuraguNo23();
        source.tokkiFuraguNo24 = item.getTokkiFuraguNo24();
        source.tokkiFuraguNo25 = item.getTokkiFuraguNo25();
        source.tokkiFuraguNo26 = item.getTokkiFuraguNo26();
        source.tokkiFuraguNo27 = item.getTokkiFuraguNo27();
        source.tokkiFuraguNo28 = item.getTokkiFuraguNo28();
        source.tokkiFuraguNo29 = item.getTokkiFuraguNo29();
        source.tokkiFuraguNo30 = item.getTokkiFuraguNo30();
        source.tokkiFuraguNo31 = item.getTokkiFuraguNo31();
        source.tokkiFuraguNo32 = item.getTokkiFuraguNo32();
        source.tokkiFuraguNo33 = item.getTokkiFuraguNo33();
        source.tokkiFuraguNo34 = item.getTokkiFuraguNo34();
        source.tokkiFuraguNo35 = item.getTokkiFuraguNo35();
        source.tokkiFuraguNo36 = item.getTokkiFuraguNo36();
        source.tokkiFuraguNo37 = item.getTokkiFuraguNo37();
        source.tokkiFuraguNo38 = item.getTokkiFuraguNo38();
        source.tokkiFuraguNo39 = item.getTokkiFuraguNo39();
        source.tokkiFuraguNo40 = item.getTokkiFuraguNo40();
        source.tokkiFuraguNo41 = item.getTokkiFuraguNo41();
        source.tokkiFuraguNo42 = item.getTokkiFuraguNo42();
        source.tokkiFuraguNo43 = item.getTokkiFuraguNo43();
        source.tokkiFuraguNo44 = item.getTokkiFuraguNo44();
        source.tokkiFuraguNo45 = item.getTokkiFuraguNo45();
        source.tokkiFuraguNo46 = item.getTokkiFuraguNo46();
        source.tokkiFuraguNo47 = item.getTokkiFuraguNo47();
        source.tokkiFuraguNo48 = item.getTokkiFuraguNo48();
        source.tokkiFuraguNo49 = item.getTokkiFuraguNo49();
        source.tokkiFuraguNo50 = item.getTokkiFuraguNo50();
        source.tokkiFuraguNo51 = item.getTokkiFuraguNo51();
        source.tokkiFuraguNo52 = item.getTokkiFuraguNo52();
        source.tokkiFuraguNo53 = item.getTokkiFuraguNo53();
        source.tokkiFuraguNo54 = item.getTokkiFuraguNo54();
        source.tokkiFuraguNo55 = item.getTokkiFuraguNo55();
        source.tokkiFuraguNo56 = item.getTokkiFuraguNo56();
        source.tokkiFuraguNo57 = item.getTokkiFuraguNo57();
        source.tokkiFuraguNo58 = item.getTokkiFuraguNo58();
        source.tokkiFuraguNo59 = item.getTokkiFuraguNo59();
        source.tokkiFuraguNo60 = item.getTokkiFuraguNo60();
        source.tokkiFuraguNo61 = item.getTokkiFuraguNo61();
        source.tokkiFuraguNo62 = item.getTokkiFuraguNo62();
        source.tokkiFuraguNo63 = item.getTokkiFuraguNo63();
        source.tokkiFuraguNo64 = item.getTokkiFuraguNo64();
        source.tokkiFuraguNo65 = item.getTokkiFuraguNo65();
        source.tokkiFuraguNo66 = item.getTokkiFuraguNo66();
        source.tokkiFuraguNo67 = item.getTokkiFuraguNo67();
        source.tokkiFuraguNo68 = item.getTokkiFuraguNo68();
        source.tokkiFuraguNo69 = item.getTokkiFuraguNo69();
        source.tokkiFuraguNo70 = item.getTokkiFuraguNo70();
        source.tokkiFuraguNo71 = item.getTokkiFuraguNo71();
        source.tokkiFuraguNo72 = item.getTokkiFuraguNo72();
        source.tokkiFuraguNo73 = item.getTokkiFuraguNo73();
        source.tokkiFuraguNo74 = item.getTokkiFuraguNo74();
        source.tokkiFuraguNo75 = item.getTokkiFuraguNo75();
        source.tokkiFuraguNo76 = item.getTokkiFuraguNo76();
    }

    private RString setChosaAnser01(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (ChosaAnser01.あり.getコード().equals(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser01.あり.get名称();
        } else if (ChosaAnser01.なし.getコード().equals(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser01.なし.get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser02(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser02.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser03(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser03.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser04(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser04.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser06(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser06.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser07(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser07.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser08(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser08.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser09(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser09.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser10(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser10.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser11(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser11.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser12(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser12.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser13(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser13.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser14(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser14.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser15(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser15.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString setChosaAnser16(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (ChosaAnser16.ある.getコード().equals(chosakekkaNo)) {
            chosaAnser = ChosaAnser16.ある.get名称();
        } else if (ChosaAnser16.ない.getコード().equals(chosakekkaNo)) {
            chosaAnser = ChosaAnser16.ない.get名称();
        } else if (ChosaAnser16.ときどきある.getコード().equals(chosakekkaNo)) {
            chosaAnser = ChosaAnser16.ときどきある.get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser17(RString zenkaiChosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(zenkaiChosakekkaNo)) {
            chosaAnser = ChosaAnser17.toValue(zenkaiChosakekkaNo).get名称();
        }
        return chosaAnser;
    }
}
