/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険負担限度額認定申請書情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutangendogakuNinteiShinseishoBodyItem {

    private final RString shiseibun;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString hihokenshaTelNo;
    private final RString hihokenshaYubinNo;
    private final RString hihokenJusho;
    private final RString shisetsuYubinNo;
    private final RString shisetsuTelNo;
    private final RString shisetsuJusho;
    private final RString shisetsuMeisho;
    private final RString chuibun;
    private final RString ninshoshaYakushokuMei;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaYakushokuMei 認証者
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana 被保険者フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 被保険者生年月日
     * @param seibetsu 被保険者性別
     * @param hihokenshaYubinNo 郵便番号
     * @param hihokenJusho 住所
     * @param shisetsuYubinNo 入所（院）郵便番号
     * @param shisetsuTelNo 入所（院）電話番号
     * @param shisetsuJusho 入所（院）住所
     * @param shisetsuMeisho 入所（院）名称
     * @param hihokenshaTelNo 電話番号
     * @param shiseibun 申請文
     * @param chuibun 注意文
     */
    public FutangendogakuNinteiShinseishoBodyItem(
            RString shiseibun,
            RString hihokenshaNameKana,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString seibetsu,
            RString birthYMD,
            RString hihokenshaTelNo,
            RString hihokenshaYubinNo,
            RString hihokenJusho,
            RString shisetsuYubinNo,
            RString shisetsuTelNo,
            RString shisetsuJusho,
            RString shisetsuMeisho,
            RString chuibun,
            RString ninshoshaYakushokuMei
    ) {
        this.shiseibun = shiseibun;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.hihokenshaTelNo = hihokenshaTelNo;
        this.hihokenshaYubinNo = hihokenshaYubinNo;
        this.hihokenJusho = hihokenJusho;
        this.shisetsuYubinNo = shisetsuYubinNo;
        this.shisetsuTelNo = shisetsuTelNo;
        this.shisetsuJusho = shisetsuJusho;
        this.shisetsuMeisho = shisetsuMeisho;
        this.chuibun = chuibun;
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}
