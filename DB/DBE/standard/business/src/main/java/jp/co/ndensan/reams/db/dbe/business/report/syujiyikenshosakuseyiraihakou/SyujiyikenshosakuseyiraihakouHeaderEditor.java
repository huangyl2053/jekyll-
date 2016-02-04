/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書作成依頼発行一覧表ヘッダEditorです。
 */
class SyujiyikenshosakuseyiraihakouHeaderEditor implements SyujiyikenshosakuseyiraihakouEditor {

    private final SyujiyikenshosakuseyiraihakouHeadItem item;

    private static final RString KANA = new RString("～");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SyujiyikenshosakuseyiraihakouHeadItem}
     */
    protected SyujiyikenshosakuseyiraihakouHeaderEditor(SyujiyikenshosakuseyiraihakouHeadItem item) {
        this.item = item;
    }

    @Override
    public IkenshoSakuseiIraiHakkoIchiranhyoReportSource edit(IkenshoSakuseiIraiHakkoIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private IkenshoSakuseiIraiHakkoIchiranhyoReportSource editHeader(IkenshoSakuseiIraiHakkoIchiranhyoReportSource source) {

        source.printTimeStamp = new RString("主治医意見書作成依頼発行一覧表");
        source.chushutsuKind = new RString("主治医意見書作成依頼日");

        if (item.getIraiHiFrom() == null && item.getIraiHiTo() == null) {
            source.chushutsuKind.isEmpty();
        }
        RStringBuilder iraiDateTime = new RStringBuilder();
        iraiDateTime.append(new RDate(item.getIraiHiFrom().toString()).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        iraiDateTime.append(new RDate(item.getIraiHiTo().toString()).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
        iryoKikanCodeBulider.append(item.getIraiHiFrom());
        iryoKikanCodeBulider.append(KANA);
        iryoKikanCodeBulider.append(item.getIraiHiTo());
        source.chushutsuKikan = iryoKikanCodeBulider.toRString();

        source.joken1 = new RString("主治医登録者のみ");
        if (item.getSyujiyiflag().equals(new RString("1"))) {
            source.joken2 = new RString("未印刷を出力する");
        }
        if (item.getSyujiyiflag().equals(new RString("2"))) {
            source.joken2 = new RString("印刷済を出力する");
        }
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();
        return source;
    }
}
