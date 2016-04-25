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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会集計表（現在の状況別）のEditorです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoEditor implements IShinsakaiShukeiGenzainojokyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ShinsakaiShukeiGenzainojokyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link ShinsakaiShukeiGenzainojokyoEntity}
     */
    protected ShinsakaiShukeiGenzainojokyoEditor(ShinsakaiShukeiGenzainojokyoEntity entity) {
        this.entity = entity;
    }

    @Override
    public ShinsakaiShukeiGenzainojokyoReportSource edit(ShinsakaiShukeiGenzainojokyoReportSource source) {
        return editSource(source);
    }

    private ShinsakaiShukeiGenzainojokyoReportSource editSource(ShinsakaiShukeiGenzainojokyoReportSource source) {
        source.title = entity.getタイトル();
        source.shichosonName = entity.get市町村名();
        if (!RString.isNullOrEmpty(entity.get有効基準年月日())) {
            source.yukoKijunYMD = new RDate(entity.get有効基準年月日().toString()).wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = RDateTime.now();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        List<ShinsakaiShukeiGenzainojokyo> 全体List = set全体List();
        for (ShinsakaiShukeiGenzainojokyo item : 全体List) {
            source.listShukei1_1 = item.getListShukei1_1();
            source.listShukei1_2 = item.getListShukei1_2();
            source.listShukei1_3 = item.getListShukei1_3();
            source.listShukei1_4 = item.getListShukei1_4();
            source.listShukei1_5 = item.getListShukei1_5();
            source.listShukei1_6 = item.getListShukei1_6();
            source.listShukei1_7 = item.getListShukei1_7();
            source.listShukei1_8 = item.getListShukei1_8();
        }
        List<ShinsakaiShukeiGenzainojokyo> 新規申請List = set新規申請List();
        for (ShinsakaiShukeiGenzainojokyo item : 新規申請List) {
            source.listShukei2_1 = item.getListShukei2_1();
            source.listShukei2_2 = item.getListShukei2_2();
            source.listShukei2_3 = item.getListShukei2_3();
            source.listShukei2_4 = item.getListShukei2_4();
            source.listShukei2_5 = item.getListShukei2_5();
            source.listShukei2_6 = item.getListShukei2_6();
            source.listShukei2_7 = item.getListShukei2_7();
            source.listShukei2_8 = item.getListShukei2_8();
        }

        List<ShinsakaiShukeiGenzainojokyo> 更新申請List = set更新申請List();
        for (ShinsakaiShukeiGenzainojokyo item : 更新申請List) {
            source.listShukei3_1 = item.getListShukei3_1();
            source.listShukei3_2 = item.getListShukei3_2();
            source.listShukei3_3 = item.getListShukei3_3();
            source.listShukei3_4 = item.getListShukei3_4();
            source.listShukei3_5 = item.getListShukei3_5();
            source.listShukei3_6 = item.getListShukei3_6();
            source.listShukei3_7 = item.getListShukei3_7();
            source.listShukei3_8 = item.getListShukei3_8();
        }

        List<ShinsakaiShukeiGenzainojokyo> 区分変更申請List = set区分変更申請List();
        for (ShinsakaiShukeiGenzainojokyo item : 区分変更申請List) {
            source.listShukei4_1 = item.getListShukei4_1();
            source.listShukei4_2 = item.getListShukei4_2();
            source.listShukei4_3 = item.getListShukei4_3();
            source.listShukei4_4 = item.getListShukei4_4();
            source.listShukei4_5 = item.getListShukei4_5();
            source.listShukei4_6 = item.getListShukei4_6();
            source.listShukei4_7 = item.getListShukei4_7();
            source.listShukei4_8 = item.getListShukei4_8();
        }
        List<ShinsakaiShukeiGenzainojokyo> 転入List = set転入List();
        for (ShinsakaiShukeiGenzainojokyo item : 転入List) {
            source.listShukei5_1 = item.getListShukei5_1();
            source.listShukei5_2 = item.getListShukei5_2();
            source.listShukei5_3 = item.getListShukei5_3();
            source.listShukei5_4 = item.getListShukei5_4();
            source.listShukei5_5 = item.getListShukei5_5();
            source.listShukei5_6 = item.getListShukei5_6();
            source.listShukei5_7 = item.getListShukei5_7();
            source.listShukei5_8 = item.getListShukei5_8();
        }
        return source;
    }

    private List<ShinsakaiShukeiGenzainojokyo> set転入List() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(setListShukei(entity.get転入合計_要支援1_上段(),
                entity.get転入合計_要支援2_上段(),
                entity.get転入合計_要介護1_上段(),
                entity.get転入合計_要介護2_上段(),
                entity.get転入合計_要介護3_上段(),
                entity.get転入合計_要介護4_上段(),
                entity.get転入合計_要介護5_上段(),
                entity.get転入合計_計_上段()));
        itemList.add(setListShukei(entity.get転入合計_要支援1_下段(),
                entity.get転入合計_要支援2_下段(),
                entity.get転入合計_要介護1_下段(),
                entity.get転入合計_要介護2_下段(),
                entity.get転入合計_要介護3_下段(),
                entity.get転入合計_要介護4_下段(),
                entity.get転入合計_要介護5_下段(),
                entity.get転入合計_計_下段()));
        itemList.add(setListShukei(entity.get転入6ヶ月_要支援1_上段(),
                entity.get転入6ヶ月_要支援2_上段(),
                entity.get転入6ヶ月_要介護1_上段(),
                entity.get転入6ヶ月_要介護2_上段(),
                entity.get転入6ヶ月_要介護3_上段(),
                entity.get転入6ヶ月_要介護4_上段(),
                entity.get転入6ヶ月_要介護5_上段(),
                entity.get転入6ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get転入6ヶ月_要支援1_下段(),
                entity.get転入6ヶ月_要支援2_下段(),
                entity.get転入6ヶ月_要介護1_下段(),
                entity.get転入6ヶ月_要介護2_下段(),
                entity.get転入6ヶ月_要介護3_下段(),
                entity.get転入6ヶ月_要介護4_下段(),
                entity.get転入6ヶ月_要介護5_下段(),
                entity.get転入6ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get転入その他_要支援1_上段(),
                entity.get転入その他_要支援2_上段(),
                entity.get転入その他_要介護1_上段(),
                entity.get転入その他_要介護2_上段(),
                entity.get転入その他_要介護3_上段(),
                entity.get転入その他_要介護4_上段(),
                entity.get転入その他_要介護5_上段(),
                entity.get転入その他_計_上段()));
        itemList.add(setListShukei(entity.get転入その他_要支援1_下段(),
                entity.get転入その他_要支援2_下段(),
                entity.get転入その他_要介護1_下段(),
                entity.get転入その他_要介護2_下段(),
                entity.get転入その他_要介護3_下段(),
                entity.get転入その他_要介護4_下段(),
                entity.get転入その他_要介護5_下段(),
                entity.get転入その他_計_下段()));
        return itemList;
    }

    private List<ShinsakaiShukeiGenzainojokyo> set区分変更申請List() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(setListShukei(entity.get区分変更合計_要支援1_上段(),
                entity.get区分変更合計_要支援2_上段(),
                entity.get区分変更合計_要介護1_上段(),
                entity.get区分変更合計_要介護2_上段(),
                entity.get区分変更合計_要介護3_上段(),
                entity.get区分変更合計_要介護4_上段(),
                entity.get区分変更合計_要介護5_上段(),
                entity.get区分変更合計_計_上段()));
        itemList.add(setListShukei(entity.get区分変更合計_要支援1_下段(),
                entity.get区分変更合計_要支援2_下段(),
                entity.get区分変更合計_要介護1_下段(),
                entity.get区分変更合計_要介護2_下段(),
                entity.get区分変更合計_要介護3_下段(),
                entity.get区分変更合計_要介護4_下段(),
                entity.get区分変更合計_要介護5_下段(),
                entity.get区分変更合計_計_下段()));
        itemList.add(setListShukei(entity.get区分変更6ヶ月_要支援1_上段(),
                entity.get区分変更6ヶ月_要支援2_上段(),
                entity.get区分変更6ヶ月_要介護1_上段(),
                entity.get区分変更6ヶ月_要介護2_上段(),
                entity.get区分変更6ヶ月_要介護3_上段(),
                entity.get区分変更6ヶ月_要介護4_上段(),
                entity.get区分変更6ヶ月_要介護5_上段(),
                entity.get区分変更6ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get区分変更6ヶ月_要支援1_下段(),
                entity.get区分変更6ヶ月_要支援2_下段(),
                entity.get区分変更6ヶ月_要介護1_下段(),
                entity.get区分変更6ヶ月_要介護2_下段(),
                entity.get区分変更6ヶ月_要介護3_下段(),
                entity.get区分変更6ヶ月_要介護4_下段(),
                entity.get区分変更6ヶ月_要介護5_下段(),
                entity.get区分変更6ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get区分変更12ヶ月_要支援1_上段(),
                entity.get区分変更12ヶ月_要支援2_上段(),
                entity.get区分変更12ヶ月_要介護1_上段(),
                entity.get区分変更12ヶ月_要介護2_上段(),
                entity.get区分変更12ヶ月_要介護3_上段(),
                entity.get区分変更12ヶ月_要介護4_上段(),
                entity.get区分変更12ヶ月_要介護5_上段(),
                entity.get区分変更12ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get区分変更12ヶ月_要支援1_下段(),
                entity.get区分変更12ヶ月_要支援2_下段(),
                entity.get区分変更12ヶ月_要介護1_下段(),
                entity.get区分変更12ヶ月_要介護2_下段(),
                entity.get区分変更12ヶ月_要介護3_下段(),
                entity.get区分変更12ヶ月_要介護4_下段(),
                entity.get区分変更12ヶ月_要介護5_下段(),
                entity.get区分変更12ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get区分変更24ヶ月_要支援1_上段(),
                entity.get区分変更24ヶ月_要支援2_上段(),
                entity.get区分変更24ヶ月_要介護1_上段(),
                entity.get区分変更24ヶ月_要介護2_上段(),
                entity.get区分変更24ヶ月_要介護3_上段(),
                entity.get区分変更24ヶ月_要介護4_上段(),
                entity.get区分変更24ヶ月_要介護5_上段(),
                entity.get区分変更24ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get区分変更24ヶ月_要支援1_下段(),
                entity.get区分変更24ヶ月_要支援2_下段(),
                entity.get区分変更24ヶ月_要介護1_下段(),
                entity.get区分変更24ヶ月_要介護2_下段(),
                entity.get区分変更24ヶ月_要介護3_下段(),
                entity.get区分変更24ヶ月_要介護4_下段(),
                entity.get区分変更24ヶ月_要介護5_下段(),
                entity.get区分変更24ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get区分変更その他_要支援1_上段(),
                entity.get区分変更その他_要支援2_上段(),
                entity.get区分変更その他_要介護1_上段(),
                entity.get区分変更その他_要介護2_上段(),
                entity.get区分変更その他_要介護3_上段(),
                entity.get区分変更その他_要介護4_上段(),
                entity.get区分変更その他_要介護5_上段(),
                entity.get区分変更その他_計_上段()));
        itemList.add(setListShukei(entity.get区分変更その他_要支援1_下段(),
                entity.get区分変更その他_要支援2_下段(),
                entity.get区分変更その他_要介護1_下段(),
                entity.get区分変更その他_要介護2_下段(),
                entity.get区分変更その他_要介護3_下段(),
                entity.get区分変更その他_要介護4_下段(),
                entity.get区分変更その他_要介護5_下段(),
                entity.get区分変更その他_計_下段()));
        return itemList;
    }

    private List<ShinsakaiShukeiGenzainojokyo> set更新申請List() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(setListShukei(entity.get更新合計_要支援1_上段(),
                entity.get更新合計_要支援2_上段(),
                entity.get更新合計_要介護1_上段(),
                entity.get更新合計_要介護2_上段(),
                entity.get更新合計_要介護3_上段(),
                entity.get更新合計_要介護4_上段(),
                entity.get更新合計_要介護5_上段(),
                entity.get更新合計_計_上段()));
        itemList.add(setListShukei(entity.get更新合計_要支援1_下段(),
                entity.get更新合計_要支援2_下段(),
                entity.get更新合計_要介護1_下段(),
                entity.get更新合計_要介護2_下段(),
                entity.get更新合計_要介護3_下段(),
                entity.get更新合計_要介護4_下段(),
                entity.get更新合計_要介護5_下段(),
                entity.get更新合計_計_下段()));
        itemList.add(setListShukei(entity.get更新6ヶ月_要支援1_上段(),
                entity.get更新6ヶ月_要支援2_上段(),
                entity.get更新6ヶ月_要介護1_上段(),
                entity.get更新6ヶ月_要介護2_上段(),
                entity.get更新6ヶ月_要介護3_上段(),
                entity.get更新6ヶ月_要介護4_上段(),
                entity.get更新6ヶ月_要介護5_上段(),
                entity.get更新6ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get更新6ヶ月_要支援1_下段(),
                entity.get更新6ヶ月_要支援2_下段(),
                entity.get更新6ヶ月_要介護1_下段(),
                entity.get更新6ヶ月_要介護2_下段(),
                entity.get更新6ヶ月_要介護3_下段(),
                entity.get更新6ヶ月_要介護4_下段(),
                entity.get更新6ヶ月_要介護5_下段(),
                entity.get更新6ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get更新12ヶ月_要支援1_上段(),
                entity.get更新12ヶ月_要支援2_上段(),
                entity.get更新12ヶ月_要介護1_上段(),
                entity.get更新12ヶ月_要介護2_上段(),
                entity.get更新12ヶ月_要介護3_上段(),
                entity.get更新12ヶ月_要介護4_上段(),
                entity.get更新12ヶ月_要介護5_上段(),
                entity.get更新12ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get更新12ヶ月_要支援1_下段(),
                entity.get更新12ヶ月_要支援2_下段(),
                entity.get更新12ヶ月_要介護1_下段(),
                entity.get更新12ヶ月_要介護2_下段(),
                entity.get更新12ヶ月_要介護3_下段(),
                entity.get更新12ヶ月_要介護4_下段(),
                entity.get更新12ヶ月_要介護5_下段(),
                entity.get更新12ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get更新24ヶ月_要支援1_上段(),
                entity.get更新24ヶ月_要支援2_上段(),
                entity.get更新24ヶ月_要介護1_上段(),
                entity.get更新24ヶ月_要介護2_上段(),
                entity.get更新24ヶ月_要介護3_上段(),
                entity.get更新24ヶ月_要介護4_上段(),
                entity.get更新24ヶ月_要介護5_上段(),
                entity.get更新24ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get更新24ヶ月_要支援1_下段(),
                entity.get更新24ヶ月_要支援2_下段(),
                entity.get更新24ヶ月_要介護1_下段(),
                entity.get更新24ヶ月_要介護2_下段(),
                entity.get更新24ヶ月_要介護3_下段(),
                entity.get更新24ヶ月_要介護4_下段(),
                entity.get更新24ヶ月_要介護5_下段(),
                entity.get更新24ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get更新その他_要支援1_上段(),
                entity.get更新その他_要支援2_上段(),
                entity.get更新その他_要介護1_上段(),
                entity.get更新その他_要介護2_上段(),
                entity.get更新その他_要介護3_上段(),
                entity.get更新その他_要介護4_上段(),
                entity.get更新その他_要介護5_上段(),
                entity.get更新その他_計_上段()));
        itemList.add(setListShukei(entity.get更新その他_要支援1_下段(),
                entity.get更新その他_要支援2_下段(),
                entity.get更新その他_要介護1_下段(),
                entity.get更新その他_要介護2_下段(),
                entity.get更新その他_要介護3_下段(),
                entity.get更新その他_要介護4_下段(),
                entity.get更新その他_要介護5_下段(),
                entity.get更新その他_計_下段()));
        return itemList;
    }

    private List<ShinsakaiShukeiGenzainojokyo> set新規申請List() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(setListShukei(entity.get新規合計_要支援1_上段(),
                entity.get新規合計_要支援2_上段(),
                entity.get新規合計_要介護1_上段(),
                entity.get新規合計_要介護2_上段(),
                entity.get新規合計_要介護3_上段(),
                entity.get新規合計_要介護4_上段(),
                entity.get新規合計_要介護5_上段(),
                entity.get新規合計_計_上段()));
        itemList.add(setListShukei(entity.get新規合計_要支援1_下段(),
                entity.get新規合計_要支援2_下段(),
                entity.get新規合計_要介護1_下段(),
                entity.get新規合計_要介護2_下段(),
                entity.get新規合計_要介護3_下段(),
                entity.get新規合計_要介護4_下段(),
                entity.get新規合計_要介護5_下段(),
                entity.get新規合計_計_下段()));
        itemList.add(setListShukei(entity.get新規6ヶ月_要支援1_上段(),
                entity.get新規6ヶ月_要支援2_上段(),
                entity.get新規6ヶ月_要介護1_上段(),
                entity.get新規6ヶ月_要介護2_上段(),
                entity.get新規6ヶ月_要介護3_上段(),
                entity.get新規6ヶ月_要介護4_上段(),
                entity.get新規6ヶ月_要介護5_上段(),
                entity.get新規6ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get新規6ヶ月_要支援1_下段(),
                entity.get新規6ヶ月_要支援2_下段(),
                entity.get新規6ヶ月_要介護1_下段(),
                entity.get新規6ヶ月_要介護2_下段(),
                entity.get新規6ヶ月_要介護3_下段(),
                entity.get新規6ヶ月_要介護4_下段(),
                entity.get新規6ヶ月_要介護5_下段(),
                entity.get新規6ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get新規12ヶ月_要支援1_上段(),
                entity.get新規12ヶ月_要支援2_上段(),
                entity.get新規12ヶ月_要介護1_上段(),
                entity.get新規12ヶ月_要介護2_上段(),
                entity.get新規12ヶ月_要介護3_上段(),
                entity.get新規12ヶ月_要介護4_上段(),
                entity.get新規12ヶ月_要介護5_上段(),
                entity.get新規12ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get新規12ヶ月_要支援1_下段(),
                entity.get新規12ヶ月_要支援2_下段(),
                entity.get新規12ヶ月_要介護1_下段(),
                entity.get新規12ヶ月_要介護2_下段(),
                entity.get新規12ヶ月_要介護3_下段(),
                entity.get新規12ヶ月_要介護4_下段(),
                entity.get新規12ヶ月_要介護5_下段(),
                entity.get新規12ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get新規24ヶ月_要支援1_上段(),
                entity.get新規24ヶ月_要支援2_上段(),
                entity.get新規24ヶ月_要介護1_上段(),
                entity.get新規24ヶ月_要介護2_上段(),
                entity.get新規24ヶ月_要介護3_上段(),
                entity.get新規24ヶ月_要介護4_上段(),
                entity.get新規24ヶ月_要介護5_上段(),
                entity.get新規24ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get新規24ヶ月_要支援1_下段(),
                entity.get新規24ヶ月_要支援2_下段(),
                entity.get新規24ヶ月_要介護1_下段(),
                entity.get新規24ヶ月_要介護2_下段(),
                entity.get新規24ヶ月_要介護3_下段(),
                entity.get新規24ヶ月_要介護4_下段(),
                entity.get新規24ヶ月_要介護5_下段(),
                entity.get新規24ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get新規その他_要支援1_上段(),
                entity.get新規その他_要支援2_上段(),
                entity.get新規その他_要介護1_上段(),
                entity.get新規その他_要介護2_上段(),
                entity.get新規その他_要介護3_上段(),
                entity.get新規その他_要介護4_上段(),
                entity.get新規その他_要介護5_上段(),
                entity.get新規その他_計_上段()));
        itemList.add(setListShukei(entity.get新規その他_要支援1_下段(),
                entity.get新規その他_要支援2_下段(),
                entity.get新規その他_要介護1_下段(),
                entity.get新規その他_要介護2_下段(),
                entity.get新規その他_要介護3_下段(),
                entity.get新規その他_要介護4_下段(),
                entity.get新規その他_要介護5_下段(),
                entity.get新規その他_計_下段()));
        return itemList;
    }

    private List<ShinsakaiShukeiGenzainojokyo> set全体List() {
        List<ShinsakaiShukeiGenzainojokyo> itemList = new ArrayList<>();
        itemList.add(setListShukei(entity.get全体合計_要支援1_上段(),
                entity.get全体合計_要支援2_上段(),
                entity.get全体合計_要介護1_上段(),
                entity.get全体合計_要介護2_上段(),
                entity.get全体合計_要介護3_上段(),
                entity.get全体合計_要介護4_上段(),
                entity.get全体合計_要介護5_上段(),
                entity.get全体合計_計_上段()));
        itemList.add(setListShukei(entity.get全体合計_要支援1_下段(),
                entity.get全体合計_要支援2_下段(),
                entity.get全体合計_要介護1_下段(),
                entity.get全体合計_要介護2_下段(),
                entity.get全体合計_要介護3_下段(),
                entity.get全体合計_要介護4_下段(),
                entity.get全体合計_要介護5_下段(),
                entity.get全体合計_計_下段()));
        itemList.add(setListShukei(entity.get全体6ヶ月_要支援1_上段(),
                entity.get全体6ヶ月_要支援2_上段(),
                entity.get全体6ヶ月_要介護1_上段(),
                entity.get全体6ヶ月_要介護2_上段(),
                entity.get全体6ヶ月_要介護3_上段(),
                entity.get全体6ヶ月_要介護4_上段(),
                entity.get全体6ヶ月_要介護5_上段(),
                entity.get全体6ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get全体6ヶ月_要支援1_下段(),
                entity.get全体6ヶ月_要支援2_下段(),
                entity.get全体6ヶ月_要介護1_下段(),
                entity.get全体6ヶ月_要介護2_下段(),
                entity.get全体6ヶ月_要介護3_下段(),
                entity.get全体6ヶ月_要介護4_下段(),
                entity.get全体6ヶ月_要介護5_下段(),
                entity.get全体6ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get全体12ヶ月_要支援1_上段(),
                entity.get全体12ヶ月_要支援2_上段(),
                entity.get全体12ヶ月_要介護1_上段(),
                entity.get全体12ヶ月_要介護2_上段(),
                entity.get全体12ヶ月_要介護3_上段(),
                entity.get全体12ヶ月_要介護4_上段(),
                entity.get全体12ヶ月_要介護5_上段(),
                entity.get全体12ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get全体12ヶ月_要支援1_下段(),
                entity.get全体12ヶ月_要支援2_下段(),
                entity.get全体12ヶ月_要介護1_下段(),
                entity.get全体12ヶ月_要介護2_下段(),
                entity.get全体12ヶ月_要介護3_下段(),
                entity.get全体12ヶ月_要介護4_下段(),
                entity.get全体12ヶ月_要介護5_下段(),
                entity.get全体12ヶ月_計_下段()));
        itemList.add(setListShukei(entity.get全体24ヶ月_要支援1_上段(),
                entity.get全体24ヶ月_要支援2_上段(),
                entity.get全体24ヶ月_要介護1_上段(),
                entity.get全体24ヶ月_要介護2_上段(),
                entity.get全体24ヶ月_要介護3_上段(),
                entity.get全体24ヶ月_要介護4_上段(),
                entity.get全体24ヶ月_要介護5_上段(),
                entity.get全体24ヶ月_計_上段()));
        itemList.add(setListShukei(entity.get全体24ヶ月_要支援1_下段(),
                entity.get全体24ヶ月_要支援2_下段(),
                entity.get全体24ヶ月_要介護1_下段(),
                entity.get全体24ヶ月_要介護2_下段(),
                entity.get全体24ヶ月_要介護3_下段(),
                entity.get全体24ヶ月_要介護4_下段(),
                entity.get全体24ヶ月_要介護5_下段(),
                entity.get全体24ヶ月_計_下段()));

        itemList.add(setListShukei(entity.get全体その他_要支援1_上段(),
                entity.get全体その他_要支援2_上段(),
                entity.get全体その他_要介護1_上段(),
                entity.get全体その他_要介護2_上段(),
                entity.get全体その他_要介護3_上段(),
                entity.get全体その他_要介護4_上段(),
                entity.get全体その他_要介護5_上段(),
                entity.get全体その他_計_上段()));
        itemList.add(setListShukei(entity.get全体その他_要支援1_下段(),
                entity.get全体その他_要支援2_下段(),
                entity.get全体その他_要介護1_下段(),
                entity.get全体その他_要介護2_下段(),
                entity.get全体その他_要介護3_下段(),
                entity.get全体その他_要介護4_下段(),
                entity.get全体その他_要介護5_下段(),
                entity.get全体その他_計_下段()));
        return itemList;
    }

    private ShinsakaiShukeiGenzainojokyo setListShukei(
            RString 要支援1,
            RString 要支援2,
            RString 要介護1,
            RString 要介護2,
            RString 要介護3,
            RString 要介護4,
            RString 要介護5,
            RString 合計) {
        ShinsakaiShukeiGenzainojokyo item = new ShinsakaiShukeiGenzainojokyo();
        item.setListShukei1_1(要支援1);
        item.setListShukei1_2(要支援2);
        item.setListShukei1_3(要介護1);
        item.setListShukei1_4(要介護2);
        item.setListShukei1_5(要介護3);
        item.setListShukei1_6(要介護4);
        item.setListShukei1_7(要介護5);
        item.setListShukei1_8(合計);
        return item;
    }
}
