/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerProperty;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Printerです。
 *
 * @reamsid_L DBC-1000-130 zhangzhiming
 */
public class ShokanKetteiTsuchiShoSealerService {

    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）を印刷します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShokanKetteiTsuchiShoSealer> itemList) {

        ShokanKetteiTsuchiShoSealerProperty property = new ShokanKetteiTsuchiShoSealerProperty();
        return new Printer<ShokanKetteiTsuchiShoSealerReportSource>().spool(property, toReports(itemList));
    }

    private static List<ShokanKetteiTsuchiShoSealerReport> toReports(List<ShokanKetteiTsuchiShoSealer> itemList) {
        List<ShokanKetteiTsuchiShoSealerReport> list = new ArrayList<>();
        List<ShokanKetteiTsuchiShoSealerItem> item1list = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealer item : itemList) {
            item1list.add(setShokanKetteiTsuchiShoSealerReport(item));
        }
        list.add(ShokanKetteiTsuchiShoSealerReport.createFrom(item1list));
        return list;
    }

    private static ShokanKetteiTsuchiShoSealerItem
            setShokanKetteiTsuchiShoSealerReport(ShokanKetteiTsuchiShoSealer item) {

        return new ShokanKetteiTsuchiShoSealerItem(
                item.getTsuban(),
                item.getTitle1(),
                item.getBunshoNo(),
                item.getPage(),
                item.getPages(),
                item.getTitle(),
                item.getTitle2(),
                item.getHihokenshaName2(),
                item.getHihokenshaNo(),
                item.getHihokenshaName(),
                item.getTsuchibun1(),
                item.getKetteiYMD(),
                item.getShiharaiGaku(),
                item.getShiharaiYoteiYMD(),
                item.getKyufuShurui1(),
                item.getTaishoYM1(),
                item.getShikyuGaku1(),
                item.getYen1(),
                item.getInfo(),
                item.getKyufuShurui2(),
                item.getTaishoYM2(),
                item.getShikyuGaku2(),
                item.getYen2(),
                item.getKyufuShurui3(),
                item.getTaishoYM3(),
                item.getShikyuGaku3(),
                item.getYen3(),
                item.getKyufuShurui4(),
                item.getTaishoYM4(),
                item.getShikyuGaku4(),
                item.getYen4(),
                item.getBankName(),
                item.getBranchBankName(),
                item.getShumokuTitle(),
                item.getKouzaShu(),
                item.getBangoTitle(),
                item.getKouzaNo(),
                item.getKouzaMeigi(),
                item.getHakkoYMD(),
                item.getDenshiKoin(),
                item.getNinshoshaYakushokuMei(),
                item.getNinshoshaYakushokuMei1(),
                item.getKoinMojiretsu(),
                item.getNinshoshaYakushokuMei2(),
                item.getNinshoshaShimeiKakenai(),
                item.getNinshoshaShimeiKakeru(),
                item.getKoinShoryaku(),
                item.getYubinNo(),
                item.getGyoseiku1(),
                item.getJusho4(),
                item.getJushoText(),
                item.getJusho5(),
                item.getJusho6(),
                item.getKatagakiText(),
                item.getKatagaki3(),
                item.getKatagakiSmall2(),
                item.getKatagaki4(),
                item.getKatagakiSmall1(),
                item.getShimei5(),
                item.getShimeiSmall2(),
                item.getShimeiText(),
                item.getMeishoFuyo2(),
                item.getShimeiSmall1(),
                item.getDainoKubunMei(),
                item.getShimei6(),
                item.getMeishoFuyo1(),
                item.getSamabunShimeiText(),
                item.getSamaBun2(),
                item.getKakkoLeft2(),
                item.getSamabunShimei2(),
                item.getSamabunShimeiSmall2(),
                item.getKakkoRight2(),
                item.getKakkoLeft1(),
                item.getSamabunShimei1(),
                item.getSamaBun1(),
                item.getKakkoRight1(),
                item.getSamabunShimeiSmall1(),
                item.getCustomerBarCode());
    }
}
