/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaisho;

import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定調査依頼書ヘッダEditorです。
 *
 * @reamsid_L DBE-0010-020 lishengli
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
        if (RString.isNullOrEmpty(item.getHakkoYMD1())) {
            source.hakkoYMD1 = RString.EMPTY;
        } else {
            source.hakkoYMD1 = パターン12(new RDate(item.getHakkoYMD1().toString()));
        }
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.koinShoryaku = item.getKoinShoryaku();
        source.bunshoNo = item.getBunshoNo();
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.sonota = item.getSonota();
        source.customerBarCode = item.getCustomerBarCode();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
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
            source.birthYMD = 生年月日_パターン12(new RDate(item.getBirthYMD().toString()));
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
        source.homonChosasakiJusho = item.getHomonChosasakiJusho();
        source.homonChosasakiName = item.getHomonChosasakiJushoName();
        source.homonChosasakiTelNo = item.getHomonChosasakiTelNo();
        if (item.getShinseiYMD().isNullOrEmpty()) {
            source.shinseiYMD = RString.EMPTY;
        } else {
            source.shinseiYMD = パターン12(new RDate(item.getShinseiYMD().toString()));
        }
        if (item.getTeishutsuKigen().isNullOrEmpty()) {
            source.teishutsuKigen = RString.EMPTY;
        } else {
            source.teishutsuKigen = パターン12(new RDate(item.getTeishutsuKigen().toString()));
        }
        source.tsuchibun2 = item.getTsuchibun2();
        return source;
    }

    private RString パターン12(RDate rDate) {
        return rDate.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString 生年月日_パターン12(RDate rDate) {
        RString 生年月日 = rDate.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        return 生年月日.substring(2, 生年月日.length());
    }
}
