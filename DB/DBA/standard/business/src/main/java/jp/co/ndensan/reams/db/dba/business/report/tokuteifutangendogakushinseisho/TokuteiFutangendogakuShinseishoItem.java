/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険被保険者証交付申請書（第2号被保険者）です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiFutangendogakuShinseishoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString hokenshaNo;
    private final RString hihokenshaNo;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString hihokenshaTelNo;
    private final RString shisetsuYubinNo;
    private final RString shisetsuJusho;
    private final RString shisetsuMeisho;
    private final RString shisetsuTelNo;
    private final RString remban;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param hokenshaNo 保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param hihokenshaTelNo 電話番号
     * @param shisetsuYubinNo 施設郵便番号
     * @param shisetsuJusho 施設住所
     * @param shisetsuMeisho 施設名称
     * @param shisetsuTelNo 施設電話番号
     * @param remban 連番
     */
    public TokuteiFutangendogakuShinseishoItem(
            RString ninshoshaYakushokuMei,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString hokenshaNo,
            RString hihokenshaNo,
            RString birthYMD,
            RString seibetsu,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString hihokenshaTelNo,
            RString shisetsuYubinNo,
            RString shisetsuJusho,
            RString shisetsuMeisho,
            RString shisetsuTelNo,
            RString remban
    ) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.shisetsuYubinNo = shisetsuYubinNo;
        this.shisetsuJusho = shisetsuJusho;
        this.shisetsuMeisho = shisetsuMeisho;
        this.shisetsuTelNo = shisetsuTelNo;
        this.remban = remban;

    }
}
