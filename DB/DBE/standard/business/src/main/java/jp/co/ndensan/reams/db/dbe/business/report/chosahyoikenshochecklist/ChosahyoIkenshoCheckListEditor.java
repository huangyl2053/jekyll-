/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 認定調査結果と主治医意見書のチェックリストのEditorです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
public class ChosahyoIkenshoCheckListEditor implements IChosahyoIkenshoCheckListEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ChosahyoIkenshoCheckListReportEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected ChosahyoIkenshoCheckListEditor(ChosahyoIkenshoCheckListReportEntity item) {
        this.item = item;
    }

    @Override
    public ChosahyoIkenshoCheckListReportSource edit(ChosahyoIkenshoCheckListReportSource source) {
        return editSource(source);
    }

    private ChosahyoIkenshoCheckListReportSource editSource(ChosahyoIkenshoCheckListReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.zenkaiIchijiHanteiKekka = item.getZenkaiIchijiHanteiKekka();
        source.konkaiIchijiHanteiKekka = item.getKonkaiIchijiHanteiKekka();
        source.shinsakaiKaisaiYMD = item.getShinsakaiKaisaiYMD();
        source.gogitaiNo = item.getGogitaiNo();
        source.zenkaiNijiHanteiKekka = item.getZenkaiNijiHanteiKekka();
        source.konkaiChosahyo1 = item.getKonkaiChosahyo1();
        source.konkaiIkensho1 = item.getKonkaiIkensho1();
        source.flag1 = item.getFlag1();
        source.konkaiChosahyo42 = item.getKonkaiChosahyo42();
        source.konkaiChosahyo2 = item.getKonkaiChosahyo2();
        source.konkaiIkensho2 = item.getKonkaiIkensho2();
        source.flag2 = item.getFlag2();
        source.konkaiChosahyo43 = item.getKonkaiChosahyo43();
        source.konkaiIkensho10 = item.getKonkaiIkensho10();
        source.flag10 = item.getFlag10();
        source.konkaiChosahyo3 = item.getKonkaiChosahyo3();
        source.konkaiIkensho3 = item.getKonkaiIkensho3();
        source.flag3 = item.getFlag3();
        source.konkaiChosahyo44 = item.getKonkaiChosahyo44();
        source.konkaiIkensho11 = item.getKonkaiIkensho11();
        source.konkaiChosahyo4 = item.getKonkaiChosahyo4();
        source.konkaiIkensho4 = item.getKonkaiIkensho4();
        source.flag4 = item.getFlag4();
        source.konkaiChosahyo45 = item.getKonkaiChosahyo45();
        source.flag11 = item.getFlag11();
        source.konkaiChosahyo5 = item.getKonkaiChosahyo5();
        source.konkaiIkensho5 = item.getKonkaiIkensho5();
        source.flag5 = item.getFlag5();
        source.konkaiChosahyo46 = item.getKonkaiChosahyo46();
        source.konkaiChosahyo6 = item.getKonkaiChosahyo6();
        source.konkaiChosahyo47 = item.getKonkaiChosahyo47();
        source.konkaiChosahyo7 = item.getKonkaiChosahyo7();
        source.konkaiChosahyo48 = item.getKonkaiChosahyo48();
        source.konkaiIkensho12 = item.getKonkaiIkensho12();
        source.flag12 = item.getFlag12();
        source.konkaiChosahyo8 = item.getKonkaiChosahyo8();
        source.konkaiChosahyo49 = item.getKonkaiChosahyo49();
        source.konkaiChosahyo9 = item.getKonkaiChosahyo9();
        source.konkaiChosahyo50 = item.getKonkaiChosahyo50();
        source.konkaiChosahyo10 = item.getKonkaiChosahyo10();
        source.konkaiChosahyo51 = item.getKonkaiChosahyo51();
        source.konkaiChosahyo11 = item.getKonkaiChosahyo11();
        source.konkaiChosahyo52 = item.getKonkaiChosahyo52();
        source.konkaiChosahyo12 = item.getKonkaiChosahyo12();
        source.konkaiChosahyo53 = item.getKonkaiChosahyo53();
        source.konkaiChosahyo13 = item.getKonkaiChosahyo13();
        source.konkaiChosahyo54 = item.getKonkaiChosahyo54();
        source.konkaiChosahyo14 = item.getKonkaiChosahyo14();
        source.konkaiChosahyo55 = item.getKonkaiChosahyo55();
        source.konkaiChosahyo15 = item.getKonkaiChosahyo15();
        source.konkaiChosahyo56 = item.getKonkaiChosahyo56();
        source.konkaiChosahyo16 = item.getKonkaiChosahyo16();
        source.konkaiChosahyo17 = item.getKonkaiChosahyo17();
        source.konkaiChosahyo18 = item.getKonkaiChosahyo18();
        source.konkaiChosahyo57 = item.getKonkaiChosahyo57();
        source.konkaiChosahyo19 = item.getKonkaiChosahyo19();
        source.konkaiChosahyo58 = item.getKonkaiChosahyo58();
        source.konkaiChosahyo20 = item.getKonkaiChosahyo20();
        source.konkaiChosahyo59 = item.getKonkaiChosahyo59();
        source.konkaiChosahyo60 = item.getKonkaiChosahyo60();
        source.konkaiChosahyo61 = item.getKonkaiChosahyo61();
        source.konkaiChosahyo21 = item.getKonkaiChosahyo21();
        source.konkaiChosahyo62 = item.getKonkaiChosahyo62();
        source.konkaiChosahyo22 = item.getKonkaiChosahyo22();
        source.konkaiChosahyo23 = item.getKonkaiChosahyo23();
        source.konkaiIkensho6 = item.getKonkaiIkensho6();
        source.flag6 = item.getFlag6();
        source.konkaiChosahyo24 = item.getKonkaiChosahyo24();
        source.konkaiChosahyo63 = item.getKonkaiChosahyo63();
        source.konkaiIkensho13 = item.getKonkaiIkensho13();
        source.flag13 = item.getFlag13();
        source.konkaiChosahyo25 = item.getKonkaiChosahyo25();
        source.konkaiChosahyo64 = item.getKonkaiChosahyo64();
        source.konkaiIkensho14 = item.getKonkaiIkensho14();
        source.flag14 = item.getFlag14();
        source.konkaiChosahyo26 = item.getKonkaiChosahyo26();
        source.konkaiChosahyo65 = item.getKonkaiChosahyo65();
        source.konkaiIkensho15 = item.getKonkaiIkensho15();
        source.flag15 = item.getFlag15();
        source.konkaiChosahyo27 = item.getKonkaiChosahyo27();
        source.konkaiChosahyo66 = item.getKonkaiChosahyo66();
        source.konkaiIkensho16 = item.getKonkaiIkensho16();
        source.flag16 = item.getFlag16();
        source.konkaiChosahyo28 = item.getKonkaiChosahyo28();
        source.konkaiChosahyo67 = item.getKonkaiChosahyo67();
        source.konkaiIkensho17 = item.getKonkaiIkensho17();
        source.flag17 = item.getFlag17();
        source.konkaiChosahyo29 = item.getKonkaiChosahyo29();
        source.konkaiChosahyo68 = item.getKonkaiChosahyo68();
        source.konkaiIkensho18 = item.getKonkaiIkensho18();
        source.flag18 = item.getFlag18();
        source.konkaiChosahyo30 = item.getKonkaiChosahyo30();
        source.konkaiChosahyo69 = item.getKonkaiChosahyo69();
        source.konkaiIkensho19 = item.getKonkaiIkensho19();
        source.flag19 = item.getFlag19();
        source.konkaiChosahyo31 = item.getKonkaiChosahyo31();
        source.konkaiChosahyo70 = item.getKonkaiChosahyo70();
        source.konkaiIkensho20 = item.getKonkaiIkensho20();
        source.flag20 = item.getFlag20();
        source.konkaiChosahyo32 = item.getKonkaiChosahyo32();
        source.konkaiChosahyo71 = item.getKonkaiChosahyo71();
        source.konkaiIkensho21 = item.getKonkaiIkensho21();
        source.flag21 = item.getFlag21();
        source.konkaiChosahyo72 = item.getKonkaiChosahyo72();
        source.konkaiIkensho22 = item.getKonkaiIkensho22();
        source.flag22 = item.getFlag22();
        source.konkaiChosahyo73 = item.getKonkaiChosahyo73();
        source.konkaiIkensho23 = item.getKonkaiIkensho23();
        source.flag23 = item.getFlag23();
        source.konkaiChosahyo33 = item.getKonkaiChosahyo33();
        source.konkaiIkensho7 = item.getKonkaiIkensho7();
        source.flag7 = item.getFlag7();
        source.konkaiChosahyo74 = item.getKonkaiChosahyo74();
        source.konkaiIkensho24 = item.getKonkaiIkensho24();
        source.flag24 = item.getFlag24();
        source.konkaiChosahyo34 = item.getKonkaiChosahyo34();
        source.konkaiChosahyo35 = item.getKonkaiChosahyo35();
        source.konkaiChosahyo36 = item.getKonkaiChosahyo36();
        source.konkaiIkensho8 = item.getKonkaiIkensho8();
        source.flag8 = item.getFlag8();
        source.konkaiChosahyo75 = item.getKonkaiChosahyo75();
        source.konkaiIkensho25 = item.getKonkaiIkensho25();
        source.flag25 = item.getFlag25();
        source.konkaiChosahyo37 = item.getKonkaiChosahyo37();
        source.konkaiChosahyo76 = item.getKonkaiChosahyo76();
        source.konkaiIkensho26 = item.getKonkaiIkensho26();
        source.flag26 = item.getFlag26();
        source.konkaiChosahyo38 = item.getKonkaiChosahyo38();
        source.konkaiChosahyo39 = item.getKonkaiChosahyo39();
        source.konkaiChosahyo40 = item.getKonkaiChosahyo40();
        source.konkaiIkensho9 = item.getKonkaiIkensho9();
        source.flag9 = item.getFlag9();
        source.konkaiChosahyo41 = item.getKonkaiChosahyo41();
        RString 被保険者番号 = RString.EMPTY;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(source.hihokenshaNo)) {
            被保険者番号 = source.hihokenshaNo;
        }
        source.hihokenshaNoAcc = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), 被保険者番号);
        return source;
    }

    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
