/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険住所地特例適用・変更・終了届のEntityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyushochiTokureiTekiyoHenkoItem {
    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString seibetsu;

    /**
     * コンストラクタです。
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     */
    public JyushochiTokureiTekiyoHenkoItem(RString ninshoshaYakushokuMei,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString birthYMD,
            RString seibetsu) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
    }
}
