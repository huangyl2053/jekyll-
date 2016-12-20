/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiHateiJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiOutputPage1;
import jp.co.ndensan.reams.db.dbe.definition.core.dokuji.ShujiiOutputSort;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医医療機関・主治医一覧表ヘッダEditorです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
class IkenshoShujiiIchiranHeaderEditor implements IkenshoShujiiIchiranEditor {

    private final IkenshoShujiiIchiranHeadItem item;

    private static final RString KANA = new RString("～");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoShujiiIchiranItem}
     */
    protected IkenshoShujiiIchiranHeaderEditor(IkenshoShujiiIchiranHeadItem item) {
        this.item = item;
    }

    @Override
    public ShujiiIryokikanShujiiIchiranhyoReportSource edit(ShujiiIryokikanShujiiIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private ShujiiIryokikanShujiiIchiranhyoReportSource editHeader(ShujiiIryokikanShujiiIchiranhyoReportSource source) {

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

        source.title = new RString("介護保険 医療機関・主治医一覧表");
        RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
        iryoKikanCodeBulider.append(item.getIryoKikanCodeFrom());
        iryoKikanCodeBulider.append(KANA);
        iryoKikanCodeBulider.append(item.getIryoKikanCodeTo());
        source.iryoKikanCode = iryoKikanCodeBulider.toRString();

        RStringBuilder shujiiCodeBulider = new RStringBuilder();
        shujiiCodeBulider.append(item.getShujiiCodeFrom());
        shujiiCodeBulider.append(KANA);
        shujiiCodeBulider.append(item.getShujiiCodeTo());
        source.shujiiCode = shujiiCodeBulider.toRString();

        source.shujiiJokyo = ShujiiHateiJokyo.toValue(item.getShujiiJokyo()).get名称();
        source.dataShubetsu = new RString("医療機関マスタ");
        source.sort1 = ShujiiOutputSort.toValue(item.getSort()).getソート名称１();
        source.sort2 = ShujiiOutputSort.toValue(item.getSort()).getソート名称２();
        source.sort3 = RString.EMPTY;
        source.sort4 = RString.EMPTY;
        source.sort5 = RString.EMPTY;
        source.page1 = ShujiiOutputPage1.toValue(item.getPage()).get名称();
        source.page2 = RString.EMPTY;
        source.page3 = RString.EMPTY;
        source.page4 = RString.EMPTY;
        source.page5 = RString.EMPTY;
        return source;
    }
}
