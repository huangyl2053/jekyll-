/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書作成依頼一覧Editorです。
 */
public class IkenshoSakuseiIraiIchiranhyoHeadEditor implements IkenshoSakuseiIraiIchiranhyoEditor {

    private final IkenshoSakuseiIraiIchiranhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoSakuseiIraiIchiranhyoHeadEditor}
     */
    protected IkenshoSakuseiIraiIchiranhyoHeadEditor(IkenshoSakuseiIraiIchiranhyoItem item) {
        this.item = item;
    }

    @Override
    public IkenshoSakuseiIraiIchiranhyoReportSource edit(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        return editSource(source);
    }

    private IkenshoSakuseiIraiIchiranhyoReportSource editSource(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
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
        source.yubinNo = item.getYubinNo();
        source.iryokikanJusho = item.getIryokikanJusho();
        source.iryokikanName = item.getIryokikanName();
        source.listIchiranhyo_1 = item.getNo();
        source.listIchiranhyo_2 = item.getShujiiName();
        source.listIchiranhyo_3 = item.getHihokenshaNo();
        source.listIchiranhyo_4 = item.getHihokenshaName();
        source.listIchiranhyo_5 = item.getHihokenshaNameKana();
        source.listIchiranhyo_6 = item.getJusho();
        RDate seinen = new RDate(item.getSeinengappiYMD().toString());
        source.listIchiranhyo_7 = seinen.wareki().toDateString();
        source.listIchiranhyo_8 = Seibetsu.toValue(item.getSeibetsu()).get名称();
        RDate iken = new RDate(item.getIkenshoSakuseiKigenYMD().toString());
        source.listIchiranhyo_9 = iken.wareki().toDateString();
        source.toiawasesaki = item.getToiawasesaki(); //TODO QA670
        source.denshiKoin = item.getDenshiKoin();
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.shuchoMei = item.getShuchoMei(); //TODO QA670
        source.shichosonMei = item.getShichosonMei();
        source.koinShoryaku = item.getKoinShoryaku();
        return source;
    }
}
