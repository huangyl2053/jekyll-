/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishosealer;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Item;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Property;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Report;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）Printerです。
 *
 * @reamsid_L DBC-1000-140 hezhenzhen
 *
 */
public class ShokanKetteiTsuchiShoSealer2Service {

    /**
     * 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）を印刷します。
     *
     * @param itemList 償還払支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShokanKetteiTsuchiShoSealer> itemList) {
        ShokanKetteiTsuchiShoSealer2Property property = new ShokanKetteiTsuchiShoSealer2Property();
        return new Printer<ShokanKetteiTsuchiShoSealer2ReportSource>().spool(property, toReports(itemList));
    }

    private static List<ShokanKetteiTsuchiShoSealer2Report> toReports(List<ShokanKetteiTsuchiShoSealer> itemList) {
        List<ShokanKetteiTsuchiShoSealer2Report> list = new ArrayList<>();
        List<ShokanKetteiTsuchiShoSealer2Item> item2list = new ArrayList<>();
        for (ShokanKetteiTsuchiShoSealer item : itemList) {
            item2list.add(setShokanKetteiTsuchiShoSealer2Item(item));
        }
        list.add(ShokanKetteiTsuchiShoSealer2Report.createFrom(item2list));
        return list;
    }

    private static ShokanKetteiTsuchiShoSealer2Item
            setShokanKetteiTsuchiShoSealer2Item(ShokanKetteiTsuchiShoSealer item) {

        return new ShokanKetteiTsuchiShoSealer2Item(
                item.getBunshoNo(),
                item.getHihokenshaName(),
                item.getHihokenshaNo1(),
                item.getHihokenshaNo2(),
                item.getHihokenshaNo3(),
                item.getHihokenshaNo4(),
                item.getHihokenshaNo5(),
                item.getHihokenshaNo6(),
                item.getHihokenshaNo7(),
                item.getHihokenshaNo8(),
                item.getHihokenshaNo9(),
                item.getHihokenshaNo10(),
                item.getUketsukeYMD(),
                item.getKetteiYMD(),
                item.getShiharaiGaku(),
                item.getTaishoYM(),
                item.getKyufuShurui1(),
                item.getKyufuShurui2(),
                item.getKyufuShurui3(),
                item.getKekka(),
                item.getShikyuGaku(),
                item.getRiyu1(),
                item.getRiyu2(),
                item.getRiyu3(),
                item.getShiharaiBasho(),
                item.getBankName(),
                item.getBranchBankName(),
                item.getKouzaShu(),
                item.getKouzaNo(),
                item.getKouzaMeigi(),
                item.getShiharaiYoteiYMD(),
                item.get整理番号(),
                item.get決定通知書番号(),
                item.getShiharaiStartYMD(),
                item.getShiharaiEndYMD(),
                item.getShiharaiStartHMS(),
                item.getShiharaiEndHMS(),
                item.getKaraFugo(),
                item.getTsuban(),
                item.getShumokuTitle(),
                item.getBangoTitle(),
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
                item.getKakkoLeft2(),
                item.getSamabunShimei2(),
                item.getSamabunShimeiSmall2(),
                item.getSamaBun2(),
                item.getKakkoRight2(),
                item.getKakkoLeft1(),
                item.getSamabunShimei1(),
                item.getSamaBun1(),
                item.getKakkoRight1(),
                item.getSamabunShimeiSmall1(),
                item.getCustomerBarCode(),
                item.getTitle2_1(),
                item.getTitle2_2_1(),
                item.getTitle2_2_2(),
                item.getTitle2_3_1(),
                item.getTitle2_3_2(),
                item.getTitle2_4(),
                item.getTorikeshi1(),
                item.getTorikeshi2(),
                item.getMochimono1(),
                item.getTorikeshiMochimono1(),
                item.getMochimono2(),
                item.getTorikeshiMochimono2(),
                item.getMochimono3(),
                item.getShoHokenshaNo(),
                item.getServiceYM(),
                item.getTsuban2(),
                item.getTorikeshiShiharaikikan(),
                item.getRiyuTitle(),
                item.getTitle1(),
                item.getTitle2(),
                item.getPage(),
                item.getPages(),
                item.getHihokenshaName2(),
                item.getTsuchibun1(),
                item.getInfo(),
                item.getYen1(),
                item.getYen2(),
                item.getYen3(),
                item.getYen4(),
                item.getTitle(),
                item.getTorikeshiShiharaibasho(),
                item.getHihokenshaNo21(),
                item.getGyoseiku2());
    }
}
