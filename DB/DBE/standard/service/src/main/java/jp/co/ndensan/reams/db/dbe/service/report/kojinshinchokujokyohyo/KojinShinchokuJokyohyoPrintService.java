/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.kojinshinchokujokyohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.ChousaBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoJoho;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.ShuiBodyItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定個人進捗状況票Printerです。
 */
public class KojinShinchokuJokyohyoPrintService {

    /**
     * 要介護認定個人進捗状況票を印刷します。
     *
     * @param joho 要介護認定個人進捗状況票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(KojinShinchokuJokyohyoJoho joho) {
        KojinShinchokuJokyohyoProperty property = new KojinShinchokuJokyohyoProperty();
        KojinShinchokuJokyohyoReportJoho kojinReportJoho = getJoho(joho);
        return new Printer<KojinShinchokuJokyohyoReportSource>().spool(property, toReports(kojinReportJoho));
    }

    private static List<KojinShinchokuJokyohyoReport> toReports(KojinShinchokuJokyohyoReportJoho kojinReportJoho) {
        List<KojinShinchokuJokyohyoReport> list = new ArrayList<>();
        list.add(KojinShinchokuJokyohyoReport.createFrom(
                kojinReportJoho.getHeadItem(),
                kojinReportJoho.getChousaItemList(),
                kojinReportJoho.getShujiItemList(),
                kojinReportJoho.getBodyItemList()));
        return list;
    }

    private static KojinShinchokuJokyohyoReportJoho getJoho(KojinShinchokuJokyohyoJoho joho) {
        List<ChousaBodyItem> items = new ArrayList<>();
        ChousaBodyItem chou1 = new ChousaBodyItem(joho.getChosain_1(), joho.getChosain_4(), joho.getChosain_7());
        ChousaBodyItem chou2 = new ChousaBodyItem(joho.getChosain_2(), joho.getChosain_5(), joho.getChosain_8());
        ChousaBodyItem chou3 = new ChousaBodyItem(joho.getChosain_3(), joho.getChosain_6(), joho.getChosain_9());
        items.add(chou3);
        items.add(chou2);
        items.add(chou1);
        List<ShuiBodyItem> shujiItemList = new ArrayList<>();
        ShuiBodyItem shui1 = new ShuiBodyItem(joho.getShui_1(), joho.getShui_4(), joho.getShui_7());
        ShuiBodyItem shui2 = new ShuiBodyItem(joho.getShui_2(), joho.getShui_5(), joho.getShui_8());
        ShuiBodyItem shui3 = new ShuiBodyItem(joho.getShui_3(), joho.getShui_6(), joho.getShui_9());
        shujiItemList.add(shui1);
        shujiItemList.add(shui2);
        shujiItemList.add(shui3);
        List<KojinShinchokuJokyohyoBodyItem> bodyItemList = new ArrayList<>();
        KojinShinchokuJokyohyoBodyItem bodyList1 = new KojinShinchokuJokyohyoBodyItem(new RString("1"), new RString("認定申請情報登録完了年月日"),
                joho.getKonnkai_1(), joho.getZennkai_1(), joho.getZennnoma_1());
        KojinShinchokuJokyohyoBodyItem bodyList2 = new KojinShinchokuJokyohyoBodyItem(new RString("2"), new RString("認定調査依頼予定年月日"),
                joho.getKonnkai_2(), joho.getZennkai_2(), joho.getZennnoma_2());
        KojinShinchokuJokyohyoBodyItem bodyList3 = new KojinShinchokuJokyohyoBodyItem(new RString("3"), new RString("認定調査依頼年月日"),
                joho.getKonnkai_3(), joho.getZennkai_3(), joho.getZennnoma_3());
        KojinShinchokuJokyohyoBodyItem bodyList4 = new KojinShinchokuJokyohyoBodyItem(new RString("4"), new RString("認定調査依頼完了年月日"),
                joho.getKonnkai_4(), joho.getZennkai_4(), joho.getZennnoma_4());
        KojinShinchokuJokyohyoBodyItem bodyList5 = new KojinShinchokuJokyohyoBodyItem(new RString("5"), new RString("認定調査予定年月日"),
                joho.getKonnkai_5(), joho.getZennkai_5(), joho.getZennnoma_5());
        KojinShinchokuJokyohyoBodyItem bodyList6 = new KojinShinchokuJokyohyoBodyItem(new RString("6"), new RString("認定調査受領年月日"),
                joho.getKonnkai_6(), joho.getZennkai_6(), joho.getZennnoma_6());
        KojinShinchokuJokyohyoBodyItem bodyList7 = new KojinShinchokuJokyohyoBodyItem(new RString("7"), new RString("認定調査完了年月日"),
                joho.getKonnkai_7(), joho.getZennkai_7(), joho.getZennnoma_7());
        KojinShinchokuJokyohyoBodyItem bodyList8 = new KojinShinchokuJokyohyoBodyItem(new RString("8"), new RString("主治医意見書作成依頼予定年月日"),
                joho.getKonnkai_8(), joho.getZennkai_8(), joho.getZennnoma_8());
        KojinShinchokuJokyohyoBodyItem bodyList9 = new KojinShinchokuJokyohyoBodyItem(new RString("9"), new RString("主治医意見書作成依頼年月日"),
                joho.getKonnkai_9(), joho.getZennkai_9(), joho.getZennnoma_9());
        KojinShinchokuJokyohyoBodyItem bodyList10 = new KojinShinchokuJokyohyoBodyItem(new RString("10"), new RString("意見書作成依頼完了年月日"),
                joho.getKonnkai_10(), joho.getZennkai_10(), joho.getZennnoma_10());
        KojinShinchokuJokyohyoBodyItem bodyList11 = new KojinShinchokuJokyohyoBodyItem(new RString("11"), new RString("主治医意見書登録予定年月日"),
                joho.getKonnkai_11(), joho.getZennkai_11(), joho.getZennnoma_11());
        KojinShinchokuJokyohyoBodyItem bodyList12 = new KojinShinchokuJokyohyoBodyItem(new RString("12"), new RString("主治医意見書受領年月日"),
                joho.getKonnkai_12(), joho.getZennkai_12(), joho.getZennnoma_12());
        KojinShinchokuJokyohyoBodyItem bodyList13 = new KojinShinchokuJokyohyoBodyItem(new RString("13"), new RString("意見書登録完了年月日"),
                joho.getKonnkai_13(), joho.getZennkai_13(), joho.getZennnoma_13());
        KojinShinchokuJokyohyoBodyItem bodyList14 = new KojinShinchokuJokyohyoBodyItem(new RString("14"), new RString("要介護認定一次判定予定年月日"),
                joho.getKonnkai_14(), joho.getZennkai_14(), joho.getZennnoma_14());
        KojinShinchokuJokyohyoBodyItem bodyList15 = new KojinShinchokuJokyohyoBodyItem(new RString("15"), new RString("一次判定完了年月日"),
                joho.getKonnkai_15(), joho.getZennkai_15(), joho.getZennnoma_15());
        KojinShinchokuJokyohyoBodyItem bodyList16 = new KojinShinchokuJokyohyoBodyItem(new RString("16"), new RString("マスキング完了年月日"),
                joho.getKonnkai_16(), joho.getZennkai_16(), joho.getZennnoma_16());
        KojinShinchokuJokyohyoBodyItem bodyList17 = new KojinShinchokuJokyohyoBodyItem(new RString("17"), new RString("認定審査会割当予定年月日"),
                joho.getKonnkai_17(), joho.getZennkai_17(), joho.getZennnoma_17());
        KojinShinchokuJokyohyoBodyItem bodyList18 = new KojinShinchokuJokyohyoBodyItem(new RString("18"), new RString("認定審査会予定年月日"),
                joho.getKonnkai_18(), joho.getZennkai_18(), joho.getZennnoma_18());
        KojinShinchokuJokyohyoBodyItem bodyList19 = new KojinShinchokuJokyohyoBodyItem(new RString("19"), new RString("審査会割当完了年月日"),
                joho.getKonnkai_19(), joho.getZennkai_19(), joho.getZennnoma_19());
        KojinShinchokuJokyohyoBodyItem bodyList20 = new KojinShinchokuJokyohyoBodyItem(new RString("20"), new RString("審査会完了年月日"),
                joho.getKonnkai_20(), joho.getZennkai_20(), joho.getZennnoma_20());
        KojinShinchokuJokyohyoBodyItem bodyList21 = new KojinShinchokuJokyohyoBodyItem(new RString("21"), new RString("センター送信予定年月日"),
                joho.getKonnkai_21(), joho.getZennkai_21(), joho.getZennnoma_21());
        KojinShinchokuJokyohyoBodyItem bodyList22 = new KojinShinchokuJokyohyoBodyItem(new RString("22"), new RString("センター送信年月日"),
                joho.getKonnkai_22(), joho.getZennkai_22(), joho.getZennnoma_22());
        bodyItemList.add(bodyList1);
        bodyItemList.add(bodyList2);
        bodyItemList.add(bodyList3);
        bodyItemList.add(bodyList4);
        bodyItemList.add(bodyList5);
        bodyItemList.add(bodyList6);
        bodyItemList.add(bodyList7);
        bodyItemList.add(bodyList8);
        bodyItemList.add(bodyList9);
        bodyItemList.add(bodyList10);
        bodyItemList.add(bodyList11);
        bodyItemList.add(bodyList12);
        bodyItemList.add(bodyList13);
        bodyItemList.add(bodyList14);
        bodyItemList.add(bodyList15);
        bodyItemList.add(bodyList16);
        bodyItemList.add(bodyList17);
        bodyItemList.add(bodyList18);
        bodyItemList.add(bodyList19);
        bodyItemList.add(bodyList20);
        bodyItemList.add(bodyList21);
        bodyItemList.add(bodyList22);
        KojinShinchokuJokyohyoHeadItem headItem = new KojinShinchokuJokyohyoHeadItem(joho.getHihokenshaNo(), joho.getShinseiKubun(),
                joho.getHihokenshaNameKana(), joho.getShinseiYMD(), joho.getSeibetsu(), joho.getHihokenshaName(), joho.getBirthYMD(),
                joho.getAge(), joho.getYubinNo1(), joho.getHihokenshaJusho(), joho.getTelNo1(), joho.getShinseiRiyu(),
                joho.getShinseishaName(), joho.getShinseiDaikoJigyoshaName(), joho.getShinseishaKankei(), joho.getHonninKankei(),
                joho.getYubinNo2(), joho.getShinseishaJusho(), joho.getTelNo2(), joho.getShisetsuName(), joho.getShisetsujusho(),
                joho.getTelNo3());
        return new KojinShinchokuJokyohyoReportJoho(headItem, items, shujiItemList, bodyItemList);
    }
}
