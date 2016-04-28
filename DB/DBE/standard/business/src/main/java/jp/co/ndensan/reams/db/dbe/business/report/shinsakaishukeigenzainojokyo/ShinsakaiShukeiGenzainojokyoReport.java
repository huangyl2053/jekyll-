/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（現在の状況別）のReportです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoReport extends Report<ShinsakaiShukeiGenzainojokyoReportSource> {

    private final ShinsakaiShukeiGenzainojokyoEntity target;

    /**
     * インスタンスを生成します。
     *
     * @param target 介護認定審査会集計表（現在の状況別）target
     */
    public ShinsakaiShukeiGenzainojokyoReport(ShinsakaiShukeiGenzainojokyoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiShukeiGenzainojokyoReportSource> reportSourceWriter) {
        List<ShinsakaiShukeiGenzainojokyo> itemList = itemList();
        int count = 0;
        for (ShinsakaiShukeiGenzainojokyo item : itemList) {
            IShinsakaiShukeiGenzainojokyoHeadEditor headEditor = new ShinsakaiShukeiGenzainojokyoHeadEditor(target);
            IShinsakaiShukeiGenzainojokyoEditor editor = new ShinsakaiShukeiGenzainojokyoEditor(item, count++);
            IShinsakaiShukeiGenzainojokyoBuilder builder = new ShinsakaiShukeiGenzainojokyoBuilder(headEditor, editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsakaiShukeiGenzainojokyo> itemList() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(set上段合計(target));
        itemList.add(set下段合計(target));
        itemList.add(set上段6ヶ月(target));
        itemList.add(set下段6ヶ月(target));
        itemList.add(set上段12ヶ月(target));
        itemList.add(set下段12ヶ月(target));
        itemList.add(set上段24ヶ月(target));
        itemList.add(set下段24ヶ月(target));
        itemList.add(set上段その他(target));
        itemList.add(set下段その他(target));
        return itemList;
    }

    private ShinsakaiShukeiGenzainojokyo set上段合計(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setTitle(entity.getタイトル());
        item.setShichosonName(entity.get市町村名());
        item.setShichosonName(entity.get有効基準年月日());
        item.setListShukei1_1(entity.get全体合計_要支援1_上段());
        item.setListShukei1_2(entity.get全体合計_要支援2_上段());
        item.setListShukei1_3(entity.get全体合計_要介護1_上段());
        item.setListShukei1_4(entity.get全体合計_要介護2_上段());
        item.setListShukei1_5(entity.get全体合計_要介護3_上段());
        item.setListShukei1_6(entity.get全体合計_要介護4_上段());
        item.setListShukei1_7(entity.get全体合計_要介護5_上段());
        item.setListShukei1_8(entity.get全体合計_計_上段());
        item.setListShukei2_1(entity.get新規合計_要支援1_上段());
        item.setListShukei2_2(entity.get新規合計_要支援2_上段());
        item.setListShukei2_3(entity.get新規合計_要介護1_上段());
        item.setListShukei2_4(entity.get新規合計_要介護2_上段());
        item.setListShukei2_5(entity.get新規合計_要介護3_上段());
        item.setListShukei2_6(entity.get新規合計_要介護4_上段());
        item.setListShukei2_7(entity.get新規合計_要介護5_上段());
        item.setListShukei2_8(entity.get新規合計_計_上段());
        item.setListShukei3_1(entity.get更新合計_要支援1_上段());
        item.setListShukei3_2(entity.get更新合計_要支援2_上段());
        item.setListShukei3_3(entity.get更新合計_要介護1_上段());
        item.setListShukei3_4(entity.get更新合計_要介護2_上段());
        item.setListShukei3_5(entity.get更新合計_要介護3_上段());
        item.setListShukei3_6(entity.get更新合計_要介護4_上段());
        item.setListShukei3_7(entity.get更新合計_要介護5_上段());
        item.setListShukei3_8(entity.get更新合計_計_上段());
        item.setListShukei4_1(entity.get区分変更合計_要支援1_上段());
        item.setListShukei4_2(entity.get区分変更合計_要支援2_上段());
        item.setListShukei4_3(entity.get区分変更合計_要介護1_上段());
        item.setListShukei4_4(entity.get区分変更合計_要介護2_上段());
        item.setListShukei4_5(entity.get区分変更合計_要介護3_上段());
        item.setListShukei4_6(entity.get区分変更合計_要介護4_上段());
        item.setListShukei4_7(entity.get区分変更合計_要介護5_上段());
        item.setListShukei4_8(entity.get区分変更合計_計_上段());
        item.setListShukei5_1(entity.get転入合計_要支援1_上段());
        item.setListShukei5_2(entity.get転入合計_要支援2_上段());
        item.setListShukei5_3(entity.get転入合計_要介護1_上段());
        item.setListShukei5_4(entity.get転入合計_要介護2_上段());
        item.setListShukei5_5(entity.get転入合計_要介護3_上段());
        item.setListShukei5_6(entity.get転入合計_要介護4_上段());
        item.setListShukei5_7(entity.get転入合計_要介護5_上段());
        item.setListShukei5_8(entity.get転入合計_計_上段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set下段合計(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体合計_要支援1_下段());
        item.setListShukei1_2(entity.get全体合計_要支援2_下段());
        item.setListShukei1_3(entity.get全体合計_要介護1_下段());
        item.setListShukei1_4(entity.get全体合計_要介護2_下段());
        item.setListShukei1_5(entity.get全体合計_要介護3_下段());
        item.setListShukei1_6(entity.get全体合計_要介護4_下段());
        item.setListShukei1_7(entity.get全体合計_要介護5_下段());
        item.setListShukei1_8(entity.get全体合計_計_下段());
        item.setListShukei2_1(entity.get新規合計_要支援1_下段());
        item.setListShukei2_2(entity.get新規合計_要支援2_下段());
        item.setListShukei2_3(entity.get新規合計_要介護1_下段());
        item.setListShukei2_4(entity.get新規合計_要介護2_下段());
        item.setListShukei2_5(entity.get新規合計_要介護3_下段());
        item.setListShukei2_6(entity.get新規合計_要介護4_下段());
        item.setListShukei2_7(entity.get新規合計_要介護5_下段());
        item.setListShukei2_8(entity.get新規合計_計_下段());
        item.setListShukei3_1(entity.get更新合計_要支援1_下段());
        item.setListShukei3_2(entity.get更新合計_要支援2_下段());
        item.setListShukei3_3(entity.get更新合計_要介護1_下段());
        item.setListShukei3_4(entity.get更新合計_要介護2_下段());
        item.setListShukei3_5(entity.get更新合計_要介護3_下段());
        item.setListShukei3_6(entity.get更新合計_要介護4_下段());
        item.setListShukei3_7(entity.get更新合計_要介護5_下段());
        item.setListShukei3_8(entity.get更新合計_計_下段());
        item.setListShukei4_1(entity.get区分変更合計_要支援1_下段());
        item.setListShukei4_2(entity.get区分変更合計_要支援2_下段());
        item.setListShukei4_3(entity.get区分変更合計_要介護1_下段());
        item.setListShukei4_4(entity.get区分変更合計_要介護2_下段());
        item.setListShukei4_5(entity.get区分変更合計_要介護3_下段());
        item.setListShukei4_6(entity.get区分変更合計_要介護4_下段());
        item.setListShukei4_7(entity.get区分変更合計_要介護5_下段());
        item.setListShukei4_8(entity.get区分変更合計_計_下段());
        item.setListShukei5_1(entity.get転入合計_要支援1_下段());
        item.setListShukei5_2(entity.get転入合計_要支援2_下段());
        item.setListShukei5_3(entity.get転入合計_要介護1_下段());
        item.setListShukei5_4(entity.get転入合計_要介護2_下段());
        item.setListShukei5_5(entity.get転入合計_要介護3_下段());
        item.setListShukei5_6(entity.get転入合計_要介護4_下段());
        item.setListShukei5_7(entity.get転入合計_要介護5_下段());
        item.setListShukei5_8(entity.get転入合計_計_下段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set上段6ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体6ヶ月_要支援1_上段());
        item.setListShukei1_2(entity.get全体6ヶ月_要支援2_上段());
        item.setListShukei1_3(entity.get全体6ヶ月_要介護1_上段());
        item.setListShukei1_4(entity.get全体6ヶ月_要介護2_上段());
        item.setListShukei1_5(entity.get全体6ヶ月_要介護3_上段());
        item.setListShukei1_6(entity.get全体6ヶ月_要介護4_上段());
        item.setListShukei1_7(entity.get全体6ヶ月_要介護5_上段());
        item.setListShukei1_8(entity.get全体6ヶ月_計_上段());
        item.setListShukei2_1(entity.get新規6ヶ月_要支援1_上段());
        item.setListShukei2_2(entity.get新規6ヶ月_要支援2_上段());
        item.setListShukei2_3(entity.get新規6ヶ月_要介護1_上段());
        item.setListShukei2_4(entity.get新規6ヶ月_要介護2_上段());
        item.setListShukei2_5(entity.get新規6ヶ月_要介護3_上段());
        item.setListShukei2_6(entity.get新規6ヶ月_要介護4_上段());
        item.setListShukei2_7(entity.get新規6ヶ月_要介護5_上段());
        item.setListShukei2_8(entity.get新規6ヶ月_計_上段());
        item.setListShukei3_1(entity.get更新6ヶ月_要支援1_上段());
        item.setListShukei3_2(entity.get更新6ヶ月_要支援2_上段());
        item.setListShukei3_3(entity.get更新6ヶ月_要介護1_上段());
        item.setListShukei3_4(entity.get更新6ヶ月_要介護2_上段());
        item.setListShukei3_5(entity.get更新6ヶ月_要介護3_上段());
        item.setListShukei3_6(entity.get更新6ヶ月_要介護4_上段());
        item.setListShukei3_7(entity.get更新6ヶ月_要介護5_上段());
        item.setListShukei3_8(entity.get更新6ヶ月_計_上段());
        item.setListShukei4_1(entity.get区分変更6ヶ月_要支援1_上段());
        item.setListShukei4_2(entity.get区分変更6ヶ月_要支援2_上段());
        item.setListShukei4_3(entity.get区分変更6ヶ月_要介護1_上段());
        item.setListShukei4_4(entity.get区分変更6ヶ月_要介護2_上段());
        item.setListShukei4_5(entity.get区分変更6ヶ月_要介護3_上段());
        item.setListShukei4_6(entity.get区分変更6ヶ月_要介護4_上段());
        item.setListShukei4_7(entity.get区分変更6ヶ月_要介護5_上段());
        item.setListShukei4_8(entity.get区分変更6ヶ月_計_上段());
        item.setListShukei5_1(entity.get転入6ヶ月_要支援1_上段());
        item.setListShukei5_2(entity.get転入6ヶ月_要支援2_上段());
        item.setListShukei5_3(entity.get転入6ヶ月_要介護1_上段());
        item.setListShukei5_4(entity.get転入6ヶ月_要介護2_上段());
        item.setListShukei5_5(entity.get転入6ヶ月_要介護3_上段());
        item.setListShukei5_6(entity.get転入6ヶ月_要介護4_上段());
        item.setListShukei5_7(entity.get転入6ヶ月_要介護5_上段());
        item.setListShukei5_8(entity.get転入6ヶ月_計_上段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set下段6ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体6ヶ月_要支援1_下段());
        item.setListShukei1_2(entity.get全体6ヶ月_要支援2_下段());
        item.setListShukei1_3(entity.get全体6ヶ月_要介護1_下段());
        item.setListShukei1_4(entity.get全体6ヶ月_要介護2_下段());
        item.setListShukei1_5(entity.get全体6ヶ月_要介護3_下段());
        item.setListShukei1_6(entity.get全体6ヶ月_要介護4_下段());
        item.setListShukei1_7(entity.get全体6ヶ月_要介護5_下段());
        item.setListShukei1_8(entity.get全体6ヶ月_計_下段());
        item.setListShukei2_1(entity.get新規6ヶ月_要支援1_下段());
        item.setListShukei2_2(entity.get新規6ヶ月_要支援2_下段());
        item.setListShukei2_3(entity.get新規6ヶ月_要介護1_下段());
        item.setListShukei2_4(entity.get新規6ヶ月_要介護2_下段());
        item.setListShukei2_5(entity.get新規6ヶ月_要介護3_下段());
        item.setListShukei2_6(entity.get新規6ヶ月_要介護4_下段());
        item.setListShukei2_7(entity.get新規6ヶ月_要介護5_下段());
        item.setListShukei2_8(entity.get新規6ヶ月_計_下段());
        item.setListShukei3_1(entity.get更新6ヶ月_要支援1_下段());
        item.setListShukei3_2(entity.get更新6ヶ月_要支援2_下段());
        item.setListShukei3_3(entity.get更新6ヶ月_要介護1_下段());
        item.setListShukei3_4(entity.get更新6ヶ月_要介護2_下段());
        item.setListShukei3_5(entity.get更新6ヶ月_要介護3_下段());
        item.setListShukei3_6(entity.get更新6ヶ月_要介護4_下段());
        item.setListShukei3_7(entity.get更新6ヶ月_要介護5_下段());
        item.setListShukei3_8(entity.get更新6ヶ月_計_下段());
        item.setListShukei4_1(entity.get区分変更6ヶ月_要支援1_下段());
        item.setListShukei4_2(entity.get区分変更6ヶ月_要支援2_下段());
        item.setListShukei4_3(entity.get区分変更6ヶ月_要介護1_下段());
        item.setListShukei4_4(entity.get区分変更6ヶ月_要介護2_下段());
        item.setListShukei4_5(entity.get区分変更6ヶ月_要介護3_下段());
        item.setListShukei4_6(entity.get区分変更6ヶ月_要介護4_下段());
        item.setListShukei4_7(entity.get区分変更6ヶ月_要介護5_下段());
        item.setListShukei4_8(entity.get区分変更6ヶ月_計_下段());
        item.setListShukei5_1(entity.get転入6ヶ月_要支援1_下段());
        item.setListShukei5_2(entity.get転入6ヶ月_要支援2_下段());
        item.setListShukei5_3(entity.get転入6ヶ月_要介護1_下段());
        item.setListShukei5_4(entity.get転入6ヶ月_要介護2_下段());
        item.setListShukei5_5(entity.get転入6ヶ月_要介護3_下段());
        item.setListShukei5_6(entity.get転入6ヶ月_要介護4_下段());
        item.setListShukei5_7(entity.get転入6ヶ月_要介護5_下段());
        item.setListShukei5_8(entity.get転入6ヶ月_計_下段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set上段12ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体12ヶ月_要支援1_上段());
        item.setListShukei1_2(entity.get全体12ヶ月_要支援2_上段());
        item.setListShukei1_3(entity.get全体12ヶ月_要介護1_上段());
        item.setListShukei1_4(entity.get全体12ヶ月_要介護2_上段());
        item.setListShukei1_5(entity.get全体12ヶ月_要介護3_上段());
        item.setListShukei1_6(entity.get全体12ヶ月_要介護4_上段());
        item.setListShukei1_7(entity.get全体12ヶ月_要介護5_上段());
        item.setListShukei1_8(entity.get全体12ヶ月_計_上段());
        item.setListShukei2_1(entity.get新規12ヶ月_要支援1_上段());
        item.setListShukei2_2(entity.get新規12ヶ月_要支援2_上段());
        item.setListShukei2_3(entity.get新規12ヶ月_要介護1_上段());
        item.setListShukei2_4(entity.get新規12ヶ月_要介護2_上段());
        item.setListShukei2_5(entity.get新規12ヶ月_要介護3_上段());
        item.setListShukei2_6(entity.get新規12ヶ月_要介護4_上段());
        item.setListShukei2_7(entity.get新規12ヶ月_要介護5_上段());
        item.setListShukei2_8(entity.get新規12ヶ月_計_上段());
        item.setListShukei3_1(entity.get更新12ヶ月_要支援1_上段());
        item.setListShukei3_2(entity.get更新12ヶ月_要支援2_上段());
        item.setListShukei3_3(entity.get更新12ヶ月_要介護1_上段());
        item.setListShukei3_4(entity.get更新12ヶ月_要介護2_上段());
        item.setListShukei3_5(entity.get更新12ヶ月_要介護3_上段());
        item.setListShukei3_6(entity.get更新12ヶ月_要介護4_上段());
        item.setListShukei3_7(entity.get更新12ヶ月_要介護5_上段());
        item.setListShukei3_8(entity.get更新12ヶ月_計_上段());
        item.setListShukei4_1(entity.get区分変更12ヶ月_要支援1_上段());
        item.setListShukei4_2(entity.get区分変更12ヶ月_要支援2_上段());
        item.setListShukei4_3(entity.get区分変更12ヶ月_要介護1_上段());
        item.setListShukei4_4(entity.get区分変更12ヶ月_要介護2_上段());
        item.setListShukei4_5(entity.get区分変更12ヶ月_要介護3_上段());
        item.setListShukei4_6(entity.get区分変更12ヶ月_要介護4_上段());
        item.setListShukei4_7(entity.get区分変更12ヶ月_要介護5_上段());
        item.setListShukei4_8(entity.get区分変更12ヶ月_計_上段());
        item.setListShukei5_1(entity.get転入その他_要支援1_上段());
        item.setListShukei5_2(entity.get転入その他_要支援2_上段());
        item.setListShukei5_3(entity.get転入その他_要介護1_上段());
        item.setListShukei5_4(entity.get転入その他_要介護2_上段());
        item.setListShukei5_5(entity.get転入その他_要介護3_上段());
        item.setListShukei5_6(entity.get転入その他_要介護4_上段());
        item.setListShukei5_7(entity.get転入その他_要介護5_上段());
        item.setListShukei5_8(entity.get転入その他_計_上段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set下段12ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体12ヶ月_要支援1_下段());
        item.setListShukei1_2(entity.get全体12ヶ月_要支援2_下段());
        item.setListShukei1_3(entity.get全体12ヶ月_要介護1_下段());
        item.setListShukei1_4(entity.get全体12ヶ月_要介護2_下段());
        item.setListShukei1_5(entity.get全体12ヶ月_要介護3_下段());
        item.setListShukei1_6(entity.get全体12ヶ月_要介護4_下段());
        item.setListShukei1_7(entity.get全体12ヶ月_要介護5_下段());
        item.setListShukei1_8(entity.get全体12ヶ月_計_下段());
        item.setListShukei2_1(entity.get新規12ヶ月_要支援1_下段());
        item.setListShukei2_2(entity.get新規12ヶ月_要支援2_下段());
        item.setListShukei2_3(entity.get新規12ヶ月_要介護1_下段());
        item.setListShukei2_4(entity.get新規12ヶ月_要介護2_下段());
        item.setListShukei2_5(entity.get新規12ヶ月_要介護3_下段());
        item.setListShukei2_6(entity.get新規12ヶ月_要介護4_下段());
        item.setListShukei2_7(entity.get新規12ヶ月_要介護5_下段());
        item.setListShukei2_8(entity.get新規12ヶ月_計_下段());
        item.setListShukei3_1(entity.get更新12ヶ月_要支援1_下段());
        item.setListShukei3_2(entity.get更新12ヶ月_要支援2_下段());
        item.setListShukei3_3(entity.get更新12ヶ月_要介護1_下段());
        item.setListShukei3_4(entity.get更新12ヶ月_要介護2_下段());
        item.setListShukei3_5(entity.get更新12ヶ月_要介護3_下段());
        item.setListShukei3_6(entity.get更新12ヶ月_要介護4_下段());
        item.setListShukei3_7(entity.get更新12ヶ月_要介護5_下段());
        item.setListShukei3_8(entity.get更新12ヶ月_計_下段());
        item.setListShukei4_1(entity.get区分変更12ヶ月_要支援1_下段());
        item.setListShukei4_2(entity.get区分変更12ヶ月_要支援2_下段());
        item.setListShukei4_3(entity.get区分変更12ヶ月_要介護1_下段());
        item.setListShukei4_4(entity.get区分変更12ヶ月_要介護2_下段());
        item.setListShukei4_5(entity.get区分変更12ヶ月_要介護3_下段());
        item.setListShukei4_6(entity.get区分変更12ヶ月_要介護4_下段());
        item.setListShukei4_7(entity.get区分変更12ヶ月_要介護5_下段());
        item.setListShukei4_8(entity.get区分変更12ヶ月_計_下段());
        item.setListShukei5_1(entity.get転入その他_要支援1_下段());
        item.setListShukei5_2(entity.get転入その他_要支援2_下段());
        item.setListShukei5_3(entity.get転入その他_要介護1_下段());
        item.setListShukei5_4(entity.get転入その他_要介護2_下段());
        item.setListShukei5_5(entity.get転入その他_要介護3_下段());
        item.setListShukei5_6(entity.get転入その他_要介護4_下段());
        item.setListShukei5_7(entity.get転入その他_要介護5_下段());
        item.setListShukei5_8(entity.get転入その他_計_下段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set上段24ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体24ヶ月_要支援1_上段());
        item.setListShukei1_2(entity.get全体24ヶ月_要支援2_上段());
        item.setListShukei1_3(entity.get全体24ヶ月_要介護1_上段());
        item.setListShukei1_4(entity.get全体24ヶ月_要介護2_上段());
        item.setListShukei1_5(entity.get全体24ヶ月_要介護3_上段());
        item.setListShukei1_6(entity.get全体24ヶ月_要介護4_上段());
        item.setListShukei1_7(entity.get全体24ヶ月_要介護5_上段());
        item.setListShukei1_8(entity.get全体24ヶ月_計_上段());
        item.setListShukei2_1(entity.get新規24ヶ月_要支援1_上段());
        item.setListShukei2_2(entity.get新規24ヶ月_要支援2_上段());
        item.setListShukei2_3(entity.get新規24ヶ月_要介護1_上段());
        item.setListShukei2_4(entity.get新規24ヶ月_要介護2_上段());
        item.setListShukei2_5(entity.get新規24ヶ月_要介護3_上段());
        item.setListShukei2_6(entity.get新規24ヶ月_要介護4_上段());
        item.setListShukei2_7(entity.get新規24ヶ月_要介護5_上段());
        item.setListShukei2_8(entity.get新規24ヶ月_計_上段());
        item.setListShukei3_1(entity.get更新24ヶ月_要支援1_上段());
        item.setListShukei3_2(entity.get更新24ヶ月_要支援2_上段());
        item.setListShukei3_3(entity.get更新24ヶ月_要介護1_上段());
        item.setListShukei3_4(entity.get更新24ヶ月_要介護2_上段());
        item.setListShukei3_5(entity.get更新24ヶ月_要介護3_上段());
        item.setListShukei3_6(entity.get更新24ヶ月_要介護4_上段());
        item.setListShukei3_7(entity.get更新24ヶ月_要介護5_上段());
        item.setListShukei3_8(entity.get更新24ヶ月_計_上段());
        item.setListShukei4_1(entity.get区分変更24ヶ月_要支援1_上段());
        item.setListShukei4_2(entity.get区分変更24ヶ月_要支援2_上段());
        item.setListShukei4_3(entity.get区分変更24ヶ月_要介護1_上段());
        item.setListShukei4_4(entity.get区分変更24ヶ月_要介護2_上段());
        item.setListShukei4_5(entity.get区分変更24ヶ月_要介護3_上段());
        item.setListShukei4_6(entity.get区分変更24ヶ月_要介護4_上段());
        item.setListShukei4_7(entity.get区分変更24ヶ月_要介護5_上段());
        item.setListShukei4_8(entity.get区分変更24ヶ月_計_上段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set下段24ヶ月(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体24ヶ月_要支援1_下段());
        item.setListShukei1_2(entity.get全体24ヶ月_要支援2_下段());
        item.setListShukei1_3(entity.get全体24ヶ月_要介護1_下段());
        item.setListShukei1_4(entity.get全体24ヶ月_要介護2_下段());
        item.setListShukei1_5(entity.get全体24ヶ月_要介護3_下段());
        item.setListShukei1_6(entity.get全体24ヶ月_要介護4_下段());
        item.setListShukei1_7(entity.get全体24ヶ月_要介護5_下段());
        item.setListShukei1_8(entity.get全体24ヶ月_計_下段());
        item.setListShukei2_1(entity.get新規24ヶ月_要支援1_下段());
        item.setListShukei2_2(entity.get新規24ヶ月_要支援2_下段());
        item.setListShukei2_3(entity.get新規24ヶ月_要介護1_下段());
        item.setListShukei2_4(entity.get新規24ヶ月_要介護2_下段());
        item.setListShukei2_5(entity.get新規24ヶ月_要介護3_下段());
        item.setListShukei2_6(entity.get新規24ヶ月_要介護4_下段());
        item.setListShukei2_7(entity.get新規24ヶ月_要介護5_下段());
        item.setListShukei2_8(entity.get新規24ヶ月_計_下段());
        item.setListShukei3_1(entity.get更新24ヶ月_要支援1_下段());
        item.setListShukei3_2(entity.get更新24ヶ月_要支援2_下段());
        item.setListShukei3_3(entity.get更新24ヶ月_要介護1_下段());
        item.setListShukei3_4(entity.get更新24ヶ月_要介護2_下段());
        item.setListShukei3_5(entity.get更新24ヶ月_要介護3_下段());
        item.setListShukei3_6(entity.get更新24ヶ月_要介護4_下段());
        item.setListShukei3_7(entity.get更新24ヶ月_要介護5_下段());
        item.setListShukei3_8(entity.get更新24ヶ月_計_下段());
        item.setListShukei4_1(entity.get区分変更24ヶ月_要支援1_下段());
        item.setListShukei4_2(entity.get区分変更24ヶ月_要支援2_下段());
        item.setListShukei4_3(entity.get区分変更24ヶ月_要介護1_下段());
        item.setListShukei4_4(entity.get区分変更24ヶ月_要介護2_下段());
        item.setListShukei4_5(entity.get区分変更24ヶ月_要介護3_下段());
        item.setListShukei4_6(entity.get区分変更24ヶ月_要介護4_下段());
        item.setListShukei4_7(entity.get区分変更24ヶ月_要介護5_下段());
        item.setListShukei4_8(entity.get区分変更24ヶ月_計_下段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set上段その他(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体その他_要支援1_上段());
        item.setListShukei1_2(entity.get全体その他_要支援2_上段());
        item.setListShukei1_3(entity.get全体その他_要介護1_上段());
        item.setListShukei1_4(entity.get全体その他_要介護2_上段());
        item.setListShukei1_5(entity.get全体その他_要介護3_上段());
        item.setListShukei1_6(entity.get全体その他_要介護4_上段());
        item.setListShukei1_7(entity.get全体その他_要介護5_上段());
        item.setListShukei1_8(entity.get全体その他_計_上段());
        item.setListShukei2_1(entity.get新規その他_要支援1_上段());
        item.setListShukei2_2(entity.get新規その他_要支援2_上段());
        item.setListShukei2_3(entity.get新規その他_要介護1_上段());
        item.setListShukei2_4(entity.get新規その他_要介護2_上段());
        item.setListShukei2_5(entity.get新規その他_要介護3_上段());
        item.setListShukei2_6(entity.get新規その他_要介護4_上段());
        item.setListShukei2_7(entity.get新規その他_要介護5_上段());
        item.setListShukei2_8(entity.get新規その他_計_上段());
        item.setListShukei3_1(entity.get更新その他_要支援1_上段());
        item.setListShukei3_2(entity.get更新その他_要支援2_上段());
        item.setListShukei3_3(entity.get更新その他_要介護1_上段());
        item.setListShukei3_4(entity.get更新その他_要介護2_上段());
        item.setListShukei3_5(entity.get更新その他_要介護3_上段());
        item.setListShukei3_6(entity.get更新その他_要介護4_上段());
        item.setListShukei3_7(entity.get更新その他_要介護5_上段());
        item.setListShukei3_8(entity.get更新その他_計_上段());
        item.setListShukei4_1(entity.get区分変更その他_要支援1_上段());
        item.setListShukei4_2(entity.get区分変更その他_要支援2_上段());
        item.setListShukei4_3(entity.get区分変更その他_要介護1_上段());
        item.setListShukei4_4(entity.get区分変更その他_要介護2_上段());
        item.setListShukei4_5(entity.get区分変更その他_要介護3_上段());
        item.setListShukei4_6(entity.get区分変更その他_要介護4_上段());
        item.setListShukei4_7(entity.get区分変更その他_要介護5_上段());
        item.setListShukei4_8(entity.get区分変更その他_計_上段());
        return item;
    }

    private ShinsakaiShukeiGenzainojokyo set下段その他(ShinsakaiShukeiGenzainojokyoEntity entity) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(entity.get全体その他_要支援1_下段());
        item.setListShukei1_2(entity.get全体その他_要支援2_下段());
        item.setListShukei1_3(entity.get全体その他_要介護1_下段());
        item.setListShukei1_4(entity.get全体その他_要介護2_下段());
        item.setListShukei1_5(entity.get全体その他_要介護3_下段());
        item.setListShukei1_6(entity.get全体その他_要介護4_下段());
        item.setListShukei1_7(entity.get全体その他_要介護5_下段());
        item.setListShukei1_8(entity.get全体その他_計_下段());
        item.setListShukei2_1(entity.get新規その他_要支援1_下段());
        item.setListShukei2_2(entity.get新規その他_要支援2_下段());
        item.setListShukei2_3(entity.get新規その他_要介護1_下段());
        item.setListShukei2_4(entity.get新規その他_要介護2_下段());
        item.setListShukei2_5(entity.get新規その他_要介護3_下段());
        item.setListShukei2_6(entity.get新規その他_要介護4_下段());
        item.setListShukei2_7(entity.get新規その他_要介護5_下段());
        item.setListShukei2_8(entity.get新規その他_計_下段());
        item.setListShukei3_1(entity.get更新その他_要支援1_下段());
        item.setListShukei3_2(entity.get更新その他_要支援2_下段());
        item.setListShukei3_3(entity.get更新その他_要介護1_下段());
        item.setListShukei3_4(entity.get更新その他_要介護2_下段());
        item.setListShukei3_5(entity.get更新その他_要介護3_下段());
        item.setListShukei3_6(entity.get更新その他_要介護4_下段());
        item.setListShukei3_7(entity.get更新その他_要介護5_下段());
        item.setListShukei3_8(entity.get更新その他_計_下段());
        item.setListShukei4_1(entity.get区分変更その他_要支援1_下段());
        item.setListShukei4_2(entity.get区分変更その他_要支援2_下段());
        item.setListShukei4_3(entity.get区分変更その他_要介護1_下段());
        item.setListShukei4_4(entity.get区分変更その他_要介護2_下段());
        item.setListShukei4_5(entity.get区分変更その他_要介護3_下段());
        item.setListShukei4_6(entity.get区分変更その他_要介護4_下段());
        item.setListShukei4_7(entity.get区分変更その他_要介護5_下段());
        item.setListShukei4_8(entity.get区分変更その他_計_下段());
        return item;
    }
}
