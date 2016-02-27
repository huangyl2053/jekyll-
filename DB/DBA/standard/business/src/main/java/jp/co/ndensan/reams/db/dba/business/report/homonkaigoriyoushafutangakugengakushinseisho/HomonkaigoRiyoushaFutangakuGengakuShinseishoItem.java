/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.homonkaigoriyoushafutangakugengakushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 訪問介護利用者負担額減額申請書Entityリストです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HomonkaigoRiyoushaFutangakuGengakuShinseishoItem {

    private final RString hihokenshaNameKana;
    private final RString hokenshaNo;
    private final RString hihokenshaName;
    private final RString hihokenshaNo;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString hihokenshaYubinNo;
    private final RString hihokenshaTelNo;
    private final RString hihokenJusho;
    private final RString tsuchiBun;
    private final RString remban;
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNameKana フリガナ
     * @param hokenshaNo 保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param hihokenshaNo 被保険者番号
     * @param seibetsu 性別
     * @param birthYMD 生年月日
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenshaTelNo 電話番号
     * @param hihokenJusho 住所
     * @param tsuchiBun 通知文
     * @param remban 連番
     * @param ninshoshaYakushokuMei 認証者
     */
    public HomonkaigoRiyoushaFutangakuGengakuShinseishoItem(RString hihokenshaNameKana,
            RString hokenshaNo,
            RString hihokenshaName,
            RString hihokenshaNo,
            RString seibetsu,
            RString birthYMD,
            RString hihokenshaYubinNo,
            RString hihokenshaTelNo,
            RString hihokenJusho,
            RString tsuchiBun,
            RString remban,
            RString ninshoshaYakushokuMei) {
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaNo = hihokenshaNo;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenJusho = hihokenJusho;
        this.tsuchiBun = tsuchiBun;
        this.remban = remban;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
