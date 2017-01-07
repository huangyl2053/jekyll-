/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

/**
 * 要介護認定個人進捗状況票ボディEditorです。
 *
 * @reamsid_L DBE-0200-040 zhangzhiming
 */
class KojinShinchokuJokyohyoBodyEditor implements IKojinShinchokuJokyohyoEditor {

    private final KojinShinchokuJokyohyoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link shuiBodyItem}
     */
    protected KojinShinchokuJokyohyoBodyEditor(KojinShinchokuJokyohyoBodyItem item) {
        this.item = item;
    }

    @Override
    public KojinShinchokuJokyohyoReportSource edit(KojinShinchokuJokyohyoReportSource source) {
        return editHeader(source);
    }

    private KojinShinchokuJokyohyoReportSource editHeader(KojinShinchokuJokyohyoReportSource source) {
        source.listJokyo_1 = item.getListJokyo_1();
        source.listJokyo_2 = item.getListJokyo_2();
        RStringBuilder listJokyo_3 = new RStringBuilder();
        RStringBuilder listJokyo_4 = new RStringBuilder();
        RStringBuilder listJokyo_5 = new RStringBuilder();
        if (RString.isNullOrEmpty(item.getListJokyo_3())) {
            source.listJokyo_3 = RString.EMPTY;
        } else {
            Wareki jokyo_3 = new RDate(item.getListJokyo_3().toString()).wareki();
            listJokyo_3.append(jokyo_3.eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            source.listJokyo_3 = listJokyo_3.toRString();
        }
        if (RString.isNullOrEmpty(item.getListJokyo_4())) {
            source.listJokyo_4 = RString.EMPTY;
        } else {
            Wareki jokyo_4 = new RDate(item.getListJokyo_4().toString()).wareki();
            listJokyo_4.append(jokyo_4.eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            source.listJokyo_4 = listJokyo_4.toRString();
        }
        if (RString.isNullOrEmpty(item.getListJokyo_5())) {
            source.listJokyo_5 = RString.EMPTY;
        } else {
            Wareki jokyo_5 = new RDate(item.getListJokyo_5().toString()).wareki();
            listJokyo_5.append(jokyo_5.eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            source.listJokyo_5 = listJokyo_5.toRString();
        }
        return source;
    }
}
