/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Editorです。
 *
 * @reamsid_L DBC-1000-130 zhangzhiming
 */
public class ShokanKetteiTsuchiShoSealerEditor implements IShokanKetteiTsuchiShoSealerEditor {

    private final ShokanKetteiTsuchiShoSealerItem item;
    private static final int 結束_位置10 = 10;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem}
     */
    protected ShokanKetteiTsuchiShoSealerEditor(ShokanKetteiTsuchiShoSealerItem item) {
        this.item = item;
    }

    @Override
    public ShokanKetteiTsuchiShoSealerReportSource edit(ShokanKetteiTsuchiShoSealerReportSource source) {
        return editSource(source);
    }

    private ShokanKetteiTsuchiShoSealerReportSource editSource(ShokanKetteiTsuchiShoSealerReportSource source) {
        source.tsuban = item.getTsuban();
        source.title1 = item.getTitle1();
        source.bunshoNo = item.getBunshoNo();
        source.page = item.getPage();
        source.pages = item.getPages();
        source.ｔｉtle = item.getTitle();
        source.ｔｉtle2 = item.getTitle2();
        source.hihokenshaName2 = item.getHihokenshaName2();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.tsuchibun = item.getTsuchibun1();
        source.ketteiYMD = item.getKetteiYMD();
        RString shiharaiGaku = item.getShiharaiGaku();
        if (item.getShiharaiGaku() == null) {
            shiharaiGaku = RString.EMPTY;
        }
        if (shiharaiGaku.length() < 結束_位置10) {
            shiharaiGaku = shiharaiGaku.padLeft(RString.HALF_SPACE, 結束_位置10);
        }
        source.shiharaiGaku = shiharaiGaku;
        source.shiharaiYoteiYMD = item.getShiharaiYoteiYMD();
        source.kyufuShurui1 = item.getKyufuShurui1();
        source.taishoYM1 = item.getTaishoYM1();
        if (item.getShikyuGaku1() != null && !item.getShikyuGaku1().isEmpty()) {
            source.shikyuGaku1 = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getShikyuGaku1().toString()), 0);
        }
        source.yen1 = item.getYen1();
        source.info = item.getInfo();
        source.kyufuShurui2 = item.getKyufuShurui2();
        source.taishoYM2 = item.getTaishoYM2();
        if (item.getShikyuGaku2() != null && !item.getShikyuGaku2().isEmpty()) {
            source.shikyuGaku2 = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getShikyuGaku2().toString()), 0);
        }
        source.yen2 = item.getYen2();
        source.kyufuShurui3 = item.getKyufuShurui3();
        source.taishoYM3 = item.getTaishoYM3();
        if (item.getShikyuGaku3() != null && !item.getShikyuGaku3().isEmpty()) {
            source.shikyuGaku3 = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getShikyuGaku3().toString()), 0);
        }
        source.yen3 = item.getYen3();
        source.kyufuShurui4 = item.getKyufuShurui4();
        source.taishoYM4 = item.getTaishoYM4();
        if (item.getShikyuGaku4() != null && !item.getShikyuGaku4().isEmpty()) {
            source.shikyuGaku4 = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getShikyuGaku4().toString()), 0);
        }
        source.yen4 = item.getYen4();
        source.bankName = item.getBankName();
        source.branchBankName = item.getBranchBankName();
        source.shumokuTitle = item.getShumokuTitle();
        source.kouzaShu = item.getKouzaShu();
        source.bangoTitle = item.getBangoTitle();
        source.kouzaNo = item.getKouzaNo();
        source.kouzaMeigi = item.getKouzaMeigi();
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
        source.gyoseiku2 = item.getGyoseiku1();
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
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
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
