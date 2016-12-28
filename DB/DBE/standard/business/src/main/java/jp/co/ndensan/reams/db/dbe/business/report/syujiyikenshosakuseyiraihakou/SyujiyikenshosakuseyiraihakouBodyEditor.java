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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書作成依頼発行一覧表ディEditorです。
 *
 * @reamsid_L DBE-0080-100 lizhuoxuan
 */
class SyujiyikenshosakuseyiraihakouBodyEditor implements ISyujiyikenshosakuseyiraihakouEditor {

    private final SyujiyikenshosakuseyiraihakouBodyItem item;
    private final RString renban;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SyujiyikenshosakuseyiraihakouItem}
     */
    protected SyujiyikenshosakuseyiraihakouBodyEditor(SyujiyikenshosakuseyiraihakouBodyItem item, RString renban) {
        this.item = item;
        this.renban = renban;
    }

    @Override
    public IkenshoSakuseiIraiHakkoIchiranhyoReportSource edit(IkenshoSakuseiIraiHakkoIchiranhyoReportSource source) {
        return editBody(source);
    }

    private IkenshoSakuseiIraiHakkoIchiranhyoReportSource editBody(IkenshoSakuseiIraiHakkoIchiranhyoReportSource source) {
        source.listHakkoIchiranhyo_1 = renban;
        source.listHakkoIchiranhyo_2 = item.getListHakkoIchiranhyo_2();
        source.listHakkoIchiranhyo_3 = item.getListHakkoIchiranhyo_3();
        if (!RString.isNullOrEmpty(item.getListHakkoIchiranhyo_4())) {
            source.listHakkoIchiranhyo_4 = new RDate(item.getListHakkoIchiranhyo_4().toString()).wareki().toDateString();
        }
        source.listHakkoIchiranhyo_5 = item.getListHakkoIchiranhyo_5();
        source.listHakkoIchiranhyo_6 = item.getListHakkoIchiranhyo_6();
        source.listHakkoIchiranhyo_7 = item.getListHakkoIchiranhyo_7();
        source.listHakkoIchiranhyo_8 = item.getListHakkoIchiranhyo_8();
        source.listHakkoIchiranhyo_9 = item.getListHakkoIchiranhyo_9();
        source.listHakkoIchiranhyo_10 = item.getListHakkoIchiranhyo_10();
        RStringBuilder iraiDateTime = new RStringBuilder();
        if (!RString.isNullOrEmpty(item.getListHakkoIchiranhyo_1_1())) {
            iraiDateTime.append(new RDate(item.getListHakkoIchiranhyo_1_1().toString()).wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
        }
        source.joken3 = iraiDateTime.toRString();
        RStringBuilder iraiDateTime1 = new RStringBuilder();
        if (!RString.isNullOrEmpty(item.getListHakkoIchiranhyo_1_2())) {
            iraiDateTime1.append(new RDate(item.getListHakkoIchiranhyo_1_2().toString()).wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
        }
        source.joken4 = iraiDateTime1.toRString();
        source.cityCode = item.getListHakkoIchiranhyo_1_5();
        source.cityName = item.getListHakkoIchiranhyo_1_4();
        return source;
    }
}
