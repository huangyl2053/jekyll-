/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会スケジュール表かがみのEditorです。
 */
public class ShinsaschedulekagamiEditorImpl implements IShinsaschedulekagamiEditor {

    private final ShinsaschedulekagamiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsaschedulekagamiItem}
     */
    protected ShinsaschedulekagamiEditorImpl(ShinsaschedulekagamiItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会スケジュール表かがみを編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ShinsaschedulekagamiReportSource edit(ShinsaschedulekagamiReportSource source) {
        return editSource(source);
    }

    private ShinsaschedulekagamiReportSource editSource(ShinsaschedulekagamiReportSource source) {
        source.hakkoYMD = item.getHakkoYMD() == null
                ? RString.EMPTY : new FlexibleDate(item.getHakkoYMD()).wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin = item.getDenshiKoin();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shoriMikomiKaishiYMD = item.getShoriMikomiKaishiYMD() == null
                ? RString.EMPTY : new FlexibleDate(item.getShoriMikomiKaishiYMD()).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
        source.shoriMikomiShuryoYMD = item.getShoriMikomiShuryoYMD() == null
                ? RString.EMPTY : new FlexibleDate(item.getShoriMikomiShuryoYMD()).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
        source.tsuchibun2 = item.getTsuchibun2();
        return source;
    }

}
