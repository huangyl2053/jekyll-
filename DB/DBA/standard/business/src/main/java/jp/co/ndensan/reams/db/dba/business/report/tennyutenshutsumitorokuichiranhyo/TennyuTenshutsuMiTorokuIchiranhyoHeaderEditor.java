/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 転入転出未登録一覧表ヘッダEditorです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
class TennyuTenshutsuMiTorokuIchiranhyoHeaderEditor implements ITennyuTenshutsuMiTorokuIchiranhyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final TennyuTenshutsuMiTorokuIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link TennyuTenshutsuMiTorokuIchiranhyoHeadItem}
     */
    protected TennyuTenshutsuMiTorokuIchiranhyoHeaderEditor(TennyuTenshutsuMiTorokuIchiranhyoHeadItem item) {
        this.item = item;
    }

    /**
     * 転入転出未登録一覧表editです。
     *
     * @param reportSourceWriter 転入転出未登録一覧表Source
     */
    @Override
    public TennyuTenshutsuMitorokuIchiranhyoReportSource edit(TennyuTenshutsuMitorokuIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private TennyuTenshutsuMitorokuIchiranhyoReportSource editHeader(TennyuTenshutsuMitorokuIchiranhyoReportSource source) {
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
        source.printTimeStamp = printTimeStamp.toRString();
        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        return source;
    }
}
