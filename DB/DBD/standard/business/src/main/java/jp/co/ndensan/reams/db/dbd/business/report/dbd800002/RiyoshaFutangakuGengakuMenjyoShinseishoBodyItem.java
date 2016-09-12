/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険利用者負担額減額・免除申請書情報です。
 *
 * @reamsid_L DBA-0540-691 suguangjun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem {

    private final RString ninshoshaYakushokuMei;
    private final RString title;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString hokenshaNo;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString hihokenshaTelNo;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param title タイトル
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana 被保険者フリガナ
     * @param hokenshaNo 保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 被保険者生年月日
     * @param seibetsu 被保険者性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param hihokenshaTelNo 電話番号
     */
    public RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem(RString ninshoshaYakushokuMei,
            RString title,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString hokenshaNo,
            RString hihokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString hihokenshaTelNo) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.title = title;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.hokenshaNo = hokenshaNo;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaTelNo = hihokenshaTelNo;
    }
}
