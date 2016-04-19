/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプCompNinshoshaEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompNinshoshaB5Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor {

    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです
     *
     * @param sourceBuilder sourceBuilder
     */
    public CompNinshoshaB5Editor(NinshoshaSource sourceBuilder) {
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource edit(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource source) {

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
