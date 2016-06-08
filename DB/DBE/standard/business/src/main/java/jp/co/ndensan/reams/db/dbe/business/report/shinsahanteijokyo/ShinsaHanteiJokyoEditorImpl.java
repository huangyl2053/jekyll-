/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoEditorImpl implements IShinsaHanteiJokyoEditor {

    private final ShinsaHanteiJokyoItem item;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsaschedulekagamiItem}
     */
    protected ShinsaHanteiJokyoEditorImpl(ShinsaHanteiJokyoItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会スケジュール表かがみを編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShinsaHanteiJokyoReportSource edit(ShinsaHanteiJokyoReportSource source) {
        return editSource(source);
    }

    private ShinsaHanteiJokyoReportSource editSource(ShinsaHanteiJokyoReportSource source) {
        source.title = item.getTitle();
        source.gogitaiName = item.getGogitaiName();
        source.kaisaiKaishiYMD = RString.isNullOrEmpty(item.getKaisaiKaishiYMD())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getKaisaiKaishiYMD()));
        source.kaisaiShuryoYMD = RString.isNullOrEmpty(item.getKaisaiShuryoYMD())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(item.getKaisaiShuryoYMD()));
        source.kaisaiCount = item.getKaisaiCount();
        source.hokenshaNo = item.getHokenshaNo();
        source.printTimeStamp = getNowDate();
        source.hokenshaName = item.getHokenshaName();
        source.listHanteiHeader_1 = item.getListHanteiHeader_1();
        source.listHanteiHeader_2 = item.getListHanteiHeader_2();
        source.listHanteiHeader_3 = item.getListHanteiHeader_3();
        source.listHanteiHeader_4 = item.getListHanteiHeader_4();
        source.listHanteiHeader_5 = item.getListHanteiHeader_5();
        source.listHanteiHeader_6 = item.getListHanteiHeader_6();
        source.listHanteiHeader_7 = item.getListHanteiHeader_7();
        source.listHanteiHeader_8 = item.getListHanteiHeader_8();
        source.listHanteiHeader_9 = item.getListHanteiHeader_9();
        source.listHantei_1 = item.getListHantei_1();
        source.listHantei_2 = item.getListHantei_2();
        source.listHantei_3 = item.getListHantei_3();
        source.listHantei_4 = item.getListHantei_4();
        source.listHantei_5 = item.getListHantei_5();
        source.listHantei_6 = item.getListHantei_6();
        source.listHantei_7 = item.getListHantei_7();
        source.listHantei_8 = item.getListHantei_8();
        source.listHantei_9 = item.getListHantei_9();
        source.listHantei_10 = item.getListHantei_10();
        source.listHantei_11 = item.getListHantei_11();
        source.listHantei_12 = item.getListHantei_12();
        source.listHantei_13 = item.getListHantei_13();
        source.listHantei_14 = item.getListHantei_14();
        source.listHantei_15 = item.getListHantei_15();
        source.listHanteiKensu_1 = item.getListHanteiKensu_1();
        source.listHanteiKensu_2 = item.getListHanteiKensu_2();
        source.listHanteiKensu_3 = item.getListHanteiKensu_3();
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
    }

    private RString getNowDate() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(DATE_作成);
        return printTimeStamp.toRString();
    }
}
