/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 前回認定調査結果との比較表Editorです。
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
        source.PageCount = item.getPageCount();
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
        if (NinteichosaKomoku09B.麻痺等の有無.get名称1().equals(NinteichosaKomoku09B.toValueCode(item.getZenkaiChosakekkaNo1()).get名称1())) {

        }
        source.zenkaiChosakekkaNo1 = item.getZenkaiChosakekkaNo1();
        source.konkaiChosakekkaNo1 = item.getKonkaiChosakekkaNo1();
        source.tokkiFuraguNo1 = item.getTokkiFuraguNo1();
        source.zenkaiChosakekkaNo42 = item.getZenkaiChosakekkaNo42();
        source.konkaiChosakekkaNo42 = item.getKonkaiChosakekkaNo42();
        source.tokkiFuraguNo42 = item.getTokkiFuraguNo42();
        source.zenkaiChosakekkaNo2 = item.getZenkaiChosakekkaNo2();
        source.konkaiChosakekkaNo2 = item.getKonkaiChosakekkaNo2();
        source.tokkiFuraguNo2 = item.getTokkiFuraguNo2();
        source.zenkaiChosakekkaNo43 = item.getZenkaiChosakekkaNo43();
        source.konkaiChosakekkaNo43 = item.getKonkaiChosakekkaNo43();
        source.tokkiFuraguNo43 = item.getTokkiFuraguNo43();
        source.zenkaiChosakekkaNo3 = item.getZenkaiChosakekkaNo3();
        source.konkaiChosakekkaNo3 = item.getKonkaiChosakekkaNo3();
        source.tokkiFuraguNo3 = item.getTokkiFuraguNo3();
        source.zenkaiChosakekkaNo44 = item.getZenkaiChosakekkaNo44();
        source.konkaiChosakekkaNo44 = item.getKonkaiChosakekkaNo44();
        source.tokkiFuraguNo44 = item.getTokkiFuraguNo44();
        source.zenkaiChosakekkaNo4 = item.getZenkaiChosakekkaNo4();
        source.konkaiChosakekkaNo4 = item.getKonkaiChosakekkaNo4();
        source.tokkiFuraguNo4 = item.getTokkiFuraguNo4();
        source.zenkaiChosakekkaNo45 = item.getZenkaiChosakekkaNo45();
        source.konkaiChosakekkaNo45 = item.getKonkaiChosakekkaNo45();
        source.tokkiFuraguNo45 = item.getTokkiFuraguNo45();
        source.zenkaiChosakekkaNo5 = item.getZenkaiChosakekkaNo5();
        source.konkaiChosakekkaNo5 = item.getKonkaiChosakekkaNo5();
        source.tokkiFuraguNo5 = item.getTokkiFuraguNo5();
        source.zenkaiChosakekkaNo46 = item.getZenkaiChosakekkaNo46();
        source.konkaiChosakekkaNo46 = item.getKonkaiChosakekkaNo46();
        source.tokkiFuraguNo46 = item.getTokkiFuraguNo46();
        source.zenkaiChosakekkaNo6 = item.getZenkaiChosakekkaNo6();
        source.konkaiChosakekkaNo6 = item.getKonkaiChosakekkaNo6();
        source.tokkiFuraguNo6 = item.getTokkiFuraguNo6();
        source.zenkaiChosakekkaNo47 = item.getZenkaiChosakekkaNo47();
        source.konkaiChosakekkaNo47 = item.getKonkaiChosakekkaNo47();
        source.tokkiFuraguNo47 = item.getTokkiFuraguNo47();
        source.zenkaiChosakekkaNo7 = item.getZenkaiChosakekkaNo7();
        source.konkaiChosakekkaNo7 = item.getKonkaiChosakekkaNo7();
        source.tokkiFuraguNo7 = item.getTokkiFuraguNo7();
        source.zenkaiChosakekkaNo48 = item.getZenkaiChosakekkaNo48();
        source.konkaiChosakekkaNo48 = item.getKonkaiChosakekkaNo48();
        source.tokkiFuraguNo48 = item.getTokkiFuraguNo48();
        source.zenkaiChosakekkaNo8 = item.getZenkaiChosakekkaNo8();
        source.konkaiChosakekkaNo8 = item.getKonkaiChosakekkaNo8();
        source.tokkiFuraguNo8 = item.getTokkiFuraguNo8();
        source.zenkaiChosakekkaNo49 = item.getZenkaiChosakekkaNo49();
        source.konkaiChosakekkaNo49 = item.getKonkaiChosakekkaNo49();
        source.tokkiFuraguNo49 = item.getTokkiFuraguNo49();
        source.zenkaiChosakekkaNo9 = item.getZenkaiChosakekkaNo9();
        source.konkaiChosakekkaNo9 = item.getKonkaiChosakekkaNo9();
        source.tokkiFuraguNo9 = item.getTokkiFuraguNo9();
        source.zenkaiChosakekkaNo50 = item.getZenkaiChosakekkaNo50();
        source.konkaiChosakekkaNo50 = item.getKonkaiChosakekkaNo50();
        source.tokkiFuraguNo50 = item.getTokkiFuraguNo50();
        source.zenkaiChosakekkaNo10 = item.getZenkaiChosakekkaNo10();
        source.konkaiChosakekkaNo10 = item.getKonkaiChosakekkaNo10();
        source.tokkiFuraguNo10 = item.getTokkiFuraguNo10();
        source.zenkaiChosakekkaNo51 = item.getZenkaiChosakekkaNo51();
        source.konkaiChosakekkaNo51 = item.getKonkaiChosakekkaNo51();
        source.tokkiFuraguNo51 = item.getTokkiFuraguNo51();
        source.zenkaiChosakekkaNo11 = item.getZenkaiChosakekkaNo11();
        source.konkaiChosakekkaNo11 = item.getKonkaiChosakekkaNo11();
        source.tokkiFuraguNo11 = item.getTokkiFuraguNo11();
        source.zenkaiChosakekkaNo52 = item.getZenkaiChosakekkaNo52();
        source.konkaiChosakekkaNo52 = item.getKonkaiChosakekkaNo52();
        source.tokkiFuraguNo52 = item.getTokkiFuraguNo52();
        source.zenkaiChosakekkaNo12 = item.getZenkaiChosakekkaNo12();
        source.konkaiChosakekkaNo12 = item.getKonkaiChosakekkaNo12();
        source.tokkiFuraguNo12 = item.getTokkiFuraguNo12();
        source.zenkaiChosakekkaNo53 = item.getZenkaiChosakekkaNo53();
        source.konkaiChosakekkaNo53 = item.getKonkaiChosakekkaNo53();
        source.tokkiFuraguNo53 = item.getTokkiFuraguNo53();
        source.zenkaiChosakekkaNo13 = item.getZenkaiChosakekkaNo13();
        source.konkaiChosakekkaNo13 = item.getKonkaiChosakekkaNo13();
        source.tokkiFuraguNo13 = item.getTokkiFuraguNo13();
        source.zenkaiChosakekkaNo54 = item.getZenkaiChosakekkaNo54();
        source.konkaiChosakekkaNo54 = item.getKonkaiChosakekkaNo54();
        source.tokkiFuraguNo54 = item.getTokkiFuraguNo54();
        source.zenkaiChosakekkaNo14 = item.getZenkaiChosakekkaNo14();
        source.konkaiChosakekkaNo14 = item.getKonkaiChosakekkaNo14();
        source.tokkiFuraguNo14 = item.getTokkiFuraguNo14();
        source.zenkaiChosakekkaNo55 = item.getZenkaiChosakekkaNo55();
        source.konkaiChosakekkaNo55 = item.getKonkaiChosakekkaNo55();
        source.tokkiFuraguNo55 = item.getTokkiFuraguNo55();
        source.zenkaiChosakekkaNo15 = item.getZenkaiChosakekkaNo15();
        source.konkaiChosakekkaNo15 = item.getKonkaiChosakekkaNo15();
        source.tokkiFuraguNo15 = item.getTokkiFuraguNo15();
        source.zenkaiChosakekkaNo56 = item.getZenkaiChosakekkaNo56();
        source.konkaiChosakekkaNo56 = item.getKonkaiChosakekkaNo56();
        source.tokkiFuraguNo56 = item.getTokkiFuraguNo56();
        source.zenkaiChosakekkaNo16 = item.getZenkaiChosakekkaNo16();
        source.konkaiChosakekkaNo16 = item.getKonkaiChosakekkaNo16();
        source.tokkiFuraguNo16 = item.getTokkiFuraguNo16();
        source.zenkaiChosakekkaNo17 = item.getZenkaiChosakekkaNo17();
        source.konkaiChosakekkaNo17 = item.getKonkaiChosakekkaNo17();
        source.tokkiFuraguNo17 = item.getTokkiFuraguNo17();
        source.zenkaiChosakekkaNo18 = item.getZenkaiChosakekkaNo18();
        source.konkaiChosakekkaNo18 = item.getKonkaiChosakekkaNo18();
        source.tokkiFuraguNo18 = item.getTokkiFuraguNo18();
        source.zenkaiChosakekkaNo57 = item.getZenkaiChosakekkaNo57();
        source.konkaiChosakekkaNo57 = item.getKonkaiChosakekkaNo57();
        source.tokkiFuraguNo57 = item.getTokkiFuraguNo57();
        source.zenkaiChosakekkaNo19 = item.getZenkaiChosakekkaNo19();
        source.konkaiChosakekkaNo19 = item.getKonkaiChosakekkaNo19();
        source.tokkiFuraguNo19 = item.getTokkiFuraguNo19();
        source.tokkiFuraguNo58 = item.getTokkiFuraguNo58();
        source.zenkaiChosakekkaNo58 = item.getZenkaiChosakekkaNo58();
        source.konkaiChosakekkaNo58 = item.getKonkaiChosakekkaNo58();
        source.zenkaiChosakekkaNo20 = item.getZenkaiChosakekkaNo20();
        source.konkaiChosakekkaNo20 = item.getKonkaiChosakekkaNo20();

        source.tokkiFuraguNo20 = item.getTokkiFuraguNo20();
        source.tokkiFuraguNo59 = item.getTokkiFuraguNo59();
        source.zenkaiChosakekkaNo59 = item.getZenkaiChosakekkaNo59();
        source.konkaiChosakekkaNo59 = item.getKonkaiChosakekkaNo59();
        source.tokkiFuraguNo60 = item.getTokkiFuraguNo60();
        source.zenkaiChosakekkaNo60 = item.getZenkaiChosakekkaNo60();
        source.konkaiChosakekkaNo60 = item.getKonkaiChosakekkaNo60();
        source.tokkiFuraguNo61 = item.getTokkiFuraguNo61();
        source.zenkaiChosakekkaNo61 = item.getZenkaiChosakekkaNo61();
        source.konkaiChosakekkaNo61 = item.getKonkaiChosakekkaNo61();
        source.zenkaiChosakekkaNo21 = item.getZenkaiChosakekkaNo21();
        source.konkaiChosakekkaNo21 = item.getKonkaiChosakekkaNo21();
        source.tokkiFuraguNo21 = item.getTokkiFuraguNo21();
        source.zenkaiChosakekkaNo62 = item.getZenkaiChosakekkaNo62();
        source.konkaiChosakekkaNo62 = item.getKonkaiChosakekkaNo62();
        source.tokkiFuraguNo62 = item.getTokkiFuraguNo62();
        source.zenkaiChosakekkaNo22 = item.getZenkaiChosakekkaNo22();
        source.konkaiChosakekkaNo22 = item.getKonkaiChosakekkaNo22();
        source.tokkiFuraguNo22 = item.getTokkiFuraguNo22();
        source.zenkaiChosakekkaNo23 = item.getZenkaiChosakekkaNo23();
        source.konkaiChosakekkaNo23 = item.getKonkaiChosakekkaNo23();
        source.tokkiFuraguNo23 = item.getTokkiFuraguNo23();
        source.zenkaiChosakekkaNo24 = item.getZenkaiChosakekkaNo24();
        source.konkaiChosakekkaNo24 = item.getKonkaiChosakekkaNo24();
        source.tokkiFuraguNo24 = item.getTokkiFuraguNo24();
        source.zenkaiChosakekkaNo63 = item.getZenkaiChosakekkaNo63();
        source.konkaiChosakekkaNo63 = item.getKonkaiChosakekkaNo63();
        source.tokkiFuraguNo63 = item.getTokkiFuraguNo63();
        source.zenkaiChosakekkaNo25 = item.getZenkaiChosakekkaNo25();
        source.konkaiChosakekkaNo25 = item.getKonkaiChosakekkaNo25();
        source.tokkiFuraguNo25 = item.getTokkiFuraguNo25();
        source.zenkaiChosakekkaNo64 = item.getZenkaiChosakekkaNo64();
        source.konkaiChosakekkaNo64 = item.getKonkaiChosakekkaNo64();
        source.tokkiFuraguNo64 = item.getTokkiFuraguNo64();
        source.zenkaiChosakekkaNo26 = item.getZenkaiChosakekkaNo26();
        source.konkaiChosakekkaNo26 = item.getKonkaiChosakekkaNo26();
        source.tokkiFuraguNo26 = item.getTokkiFuraguNo26();
        source.zenkaiChosakekkaNo65 = item.getZenkaiChosakekkaNo65();
        source.konkaiChosakekkaNo65 = item.getKonkaiChosakekkaNo65();
        source.tokkiFuraguNo65 = item.getTokkiFuraguNo65();
        source.zenkaiChosakekkaNo27 = item.getZenkaiChosakekkaNo27();
        source.konkaiChosakekkaNo27 = item.getKonkaiChosakekkaNo27();
        source.tokkiFuraguNo27 = item.getTokkiFuraguNo27();
        source.zenkaiChosakekkaNo66 = item.getZenkaiChosakekkaNo66();
        source.konkaiChosakekkaNo66 = item.getKonkaiChosakekkaNo66();
        source.tokkiFuraguNo66 = item.getTokkiFuraguNo66();
        source.zenkaiChosakekkaNo28 = item.getZenkaiChosakekkaNo28();
        source.konkaiChosakekkaNo28 = item.getKonkaiChosakekkaNo28();
        source.tokkiFuraguNo28 = item.getTokkiFuraguNo28();
        source.zenkaiChosakekkaNo67 = item.getZenkaiChosakekkaNo67();
        source.konkaiChosakekkaNo67 = item.getKonkaiChosakekkaNo67();
        source.tokkiFuraguNo67 = item.getTokkiFuraguNo67();
        source.zenkaiChosakekkaNo29 = item.getZenkaiChosakekkaNo29();
        source.konkaiChosakekkaNo29 = item.getKonkaiChosakekkaNo29();
        source.tokkiFuraguNo29 = item.getTokkiFuraguNo29();
        source.zenkaiChosakekkaNo68 = item.getZenkaiChosakekkaNo68();
        source.konkaiChosakekkaNo68 = item.getKonkaiChosakekkaNo68();
        source.tokkiFuraguNo68 = item.getTokkiFuraguNo68();
        source.zenkaiChosakekkaNo30 = item.getZenkaiChosakekkaNo30();
        source.konkaiChosakekkaNo30 = item.getKonkaiChosakekkaNo30();
        source.tokkiFuraguNo30 = item.getTokkiFuraguNo30();
        source.zenkaiChosakekkaNo69 = item.getZenkaiChosakekkaNo69();
        source.konkaiChosakekkaNo69 = item.getKonkaiChosakekkaNo69();
        source.tokkiFuraguNo69 = item.getTokkiFuraguNo69();
        source.zenkaiChosakekkaNo31 = item.getZenkaiChosakekkaNo31();
        source.konkaiChosakekkaNo31 = item.getKonkaiChosakekkaNo31();
        source.tokkiFuraguNo31 = item.getTokkiFuraguNo31();
        source.zenkaiChosakekkaNo70 = item.getZenkaiChosakekkaNo70();
        source.konkaiChosakekkaNo70 = item.getKonkaiChosakekkaNo70();
        source.tokkiFuraguNo70 = item.getTokkiFuraguNo70();
        source.zenkaiChosakekkaNo32 = item.getZenkaiChosakekkaNo32();
        source.konkaiChosakekkaNo32 = item.getKonkaiChosakekkaNo32();
        source.tokkiFuraguNo32 = item.getTokkiFuraguNo32();
        source.zenkaiChosakekkaNo71 = item.getZenkaiChosakekkaNo71();
        source.konkaiChosakekkaNo71 = item.getKonkaiChosakekkaNo71();
        source.tokkiFuraguNo71 = item.getTokkiFuraguNo71();
        source.zenkaiChosakekkaNo72 = item.getZenkaiChosakekkaNo72();
        source.konkaiChosakekkaNo72 = item.getKonkaiChosakekkaNo72();
        source.tokkiFuraguNo72 = item.getTokkiFuraguNo72();
        source.zenkaiChosakekkaNo73 = item.getZenkaiChosakekkaNo73();
        source.konkaiChosakekkaNo73 = item.getKonkaiChosakekkaNo73();
        source.tokkiFuraguNo73 = item.getTokkiFuraguNo73();
        source.zenkaiChosakekkaNo33 = item.getZenkaiChosakekkaNo33();
        source.konkaiChosakekkaNo33 = item.getKonkaiChosakekkaNo33();
        source.tokkiFuraguNo33 = item.getTokkiFuraguNo33();
        source.zenkaiChosakekkaNo74 = item.getZenkaiChosakekkaNo74();
        source.konkaiChosakekkaNo74 = item.getKonkaiChosakekkaNo74();
        source.tokkiFuraguNo74 = item.getTokkiFuraguNo74();
        source.zenkaiChosakekkaNo34 = item.getZenkaiChosakekkaNo34();
        source.konkaiChosakekkaNo34 = item.getKonkaiChosakekkaNo34();
        source.tokkiFuraguNo34 = item.getTokkiFuraguNo34();
        source.zenkaiChosakekkaNo35 = item.getZenkaiChosakekkaNo35();
        source.konkaiChosakekkaNo35 = item.getKonkaiChosakekkaNo35();
        source.tokkiFuraguNo35 = item.getTokkiFuraguNo35();
        source.zenkaiChosakekkaNo36 = item.getZenkaiChosakekkaNo36();
        source.konkaiChosakekkaNo36 = item.getKonkaiChosakekkaNo36();
        source.tokkiFuraguNo36 = item.getTokkiFuraguNo36();
        source.zenkaiChosakekkaNo75 = item.getZenkaiChosakekkaNo75();
        source.konkaiChosakekkaNo75 = item.getKonkaiChosakekkaNo75();
        source.tokkiFuraguNo75 = item.getTokkiFuraguNo75();
        source.zenkaiChosakekkaNo37 = item.getZenkaiChosakekkaNo37();
        source.konkaiChosakekkaNo37 = item.getKonkaiChosakekkaNo37();
        source.tokkiFuraguNo37 = item.getTokkiFuraguNo37();
        source.zenkaiChosakekkaNo76 = item.getZenkaiChosakekkaNo76();
        source.konkaiChosakekkaNo76 = item.getKonkaiChosakekkaNo76();
        source.tokkiFuraguNo76 = item.getTokkiFuraguNo76();
        source.zenkaiChosakekkaNo38 = item.getZenkaiChosakekkaNo38();
        source.konkaiChosakekkaNo38 = item.getKonkaiChosakekkaNo38();
        source.tokkiFuraguNo38 = item.getTokkiFuraguNo38();
        source.zenkaiChosakekkaNo39 = item.getZenkaiChosakekkaNo39();
        source.konkaiChosakekkaNo39 = item.getKonkaiChosakekkaNo39();
        source.tokkiFuraguNo39 = item.getTokkiFuraguNo39();
        source.zenkaiChosakekkaNo40 = item.getZenkaiChosakekkaNo40();
        source.konkaiChosakekkaNo40 = item.getKonkaiChosakekkaNo40();
        source.tokkiFuraguNo40 = item.getTokkiFuraguNo40();
        source.zenkaiChosakekkaNo41 = item.getZenkaiChosakekkaNo41();
        source.konkaiChosakekkaNo41 = item.getKonkaiChosakekkaNo41();
        source.tokkiFuraguNo41 = item.getTokkiFuraguNo41();
        return source;
    }
}
