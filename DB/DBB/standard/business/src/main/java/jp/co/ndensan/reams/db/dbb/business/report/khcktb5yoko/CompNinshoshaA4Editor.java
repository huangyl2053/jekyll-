/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプCompNinshoshaEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompNinshoshaA4Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor {

    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです
     *
     * @param sourceBuilder sourceBuilder
     */
    public CompNinshoshaA4Editor(NinshoshaSource sourceBuilder) {
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource source) {

        source.hakkoYMD = sourceBuilder.hakkoYMD;
        source.denshiKoin = sourceBuilder.denshiKoin;
        source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
        source.koinMojiretsu = sourceBuilder.koinMojiretsu;
        source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
        source.koinShoryaku = sourceBuilder.koinShoryaku;
        return source;
    }
}
