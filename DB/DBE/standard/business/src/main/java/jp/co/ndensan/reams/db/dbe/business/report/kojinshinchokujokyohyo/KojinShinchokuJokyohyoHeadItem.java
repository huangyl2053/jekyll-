/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定個人進捗状況票ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinShinchokuJokyohyoHeadItem {

    private final RString hihokenshaNo;
    private final RString shinseiKubun;
    private final RString hihokenshaNameKana;
    private final RString shinseiYMD;
    private final RString seibetsu;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString age;
    private final RString yubinNo1;
    private final RString hihokenshaJusho;
    private final RString telNo1;
    private final RString shinseiRiyu;
    private final RString shinseishaName;
    private final RString shinseiDaikoJigyoshaName;
    private final RString shinseishaKankei;
    private final RString honninKankei;
    private final RString yubinNo2;
    private final RString shinseishaJusho;
    private final RString telNo2;
    private final RString shisetsuName;
    private final RString shisetsujusho;
    private final RString telNo3;

    /**
     * インスタンスを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shinseiKubun 申請区分
     * @param hihokenshaNameKana フリガナ
     * @param shinseiYMD 申請日
     * @param seibetsu 性別
     * @param hihokenshaName 被保険者氏名
     * @param birthYMD 生年月日
     * @param age 年齢
     * @param yubinNo1 郵便番号
     * @param hihokenshaJusho 現住所
     * @param telNo1 電話番号
     * @param shinseiRiyu 申請理由
     * @param shinseishaName 申請者氏名
     * @param shinseiDaikoJigyoshaName 申請代行事業者
     * @param shinseishaKankei 申請者との関係
     * @param honninKankei 本人との関係
     * @param yubinNo2 申請者郵便番号
     * @param shinseishaJusho 申請者住所
     * @param telNo2 電話番号
     * @param shisetsuName 入所施設名
     * @param shisetsujusho 入所施設所在地
     * @param telNo3 入所施設電話番号
     */
    public KojinShinchokuJokyohyoHeadItem(
            RString hihokenshaNo,
            RString shinseiKubun,
            RString hihokenshaNameKana,
            RString shinseiYMD,
            RString seibetsu,
            RString hihokenshaName,
            RString birthYMD,
            RString age,
            RString yubinNo1,
            RString hihokenshaJusho,
            RString telNo1,
            RString shinseiRiyu,
            RString shinseishaName,
            RString shinseiDaikoJigyoshaName,
            RString shinseishaKankei,
            RString honninKankei,
            RString yubinNo2,
            RString shinseishaJusho,
            RString telNo2,
            RString shisetsuName,
            RString shisetsujusho,
            RString telNo3) {

        this.hihokenshaNo = hihokenshaNo;
        this.shinseiKubun = shinseiKubun;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.shinseiYMD = shinseiYMD;
        this.seibetsu = seibetsu;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.age = age;
        this.yubinNo1 = yubinNo1;
        this.hihokenshaJusho = hihokenshaJusho;
        this.telNo1 = telNo1;
        this.shinseiRiyu = shinseiRiyu;
        this.shinseishaName = shinseishaName;
        this.shinseiDaikoJigyoshaName = shinseiDaikoJigyoshaName;
        this.shinseishaKankei = shinseishaKankei;
        this.honninKankei = honninKankei;
        this.yubinNo2 = yubinNo2;
        this.shinseishaJusho = shinseishaJusho;
        this.telNo2 = telNo2;
        this.shisetsuName = shisetsuName;
        this.shisetsujusho = shisetsujusho;
        this.telNo3 = telNo3;
    }
}
