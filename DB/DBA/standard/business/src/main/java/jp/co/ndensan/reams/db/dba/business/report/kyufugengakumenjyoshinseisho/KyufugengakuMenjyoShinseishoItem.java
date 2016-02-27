/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufugengakumenjyoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 給付額減額免除申請書Itemです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugengakuMenjyoShinseishoItem {

    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaTelNo;
    private final RString hihokenJusho;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param seibetsu 性別
     * @param birthYMD 生年月日
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaTelNo 電話番号
     * @param hihokenJusho 住所
     * @param ninshoshaYakushokuMei 認証者
     */
    public KyufugengakuMenjyoShinseishoItem(RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString seibetsu,
            RString birthYMD,
            RString hihokenshaYubinNo,
            RString hihokenshaTelNo,
            RString hihokenJusho,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenJusho = hihokenJusho;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;

    }
}
