/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査督促対象者一覧表ヘッダEditorです。
 */
class NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor implements INinteiChosaTokusokuTaishoshaIchiranhyoEditor {

    private final NinteiChosaTokusokuTaishoshaIchiranhyoItem item;
    private static final RString タイトル = new RString("督促状発行対象者一覧");
    private static final int index_0 = 0;
    private static final int index_2 = 2;
    private static final int index_3 = 3;
    private static final int index_5 = 5;
    private static final int index_6 = 6;
    private static final int index_8 = 8;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokuTaishoshaIchiranhyoItem}
     */
    protected NinteiChosaTokusokuTaishoshaIchiranhyoHeaderEditor(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        this.item = item;
    }

    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource edit(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private NinteiChosaTokusokuTaishoshaIchiranhyoReportSource editHeader(NinteiChosaTokusokuTaishoshaIchiranhyoReportSource source) {

        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(index_0, index_2);
        RString min = new RString(time.toString()).substring(index_3, index_5);
        RString sec = new RString(time.toString()).substring(index_6, index_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");

        source.title = タイトル;
        source.cityCode = item.getCityCode();
        source.cityName = item.getCityName();
        source.printTimeStamp = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + RString.HALF_SPACE + timeFormat);
        source.kikanNameTitle = item.getKikanNameTitle();
        source.kikanJushoTitle = item.getKikanJushoTitle();
        source.nameTitle = item.getNameTitle();
        source.kikanTelTitle = item.getKikanTelTitle();
        return source;
    }
}
