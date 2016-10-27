/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.shinsahanteijokyo.ShinsaHanteiJokyoEntity;
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

    private final ShinsaHanteiJokyoEntity itemEntity;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param itemEntity {@link ShinsaHanteiJokyoEntity}
     */
    protected ShinsaHanteiJokyoEditorImpl(ShinsaHanteiJokyoEntity itemEntity) {
        this.itemEntity = itemEntity;
    }

    /**
     * 介護認定審査会判定状況表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShinsaHanteiJokyoReportSource edit(ShinsaHanteiJokyoReportSource source) {
        return editSource(source);
    }

    private ShinsaHanteiJokyoReportSource editSource(ShinsaHanteiJokyoReportSource source) {
        source.title = itemEntity.getTitle();
        source.gogitaiName = itemEntity.getGogitaiName();
        source.kaisaiKaishiYMD = RString.isNullOrEmpty(itemEntity.getKaisaiKaishiYMD())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(itemEntity.getKaisaiKaishiYMD()));
        source.kaisaiShuryoYMD = RString.isNullOrEmpty(itemEntity.getKaisaiShuryoYMD())
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(itemEntity.getKaisaiShuryoYMD()));
        source.kaisaiCount = itemEntity.getKaisaiCount();
        source.hokenshaNo = itemEntity.getHokenshaNo();
        source.printTimeStamp = getNowDate();
        source.hokenshaName = itemEntity.getHokenshaName();
        source.listHanteiHeader_1 = itemEntity.getListHanteiHeader_1();
        source.listHanteiHeader_2 = itemEntity.getListHanteiHeader_2();
        source.listHanteiHeader_3 = itemEntity.getListHanteiHeader_3();
        source.listHanteiHeader_4 = itemEntity.getListHanteiHeader_4();
        source.listHanteiHeader_5 = itemEntity.getListHanteiHeader_5();
        source.listHanteiHeader_6 = itemEntity.getListHanteiHeader_6();
        source.listHanteiHeader_7 = itemEntity.getListHanteiHeader_7();
        source.listHanteiHeader_8 = itemEntity.getListHanteiHeader_8();
        source.listHanteiHeader_9 = itemEntity.getListHanteiHeader_9();
        source.listHantei_1 = itemEntity.getListHantei_1();
        source.listHantei_2 = itemEntity.getListHantei_2();
        source.listHantei_3 = itemEntity.getListHantei_3();
        source.listHantei_4 = itemEntity.getListHantei_4();
        source.listHantei_5 = itemEntity.getListHantei_5();
        source.listHantei_6 = itemEntity.getListHantei_6();
        source.listHantei_7 = itemEntity.getListHantei_7();
        source.listHantei_8 = itemEntity.getListHantei_8();
        source.listHantei_9 = itemEntity.getListHantei_9();
        source.listHantei_10 = itemEntity.getListHantei_10();
        source.listHantei_11 = itemEntity.getListHantei_11();
        source.listHantei_12 = itemEntity.getListHantei_12();
        source.listHantei_13 = itemEntity.getListHantei_13();
        source.listHantei_14 = itemEntity.getListHantei_14();
        source.listHantei_15 = itemEntity.getListHantei_15();
        source.listHanteiKensu_1 = itemEntity.getListHanteiKensu_1();
        source.listHanteiKensu_2 = itemEntity.getListHanteiKensu_2();
        source.listHanteiKensu_3 = itemEntity.getListHanteiKensu_3();
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
