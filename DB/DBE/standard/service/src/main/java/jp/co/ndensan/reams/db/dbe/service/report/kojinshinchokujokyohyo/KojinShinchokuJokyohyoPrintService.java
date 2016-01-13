/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.kojinshinchokujokyohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.ChousaBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.ShuiBodyItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoReportSource;
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
     * @param entity 要介護認定個人進捗状況票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(KojinShinchokuJokyohyoEntity entity) {
        KojinShinchokuJokyohyoProperty property = new KojinShinchokuJokyohyoProperty();
        KojinShinchokuJokyohyoReportJoho kojinReportJoho = getJoho(entity);
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

    private static KojinShinchokuJokyohyoReportJoho getJoho(KojinShinchokuJokyohyoEntity entity) {
        List<ChousaBodyItem> items = new ArrayList<>();
        ChousaBodyItem chou1 = new ChousaBodyItem(entity.getChosain_1(), entity.getChosain_4(), entity.getChosain_7());
        ChousaBodyItem chou2 = new ChousaBodyItem(entity.getChosain_2(), entity.getChosain_5(), entity.getChosain_8());
        ChousaBodyItem chou3 = new ChousaBodyItem(entity.getChosain_3(), entity.getChosain_6(), entity.getChosain_9());
        items.add(chou3);
        items.add(chou2);
        items.add(chou1);
        List<ShuiBodyItem> shujiItemList = new ArrayList<>();
        ShuiBodyItem shui1 = new ShuiBodyItem(entity.getShui_1(), entity.getShui_4(), entity.getShui_7());
        ShuiBodyItem shui2 = new ShuiBodyItem(entity.getShui_2(), entity.getShui_5(), entity.getShui_8());
        ShuiBodyItem shui3 = new ShuiBodyItem(entity.getShui_3(), entity.getShui_6(), entity.getShui_9());
        shujiItemList.add(shui1);
        shujiItemList.add(shui2);
        shujiItemList.add(shui3);
        List<KojinShinchokuJokyohyoBodyItem> bodyItemList = new ArrayList<>();
        KojinShinchokuJokyohyoBodyItem bodyList1 = new KojinShinchokuJokyohyoBodyItem(new RString("1"), new RString("認定申請情報登録完了年月日"),
                entity.getKonnkai_1(), entity.getZennkai_1(), entity.getZennnoma_1());
        KojinShinchokuJokyohyoBodyItem bodyList2 = new KojinShinchokuJokyohyoBodyItem(new RString("2"), new RString("認定調査依頼予定年月日"),
                entity.getKonnkai_2(), entity.getZennkai_2(), entity.getZennnoma_2());
        KojinShinchokuJokyohyoBodyItem bodyList3 = new KojinShinchokuJokyohyoBodyItem(new RString("3"), new RString("認定調査依頼年月日"),
                entity.getKonnkai_3(), entity.getZennkai_3(), entity.getZennnoma_3());
        KojinShinchokuJokyohyoBodyItem bodyList4 = new KojinShinchokuJokyohyoBodyItem(new RString("4"), new RString("認定調査依頼完了年月日"),
                entity.getKonnkai_4(), entity.getZennkai_4(), entity.getZennnoma_4());
        KojinShinchokuJokyohyoBodyItem bodyList5 = new KojinShinchokuJokyohyoBodyItem(new RString("5"), new RString("認定調査予定年月日"),
                entity.getKonnkai_5(), entity.getZennkai_5(), entity.getZennnoma_5());
        KojinShinchokuJokyohyoBodyItem bodyList6 = new KojinShinchokuJokyohyoBodyItem(new RString("6"), new RString("認定調査受領年月日"),
                entity.getKonnkai_6(), entity.getZennkai_6(), entity.getZennnoma_6());
        KojinShinchokuJokyohyoBodyItem bodyList7 = new KojinShinchokuJokyohyoBodyItem(new RString("7"), new RString("認定調査完了年月日"),
                entity.getKonnkai_7(), entity.getZennkai_7(), entity.getZennnoma_7());
        KojinShinchokuJokyohyoBodyItem bodyList8 = new KojinShinchokuJokyohyoBodyItem(new RString("8"), new RString("主治医意見書作成依頼予定年月日"),
                entity.getKonnkai_8(), entity.getZennkai_8(), entity.getZennnoma_8());
        KojinShinchokuJokyohyoBodyItem bodyList9 = new KojinShinchokuJokyohyoBodyItem(new RString("9"), new RString("主治医意見書作成依頼年月日"),
                entity.getKonnkai_9(), entity.getZennkai_9(), entity.getZennnoma_9());
        KojinShinchokuJokyohyoBodyItem bodyList10 = new KojinShinchokuJokyohyoBodyItem(new RString("10"), new RString("意見書作成依頼完了年月日"),
                entity.getKonnkai_10(), entity.getZennkai_10(), entity.getZennnoma_10());
        KojinShinchokuJokyohyoBodyItem bodyList11 = new KojinShinchokuJokyohyoBodyItem(new RString("11"), new RString("主治医意見書登録予定年月日"),
                entity.getKonnkai_11(), entity.getZennkai_11(), entity.getZennnoma_11());
        KojinShinchokuJokyohyoBodyItem bodyList12 = new KojinShinchokuJokyohyoBodyItem(new RString("12"), new RString("主治医意見書受領年月日"),
                entity.getKonnkai_12(), entity.getZennkai_12(), entity.getZennnoma_12());
        KojinShinchokuJokyohyoBodyItem bodyList13 = new KojinShinchokuJokyohyoBodyItem(new RString("13"), new RString("意見書登録完了年月日"),
                entity.getKonnkai_13(), entity.getZennkai_13(), entity.getZennnoma_13());
        KojinShinchokuJokyohyoBodyItem bodyList14 = new KojinShinchokuJokyohyoBodyItem(new RString("14"), new RString("要介護認定一次判定予定年月日"),
                entity.getKonnkai_14(), entity.getZennkai_14(), entity.getZennnoma_14());
        KojinShinchokuJokyohyoBodyItem bodyList15 = new KojinShinchokuJokyohyoBodyItem(new RString("15"), new RString("一次判定完了年月日"),
                entity.getKonnkai_15(), entity.getZennkai_15(), entity.getZennnoma_15());
        KojinShinchokuJokyohyoBodyItem bodyList16 = new KojinShinchokuJokyohyoBodyItem(new RString("16"), new RString("マスキング完了年月日"),
                entity.getKonnkai_16(), entity.getZennkai_16(), entity.getZennnoma_16());
        KojinShinchokuJokyohyoBodyItem bodyList17 = new KojinShinchokuJokyohyoBodyItem(new RString("17"), new RString("認定審査会割当予定年月日"),
                entity.getKonnkai_17(), entity.getZennkai_17(), entity.getZennnoma_17());
        KojinShinchokuJokyohyoBodyItem bodyList18 = new KojinShinchokuJokyohyoBodyItem(new RString("18"), new RString("認定審査会予定年月日"),
                entity.getKonnkai_18(), entity.getZennkai_18(), entity.getZennnoma_18());
        KojinShinchokuJokyohyoBodyItem bodyList19 = new KojinShinchokuJokyohyoBodyItem(new RString("19"), new RString("審査会割当完了年月日"),
                entity.getKonnkai_19(), entity.getZennkai_19(), entity.getZennnoma_19());
        KojinShinchokuJokyohyoBodyItem bodyList20 = new KojinShinchokuJokyohyoBodyItem(new RString("20"), new RString("審査会完了年月日"),
                entity.getKonnkai_20(), entity.getZennkai_20(), entity.getZennnoma_20());
        KojinShinchokuJokyohyoBodyItem bodyList21 = new KojinShinchokuJokyohyoBodyItem(new RString("21"), new RString("センター送信予定年月日"),
                entity.getKonnkai_21(), entity.getZennkai_21(), entity.getZennnoma_21());
        KojinShinchokuJokyohyoBodyItem bodyList22 = new KojinShinchokuJokyohyoBodyItem(new RString("22"), new RString("センター送信年月日"),
                entity.getKonnkai_22(), entity.getZennkai_22(), entity.getZennnoma_22());
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
        KojinShinchokuJokyohyoHeadItem headItem = new KojinShinchokuJokyohyoHeadItem(entity.getHihokenshaNo(), entity.getShinseiKubun(),
                entity.getHihokenshaNameKana(), entity.getShinseiYMD(), entity.getSeibetsu(), entity.getHihokenshaName(), entity.getBirthYMD(),
                entity.getAge(), entity.getYubinNo1(), entity.getHihokenshaJusho(), entity.getTelNo1(), entity.getShinseiRiyu(),
                entity.getShinseishaName(), entity.getShinseiDaikoJigyoshaName(), entity.getShinseishaKankei(), entity.getHonninKankei(),
                entity.getYubinNo2(), entity.getShinseishaJusho(), entity.getTelNo2(), entity.getShisetsuName(), entity.getShisetsujusho(),
                entity.getTelNo3());
        return new KojinShinchokuJokyohyoReportJoho(headItem, items, shujiItemList, bodyItemList);
    }
}
