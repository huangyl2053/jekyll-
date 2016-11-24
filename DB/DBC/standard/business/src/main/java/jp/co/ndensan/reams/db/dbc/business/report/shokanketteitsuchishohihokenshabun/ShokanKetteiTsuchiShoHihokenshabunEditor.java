/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）Editorです。
 *
 * @reamsid_L DBC-1000-120 zuotao
 */
public class ShokanKetteiTsuchiShoHihokenshabunEditor implements IShokanKetteiTsuchiShoHihokenshabunEditor {

    private final ShokanKetteiTsuchiShoHihokenshabunItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanKetteiTsuchiShoHihokenshabunItem}
     */
    protected ShokanKetteiTsuchiShoHihokenshabunEditor(ShokanKetteiTsuchiShoHihokenshabunItem item) {
        this.item = item;
    }

    @Override
    public ShokanKetteiTsuchiShoHihokenshabunReportSource edit(ShokanKetteiTsuchiShoHihokenshabunReportSource source) {
        return editSource(source);
    }

    private ShokanKetteiTsuchiShoHihokenshabunReportSource editSource(ShokanKetteiTsuchiShoHihokenshabunReportSource source) {

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
        if (item.getHonninShiharaiGaku() != null && !item.getHonninShiharaiGaku().isEmpty()) {
            source.honninShiharaiGaku = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getHonninShiharaiGaku().toString()), 0);
        }
        source.taishoYM = item.getTaishoYM();
        source.kyufuShu1 = item.getKyufuShu1();
        source.kyufuShu2 = item.getKyufuShu2();
        source.kyufuShu3 = item.getKyufuShu3();
        source.kekka = item.getKekka();
        if (item.getShikyuGaku() != null && !item.getShikyuGaku().isEmpty()) {
            source.shikyuGaku = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getShikyuGaku().toString()), 0);
        }
        source.riyu1 = item.getRiyu1();
        source.riyuTitle = item.getRiyuTitle();
        source.riyu2 = item.getRiyu2();
        source.riyu3 = item.getRiyu3();
        source.jigyoshoName = item.getJigyoshoName();
        source.daihyoshaName = item.getDaihyoshaName();
        source.jigyoshoYubinNo = item.getJigyoshoYubinNo();
        source.jigyoshoJusho = item.getJigyoshoJusho();
        source.jigyoshoTelNo = item.getJigyoshoTelNo();
        source.tsuchibun2 = item.getTsuchibun2();
        source.seirino = item.getSeirino();
        source.tsuchino = item.getTsuchino();
        source.remban = item.getRemban();
        source.tsuchibunLarge = item.getTsuchibunLarge3();
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
