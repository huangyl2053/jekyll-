/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年額保険料計算（機能見直し）パラメータ年額賦課根拠作成のクラスです。
 *
 * @reamsid_L DBB-9040-030 cuilin
 */
public class NengakuFukaKonkyoFactory {

    /**
     * 年額賦課根拠作成メソッドです。
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

}
