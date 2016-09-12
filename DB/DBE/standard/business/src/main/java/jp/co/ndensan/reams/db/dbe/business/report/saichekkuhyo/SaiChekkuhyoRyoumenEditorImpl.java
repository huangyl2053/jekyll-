/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定調査票差異チェック票のEditorです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenEditorImpl implements ISaiChekkuhyoRyoumenEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private final SaiChekkuhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SaiChekkuhyoItem}
     */
    protected SaiChekkuhyoRyoumenEditorImpl(SaiChekkuhyoItem item) {
        this.item = item;
    }

    /**
     * 帳票用データを編集します。
     *
     * @param source 要介護認定調査票差異チェック票のReportSource
     * @return SaiChekkuhyoReportSource
     */
    @Override
    public SaiChekkuhyoReportSource edit(SaiChekkuhyoReportSource source) {
        return editSource(source);
    }

    private SaiChekkuhyoReportSource editSource(SaiChekkuhyoReportSource source) {
        source.printTimeStamp = getNowDate();
        source.zenkaiIchijiHantei = item.getZenkaiIchijiHantei();
        source.hihokenshaKubun = item.getHihokenshaKubun();
        source.hokenshaName = item.getHokenshaName();
        source.age = item.getAge();
        source.zenkaiNijiHantei = item.getZenkaiNijiHantei();
        if (RString.isNullOrEmpty(item.getZenkaiNijihanteiYMD())) {
            source.zenkaiNijihanteiYMD = RString.EMPTY;
        } else {
            source.zenkaiNijihanteiYMD = new FlexibleDate(item.getZenkaiNijihanteiYMD())
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (RString.isNullOrEmpty(item.getSeinengappi())) {
            source.seinengappi = RString.EMPTY;
        } else {
            source.seinengappi = new FlexibleDate(item.getSeinengappi())
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        source.layout = Layouts.鑑;
        return source;
    }

    private RString getNowDate() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStamp.append(RString.FULL_SPACE);
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
