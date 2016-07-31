/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額保険料計算（機能見直し）パラメータ作成のクラスです。
 *
 * @reamsid_L DBB-9040-030 cuilin
 */
public class NengakuFukaKonkyoFactory {

    /**
     * 年額賦課根拠作成メソッド
     *
     * @param 賦課基準日 FlexibleDate
     * @param 資格取得日 FlexibleDate
     * @param 資格喪失日 FlexibleDate
     * @param 月別保険料段階 TsukibetsuHokenryoDankai
     * @param ランク_4月 RString
     * @param ランク_5月 RString
     * @param ランク_6月 RString
     * @param ランク_7月 RString
     * @param ランク_8月 RString
     * @param ランク_9月 RString
     * @param ランク_10月 RString
     * @param ランク_11月 RString
     * @param ランク_12月 RString
     * @param ランク_1月 RString
     * @param ランク_2月 RString
     * @param ランク_3月 RString
     * @return 年額賦課根拠クラス NengakuFukaKonkyo
     */
    public NengakuFukaKonkyo createNengakuFukaKonkyo(FlexibleDate 賦課基準日,
            FlexibleDate 資格取得日,
            FlexibleDate 資格喪失日,
            TsukibetsuHokenryoDankai 月別保険料段階,
            RString ランク_4月,
            RString ランク_5月,
            RString ランク_6月,
            RString ランク_7月,
            RString ランク_8月,
            RString ランク_9月,
            RString ランク_10月,
            RString ランク_11月,
            RString ランク_12月,
            RString ランク_1月,
            RString ランク_2月,
            RString ランク_3月) {
        NengakuFukaKonkyo nengakuFukaKonkyo = new NengakuFukaKonkyo();

        nengakuFukaKonkyo.set賦課基準日(賦課基準日);
        nengakuFukaKonkyo.set資格取得日(資格取得日);
        nengakuFukaKonkyo.set資格喪失日(資格喪失日);
        nengakuFukaKonkyo.set月別保険料段階(月別保険料段階);
        nengakuFukaKonkyo.setランク_4月(ランク_4月);
        nengakuFukaKonkyo.setランク_5月(ランク_5月);
        nengakuFukaKonkyo.setランク_6月(ランク_6月);
        nengakuFukaKonkyo.setランク_7月(ランク_7月);
        nengakuFukaKonkyo.setランク_8月(ランク_8月);
        nengakuFukaKonkyo.setランク_9月(ランク_9月);
        nengakuFukaKonkyo.setランク_10月(ランク_10月);
        nengakuFukaKonkyo.setランク_11月(ランク_11月);
        nengakuFukaKonkyo.setランク_12月(ランク_12月);
        nengakuFukaKonkyo.setランク_1月(ランク_1月);
        nengakuFukaKonkyo.setランク_2月(ランク_2月);
        nengakuFukaKonkyo.setランク_3月(ランク_3月);
        return nengakuFukaKonkyo;
    }

    /**
     * 年額制御情報作成メソッド
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
