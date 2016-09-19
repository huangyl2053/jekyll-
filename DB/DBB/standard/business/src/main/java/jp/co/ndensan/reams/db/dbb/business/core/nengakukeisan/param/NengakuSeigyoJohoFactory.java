/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額保険料計算（機能見直し）パラメータ年額制御情報作成のクラスです。
 *
 * @reamsid_L DBB-9040-030 cuilin
 */
public class NengakuSeigyoJohoFactory {

    /**
     * 年額制御情報作成メソッドです。
     *
     * @param 端数単位 Decimal
     * @param 端数調整方法 HasuChoseiHoho
     * @param 端数単位_ランク用 Decimal
     * @param 端数調整方法_ランク用 HasuChoseiHoho
     * @param 端数調整対象 HasuChoseiTaisho
     * @param ランク別制御情報 Map<RString, RankBetsuKijunKingaku>
     * @return 年額制御情報クラス NengakuSeigyoJoho
     */
    public NengakuSeigyoJoho createNengakuSeigyoJoho(Decimal 端数単位,
            HasuChoseiHoho 端数調整方法,
            Decimal 端数単位_ランク用,
            HasuChoseiHoho 端数調整方法_ランク用,
            HasuChoseiTaisho 端数調整対象,
            Map<RString, RankBetsuKijunKingaku> ランク別制御情報) {
        NengakuSeigyoJoho nengakuSeigyoJoho = new NengakuSeigyoJoho();

        nengakuSeigyoJoho.set端数単位(端数単位);
        nengakuSeigyoJoho.set端数調整方法(端数調整方法);
        nengakuSeigyoJoho.set端数単位_ランク用(端数単位_ランク用);
        nengakuSeigyoJoho.set端数調整方法_ランク用(端数調整方法_ランク用);
        nengakuSeigyoJoho.set端数調整対象(端数調整対象);
        nengakuSeigyoJoho.setランク別制御情報(ランク別制御情報);
        return nengakuSeigyoJoho;
    }
}
