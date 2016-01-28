/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource;

/**
 * 償還払い支給（不支給）決定通知書のEditorです。
 */
class ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor implements IShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor {

    private final ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem}
     */
    protected ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem item) {
        this.item = item;
    }

    @Override
    public ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource edit(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource source) {
        return editSource(source);
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource editSource(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        source.title = item.getTitle();
        source.title2_1 = item.getTitle2_1();
        source.title2_2_1 = item.getTitle2_2_1();
        source.title2_2_2 = item.getTitle2_2_2();
        source.title2_3_1 = item.getTitle2_3_1();
        source.title2_3_2 = item.getTitle2_3_2();
        source.title2_4 = item.getTitle2_4();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaName = item.getHihokenshaName();
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
        source.uketsukeYMD = item.getUketsukeYMD();
        source.ketteiYMD = item.getKetteiYMD();
        source.honninShiharaiGaku = item.getHonninShiharaiGaku();
        source.taishoYM = item.getTaishoYM();
        source.kyufuShu1 = item.getKyufuShu1();
        source.kyufuShu2 = item.getKyufuShu2();
        source.kyufuShu3 = item.getKyufuShu3();
        source.kekka = item.getKekka();
        source.shikyuGaku = item.getShikyuGaku();
        source.riyu1 = item.getRiyu1();
        source.riyuTitle = item.getRiyuTitle();
        source.riyu2 = item.getRiyu2();
        source.riyu3 = item.getRiyu3();
        source.torikeshi1 = item.getTorikeshi1();
        source.torikeshi2 = item.getTorikeshi2();
        source.bankName = item.getBankName();
        source.mochimono1 = item.getMochimono1();
        source.torikeshiMochimono1 = item.getTorikeshiMochimono1();
        source.branchBankName = item.getBranchBankName();
        source.mochimono2 = item.getMochimono2();
        source.torikeshiMochimono2 = item.getTorikeshiMochimono2();
        source.mochimono3 = item.getMochimono3();
        source.shiharaiBasho = item.getShiharaiBasho();
        source.torikeshiShiharaibasho = item.getTorikeshiShiharaibasho();
        source.shumokuTitle = item.getShumokuTitle();
        source.kouzaShu = item.getKouzaShu();
        source.bangoTitle = item.getBangoTitle();
        source.kouzaNo = item.getKouzaNo();
        source.shiharaiStartYMD = item.getShiharaiStartYMD();
        source.kouzaMeigi = item.getKouzaMeigi();
        source.torikeshiShiharaikikan = item.getTorikeshiShiharaikikan();
        source.shiharaiEndYMD = item.getShiharaiEndYMD();
        source.karaFugo = item.getKaraFugo();
        source.shiharaiStartHMS = item.getShiharaiStartHMS();
        source.shiharaiEndHMS = item.getShiharaiEndHMS();
        source.tsuchibun2 = item.getTsuchibun2();
        source.seirino = item.getSeirino();
        source.tsuchino = item.getTsuchino();
        source.remban = item.getRemban();
        source.tsuchibunLarge = item.getTsuchibunLarge();
        source.tsuchibunMix1 = item.getTsuchibunMix1();
        source.tsuchibunMix2 = item.getTsuchibunMix2();
        source.tsuchibunMixTwo1 = item.getTsuchibunMixtwo1();
        source.tsuchibunMixTwo2 = item.getTsuchibunMixtwo2();
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo = item.getYubinNo();
        source.gyoseiku2 = item.getGyoseiku2();
        source.jusho4 = item.getJusho4();
        source.jushoText = item.getJushoText();
        source.jusho5 = item.getJusho5();
        source.jusho6 = item.getJusho6();
        source.katagakiText = item.getKatagakiText();
        source.katagaki3 = item.getKatagaki3();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.katagaki4 = item.getKatagaki4();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.shimei5 = item.getShimei5();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.shimei6 = item.getShimei6();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoRight2 = item.getKakkoRight2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samaBun1 = item.getSamaBun1();
        source.kakkoRight1 = item.getKakkoRight1();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.customerBarCode = item.getCustomerBarCode();
        return source;
    }
}
