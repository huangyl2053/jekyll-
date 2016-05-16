/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定審査判定結果（鑑）Editorです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiEditor implements IHanteikekkaKagamiEditor {

    private final HanteikekkaKagamiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteiKekkaIchiranEntity}
     */
    protected HanteikekkaKagamiEditor(HanteikekkaKagamiEntity item) {
        this.item = item;
    }

    @Override
    public HanteikekkaKagamiReportSource edit(HanteikekkaKagamiReportSource source) {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        if (item != null) {
            editCompNinshosha(source);
            // TODO QA
            source.title = new RString("介護認定審査判定結果（鑑）");
            source.shinsakaiKaisaiYMD = new RString(item.getShinsakaiKaisaiYMD().toString());
            source.gogitaiNo = new RString(item.getGogitaiNo());
            source.tsuchibun1 = item.getTsuchibun1();
            source.tsuchibun2 = item.getTsuchibun2();
        }
        return source;
    }

    private void editCompNinshosha(HanteikekkaKagamiReportSource source) {
        if (item != null && item.getNinshoshaSource() != null) {
            source.hakkoYMD1 = item.getNinshoshaSource().hakkoYMD;
            source.denshiKoin = item.getNinshoshaSource().denshiKoin;
            source.koinMojiretsu = item.getNinshoshaSource().koinMojiretsu;
            source.koinShoryaku = item.getNinshoshaSource().koinShoryaku;
            source.ninshoshaShimeiKakeru = item.getNinshoshaSource().ninshoshaShimeiKakeru;
            source.ninshoshaShimeiKakenai = item.getNinshoshaSource().ninshoshaShimeiKakenai;
            source.ninshoshaYakushokuMei = item.getNinshoshaSource().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = item.getNinshoshaSource().ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = item.getNinshoshaSource().ninshoshaYakushokuMei2;
        }
    }
}
