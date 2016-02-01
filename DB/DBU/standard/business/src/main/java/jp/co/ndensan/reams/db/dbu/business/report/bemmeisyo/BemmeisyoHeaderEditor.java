/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明書ヘッダEditorです。
 */
class BemmeisyoHeaderEditor implements BemmeisyoEditor {

    private final BemmeisyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link BemmeisyoItem}
     */
    protected BemmeisyoHeaderEditor(BemmeisyoHeadItem item) {
        this.item = item;
    }

    @Override
    public BemmeisyoReportSource edit(BemmeisyoReportSource source) {
        return editHeader(source);
    }

    private BemmeisyoReportSource editHeader(BemmeisyoReportSource source) {

        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        // TODO 袁献輝　QA597、resファイルに認証者氏名がありません　2016/02/20。
//        source.ninshoshaShimei = item.getNinshoshaShimei();
        source.denshiKoin = item.getDenshiKoin();
        source.koinShoryaku = item.getKoinShoryaku();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.sofusakiYubinNo = item.getSofusakiYubinNo();
        source.sofusakiJusho = item.getSofusakiJusho();
        source.sofusakiName = item.getSofusakiName();
        source.midashi = item.getMidashi();
        source.bemmeisyoSakuseiYMD = item.getBemmeisyoSakuseiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.bemmeisyoName = item.getBemmeisyoName();
        source.bemmeiNaiyo = item.getBemmeiNaiyo();
        source.hihokenshaNo = new RString(item.getHihokenshaNo().toString());
        source.hihokenshaName = new RString(item.getHihokenshaName().toString());
        source.birthYMD = new FlexibleDate(item.getBirthYMD().toString()).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        source.seibetsu = new RString(item.getSeibetsu().toString());
        source.hihokenshaYubinNo = new RString(item.getHihokenshaYubinNo().toString());
        source.hihokenshaJusho = item.getHihokenshaJusho();
        return source;
    }
}
