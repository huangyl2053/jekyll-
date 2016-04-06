/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプCompNinshoshaEditor
 */
public class CompNinshoshaA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item;

    /**
     * コンストラクタです
     *
     * @param item KaigoHokenryoChoshuyuyoKetteiTsuchishoItem
     */
    public CompNinshoshaA4Editor(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        // QA:581
//        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
//        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        return source;
    }
}
