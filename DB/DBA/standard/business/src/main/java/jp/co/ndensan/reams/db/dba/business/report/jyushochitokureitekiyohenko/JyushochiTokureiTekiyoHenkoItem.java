/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険資格取得・異動・喪失届Entityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushutokuIdoSoshitsuItem {
    private final RString ninshoshaYakushokuMei;
    private final RString birthYMD1;
    private final RString hihokenJusho;
    private final RString hihokenKatakaki;
    private final RString hihokenshaName1;
    private final RString hihokenshaNameKana1;
    private final RString hihokenshaNo1;
    private final RString seibetsu1;
    private final RString setainushiName;
    private final RString zokugara1;

    /**
     * コンストラクタです。
     * @param ninshoshaYakushokuMei 認証者
     * @param birthYMD1 被保険者生年月日
     * @param hihokenJusho 被保険者住所
     * @param hihokenKatakaki 被保険者方書
     * @param hihokenshaName1 被保険者氏名
     * @param hihokenshaNameKana1 被保険者氏名カナ
     * @param hihokenshaNo1 被保険者番号
     * @param seibetsu1 性別
     * @param setainushiName 世帯主氏名
     * @param zokugara1 続柄
     */
    public ShikakushutokuIdoSoshitsuItem(RString ninshoshaYakushokuMei,
            RString birthYMD1,
            RString hihokenJusho,
            RString hihokenKatakaki,
            RString hihokenshaName1,
            RString hihokenshaNameKana1,
            RString hihokenshaNo1,
            RString seibetsu1,
            RString setainushiName,
            RString zokugara1) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.birthYMD1 = birthYMD1;
        this.hihokenJusho = hihokenJusho;
        this.hihokenKatakaki = hihokenKatakaki;
        this.hihokenshaName1 = hihokenshaName1;
        this.hihokenshaNameKana1 = hihokenshaNameKana1;
        this.hihokenshaNo1 = hihokenshaNo1;
        this.seibetsu1 = seibetsu1;
        this.setainushiName = setainushiName;
        this.zokugara1 = zokugara1;

    }
}
