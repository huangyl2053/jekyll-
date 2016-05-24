/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会集計表（申請区分別）のEditorです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class ShinsakaishukeihyoShinseiEditor implements IShinsakaishukeihyoShinseiEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ShinsakaiShukeihyoShinsei item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsakaishukeihyoShinseiEditor(ShinsakaiShukeihyoShinsei item) {
        this.item = item;
    }

    @Override
    public ShinsakaiShukeihyoShinseiReportSource edit(ShinsakaiShukeihyoShinseiReportSource source) {
        return editSource(source);
    }

    private ShinsakaiShukeihyoShinseiReportSource editSource(ShinsakaiShukeihyoShinseiReportSource source) {
        source.title = item.getタイトル();
        RDateTime printdate = item.get発行日時();
        RStringBuilder printTimeStampSb = new RStringBuilder();
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
        source.printTimeStamp = printTimeStampSb.toRString();
        source.shichosonName = item.get市町村名称();
        source.chushutsuKikan = item.get抽出期間();
        return source;
    }
}
